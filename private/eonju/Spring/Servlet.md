# Servlet
## 개념
- Dynamic Web Page를 만들 때 사용되는 자바 기반의 웹 애플리케이션 프로그래밍 기술입니다.
  ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbc76R9%2Fbtq7EeRfHx3%2FrBY8OFkMbUZH8cI84O2wu0%2Fimg.png)

### 왜 사용하는가?
  - 웹의 요청과 응답 메세지를 일일히 파싱해서 처리하게 된다면 서비스를 만드는 것에 보다 집중하기 힘들어진다.
  따라서, 웹 요청과 응답의 흐름을 간단한 메서드 호출만으로 체계적으로 다룰 수 있게 해줍니다.
  
### 서블릿의 주요 특징
  - 클라이언트의 Request에 대해 동적으로 작동하는 웹 애플리케이션 컴포넌트이다.
  - HTML을 사용하여 Response 한다.
  - JAVA의 스레드를 이용하여 동작한다.
  - MVC 패턴에서의 컨트롤러로 이용된다.
  - HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받는다.
  - UDP보다 속도가 느리다.
  - 서블릿 내에 HTML코드가 존재하기 때문에 HTML 변경시 Servlet을 재 컴파일해야 하는 단점이 있다.
  
### 서블릿 실행 과정
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbu3HKI%2Fbtq7BerRpgq%2FiI82e9Zf9XLSwklFLjsXpk%2Fimg.png)

## filter
- 자바 서블릿에서 제공하는 기능으로 디스패처 서블릿(Dispatcher Servlet)에 요청이 전달되기 전/후에 url 패턴에 맞는 모든 요청에 대해 부가작업을 처리할 수 있는 기능을 제공
- 디스패처 서블릿은 스프링의 가장 앞단에 존재하는 프론트 컨트롤러이므로, 필터는 스프링 범위 밖에서 처리가 되는 것이다.
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbZQx9K%2Fbtq9zEBsJ75%2FdEAKj1HEymcKyZGZNOiA80%2Fimg.png)

### filter vs Interceptor
filter는 Spring Context단에서 동작
Interceptor는 Web Context 단에서 동작, Spring이 제공하는 기술로써, 디스패처 서블릿(Dispatcher Servlet)이 컨트롤러를 호출하기 전과 후에 요청과 응답을 참조하거나 가공할 수 있는 기능을 제공

### 메소드 정리
- init 메소드
: init 메소드는 필터 객체를 초기화하고 서비스에 추가하기 위한 메소드이다. 웹 컨테이너가 1회 init 메소드를 호출하여 필터 객체를 초기화하면 이후의 요청들은 doFilter를 통해 처리된다.
- doFilter 메소드
: doFilter 메소드는 url-pattern에 맞는 모든 HTTP 요청이 디스패처 서블릿으로 전달되기 전에 웹 컨테이너에 의해 실행되는 메소드이다. doFilter의 파라미터로는 FilterChain이 있는데, FilterChain의 doFilter 통해 다음 대상으로 요청을 전달하게 된다. chain.doFilter() 전/후에 우리가 필요한 처리 과정을 넣어줌으로써 원하는 처리를 진행할 수 있다.
- destroy 메소드
: destroy 메소드는 필터 객체를 서비스에서 제거하고 사용하는 자원을 반환하기 위한 메소드이다. 이는 웹 컨테이너에 의해 1번 호출되며 이후에는 이제 doFilter에 의해 처리되지 않는다.

### 사용되는 곳
필터는 주로 요청에 대한 인증, 권한 체크 등을 하는데에 쓰입니다. 구체적으로 들어온 요청이 DispatcherServlet에 전달되기 전에 헤더를 검사해 인증 토큰이 있는지 없는지, 올바른지 올바르지 않은지 등을 검사할 수 있을 것입니다.

## servlet container
: servlet의 생성부터 소멸까지의 일련의 과정(Life Cycle)을 관리한다.

### 서블릿 컨테이너의 동작과정
1. 클라이언트로부터 요청 도착
2. HttpServletRequest, HttpServletResponse 두 객체를 생성
3. post, get여부에 따라 동적인 페이지를 생성하여 응답

- HttpServletRequest  
  : http프로토콜의 request정보를 서블릿에게 전달하기 위한 목적으로 사용하며 헤더 정보, 파라미터, 쿠키, URI, URL 등의 정보를
    읽어 들이는 메서드와 Body의 Stream을 읽어 들이는 메서드를 가지고 있습니다.
- HttpServletResponse  
  : WAS는 어떤 클라이언트가 요청을 보냈는지 알고 있고, 해당 클라이언트에게 응답을 보내기 위한 HttpServleResponse 객체를
    생성하여 서블릿에게 전달하고 이 객체를 활용하여 content type, 응답 코드, 응답 메시지 등을 전송합니다.
### Tomcat
: 대표적인 서블릿 컨테이너, 웹 컨테이너
![img](http://melonicedlatte.com/assets/images/201906/79986821-0AE3-4389-83E8-4AFC4FD2EABF.jpeg)
