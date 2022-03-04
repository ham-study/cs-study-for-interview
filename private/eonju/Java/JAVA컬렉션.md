## JAVA Collection?

: 컬렉션 프레임워크란, **데이터를 쉽고 효과적으로 처리하기 위해 표준화된 방법을 제공하는 클래스의 집합**입니다.

컬렉션 프레임워크는 크게 3가지의 유형으로 나뉩니다.

- List
    - 특징 : 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다.
    - 구현 클래스 : ArrayList, LinkedList, Stack ...
- Set
    - 특징 : 순서를 유지하지 않는 데이터의 집합. 데이터의 중복을 허용하지 않는다.
    - 구현 클래스 : HashSet, LinkedHashSet, TreeSet ...
- Map
    - 특징 : 키(Key)와 값(Value)의 쌍(Pair)으로 이루어진 데이터의 집합입니다.  
      키 중복 허용 X, 값의 중복 허용 O, 순서 유지 X
    - 구현 클래스 : HashMap, Hashtable, LinkedHashMap, TreeMap ...

## HashCode() & Equals()

### HashCode()

: 해시코드란, **객체를 식별하는 하나의 정수값**입니다.  
Object의 hashCode() 메소드는 **객체가 저장된 메모리의 번지수를 활용**하여 해시코드를 만들어냅니다.

- **사용하는 경우** : 두 객체가 동일한지 판결할 경우 사용할 수 있음.
- **객체를 비교할 떄 hashCode()와 Equals()를 오버라이딩하는 이유**  
  객체 내부의 값은 같으나 해시코드에 의해 다른 객체로 판별하기 때문이다.

### Equals() vs ==

**Eqauls** : 논리적으로 동등한가를 비교하는 것, 즉 참조값이 다르더라도 내부의 **값이 같은 경우 true를 반환**한다.  
**재정의하지 않은 equals는 주소 값을 비교한다.**  
String.equals()의 경우 내부의 값을 비교한다.  
**==** : 객체의 **주소값을 비교**한다.  

### primitive 타입이 == 비교를 통해 값 비교가 가능한 이유

**변수 선언부**는 Java Runtime Data Area의 **Stack 영역에 저장**이 되고, 해당 **변수에 저장된 상수**는 **Runtime Constant
Pool에 저장**되어있다. Stack의 **변수 선언부**는 해당 **Runtime Contant Pool의 주소값**을 가지게 되고, 만약 **다른 변수도 같은 상수를 저장**
하고 있다면, 이 다른 변수도 같은 **Runtime Contant Pool의 주소값**을 가지게 때문에 엄밀히 말하면
**primitive type 역시 주소값 비교**가 되는 것이다.

## ThreadSafe & Syncronized

### ThreadSafe

**Thread** : 메모리를 할당받아 실행 중인 프로그램을 프로세스라고 하는데 하나의 프로세스 내에서  
해당 프로세스 내에서 하나의 실행 흐름을 쓰레드라고 합니다.

- 특징
1. 메모리를 공유한다. (코드, 데이터, 힙 영역 공유 - 스택, 레지스터 뺴고)

**ThreadSafe** : 멀티 스레딩에서 일반적으로 어떤 함수나 변수, 혹은 객체가 **여러 스레드로부터 동시에 접근이 이루어져도 프로그램의 실행에 문제가 없음을
뜻합니다.**

**Thread-safe를 지키기 위한 방법**

1. Re-entrancy  
   어떤 함수가 한 스레드에 의해 호출되어 실행 중일 때, 다른 스레드가 그 함수를 호출하더라도 그 결과가 각각에게 올바로 주어져야 한다.
2. Thread-local storage  
   공유 자원의 사용을 최대한 줄여 각각의 스레드에서만 접근 가능한 저장소들을 사용함으로써 동시 접근을 막는다. 이 방식은 동기화 방법과 관련되어 있고, 또한 공유상태를 피할 수
   없을 때 사용하는 방식이다.
