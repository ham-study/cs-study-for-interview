## Spring Security
: 애플리케이션의 보안(인증과 권한, 인가 등)을 담당하는 스프링 하위 프레임워크

- **인증(Authentication)** : 해당 사용자가 본인이 맞는지를 확인하는 절차
- **인가(Authorize)** : 인증된 사용자가 요청한 자원에 접근 가능한지를 결정하는 절차

- **스프링 시큐리티의 특징 및 구조**
  - 보안과 관련하여 체계적으로 많은 옵션을 제공하여 편리하게 사용할 수 있음
  - Filter 기반으로 동작하여 MVC와 분리하여 관리 및 동작
  - 어노테이션을 통한 간단한 설정
  - Spring Security는 기본적으로 세션 & 쿠키방식으로 인증

- **Flow**
  - 인증관리자(Authentication Manager)와 접근 결정 관리자(Access Decision Manager)를 통해 사용자의 리소스 접근을 관리
  - 인증 관리자는 UsenamePasswordAuthenticationFilter, 접근 결정 관리자는 FilterSecurityInterceptor가 수행
  ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FRdJGx%2FbtqD9Ouzlub%2F5At2yq9zCxACpguIwWKHE1%2Fimg.png)

## Form 로그인에 대한 플로우
![img](https://www.bottlehs.com/assets/spring-security-authentication-architecture.png)
1. 사용자가 Form을 통해 로그인 정보를 입력하고 인증 요청을 보낸다.
2. AuthenticationFilter(사용할 구현체 UsernamePasswordAuthenticationFilter)가 HttpServletRequest에서 사용자가 보낸 아이디와 패스워드를 인터셉트한다. 프론트 단에서 유효성검사를 할 수도 있지만, 안전을 위해서 다시 한번 사용자가 보낸 아이디와 패스워드의 유효성 검사를 한다. HttpServletRequest에서 꺼내온 사용자 아이디와 패스워드를 진짜 인증을 담당할 AuthenticationManager 인터페이스(구현체 - ProviderManager)에게 인증용 객체(UsernamePasswordAuthenticationToken)로 만들어줘서 위임한다.
3. AuthenticationFilter에게 인증용 객체(UsernamePasswordAuthenticationToken)을 전달받는다. 
4. 실제 인증을 할 AuthenticationProvider에게 Authentication객체(UsernamePasswordAuthenticationToken)을 다시 전달한다. 
5. DB에서 사용자 인증 정보를 가져올 UserDetailsService 객체에게 사용자 아이디를 넘겨주고 DB에서 인증에 사용할 사용자 정보(사용자 아이디, 암호화된 패스워드, 권한 등)를 UserDetails(인증용 객체와 도메인 객체를 분리하지 않기 위해서 실제 사용되는 도메인 객체에 UserDetails를 상속하기도 한다.)라는 객체로 전달 받는다. 
6. AuthenticationProvider는 UserDetails 객체를 전달 받은 이후 실제 사용자의 입력정보와 UserDetails 객체를 가지고 인증을 시도한다. 
7. 인증이 완료되면 사용자 정보를 가진 Authentication 객체를 SecurityContextHolder에 담은 이후 AuthenticationSuccessHandle를 실행한다.(실패시 AuthenticationFailureHandler를 실행한다.)

## Filter
- SecurityContextPersistenceFilter : SecurityContextRepository에서 SecurityContext를 가져오거나 저장하는 역할을 한다. 
- LogoutFilter : 설정된 로그아웃 URL로 오는 요청을 감시하며, 해당 유저를 로그아웃 처리
- (UsernamePassword)AuthenticationFilter : (아이디와 비밀번호를 사용하는 form 기반 인증) 설정된 로그인 URL로 오는 요청을 감시하며, 유저 인증 처리 
  - AuthenticationManager를 통한 인증 실행 
  - 인증 성공 시, 얻은 Authentication 객체를 SecurityContext에 저장 후 AuthenticationSuccessHandler 실행 
  - 인증 실패 시, AuthenticationFailureHandler 실행 
- DefaultLoginPageGeneratingFilter : 인증을 위한 로그인폼 URL을 감시한다.
- BasicAuthenticationFilter : HTTP 기본 인증 헤더를 감시하여 처리한다. 
- RequestCacheAwareFilter : 로그인 성공 후, 원래 요청 정보를 재구성하기 위해 사용된다. 
- SecurityContextHolderAwareRequestFilter : HttpServletRequestWrapper를 상속한 SecurityContextHolderAwareRequestWapper 클래스로 HttpServletRequest 정보를 감싼다. SecurityContextHolderAwareRequestWrapper 클래스는 필터 체인상의 다음 필터들에게 부가정보를 제공한다. 
- AnonymousAuthenticationFilter : 이 필터가 호출되는 시점까지 사용자 정보가 인증되지 않았다면 인증토큰에 사용자가 익명 사용자로 나타난다. 
- SessionManagementFilter : 이 필터는 인증된 사용자와 관련된 모든 세션을 추적한다. 
- ExceptionTranslationFilter : 이 필터는 보호된 요청을 처리하는 중에 발생할 수 있는 예외를 위임하거나 전달하는 역할을 한다. 
- FilterSecurityInterceptor : 이 필터는 AccessDecisionManager 로 권한부여 처리를 위임함으로써 접근 제어 결정을 쉽게해준다.

## 인증(Authentication)
: 접근 주체는 Authentication 객체를 생성한다. 이 객체는 SecurityContext(내부 메모리)에 보관되고 사용
