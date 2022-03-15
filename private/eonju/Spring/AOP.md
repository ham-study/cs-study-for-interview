## AOP
spring AOP에서는 인터페이스 유무에 따라 인터페이스 기반의 프록시 생성 시
Dynamic Proxy를 사용하고 인터페이스 기반이 아닐시 CGLib을 사용하는데
spring boot AOP에서는 CGLib을 default로 사용한다고 한다.

핵심로직이 구현된 메소드에 포함된 공통기능 코드를 제거할 수 있다.
- 공통기능을 별도의 클래스에 정의하고,
AOP 기능을 지원하는 컨테이너(우리는 Spring Container)를 활용해서
핵심기능이 실행될 때 공총기능이 같이 실행되도록 하는 것이다.
- 스프링 컨테이너는 AOP의 구현체다.

#### 장점
- 코드의 중복이 제거된다.
- 핵심 로직의 유지보수가 쉬워진다.
- 공통기능의 활성화/비활성화가 가능하다.                
- 개발자는 업무로직의 구현에만 집중할 수 있다.

### JDK Dynamic Proxy
- JDK 에서 제공하는 Dynamic Proxy는 Interface를 기반으로 Proxy를 생성해주는 방식
- 다이나믹 프록시란 런타임에 프록시가 생성되는 것을 의미한다.
- Invocation Handler를 상속받아서 실체를 구현
- 특정 Object에 대해 Reflection을 사용하기 때문에 성능이 조금 떨어지는 크리티컬한 단점
- 리플렉션을 활용한 Proxy 클래스를 제공해주고 있다.
  Java.lang.reflect.Proxy 클래스의 newProxyInstance() 메소드를 이용해 프록시 객체를 생성한다.

### Reflection
- 구체적인 클래스 타입을 알지 못해도 그 클래스의 정보(메서드, 타입, 변수 등등)에 접근할 수 있게 해주는 자바 API
- 자바에서는 JVM이 실행되면 사용자가 작성한 자바 코드가 컴파일러를 거쳐 바이트 코드로 변환되어 static 영역에 저장된다. Reflection API는 이 정보를 활용해 필요한 정보를 가져온다.
- 단점 : Reflection API는 값비싼 API이기 때문에 Dynamic Proxy는 리플렉션을 하는 과정에서 성능이 좀 떨어진다.

### CGLIB (Code Generator Library)
: 클래스의 바이트코드를 조작하여 Proxy 객체를 생성해주는 라이브러리
- Enhancer를 바탕으로 Proxy를 구현하는 방식
