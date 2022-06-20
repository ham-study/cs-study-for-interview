## Servlet (자카르타 서블릿)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbc76R9%2Fbtq7EeRfHx3%2FrBY8OFkMbUZH8cI84O2wu0%2Fimg.png)

- Dynamic Web Page를 만들 때 사용되는 자바 기반의 웹 애플리케이션 프로그래밍 기술입니다.

**왜 사용하는가?**

- 웹의 요청과 응답 메세지를 일일히 파싱해서 처리하게 된다면 서비스를 만드는 것에 보다 집중하기 힘들어집니다.
- 따라서, 웹 요청과 응답의 흐름을 간단한 메서드 호출만으로 체계적으로 다룰 수 있게 해줍니다.

**서블릿의 주요 특징**

- 클라이언트의 Request에 대해 동적으로 작동하는 웹 애플리케이션 컴포넌트이다.
- HTML을 사용하여 Response 한다.
- JAVA의 스레드를 이용하여 동작한다.
- MVC 패턴에서의 컨트롤러로 이용된다.
- HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받는다.
- UDP보다 속도가 느리다.
- 서블릿 내에 HTML코드가 존재하기 때문에 HTML 변경시 Servlet을 재 컴파일해야 하는 단점이 있다.

**서블릿 생명 주기**

1. 요청이 들어오면 해당 Servlet의 유무를 판단하여 Servlet 인스턴스가 생성 후 init()
2. 요청별 스레드를 생성하여 service()를 실행
3. 응답을 다 처리하였으면 Servlet Container 에 servlet 객체 반환
4. 서비스나 서버가 중단되었을 때 distory() 메소드를 실행하여 서블릿 객체 소멸

**서블릿 실행 과정**

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbu3HKI%2Fbtq7BerRpgq%2FiI82e9Zf9XLSwklFLjsXpk%2Fimg.png)

---

## Servlet Container

- IoC 컨테이너
- Servlet 의 생성부터 소멸까지의 일련의 과정(Life Cycle)을 관리
- 대표적으로 아파치 톰캣(Tomcat)이 있다.

**서블릿 컨테이너가 하는 일**

- servlet 관리
- 네트워크 통신
- 스레드 기반 병렬 처리

**서블릿 컨테이너의 동작과정**

1. 클라이언트로부터 HTTP 요청 도착
2. 서블릿 컨테이너가 HttpServletRequest, HttpServletResponse 두 객체를 생성
3. 사용자가 요청한 URL을 분석하여 어느 Servlet에 대한 요청인지 찾는다.
4. 찾은 서블릿의 service()를 호출하여 POST, GET 여부에 따라 doGet() 또는 doPost()가 호출
5. HttpServletResponse 객체에 응답을 담아 보낸다.

**HttpServletRequest**

- HTTP 프로토콜의 Request정보를 서블릿에게 전달하기 위한 목적으로 사용
- 헤더 정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽어 들이는 메서드와 Body의 Stream을 읽어 들이는 메서드를 지님.

**HttpServletResponse**

- 서블릿에게 전달되는 객체
- content type, 응답 코드, 응답 메시지 등을 전송합니다.

---

## Filter

- 자바 서블릿에서 제공하는 기능으로 디스패처 서블릿(Dispatcher Servlet)에 요청이 전달되기 전/후에 url 패턴에 맞는 모든 요청에 대해 부가작업을 처리할 수 있는
  기능을 제공
- 공통적인 일을 처리해주는 기능을 한다.
- 디스패처 서블릿은 스프링의 가장 앞단에 존재하는 프론트 컨트롤러이므로, 필터는 스프링 범위 밖에서 처리가 되는 것이다.
- 웹 컨테이너에 의해 관리된다. (Spring Bean으로 등록되기는 한다)
  ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FSz6DV%2Fbtq9zjRpUGv%2F68Fw4fZtDwaNCZiCFx57oK%2Fimg.png)

**필터가 사용되는 예**

: 서블릿이 호출되기 전에 HTTP 요청을 조작 및 점검 또는 서블릿이 호출된 후 HTTP 응답을 조작

- 로그인여부나 권한 검사와 같은 인증 기능
- 요청이나 응답에 대한 로그(기록) 기능
- 오류 처리 기능
- 데이터 압축이나 변환 기능
- 인코딩 처리

