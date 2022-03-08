## 디자인 패턴이란?
> 소프트웨어 개발 방법으로, 소프트웨어 설계에서 공통으로 발생하는 문제에 대해 자주 쓰이는 설계 방법을 정리한 패턴이다.

## 상속(is-a) vs Composition:합성(has-a)
  
#### 상속의 단점
    
1. 캡슐화를 위반 할 수 있다. → 상위 계층의 변경이 자식계층에 큰 영향을 미친다.
2. 상위 클래스 변경이 어렵다. →  부모 자식간의 결합도가 높다.
3. 설계가 유연하지 않다. → 클래스 폭발 또는 조합의 폭발 문제
4. 상속 관계는 컴파일 타임에 결정되고 고정되기 때문에 코드를 실행하는 도중에 변경할 수 없다.
    
### 합성이란?
    
객체가 다른 객체의 참조를 속성으로 사용하는 방식으로 **런타임시에 동적으로** 이루어진다.
    
합성은 내부에 포함되는 객체의 구현체가 아닌 인터페이스만을 바라보게 됨으로써 캡슐화가 잘 이뤄질 수 있다.
    
#### 합성의 단점
    
합성은 객체 간의 관계가 수직관계가 아닌 수평 관계가 된다. 따라서 객체나 메서드 명이 명확하지 않으면 코드가 가독성이 떨어지고 이해하기 어려워 질 수 있다. 따라서 합성을 구현할 때는 그 용도에 따라 클래스들을 패키지로 적절히 구분하고 각각의 사용 용도가 명확하게 드러나도록 인터페이스를 설계해야 한다.
    
### 결론
    
is-a 관계인지 has-a 관계인지(단순히 코드 재사용)  명확하게 파악하자! 그리고 인터페이스가 단일 책임을 지키는지 분리가 필요한지 고려해서 설계하자!

## 생성 패턴
>객체의 생성과 조합을 캡슐화해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공

### 팩토리 메소드 패턴
>객체를 생성하기 위한 인터페이스를 정의하고, 어떤 클래스의 인스턴스를 생성할지에 대한 처리는 서브클래스가 팩토리 메서드를 오버라이딩 하여 결정하는 디자인 패턴

