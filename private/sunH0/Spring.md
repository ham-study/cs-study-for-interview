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

### filter
서블릿으로 전달되는 클라이언트의 request 혹은 서블릿에서 클라이언트로 전달되는 response를 중간에 가로채서 특정한 작업(필터링)을 하기 위해 객체와 메서드를 정의해 둔 인터페이스다.

가장 대표적인 예가 인코딩 작업