**Filter의 메소드**

- init()
    - 필터 객체를 초기화하고 서비스에 추가하기 위한 메소드
    - 웹 컨테이너가 1회 init 메소드를 호출하여 필터 객체를 초기화하면 이후의 요청들은 doFilter()를 통해 처리된다.

- doFilter()
    - url-pattern에 맞는 모든 HTTP 요청이 디스패처 서블릿으로 전달되기 전에 웹 컨테이너에 의해 실행되는 메소드
    - doFilter의 파라미터로는 FilterChain이 있는데, FilterChain의 doFilter()를 통해 다음 대상으로 요청을 전달하게 된다.
    - chain.doFilter() 전/후에 우리가 필요한 처리 과정을 넣어줌으로써 원하는 처리를 진행할 수 있다.

- destroy()
    - 필터 객체를 서비스에서 제거하고 사용하는 자원을 반환하기 위한 메소드
    - 이는 웹 컨테이너에 의해 1번 호출되며 이후에는 이제 doFilter()에 의해 처리되지 않는다.

---

## Spring vs Spring MVC vs Spring Boot

- Spring : Java 기반의 웹 애플리케이션 개발을 위한 오픈소스 프레임워크
- Spring MVC : 웹 애플리케이션 개발에 있어 MVC 패턴을 적용할 수 있도록 Spring에서 제공하는 프레임워크
- Spring Boot : Spring 설정들을 자동화하는 Spring 기반의 프레임워크

**Spring vs SpringBoot**  
a) Auto Configuration 자동 실행  
b) 쉬운 의존성 관리  
c) 내장 서버

