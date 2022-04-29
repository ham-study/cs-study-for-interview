## 객체지향 프로그래밍 (OOP)

- 컴퓨터 프로그래밍 패러다임 중 하나로,
- 데이터들을 상태와 행위를 가진 객체로 만들어서
- 그 객체들 사이을 메세지를 통해 의사소통할 수 있게 로직으로 구현하는 방법입니다.
- 객체 지향적으로 프로그래밍을 하게되면 코드의 재사용성이 높아지고, 유지보수가 편리해집니다.

- 장점
    - 코드 재사용이 용이
      남이 만든 클래스를 가져와서 이용할 수 있고 상속을 통해 확장해서 사용할 수 있다.
    - 유지보수가 쉬움
      절차 지향 프로그래밍에서는 코드를 수정해야할 때 일일이 찾아 수정해야하는 반면 객체 지향 프로그래밍에서는 수정해야 할 부분이 클래스 내부에 멤버 변수혹은 메서드로
      존재하기 때문에 해당 부분만 수정하면 된다.
    - 대형 프로젝트에 적합
      클래스 단위로 모듈화시켜서 개발할 수 있으므로 대형 프로젝트처럼 여러 명, 여러 회사에서 프로젝트를 개발할 때 업무 분담하기 쉽다.

- 단점
    - 처리 속도가 상대적으로 느림
    - 객체가 많으면 용량이 커질 수 있음
    - 설계시 많은 시간과 노력이 필요

### 객체지향의 4가지 특징

- **추상화**  
  추상적인 것 을 구체적으로 모델링 하는 모든 과정
- **캡슐화**  
  객체에 필요한 데이터나 기능(메소드)을 책임이 있는 객체에 그룹화시켜주는 것을 캡슐화(Capsulation)이라 한다.
- **상속**  
  상위 클래스의 기능을 하위 클래스가 사용할 수 있는 개념이다. 상속이 필요한 이유는 여러 객체에서 사용되는 기능을 하나의 클래스로 분리해서 사용할 수 있도록 위함이다. 즉
  중복되는 코드의 재사용성을 위함이다.
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
컴퓨터 프로그래밍 패러다임 중 하나로, **프로그래밍에서 필요한 데이터를 추상화시켜 상태와 행위를 가진 객체를 만들고 그 객체들 간의 유기적인 상호작용을 통해 로직을 구성하는
프로그래밍 방법**

**절차지향**
순차적으로 처리하여 프로그램 전체가 유기적으로 연결되어야 합니다.

**함수형 프로그래밍**
순수 함수를 조합하고 소프트웨어를 만드는 방식 (클로저, 하스켈, 리스프)

## JDK, JRE, JVM

### JDK (Java Development Kit)