3. Mutual exclusion  
   공유 자원을 꼭 사용해야 할 경우 해당 자원의 접근을 세마포어 등의 락으로 통제한다.
4. Atomic operations  
   공유 자원에 접근할 때 원자 연산을 이용하거나 '원자적'으로 정의된 접근 방법을 사용함으로써 상호 배제를 구현할 수 있다.
5. Immutable Object  
   객체 생성 이후에 값을 변경할 수 없도록 만듭니다.

- ArrayList는 Thread safe 하지 않고, Vector는 Thread safe 하다.

### Syncronized

: 스레드 동기화를 할 때 사용하는 대표적인 기법입니다.  
멀티 스레드 환경에서 공유 자원에 대한 스레드의 접근을 제어하여 thread-safe하게 해줍니다.  
자바에서는 synchronized 키워드를 제공해 스레드간 동기화를 시켜 data의 thread-safe를 가능케합니다.

- 사용 방법

1. 메서드에서 사용하는 경우

```java
public synchronized void method(){
// 코드
}
```

2. 객체 변수에 사용하는 경우

```java
private Object obj=new Object();
public void exampleMethod(){
    synchroized(obj){
        //코드
    }
}
```

- 스레드 동기화의 두 가지 관점
    1. 실행 순서의 동기화
       : 스레드의 실행순서를 정의하고, 반드시 이 순서를 따르도록 하는 것
    2. 메모리 접근의 동기화
       : 데이터 영역과 힙 영역과 같이 한 순간에 하나의 쓰레드만 접근하도록 하는 것이 메모리 접근에 대한 동기화

- 문제점 - 추가
1. Synchronized 키워드를 너무 남발하면 오히려 프로그램 성능저하를 일으킬 수 있습니다.


## String

: 자바에서 제공하는 문자열 클래스로 문자열과 관련된 다양한 유용한 기능들을 제공하는 클래스입니다.

- String 인스턴스는 한번 생성되면 읽기만 가능하며 수정하는 것은 불가합니다.
- 불변 객체(Immutable Object)입니다.

### String vs StringBuffer vs StringBuilder

#### StringBuffer

: 내부적으로 버퍼(buffer)라고 하는 독립적인 공간을 가집니다. 버퍼 크기는 기본적으로 16 문자를 저장할 수 있으며, 생성자를 통해 별도로 크기를 지정할 수 있습니다.
**주요 메소드 종류**

- append()
- capacity() : 현재의 버퍼 크기를 반환
- delete(int start, int end) : 해당 문자열의 start ~ (end-1) 인덱스에 해당하는 문자 제거
  **String vs StringBuffer**  
  String 클래스는 변경이 불가한 반면, StringBuffer 클래스의 인스턴스는 그 값을 변경할 수도 있고, 추가할 수도 있습니다.  
  따라서 공간 낭비가 String에 비해 적고, 속도도 빨라집니다.  
  이유 : 덧셈(+) 연산자를 이용해 String 인스턴스의 문자열을 결합하면, 내용이 합쳐진 새로운 String 인스턴스를 생성합니다.

### Immutable Object

: 생성 후 그 상태를 바꿀 수 없는 객체.

- ex ) String, Integer, Boolean
- 장점
    - 객체에 대한 신뢰도가 높아집니다. 객체가 한번 생성되어서 그게 변하지 않는다면 transaction 내에서 그 객체가 변하지 않기에 우리가 믿고 쓸 수 있기 때문입니다.
    - 생성자, 접근메소드에 대한 방어 복사가 필요없습니다.
    - 멀티스레드 환경에서 동기화 처리없이 객체를 공유할 수 있습니다.
- 단점
    - 객체가 가지는 값마다 새로운 객체가 필요합니다.
    - 따라서 메모리 누수와 새로운 객체를 계속 생성해야하기 때문에 성능저하를 발생시킬 수 있습니다.

### StringBuilder vs SringBuffer

#### StringBuilder가 유리한 점

- **단일 스레드 환경**에서의 비번한 추가, 수정, 삭제가 일어나는 경우 StringBuffer에 비해 효율적

