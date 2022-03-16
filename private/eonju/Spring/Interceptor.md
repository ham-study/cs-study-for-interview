## Filter
: 애플리케이션의 HTTP 요청 및 응답을 가로채는 데 사용되는 개체

### Filter의 구조
![img](https://media.vlpt.us/images/ysm103408/post/44b25355-fc13-4320-bdab-ce8612078db9/image.png)

## interceptor
: 컨트롤러에 들어오는 요청 HttpRequest와 컨트롤러가 응답하는 HttpResponse를 가로채는 역할

- 사용될만한 곳 : 관리자 페이지 - 관리자 인증을 하는 용도

### Interceptor vs Filter
1. 호출 시점
   : Filter는 DispatcherServlet이 실행되기 전 , Interceptor는 DispatcherServlet이 실행된 후
2. 설정 위치
   : Filter는 web.xml , Interceptor는 spring-servlet.xml
3. 구현 방식
   : Filter는 web.xml에서 설정을 하면 구현이 가능하지만, Interceptor는 설정은 물론 메서드 구현이 필요합니다.

## Spring 전체 동작 과정 총 정리
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FchuSEt%2FbtqOxsoBXgh%2FoG3AkFamLy3UvDchdCTeSK%2Fimg.png)
![img](https://media.vlpt.us/images/lsj8367/post/fdba2f75-4cd4-420b-a9f8-c4a1e9cd42da/image.png)


## Spring Framework?
- 자바 개발을 편하게 해주는 오픈 소스 애플리케이션 프레임워크입니다.
- Java 개발에 있어 대표적인 프레임워크이며 JDBC, 하이버네이트, JPA 등과 같은 
DB 처리에 필요한 라이브러리와의 연동을 지원하여 활용도가 높습니다.
- 더불어 전자정부 표준프레임워크의 기반이 되는 기술이기 때문에 사용합니다.
- 정부기관에서 관리하는 검증된 오픈 소스로 구성된 무료 프레임워크입니다.

### 스프링 프레임워크의 특징
- 경량컨테이너로 라이프사이클을 관리하고 필요한 객체를 스프링으로부터 받아옵니다.
- DI지원하여 객체간의 의존관계 설정이 가능합니다.
- AOP지원합니다.
- POJO방식으로 자바객체는 특정한 인터페이스를 구현하고 클라스 상속이 필요치 않습니다.
- 트랜젝션 처리를 위한 일관된 방법을 제공합니다.
- 영속성 관련 다양한 API를 지원합니다.
- API연동을 지원합니다.
