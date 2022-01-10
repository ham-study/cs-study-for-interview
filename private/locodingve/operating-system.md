# Operating System

🗂 Contents

1. [운영체제소개](#운영체제소개)
2. [운영체제구조](#운영체제구조)
3. [프로세스](#프로세스)
4. [스레드](#스레드)
5. [CPU스케줄링](#CPU스케줄링)

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

## 출처

- https://www.youtube.com/watch?v=EdTtGv9w2sA&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN
- https://www.youtube.com/watch?v=jZuTw2tRT7w&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=5
- https://velog.io/@codemcd/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9COS-5.-%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4-%EA%B4%80%EB%A6%AC
- https://ko.wikipedia.org/wiki/%EC%8A%A4%EB%A0%88%EB%93%9C_(%EC%BB%B4%ED%93%A8%ED%8C%85)
- https://eun-jeong.tistory.com/20
- https://magi82.github.io/process-thread/
- https://www.crocus.co.kr/1255
