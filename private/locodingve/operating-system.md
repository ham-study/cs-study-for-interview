# Operating System

🗂 Contents

1. [운영체제소개](#운영체제소개)
2. [운영체제구조](#운영체제구조)
3. [프로세스](#프로세스)
4. [스레드](#스레드)
5. [CPU스케줄링](#CPU스케줄링)
6. [스케줄링알고리즘](#스케줄링알고리즘)
7. [인터럽트](#인터럽트)
8. [프로세스동기화](#프로세스동기화)
9. [교착상태](#교착상태)
10. [메모리관리](#메모리관리)
11. [가상메모리 개요](#가상메모리-개요)
<br><br>

# 운영체제소개


### 1. 운영체제 정의
- 하드웨어와 응용 프로그램 사이에서 인터페이스 역할을 하고 시스템의 자원과 동작을 관리하는 시스템 소프트웨어입니다.

### 2. 운영체제 역할
- User Interface(사용자에게 시스템을 편리하게 사용할 수 있도록 도와줍니다.)
    - CUI(Character User Interface) : 글자로 사용자 인터페이스를 제공하는 형태를 의미합니다.
    - GUI(Graphical User Interface) : 현재 우리가 사용하고 있는 그래픽 기반의 사용자 인터페이스를 의미합니다. 
    - EUCI(End-User Comfortable Interface) : 특정 디바이스에 제공되는 인터페이스를 의미합니다. 예를 들면 MP3에 보이는 사용자 인터페이스는 MP3 만을 위한 사용자 인터페이스 입니다. 
- Resource Management(주어진 자원을 잘 관리해서, 효율성을 높이는 역할을 합니다.)
    - HW resource (processor, memory, I/O devices, Etc.)
    - SW resource (file, application, message, signal, Etc.)
- Process and Thread management
- System management(시스템 보호, 사용자가 불법적으로 시스템을 사용하는 것으로부터 시스템을 보호하는 역할을 합니다.)

### 3. 운영체제의 기능
- 프로세스(Process) <b>관리</b> 
    - 생성/삭제, 상태 관리
    - 자원 할당
    - 프로세스 간 통신 및 동기화(synchronization)
    - 교착상태(deadlock) 해결
- 프로세서(Processor) <b>관리</b>
    - 프로세스 스케줄링 : 시스템 내의 프로세스 처리 순서 결정
- 메모리(Memory) <b>관리</b>
    - 프로세서에 대한 메모리 할당 및 회수
    - 메모리 여유 공간 관리
    - 각 프로세서의 할당 메모리 영역 접근 보호
- 파일(File) <b>관리</b>
    - 사용자 및 시스템의 파일 관리
- 입출력(I/O) <b>관리</b>
- 보조 기억 장치 및 기타 주변장치 <b>관리</b> 등




<br><br>

# 운영체제구조

![image](https://user-images.githubusercontent.com/88185304/147988857-99e207d1-7755-43d7-aa92-a34a69a91877.png)

![image](https://user-images.githubusercontent.com/88185304/147992446-226ee454-d54b-42a9-9d9c-10a0f87d192d.png)

### 1. 커널
-  커널(kernel)은 컴퓨터의 운영 체제의 핵심이 되는 컴퓨터 프로그램의 하나로, 시스템의 모든 것을 통제합니다.

- 커널 종류
    - 단일 구조

    ![image](https://user-images.githubusercontent.com/88185304/147993086-4c2cd760-f85e-467b-ba9f-fd9ae7e68dc5.png)

        - 장점 : 커널 내 모듈간 직접 통신 -> 효율적 자원 관리 및 사용 가능
        - 단점 : 커널의 거대화 -> 오류 및 버그, 추가 기능 구현 등 유지 보수가 어려움
    - 계층 구조

    ![image](https://user-images.githubusercontent.com/88185304/147993200-ee851b9c-4c82-4167-84ad-cc4595ffd443.png)
    
        - 장점 : 모듈화 -> 계층간 검증 및 수정 용의
        - 단점 : 단일구조 대비 성능 저하 -> 원하는 기능 수행을 위해 여러 계층을 거쳐야 함.
    - 마이크로 커널 구조

    ![image](https://user-images.githubusercontent.com/88185304/147993259-317dcb41-fad3-4862-833e-d1b664487665.png)

        - 특징 : 커널 크기의 최소화 -> 필수기능만 포함, 기타 기능은 사용자 영역에서 수행
    
### 2. 시스템 호출

- 커널이 제공하는 기능 중에서 사용자가 사용할 수 있는 기능들을 모아놓은 것들입니다.

<br>
<br>

# 프로세스

### 1. 프로세스 개념

#### 1-1. 프로세스 VS 작업(Job)
cf. Job/Program 개념과 비교하면 좀 더 쉽게 이해할 수 있다.

![image](https://user-images.githubusercontent.com/88185304/148149085-47c2cc7d-0b5c-40c2-9ea3-fd0c9bb0e7f9.png)

- 프로세스
    - 실행을 위해 시스템(커널)에 등록된 작업
    - 시스템 성능 향상을 위해 커널에 의해 관리되는 작업

- Job 
    - 실행할 프로그램 + 데이터
    - 컴퓨터 시스템에 실행 요청 전 상태

#### 1-2. 프로세스 정의
- 실행중인 프로그램
- 커널에 등록되고 커널의 관리하에 있는 작업
- 각종 자원들을 요청하고 할당 받을 수 있는 개체
- 프로세스 관리 븍록(PCB)을 할당 받은 개체


### 2. 프로세스 상태

프로세스 상탱는 자원 간의 상호작용에 의해 결정이 된다.

![image](https://user-images.githubusercontent.com/88185304/148150494-5366408d-3064-4125-b1e8-e9cf232bcbf2.png)

- Created State

![image](https://user-images.githubusercontent.com/88185304/148150764-78e9049b-53cb-45b4-bb06-c49fccfab7b3.png)

    - 작업을 커널에 등록되었으며, PCB 할당 및 프로세스 생성이 된 상태

- Ready State

![image](https://user-images.githubusercontent.com/88185304/148150979-bc27f004-3af0-4a5f-a31d-bf6cde130ff0.png)

    - 프로세서 외에 다른 모든 자원을 할당 받은 상태
    - 프로세서 할당 대기 상태
    - 즉시 실행 가능 상태

- Running State

![image](https://user-images.githubusercontent.com/88185304/148151152-a63b2ed2-49df-471d-81b8-079a1cd1681e.png)

    - 프로세서와 필요한 자원을 모두 할당 받은 상태
        - preemption : 프로세서 스케쥴링을 통해 Running state에서 Ready state으로 변경
        - Block/Sleep : I/O 등 자원 할당 요청으로 Running state에서 Asleep state로 변경

- Blocked/Asleep state

![image](https://user-images.githubusercontent.com/88185304/148151705-ff7571bf-b296-4130-860a-a3f4b57452fd.png)

    - 프로세서 외에 다른 자원을 기다리는 상태
        - 자원 할당은 system call에 의해 이루어짐

- Suspended State

![image](https://user-images.githubusercontent.com/88185304/148151897-95198fac-b050-47db-a9a7-bf56c70ed37d.png)

    - 메모리를 할당 받지 못한(빼앗긴) 상태
        - Memory image를 swap device에 보관 (swap device: 프로그램 정보 저장을 위한 특별한 파일 시스템) 

- Teminated/Zombie State

![image](https://user-images.githubusercontent.com/88185304/148152186-56e0de74-8791-4612-ace3-840770120eb5.png)

    - 프로세스 수행이 끝난 상태
    - 모든 자원 반납 후, 커널 내에서 (추후 프로세스 관리를 위해 정보 수집 목적으로) 일부 PCB 정보만 남아 있는 상태

### 3. 프로세스 제어 블록

![image](https://user-images.githubusercontent.com/88185304/148149869-226e4642-8998-48d6-ad5b-33b61f11cc41.png)

- PCB 
    - 커널 공간 내에 존재하며, OS가 프로세스 관리에 필요한 정보 저장
    - 프로세스가 생성될 때 생성됨
- PCB가 관리하는 정보
    - PID(Process Identification Number): 프로세스 고유 식별 번호
    - 스케줄링 정보 : 프로세스 우선순위 등과 같은 스케줄링 관련 정보들
    - 스로세스 상태 : 자원 할당, 요청 정보 등
    - 메모리 관리 정보 : Page table, Segment table
    - 입출력 상태 정보 : 할당 받은 입출력 장치, 파일 등에 대한 정보 등
    - 문맥 저장 영역 (context save area) : 프로세스의 레지스터 상태를 저장하는 공간 등
    - 계정 정보 : 자원 사용 시간 등을 관리 

    cf. PCB 정보는 os 마다 다르며, PCB 참조 및 갱신 속도는 os 의 성능을 결정하는 중요한 요소 중 하나가 된다.

### 4. 프로세스 큐(Queue)
프로세스는 수행하면서 상태가 여러 번 변하는데 이에 따라 서비스를 받아야하는 곳이 다르다. 그리고 프로세스는 일반적으로 여러 개가 한 번에 수행되므로 그에 따른 순서가 필요하다. 이러한 순서를 대기하는 곳을 큐(queue)라고 부른다.

![image](https://user-images.githubusercontent.com/88185304/148152771-3e5fa5c6-c1ea-4a83-8b95-2d06063ceb4f.png)

- Job Queue: 하드디스크에 있는 프로그램이 실행되기 위해 메인 메모리의 할당 순서를 기다리는 큐이다.
- Ready Queue: CPU 점유 순서를 기다리는 큐이다.
- Device Queue: I/O를 하기 위한 여러 장치가 있는데, 각 장치를 기다리는 큐가 각각 존재한다.

위와 같이 여러 큐가 존재하는데, 각 큐 내부에 저장된 실제 데이터는 각 프로세스의 PCB가 저장되어 있다.

### 프로세스 문맥 교환

![image](https://user-images.githubusercontent.com/88185304/148153031-96a023a1-c22b-460d-8011-8b77b8110b56.png)

- context : 프로세스와 관련전 정보들의 집합
    - CPU register context 는 CPU 내에 저장되어있음.
    - Code & Data, Stack, PCB는 메모리 내에 저장되어 있음.
- context saving : 현재 프로세스의 Register context를 저장하는 작업
- context restoring : register context를 프롯세스로 복구하는 작업
- context switching : 실행 중인 프로세스의 context를 저장하고, 앞으로 실행할 프로세스의 context를 복구하는 일 (커널의 개입으로 이루어짐)

<br><br>

# 스레드
멀티프로세싱 방식은 CPU에서 여러 프로세스를 스케쥴링 알고리즘을 통해 로테이션으로 처리됩니다. 이때 동작중인 프로세스가 대기 상태가 되면서 context 정보를 저장하고, 대기하고 있던 다음 순번의 프로레스가 동작하면서 이전에 보관했던 프로세스의 context를 복구하게 됩니다. 이를 context switching이라고 하는데, 프로세스는 각각 독립된 메모리 영역이다보니 캐쉬 메모리 초기화 등 꽤나 무거운 작업이 진행되어 오버헤드가 날 가능성이 커집니다. 이를 해결하기 위해 사용되는 개념이 스레드입니다. 

### 1. 스레드 개념
- 스레드(thread)는 어떠한 프로그램 내에서, 특히 프로세스 내에서 실행되는 흐름의 단위
- 일반적으로 한 프로그램은 하나의 스레드를 가지고 있지만, 프로그램 환경에 따라 둘 이상의 스레드를 동시에 실행할 수 있으며, 이러한 실행 방식을 멀티스레드(multithread)라고 함.
- 프로세서 활용의 기본 단위
- 제어 요소 외 코드, 데이터 및 자원들을 프로세스 내 다른 스레드들과 공유
- 구성요소 : Thread ID, Register set(PC, SP 등), Stack

< 개념 이해를 위한 이미지 >

![image](https://user-images.githubusercontent.com/88185304/148311902-b54ba355-aa9c-434c-92bb-401b9001182f.png)

< 메모리 관점으로 스레드 이해를 위한 이미지 >

![image](https://user-images.githubusercontent.com/88185304/148307176-00233f2d-4f03-47e4-9771-39b2c4e87c36.png)


### 2. 멀티 프로세스 VS 멀티 스레드
- 멀티프로세스

![image](https://user-images.githubusercontent.com/88185304/148309284-be257cee-0832-4fdb-bce8-f057488ead18.png)

    - 프로그램 실행시 Code, Data, Stack, Heap 구조로 되어있는 독립된 메모리 영역을 할당받습니다. 
    - 그러나 빈번한 context switching으로 오버헤드가 발생할 가능성이 커집니다.

- 멀티스레드

![image](https://user-images.githubusercontent.com/88185304/148309314-d5717a80-f613-4770-8494-aeacbb5309fe.png)

    - 스레드는 프로세스 내에서 각각 stack만 따로 할당을 받고, code, Data, Heap 영역을 공유합니다. 



### 3. 멀티스레드 장단점
- 장점 
    - 사용자 응담성 (Responseiveness) : 일부 스레드의 처리가 지연되어도, 다른 스레드는 작업을 계속 처리
    - 자원 공유 (Resource Sharing) : 자원을 공유해서 효율성 증가 (커널 개임을 피할 수 있음)
    - 경제성 (Economy) : 프로세스의 생성 및 context swich에 비해 효율적
    - 멀티 프로세서(multi-processor) 활용 : 병렬처리를 통해 성능 향상

- 단점 
    - 임계 영역(Critical Section, 둘 이상의 스레드가 동시에 실행하면 문제를 일으키는 코드 블록): 공유하는 자원에 동시에 접근하는 경우, 프로세스와는 달리 스레드는 데이터와 힙 영역을 공유하기 때문에 어떤 스레드가 다른 스레드에서 사용 중인 변수나 자료구조에 접근하여 엉뚱한 값을 읽어오거나 수정할 수 있음. 따라서 동기화가 필요!
    - 디버깅이 다소 까다로워진다. (버그 생성될 가능성 증가)


### 4. 멀티 스레드 모델
- 다대일(n:1) 모델 
    - 사용자 수준 스레드
- 일대일(1:1) 모델 
    - 커널 수준 스레드
- 다대다(n:m) 모델
    - n > m 
    - 혼합형 스레드


### 5. 사용자 레벨 스레드 커널 VS 레벨 스레드 VS 혼합형 스레드

![image](https://user-images.githubusercontent.com/88185304/148310730-7ff76661-7ce7-43f8-bf7f-c607df47704a.png)

- 사용자 레벨 스레드

    ![image](https://user-images.githubusercontent.com/88185304/148311080-f766144d-1b10-4e2f-88c9-ae7314c6dd42.png)

    - 사용자 영역의 스레드 라이브러리로 구현된다. 스레드 라이브러리는 통해 스레드 생성 및 스케줄링 등을 수행한다. 예를 들면 java thread API 등이 있다.
    - 커널은 스레드의 존재를 모른다. 그래서 커널의 개입을 받지 않을 수 있어 생성 및 관리의 부하가 적다. 그러나 커널은 하나의 프로세스 단위로 자원을 할당하기 때문에 하나의 스레드가 block 상태가 되면, 모든 스레드가 대기상태에 있게 된다. (single-thread kernel의 경우)

- 커널 수준 스레드

    ![image](https://user-images.githubusercontent.com/88185304/148311769-6f2cd03d-dede-43dd-8f8c-b8d0a01398d1.png)

    - OS(kernel)가 직접 관리한다. 그래서 커널 영역에서 스레드의 생성 및 관리를 수행하게 된다. 이 과정에서 context switching 등으로 오버헤드가 발생할 가능성이 커진다.
    - 커널이 각 스레드를 개벌적으로 관리를 하여, 프로세스 내 스레드들이 병렬 수행이 가능할 수 있게 해 준다. 그래서 하나의 스레드가 block 상태가 되어도 다른 스레드는 계속 작업 수행 가능하다.

- 혼합형 스레드
    - n개 사용자 수준 스레드 - m개의 커널 스레드 (n>m) : 사용자가 원하는 수만큼 스레드를 사용할 수 있다. 그리고 커널 스레드는 자신에게 할당된 하나의 사용자 스레드가 block 상태가 되어도, 다른 스레드의 수행이 가능하다. 
    - 효율적이면서도 유연하다. 


<br><br>

# CPU스케줄링

스케줄링이 왜 필요한가? 
- 여러 개의 프로세스가 시스템 내 존재하고있기 떄문에(다중프로그래밍) 자원을 할당한 프로세스를 선택하야 합니다. 이때 스케줄링이 필요합니다. 

### 1. 스케줄링 개념

#### 1-1. 목적 
- 시스템 성능을 향상
    - 성능 향상을 위해서는 목적에 맞는 지표를 고려하여 스케줄링 기법을 선택하여야 함.
    - 성능 지표로는 응답시간, 작업처리량, 자원활용도 등을 들 수 있다. 
#### 1-2. 성능지표

![image](https://user-images.githubusercontent.com/88185304/148482772-d89358aa-037a-4340-8a1a-bfa5b5722cae.png)

- 대기시간 (Waiting Time):
- 응답시간 (Response Time):
- 반환시간 (Turn-around Time):

#### 1-3. 스케줄링 기준
- 스케줄링 기준 : 스케줄링 기법이 고려하는 항목들을 의미
- 기준
    - 프로세스의 특성 : I/O-bounded or compute-bounded
    - 시스템 특징 : batch system or interactive system
    - 프로세스의 긴급성 : Hard or Soft real time
    - 프로세스 우선순위
    - 프로세스 총 실행시간 
    ...

### 2. 스케줄링 레벨


#### 2-1. 장기 스케줄링(Long-term scheduling)
- Job scheduling : 커널에 등록할 작업(Job)을 결정
- 시스템 내에 프로세스 수를 조절함 (다중프로그래밍 정도를 조절)
- 특정 프로세스가 놀 수 있기 때문에, I/O-bounded와 compute-bounded 프로세스들을 잘 섞에서 선택해야 함.

#### 2-2. 중기 스케줄링(Mid-term scheduling)
- Memory allocation

#### 2-3. 단기 스케줄링(Short-term scheduling)
- process scheduling : 프로세서를 할당한 프로세스를 결정
- 가장 빈번하게 발생하기 때문에 매우 빨라야 함.

![image](https://user-images.githubusercontent.com/88185304/148484023-38df761e-aa51-43ab-a6ff-fb62ac7085e1.png)

<br>

### 3. 스케줄링 정책

#### 3-1. premptive/non-preemptive
- premptive scheduling
    - 타인에 의해 자원을 빼앗길 수 있음
    - context switch overhead가 발생 가능성이 큼
    - time-sharing system, real-time system 등에 적합

-  non-preemptive scheduling
    - 할당 받은 자원을 스스로 반남할 때까지 사용 
    - context switch overhead 발생 가능성이 적음
    - 잦은 우선순위 역전, 평균 응답 시간 증가
    - 예로는 system call, I/O 등

#### 3-2. priority
- 프로세스의 중요도를 의미함
- 종류
    - 정적 우선순위
        - 프로세스 생성시 결정된 priority가 유지됨
        - 구현이 쉽고, overhead 가능성이 적음
        - 시스템 환경 변화에 대한 대응이 어려움

    - 동적 우선순위
        - 프로세스의 상태 변화에 따라 priority 변경
        - 구현이 복잡, priority 재계산으로 overhead 가능성이 큼
        - 시스템 환경 변화에 유연한 대응이 가능

</br></br>


# 스케줄링알고리즘

![image](https://user-images.githubusercontent.com/88185304/148717476-1353a94e-14a7-46d5-8b3d-c82faa9b99a8.png)


<br>

### FCRS(First-Come-First-Service)

![image](https://user-images.githubusercontent.com/88185304/148715663-eeff6a22-e3b5-4f97-a354-092651f870c7.png)

- 사용하는 정책 : Non-preemptive scheduling
- 스케줄링 기준 (Criteria)
    - 도착시간 (ready queue 기준)
    - 먼저 도착한 프로세스를 먼저 처리
- 적합한 시스템 
    - batch system, interactive system
- 장점 
    - 자원을 효율적으로 사용 가능(먼저 도착한 프로세스를 먼저 처리하여, 스케줄링 오버해드가 낮음 그리고 cpu가 쉬지 않고 계속 사용할 수 있음)
- 단점 
    - Convoy effect : 하나의 수행시간이 긴 프로세스에 의해 다른 프로세스들이 긴 대기 시간을 갖게 되는 현상 (대기시간 > 실행시간)
    - 긴 평귱 응답시간

<br>

### RR(Round-Robin)

![image](https://user-images.githubusercontent.com/88185304/148716080-1b05e0da-3ac1-4063-90de-5b263c180056.png)

- 사용하는 정책 : Preemptive scheduling
- 스케줄링 기준 (Criteria)
    - 도착 시간 (ready queue 기준)
    - 먼저 도착한 프로세스를 먼저 처리
- 특징
    - <b>자원 사용 제한 시간(time quantum)이 있음</b>
    - system parameter
    - 프로세스는 할당된 시간이 지나면 자원 반납 (timer-runout)
- 적합한 시스템 
    - interactive system, time sharing system
- 장점
    - 특정 프로세서의 자원 독점 방지
- 단점    
    - Context switch overhead가 큼

<br>

### SPN(Shortest-Process-Next)

- 사용하는 정책 : Non-preemptive scheduling
- 스케줄링 기준 (Criteria)
    - 실행시간 (burst 기준)
    - burst time 가장 작은 프로세스를 먼저 처리 
- 장점 
    - 평균 대기시간 최소화
    - 시스템 내 프로세스 수 최소화 (스케줄링 부하 감소, 메모리 절약 -> 세스템 효율 향상)
    - 많은 프로세스들에게 빠른 응답시간 제공
- 단점 
    - Starvation(무한대기) 현상 발생: BT가 긴 프로세스는 자원을 할당 받지 못 할 수 있음. (Aging 등으로 해결, ex HRRN)
    - 정확한 실행 시간을 알 수 없음 : 실행시간 예측기법 필요

<br>

### SRTN(Shortest Remaining Time Next)

- 사용하는 정책 : Preemptive scheduling (잔여 실행 시간이 더 적은 프로세스가 ready 상태가 되면 선점됨)
- 특징 
    - SPN의 변형
- 장점 
    -  SPN의 장점 극대화
- 단점 
    - 프로세스 생성시, 총 실행 시간 예측이 필요함.
    - 잔여 실행을 계혹 추적해야 함 = overhead
    - context switching overhead


<br>

### HRRN(High-Response-Ratio-Next)

- 사용하는 정책 : SPN + <b>Aging concepts</b>, Non-preemptive sheduling
    - Aging concepts란? 프로세스의 대기 시간을 고려하여 기회를 제공
- 특징 
    - SPN의 변형
- 스케줄링 기준(Creteria)
    - response ratio 가 높은 프로세스 우선 (Response ratio = (WT+BT)/BT, 실행시간 대비 얼마나 기다렸는가?)
- 장점
    - SPN의 장점 극대화
    - Starvation 현상 방지
- 단점
    - 실행 시간 예측 기법 필요 (overhead)

<br>

### MLQ(Multi-level Queue)

![image](https://user-images.githubusercontent.com/88185304/148717821-216ada7f-26af-4325-914d-bc0511147e88.png)

- 특징
    - 작업(or 우선순위)별 별도의 ready queue를 가짐
        - 최초 배정된 queue를 벗어나지 못함
        - 각각의 queue는 자신만의 스케줄링 기법 사용
    - Queue 사이에는 우선순위 기반의 스케줄링 사용 (ex, fixed-priority preemptive scheduling)
- 장점
    - 우선순위가 높음 프로세스들의 빠른 응답시간
- 단점
    - 여러 개의 Queue 관리 등 스케줄링 overhead
    - 우선순위가 낮은 queue는 starvation 현상 발생가능

<br>

### MFQ(Multi-level Feedback Queue)

![image](https://user-images.githubusercontent.com/88185304/148718064-58310a3e-12ff-4e08-8880-830e8afdfc03.png)

- 특징
    - 프로세스의 queue 간 이동이 허용된 MLQ
    - Feadback을 통해 우선 순위 조정 (현재까지의 프로세서 사용 정보(패턴) 활용)
    - Dynamic priority
    - Preempive scheduling
    - Favor short burst-time process
    - Favor I/O bounded process
    - Improve adaptablility
- 장점 
    - 프로세스에 대한 사전 정보 없이 SPN, SRTN, HRRN 기법의 효과를 볼 수 있음

</br></br>

# 인터럽트

### 인터럽트 개념

- 예상치 못한, 외부에서 발생한 이벤트

### 인터럼트 종류

- I/O interrupt
- Clock interrupt
- Console interrupt
- Program check interrupt
- Machine check interrupt
- Inter-process interrupt
- System call interrupt


### 동기적 인터럽트, 비동기적 인터럽트

- 동기적 인터럽트 : 실행 중인 명령어로 인해 발생 하는 인터럽트
    - 프로그램 상의 문제 때문에 일어나는 인터럽트 (다른 프로세스의 메모리에 접근 등)
    - 입출력 장치의 조작
    - 수를 0으로 나눔

- 비동기적 인터럽트 : 실행 중인 명령어와 무관하게 발생하는 인터럽트(하드웨어와 관련된 것이 다수)
    - 하드디스크 읽기 오류
    - 메모리 불량


### 인터럽트 처리 과정

![image](https://user-images.githubusercontent.com/88185304/148773144-19bec776-4ef8-416f-9959-fcd12a751f1d.png)

1. 인터럽트 발생
2. 커널이 개입하여, 진행중이 프로세스 중단
3. context saving 발생, PCB에 프로세스 정보 저장(책갈피 저장)
4. 인터럽트 발생 장소 및 원인을 파악한 뒤, 인터럽트 서비스를 할 것인지 결정(인터럽트 핸들링)
5. 인터럽트 서비스 루틴 호출 (인터럽트 서비스)
6. Ready Queue에 있던 대기 상태의 프로세스에게 프로세서 할당하여, 프로세스 실행

### 인터럽트 우선 순위

1. 전원이상: 정전 인터럽트
2. 기계 착오: 기계 이상의 의해서 발생한 인터럽트
3. 외부 신호: 외부 프로세서 드으이 요청에 의해 발생한 인터럽트
4. 입출력
5. 프로그램 검사: 불법적인 연산자 사용, Overflow/Underflow 인터럽트
6. SVC: 제어 프로그램 호출 인터럽트


### 인터럽트 이중 모드

- 프로세스 → 커널 프로세스와 사용자 프로세스로 나눌 수 있음
- 커널 프로세스가 실행되는 상태 → 커널 모드
- 사용자 프로세스가 실행되는 상태 → 사용자 모드
- 이중 모드 ( dual mode )
    - 사용자 프로세스에서, 하드디스크 입출력, 프로세스 생성 등 커널의 기능을 사용하기 위해서 사용자모드 → 커널모드로 전환 하며 일 처리를 하는 모드
    - 운영체제가 자원을 보호하기 위해 사용하는 기법
    - 커널은 시스템 호출을 통해서만 자원에 접근하도록 허용
    - 사용자 프로세스가 커널 모드에서 실행되지 못하도록 막음
    - 이러한 시스템 호출 위해 API를 제공
    - 이렇게 사용자가 커널 모드로 진입 하는 경우는, "시스템 호출을 사용 한 경우, 인터럽트를 발생 시킨 경우"로 두가지 경우가 있음


### DMA 와 인터럽트

- DMA(Direct Memory Access): 주변 장치들이 메모리에 직접 읽거나 쓸 수 있는 기능
- DMA가 없다면 : DMA를 사용하지 않으므로 주변 장치와 메모리에 데이터 전송이 발생할 때 마다 CPU가 처리하여, 처리 효율이 떨어짐
- DMA가 있다면(Processor with DMA): CPU가 해야할 주변장치와 데이터 전송을 DMA가 해줌으로서 효율을 높임
    (DMA가 주변장치의 데이터 전송이 필요하다면, DMA controller에게 DMA Reqeust(전송데이터 크기, 주소, 추가정보 포함)를 송신한다. 그리고 DMA controller를 통해 주변 장치와 메모리 사이에 데이터를 전송하며, 전송이 완료되면 인터럽트를 발생시켜 CPU에게 전송이 끝남을 알린다.)

</br></br>

# 프로세스동기화

### 프로세스 동기화의 필요성

- 다중 프로그래밍 시스템에서 여러개의 프로세스들이 서로 독립적으로 동작을 합니다. 공유 자원또는 데이터가 있을 때 문제가 발생할 수 있는데,(= 병행 수행중인 비동기적 프로세스들이 공유 자원에 동시 접근 할 떄 문제가 발생할 수 있음) 이때 프로세스들 간 동작을 맞추고 공유하는 동기화가 필요합나다.


### 공유자원, 경쟁상태, 임계구역

- 공유 데이터(shared data or critical data) : 여러 프로세스들이 공유하는 데이터

- 임계 영역(critical section) : 공유 데이터를 접근하는 코드 영역

![image](https://user-images.githubusercontent.com/88185304/149049121-5f4f499d-ba3a-4e04-9d0f-b683bec566f3.png)
(기계어 명렁의 특징 : 원자성을 갖는다. 즉 한 기계어 명령의 실행 도중에 인터럽트를 받지 않는다.)

![image](https://user-images.githubusercontent.com/88185304/149051557-712e9fe7-0302-4ece-bb3d-fe9517412837.png)
(Race condition : 명령 수행 순서에 따라 결과가 달라지는 상태를 의미합니다.)

- 상호 배제(mutual exclusion) : 둘 이상의 프로세스가 동시에 임계 영역에 진입하는 것을 막는 것
    - 상호배제의 메소드들
        - Multual exclusion primitive(기본연산)
            - enterCS() primitive
                - 임계영역 진입 전 검사
                - 다른 프로세스가 임계영역 안에 있는지 검사
            - exitCS() primitive
                - 임계영역을 벗어날 때의 후처리 과정
                - 임계영역을 벗어남을 시스템이 알림

    - 상호배제 기본연상의 조건
        - 상호배제(Mutual exclusion) : 임계영역에 프로세스가 있으며, 다른 프로세스의 집입을 금지시킴
        - 진행(Progress) : 임계영역 안에 있는 프로세스 외에는, 다른 프로세스가 임계영역에 진입하는 것을 방해하면 안됨
        - 한정 대기(Bounded waiting) : 프로세스의 임계영역 진입은 유한 시간 내에 허용되어야 함

### Dekker's Algorithm

![image](https://user-images.githubusercontent.com/88185304/149053752-1698c1cb-b5d9-46bb-aa71-f0fd8dba20e1.png)

- Two process ME(상호배제)를 보장하는 최초의 알고리즘

### Peterson's Algorithm

![image](https://user-images.githubusercontent.com/88185304/149054145-b9f9a7f3-9252-44e5-bf07-16d59ae049b7.png)

- Dekker's algorithm 보다 간단하게 구현

### Semaphore(세마포어)

![image](https://user-images.githubusercontent.com/88185304/149061301-44dadb56-32f7-4aa5-9802-1676472a4de5.png)

- 세마포어는 자원의 개수를 의미합니다. 즉 동시에 자원에 접근할 수 있는 허용가능한 카운터의 개수입니다. 
    - 동기화 기법 중, 추상적인 방법
    - 세마포어는 여러 프로세스들에 의해 공유되는 변수로 정의
    - 이 변수는 오직 P()와 V()라는 원자적인 연산에 의해서만 접근 가능
    - 리소스의 상태를 나타내는 카운터라고 생각하면 됨.
    - 임의의 변수 하나에 ready queue 하나가 할당 됨

- 장점 : No busy waiting (기다려야 하는 프로세스는 block 상태가 됨)
- 단점 : Semaphore queue에 대한 wake-up 순서는 비결정적이라서 기아 현상이 일어날 수 있다.

### Mutex(뮤텍스)

- 뮤텍스는 상호배제를 뜻하며, Binary Semaphore와 같은 의미이다. 즉 자원에 단 하나의 작업만이 접근할 수 있다는 뜻이다. 
- 임계 영역을 가진 스레드들의 Running Time이 서로 겹치지 않게 각각 단독으로 실행되게 하는 기술이다. 다중 프로세스들의 공유 자원에 대한 접근을 조율하기 위해 lock과 unlock을 사용한다. 
- 세미포어와의 가장 큰 차이점은 동기화 대상의 개수이다. 뮤텍스는 동기화 대상이 오직 하나 뿐일 때, 세마포어는 동기화 대상이 하나 이상일 때 사용한다.

### Monitor(모니터)

![image](https://user-images.githubusercontent.com/88185304/149060769-6a0e21df-ea31-498e-96a8-0ab030e3b790.png)

- 모니터 내에서는 한 번에 하나의 프로세스만 활동이 가능하다. 프로그래머가 동기화 제약 조건을 명시작으로 코딩할 필요가 없다. 또한 프로세스가 모니터 안에 기다릴 수 있도록 Condition variable을 사용한다. 이는 wait/signal 연산에 의해서만 접근이 가능하다.
- 모니터와 세마포어의 차이점은 모니터는 자체적으로 하나의 프로세스만 처리한다. 반면 세마포어는 직접 락을 걸고 해제해야 한다. 

- 장점 : 사용이 쉽고, Deadlock 등 error 발생 가능성이 낮다.
- 단점 : 지원하는 언어에서만 사용이 가능하며, 컴파일러가 OS를 이해하고 있어야 한다. (임계영역 접근을 위한 코드 생성)

</br></br>

# 교착상태

### 교착상태 정의

- 개념
    - 프로세스가 발생 가능성이 없는 이벤트를 기다리는 상태를 의미합니다. (프로세스가 교착상태에 있음)
    - 시스템 내에 교착상태에 빠진 프로세스가 있는 경우를 의미합니다. (시스템이 교착상태에 있음)

- 교착상태 VS 기아현상

    ![image](https://user-images.githubusercontent.com/88185304/149260680-9954f40d-be05-428b-ae96-2f32b6c3dba0.png)

    - 어떤 자원을 기다리는지 다름 : **자원 또는 이벤트를 기다림** VS 프로세서 할당 기다림
    - 어떤 상태에서 일어나는지 다름 : **asleep(block) 상태** VS ready 상태
    - 기다리는 것이 일어날 가능성 : **가능성 없음** VS 일어날 가능성은 있지만 오랫동안 대기 상태임


### 교착상태를 발생시킬 수 있는 조건

- 상호배제(Mutual Exclusion): **한 번**에 **한 개**의 프로세스만이 공유 자원을 사용할 수 있습니다. 
- 비선점(Non-preemption) : 다른 프로세스에 할당된 자원은 사용이 **끝날 때까지 강제로 빼앗을 수 없어야**합니다. 
- 점유와 대기(Hold and Wait) : **최소한 하나의 자원을 점유하고 있으면서** 다른 프로세스에 할당되어 사용되고 있는 자원을 **추가로 점유하기 위해 대기**하는 프로세스가 있어야 합니다. 
- 환형대기(Circular wait) : 공유자원과 공유자원을 사용하기 위해 대기하는 프로세스들이 **원형**으로 구성되어 있어 자신에게 할당된 자원을 점유하면서 앞이나 뒤에 있는 프로세스의 자원을 요구해야 합니다. 

### 교착상태 표현법

- Graph Model

![image](https://user-images.githubusercontent.com/88185304/149262715-0155f68c-1290-4e69-93a3-01c4a8718f63.png)

- State Transition Model
    - 가정
        - 2개의 프로세스와 A type의 자원 2개(unit) 존재
        - 프로세스는 한 번에 자원 하나만 요청/반납 가능
    - state

        ![image](https://user-images.githubusercontent.com/88185304/149262882-183f5a3a-55a4-4b83-bba4-b77f7766aa4a.png)

    - Model

        ![image](https://user-images.githubusercontent.com/88185304/149262951-3a5a982d-7918-41e9-9340-3cdae075fa28.png)


### 교착상태 해결방법

- 예방기법

    - 개념
        - 교착상태 예방 기법은 교착상태가 발생하지 않도록 사전에 시스템을 제어하는 방법으로 교착상태 발생의 **네가지 조건 중에서 어느 하나를 제거**함으로써 수행됩니다. 
    - 단점 
        - **자원 낭비가 가장 심한** 기법입니다.
        - **비현실적입**니다. 
    - 방법
        - 상호 배제(Mutual Exclusion)부정 : 한 번에 여러개의 프로세스가 공유 자원을 사용할 수 있도록 합니다.
        - 점유 및 대기(Hold and Wait) 부정 : 프로세스가 실행되기 전 필요한 모든 자원을 할당하여 프로세스 대기를 없애거나 자원이 점유되지 않은 상태에서만 자원을 요구하도록 합니다.
        - 비선점(Non-preemption)부정 : 자원을 점유하고 있는 프로세스가 다른 자원을 요구할 때 점유하고 있는 자원을 반납하고, 요구한 자원을 사용하기 위해 기다리게 합니다.
        - 환형 대기(Circular Wait)부정 : 자원을 선형 순서로 분류하여 고유 번호를 할당하고, 각 프로세스는 현재 점유한 자원의 고유 번호보다 앞이나 뒤 어느 한쪽 방향으로만 자원을 요구하도록 하는것입니다.

- 회피기법

    - 개념
        - 교착상태 회피 기법은 교착상태가 발생할 가능성을 배제하지 않고 교착상태가 발생하면 적절히 **피해나가는 방법**으로, 주로 은행원 알고리즘(Banker's Algorithm)이 사용됩니다.
    - 방법
        - 은행알고리즘

            ![image](https://user-images.githubusercontent.com/88185304/149265424-aaa0d400-9189-45be-9939-bcc289db5ff6.png)

            - 은행원 알고리즘은 다익스트라가 제안한 기법으로, 은행에서 모든 고객의 요구가 충족되도록 현금을 할당하는데서 유래한 기법입니다.
            - 각 프로세스에게 자원을 할당하여 교착상태가 발생하지 않으며 모든 프로세스가 완료될 수 있는 상태를 안전상태, 교착상태가 발생할 수 있는 상태를 불안전 상태라고 합니다.
            - 은행원 알고리즘을 적용하기 위해서는 자원의 양과 사용자(프로세스) 수가 일정해야 합니다.
            - 은행원 알고리즘은 프로세스의 모든 요구를 유한한 시간안에 할당하는 것을 보장합니다.
        - Habermann's 알고리즘
            - 은행알고리즘 확장형 (자원이 더 많아졌고, 내용은 비슷함)
    - 단점
        - 항상 시스템을 **감시**하고 있어야 한다. -> overhead 발생
        - safe state 유지를 위해, 사용되지 않는 자원이 존재한다.
        - **비현실적**이다. 
            - 가정 : 프로세스 수, 자원수가 고정되어있고, 필요한 최대 자원수를 알고 있다는 가정

- 발견기법

    - 개념
        - 교착상태 발견 기법은 시스템에 교착상태가 발생했는지 점검하여 교착상태에 있는 프로세스와 자원을 **발견**하는 것을 의미합니다.
    - 방법
        - 교착상태 발견 알고리즘과 자원 할당 그래프 등을 사용 할 수 있습니다.
    - 단점
        - 검사 주기에 영향을 받는다.
        - node 수가 많은 경우 overhaed가 발생할 수 있다. 
    

- 회복기법

    - 개념
        - 교착상태 회복 기법은 교착상태를 일으킨 프로세스 중 일부를 종료하거나 교착상태의 프로세스에 할당된 자원을 선점하여 프로세스나 자원을 회복하는 것을 의미합니다.
    - 방법

        ![image](https://user-images.githubusercontent.com/88185304/149267297-4fcb068a-6716-4840-8a8e-6c341d414769.png)

        ![image](https://user-images.githubusercontent.com/88185304/149267411-dc849140-7ffa-4845-8de3-9f487dc540dc.png)

        - 프로세스 종료 : 교착상태에 있는 프로세스 중 일부를 종료하는 것으로, 교착상태에 있는 모든 프로세스를 종료하는 방법과 교착상태에 있는 프로세스들을 하나씩 종료해가며 교착상태를 해결하는 방법이 있습니다.
            - 기준
                - 종료시 비용이 적게 되는 프로세스 먼저 종료하기
                    - 장점 : 간단하고, overhead가 적다
                    - 단점 : 중요한 프로세스가 종료될 가능성이 높다.
                - 모든 경우를 생각해서 최적의 비용이 드는 프로세스를 먼저 종료
                    - 단점 : 복잡하여, overhaed 가능성이 크다. 

        - 자원선점 : 교착상태의 프로세스가 점유하고 있는 자원을 선점하여 다른 프로세스에게 할당하며, 해당 프로세스를 일시 정지시키는 방법입니다. 우선순위가 낮은 프로세스, 수행된 정도가 적은 프로세스, 사용되는 자원이 적은 프로세스 등을 위주로 해당 프로세스의 자원을 선점합니다.
            - 자원 선점시 주의사항 
                - 자원 을 선점할 프로세스 선택 문제 : 최소의 피해를 줄 수 있는 프로세스를 선택합니다.
                - 자원을 선점한 프로세스의 복귀 문제 : 자원이 부족한 상태이므로 대부분 일시 중지시키고 다시 시작하는 방법을 사용합니다.
                - 기아 현상 문제 : 한 프로세스가 계속하여 자원 선점 대상이 되지 못하도록 고려해야 합니다.
    - 전략
        - checkpoint-restart method
            - 프로세스의 수행 중 특정 지점(checkpoint)마다 context 저장
            - Rollback하기 위해, 프로세스를 강제 종료한 후 가장 최근의 checkpoint에서 재시작

### 식사하는 철학자 문제

- 문제 설명

    철학자 다섯이서 원형 식탁에 둘러앉아 생각에 빠지다가, 배고플 땐 밥을 먹는다. 그들의 양쪽엔 각각 젓가락 한 짝씩 놓여있고, 밥을 먹으려 할 땐 다음의 과정을 따른다.

    - 왼쪽 젓가락부터 집어든다. 다른 철학자가 이미 왼쪽 젓가락을 쓰고 있다면 그가 내려놓을 때까지 생각하며 대기한다.
    - 왼쪽을 들었으면 오른쪽 젓가락을 든다. 들 수 없다면 1번과 마찬가지로 들 수 있을 때까지 생각하며 대기한다.
    - 두 젓가락을 모두 들었다면 일정 시간동안 식사를 한다.
    - 식사를 마쳤으면 오른쪽 젓가락을 내려놓고, 그 다음 왼쪽 젓가락을 내려놓는다.
    - 다시 생각하다가 배고프면 1번으로 돌아간다.

- 문제 
    식사하는 철학자 문제는 교착상태(Deadlock)의 대표적인 예제이다.
    위의 상황을 프로그램으로 만들어 실행하면 잘 돌아가다가 어느순간 멈춰버리는 것을 확인할 수 있는데, 그 이유는 식사하는 철학자 문제가 데드락 발생의 4가지 필요조건을 모두 만족하고 있기 때문이다. 만약 모든 철학자가 동시에 배가 고파서 왼쪽 젓가락을 집어든다면 어떻게 될까? 오른쪽 젓가락은 이미 자신의 우측에 앉은 철학자가 집어들었을 것이므로, 모두가 영원히 오른쪽 젓가락을 들지 못하게 된다. 그렇게 상단 과정의 2번에서 더이상 진행하지 못하고 철학자들은 영원히 생각에 빠지게 되는데, 이런 현상을 컴퓨터과학에선 교착상태(Deadlock)라고 한다. 한번 교착상태에 빠진 철학자들은 계속 고뇌만 하다가 기아현상(Starvation)으로 굶어 죽는다.

- 교착상태(Deadlock) 해결 방법
    - 짝수인 철학자는 왼쪽부터, id가 홀수인 철학자는 오른쪽부터 젓가락을 집어들게 하면 교착상태가 일어나지 않게 한다.

<br><br>

# 메모리관리

### 메모리(기억장치)의 종류

![image](https://user-images.githubusercontent.com/88185304/149438443-2e38844f-18e1-4d97-b78b-d85f89bccaee.png)

### 메모리관리의 필요성

- 여러 프로세스가 한정된 자원을 사용하기 떄문에 메모리가 관리가 필요하다.
- 메모리 자원을 효율적으로 사용하기 위해(메모리를 관리하지 않으면 메모리를 낭비될 수 있는 경우가 발생할 수 있다. 예로는 외부적 단편화가 발생하여 메모리 자원이 있음에도 사용하지 못하는 상황이 발생할 수 있다.)

### 고정 분할 방식(Fixed partition multi-programming, FPM)

- 특징
    - 미리 메모리 공간을 고정된 크기로 분할되어 있음.
    - 각 프로세스는 하나의 partition(분할)에 적재될 수 있음.
    - 커널 및 사용자 영역을 보호하기 위해 boundary address을 미리 알고 있음.

    ![image](https://user-images.githubusercontent.com/88185304/149442481-fe88787b-7a73-4724-aebe-36dc6e5964dc.png)

- 장점 
    - 미리 메모리 공간이 분할되어 있기 때문에, 메모리 관리가 간편하다. 

- 단점
    - internal/external fragmentation이 발생하여, 시스템 자원이 낭비될 수 있다.


### 가변 분할 방식(Variable partition multi-programming, VPM)

- 특징 
    - 초기에는 전체가 하나의 영역
    - 프로세스를 처리하는 과정에서 메모리 공간이 동적으로 분할됨.

    ![image](https://user-images.githubusercontent.com/88185304/149443014-702d21f4-f288-4fa7-904e-ee2971a020f9.png)

- 장점 
    - internal fragmentation이 일어나지 않음.

- 단점
    - external fragmentation 발생

- 프로세스가 반납한 메모리에 새로운 process에 할당하기 위한 배치 전략

    ![image](https://user-images.githubusercontent.com/88185304/149443861-ecb6ab1d-de83-4cfc-bad1-0f1f967e1529.png)

    - First-fit(최초 적합)
        - 충분한 크기를 가진 첫번째 partition을 선택
        - 간단하여 overhead 발생가능성 적음
        - 그러나 공간 활용률이 떨어질 수 있음
    - Best-fit(최적 적합)
        - process가 들어갈 수 있는 partition 중 가장 작은 곳 선택
        - 모든 partition을 확인해야 함으로, 탐색시간이 오래 걸림
        - 크기가 큰 partition을 유지할 수 있음.
        - 그러나 활용하기에는 너무 작은 크기의 partition이 많이 발생할 가능성이 큼
    - Worst-fit(최악 적합)
        - process가 들어갈 수 있는 partition 중 가장 큰 곳 선택
        - 모든 partition을 확인해야 함으로, 탐색시간이 오래 걸림
        - 활용하기에는 너무 작은 크기의 partition 발생을 줄일 수 있음
        - 큰 프로세스에게 필요한, 큰 크기의 partition 화보가 어려울 수 있음
    - Next-fit(순차 최초 접합)
        - 최초 적합 전략과 유사하지만, state table에서 마지막으로 탐색한 위치부터 탐색
        - 메모리 영역의 사용 빈도 균등화
        - 간단하여 overhead 발생가능성 적음

- external fragmentation 발생을 해결하기 위한 전략
    - Coalescing holes (공간 통합)
        - 인접한 빈 영역을 하나의 partition으로 통합
        - process가 메모리를 반납하고 나가면 수행
        - overhead 발생 낮음
    - Storage compaction (메모리 압축)
        - 모든 빈 공간을 하나로 통합
        - 프로세스 처리에 필요한 적재 공간 확보가 필요할 때 수행
        - 메모리 압축시, 모든 프로세스를 (중지하고) 재배치해야 함으로 많은 시스템 자원을 소비함(overhead 발생 가능성 큼)
        - 많은 시스템 자원을 활용하기 때문에, 자주하면 안됨 -> 각 os 마다 주기가 다름.

### 32bit VS 64bit

![image](https://user-images.githubusercontent.com/88185304/149444791-8902aacf-cb37-45d5-8f6f-e146e1d2a7b4.png)

- 주기억장치와 레지스터 사이의 데이터 전송단위(word)가 32bit냐 64bit냐의 차이에 따라 32bit CPU, 64bit CPU 라고 일컸는다. 

- 차이점
    - 주기억장치와 레지스터 사이의 데이터 전송 단위가 다르다.
    - 전송단위가 다르면서 발생한 차이점으로, 32bit cpu는 4GB이상을 데이터를 처리할 수 없다.(=주소값이 32bit를 넘어가기 때문에 32bit 시스템에서는 인식되지 않는다.) 그에 반해, 64bit는 가능하다. 
        - 2^32 = 4.294,967,296 = 2^30 * 2^2 -> 약 4GB (1GB -> 약 2^30)
        - 2^64 = 2^60 * 2^4 GB = 61EB(엑사바이트)

</br></br>

# 가상메모리 개요

### 가상메모리 정의

- 메모리가 실제 메모리보다 많아 보이게 하는 기술로, 어떤 프로세스가 실행될 때 메모리에 해당 프로세스 전체가 올라가지 않더라도 실행이 가능하다는 점에 착안하여 고안되었습니다. 
    - 사용자 프로그램을 여러 개의 block으로 분할한 후, 실행시 필요한 blodk들만 메모리에 적재하는 기법 (나머지 block 들은 swap device에 존재)

### 가상메모리 필요성

- 일반적으로 한 시스템의 여러 프로세스들은 CPU와 메인 메모리를 공유한다. CPU를 공유하는 부분에 대해서는 일반적으로 순서를 기다리느라 단지 느려질 뿐이고 심각한 오류는 발생하지 않는다. 그러나 프로세스들이 존재하는 메모리가 여유가 없이 지나치게 많은 요구에 의해 오염될 경우, 프로그램의 논리와 무관하게 오류가 난다. 이를 방지하기 위한 기술이 바로 가상메모리이다.

- 이러한 가상메모리 기술은 사용자가 신경 쓸 필요 없이 OS 측에서 자동으로 작동하며 사용자가 프로세스를 올리고 내림에 있어서 역시 사용자가 신경 쓸 필요 없이 OS의 가상메모리를 활용하여 자동으로 메모리 관리를 위임할 수 있다는 장점이 있다.

### 페이징 기법

- 특징
    - 프로그램을 고정된 크기(논리적 크기 X)의 block으로 분할(page) / 메모리를 block size로 미리 분할(page frame)
        - 외부 단편화 문제 없음
        - 메모리 통합/압축 불필요
        - 프로그램의 논리적 구조 고려하지 않음 -> page sharing/protection 이 복잡
    - 필요한 page만 page frame에 적재하여 사용 -> 메모리 효율적 활용
    - page mapping overhead 발생 가능성 있음
        - 메모리 공간 및 추가 적인 메모리 접근이 필요
        - 전용 HW 활용으로 해결 가능 -> 하드웨어 비쌈

- virtual address : v = (p, d)
    - p : page number
    - d : offset

- address mapping 
    - PMT(Page Map Table) 사용

- address mapping mechanism
    - Direct mapping(직접 사상)

        ![image](https://user-images.githubusercontent.com/88185304/149689551-19472c70-bc59-4fc3-8a50-ba4e37dda029.png)

        - Block mapping 방식과 유사
        - 가정
            - PMT를 커널 안에 저장
            - PMT entry size = entrySize
            - page size = pageSize
        - 문제점
            - 메모리 접근 횟수가 2배 -> 성능 저하 유발
            - PMT를 위한 메모리 공간 필요
        - 해결방안
            - Associative mapping(TLB)
            - PMT를 위한 전용 기억장치(공간) 사용

    - Associative mapping(연관 사상)

        ![image](https://user-images.githubusercontent.com/88185304/149689835-1270dfa3-fcdd-4fec-9053-ae780260cbf8.png)

        - TLB(translation look-aside buffer)에 PMT 적재
        - PMT를 병렬 탐색
        - Low overhead, high speed
        - 비싼 하드웨어 필요

    - Hybrid direct/associative mapping

        ![image](https://user-images.githubusercontent.com/88185304/149690147-b8749a36-735a-4b38-8ffb-28fc5b77d720.png)

        - 두 기법을 혼합하여 사용함으로서, HW 비용은 줄이고, Associative mapping 장점 활용
        - 작은 크기의 TLB를 사용함
            - PMT : 메모리(커널 공간)에 저장
            - TLB : PMT 중 일부 entry들을 적재 -> 최근에 사용된 page 들에 대한 entiry 저장 (지역성 활용)


### 세크먼테이션 기법

- 특징
    - 프로그램을 논리 단위로 분할(segment) / 메모리를 동적으로 분할
        - 내부 단편화 문제가 없음
        - segment sharing/protection이 용이함
        - paging system과 비교하여 관리 overhaed가 큼
    - 필요한 segment만 메모리에 적재하여 사용
    - segment mapping overhead
        - 메모리 공간 및 추가적인 메모리 접근이 필요
        - 전용 HW 활용으로 해결 가능

- virtual address : v = (s, d)
    - s : segment number
    - d : offset

- SMT(Segment Map Table) 사용

- address mapping mechanism
    - paging system과 유사함

    ![image](https://user-images.githubusercontent.com/88185304/149692496-4cd53fd0-2189-456a-9ece-c2f9cd408fcc.png)


### Hybrid Paging/Segmentation 기법

- 특징
    - 논리적 분할와 고정 크기 분할을 결합
        - page sharing/protection이 쉬움
        - 메모리 할당/관리 overhead 가능성 적음
        - external fragmentation 문제 없음
    - 전체 테이블의 수 증가
        - 메모리 소보가 크다
        - address mapping 과정이 복잡
    - Direct mapping 의 경우, 메모리 접근이 3배 
        - 성능 저하를 이르킬 수 있음
        - 그럼에도 불구하고 장점이 많아서 많이 사용하는 기법

- virtual address : v = (s, p, d)
    - s : segment number
    - p : page number
    - d : offset

- SMT(Segment Map Table) 와 PMT(Page Map Table) 모두 사용

- address mapping mechanism
    - Direct, associated 등
    
    ![image](https://user-images.githubusercontent.com/88185304/149694251-08e43a20-d488-4727-ae99-6fcd8478953f.png)


</br></br>


## 출처

- https://www.youtube.com/watch?v=EdTtGv9w2sA&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN

- https://velog.io/@codemcd/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9COS-5.-%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4-%EA%B4%80%EB%A6%AC
- https://ko.wikipedia.org/wiki/%EC%8A%A4%EB%A0%88%EB%93%9C_(%EC%BB%B4%ED%93%A8%ED%8C%85)
- https://eun-jeong.tistory.com/20
- https://magi82.github.io/process-thread/
- https://www.crocus.co.kr/1255
- https://mindstation.tistory.com/164
- https://kangraemin.github.io/operation%20system/2020/10/20/interrupt/
- https://velog.io/@audgus47/UART-Interrupt-DMA-%EB%B0%A9%EC%8B%9D
- https://coding-factory.tistory.com/311
- https://m.blog.naver.com/hirit808/221788147057
- https://ahnanne.tistory.com/15
- https://namu.wiki/w/%EA%B0%80%EC%83%81%20%EB%A9%94%EB%AA%A8%EB%A6%AC?from=%EA%B0%80%EC%83%81%EB%A9%94%EB%AA%A8%EB%A6%AC