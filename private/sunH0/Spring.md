# Spring
---

- [Spring](#Spring)
  - [Servlet](#Servlet)
  - [Servlet container](#Servlet-container)
  - [WAS](#WAS)
  - [servlet 동작 과정](#servlet-동작-과정)
  

## Servlet
---
java servlet은 웹서버 내부에서 클라이언트 요구에 맞춰 동적으로 반응하는 페이지인 처리를 위해 동작하는 자바 프로그램이다. servlet 컨테이너에 의해 실행되고 관리된다. 

+) CGI : 서블릿 등장 이전에 http 통신규약을 사용하는 웹서버가 프로그램(웹 어플리케이션)과 데이터를 주고 받는 처리 규약이다. 인터페이스라서 여러 언어로 구현이 가능하였다. 

#### servlet life Cycle

servlet 인터페이스에 init, service, destroy 3가지 메서드가 정의되어 있다. 오버라이딩하여 재정의 할 수 있다.

1. init은 서블릿이 최초의 한번만 실행되며 서블릿을 초기화한다.
    - 요청이 들어올 때마다 매번 servlet객체를 만드는 비용이 크기 때문에 init메서드가 호출되면 servlet은 메모리에 저장된다.
    
2. service는 개발자가 구현한 doGet(), doPost(), doPut(), doDelete() 메서드를 가지고 있으며 클라이언트의 요청을 처리며 실제 기능이 수행된다.

3. destory는 servlet Instance가 제거하며 GC에 의해 메모리 정리가 된다.

#### Servlet 특징

- Servlet 인터페이스를 구현하기 위해서 Generic Servlet, Http Servlet을 상속받아 구현한다.
  - Http Servlet: GenericServlet를 상속하여 만든 추상 클래스로 HTTP 프로토콜 서비스를 지원
  - Generic Servlet(추상 클래스) : init(), destroy()를 간단하게 제공

- 컨테이너 내부에서 쓰레드 단위로 요청을 처리한다. (리퀘스트가 쓰레드 하나)

- MVC 패턴에서 Controller로 이용된다.

- UDP보다 처리 속도가 느리다.

- HTML 변경 시 Servlet을 재컴파일해야 하는 단점이 있다.

- html을 사용하여 요청에 응답한다.
- 서블릿 객체는 싱글톤으로 관리

### WAS

사용자의 복잡한 로직을 처리하기 위해 요청 내용(request)을 받아 짜여진 로직대로 잘 처리한 뒤 웹페이지를 만들어 사용자에게 응답(response) 해주는 방식이다. 물론 만들어진 웹페이지는 웹서버를 통해 사용자에게 전달한다.

- 사용자는 웹서버가 주는 페이지만 받아서 실행하므로 내부의 로직을 알 수 없게 되어 보안이 강화
- 복잡한 연산은 성능이 뛰어난 서버단에서 해결하고 사용자에게 결과값만을 보내주기 때문에 네트워크 부하를 막을수 있고 성능이 향상된다.
  - 클라이언트는 주고 받는 코드량이 줄어들어 네트워크 부하도 줄일 수가 있다.
- WEB서버와 WAS는 물리적으로 나눌 수도 있고 한 서버안에 기능적으로 나눠둘 수도 있다. 
- WAS에서는 여러 개의 컨테이너를 구성해서 각각 독립적인 서비스로 구동시키는 것도 가능
- 웹서버 하나에서 로드밸런싱을 통해 많은 WAS서버를 가질수 있어 무중단 베포가 가능하다.


#### tomcat

Tomcat(톰캣)은 WEB/WAS의 기능을 가진 전 세계적으로 가장 많이 사용되는 오픈 소스 웹 컨테이너 


### JSP (Java Server Page)

기본적으로는 Html 코드 형식을 하되, 중간에 자바를 사용해 로직을 구성할 수 있는 구조의 웹어플리케이션 프로그래밍 기술로,
서블릿의  html 코드를 출력해주는 작업(writer.println)이 너무 번거롭다는 단점을 보안할 수 있다. (디자이너와 개발자의 역할 분리)

JSP파일은 결국 서블릿으로(.java) 변환이 되어 실행된다. 

- Java 컨테이너는 JSP파일의 HTML코드와 자바코드를 분리하고 다시 컴파일해서 .class 파일로 만든 뒤 실행 
  - JSP파일이 Servlet으로 변환되는 과정은 오직 한번만 일어나므로 servlet과 비슷한 속도이다.
  - jsp -(변환) -> Servlet(.java) -(컴파일) -> .class -(응답/HTML)-> 클라이언트
- JSP를 사용하여 비지니스 로직과 프레젠테이션 로직을 분리할 수 있다. 



### Servlet container
servlet container는 http요청을 받아 servlet을 실행시키고 생명주기를 관리하는 컴포넌트이다. 

추가적으로 다음과 같은 역할을 수행한다.

- 멀티 스레딩을 지원하고 관리한다.
- 웹 서버(nginx, apache..)와 소캣으로 통신할수 있는 API을 지원
- 선언적인 보안 관리
  - Web.xml에 정의하며, 보안에 대해 수정할 일이 생겨도 자바 소스 코드를 수정하여 다시 컴파일 하지 않아도 된다.

대표적인 container로 tomcat, jetty, jboss등이 있다.


### servlet 동작 과정

0. 사용자(클라이언트)가 URL을 입력하면 동적 자원 요청일 경우 HTTP Request가 Servlet Container로 전송
	- 정적인 페이지는 WeB 서버가 제공
1. 요청을 전송받은 servlet container에서 HttpServletRequest, HttpServletResponse 객체를 생성
2. web.xml파일을 확인하여 사용자가 요청한 URL이 어느 서블릿에 대한 요청인지 구분합니다.
	- 해당 서블릿 인스턴스가 없으면 init() 호출
	- url마다 서블릿이 존재하고 web.xml 에 어떻게 매핑시킬지 정의한다.
3. 컨테이너는 해당 서블릿에서 service() 메서드를 호출한후 HTTP 요청 메서드에 따라 doGet() 또는 doPost()를 호출한다.
   - rquest와 response객체가 제공
4. doGet(), doPost()메서드는 요청을 처리하여 HttpServletResponse 객체에 응답을 전달한다.
5. 응답이 완료되면 HttpServletRequest, HttpServletResponse객체는 소멸된다.





  
  
 ## Spring vs SpringBoot
  
 ### Spring Framework
 자바 앤터프라이즈(자바 플랫폼) 개발을 위해 필요한 기능들을 포괄적으로 제공하는 오픈소스 경량급 애플리케이션 프레임워크이다.
-  엔터프라이즈 개발 용이 : 개발자가 복잡하고 실수하기 쉬운 Low Level에 많이 신경 쓰지 않으면서 Business Logic
개발에 전념할 수 있도록 해준다.
- 경량급 프레임워크 : 단순한 웹컨테이너에서도 엔터프라이즈 개발의 고급기술을 대부분 사용할 수 있다.
 
 +) java SE 와 EE
 SE : 가장 대중적인 자바 플랫폼으로 자바 프로그래밍 언어의 핵심 api와 패키지를 제공한다.
 EE :  Java SE 플랫폼을 기반으로 JSP, Servlet, JDBC 같은 웹 프로그래밍에 필요한 기능을 포함하고 대규모, 다계층 구조로 확장 가능하며 보안 네트워크 API 를 제공한다.
 -> Spring은 Java EE의 많은 부분을 대체하고 개선하는 독립형 프레임 워크이다. 
 
 #### Spring 장점
스프링이 제공해주는 기능들을 통해 반복적인 코드를 줄이고 개발자는 비즈니스 로직에만 집중할 수 있기 때문에 생산성을 증가 

- DI, IOC를 통해 재사용 및 유지보수가 용이한 코드를 작성할 수 있고, 확장성을 가진 코드를 설계할 수 있다
- POJO 기반 구성 : 특정한 라이브러리나 컨테이너의 기술에 종속적이지 않게 자바 객체 를 사용할 수 있다.
- 경량 Container : 객체의 라이프 사이클을 관리하며 스프링 컨테이너으로 부터 필요한 객체를 얻어올 수 있다.
- Mybatis, Hibernate 등 데이터베이스 처리를 위한 ORM 프레임워크들과의 연동 지원
- 아키텍처의 유연성
  - AOP활용으로 Logging, Transaction, Security를 구현할 수 있습니다.
  - 모듈식으로 독립적인 구성을 가지고 있습니다.

+) POJO는 객체지향 원리에 충실하면서, 특정 환경이나 규약에 종속되지 않고 필요에 따라 재활용될수 있는\
방식으로 설계된 객체이다.

 ### SpringBoot
SpringBoot는 Spring Framework에서 사용하는 프로젝트를 간편하게 셋업할 수 있는 서브 프로젝트이다. 
 
### Spring Framework와 SpringBoot의 차이

1. 의존성 관리
- Spring은 개발에 필요한 모듈의 의존성을 각각 설정해줘야 했으며, 각 모듈의 버전을 개발자가 하나하나 명시해줘야했다.
-> SpringBoot는 프로젝트에 설정해야 할 다수의 의존성들을 포함한 spring-boot-starter를 통해 의존성 관리를 더 편리하게 해준다. (spring-aop, spring-jdbc 등등)
- 의존성을 추가할 때 Spring에서는 버전을 개발자가 직접 명시해줬어야 했는데 SpringBoot는 버전을 명시할 필요없이 가장 적합한 버전을 설정해주는 것이 가능하다.

2. Auto Configuration
Spring 에서는 컴포넌트 스캔, bean 설정, Dispatcher Servlet 설정, View Resolver, JDBC 설정 등의 다양한 설정을 해야하지만 Spring Boot 기반으로 구성함으로써  @SpringBootApplication을 통해 자동설정을 해준다.

db연결할때 datasource 설정을 매번 직접 bean을 생성했어야 했다

3. 내장 WAS
Spring으로 개발한 프로젝트를 배포하기 위해서는 웹어플리케이션이 압축된 war파일과 프로그램을 실행시킬 was가 필요했다.
SpringBoot는 Tomcat이나 Jetty같은 내장 서버를 가지고 있기 때문에 was 설정을 할 필요가 없고 jar 파일로만 배포할 수 있다. 

#### 결론
비교적 규모가 작은 어플리케이션을 실행시키기위해 그보다 큰 WAS를 따로 설치하기엔 효율적이지 않다 이런 경우 SpringBoot를 쓰는게 적당하고 규모가 큰 웹사이트에 경우 임페디드 컨테이너에서 애플리케이션을 실행 시키는 것은 다소 불안해서 SpringMVC 형태로 만들어 WAS에 배포하는 스타일이 더 좋다.

## Spring MVC
business logic과 presentation logic을 분리하여, 각 역활에 집중할 수 있으며 의존관계를 벗어날 수 있게하는 개발 기법

- Model : Business Logic 을 포함하고 뷰에 출력할 데이터를 담아두는 공간이다. 그래서 뷰는 내부에 데이터들이 어떻게 구성되었는지 신경쓰지 않고, 화면 렌더링에 집중할 수 있다.
- Controller : 클라이언트(HTTP) 요청을 받아, 실제 업무를 수행하는 모델 컴포넌트를 호출한다. 모델이 업무 수행을 완료하면, 그 결과를 가지고 화면을 생성하도록 뷰에 전달한다.
- View : 모델이 처리한 데이터나 그 작업 결과를 가지고 사용자에게 출력할 화면을 그리며, 실제로 HTML 을 생성하는 역할을 합니다.

### MVC1 과 MVC2

#### MVC1
모든 클라이언트 요청과 응답을 JSP가 담당한다. 즉, JSP가 Controller 와 View 의 기능을 모두 담당하는 구조이다
(jsp 페이지 안에서 로직 처리를 위해 자바코드가 함께 사용)

장점 : 단순해서 작은 프로젝트에서 사용될 수 있다.
단점 : 웹이 복잡해질수록 유지보수가 힘들어진다. (JSP 내에서 html, 자바코드 같이 사용)

#### MVC2
요청 결과를 출력해 주는 뷰의 역할을 jsp 가 담당하고, 흐름 제어와 비즈니스 로직 처리 요청하는 컨트롤러의 역할을 서블릿이 담당한다.

구조가 복잡하지만 유지보수, 확장에 용이하다
  
### Spring MVC 동작과정
![](https://images.velog.io/images/sunho6824/post/ca5d7824-7d2d-4cee-8295-868e24c372fa/image.png)
  
1. 클라이언트로부터 요청이 오면 dispatcher servlet에서 가로챕니다.
2. dispatcher servlet은 HandlerMapping객체에게 요청URL에 대해 어떤 컨트롤러(handler)에서 처리해야할지 정보를 얻어옵니다.
3. dispatcher servlet은 HandlerAdapter에게 요청을 위임하여 요청에 맞는 컨트롤러의 메서드를 실행시킵니다.
4. 컨트롤러는 메서드의 실행 결과를 ModelAndView의 형태로 반환합니다
5. dispatcher servlet은 view resolver로 부터 반환 값에 해당하는 view객체를 찾습니다.
6. view객체는 해당하는 뷰(html, jsp, thyleaf)를 호출하고 model객체에 담긴 데이터를 가져와 화면에 표시합니다.


### Spring MVC의 구조
- DispatcherServlet : 서블릿 컨테이너 가장 앞단에서 HTTP 프로토콜로 들어오는 모든 요청을 가장 먼저 받아 적합한 컨트롤러에 위임해주는 프론트 컨트롤러

  - 기존에는 web.xml에 서블릿을 모두 등록해줘야 했지만, 디스패처 서블릿이 모든 request를 핸들링하면서 작업을 편리하게 할 수 있다.
  - 공통적으로 진행되야 할 작업들을 우선적으로 DispatcherServlet에서 처리해준다. (한글 인코딩)

- HandlerMapping : 클라이언트의 request url을 어떤 컨트롤러가 처리해야 할 지 찾아서 Dispatcher Servlet에게 전달해주는 역할을 담당한다. -> 컨트롤러 상에서  @RequestMapping을 찾는다.

- Controller :실질적인 요청을 처리하는 곳이다. Dispatcher Servlet이 프론트 컨트롤러라면, 이 곳은 백엔드 컨트롤러라고 볼 수 있다. 모델의 처리 결과를 담아 Dispatcher Servlet에게 반환해준다.

- ModelAndView : Controller가 처리한 결과와 그 결과를 보여줄 View에 관한 정보를 담고 있는 객체이다.

- ViewResolver : View 관련 정보를 갖고 실제 View를 찾아주는 역할을 합니다.

- View : Controller가 처리한 결과값을 보여줄 View를 생성합니다.



## IoC
**이전의 방식에서는 main()에서 사용할 객체를 결정, 객체 내의 메소드 호출 작업같은 오브젝트가 프로그램 흐름을 결정하였다.**

Inversion of Control의 줄임말으로 개발자가 작성한 프로그램의 제어권이 개발자가 아닌 프레임워크에 넘어가 필요에 따라 스프링에서 사용자의 코드를 호출하는 것을 말한다. 

Spring에서 Ioc 콘테이너내에서 의존성 주입과 Bean의 전체 라이프사이클을 관리하는 등의 IoC 의 기능을 수행한다.

+) DL(Dependency Lookup: 의존성 검색) : 저장소에 저장되어 있는 Bean에 접근하기 위해  컨테이너가 제공하는 API를 이용하여 Bean을 Lookup하는 것. DL 사용 시 컨테이너 종속성이 증가한다.

###  IoC Conatiner = Spring Container
IoC Container에서 관리하는 객체 즉, Bean의 생성부터 소멸 까지의 전체 라이프 사이클을 개발자 대신 관리해주는 작업을 하는 컨테이너다. 대표적으로 Applicationcontext가 있다. 

- 의존성 주입 : 작성된  XML Configuration이나 Java 애노테이션이나 Java 코드를 확인하여 IoC Container 안에 등록된 빈들을 서로 주입해 준다.

### Beanfactory와 Applicationcontext의 차이점

경량 컨테이너 : BeanFactory 는 Bean 인스턴스를 제공하고 관리하는 컨테이너를 나타내는 인터페이스이다. 기본 구현 은 getBean () 이 호출 되는 시점에 해당 빈을 생성한다. (Lazy loading)

무거운 컨테이너 : ApplicationContext BeanFactory 인터페이스를 확장하여 더 많은 기능을 제공한다. (메세지 다국화, 이벤트 발행 기능, 리소스 로딩 기능 등)  기본 구현은 애플리케이션이 시작될 때 미리 모든 빈을 생성하고 필요할때 즉시 사용할 수 있도록 보장한다. 이 동작은 개별 Bean에 대해 재정의 될 수 있다.


## DI
각 클래스, 계층 간의 의존관계를 빈 설정 정보를 바탕으로 컨테이너에서 주입하는 개념이다.

의존성 주입의 약자로, 객체들 간의 의존성을 줄이기 위해 사용되는 스프링 IOC 컨테이너의 구체적 구현 방식이다. 개발 코드 부분에서 객체를 생성하지 않고 데이터 주입만 담당하는 별도의 공간에서 객체를 생성하고, 데이터 간의 의존성을 주입해 코드에서 가져다 쓰는 방식이다. 디자인 패턴 중 팩토리 패턴을 활용한다 할 수 있다.

객체가 직접 의존하고 있는 객체를 생성하거나 검색할 필요가 없어지므로 코드의 관리가 쉬워지고 컴포넌트 간의 결합도가 제거된다.

+) 의존성 : 컴파일 타임이 아니라 런타임시에 결정/구성되는 오브젝트와 오브젝트 사이의 의존 관계를 말한다.

### Bean 주입 방법(DI 종류)

1. (수정자)세터 주입
	- 주입받는 객체가 변경될 가능성이 있는 경우에 사용한다.
    - set 메서드에 @Autowired가 명시되어 있고 주입할 대상이 없는 경우에는 오류가 발생한다.
2. 생성자 주입
3. @Autowired 어노테이션으로 필드에 주입
	- 외부에서 변경이 불가능하다는 단점이 존재
    - 반드시 DI 프레임워크가 존재해야 하므로 순수한 자바 코드로 단위 테스트를 작성하는 것이 불가능하다


#### 생성자 주입을 주로 사용하는 이유

- 생성자의 호출 시점에 1회 호출 되는 것이 보장된다. 그렇기 때문에 주입받은 객체의 분변성을 확보할 수 있고 반드시 객체의 주입이 필요한 경우에 강제하기 위해 사용할 수 있다.

- **컴파일 시점에 객체를 주입받아** 순수 자바 코드로 테스트 코드를 작성할 수 있다. 애플리케이션 구동 시점(객체의 생성 시점)에 순환 참조 에러를 방지할 수 있다.

- 생성자 주입을 사용하면 필드 객체에 **final 키워드**를 사용할 수 있으며, 컴파일 시점에 누락된 의존성을 확인할 수 있다. Lombok과 결합되어 코드를 간결하게 작성할 수 있다.


## Bean
Spring Bean은 Spring IoC 컨테이너에 의해 생성되는 Java Object(PoJo)이다. Bean은 xml파일이나 자바 configuration으로 선언할 수 있다. 

### Spring IoC Container의 Bean 등록 방법
xml 설정파일을 이용해서 Bean 등록, @Annotatation을 통해 Bean 등록하는 방법 등이 존재

Annotation 기반의 Bean 등록시에는 Component Scan을 꼭 필요하다. Spring Boot는 Component Scan까지 자동으로 구성

#### Spring Component Scan
빈을 등록할 컴포넌트를 어노테이션 기반으로 검색해서 자동 등록해 주는 기능이다. ex) @Component, @Repository...

