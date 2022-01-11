# Operating System
:open_book: Contents
- [Operating System](#operating-system)
  - [운영체제란?](#운영체제란)
    - [운영체제의 필요성](#운영체제의-필요성)
    - [운영체제의 역할](#운영체제의-역할)
  - [운영체제 구조](#운영체제-구조)
    - [커널과 인터페이스](#커널과-인터페이스)
    - [시스템 호출과 디바이스 드라이버](#시스템-호출과-디바이스-드라이버)
    - [커널의 구성](#커널의-구성)
    - [가상 머신](#가상-머신)
  - [프로세스의 개요](#프로세스의-개요)
    - [폰 노이만 구조](#폰-노이만-구조)
    - [프로그램과 프로세스](#프로그램과-프로세스)
    - [프로그램에서 프로세스로 전환](#프로그램에서-프로세스로-전환)
    - [프로세스의 상태](#프로세스의-상태)
    - [프로세스 제어 블록](#프로세스-제어-블록)
    - [문맥 교환](#문맥-교환)
    - [프로세스의 구조](#프로세스의-구조)
    - [프로세스의 생성과 복사](#프로세스의-생성과-복사)
    - [프로세스 계층 구조](#프로세스-계층-구조)
  - [스레드](#스레드)
    - [프로세스 VS 스레드](#프로세스-vs-스레드)
    - [멀티 스레드](#멀티-스레드)
    - [멀티 스레드의 장단점](#멀티-스레드의-장단점)
    - [멀티스레드 모델](#멀티스레드-모델)
  - [스케줄링](#스케줄링)
    - [스케줄링 개요](#스케줄링-개요)
    - [스케줄링 단계](#스케줄링-단계)
    - [스케줄링 목적](#스케줄링-목적)
    - [선점형과 비선점형 스케줄링](#선점형과-비선점형-스케줄링)
    - [프로세스의 우선순위](#프로세스의-우선순위)
    - [CPU 집중 프로세스와 입출력 집중 프로세스](#cpu-집중-프로세스와-입출력-집중-프로세스)
    - [전면 프로세스와 후면 프로세스](#전면-프로세스와-후면-프로세스)
    - [다중 큐](#다중-큐)
  - [CPU 스케줄링 알고리즘](#cpu-스케줄링-알고리즘)
    - [FCFS](#fcfs)
    - [SJF](#sjf)
    - [HRN](#hrn)
    - [Round Robin](#round-robin)
    - [Sortest Remaining Time](#sortest-remaining-time)
    - [우선순위](#우선순위)
    - [다단계 큐](#다단계-큐)
    - [다단계 피드백 큐](#다단계-피드백-큐)
  
---

## 운영체제란?

운영체제는 사용자에게 편리한 **인터페이스 환경**을 제공하고 **컴퓨터 시스템의 자원을 효율적으로 관리**하는 **소프트웨어**이다.

### 운영체제의 필요성
초기 컴퓨터는 정해진 계산만 수행하면 됐다. 하지만 메모리, CPU의 성능이 향상되고, 여러 작업을 동시에 할 수 있는 컴퓨팅 환경이 조성되면서 사용 규칙이 필요해졌다. 이로 인해 운영체제가 나타났다.

### 운영체제의 역할
1. **자원 관리**
\
운영체제는 한정된 컴퓨팅 자원을 응용 프로그램에게 나누고 회수하며 사용자가 원활하게 작업할 수 있도록 돕는다.

2. **자원 보호**
\
운영체제는 미숙한 사용자나 악의적인 사용자로부터 컴퓨터 자원을 보호한다 

3. **하드웨어 인터페이스 제공**
\
운영체제는 복잡한 과정 없이 다양한 장치를 사용할 수 있도록 해주는 하드웨어 인터페이스를 제공한다. 운영체제는 다양한 장치를 일관된 방법으로 사용할수 있도록 지원하여 사용자는 하드웨어의 구체적인 동작 방식에 대해서 알 필요가 없다. 하드웨어 장치와 상호작용하기 위해 만들어진 컴퓨터 프로그램(하드웨어 인터페이스)을 **드라이버**라고한다.

4. **사용자 인터페이스 제공**
\
사용자 인터페이스는 사용자가 운영체제를 쉽게 사용하도록 지원한다. 운영체제는 사용자에게 GUI를 제공하여 사용자가 쉽게 작업을 수행할 수 있도록 한다.

<p align=middle>
    <img src=https://user-images.githubusercontent.com/60502370/147912120-3f760a8e-18c1-44a4-826f-4da45a33d92d.png width=500>
</p>

## 운영체제 구조

### 커널과 인터페이스

운영체제는 커널과 인터페이스로 나눌 수 있다.

<p align=middle>
    <img src=https://user-images.githubusercontent.com/60502370/147912449-12a72bf5-8e90-4ae6-8764-e4182ad1248a.png width=500>
</p>

**커널은** 프로세서 관리, 메모리 관리, 저장장치 관리와 같은 운영체제의 핵심적인 기능을 모아놓은 것을 말한다.

**인터페이스는** 커널에 사용자 명령을 전달하고 실행 결과를 사용자에게 알려주는 역할을 한다.

운영체제는 커널과 인터페이스를 분리하여 같은 커널을 사용하더라도 다른 인터페이스를 가진 형태로 제작할 수 있다. 다른 인터페이스를 사용하면 사용자에게 다른 운영체제처럼 느껴질 수 있다.

### 시스템 호출과 디바이스 드라이버

**시스템 호출**은 커널이 제공하는 시스템 관련 서비스를 모아놓은 것이며 함수 형태로 제공된다. 커널은 컴퓨터 자원을 보호하기 위하여 자원에 직접 접근하는 것을 차단한다. 따라서 자원을 이용하기 위해서는 커널이 제공하는 시스템 호출을 사용해야한다.

```txt
API(Application Programming Interface)

응용 프로그램이 자신과 연관된 프로그램을 만들 수 있도록 제공하는 인터페이스이다. 운영체제의 API를 시스템 호출이라할 수 있다.

SDK(System Developer's Kit)

프로그램 개발자를 위해 API 및 API 사용 매뉴얼, 프로그램 개발에 필요한 코드 편집기 같은 각종 개발용 응용 프로그램까지 묶어서 배포하는 개발 툴을 말한다(ex: android studio).

```

**드라이버**는 커널과 하드웨어 사이의 인터페이스이다. 커널이 모든 하드웨어에 맞는 인터페이스를 모두 개발하기 어렵다. 따라서 커널은 입출력의 기본적인 부분만 제작하고 하드웨어 특성을 반영한 소프트웨어를 하드웨어 제작자에게 받아 커널이 실행될 때 함께 실행하도록한다. 이때 하드웨어 제작자가 만든 소프트웨어를 디바이스 드라이버라고한다.

### 커널의 구성

커널은 운영체제의 핵심 기능을 모아놓은 것이다. 커널이 주로 하는 일은 아래와 같다

- 프로세스 관리
- 메모리 관리
- 파일 시스템 관리
- 입출력 관리
- 프로세스간 통신관리

커널은 이러한 기능을 구현하는 방법에 따라 단일형, 계층형, 마이크로 구조 커널로 구분된다.

- 단일형 구조 커널
  - 커널의 핵심 기능을 구현하는 모듈들이 구분 없이 하나로 구성되어있다.
  - 모듈이 거의 분리되어 있지 않아 모듈간 통신 비용이 적다
  - 모듈이 분리되어있지 않아 버그나 오류를 처리하기 어렵다
  - 상호 의존성이 높아 작은 결함이 시스템 전체로 번질 수 있다

- 계층형 구조 커널
  - 비슷한 기능을 가진 모듈을 묶어서 하나의 계층으로 만들고 계층간 통신을 통해 운영체제를 구현하는 방식이다.
  - 모듈이 계층적으로 분리되어 있어 단일형 보다 오류를 처리하거나 디버깅하기 편리하다

- 마이크로 구조 커널
  - 프로세스 관리, 메모리 관리, 프로세스 간 통신 관리 등 가장 기본적인 기능만 제공하는 커널
  - 다양한 요구를 수용하기 위해 커널이 방대해짐에 따라 나타난 구조
  - 다른 커널에 비해 운영체제의 많은 부분이 사용자 영역에 구현되어 있다.
  - 각 모듈이 독립적으로 작동하기 때문에 한 모듈의 결함이 전체로 퍼지지 않는다.

### 가상 머신
가상머신은 운영체제와 응용 프로그램 사이에서 작동하는 프로그램으로, 가상머신을 설치하면 응용 프로그램이 모두 동일한 환경에서 작동하는 것처럼 보인다. 자바 가상머신(JVM)이 여기에 해당한다.


## 프로세스의 개요

### 폰 노이만 구조
오늘날의 컴퓨터는 대부분 폰 노이만 구조를 따른다. 폰 노이만 구조란 CPU, 메모리, 입출력장치, 저장장치가 버스로 연결되어 있는 구조를 말한다. 폰 노이만 구조가 나오기 전까지는 컴퓨터는 전선을 바꾸며 용도를 변경해야했다. 이러한 문제를 해결하기 위해 폰 노이만이 **메모리를 사용하여 하드웨어는 그대로 두고 프로그램을 바꿔 메모리에 올리는 방식**을 제안했다.

폰 노이만 구조의 가장 큰 특징은 `모든 프로그램은 메모리에 올라와야 실행할 수 있다`는 것이다.

### 프로그램과 프로세스

현대 컴퓨터는 폰 노이만 구조를 가진다. **폰 노이만 구조**에서 프로그램이 실행된다는 것은 해당 코드가 **메모리**에 올라와서 작업이 실행된다는 것이다.

- **프로그램은** 저장장치에 저장되어 있는 정적인 상태
- **프로세스는** 실행을 위해 메모리에 올라온 동적인 상태

### 프로그램에서 프로세스로 전환

프로그램이 **메모리 위에 올라온 동적인 상태를 프로세스**라 한다. 프로그램이 프로세스로 전환되기 위해서는 메모리 위에 올라온 동시에 **프로세스 제어 블록(PCB: Process Control Block)**을 운영체제로 부터 할당 받아야한다.

따라서 다음과 같이 표현할 수 있다
- 프로그램 = 프로세스 - 프로세스 제어 블록
- 프로세스 = 프로그램 + 프로세스 제어 블록
  
프로세스 제어 블록은 프로세스의 작업 지시서와 같은 역할을 한다. PCB에는 프로세스의 다양한 정보가 포함되는데 대표적인 세 가지는 다음과 같다.

- 프로세스 구분자
\
메모리 상에서 프로세스를 구분하기 위한 구분자

- 메모리 관련 정보
\
CPU는 실행하려는 프로세스의 메모리 상의 위치를 알아야 작업이 가능하다. 따라서 PCB에 프로세스의 메모리 위치 정보가 포함된다.

- 중간 값(프로그램 카운터, 레지스터 값)
\
시분할 시스템에서 프로세스가 번갈아가며 실행된다. 따라서 프로세스가 사용했던 각종 중간 값들이 PCB에 저장된다.

프로세스가 종료되면 프로세스가 메모리에서 삭제되고 PCB도 같이 폐기된다. 중요한 점은 컴퓨터 내에는 사용자가 실행한 프로세스만 있는 것이 아니다는 것이다. 운영체제도 프로그램이기 때문에 프로세스 형태로 실행된다.

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148021164-8af9b9a5-59a9-4776-8eea-578d637c76e7.png width=500>
</p>

### 프로세스의 상태

**프로세스의 간단한 네 가지 상태**

- 생성 상태
\
프로세스가 메모리 위에 올라와 PCB를 할당 받아 실행 준비를 완료한 상태

- 준비 상태
\
생성된 프로세스가 CPU를 할당받아 실행될 때까지 기다리는 상태

- 실행 상태
\
준비 상태의 프로세스가 CPU를 할당 받아 실제 작업을 수행하는 상태. 실행 상태의 프로세스는 일정 시간(타임 퀀텀)동안 CPU를 사용할 권리를 가진다. 만약 작업을 완료하지 못하면 준비 상태를 오가며 작업이 완료될 때까지 실행된다.

- 완료 상태
\
프로세스가 작업을 완료하여 메모리에서 삭제되고 PCB가 폐기된 상태

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148022028-76fca84d-0d53-48da-9461-c65cc6008891.png width=500>
</p>

**프로세스의 다섯 가지 상태**

인터럽트 시스템에서 프로세스가 **입출력**을 요구하면 CPU는 직접 데이터를 가져오지 않고 입출력 관리자에게 명령을 내린다. 입출력을 요구한 프로세스는 작업을 진행할 수 없는데, **작업의 효율성**을 높이기 위해서 프로세스를 계속 실행 상태로 두는 것이 아니라 입출력이 완료할 때까지 기다리는 **대기 상태**로 변경한다.

- 생성 상태
\
프로세스가 메모리 위에 올라와 PCB를 할당 받아 실행 준비를 완료한 상태

- 준비 상태
\
생성된 프로세스가 CPU를 할당받아 실행될 때까지 준비 큐에서 기다리는 상태. 실제로 다수의 준비 큐가 존재하며, CPU 스케줄러에 의해서 큐를 몇개 운영할 지, 어떤 프로세스의 작업을 수행할지 결정한다.

- 실행 상태
\
준비 상태의 프로세스가 CPU를 할당 받아 실제 작업을 수행하는 상태. 실행 상태의 프로세스는 일정 시간(타임 퀀텀)동안 CPU를 사용할 권리를 가진다. 만약 작업을 완료하지 못하면 준비 상태를 오가며 작업이 완료될 때까지 실행된다. 
\
\
시간을 다 사용하면 timeout(PID)가 실행되고, 작업이 완료되면 exit(PID)가 실행된다. 실행 상태의 프로세스가 입출력을 요청하면, CPU는 입출력 관리자에게 입출력을 요청하고 block(PID)를 실행하여 프로세스를 대기 상태로 변경한다.


- 대기 상태
\
입출력을 요구한 프로세스가 입출력이 완료될 때까지 기다리는 상태. CPU는 다른 프로세스를 선정하여 작업을 진행할 수 있다.
\
\
대기 상태의 프로세스는 입출력장치별로 마련된 큐에서 기다린다. 입출력이 완료되면 인터럽트가 발생하고, 대기 상태에 있는 여러 프로세스 중 해당 인터럽트로 깨어날 프로세스를 찾는데 이것이 wakeup(PID)이다. 그리고 해당 프로세스는 준비 상태로 변경된다.

- 완료 상태
\
프로세스가 작업을 완료하여 메모리에서 삭제되고 PCB가 폐기된 상태. 만약 비정상적으로 종료된 경우 디버깅을 위해 강제 종료 직전의 메모리 상태를 저장장치로 옮기는데 이를 코어 덤프라한다.

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148022485-ec4b3872-f974-4518-9eeb-85868fc6a88d.png width=500>
</p>

**휴식 상태와 보류 상태**

- 휴식 상태
\
프로세스가 작업을 일시적으로 쉬고있는 상태. 사용하던 데이터가 메모리에 그대로 있고 프로세스 제어 블록도 유지되어 멈춘 지점에서 바로 재시작할 수 있다

- 보류 상태
\
프로세스가 메모리에서 일시적으로 쫓겨난 상태. 보류 상태의 프로세스는 **스왑 영역**에 보관된다. 보류 상태는 다시 대기 상태에서 옮겨진 **보류 대기 상태**, 준비 상태에서 옮겨진 **보류 준비 상태**로 구분된다.보류 대기 상태에서 입출력이 완료되면 보류 준비 상태로 옮겨진다.

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148023951-5dfbe925-b21a-40a8-9ed8-a5b2d3b360b7.png width=500>
</p>

### 프로세스 제어 블록

**프로세스 제어 블록(PCB: Process Control Block)은** 프로세스를 실행하는데 필요한 중요한 정보를 저장하는 자료구조이다.

프로세스 제어 블록의 구성은 다음과 같다.

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148029794-b7432a6b-e145-41c3-833e-3a0a9f3656e2.png width=200>
</p>

- 포인터: 포인터를 사용하여 PCB를 연결해 준비 상태나 대기 상태의 큐를 구현한다
- 프로세스 상태
- 프로세스 구분자
- 프로그램 카운터: 다음에 실행될 명령어의 위치를 가리킨다
- 프로세스 우선순위: 대기 큐, 준비 큐에서는 프로세스의 우선 순위에 따라 여러 줄로 서 있다.
- 레지스터 정보: 누산기, 색인 레지스터, 스택 포인터 등
- 메모리 관리 정보: 프로세스의 메모리 상 위치, 메모리 보호를 위한 경계 레지스터 값과 한계 레지스터 값, 세그먼테이션 테이블, 페이지 테이블 정보
- 할당된 자원 정보: 프로세스를 실행하기 위해 사용하는 입출력 자원 등에 대한 정보
- 계정 정보: 계정 번호, CPU 할당 시간, CPU 사용 시간
- 부모, 자식 프로세스 구분자

### 문맥 교환
**문맥 교환**은 CPU를 차지하던 프로세스가 나가고 새로운 프로세스를 받아들이는 작업을 말한다. 이때 두 프로세스 제어 블록의 내용이 변경된다.

**문맥 교환의 절차**

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148030436-75dcaf3d-f669-4f98-bc95-3106e88ba0ad.png width=500>
</p>

1. 인터럽트나 시스템 콜이 발생한 경우 현재 프로세스 P0의 정보를 PCB에 저장한다
2. P0는 준비(대기) 상태로 쫓겨난다
3. P1이 실행 상태로 옮겨진다
4. CPU의 레지스터가 P1의 PCB 값으로 채워지고 작업을 수행한다.


문맥 교환이 일어나는 경우는 다양한데 대표적인 예는 다음과 같다
- 타임 아웃
- 인터럽트
- 주어진 메모리 공간을 벗어난 경우

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148382498-09f637ef-990c-4b15-8578-76df8684c209.png width=700>
</p>

인터럽트나 시스템 콜이 발생했다고 해서 반드시 문맥교환이 발생하는 것은 아니다.

인터럽트나 시스템 콜이 발생하면 사용자 모드에서 커널 모드로 변경되고 운영체제의 제어권이 커널로 넘어가지만, 이를 문맥 교환이라고 하지는 않는다. 커널의 작업이 끝나고 다시 동일한 프로세스의 작업을 수행하는 경우에는 문맥교환이 발생하지 않는 것이다.

만약 타임 아웃이나 시간이 오래 걸리는 입출력 요청이 발생한 경우 커널에게 운영체제의 제어권이 넘어가 커널 작업이 끝나면 다시 사용자 모드로 변경되고 인터럽트 발생 이전과는 다른 프로세스에게 CPU 제어권이 넘어가게 되는데, 이는 문맥교환이 발생한 것이다.

### 프로세스의 구조

프로세스는 코드 영역, 데이터 영역, 스택 영역으로 구성된다.

- 코드 영역
\
프로그램의 본문이 기술된 곳으로 텍스트 영역이라고도 한다.

- 데이터 영역
\
변수나 파일 등 각종 데이터를 모아놓은 곳이다. 일반 데이터 영역과 힙(Heap) 영역으로 나뉜다

- 스택 영역
\
프로그램이 실행되는데 부수적으로 필요한 데이터를 모아놓은 곳이다. 함수를 수행하고 돌아올 위치 등이 저장된다.

**동적 할당 영역**

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148031737-5ff188d3-24ea-471e-b963-c1213b546648.png width=200>
</p>

코드 영역과 데이터 영역은 프로세스가 실행되기 직전에 위치와 크기가 결정되고 실행되는 동안 변하지 않는 정적 영역이다.

**스택과 힙 영역**은 프로세스가 실행되는 동안 만들어지는 영역으로 크기가 변경되는 **동적인 영역**이다.

- 스택 영역
  - 스레드가 작동하는 동안 추가되거나 삭제되는 동적 할당영역이다
  - 호출한 함수가 종료되면 함수를 호출하기 전 코드로 되돌아올 메모리 주소를 스택에 저장한다
  - 변수 사용 범위에 영향을 미치는 영역을 구현할 때 사용한다. 지역 변수가 스택에 저장된다

- 힙 영역
  - 동적으로 할당되는 변수 영역이다.
  - 일부 데이터가 프로그램이 실행되는 동안 할당된다. C 언어의 `malloc()`, 자바의 `new`

### 프로세스의 생성과 복사
사용자가 프로그램을 실행하면 운영체제는 프로그램을 메모리로 가져와 코드 영역에 넣고 PCB를 생성한다. 그리고 메모리에 데이터 영역과 스택 영역을 확보한 후 프로세스를 실행한다.

**fork()**

실행 중인 프로세스로부터 새로운 프로세스를 복사하는 시스템 호출이다.
부모-자식 관계가 형성되며 부모 프로세스 영역의 대부분이 자식 프로세스에 복사되어 똑같은 프로세스가 만들어진다. 단 두 프로세스는 독립적이다.


프로세스를 새로 생성하는 것에 비해 fork()가 가진 장점은 다음과 같다

- 프로세스의 생성속도가 빠르다
- 추가 작업 없이 자원을 상속할 수 있다
- 시스템 관리를 효율적으로 할 수 있다

**exec()**

기존의 프로세스를 새로운 프로세스로 전환하는 함수이다. 프로세스의 구조체를 재활용하기 위해 사용한다. 코드 영역에 있는 기존의 내용을 지우고 새로운 코드로 바꿔버린다. 그리고 데이터 영역이 새로운 변수로 채워지고 스택 영역이 리셋된다.

### 프로세스 계층 구조

fork()와 exec()를 통해서 프로세스를 계층 구조로 만들 수 있다. 계층 구조의 장점은 다음과 같다.

- 여러 작업 동시 처리
- 용이한 자원 회수

fork()로 생성된 부모-자식 프로세스는 독립적이기 때문에 어떤 프로세스가 먼저 작업이 종료될 지 모른다. 부모 프로세스가 먼저 종료되거나 자식 프로세스가 부모 프로세스와 통신이 안되는 경우를 미아 프로세스(좀비 프로세스)라 한다.

## 스레드
스레드는 프로세스에 정의된 절차에 따라 CPU에 작업 요청을 하는 실행단위이다.

### 프로세스 VS 스레드
개개의 프로세스와 스레드는 서로에게 미치는 영향이 다르다. 프로세스끼리는 서로 약하게 연결되어 있고, 스레드끼리는 서로 강하게 연결되어있다.

**프로세스**

프로세스가 서로 약하게 연결되어 있다는 것은 서로 독립적이라는 것이다. 독립적이기 때문에 서로에게 미치는 영향이 적고 데이터를 주고 받을 때 **프로세스간 통신(IPC: Inter Process Communication)**을 이용한다

**스레드**

스레드는 서로 강하게 연결되어 있다. 따라서 한 스레드의 결함이 전체 스레드에 영향을 미칠 수 있다. 스레드는 변수나 파일 등을 공유하고 전역 변수나 함수 호출등의 방법으로 스레드 간 통신을 한다. CPU와 프로그래밍 기술이 발전하면서 여러 개의 코어를 가진 CPU가 생겨났다. 이러한 상황에서 프로세스에 **하나의 스레드만 존재한다면 여러 코어를 나누어 동시에 작업하는 것이 불가능**하다. 즉, 멀티스레드의 장점을 살릴 수 없다. 오늘 날의 운영체제는 프로세스를 다양한 스레드로 나누어 여러 개의 코어에 배분함으로써 시스템 효율을 높인다.

### 멀티 스레드

초기의 프로그래밍 언어는 순차적으로 실행되기 때문에 프로세스로 여러 적업을 동시에 수행하기 어려웠다. 여러 개의 작업을 동시에 처리하기 위해 fork() 시스템 호출을 통해 부모와 똑같은 자식 프로세스를 생성하고, exec()를 통해 프로세스를 전환했다. 하지만 fork() 시스템 호출은 낭비적인 요소가 많다. 부모 프로세스의 코드 영역과 데이터 영역의 일부가 **메모리에 중복하여 존재**하고, 부모-자식 관계이지만 **서로 독립적인 프로세스여서 낭비 요소를 제거하기 어렵다**. 스레드는 **멀티태스킹의 낭비적인 요소를 줄이기 위해 나타났다**. 비슷한 일을 하는 프로세스를 2개 만드는 대신, **코드나 데이터를 공유하면서 여러 개의 일을 하나의 프로세스 내에서 수행하는 것이다.**

프로세스의 구조는 크게 **동적인 영역과 정적인 영역**으로 나뉜다.
- 정적 영역: 코드, 전역데이터, 파일
- 동적 영역: 레지스터 값, 스택, 힙

fork() 시스템 호출을 사용하면 프로세스의 정적인 영역도 복사된다. 멀티 스레드는 프로세스의 코드, 전역 데이터, 파일, 힙 영역을 공유하여 자원의 낭비를 막는다. 그리고 스택, 프로그램 카운터는 별도로 할당하여 독립적인 실행흐름을 가진다.

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148177197-0516032f-b48d-4acd-a952-bd5c2631693c.png width=500>
</p>



### 멀티 스레드의 장단점

**장점**
- 응답성 향상
\
한 스레드가 입출력으로 인해 대기 상태로 변경된 경우, 다른 스레드가 작업을 계속하여 사용자의 요구에 빠르게 대응할 수 있다.
- 자원 공유
\
프로세스가 가진 자원을 공유하여 작업을 원할하게 진행할 수 있다.

-효율성 향상
\ 
불필요한 자원의 중복을 막아 시스템의 효율성이 향상된다.

- 다중 CPU 지원
\
2개 이상의 CPU를 가진 컴퓨터에서 멀티스레드를 사용하면 다중 CPU가 멀티스레드를 동시에 처리하여 CPU 사용량이 증가하고 프로세스 처리 시간이 단축된다.

**단점**
- 모든 스레드가 프로세스의 자원을 공유하기 때문에 한 스레드에 문제가 생기면 전체 프로세스에 영향을 미친다

- 프로세스의 자원을 공유함으로써 동기화 문제가 발생할 수 있다.

### 멀티스레드 모델

**사용자 레벨 스레드**

**운영체제가 멀티스레드를 지원하지 않을 때 사용**하는 방법이다. 사용자 레벨에서 스레드를 구현하기 때문에 관련 **라이브러리**를 사용하여 구현하고, 라이브러리는 커널이 제공하는 스케줄링이나 동기화 같은 기능을 대신 구현해준다. **커널 입장에서 이 스레드는 하나의 프로세스처럼 보인다**.

- 1(커널) to N(사용자) 모델이라고 부른다
- 라이브러리가 직접 스케줄링하고 필요한 정보를 처리하기 때문에 문맥 교환이 필요없다.
- 커널 스레드가 입출력 작업을 위해 대기 상태로 들어가면, 모든 사용자 스레드가 같이 대기하게된다.
- 한 프로세스의 타임 슬라이스를 공유하기 때문에 여러 개의 CPU를 동시에 사용할 수 없다
- 공유 변수 보호 장치를 라이브러리에서 구현하기 때문에 보안에 취약하다

**커널 레벨 스레드**

커널이 멀티 스레드를 지원하는 방식이다.

- 1 to 1 모델이라고 부른다
- 스레드가 독립적으로 스케줄링 되므로 특정 스레드가 대기 상태에 들어가도 다른 스레드는 작업을 계속할 수 있다.
- 커널이 제공하는 보호 기능 등을 사용할 수 있다
- 멀티 CPU를 사용할 수 있다
- 문맥 교환으로인한 오버헤드가 발생한다
  - 커널 입장에서 프로세스와 스레드를 구분하지 않는다. 두가지 모두 그냥 Task로 본다.


**멀티 레벨 스레드**

사용자 레벨 스레드와 커널 레벨 스레드를 혼합한 방식이다.
- M to N 모델이라 부른
- 하나의 커널 스레드가 대기 상태에 들어가면 다른 커널 스레드가 작업 하여 유연하게 작업을 처리할 수 있다
- 커널 스레드간 문맥교환으로 인해 오버헤드가 발생한다

## 스케줄링
### 스케줄링 개요

**CPU 스케줄링**은 어떤 작업에 CPU를 할당할 지 결정하는 작업이다. CPU 스케줄링이 중요한 이유는 **어떤 프로세스에 CPU를 할당하느냐에 따라서 시스템의 효율을 결정**하기 때문이다.

스케줄링 작업은 CPU 스케줄러가 수행한다. **CPU 스케줄러는 프로세스가 생성된 후 종료될 때까지 모든 상태변화를 조정**한다.

### 스케줄링 단계

- 고수준 스케줄링
  - 장기 스케줄링, 작업 스케줄링이라고도 한다.
  - 시스템 내의 전체 작업 수(프로세스의 수)를 조정하는 역할을 한다.
  - 고수준 스케줄링에 따라서 동시에 실행 가능한 프로세스의 총 개수가 결정된다.
  - time sharing system에서 고수준 스케줄링은 없다

- 저수준 스케줄링
  - 단기 스케줄링이라고도 부른다.
  - 가장 작은 단위의 스케줄링이 수행된다.
  - CPU를 할당할 프로세스를 결정한다.
  - 대기 상태로 보낼 프로세스를 결정한다.
   
- 중간 수준 스케줄링
  - 고수준과 저수준 스케줄링 사이에서 일어나는 스케줄링이다.
  - 중지(Suspend)와 활성화(Active)로 전체 시스템에 활성화된 프로세스 수를 조절하여 과부하를 막는다
  - 프로세스를 보류 상태로 이동시킨다.
  - 시스템에서 Active한 프로세스의 수를 결정한다

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148339221-4e4cab80-2308-4229-bc5a-914de088d4a9.png width=700>
</p>

### 스케줄링 목적
- 공평성
- 효율성
- 안정성
- 확장성
- 반응 시간 보장
- 무한 연기 방지

### 선점형과 비선점형 스케줄링

- 선점형 스케줄링: 어떤 프로세스가 CPU를 할당받아 실행 중이더라도 운영체제가 CPU를 강제로 빼앗을 수 있는 스케줄링 방식
  - 대표적인 선점형 스케줄링은 인터럽트 처리
    - 인터럽트가 발생하면 커널을 깨워서 인터럽트를 처리하고 다시 원래 작업으로 돌아간다.
  - 문맥 교환과 같은 부가적인 작업으로 인한 오버헤드가 발생할 수 있다
  - 한 프로세스가 CPU를 독점할 수 없기 때문에 대화형, 시분할 시스템에 적절하다.
  - 대부분의 저수준 스케줄러는 선점형 스케줄링 방식을 사용한다


- 비선점형 스케줄링: 어떤 프로세스가 CPU를 점유하면 다른 프로세스가 이를 빼앗을 수 없는 스케줄링 방식
  - 프로세스가 종료되거나 자발적으로 대기 상태에 들어가기까지 계속 실행된다
  - 선점형 보다 스케줄러의 작업량이 적고 문맥 교환에 의한 낭비도 적다
  - 전체 시스템의 효율이 떨어질 수 있다
  - 일괄 처리 시스템에서 적절하다

선점형 스케줄링 방식을 쓰더라도 비선점 프로세스가 존재할 수 있다. 예를 들어 시스템을 백업하는 프로세스는 비선점형으로 동작한다.

### 프로세스의 우선순위
대부분의 CPU 스케줄러는 프로세스마다 우선순위를 부여한다. 중요한 프로세스를 더 빨리, 더 자주 실행해야하기 때문이다.

따라서 커널 프로세스는 일반 프로세스보다 우선 순위가 더 높다.


### CPU 집중 프로세스와 입출력 집중 프로세스

- CPU 집중 프로세스
  - 수학 연산과 같이 CPU를 많이 사용하는 프로세스
  - CPU 버스트가 많은 프로세스

- 입출력 집중 프로세스
  - 저장 장치에서 데이터를 읽거나 쓰는 작업이 많은 프로세스
  - 입출력 버스트가 많은 프로세스

CPU 집중 프로세스와 입출력 집중 프로세스 중 입출력 집중 프로세스를 먼저 실행 시키는 것이 더 효율적이다. 입출력 집중 프로세스는 대기 상태로 옮겨져 CPU가 다른 프로세스의 작업을 수행할 수 있기 때문이다.

### 전면 프로세스와 후면 프로세스

- 전면 프로세스
  - GUI를 사용하는 운영체제에서 화면의 맨 앞에 놓인 프로세스
  - 현재 입력과 출력을 사용하는 프로세스
  - 사용자와 상호 작용이 가능하다

- 후면 프로세스
  - 사용자와 상호작용이 없는 프로세스

### 다중 큐

**준비 상태 다중 큐**

프로세스마다 중요도는 다르고 PCB에 그 중요도가 저장된다. CPU 스케줄러는 준비 상태의 프로세스 중 가장 높은 우선순위를 가진 프로세스를 선정해서 CPU를 할당한다. 매번 프로세스를 모두 탐색하는 것은 번거롭기 때문에 **우선순위에 따른 다중 큐**를 사용한다.

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148342146-dfc86a17-da32-44ad-b428-d00a1c8c748a.png 700>
</p>
 
준비 큐를 몇 개로 나눌 지, 어떤 프로세스에 CPU를 할당할 지는 스케줄링 알고리즘에 따라 달라진다.

프로세스의 우선순위를 배정하는 방식에는 고정 우선순위 방식, 변동 우선순위 방식이있다.

- 고정 우선순위
  - 운영체제가 프로세스에 우선순위를 부여한 후 변동되지 않는 방식
  - 구현은 쉽지만, 시스템의 변화에 대응하기 어렵다

- 변동 우선순위
  - 프로세스 작업 중간에 우선순위가 변경되는 방식
  - 구현하기 어렵지만, 시스템의 효율성을 높일 수 있다

우선순위가 낮은 P1프로세스가 중요한 자원을 독점하고 있다면, 이 자원을 사용하려는 다른 중요한 프로세스들은 P1의 작이 마칠때까지 대기해야한다. 하지만 P1의 우선순위를 높여 빨리 작업을 끝내게 하면 다른 중요한 프로세스가 자원을 얻어 작업을 진행할 수 있다.

낮은 우선순위의 프로세스를 높은 우선순위로 변경하는 방식을 반전 우선순위(우선순위 역전)이라 한다.

\
**대기 상태 다중 큐**

시스템 내에는 다양한 입출력 장치가 있다. 입출력이 완료된 경우 대기 상태의 모든 프로세스를 탐색하는 것은 번거롭기 때문에 시스템의 효율을 위해서 같은 입출력을 요구한 프로세스를 모아둔다.

**준비 큐는 한 번에 하나의 프로세스**를 꺼내어 CPU를 할당하는 반면, **대기 큐는 여러 개의 프로세스 제어 블록을 동시에 꺼내어 준비 상태로 옮긴다**.

시스템에는 많은 입출력 시스템이 있기 때문인데, 동시에 끝나는 인터럽트 처리를 위해 **인터럽트 벡터**라는 자료 구조를 사용한다. 인터럽트 벡터에는 동시에 완료된 입출력 정보와 처리 방법이 담겨있는데, 이 정보에 따라 완료된 프로세스 제어 블록은 모두 준비 상태로 이동한다.


## CPU 스케줄링 알고리즘

- 비선점형 알고리즘: FCFS, SJF, HRN
- 선점형 알고리즘: Round Robin(RR), SRT, 다단계 큐, 다단계 피드백 큐
- 둘 다 가능: 우선순위 큐


### FCFS
First Come First Serve 스케줄링은 준비 큐에 도착한 순서대로 CPU를 할당하는 비선점형 알고리즘이다. 초기 일괄처리 시스템에서 사용되었으며 큐가 하나라 모든 프로세스의 우선순위가 동일하다.

처리 시간이 긴 프로세스가 CPU를 차지하면 다른 프로세스들은 하염없이 기다려 시스템의 효율성이 떨어질 수 있다. 이러한 현상을 **콘보이(Convoy) 혹은 호위 효과**라고한다.

### SJF
Shortest Job First 스케줄링은 준비 큐에 있는 프로세스 중 실행 시간이 가장 짧은 작업부터 CPU를 할당하는 비선점형 스케줄링이다. SJF가 나타난 배경에는 FCFS의 콘보이 효과를 완화하기 위함이 있다.

SJF는 작업 시간이 적은 프로세스를 먼저 실행하기 때문에 시스템의 효율은 높아질 수 있다. 하지만 다음과 같은 문제로 실질적으로 사용하기 어렵다

- 운영체제가 프로세스의 종료 시간을 정확하게 예측할 수 없다.
  - 현대 프로세스는 사용자와 상호작용이 빈번하기 때문에 프로그램 종료 시간을 파악하기 어렵다.
- 공평하지 못하다
  - 작업 시간이 긴 프로세스가 준비 큐에 위치할 경우 작업이 계속 연기될 수 있어 **아사(Starvation) 현상**이 발생할 수 있다.

두 가지 문제의 해결책과 그 한계는 다음과 같다
- 프로세스가 자신의 작업 시간을 운영체제에게 알려준다
  - 프로세스가 자신의 작업 시간을 정확히 알기 어렵고, 악의적인 프로세스가 작업 시간을 속인다면 시스템의 효율성이 나빠질 수 있다.
- 에이징
  - 에이징은 프로세스가 양보할 수 있는 상한선을 정하는 것이다.
  - 에이징 값을 어떤 기준으로 정할지 자체가 문제가 된다는 한계가 있다.

### HRN
Highest Response Ratio Next 스케줄링은 SJF에서 발생할 수 있는 아사 현상을 해결하기 위해 만들어진 비선점형 알고리즘이다. 서비스를 받기 위한 대기 시간과 CPU 사용 시간을 고려하여 우선순위를 결정한다

```text
우선순위 = (대기시간 + CPU 사용시간) / CPU 사용시간
```

HRN 알고리즘은 대기 시간이 긴 프로세스의 우선순위를 높여 아사 현상을 완화할 수 있지만, 여전히 공평성이 위배될 수 있다.

### Round Robin
Round Robin(RR) 스케줄링은 한 프로세스가 할당받은 시간(타임 슬라이스)동안 작업을 하다가 작업을 완료하지 못하면 준비 큐의 맨 뒤로 가서 자기 차례를 기다리는 방식이다.

FCFS 방식과 유사하지만 가장 큰 차이점은 선점이 가능하고 타임 슬라이스가 존재한다는 것이다. 타임 슬라이스를 모두 사용한 프로세스는 강제로 준비 큐 맨 뒤로 이동하기 때문에 콘보이 효과를 완화한다.

**타임 슬라이스 크기와 문맥교환**
타임 슬라이스의 크기는 프로세스의 반응 시간뿐 아니라 시스템 전체 성능에 영향을 미칠 수 있다.

- 타임 슬라이스가 큰 경우
\
타임 슬라이스가 너무 큰 경우 FCFS와 크게 다를 것 없이 동작한다. 응답성이 하락한다.

- 타임 슬라이스가 작은 경우
\
타임 슬라이스가 너무 작은 경우 시스템 전체 성능이 떨어질 수 있다. 문맥 교환이 너무 자주 일어나 문맥 교환에 걸리는 시간이 실제 작업 시간보다 상대적으로 커지며, 문맥 교환에 많은 시간을 낭비하여 실제 작업은 하지 못하는 문제가 발생한다.

### Sortest Remaining Time
Sortest Remaining Time(SRT) 스케줄링은 SJF와 라운드 로빈 스케줄링을 혼합한 방식이다. 쉽게 말하면 SJF의 선점형 방식이다.

현재 실행 중인 **프로세스와 큐에 있는 프로세스의 남은 시간을 주기적으로 계산**해야하고, 남은 시간이 더 적은 프로세스와 **문맥 교환**해야 하므로 SJF에는 없는 작업이 추가된다. SJF와 마찬가지로 **프로세스의 종료 시간을 예측하기 어렵고 아사 현상이 발생**할 수 있다.

### 우선순위
프로세스는 중요도에 따라 우선순위를 가지는데, 이러한 우선순위를 반영한 스케줄링 방식이 우선순위 스케줄링이다. 선점형과 비선점형 스케줄링 방식에 모두 적용이 가능하다.

우선순위 스케줄링은 고정 우선순위 알고리즘과 변동 우선순위 알고리즘으로 나뉜다.

- 고정 우선순위 알고리즘
\
한 번 우선순위를 부여 받으면 종료될 때까지 우선수위가 고정된다. 구현이 단순하지만 변하는 시스템 상황을 반영하지  못한다

- 변동 우선순위 알고리즘
\
일정 시간마다 우선순위가 변한다. 일정 시간마다 우선 순위를 변경하기 때문에 구현이 복잡하지만, 시스템의 상황을 반영하여 효율적으로 운영이 가능하다.

예를 들어, 우선순위가 낮은 프로세스 A가 다른 중요한 프로세스가 사용할 자원을 독점하고 있을 때, 프로세스 A의 우선순위를 높여 먼저 실행되도록하여 중요 자원을 반환하도록 할 수 있다. 이를 우선순위 역전이라한다.

우선순위가 높은 프로세스에 CPU를 먼저 할당하므로 **공평성을 위배**하고 아사 현상을 일으킬 수 있다. 하지만 **중요도가 높은 프로세스를 먼저 실행**할 수 있으므로 시스템이 안정적으로 운영될 수 있다.

### 다단계 큐

우선순위에 따라 준비 큐를 여러개 사용하는 스케줄링이다. 우선순위에 따라 큐가 다단계로 나누어져 있다. 우선순위는 고정형 우선순위를 사용하고, 상단 큐에 있는 모든 프로세스의 작업이 끝나야 다음 큐에 위치한 프로세스의 작업을 수행한다.

- 우선순위에 따라 다양한 스케줄링이 가능한 선점형 방식이다.
- 우선순위에 따라 타임 슬라이스를 조절하여 시스템을 효율적으로 운영할 수 있다

하지만 우선순위가 낮은 프로세스는 작업이 연기될 수 있다. 이러한 문제점을 해결하기 위해 다단계 피드백 큐 스케줄링이 나타났다.

### 다단계 피드백 큐

다단계 피드백 큐는 다단계 큐 스케줄링과 동일하게 우선순위에 따른 여러 큐를 가진다. 하지만 다단계 피드백 큐는 프로세스가 CPU를 사용하고 난 후 프로세스의 우선순위가 낮아지는 변동형 우선순위 방식을 사용한다.

우선순위에 따라 타임 슬라이스의 크기를 다르게 하여, 우선순위가 낮은 프로세스가 좀 더 오랫동안 CPU를 사용할 수 있도록 보장한다. 마지막 큐는 FCFS와 동일하게 동작한다.

<p align=middle>
  <img src=https://user-images.githubusercontent.com/60502370/148675467-2d81807f-bbad-4bc7-b17f-92927f97d21a.png width=700>
</p>

프로세스가 타임 슬라이스를 모두 소진한 경우 우선순위가 낮은 큐로 이동하고, 모두 사용하지 못한 경우 원래 큐로 이동한다.

CPU 버스트가 큰 프로세스는 타임 슬라이스를 모두 소진할 확률이 높다. 따라서 타임 슬라이스를 모두 소진한 프로세스의 우선순위를 낮추고 타임 슬라이스를 크게하여 작업 시간을 보장한다. 

입출력 버스트가 큰 프로세스는 타임 슬라이스를 모두 소진하지 않을 확률이 높다. 따라서 계속 동일한 우선순위로 동작하여 사용자와의 응답성을 높일 수 있다.

하지만 여전히 우선순위가 낮은 프로세스의 작업이 지연될 수 있는데, 우선순위 역전이나 에이징 기법을 사용할 수 있다.