- 자바 개발 도구로, JRE + 개발을 위해 필요한 도구(javac, java등)들을 포함한다.
  ![img](https://wikidocs.net/images/page/257/jdk.jpg)

### JRE (Java Runtime Environment)

- 자바 실행환경으로, JVM을 포함하는 단위이다.
- JVM 이 자바 프로그램을 동작시킬 때 필요한 라이브러리 파일들과 기타 파일들을 가지고 있다.
  ![img](https://wikidocs.net/images/page/257/jre.jpg)

### JVM (Java Virtual Machine)

- 자바 가상 머신(Java Virtual Machine)으로,
- 자바 소스코드로부터 만들어지는 자바 바이너리 파일(.class)을 실행할 수 있다.
- 플랫폼에 의존적이다.
- 리눅스의 JVM과 윈도우즈의 JVM은 다르다.
- 컴파일된 바이너리 코드는 어떤 JVM에서도 동작시킬 수 있다.

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fo2kwL%2FbtqSmzWHdHV%2FOeIODqCVTN97ioNDCVjiU0%2Fimg.png)

- JVM의 구조
  : JVM은 크게 4가지로 구분할 수 있습니다.
  클래스 로더가 바이트 코드를 읽어들이면서 JVM은 작동이 됩니다.

- Class Loader
    - JVM 내로 클래스 파일을 로드하고, 링크를 통해 배치하는 작업을 수행하는 모듈입니다.
    - 런타임 시에 동적으로 클래스를 로드합니다.
- Garbage Collector
    - 힙 메모리 영역에 생성된 객체들 중에서 참조되지 않은 객체들을 탐색 후 제거하는 역할을 합니다.
- Execution Engine
    - 클래스 로더를 통해 JVM 내의 Runtime Data Area에 배치된 바이트 코드들을 명렁어 단위로 읽어서 실행합니다.
- Runtime Data Area
    - JVM의 메모리 영역으로 자바 애플리케이션을 실행할 때 사용되는 데이터들을 적재하는 영역
    - 크게 Method Area, Heap Area, Stack Area, PC Register, Native Method Stack으로 나뉩니다.
        - Method Area : 모든 쓰레드가 공유하는 메모리 영역 (Static 변수, 클래스, 인터페이스 등 바이트코드들이 저장)
        - Heap Area : 모든 쓰레드가 공유, new 키워드로 생성된 객체와 배열이 생성되는 영역, Garbage Collector가 참조되지 않는 메모리를 확인하고
          제거하는 영역
        - Stack Area : 메서드 호출 시마다 각각의 스택 프레임(그 메서드만을 위한 공간)이 생성 (매개변수, 지역변수 등이 저장)
        - PC Register : 쓰레드가 시작될 때 생성되며, 생성될 때마다 생성되는 공간으로 쓰레드마다 하나씩 존재합니다.
        - Native method stack : 자바 외 언어로 작성된 네이티브 코드를 위한 메모리 영역

### 컴파일 과정

1. 자바 코드를 작성한다.

2. 자바 컴파일러가 소스코드를 자바 바이트 코드로 변환한다.
    - 자바 바이트 코드 : _JVM 이 읽을 수 있는 코드_. 아직 컴퓨터가 읽을 수 있는 코드가 아님.
    - 바이트 코드의 구성
        - 각 명령어는 _Opcode(1byte) + 추가 피연산자_

3. 컴파일된 바이트 코드를 JVM의 클래스로더에게 전달한다.

4. 클래스 로더는 **동적 로딩(Dynamic Loading)**을 통해 필요한 클래스들을 로딩 및 링크하여
   런타임 데이터 영역(Runtime Data area), 즉 JVM의 메모리에 올립니다.
    - 런타임 데이터 영역(Runtime Data area)
      ![img](https://blog.kakaocdn.net/dn/SDLq7/btriooQgkjm/rbKq3AxnpbkmUNBg69VNr1/img.png)
    - 클래스 로더 세부 동작
        - 로드 : 클래스 파일을 가져와서 JVM의 메모리에 로드합니다.
        - 검증 : 자바 언어 명세(Java Language Specification) 및 JVM 명세에 명시된 대로 구성되어 있는지 검사합니다.
        - 준비 : 클래스가 필요로 하는 메모리를 할당합니다. (필드, 메서드, 인터페이스 등등)
        - 분석 : 클래스의 상수 풀 내 모든 심볼릭 레퍼런스를 다이렉트 레퍼런스로 변경합니다.
        - 초기화 : 클래스 변수들을 적절한 값으로 초기화합니다. (static 필드)

6. 실행엔진(Execution Engine)은 JVM 메모리에 올라온 바이트 코드들을 명령어 단위로 하나씩 가져와서 실행합니다.  
   이때, 실행 엔진은 두가지 방식으로 변경합니다.
    - 실행 엔진 두 가지 방식
        - 인터프리터 방식
            - 바이트 코드 명령어를 하나씩 읽어서 해석하고 실행합니다.
            - 하나하나의 실행은 빠르나, 전체적인 실행 속도가 느리다는 단점을 가집니다.
        - JIT 컴파일러 (Just-In-Time Compiler)
          : 인터프리터의 단점을 보완하기 위해 도입된 방식으로 바이트 코드 전체를 컴파일하여 바이너리 코드로 변경하고 이후에는 해당 메서드를 더이상 인터프리팅 하지 않고,
          바이너리 코드로 직접 실행하는 방식입니다. 하나씩 인터프리팅하여 실행하는 것이 아니라 바이트 코드 전체가 컴파일된 바이너리 코드를 실행하는 것이기 때문에 전체적인
          실행속도는 인터프리팅 방식보다 빠릅니다.

### 컴파일 언어 vs 인터프리터 언어

- [JAVA는 컴파일 방식과 인터프리터 방식이 혼합된 언어이다.](https://jaeseongdev.github.io/development/2021/03/08/JAVA%EB%8A%94_%EC%9D%B8%ED%84%B0%ED%94%84%EB%A6%AC%ED%84%B0_%EB%B0%A9%EC%8B%9D%EA%B3%BC_%EC%BB%B4%ED%8C%8C%EC%9D%BC_%EB%B0%A9%EC%8B%9D%EC%9D%B4_%ED%98%BC%ED%95%A9%EB%90%9C_%EC%96%B8%EC%96%B4%EC%9D%B4%EB%8B%A4/)

### JVM 메모리 구조

1. Method
    - 클래스의 정보 또는 static한 변수의 정보를 저장하는 공간
    - 쓰레드가 공유하는 영역

2. heap
    - 동적 객체를 저장하는 공간
    - 즉, new 연산을 사용하여 만들어진 인스터스를 저장하는 공간
    - GC의 관리 대상이다.
    - 쓰레드가 공유하는 영역

3. Stack
    - 코드의 메소드 내에 있는 지역변수나 매개변수와 같은 임시적인 변수들을 저장하는 공간이다.
    - 원시타입의 값들이 저장된다.
    - ex) Person p = new Person() → p는 Stack에 저장(주소값을 가진다) 실객체는 heap에 저장된다.
    - 쓰레드 별로 새로 생성된다.

4. PC Register
    - 다음에 실행할 데이터가 담겨있는 영역입니다.
    - 쓰레드 별로 새로 생성된다.

5. Native Method Stack
    - 자바 이외의 언어를 저장하는 공간
    - 쓰레드 별로 새로 생성된다.

### Garbage Collector 동작과정

- Mark & Sweep 알고리즘으로 동작합니다.
    1. Stack영역의 모든 데이터들 중 실제로 참조되지 않고 있는 데이터들을 찾아서 Mark합니다.
    2. 그리고 Sweep을 통해 데이터들을 제거하고 경우에 따라서 Compact과정을 수행합니다.

- Heap 영역 내에는 Young Generation 영역과 Old Generation 영역이 있습니다.
- Young Generation 영역은 Edan과 Survivor 영역으로 나뉘게되고 Survior 영역은 1과 2가 있습니다.
- 이 서바이벌 영역에서는 aging이 발생하고, 둘 중 한 곳은 비워져야하는 특징이 있습니다.
- 새로운 객체들은 Edan 영역에 할당이 됩니다. 만약 할당될 곳이 없으면 Minor GC가 발생하게됩니다.
- 그 과정에서 살아남은 객체들은 survivor1 또는 2 중 한곳으로 옮겨가게 됩니다.
- 그 곳에서 객체들은 aging 과정을 거치게되는데 특정한 임계점에 도달하게 되면 Old Generation 영역으로 옮겨가게 됩니다.(promoted)
- 만약 old Generation이 꽉차게 되면 Major GC가 발생하게 됩니다.

[참조](https://www.youtube.com/watch?v=Fe3TVCEJhzo)

### Java8의 큰 특징 + Java11과의 차이점

- String의 메소드(line(), repeat(), strip() 등)이 추가되었다.
- GC 성능이 개선되었다.

### Java 직렬화

: 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte) 형태로
데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 아울러서 이야기

- Serializable 인터페이스를 구현한 후에는 위와 같이 serialVersionUID라는 값을 지정해 주는 것을 권장
- 반드시 static final long으로 선언해야 하며, 변수명도 serialVersionUID로 선언해 주어야 자바에서 인식을 할 수 있습니다.
- serialVersionUID은 아무런 값이나 지정해주면 됩니다.

---

### 접근제어자

: 변수, 메서드, 생성자 등에 대한 접근 권한을 설정하는 것이다.

사용하는 이유 : 외부에서 데이터를 함부로 수정 및 조회를 할 수 없도록

private : 같은 클래스까지 default : 같은 패키지까지 protected : 패키지가 다르더라도 상속관계인 경우 가능 public : 모두 허용

### 클래스, 객체, 인스턴스 차이

클래스 vs 객체

- 클래스는 ‘설계도’, 객체는 ‘설계도로 구현한 모든 대상’을 의미한다.

객체 vs 인스턴스

- 클래스의 타입으로 선언되었을 때 객체라고 부르고, 그 객체가 메모리에 할당되어 실제 사용될 때 인스턴스라고 부른다.
- 엄격하게 객체와 인스턴스를 나누는것은 힘들다.

### Overloading vs Overriding

- 메소드에 다형성을 적용하여 같은 이름이지만 매개변수를 달리하여 여러개의 메소드를 만드는 것을 오버로딩이라고 하며, 상속 받은 메소드를 재정의하는 것을 오버라이딩이라고 한다.

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
Interface와 Abstract Class는 상속(extends)받거나, 구현(implements)하는 Class가 Interface나 Abstract Class 안에
있는 **Abstract Method를 구현**하도록 강제하는 공통점을 가지고 있다.

**차이점**
인터페이스는 여래개를 구현할 수 있는 반면, 추상 클래스는 여러개를 받아오지 못한다. 상속은 슈퍼클래의 기능을 이용하거나 확장하기 위해서 사용되고, 다중상속의 모호성 때문에 하나만
상속받을 수 있다.

### Checked Exception vs UnChecked Exception

**예외란?**  
예외(Exception)란 입력 값에 대한 처리가 불가능하거나, 프로그램 실행 중에 참조된 값이 잘못된 경우 등 정상적인 프로그램의 흐름을 어긋나는 것

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

---

### static

Static 키워드를 통해 생성된 정적 멤버들은 Heap영역이 아닌 Static영역에 할당됩니다.

**장점**

- 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있다.

**단점**

- Garbage Collector의 관리 영역 밖에 존재하기에 Static영역에 있는 멤버들은 프로그램의 종료시까지 메모리가 할당된 채로 존재하게 됩니다. 그렇기에 Static을
  너무 남발하게 되면 만들고자 하는 시스템 성능에 악영향을 줄 수 있습니다.

정적 메소드는 클래스가 메모리에 올라갈 때 정적 메소드가 자동적으로 생성됩니다. 그렇기에 정적 메소드는 인스턴스를 생성하지 않아도 호출을 할 수 있습니다. 정적 메소드는 유틸리티
함수를 만드는데 유용하게 사용됩니다.

### final

final 필드는 초기값이 저장되면 최종적인 값이 되어 프로그램 실행 도중에 수정을 할 수 없습니다.

**final 필드**

```java
final int number=1; //final 타입 필드 [= 초기값];
```

**final 객체**

```java
class Company {

    String name = "회사명";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Final_ex {

    public static void main(String[] args) {
        final Company company = new Company();
        //company = new Company(); //객체를 한번 생성했다면 재생성 불가능
        company.setName("ex회사"); //클래스의 필드는 변경가능
    }
}
```

- 객체 변수에 final로 선언하면 그 변수에 다른 참조 값을 지정할 수 없습니다.
- 한번 생성된 final 객체는 같은 타입으로 재생성이 불가능합니다.
- 객체자체는 변경이 불가능하지만 객체 내부 변수는 변경 가능합니다.

**final 클래스**

```java
//final 클래스
final class Company {

    String name = "회사명";
}

//상속 불가능
class A_Company extends Company {

}
```

- 클래스에 final을 사용하게되면 그 클래스는 최종상태가 되어 더이상 상속이 불가능합니다.
- final 클래스여도 필드는 Setter함수를 통하여 변경은 가능합니다.

**final 메소드**

```java
class Company {

    String name = "회사명";

    public final void print() {
        System.out.println("회사 이름은 :" + name + " 입니다.");
    }
}

class A_Company extends Company {

    String name = "a회사";

    //메서드 오버라이드 불가능
    public void print() {

    }
}
```

**메서드의 인자값에 final을 사용하는 경우**

```java
class Company {

    String name = "회사명";

    public void setName(final String name) {
        //name = "ex회사2"; //인자값으로 받은 final변수는 변경 불가능
        this.name = name;
    }
}

public class Final_ex {

    public static void main(String[] args) {
        final Company company = new Company();
        company.setName("ex회사");
    }
}
```

### generic

: 제네릭(Generic)은 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 타입이 지정되는 것을 의미

**장점**

1. 제네릭을 사용하면 잘못된 타입이 들어올 수 있는 것을 컴파일 단계에서 방지할 수 있다.
2. 클래스 외부에서 타입을 지정해주기 때문에 따로 타입을 체크하고 변환해줄 필요가 없다. 즉, 관리하기가 편하다.
3. 비슷한 기능을 지원하는 경우 코드의 재사용성이 높아진다.

| 타입  | 설명      |
|-----|---------|
| T   | Type    |
| E   | Element |
| K   | Key     |
| V   | Value   |
| N   | Number  |

### stream, lambda

자바 8부터 지원하는 기능

**특징**

1. 데이터를 변경하지 않는다.
2. 일회용이다.
3. 작업을 내부반복으로 처리한다.

**구조**

1. Stream 생성
2. 중개 연산
3. 최종 연산

### Reflection & Dynamic Proxy

**Reflection**  
: 구체적인 클래스 타입을 알지 못해서 그 클래스의 메소드와 타입과 변수들을 접근할 수 있도록 해주는 자바 API입니다.

- 사용되는 곳
  : JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 프로그램에서 사용

**Dynamic Proxy**
: 런타임 시점에(컴파일 시점이 아닌) 특정 인터페이스들을 구현하는 클래스 혹은 인스턴스를 만드는 기술

## 예상질문

1. 프로젝트에서 자바 언어를 사용하셨던데 이유가 있나요?

2. OOP가 무엇인가요?

3. 객체지향적이다라고 하셨는데 객체지향적으로 프로그래밍을 하려면 어떻게 해야하나요?

4. 객체지향적인 프로그램 설계를 위해서 고민했던 경험이 있나요?

5. 프로그래밍의 패러다임 중 절차지향 프로그래밍과 객체지향 프로그래밍의 차이를 알려주세요.

6. 프로그래밍의 패러다임 중 함수형 프로그래밍에 대해서 설명해주세요.

7. java는 컴파일 과정이 어떻게 되나요?

8. JVM과 JRE에 대해서 설명해주세요.

9. JVM의 각 영역에 설명해주세요.

10. java는 call by value인가요? call by reference이가요?
    - java는 call by value입니다.

11. java가 Primitive type와 Reference type으로 나뉜 이유가 무엇인가요?
    - null을 사용하거나 Generic타입을 사용해야하는 경우 Reference Type을 사용하는 것이 좋습니다.
    - 하지만, 이런경우가 아닌 경우 Primitive type을 쓰는 것이 좋습니다.

12. java Object 클래스에 대해서 설명해주세요.
    - Java Object 클래스는 최상위 클래스로 필드는 없고 메소드로만 이루어진 클래스입니다.
    - 모든 클래스들이 이 Object 클래스를 상속받고 있어 모든 클래스에서 이 Object 메소드를 이용할 수 있습니다.
    - Object 클래스의 대표적인 메소드로는 equals(), hashcode(), toString()이 있습니다.
    - equals()는 객체가 서로 같은지 판별하여 true와 false 중 하나를 반환하는 메소드입니다.
    - 처음에는 instanceOf를 사용해 타입을 검사하고 다른 경우 바로 false 반환합니다.
    - 만약 같은 타입일 경우 두 객체가 같은지 비교하게 됩니다.
    - object 클래스의 경우 처음에는 주소를 통해 객체를 비교하도록 되어있지만 재정의를 통해 객체 내부의 값을 비교하도록 바꿀 수 있습니다.
    - hashcode()는 객체를 식별가능하도록 객체가 저장된 메모리의 주소값을 활용하여 해시 함수를 통해 만든 해시 코드입니다.
    - HashSet, HashMap, Hashtable에서 사용되고, hashCode와 내부의 값이 동등하다면 같은 객체로 봅니다.
    -
13. String의 equals()는 어떻게 구현되어있나요?
    - 먼저 동일성을 판단합니다. 즉 주소값을 비교해봅니다.
    - 만일 다르다면 같은 String 타입이 들어왔는지 확인합니다.
    - 그 후 같은 타입이라면 동등성을 비교하게됩니다.

14. ==과 equals()의 차이점에 대해서 설명해주세요.
    - equals 연산자는 재정의하지 않으면 내부적으로 == 연산자와 같은 로직을 수행하므로 차이가 없다. 따라서 equals 연산자는 각 객체의 특성에 맞게 재정의를 해야
      동등성의 기능을 수행한다.

15. equals와 hashcode를 재정의해야하는 이유에 대해서 설명해주세요.
    - hashcode()를 재정의 하지 않으면 같은 값 객체라도 해시값이 다를 수 있다.
    - 따라서 HashTable에서 해당 객체가 저장된 버킷을 찾을 수 없다.
    - equals()를 재정의하지 않으면 hashcode()가 만든 해시값을 이용해 객체가 저장된 버킷을 찾을 수는 있지만 해당 객체가
      자신과 같은 객체인지 값을 비교할 수 없기 때문에 null을 리턴하게 된다.

16. String과 StringBuffer, StringBuilder의 차이점에 대해서 설명해주세요.
    - String은 Immutable하고, StringBuffer와 StringBuilder는 Immutable하지 않습니다.
      - 즉 String은 변하지 않는 객체이고, StringBuffer와 StringBuilder는 잘 변하지 않는 객체입니다.
      - String 객체는 한번 생성되면 할당된 공간이 변하지 않습니다.
      - 즉, +연산 또는 concat()을 사용해 뒤에 문자열을 덧붙이게 된다면 새로 String 객체가 생성됩니다.
      - 문자열이 변하는 것이 아니라 Heap영역에 새로운 객체가 생성되게 되고 이를 참조하는 방식입니다.
      - 기존의 객체는 GC에 의해서 수거의 대상이됩니다.
      - 따라서, 많은 문자열 연산에서는 String이 불리합니다.
    - StringBuffer와 StringBuilder는 동일한 문자열 객체 내부에서 문자열을 변경할 수 있어 ,
      String에 비해서 많은 문자열 연산을 수행하기에 적합합니다.
    - StringBuffer와 Stringbuilder는 같은 메소드를 제공합니다.
    - 하지만 StringBuffer의 경우 멀티 스레드 환경에서 적합하고,
    - Stringbuilder의 경우 단일 스레드 환경에서 적합합니다.

17. Immutable Object란 무엇인가요?
18. String a = "" vs String a = new String("")의 차이점은 무엇인가요?
    - ""의 경우 새롭게 주소 공간을 생성하지 않는다.
    - new의 경우 새롭게 주소 공간을 생성합니다.
    - ""의 경우 String constant pool이란 곳에 저장,
    - new의 경우 heap 영역에 저장됩니다.
    
19. ArrayList와 LinkedList의 차이점은 무엇인가요?
    - ArrayList의 경우 데이터의 순서가 보장이 되지 않습니다.
    - 하지만 LinkedList의 경우 데이터의 순서가 보장이 됩니다.
    - 그리고 수정, 삭제가 빈번한 경우 LinkedList를 이용하는 것이 더 효율적입니다.
    - LinkedList의 경우 데이터가 앞뒤 포인터를 가지고 있어 해당 데이터의 앞뒤 포인터를 찾아 수정해주면 되기 때문입니다.
    - 만약 ArrayList의 경우 수정, 삭제가 일어난다면 값이 삽입된다면 인덱스를 하나씩 밀어줘야해 시간이 오래걸립니다.
    
20. HashTable와 HashMap와 LinkedHashMap와 TreeMap의 차이점에 대해서 설명해주세요.
    - HashMap은 동기화 지원 X, HashTable 동기화 지원 O.
    - HashMap은 key와 value 모두 null 허용, 순서 보장 X
    - 하지만 동기화 지원을 위해서라면 비교적 최근에 등장한 ConcurrentHashMap을 사용하는 것을 권장하는 것으로 알고 있습니다.
    - 
21. HashMap와 ConcurrentHashMap의 차이점에 대해서 설명해주세요.