#### Bean이 주입 될 때 같은 이름 및 같은 타입의 빈이 존재한다면
@Primary 애노테이션으로 우선순위 설정할 수 있고, @Qulifier 애노테이션으로 Bean 이름을 통해서 주입 받을 수 있고, 해당 타입의 빈을 모두 List를 통해서 주입 받을 수 있다.


### 스프링 Bean의 Scope
스프링이 관리하는 빈이 생성되고, 존재하고, 적용되는 범위를 말한다. 기본값은 싱글톤으로 작동된다.
ex) @Scope(value = "prototype") 

- singleton : 기본값, 스프링 IoC 컨테이너당 하나의 인스턴스만 사용한다. 앱이 구동되는 동안 하나만 사용된다는 뜻이다. 
- prototype : 매번 새로운 빈을 정의해서 사용한다.
  - 만약, 싱글톤 스코프의 빈이 prototype 의 빈을 주입받는 경우, prototype 의 경우에는 항상 새로운 빈이 생성되어야 하는데, 매번 같은 빈을 사용하게 된다.
- request : HTTP 요청 하나가 들어오고 나갈 때 까지 유지되는 스코프, 각각의 HTTP 요청마다 별도의 빈 인스턴스가 생성되고, 관리된다.
- session : HTTP Session과 동일한 생명주기를 가지는 스코프
- application : ServletContext 와 동일한 생명주기를 가지는 스코프
- websocket : 웹 소켓과 동일한 생명주기를 가지는 스코프

