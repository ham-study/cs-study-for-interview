

## 접근 제어자
- private : 본인만 접근 가능
- default : 같은 패키지 내의 클래스에서 접근 가능
- protected : 상속받은 클래스 또는 같은 패키지 내의 클래스에서 접근 가능
- public : 모두가 접근 가능

## 클래스, 객체, 인스턴스 차이
클래스는 객체를 추상화 하여 메서드, 속성과 같은 공통된 특징을 정의한 집합이며, 객체는 구현할 대상으로 클래스를 토대로 생성된 실체이다. oop의 관점에서 클래스 타입으로 선언된 객체가 메모리에 할당되어 실제 사용될 때 인스턴스라고 부른다.

## Overloading vs Overriding
- 오버라이딩 : (재정의)
같은 메서드 이름, 같은 인자 리스트로 하위클래스에서 상속받은 상위 클래스의 메서드를 재정의 하는 기능을 말한다.
상위 클래스 타입의 객체 참조 변수를 사용하더라도 하위 클래스에서 오버라이딩(재정의) 한 메서드가 호출된다.
static 메소드는 재정의 불가하다.
- 오버 로딩 : (중복정의) 
같은 메서드 이름, 다른 인자 리스트로 다수의 메서드를 중복 정의하는 기능을 말한다. 메서드 오버로딩과 생성자 오버로딩이 있다. 



## 깊은 복사 vs 얕은 복사
깊은 복사(Deep Copy)는 '실제 값'을 새로운 메모리 공간에 복사하는 것을 의미하며,
얕은 복사(Shallow Copy)는 '주소 값'을 복사한다는 의미이다.

얕은 복사인 경우 복사된 객체의 인스턴스 변수는 원본 객체의 인스턴스 변수와 같은 메모리 주소를 참조한다. 따라서, 해당 메모리 주소의 값이 변경되면 원본 객체의 인스턴스 변수 값은 같이 변경된다.

## Primitive type vs Reference type

두가지 모두 선언(declaration)과 할당(assignment)의 과정을 거치지만 할당에서 차이점이 있다.
  - 선언 : 변수와 주소값을 매칭, 할당 : 변수의 주소값에 값을 할당.
  - Primitive Type은 실제 값을 그대로 할당하고, Reference Type은 값이 저장된 주소값(참조위치)을 참조하는 타입이다. 
  - 할당연산자(=) 을 통해 복사할 경우 기본 타입은 깊은 복사, 참조 타입은 얕은 복사가 이루어진다. 

값 변경시, 
- Primitive Type은 공간을 확보하여 새 데이터를 공간에 할당하고, 변수의 값이 가리키는 주소값을 바꿔준다. 
- Reference Type은 객체의 주소값은 바뀌지 않고 내부의 데이터가 변경된다.

### Primitive type (기본형 타입)
- JAVA에서는 총 8가지의 Primitive type을 미리 정의하고 제공
  - boolean, byte, short, int, long, float, double
- OS에 따라 자료형의 길이가 변하지 않는다.
- 비객체 타입이고, 기본값이 있기 때문에 null 값을 가질 수 없다.
  - Primitive type에 Null을 넣고 싶다면 Wrapper Class를 활용
- 실제 값을 저장하는 공간으로 스택(Stack) 메모리에 저장된다.
- 컴파일 에러가 발생한다. 

### Reference type (참조형 타입)
- 기본형 타입을 제외한 타입들이 모두 참조형 타입(Reference type)이다.
- JAVA에서 최상인 java.lang.Object클래스를 상속하는 모든 클래스들을 말한다.
- 클래스 타입(class type) , 인터페이스 타입(interface type) , 배열 타입(array type) , 열거 타입(enum type) 이 있다.
- 빈 객체를 의미하는 Null이 존재
- 문법상으로는 에러가 없지만 실행시켰을 때 에러가 나는 런타임 에러가 발생
- 실제 객체는 힙 영역에 저장되며 참조 타입 변수는 스택 영역에 실제 객체들의 주소를 저장한다. 

### String Class

- 불변(immutable)하는 객체이다.
  - 객체 내용 변경시 새로운 메모리 영역이 할당된다.
  - 자열 추가,수정,삭제 등의 연산이 빈번하게 발생하는 알고리즘이면 힙 메모리(Heap)에 많은 임시 가비지(Garbage)가 생성