#### StringBuffer가 유리한 점

- **멀티 스레드 환경**에서의 빈번한 추가, 수정, 삭제가 일어나는 경우 StringBuilder에 비해 효율적

### String a = "" vs String a = new String("")

#### String a = new String("") - new 연산자를 이용하는 방식

- Heap 영역에 메모리가 할당
- 같은 문자열이라도 다른 객체라서 선언한 만큼의 새로운 객체가 메모리에 할당

#### String a = "" - 리터럴을 이용하는 방식

- String을 리터럴로 선언하면 내부적으로 String의 intern() 메소드가 호출됩니다.  
  intern() 메소드는 주어진 문자열이 **String Constant Pool**에 존재하는 검색합니다.  
  만약 있다면 그 주소값을 반환하고 없다면 여기에 새로 하나 만들고 그 주소값을 반환해줍니다.


## List
### ArrayList vs LinkedList
검색은 ArrayList가 메모리상 연속되어서 할당되어있기 때문에 효율적이다.
하지만 삽입하거나 삭제 하는 등의 연산은 이전 노드와 다음 노드를 연결하면 됨으로 LinkedList가 더 효율적이다.


## Map
특징 : 키(Key)와 값(Value)의 쌍(Pair)으로 이루어진 데이터의 집합입니다.


#### HashMap
- 정렬이 되어있지 않다. 즉, 일정한 순서가 없다.
- key나 value값은 null이 허용된다.
- key로 올 수 있는 타입은 integer, string, 객체 등이 가능하다.  
- 객체를 key로 갖는 경우 hashcode()와 equals()를 재정의해줘야한다.
- 비동기적이다.


#### HashTable
- get(), put() 메서드를 확인해보면 synchronized하게 구현
- HashMap과 달리 비동기적(unsynchronized)이다.
- key나 value값은 null이 허용되지 않는다.

**충돌 해결 방법**
1. Separate Chaining 방식 : 연결리스트나 트리 형태로 엔트리에 값을 이어 붙이는 방식
2. Open addressing 방식 : hash table array의 빈 버킷을 찾아 저장하는 방식, 탐색시 비효율적
   - 선형 탐색법 : 해시 충돌시 다음 버킷, 혹은 몇 개를 건너뛰어 데이터를 삽입
   - 2차 검색법 : 원래 저장할 위치로부터 떨어진 영역을 차례대로 검색하여 첫번째 빈 영역에 키를 저장하는 방법
   - 이중 해싱 : 해시 충돌시 다른 함수를 한번 더 적용한 결과를 이용
   - 리사이징 : 새로운 배열에 기존 배열의 키를 새롭게 재 해싱

#### LinkedHashMap
- 순서가 있다.
- 조회보다 삽입, 삭제가 효율적이다.


#### TreeMap
- red-black tree 구조를 구현한 것으로 정렬된 키(key)를 가지고 있다
- red-black tree 규칙 : 왼쪽 < 부모 < 오른쪽


#### HashTable vs HashMap
- 동기화 유무
  : HashTable 동기적, HashMap 비동기적
cf) Hashtable은 모든 데이터 변경 메소드가 synchronized로 선언되어 있어서, 메소드 호출 전
스레드 간의 동기화 lock을 통해 멀티 스레드 환경에서 data의 무결성을 보장해준다. (thread-safe)

- null 허용 유무
  : HashTable 허용 안됨, HashMap 허용


#### LinkedHashmap vs Hashmap
- 순서의 유무
- 연산에서의 성능 차이
  : HashMap은 순차적으로 데이터를 저장하는 반면 LinkedHashMap은 데이터들을 연결해주기 때문에
    LinkedHashMap이 중간에 위치한 데이터를 접근하여 삽입, 수정, 삭제할 때는 속도면에서 더 유리합니다.


### HashMap vs ConcurrentHashMap
- 동기화 유무
  : HashMap 비동기적, ConcurrentHashMap 동기적
- null 허용 유무
  : HashMap null 허용, ConcurrentHashMap null 허용 안됨