![](https://images.velog.io/images/sunho6824/post/3175691c-2b8a-486e-a853-94182f909ea5/image.png)

**사용 이유**

- 실제 구현내용은 자식클래스에서 구현이 되므로 세부 구현 코드를 몰라도 부모클래스에서 자유롭게 사용이 가능하여 객체 간의 **결합도가 낮아지는 효과**가 있다. → **의존 역전 원칙 (DIP)**
- 객체들을 한 곳에서 관리할 수 있기에 **생명주기를 관리하고 확장하기 용이**하다.
  - 새로운 기능이 추가되더라도 팩토리 메서드를 사용하여 새로운 객체를 만들 수 있습니다.
- 동일한 객체의 호출이 잦을 경우 성능을 높일 수 있다.
- 생성자가 아닌 메소드로 작동하기 때문에 리턴 값을 가질 수 있다. 즉 객체를 선택함에 있어서 유연함을 가질 수 있는 방법이다

❗enum 클래스 활용


### 싱글톤 패턴
> "클래스의 인스턴스, 즉 객체를 하나만 존재하는 것을 보장하고, 전역적인 접근을 제공하여 공용으로 재사용하는 패턴"

**특징**

- 의미상 두 개의 객체가 존재할 수 없다.
- new를 실행할 수 없도록 생성자에 private 접근 제어자를 지정한다.
- 단일 객체 참조 변수를 정적 속성으로 갖는다.
- 단일 객체 참조 변수가 참조하는 단일 객체를 반환하는 getInstance() 정적 메서드를 갖는다.
- 단일 객체는 쓰기 가능한 속성을 갖지 않는 것이 정석이다.
    
    → 읽기 전용 속성 이나 다른 단일 객체에 대한 참조를 속성으로 가진 것은 가능하다.
    

**사용 이유**

1. 메모리 측면의 효율성
    
    단일 객체를 사용하기 때문에 고정된 메모리 영역을 사용하고 추후 해당 객체에 접근할 때 메모리 낭비를 방지할 수 있다. 또한 이미 생성된 인스턴스를 재사용하니 속도 측면에서도 효율적이다.
    
2. 데이터 공유
    
    전역으로 사용되는 인스턴스이기 때문에 다른 클래스의 인스턴스들이 접근하여 사용할 수 있다.
    
3. 의미상 유일하게 존재해야 하는 객체로의 접근을 통제 할 수 있다.
    

**주의 사항 : trade-off를 잘 고려해야 한다!!**

- 테스트 하기 어려울 수 있다.
    
     전역으로 자원을 공유하기 때문에 서로 격리된 테스트를 진행한다면 매번 상태를 초기화 시켜 주어야 하고 그렇지 않다면 특정 상황에서 상태를 예측하기 어렵다.
    
- 멀티 스레딩 환경에서 발생할 수 있는 동시성 문제를 잘 고려 해야 한다. (syncronized 키워드 사용)
- 클라이언트가 구체 클래스에 의족하기 때문에 DIP나 OCP 원칙을 위반할 수 있다.
    → 내부 속성을 변경하기 어렵고 자식 클래스를 만들기 어렵기 때문에 유연성이 떨어진다.
- 싱글톤 인스턴스가 많이 공유 될 때 다른 클래스의 인스턴스 간에 결합도가 높아 져 개방 폐쇄 원칙을 위배할 수 있다. (수정이 어려워 진다.)
    
#### 코드
- **Eager Initialization(이른 초기화, Thread-safe) : 정적 바인딩(static binding)**
     클래스가 호출될 때 인스턴스를 생성하는 방법, 인스턴스를 사용하지 않아도 생성하기 때문에 효율성이 떨어진다.
    
    ```java
    public class Singleton {
        // Eager Initialization
        private static Singleton uniqueInstance = new Singleton();
    
        private Singleton() {}
    
        public static Singleton getInstance() {
          return uniqueInstance; 
        }
    ```
    
- 늦은 초기화
    인스턴스를 실제로 사용할 시점에 생성하는 방법.  두 스레드가 동시에 싱글톤 인스턴스에 접근하고 생성이 안된 것을 확인하여 생성한다면 중복으로 생성할 수 있다는 문제가 있을 수 있다.
    
    ```java
    public class Singleton {

    private static Singleton instance;
	
    private Singleton () {} //생성자를 private로
	
    public static Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }    
        
        return instance;
    	}
	}
	``` 
    
- **Lazy Initialization. Double Checking Locking(DCL, Thread-safe)**
    멀티 스레드 환경에서 synchronized를 사용하여 여러 쓰레드가 getInstance() 메서드에 동시에 접근하는것을 방지. 정체 현상을 해결하기 위해 if 문으로 두번 확인하여 synchronized 영역을 줄일 수 있다.
    
    ```java
    public class Singleton {
        private volatile static Singleton uniqueInstance;
    
        private Sigleton() {}
    
        // Lazy Initialization. DCL
        public Singleton getInstance() {
          if(uniqueInstance == null) {
             synchronized(Singleton.class) {
                if(uniqueInstance == null) {
                   uniqueInstance = new Singleton(); 
                }
             }
          }
          return uniqueInstance;
        }
    }
    ```
    
    → 인스턴스를 생성하지 않을 경우 동기화 블록을 거치지 않기 때문에 성능의 감소를 방지 할 수 있다.
    
    ❗ volatile 란 ?
    
    Java 변수를 Main Memory에 read and write 하겠다는 것을 명시한다. 변수를 Read 할 때 CPU cache에 저장된 값이 아닌 Main Memory에서 읽기 때문에 변수 불일치 문제를 방지할 수 있다.
    
- **Lazy Initailization. Enum(열거 상수 클래스, Thread-safe)**
    
    ```java
    public enum Singleton {
    	INSTANCE;
      
    	public static SingletonTest getInstance() {		
    		return INSTANCE;
    	}
    }
    ```
    
    → enum 인스턴스의 생성은 기본적으로 Thread-safe하고 reflection 공격에 안전하다.
    
    ❗ reflection 공격 : 네트웍이 감당할 수 없는 트래픽의 양을 생성하여 정상적인 트래픽을 처리하지 못하도록 하는 것
    
- **LazyHolder 방식을 사용한 Lazy initialization : 가장 많이 사용되는 방식**        
private static class 인 LazyHolder 안에 instace 를 final 로 선언하여 JVM의 클래스의 초기화 과정에서 원자성을 보장,  static 멤버 클래스일지라도 컴파일 시점에서 초기화 되는 것이 아니고 getInstance() 메소드를 호출할 때 즉 런타임 시점에 초기화
    
    ```java
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
    
## 구조 패턴
작은 클래스들을 상속과 합성을 이용하여 더 큰 클래스를 생성하는 방법을 제공하는 패턴


### 프록시

## 👥 Proxy Pattern (프록시 패턴)

쉽게 말해 대리자 / 대변인 으로,

> 실제 서비스 메서드의 결과값을 조작하거나 변경하지 않고 제어의 흐름을 변경하거나 다른 로직을 수행하기 위한 목적으로 중간에 Proxy 객체를 통해 대상객체에 접근하는 방식

개방 폐쇄 원칙(OCP) 과 의존 역전 원칙(DIP)이 적용된 설계 패턴

- **구조 & 다이어그램**
    
![](https://images.velog.io/images/sunho6824/post/b00e5829-fe19-4582-a205-5a1f214a7b97/image.png)
    
- **Subject**
        - Proxy 와 RealSubject 가 구현해야하는 인터페이스
        - 두 객체를 동일하게 다루기 위해 존재
- **Proxy**
        - RealSubect 와 Client 요청 사이에 존재하는 객체
        - RealSubject 에 대한 참조 변수를 갖는다.
        - RealSubject의 메서드 호출 전후에 별도의 로직을 수행할 수 있다.
- **RealSubject**
        - 실질적으로 요청에 대해 주된 기능을 수행하는 객체

- **코드**
    
    ```java
    public interface IService { // Subject
    	String runSomething();
    }
    ```
    
    ```java
    public class Service implements IService { // **RealSubject**
    	public String runSomething() {
    		return "서비스 짱!!!";
    	}
    }
    ```
    
    ```java
    public class Proxy implements IService { // Proxy
    	IService service1;
    
    	public String runSomething() {
    		System.out.println("호출에 대한 흐름 제어가 주목적, 반환 결과를 그대로 전달");
    
    		service1 = new Service();
    		return service1.runSomething();
    	}
    }
    ```
    
    ```java
    public class ClientWithProxy {
    	public static void main(String[] args) {
    		// 프록시를 이용한 호출
    		IService proxy = new Proxy();
    		System.out.println(proxy.runSomething());
    	}
    }
    ```
    

**사용 이유**

- 실제 기능을 담당하는 객체의 리소스가 무거운 경우, 프록시 객체에서 간단한 처리를 하거나, 캐싱 처리를 통해 부하를 줄일 수 있다.
  - 비용이 많이 드는 연산(DB 쿼리, 대용량 텍스트 파일 등)을 실제로 필요한 시점에 수행할 수 있다.
  - 텍스트 처리용 프로세서, 그림 처리용 프로세스를 별도로 운영
- 기본 객체에 대한 수정 없이, 클라이언트와 기본 객체 사이에 일련의 로직을 프록시 객체에 추가할 수 있다. (기본 객체에 대한 접근 권한 제어)
- 클라이언트와 기본 객체의 사이에서 일종의 보안의 역할을 할 수 있다.
- 프록시 클래스는 로컬에 두고 주체 클래스는 원격에 둘 때, 같은 공간에 있는 것 처럼 사용할 수 있다. ex)구글 Docs

#### 단점

- 객체를 생성할 때 한 단계를 거치게 되므로, 빈번한 객체 생성이 필요한 경우 성능이 저하될 수 있다.
- 프록시 내부에서 객체 생성을 위해 스레드가 생성, 동기화가 구현되어야 하는 경우 성능이 저하될 수 있다.
- 로직이 난해해져 가독성이 떨어질 수 있다.




### 🎨 Decorator Pattern (데코레이터 패턴)

> 객체의 결합 을 통해 기능을 동적으로 유연하게 확장 할 수 있게 해주는 패턴

- 코드

데코레이터 패턴과 프록시 패턴은 동일한 구조를 갖는다. 그렇다면 차이점은??

- 코드
    
    ```java
    public interface IService {
    	public abstract String runSomething();
    }
    ```
    
    ```java
    public class Service implements IService {
    	public String runSomething() {
    		return "서비스 짱!!!";
    	}
    }
    ```
    
    ```java
    public class Decoreator implements IService {
    	IService service;
    
    	public String runSomething() {
    		System.out.println("호출에 대한 장식 주목적, 클라이언트에게 반환 결과에 장식을 더하여 전달");
    
    		service = new Service();
    		return "정말" + service.runSomething();
    	}
    }
    ```
    
    ```java
    public class ClientWithDecolator  {
    	public static void main(String[] args) {
    		IService decoreator = new Decoreator();
    	 	System.out.println(decoreator.runSomething());
    	}
    }
    ```

#### 장단점

장점
객체에 동적으로 기능 추가가 간단하게 가능하다. 객체가 상황에 따라 다양한 기능이 추가되거나 삭제되어야 할 때 사용할 수 있다.

단점
- 데코레이터 클래스들이 계속 추가되어 클래스가 많아질 수 있다.
- 겹겹이 애워싸고 있기 때문에 객체의 정체를 알기 힘들고 복잡해질 수 있다.

**Decorator VS Proxy VS Adaptor**

> 의도와 목적의 차이점!!

**데코레이터는** 중간에서 책임(기능) 추가를 위해 객체를 감싸서 새로운 행동을 추가하기 위한 용도이고, **프록시는** 중간에서 기능의 추가가 아닌 접근 제어와 같은 추가적인 컨트롤을 제공한다고 볼 수 있다.

**어댑터는** 중간에서 호환성을 위해 클라이언트가 사용하고자 하는 다른 인터페이스로 변경해준다.

❗프록시 패턴에서는 Wrapper Class와 Real Class의 관계가 컴파일타임에 정해집니다. 반면 데코레이터 패턴에서는 런타임에 정해지도록 되어있습니다.


## 🔌 Adapter Pattern (어뎁터 패턴)

쉽게 말하면 변환기 (converter), 즉 휴대폰 충전기와 같이

> 호환성이 없는 인터페이스 때문에 함께 동작할 수 없는 클래스들의 인터페이스를 클라이언트가 기대하는 다른 인터페이스로 변환하는 패턴

**→ 개방폐쇄 원칙 (OCP)** 를 활용한 설계 패턴!

**2가지 방식이 존재**

1. 클래스 어댑터 :
    
    is-a 방식으로 상속을 사용
    
2. 객체 어댑터 : 
    
    has-a 방식으로 합성을 사용
    
![](https://images.velog.io/images/sunho6824/post/677ddea9-9568-470c-8fe9-d930feb5b9f7/image.png)
**구성 요소**

- Client - Target 인터페이스를 요구하는 요소를 지닌 클래스
- Target - Client 가 직접적으로 사용하려고 하는 인터페이스를 정의
- Adaptee - 기존 코드로 개조 당하는 쪽을 의미
- Adapter - Adaptee 클래스를 Target 인터페이스에 맞춰주는 클래스
    (흐름) →  **Client 는 Target Interface 를 통해 Adapter에 요청을 보낸다. Adapter는 Client 의 요청을 Adaptee 가 이해할 수 있는 방법으로 전달하고, 처리는 Adaptee 에서 이루어진다.**
    
#### 코드
    
학생 A는 새로운 집으로 이사를 갔다. 새 집은 110V의 콘센트만 있었고  A의 핸드폰은 220V로 충전을 할 수 있다. 그렇다고 집의 모든 콘센트를 220V로 바꿀수 없으니 220v를 110v로 바꿔주는 어뎁터를 사용하여 핸드폰을 충전하기로 했다
    
```java
    public class NewHouse extends House{  // Adaptee

        @Override
        public void charging(int volt) {
            if (volt == 110) {
                System.out.println("충전이 시작됩니다.");
            } else {
                System.out.println("충전할 수 없습니다.");
            }    
    		}   }

    public interface Adapter{  // Target
    
        public void charging();
        public int changeVolt();
    
    }

    public class AdapterImpl implements Adapter{  //Adapter
    
        private House house;
        private final int volt = 220;
    
        public AdapterImpl(House house) {
            this.house = house;
        }
    
        @Override
        public void charging() {
            int changedVolt = changeVolt();
            house.charging(changedVolt);
        }
    
        @Override
        public int changeVolt() {
            System.out.println("110v로 전환합니다.");
            return volt-110;
        }
    
    }

    public class Person { // Client
    
        public static void main(String[] args) {
            NewHouse newHouse = new NewHouse();
    				Adapter adapter = new AdapterImpl(newHouse);
            adapter.charging();
        }
    
    }
```

#### 실사용 예제
- 다양한 데이터 베이스를 조작할수 있게 하는 ODBC/JDBC 와 플랫폼 별 JRE 가 어댑터 패턴이라 할 수 있다.
- 자바의 InputStreamReader도 어뎁터 패턴으로 구성된다. (InputStreamReader 클래스를 Adapter, System.in 을 Adaptee, Reader 를 Target Interface )

**사용 이유**

기존 코드를 변화해서 호출해야 하는 경우에 기존 코드를 변경하는 것은 엄청난 비용과 위험을 동반하기 때문에 어댑터 패턴을 사용하여 새 코드를 효율적으로 사용하고 유지 보수 할 수 있다. 하지만 구성요소를 위해 클래스를 증가시켜야 하기 때문에 복잡도가 증가할 수 있다.


## 행위 패턴
객체나 클래스 사이의 알고리즘이나 책임 분배에 관련된 패턴으로, 객체 사이의 결합도를 최소화하는것에 중점을 두는 방식


### Template Method Pattern (템플릿 메서드 패턴)

>  변하지 않는 기능 및 알고리즘의 구조를 슈퍼클래스 메소드에 정의하고 자주 변경되며 확장할 기능은 서브클래스에서 재정의 하도록 하는 패턴이다.

→ **의존 역전 원칙(DIP)을 활용**

**구성 요소**

- 공통 로직을 수행하는 템플릿 메서드
- 하위 클래스에 오버라이딩을 강제하는 추상 메서드
- 선택적으로 오버라이딩할 수 있는 훅 (Hook) 메서드

- 코드
    
    ```java
    public abstract class Animal {
    	// 템플릿 메서드
    	public void playWithOwner() {
    		System.out.println("귀염둥이 이리온...");
    		play();
    		runSomething();
    		System.out.println("잘했어");
    	}
    
    	// 추상 메서드
    	abstract void play();
    
    	// Hook(갈고리) 메서드
    	void runSomething() {
    		System.out.println("꼬리 살랑 살랑~");
    	}
    }
    ```
    
    ```java
    
    public abstract class Animal {
    	// 템플릿 메서드
    	public void playWithOwner() {
    		System.out.println("귀염둥이 이리온...");
    		play();
    		runSomething();
    		System.out.println("잘했어");
    	}
    
    	// 추상 메서드
    	abstract void play();
    
    	// Hook(갈고리) 메서드
    	void runSomething() {
    		System.out.println("꼬리 살랑 살랑~");
    	}
    }
    
    ```
    
    ```java
    public class Dog extends Animal {
    	@Override
    	// 추상 메서드 오버라이딩
    	void play() {
    		System.out.println("멍! 멍!");
    	}
    
    	@Override
    	// Hook(갈고리) 메서드 오버라이딩
    	void runSomething() {
    		System.out.println("멍! 멍!~ 꼬리 살랑 살랑~");
    	}
    }
    ```
    
    ```java
    public class Driver {
    	public static void main(String[] args) {
    		Animal bolt = new Dog();
    		Animal kitty = new Cat();
    
    		bolt.playWithOwner();
    
    		System.out.println();
    		System.out.println();
    
    		kitty.playWithOwner();
    	}
    }
    ```
    

**클래스 다이어 그램**

![](https://images.velog.io/images/sunho6824/post/cc67a7ea-7371-4fd6-ab17-927cc6095109/image.png)

#### 사용 이유

전체적으로는 구성이 동일하면서 부분적으로는 다른 구문으로 구성된 메서드의 **코드 중복을 최소화** 하고 유연하게 기능을 변경할 수 있도록 하고자 할 때 유용하다.
하지만 추상 메소드가 많아지면서 결합도가 상승하고 클래스 관리가 복잡해질 수 있다.


### 옵서버 패턴(Observer Pattern)

> 옵저버 패턴은 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들에게 연락이 가고 자동으로 정보가 갱신되는 1:N 의 관계를 정의한다.  

- JAVA에서 기본으로 Observable 클래스와 Observer 인터페이스를 제공한다.
- Subject 객체와 Object객체 간의 연결은  인터페이스를 이용하여 느슨한 결합성을 유지한다.
- 주로 분산 이벤트 핸들링 시스템을 만들 때 사용한다.

### 구조
![](https://images.velog.io/images/sunho6824/post/7943f2e9-22fc-4f91-bffa-c8826a167b52/image.png)
- Observer
  - 데이터의 변경을 통보 받는 인터페이스
  - 즉, Subject에서는 Observer 인터페이스의 update 메서드를 호출함으로써 ConcreteSubject의 데이터 변경을 ConcreteObserver에게 통보한다.
- Subject
  - ConcreteObserver 객체를 관리하는 요소
  - Observer 인터페이스를 참조해서 ConcreteObserver를 관리하므로 ConcreteObserver의 변화에 독립적일 수 있다.
- ConcreteSubject
  - 변경 관리 대상이 되는 데이터가 있는 클래스(통보하는 클래스)
  - 데이터 변경을 위한 메서드인 setState가 있다.
  - setState 메서드에서는 자신의 데이터인 subjectState를 변경하고 Subject의 notifyObservers 메서드를 호출해서ConcreteObserver 객체에 변경을 통보한다.
- ConcreteObserver
  - ConcreteSubject의 변경을 통보받는 클래스
  - Observer 인터페이스의 update 메서드를 구현함으로써 변경을 통보받는다.
  - 변경된 데이터는 ConcreteSubject의 getState 메서드를 호출함으로써 변경을 조회한다.

#### 사용 이유

장점
1. 실시간으로 한 객체의 변경사항을 다른 객체에 전파할 수 있습니다.

2. 느슨한 결합으로 시스템이 유연하고 객체간의 의존성을 제거할 수 있다.

 

단점
1. 너무 많이 사용하게 되면, 상태 관리가 힘들 수 있습니다

2. 멀티 스레드환경에서 오작동이 일어날 수 있다.