### @Bean과 @Component
- @Bean은 메소드 레벨에서 선언하며, 반환되는 객체(인스턴스)를 개발자가 수동으로 빈으로 등록하는 애노테이션이다.
반면 @Component는 클래스 레벨에서 선언함으로써 스프링이 런타임시에 컴포넌트스캔을 하여 자동으로 빈을 찾고(detect) 등록하는 애노테이션이다.

- 개발자가 컨트롤이 불가능한 외부 라이브러리를 빈으로 등록하고 싶을때 @Bean을 사용하며, 개발자가 직접 컨트롤이 가능한 클래스의 경우 @Component를 사용한다. 해당 용도외에는 컴파일 에러를 발생시킨다.

### Spring Bean 라이프 사이클
스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 메서드 호출 -> 애플리케이션에서 빈 사용 -> 소멸 전 콜백 메서드 호출 -> 스프링 종료


### Spring Framework의 기본 Bean 범위

### Singleton Bean은 스레드로부터 안전한가요?
아니요, 싱글 톤 빈은 스레드로부터 안전하지 않습니다. 스레드 안전성은 실행에 관한 것이고 싱글 톤은 생성에 초점을 맞춘 디자인 패턴입니다. 스레드 안전성은 Bean 구현 자체에만 의존합니다.


