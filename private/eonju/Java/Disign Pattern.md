# 생성패턴

## 추상 팩토리

: 객체 생성 하는 코드를 분리하여 클라이언트 코드와 결합도(의존성)를 낮추어 코드를 건드리는 횟수를 최소화 하기 위한 패턴

- **클라이언트 코드** :  분리시킨 객체 생성 코드를 호출하는 쪽
- **결합도가 왜 낮아지는가?**  
  객체지향 성질중에 하나인 **다형성**을 이용하여 인터페이스를 구현한 객체들은 같은 인터페이스를 바라 보기 때문에 코드에 유연함이 생긴다.
- **왜 사용하는가?**
    - 코드의 중복 제거
    - 다형성의 이점을 누릴 수 있음

## 싱글톤

: 객체의 인스턴스가 오직 1개만 생성되는 패턴

- **왜 사용하는가?**
    - 메모리 누수를 방지할 수 있다.
      : 최초 한번의 new연산자를 사용해 인스턴스를 한번만 생성하기 때문에 메모리 측면의 이점이 있다.
    - 다른 클래스 간에 데이터 공유가 쉽다. -> 하지만, 여러 클래스에서 하나의 인스턴스를 접근해 생기는 '동시성 문제'가 생길 수 있다.
        - 동시성이 제어되는 자료 구조를 사용한다.
        - 클래스 호출 시 싱글톤 메모리를 할당해준다.
        - syncronized와 if문을 사용해서 해결해준다.
      ```java
      public class Singleton{
        public Singleton getInstance() {
          if(uniqueInstance == null) {
          synchronized(Singleton.class) {
          if(uniqueInstance == null) {
          uniqueInstance = new Singleton();
      }}}}}
      ```
  ``` java
  public class Singleton {
  
      private static class InnerInstanceClass {
          private static final Singleton instance = new Singleton();
      }
      
      public static Singleton getInstance() {
          return InnerInstanceClass.instance;
      }
      
      private Singleton() {}
  
      public void print() {
          System.out.println("**LazyHolder 방식을 사용한** singleton pattern");
      }
  }
  ```
- **단점은 없는가?**
    - 테스트하기 어렵다는 것이다.
    - 유연성이 많이 떨어지는 패턴이다.  
      -> 자식클래스를 만들지 못한다
- **예시)** 스프링 빈 -> 스프링 컨테이너의 도움으로 싱글톤으로 관리되어진다.

# 구조패턴

## 데코레이터

: 인터페이스에서 상속받은 클래스들의 기능을 확장하기 위한 패턴

- **장점**

1. 기존 코드를 수정하지 않고도 데코레이터 패턴을 통해 행동을 확장시킬 수 있습니다.
2. 구성과 위임을 통해서 실행중에 새로운 행동을 추가할 수 있습니다.

- **단점**

1. 의미없는 객체들이 너무 많이 추가될 수 있습니다.
2. 데코레이터를 너무 많이 사용하면 코드가 필요 이상으로 복잡해질 수 있습니다.

- **예시**
1. 클래스의 요소들을 계속해서 수정을 하면서 사용하는 구조가 필요한 경우
2. 여러 요소들을 조합해서 사용하는 클래스 구조인 경우

## 프록시

: 특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴

- 초기화 지연, 접근 제어, 로깅, 캐싱 등 다양하게 응용할 수 있는 패턴
- **장점**
    - 기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있다.  
      -> 개방-폐쇄 원칙 (Open/closed principle) 만족, “소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.”
    - 기존 코드가 해야하는 일만 유지할 수 있다.  
      -> 단일 책임 원칙 (Single responsibility principle) 만족, "한 클래스는 하나의 책임만 가져야 한다."
    - 기능 추가 및 초기화 지연등 으로 다양하게 활용할 수 있다.
- **단점**
    - 코드의 복잡도가 증가한다.
    
- 프록시는 무조건 실행, 데코레이터는 실행 시킬 수도 있고 없을 수도 있다.


# 구조패턴
## 어댑터
: 한 클래스의 인터페이스를 클라이언트에서 사용하고자하는 다른 인터페이스로 변환한다.  
어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있다.

- **목적**
  - 클래스의 인터페이스를 클라이언트가 원하는 형태의 인터페이스로 변환
  - 인터페이스 호환이 안되는 클래스를 사용할 수 있게 해줌

- **장점**
1. Adapter 패턴의 가장 큰 장점을 기존 코드를 변경하지 않아도 된다는 점입니다.
2. 기존 코드를 변경하지 않기 때문에 클래스 재활용성을 증가시킬 수 있습니다.

- **단점**
1. 구성요소를 위해 클래스를 증가시켜야 하기 때문에 복잡도가 증가할 수 있습니다.
2. 클래스 Adapter 의 경우 상속을 사용하기 때문에 유연하지 못합니다.
3. 반명 객체 Adapter 의 경우는 대부분의 코드를 다시 작성해야 하기 때문에 효율적이지 못합니다.

# 행위패턴
## 옵저버
: 어떤 객체의 상태가 변할 때 그와 연관된 객체 들에게 알림을 보내는 디자인 패턴

- **장점**
1. 실시간으로 한 객체의 변경사항을 다른 객체에 전파할 수 있습니다.
2. 느슨한 결합으로 시스템이 유연하고 객체간의 의존성을 제거할 수 있다.

- **단점**
1. 너무 많이 사용하게 되면, 상태 관리가 힘들 수 있습니다
2. 데이터 배분에 문제가 생기면 자칫 큰 문제로 이어질 수 있습니다.

## 템플릿 메소드
: 알고리즘 구조를 메소드에 정의하고 하위 클래스에서 알고리즘 구조의 변경없이 알고리즘을 재정의하는 패턴
- 구현하려는 기능이 일정한 프로세스가 존재한다.
- 구현하려는 기능이 사용하는 알고리즘이 추후 변경가능성이 있다.  


- **장점**
1. 중복코드를 줄일 수 있다.
2. 자식 클래스의 역할을 줄여 핵심 로직의 관리가 용이하다.
3. 좀더 코드를 객체지향적으로 구성할 수 있다.

- **단점**
1. 추상 메소드가 많아지면서 클래스 관리가 복잡해진다.
2. 클래스간의 관계와 코드가 꼬여버릴 염려가 있다.