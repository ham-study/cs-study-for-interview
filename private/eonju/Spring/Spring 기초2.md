## JAR vs WAR

### JAR(Java Archive : 자바 아카이브)
: 자바 클래스 파일들과 클래스에서 필요로 하는 리소스들을 하나의 파일로 모아서,
자바 플랫폼에 응용 소프트웨어나 라이브러리를 배포하기 위한 소프트웨어 패키지 파일 포맷입니다.

### WAR(Web Application Archive : 웹 어플리케이션 아카이브)
: 웹 어플리케이션이 구동되기 위한 기타 자원(자바 서버 페이지, Java Servlet, XML, HTML 등)을 한 군데에 모아
배포하는데 사용되는 파일 포맷입니다.

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

### Spirng에서 IoC 패턴을 사용하는 이유

: 변경에 유연한 코드 구조를 가져가기 위해서

## DL(Dependency Lookup) : 의존성 검색

- 컨테이너에서 제공하는 API를 이용해 사용하고자 하는 빈(Bean)을 저장소에서 Lookup하는 것을 말한다.

## DI (Dependency Injection) : 의존성 주입

- 각 객체간의 의존성을 컨테이너가 자동으로 연결해주는 것으로 개발자가 빈(Bean) 설정파일에 의존관계가 필요한 정보를 추가해주면 컨테이너가 자동적으로 연결해준다.

### IoC 컨테이너

모든 작업을 사용하는 쪽에서 제어하게 되면서 IoC컨테이너에서 제어하게 되는데, 기본적으로 컨테이너는 객체를 생성하고 객체간의 의존성을 이어주는 역할을 한다.

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

VO(Value Object)
: VO는 DTO와 동일한 개념이지만 read only 속성을 가짐

DTO(Data Transfer Object)
: VO(Value Object)로 바꿔 말할 수 있는데 계층간 데이터 교환을 위한 자바빈즈를 말합니다.

- 각 계층간 데이터 교환을 위한 객체를 DTO 또는 VO라고 부릅니다

DAO(Data Access Object)
: Data Access Object의 약자로 간단히 Database의 data에 접근을 위한 객체입니다. Database에 접근을 하기위한 로직과 비즈니스 로직을 분리하기 위해서
사용을 합니다