### Autowiring 과정


## VO vs DTO vs DAO

- DAO(Data Access Object)는 데이터베이스의 데이터에 접근하기 위한 객체이다. 데이터 베이스 접근을 위한 로직과 비즈니스 로직을 분리하기 위해서 사용된다.

- DTO(Data Transfer Object)는 계층간 데이터 교환을 위한 자바 객체이다. 여기서 계층은 컨트롤러, 뷰, 비즈니스 로직, presistent layer 가 있다. 

-VO(Value Object) : VO는 값 자체에 의미가 있는 객체로ㅡ DTO와 Data를 전달하는 객체로 동일한 개념이지만,  read only 특징을 가지고 있다는 차이가 있다. 같은 객체라는 것을 보장하기 위해서는 equals와 hashcode를 재정의해주어야한다.

- Entity 클래스는 실제 DataBase의 테이블과 1 : 1로 Mapping 되는 Class로, DB의 테이블내에 존재하는 컬럼만을 속성(필드)으로 가져야 한다.

### Entity, DTO Class 분리 이유

Entity는 실제 테이블과 매핑되어 만일 변경되게 되면 여러 다른 Class에 영향을 끼치고, DTO는 View와 통신하며 자주 변경되므로 분리 해주어야 한다.

## @Service @Contriller @Repository
각각의 어노테이션을 사용하여 프로그램의 레이어를 분리한다.



- @Component : Spring에서 관리되는 객체임을 표시하기 위해 사용하는 가장 기본적인 annotation이다. 
- @Controller : Spring MVC에서  Servlet과 동일한 역할을 하지만 서블릿 위에 구현된 라이브러리로, @RequestMapping 애노테이션을 이용한 여러 handler method를 제공한다.
- @Service : @Component와 다른 기능은 없지만 비즈니스 로직에 해당 어노테이션을 사용하여 명시적으로 비즈니스 로직을 가지고 있는 클래스임을 나타내게 해준다.
- @Repository : 해당 클래스를 데이터 접근 계층으로 인식하며, 데이터 계층의 예외를 추상화하여 스프링 예외로 변환하여 던져준다. UnChecked Exception인 DataAccessException으로 전환