- new 연산자를 통해 문자열 객체를 생성하는 경우 메모리의 Heap 영역에 할당되고 두 번째 방법인 리터럴을 이용한 경우에는 Heap 영역 내부의 String Constant Pool이라는 영역에 할당된다.
  - String Constant Pool에서는 값이 같다면 동일 주소를 참조한다.
- String 객체간의 비교는 .equals() 메소드를 사용

#### StringBuffer / StringBuilder
- StringBuffer/StringBuilder 는 가변성을 가진다.
   - 동일 객체내에서 문자열을 변경
- StringBuffer는 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전
  - StringBuilder는 동기화 처리 과정이 없기 때문에 단일쓰레드에서의 성능은 StringBuffer 보다 뛰어나다.
  - String도 불변성을 가지기 때문에 멀티쓰레드 환경에서의 안정
  
### 비교
- 원시타입은 null을 담을 수 없지만, 참조 타입은 가능하다.
- 원시타입은 제너릭 타입에서 사용할 수 없지만, 참조 타입은 가능하다.
- 참조타입은 값을 필요로 할 때마다 언박싱 과정을 거쳐야 하니 원시타입과 비교해서 접근 속도가 느려지게 된다.
  - 예외적으로 엄청 큰 숫자를 복사해야 한다면, 참조값만 넘길 수 있는 참조타입이 좋을 수 도 있다.
- 원시 타입보다 참조 타입이 사용하는 메모리양이 압도적으로 높다.


## Call by value vs Call by reference
함수 호출 방법은 크게 두가지가 있다.

Call by value(값에 의한 호출)은 인자로 받은 값을 복사하여 처리를 하고 Call by reference(참조에 의한 호출)는 인자로 받은 값의 주소를 참조하여 직접 값에 영향을 준다. Call by value에서 복사된 인자는 함수 안에서 지역적으로 사용하는 변수이다.

- Call by value(값에 의한 호출)
장점 : 복사하여 처리하기 때문에 안전하다. 원래의 값이 보존이 된다.
단점 : 복사를 하기 때문에 메모리 사용량이 늘어난다.

- Call by reference(참조에 의한 호출)
장점 : 복사하지 않고 직접 참조를 하기에 빠르다.
단점 : 직접 참조를 하기에 원래 값이 영향을 받는다.

### equals와 == 연산의 차이
== 연산자는 비교하고자 하는 두개의 대상의 주소값을 비교하는데 반해 equals 메소드는 비교하고자 하는 두개의 대상의 값 자체를 비교한다.

즉, 참조 타입의 객체를 비교할 때 값은 같아도 힙 메모리 역역의 참조 주소값이 다르므로  ==에서는 false가 된다. 기본 타입일 경우는 같은 값이면 참조 주소가 동일하므로 true가 나온다.

### 자바에서는?
Java 의 경우 항상 call by value 이다. Java는 객체의 값에 직접적인 접근을 제공하지 않고, 넘겨 받은 객체의 값을 복사하여 메소드의 새로운 지역 변수에 저장하여 사용한다. 즉, 객체가 참조 타입일 경우라도 그 객체가 힙 영역에서 가리키고 있는 참조 주소를 복사한다. 즉 그 주소 값을 통해 접근하여 값을 수정하는 것은 가능하다.

#### Wrapper 클래스인 경우
자바에서 wrapper class 는 모두 불변이기 때문에 heap에 있는 같은 객체를 참조하고 있는 경우라 하더라도 새로운 연산이 적용되면 새로운 인스턴스가 할당 되기 때문에 원본 객체를 변경할 수 없다. (메소드 내의 지역 변수도 복사된 값이기 때문)

## Wrapper Class
기본 자료형의 데이터를 인스턴스(객체)로 만들기 위해 사용(포장) 하는 클래스

### Boxing, Unboxing
Boxing(박싱)은 원시 타입을 참조 타입(Wrapper Class)으로 변환 시키는 것을 말하고, Unboxing(언박싱)은 참조 타입(Wrapper Class)을 원시 타입으로 변환 시키는 것을 말한다.
- 자바 1.5부터 자동으로 Boxing / Unboxing 해준다.
  - Auto Boxing / Unboxing 기능은 메모리 누수의 원인이 될 수 있고  추가 연산 작업이 발생한다.
- autoboxing은 내부적으로 컴파일러가 valueOf() 메소드를 호출하고, **새로운 Integer 객체를 생성해서**, 이를 return 한다.


## interface vs abstract class

