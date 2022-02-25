### 객체지향의 4가지 특징
- **추상화**  
  추상적인 것 을 구체적으로 모델링 하는 모든 과정
- **캡슐화**  
  객체에 필요한 데이터나 기능(메소드)을 책임이 있는 객체에 그룹화시켜주는 것을 캡슐화(Capsulation)이라 한다.
- **상속**  
  상위 클래스의 기능을 하위 클래스가 사용할 수 있는 개념이다. 상속이 필요한 이유는 여러 객체에서 사용되는 기능을 하나의 클래스로 분리해서 사용할 수 있도록 위함이다. 즉 중복되는 코드의 재사용성을 위함이다.
- **다형성**  
  같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 동작하도록 구현되는것을 말한다.

### 객체지향의 5원칙 (SOLID)
- SRP(Single Responsibility Principle) - 단일 책임 원칙
- OCP(Open Closed Principle) - 개방 폐쇄 원칙
- LSP(Listov Listov Substitution Priciple) - 리스코프 치환 원칙
- ISP(Interface Segregation Principle) - 인터페이스 분리 원칙
- DIP(Dependency Inversion Principle) - 의존 역전 원칙

### 객체지향 vs 절차지향 vs 함수형 프로그래밍
**객체지향**  
컴퓨터 프로그래밍 패러다임 중 하나로, **프로그래밍에서 필요한 데이터를 추상화시켜 상태와 행위를 가진 객체를 만들고
그 객체들 간의 유기적인 상호작용을 통해 로직을 구성하는 프로그래밍 방법**

**절차지향**  


**함수형 프로그래밍**

---

### 접근제어자
: 변수, 메서드, 생성자 등에 대한 접근 권한을 설정하는 것이다.

사용하는 이유 : 외부에서 데이터를 함부로 수정 및 조회를 할 수 없도록

private : 같은 클래스까지
default : 같은 패키지까지
protected : 패키지가 다르더라도 상속관계인 경우 가능
public : 모두 허용

### 클래스, 객체, 인스턴스 차이
클래스 vs 객체
- 클래스는 ‘설계도’, 객체는 ‘설계도로 구현한 모든 대상’을 의미한다.

객체 vs 인스턴스
- 클래스의 타입으로 선언되었을 때 객체라고 부르고, 그 객체가 메모리에 할당되어 실제 사용될 때 인스턴스라고 부른다.
- 엄격하게 객체와 인스턴스를 나누는것은 힘들다.

### Overloading vs Overriding
- 메소드에 다형성을 적용하여 같은 이름이지만 매개변수를 달리하여 여러개의 메소드를 만드는 것을 오버로딩이라고 하며,
상속 받은 메소드를 재정의하는 것을 오버라이딩이라고 한다.

---

### Primitive type vs Reference type
프리미티브 타입(Primitive Type)은 값을 저장한다.  
레퍼런스 타입(Reference Type)은 주소를 저장한다.

**기본형 타입(Primitive Type)**
- int, long, float, double, char, boolean, short, byte
- 기본값이 있어 null이 존재하지 않는다.
- **값**이 저장되어**스택 메모리(Stack) 영역**에 저장된다.
- 만약 컴파일 시점에 담을 수 있는 크기를 벗어나면 에러를 발생시키는 컴파일 에러가 발생한다.

![img](http://img.c4learn.com/2012/03/Primitive-Data-Types-in-Java-Programming-Language.png)

**참조형 타입(Reference Type)**
- Array, Enum, Class, Interface
- 빈 객체를 의미하는 null이 존재한다.
- 값이 저장되어 있는 곳의 **주소값**을 저장하는 공간으로 **힙(Heap) 메모리**에 저장된다.
- NullPointerException이 발생하기도 한다.

### Call by Reference vs Call by Value
**Call By Reference**
- 함수가 호출될 때, 메모리 공간 안에서는 함수를 위한 별도의 임시 공간이 생성된다.
- call-by-reference 참조에 의한 호출방식은 함수 호출시 인자로 전달되는 변수의 레퍼런스를 전달한다.

**Call By Value**
- 값에 의한 호출방식은 함수 호출시 전달되는 변수의 값을 복사하여 함수의 인자로 전달한다.
- 복사된 인자는 함수 안에서 지역적으로 사용되는 local value의 특성을 가진다.
- Java의 경우 함수에 전달되는 인자의 데이터 타입에 따라서 (원시자료형 / 참조자료형) 함수 호출 방식이 달라진다.

### Wrapper Class
**Wrapper Class (객체)**
- **프리미티브 타입**으로 표현할 수 있는 데이터를 **객체로 만들어야하는 경우**에 사용하기 위해 만든 기능
- 두 타입간 변환을 `Boxing` 과 `Unboxing`이라고 한다.
- Wrapper클래스는 null값을 처리할 수 있기 때문에 SQL과 연동 시에 유용하다.

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcfumdY%2Fbtq1JWpET04%2FKCZJkkOhSxNKmhpfNYRd3K%2Fimg.jpg)

### interface vs abstract class
**공통점**
Interface와 Abstract Class는 상속(extends)받거나, 구현(implements)하는 Class가
Interface나 Abstract Class 안에 있는 **Abstract Method를 구현**하도록 강제하는 공통점을 가지고 있다.

**차이점**
인터페이스는 여래개를 구현할 수 있는 반면, 추상 클래스는 여러개를 받아오지 못한다.
상속은 슈퍼클래의 기능을 이용하거나 확장하기 위해서 사용되고, 다중상속의 모호성 때문에 하나만 상속받을 수 있다.

### Checked Exception vs UnChecked Exception
**예외란?**  
예외(Exception)란 입력 값에 대한 처리가 불가능하거나, 프로그램 실행 중에 참조된 값이 잘못된 경우 등 
정상적인 프로그램의 흐름을 어긋나는 것

![img](https://madplay.github.io/img/post/2019-03-02-java-checked-unchecked-exceptions-1.png)

**Checked Exception**
- 컴파일 단계에서 나타나는 예외입니다.
- 체크 예외는 RuntimeException의 하위 클래스가 아니면서 Exception 클래스의 하위 클래스들입니다.
- 반드시 에러 처리를 해야하는 특징(try/catch or throw)을 가지고 있습니다.

**Unchecked Exception**
- RuntimeException의 하위 클래스들을 의미
- 체크 예외와는 달리 에러 처리를 강제하지 않습니다.
- 말 그대로 실행 중에(runtime) 발생할 수 있는 예외를 의미합니다.

**해결방법**
- 예외 복구 : 예외 상황을 파악하고 문제를 해결해서 정상 상태로 돌려놓는 방법
- 예외 처리 회피 : 예외 처리를 직접 담당하지 않고 호출한 쪽으로 던져 회피하는 방법
- 예외 전환 : 예외 회피와 비슷하게 메서드 밖으로 예외를 던지지만, 그냥 던지지 않고 적절한 예외로 전환해서 넘기는 방법