**Spring vs SpringMVC**  
[참고 블로그](https://velog.io/@hellonayeon/springmvc-vs-springboot)

#### Spring

**구조**
![img](https://t1.daumcdn.net/cfile/tistory/996CA6455B90B6CC4E)

#### Spring MVC

- 프론트 컨트롤러 패턴으로 구현되어 있습니다.
- 프론트 컨트롤러가 Dispatcher Servlet입니다.
- Dispatcher Servlet은 Spring MVC의 핵심입니다.
- 이 Dispacher Servlet이 HandlerMapping 객체를 이용해 요청과 매핑되는 controller을 검색하고,
- Handler Adapter가 요청에 맞는 ModleAndView를 반환합니다. 이때, 컨트롤러 사용하게 됩니다.
- 그리고 받은 ModleAndView객체에서 View name에 맞는 이름을 검색하여 view를 만들어 반환하게 됩니다.

- Model : 백그라운드에서 동작하며, 사용자가 원하는 데이터나 정보를 제공한다.
- View : 사용자의 요청을 화면으로 출력한다.
- Controller : 사용자의 요청을 처리하고, 그 요청에 따른 전체적인 흐름을 제어한다.

**구조**
![img](https://media.vlpt.us/images/gillog/post/566eb042-5ddf-45cb-99ee-3ee1153e7e6b/a.png)

**동작과정**

1. 사용자가 URL을 통해서 Request를 전송한다.

2. DispatcherServlet은 Request를 처리하기 위한 Controller를 HandlerMapping 빈 객체에게 검색 요청 한다.

3. HandlerMapping은 Client의 URL을 이용해서 이를 처리할 Controller 빈 객체를 DispathcerServlet에게 return한다.

4. DispathcerServlet은 Controller 객체를 처리 할 수 있는 HandlerAdapter 빈에게 요청 처리를 위임한다. @Controller,
   Controller Interface, HttpRequestHandler Interface를 동일한 방식으로 처리 하기 위해 HandlerAdapter 빈이 중간에 사용된다.
5. HandlerAdapter는 Controller에게 알맞은 method를 호출한다.

6. Controller는 비즈니스 로직을 수행 한 후 처리 결과를 HandlerAdapter에게 return 한다.

7. HandlerAdapter는 DispatcherServlet에게 Controller의 실행 결과를 ModelAndView 객체로 변환 하여 return 한다.

8. DispatcherServlet은 결과를 보여줄 View를 검색하기 위해 ViewResolver 빈 객체에게 ModelAndView안의 해당 View를 검색 요청한다.

9. ViewResolver는 ModelAndView안의 View 이름에 해당하는 View객체를 찾거나 생성해서 return 한다. JSP를 사용하는 ViewResolver는 매번
   새로운 View 객체를 생성해서 DispathcerServlet에게 return한다.

10. DispatcherServlet은 ViewResolver가 return한 View 객체에게 request result 생성을 요청한다.

11. View 객체는 JSP를 사용하는 경우 JSP를 실행하여 result를 Rendering한 후 Client에게 Rendering된 View를 응답한다.

![img](https://t1.daumcdn.net/cfile/tistory/992B234C5C807FD114)

### MVC1 vs MVC2

#### MVC1

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FI1UUx%2FbtqEZ0IhZ6O%2FqzvwssYAAkEltNqYd3Kpik%2Fimg.png)

#### MVC2

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbgbhsb%2FbtqE0BOnWqs%2FGhoRjVi90P1dYSBjRHSo91%2Fimg.png)

## Dispatcher Servlet

: 가장 앞단에서 HTTP 프로토콜로 들어오는 모든 요청을 가장 먼저 받아 적합한 컨트롤러에 위임해주는 프론트 컨트롤러(Front Controller)

- 프론트 컨트롤러 패턴과 관련있음
- 클라이언트 -> 서블릿 컨테이너 -> 디스패처 서블릿 -> 공통적인 작업을 먼저 처리 -> 세부 컨트롤러에게 작업 위임

**장점**

- dispatcher-servlet이 해당 어플리케이션으로 들어오는 모든 요청을 핸들링
- 공통 작업을 처리
- 우리는 컨트롤러를 구현해두기만 하면 디스패처 서블릿가 알아서 적합한 컨트롤러로 위임을 해주는 구조

**단점**

- Dispatcher Servlet이 모든 요청을 처리하다보니 이미지나 HTML/CSS/JavaScript 등과 같은 정적 파일에 대한 요청마저 모두 가로채는 까닭에 정적자원(
  Static Resources)을 불러오지 못하는 상황도 발생
    - 해결방법
        1. 정적 자원에 대한 요청과 애플리케이션에 대한 요청을 분리
        2. 애플리케이션에 대한 요청을 탐색하고 없으면 정적 자원에 대한 요청으로 처리

## JAR(Java Archive : 자바 아카이브)

: 자바 클래스 파일들과 클래스에서 필요로 하는 리소스들을 하나의 파일로 모아서, 자바 플랫폼에 응용 소프트웨어나 라이브러리를 배포하기 위한 소프트웨어 패키지 파일 포맷입니다.

## WAR(Web Application Archive : 웹 어플리케이션 아카이브)

: 웹 어플리케이션이 구동되기 위한 기타 자원(자바 서버 페이지, Java Servlet, XML, HTML 등)을 한 군데에 모아 배포하는데 사용되는 파일 포맷입니다.

- Servlet / Jsp 컨테이너에 배치할 수 있는 웹 애플리케이션(Web Application) 압축파일 포맷

### cf ) 자바 플랫폼이란?

- Java 프로그램의 개발과 실행을 위한 환경
- Java 플랫폼 = Java VM + Java API로 구성

### JAR와 WAR가 사용되는 곳은?

- JAR와 WAR는 모두 압축 파일 포맷입니다.
- 애플리케이션을 간단히 배포하고 어느 환경에서나 구동할 수 있도록 소스 코드들이나 관련 파일들을 하나로 패키징한 것입니다.

### JAR vs WAR

- JAR
    - JRE(Java Runtime Environment)만 존재하면 프로젝트 구동이 가능하다.
- WAR
    - 별도의 웹 서버 또는 WAS(웹 컨테이너)가 있어야 프로젝트 구동이 가능하다.
    - 외부의 WAS를 이용해야한다면 WAR를 이용해야 한다.

## IoC (Inversion of Control) : 제어의 역전

제어의 역전의 방법 중 하나가 의존성 주입(DI)이다.

- 의존관계의 제어를 개발자가 직접 해주었다. 그러나 제어권이 컨테이너로 넘어갔고 객체의 생성부터 생명주기의 관리까지 객체에 대한 제어권이 바뀐것을 IoC라고 한다.

![img](https://t1.daumcdn.net/cfile/tistory/9933C93F5AF277561A)

### Spring 에서 IoC 패턴을 사용하는 이유

: 변경에 유연한 코드 구조를 가져가기 위해서

## DL(Dependency Lookup) : 의존성 검색

- 컨테이너에서 제공하는 API를 이용해 사용하고자 하는 빈(Bean)을 저장소에서 Lookup하는 것을 말한다.

## DI (Dependency Injection) : 의존성 주입

- 각 객체간의 의존성을 컨테이너가 자동으로 연결해주는 것으로 개발자가 빈(Bean) 설정파일에 의존관계가 필요한 정보를 추가해주면 컨테이너가 자동적으로 연결해준다.

### IoC 컨테이너

: 모든 작업을 사용하는 쪽에서 제어하게 되면서 IoC 컨테이너에서 제어하게 되는데, 기본적으로 컨테이너는 객체를 생성하고 객체간의 의존성을 이어주는 역할을 한다.

- Spring 프레임워크에서는 Setter Injection, Constructor Injection 두 가지 방식이 있다.

### 빈(Bean) 요청 시 처리 과정

클라이언트에서 해당 빈을 요청하면 애플리케이션 컨텍스트는 다음과 같은 과정을 거쳐 빈을 반환한다.

1. ApplicationContext는 @Configuration이 붙은 클래스들을 설정 정보로 등록해두고, @Bean이 붙은 메소드의 이름으로 빈 목록을 생성한다.
2. 클라이언트가 해당 빈을 요청한다.
3. ApplicationContext는 자신의 빈 목록에서 요청한 이름이 있는지 찾는다.
4. ApplicationContext는 설정 클래스로부터 빈 생성을 요청하고, 생성된 빈을 돌려준다.
   ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FLuLhA%2Fbtq4squITMm%2FmqqtgMfiiahkAFBuPLMaLk%2Fimg.png)

## Bean, Component

### Bean

: 스프링 컨테이너가 설정 파일을 읽어서 정보를 읽고 관리한다.

### Bean 설정 방식

1. XML 방식 -> <bean>으로 등록
2. java Config 방식 -> @Bean

### Bean 등록 과정

Bean은 런타임시점에 ComponentScan이 설정 파일들을 읽고 ApplicationContext에 의하여 IoC컨테이너에 등록된다

### Bean vs Component

- @Component는 Class Level에서, @Bean은 Method Level에서 적용된다.
- @Bean은 사용자가 컨트롤 하지 못하는 Class나, 좀 더 유연하게 객체를 생성해서 넘기고 싶을 때 (이를 테면 외부 라이브러리),
- @Component는 Class 자체를 빈으로 등록하고 싶을 때, 사용하면 된다.
- @SpringBootApplication이 @Configuration, @ComponentScan을 상속받고 있다.

### @Component @Service @Controller

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fk0eNV%2FbtqIdTkRQ2A%2FdMWPvZl1djOkItdzxFeWH0%2Fimg.jpg)

### @Component

: **Spring에서 관리되는 객체임**을 표시하기 위해 사용하는 가장 기본적인 annotation이다. 즉, scan-auto-detection과 dependency
injection을 사용하기 위해서 사용되는 가장 기본 어노테이션이다.

### @Service

: 비즈니스 로직이나 respository layer 호출하는 함수에 사용된다.

### @Controller

: Web MVC 코드에 사용되는 어노테이션이다. @RequestMapping 어노테이션을 해당 어노테이션 밑에서만 사용할 수 있다.

- Component vs Controller/Service/Repository  
  : 일반적으로 컴포넌트 클래스들에 @Component를 붙일 수 있지만, @Repository, @Service, @Controller를 붙인다면 도구들이 클래스들을 처리하는데
  더 적합하도록 할 수 있고 관점(aspects)에 더 연관성을 부여할 수 있다.
  (= AOP 를 통한 처리가 쉽게 가능하다)

## Container

- Application Context
  : 직접 오브젝트를 생성하고 관계를 맺어주는 코드가 없고, 그런 생성 정보와 연관관계 정보에 대한 설정을 읽어 처리한다.

- IoC 컨테이너
  : 객체에 대한 생성 및 생명주기를 관리할 수 있는 기능을 제공
    - IoC Container는 오브젝트의 생성과 관계설정, 사용, 제거 등의 작업을 대신 해준다하여 붙여진 이름이다.
    - 이때, IoC Container에 의해 관리되는 오브젝트들은 Bean 이라고 부른다.

## VO vs DTO vs DAO

- VO(Value Object)
  : VO는 DTO와 동일한 개념이지만 read only 속성을 가짐

- DTO(Data Transfer Object)
  : VO(Value Object)로 바꿔 말할 수 있는데 계층간 데이터 교환을 위한 자바빈즈를 말합니다.
- DAO(Data Access Object)
  : Data Access Object의 약자로 간단히 Database의 data에 접근을 위한 객체입니다. Database에 접근을 하기위한 로직과 비즈니스 로직을 분리하기
  위해서 사용을 합니다.
- 각 계층간 데이터 교환을 위한 객체를 DTO 또는 VO라고 부릅니다

---

## Spring AOP

spring AOP에서는 인터페이스 유무에 따라 인터페이스 기반의 프록시 생성 시 Dynamic Proxy를 사용하고 인터페이스 기반이 아닐시 CGLib을 사용하는데 spring
boot AOP에서는 CGLib을 default로 사용한다고 한다.

- 핵심로직이 구현된 메소드에 포함된 공통기능 코드를 제거할 수 있다.
- 공통기능을 별도의 클래스에 정의하고, AOP 기능을 지원하는 컨테이너(우리는 Spring Container)를 활용해서 핵심기능이 실행될 때 공총기능이 같이 실행되도록 하는
  것이다.
- 스프링 컨테이너는 AOP의 구현체다.

**장점**

- 코드의 중복이 제거된다.
- 핵심 로직의 유지보수가 쉬워진다.
- 공통기능의 활성화/비활성화가 가능하다.
- 개발자는 업무로직의 구현에만 집중할 수 있다.

### JDK Dynamic Proxy

- JDK 에서 제공하는 Dynamic Proxy는 Interface를 기반으로 Proxy를 생성해주는 방식
- 다이나믹 프록시란 런타임에 프록시가 생성되는 것을 의미한다.
- Invocation Handler를 상속받아서 실체를 구현
- 특정 Object에 대해 Reflection을 사용하기 때문에 성능이 조금 떨어지는 크리티컬한 단점
- 리플렉션을 활용한 Proxy 클래스를 제공해주고 있다. Java.lang.reflect.Proxy 클래스의 newProxyInstance() 메소드를 이용해 프록시 객체를
  생성한다.

### Reflection

- 구체적인 클래스 타입을 알지 못해도 그 클래스의 정보(메서드, 타입, 변수 등등)에 접근할 수 있게 해주는 자바 API
- 자바에서는 JVM이 실행되면 사용자가 작성한 자바 코드가 컴파일러를 거쳐 바이트 코드로 변환되어 static 영역에 저장된다. Reflection API는 이 정보를 활용해
  필요한 정보를 가져온다.
- 단점 : Reflection API는 값비싼 API이기 때문에 Dynamic Proxy는 리플렉션을 하는 과정에서 성능이 좀 떨어진다.

### CGLIB (Code Generator Library)

: 클래스의 바이트코드를 조작하여 Proxy 객체를 생성해주는 라이브러리

- Enhancer를 바탕으로 Proxy를 구현하는 방식

## interceptor

: 컨트롤러에 들어오는 요청 HttpRequest와 컨트롤러가 응답하는 HttpResponse를 가로채는 역할

- 사용될만한 곳 : 관리자 페이지 - 관리자 인증을 하는 용도

**Interceptor vs Filter**

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
- Java 개발에 있어 대표적인 프레임워크이며 JDBC, 하이버네이트, JPA 등과 같은 DB 처리에 필요한 라이브러리와의 연동을 지원하여 활용도가 높습니다.
- 더불어 전자정부 표준프레임워크의 기반이 되는 기술이기 때문에 사용합니다.
- 정부기관에서 관리하는 검증된 오픈 소스로 구성된 무료 프레임워크입니다.

**스프링 프레임워크의 특징**

- 경량컨테이너로 라이프사이클을 관리하고 필요한 객체를 스프링으로부터 받아옵니다.
- DI지원하여 객체간의 의존관계 설정이 가능합니다.
- AOP지원합니다.
- POJO방식으로 자바객체는 특정한 인터페이스를 구현하고 클라스 상속이 필요치 않습니다.
- 트랜젝션 처리를 위한 일관된 방법을 제공합니다.
- 영속성 관련 다양한 API를 지원합니다.
- API연동을 지원합니다.

---