#### 추상 클래스는
필요한 대부분의 기능을 구현하고 자식 클래스에서 재정의해야하는 부분을 추상 메서드로 선언하여 기능을 확장하는데 목적이 있다. 추상 클래스 자체는 객체로서 생성될 수 없고 하위 클래스에서 추상 메서드를 구현하므로써 생성할 수 있다. 논리적인 측면에서 상속 관계는 상위 클래스와 하위 클래스의 계층 관계가 명확해야 한다.(is-a) 

#### 인터페이스는
인터페이스는 구현 객체에서 같은 동작을 보장하기 위한 목적으로 주로 사용할수 있다. 인터페이스는 객체로서 생성될 수 없으며 추상 메세드로 구성되지만 자바 8부터는 default메서드가 추가되서 기본 동작을 구현할 수 있다.

+) 자바 8부터 인터페이스는 static 메서드도 지원한다. 클래스 명으로 메소드를 호출하고 재정의가 불가능하다는 특징이 있다.
default 메서드는 implements한 클래스에서 재정의가 가능하다.

+) 인터페이스 다중 상속인 경우에 동일한 메소드 명의 default 메서드가 겹친다면 하위 클래스는 반드시 해당 메소드를 오버라이딩 해야 한다. 중복 메서드가 없을 경우 오버라이딩을 하지 않아도 컴파일 에러가 나지 않는다.

#### 비교
- 자바에서 추상 클래스에서 다중 상속은 지원되지 않지만 인터페이스는 다중 상속이 가능하다.
- 추상 클래스와 인터페이스 둘 다 가지고 있는 추상 메서드를 구현하도록 강제하고, 인스턴스화가 불가능하다.
- 인터페이스에서 모든 변수는 public static final, 모든 메소드는 public abstract이다. 하지만 추상 클래스에서는 static이나 final이 아닌 필드를 가질 수 있고, public, protected, private 모두 가질 수 있다.

## Exeption
### Error 과 Exception
- Error:
java.lang.Error 클래스의 서브 클래스들이다. 에러는 메모리가 부족이나 스택오버플로우 등과 같이 시스템이 비정상적인 상황인 경우에 사용한다. 주로 JVM에서 발생시키기 때문에 애플리케이션 코드에서 처리는 하지 않아도 된다.

- Exception :
java.lang.Exception 클래스의 서브 클래스들은 Error와 달리 애플리케이션 코드에서 예외가 발생하였을 경우에 사용된다.

### Checked Exception vs UnChecked Exception

- checked exception은 컴파일 단계에서 확인되는 예외로서 IOException, SQLException등이 포함되고(RuntimeException 클래스를 상속하지 않은 Exception 클래스) 코드상으로 예외처리를 작성해야한다. 또한, 예외 발생시 트랜잭션이 rollback되지않는다 .

- unchecked exception은 런타임시 확인되는 예외로서 RuntimeException을 상속 받는다. NullPointerException, IllegalArgumentException등이 포함된다. 주로 개발자들에 의해 실수로 발생하기 때문에 코드상에서 명시적으로 예외를 처리하지 않아도 실행가능하고 예외 발생시 트랜잭션시 rollback된다.

+)  try catch로 처리가 명확하게 가능하면 exception 클래스를 확장해 처리하는게 좋지만, 일반적으로 실행시 예외를 처리할 수 있는 경우에는 RuntimeException 클래스를 확장해 Unchecked Exception을 사용하여 명확하게 메세지를 남기는 것이 더 좋은 방법일 수 있다.

## hashcode() & equals()
Java의 모든 객체는 Object 클래스에 정의된 equals와 hashCode 함수를 상속받고 있다.

### equals()
boolean equals(Object obj)로 정의된 equals 메소드는 2개의 객체의 동일성을 비교하는 메서드로 == 연산을 사용하여 객체의 주소 값을 비교한다.
equals()는 일반적으로 Overriding될 수 있고 대표적인 예가 String 클래스에서 재정의 된 equals() 이다.

### hashcode()
public native int hashCode()로 정의된 hashCode 메소드는 객체의 고유한 주소 값을 해싱하여 정수로 표현하는 메서드를 의미한다.

+) native 키워드는 메소드가 JNI(Java Native Interface)라는 native code를 이용해 구현되었음을 의미한다. native는 메소드에만 적용가능한 제어자로, C or C++ 등 Java가 아닌 언어로 구현된 부분을 JNI를 통해 Java에서 이용하고자 할 때 사용된다.

