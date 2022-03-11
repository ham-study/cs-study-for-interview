## Spring vs Spring MVC vs Spring Boot

Spring : Java 기반의 웹 애플리케이션 개발을 위한 오픈소스 프레임워크
Spring MVC : 웹 애플리케이션 개발에 있어 MVC 패턴을 적용할 수 있도록 Spring에서 제공하는 프레임워크
Spring Boot : Spring 설정들을 자동화하는 Spring 기반의 프레임워크

#### Spring
**구조**
![img](https://t1.daumcdn.net/cfile/tistory/996CA6455B90B6CC4E)

#### Spring MVC
- Model : 백그라운드에서 동작하며, 사용자가 원하는 데이터나 정보를 제공한다.
- View : 사용자의 요청을 화면으로 출력한다.
- Controller : 사용자의 요청을 처리하고, 그 요청에 따른 전체적인 흐름을 제어한다.
**구조**
![img](https://media.vlpt.us/images/gillog/post/566eb042-5ddf-45cb-99ee-3ee1153e7e6b/a.png)

**동작과정**
1. 사용자가 URL을 통해서 Request를 전송한다.

2. DispatcherServlet은 Request를 처리하기 위한 Controller를 HandlerMapping 빈 객체에게 검색 요청 한다.

3. HandlerMapping은 Client의 URL을 이용해서 이를 처리할 Controller 빈 객체를 DispathcerServlet에게 return한다.

4. DispathcerServlet은 Controller 객체를 처리 할 수 있는 HandlerAdapter 빈에게 요청 처리를 위임한다.
   @Controller, Controller Interface, HttpRequestHandler Interface를 동일한 방식으로 처리 하기 위해 HandlerAdapter 빈이 중간에 사용된다.
5. HandlerAdapter는 Controller에게 알맞은 method를 호출한다.

6. Controller는 비즈니스 로직을 수행 한 후 처리 결과를 HandlerAdapter에게 return 한다.

7. HandlerAdapter는 DispatcherServlet에게 Controller의 실행 결과를 ModelAndView 객체로 변환 하여 return 한다.

8. DispatcherServlet은 결과를 보여줄 View를 검색하기 위해 ViewResolver 빈 객체에게 ModelAndView안의 해당 View를 검색 요청한다.

9. ViewResolver는 ModelAndView안의 View 이름에 해당하는 View객체를 찾거나 생성해서 return 한다.
   JSP를 사용하는 ViewResolver는 매번 새로운 View 객체를 생성해서 DispathcerServlet에게 return한다.

10. DispatcherServlet은 ViewResolver가 return한 View 객체에게 request result 생성을 요청한다.

11. View 객체는 JSP를 사용하는 경우 JSP를 실행하여 result를 Rendering한 후 Client에게 Rendering된 View를 응답한다.



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
- 우리는 컨트롤러를 구현해두기만 하면 디스패처 서블릿가 알아서 적합한 컨트롤러로 위임을 해주는 구조가 되었습니다.

**단점**  
- Dispatcher Servlet이 모든 요청을 처리하다보니 이미지나 HTML/CSS/JavaScript 등과 같은 정적 파일에 대한 요청마저 모두 가로채는 까닭에 정적자원(Static Resources)을 불러오지 못하는 상황도 발생
    - 해결방법
      1. 정적 자원에 대한 요청과 애플리케이션에 대한 요청을 분리
      2. 애플리케이션에 대한 요청을 탐색하고 없으면 정적 자원에 대한 요청으로 처리