### equals와 hashCode의 관계
동일한 객체는 동일한 메모리 주소를 갖는다는 것을 의미하므로, 동일한 객체는 동일한 해시코드를 가져야 한다. 따라서 equals() 메소드를 오버라이드 한다면, hashCode() 메소드도 오버라이드 되어야 한다.

- 두 객체가 equals()에 의해 동일하다면, 두 객체의 hashCode() 값도 일치해야 한다.
- hashCode(obj1) == hashCode(obj2) 라고 obj1.equals(obj2) == True일 필요는 없다.
- 만약 ORM을(ex. JPA) 사용하고 있는 경우라면, hashCode와 equals를 오버라이드 하는 메소드 내부에서 Getter를 사용하기를 권장
  - ORM에 의해 fields가 Lazy Loaded되어, getter를 부르기 전에는 사용이 불가능할 수 있기 때문
  
#### 같이 오버라이딩 해야 하는 이유
Collection(HashMap, HashSet, HashTable)은 객체의 동등성을 비교할 때, hashCode 메서드의 리턴 값이 우선 일치하고 equals 메서드의 리턴 값이 true여야 논리적으로 같은 객체라고 판단한다. (hashCode 리턴값이 다를 경우 다른 객체라 판단한다.)

하지만, 해시 테이블에서 해시 충돌이 발생하면 해당 버킷(Bucket)에 LinkedList 형태로 객체를 추가하기 때문에 다른 객체라도 같은 해시코드 값을 가질 수 있다.

또한 collection에서 key값을 사용해 데이터를 insert할 때 hashcode()가 호출되는데, hashcode()를 overriding하지 않았다면 같은 내용의 객체가 서로 다른 버킷에 할당될 가능성이 있다. 즉, 같은 내용의 객체가 중복 저장되는 것이다.

+) Objects.hash 메서드는 hashCode 메서드를 재정의하기 위해 간편히 사용할 수 있는 메서드이지만 속도가 느리다. 인자를 담기 위한 배열이 만들어지고 인자 중 기본 타입이 있다면 박싱과 언박싱도 거쳐야 하기 때문이다. 성능에 민감한 프로그램인 경우 직접 재정의해주는 게 좋다.


## Thread Safe & Syncronized

## 자바스레드 구현 방법
1. Runnable 인터페이스 구현
	- 해당 클래스를 인스턴스화해서 Thread 생성자에 argument로 넘겨줘야 한다.
    - 따로 오버라이딩 하지 않고 Runnable 인터페이스에서 구현한 run()을 사용할 수 있다.
  
2. Thread 클래스 상속
	- 상속받은 클래스 자체를 스레드로 사용할 수 있다.
둘다 run() 메소드를 오버라이딩 한다.

#### run() 과 start()

Java에는 콜 스택(call stack)은 실질적인 명령어들을 담고 있는 메모리로, 하나씩 꺼내서 실행시키는 역할을 한다. 즉, 스레드를 이용한다는 건, JVM이 다수의 콜 스택을 번갈아가며 명령어를 실행시키는 것이다.

run() 메소드를 이용한다는 것은 main()의 콜 스택 하나만 이용하는 것으로 스레드 활용이 아니다, 
start() 메소드를 호출하면, JVM은 알아서 스레드를 위한 콜 스택을 새로 만들어주고 context switching을 통해 스레드답게 동작하도록 해준다.
-> start()는 스레드가 작업을 실행하는데 필요한 콜 스택을 생성한 다음 run()을 호출해서 그 스택 안에 run()을 저장할 수 있도록 해준다.

### Syncronized (동기화)

Synchronized는 동기화를 위한 키워드로서 lock을 걸어 여러 스레드가 대상에 동시에 접근하는 상황을 방지한다.
임계영역을 지정하고, 임계영역을 가지고 있는 lock을 단 하나의 스레드에게만 허용한다.

- Synchronized method는 함수와 자신이 포함된 객체에 lock을 건다.
- Synchornized block은 필요한 부분만 동기화처리를 해줄 수 있다.
- 부모 클래스의 메소드에 synchronized 키워드로 임계영역을 설정해주면, 서로 다른 두 자식 객체가 오버라이딩 한 동기화된 메소드를 사용할 수 있다.

#### wait()과 notify()
- wait() : 스레드가 lock을 가지고 있으면, lock 권한을 반납하고 대기하게 한다.
- notify() : 대기 상태인 스레드 중 하나를 깨운다.
- notifyAll() : WAIT SET에 있는 모든 Thread 가 깨어난다.

위 메소드는 동기화 된 영역(임계 영역)내에서 사용되어야 한다.


