# Operating System

🗂 Contents

1. [운영체제소개](#-운영체제소개)
2. [운영체제구조](#-운영체제구조)

<br>

## 운영체제소개


### 운영체제 정의
- 하드웨어와 응용 프로그램 사이에서 인터페이스 역할을 하고 시스템의 자원과 동작을 관리하는 시스템 소프트웨어입니다.

### 운영체제 역할
- User Interface(사용자에게 시스템을 편리하게 사용할 수 있도록 도와줍니다.)
    - CUI(Character User Interface) : 글자로 사용자 인터페이스를 제공하는 형태를 의미합니다.
    - GUI(Graphical User Interface) : 현재 우리가 사용하고 있는 그래픽 기반의 사용자 인터페이스를 의미합니다. 
    - EUCI(End-User Comfortable Interface) : 특정 디바이스에 제공되는 인터페이스를 의미합니다. 예를 들면 MP3에 보이는 사용자 인터페이스는 MP3 만을 위한 사용자 인터페이스 입니다. 
- Resource Management(주어진 자원을 잘 관리해서, 효율성을 높이는 역할을 합니다.)
    - HW resource (processor, memory, I/O devices, Etc.)
    - SW resource (file, application, message, signal, Etc.)
- Process and Thread management
- System management(시스템 보호, 사용자가 불법적으로 시스템을 사용하는 것으로부터 시스템을 보호하는 역할을 합니다.)

### 운영체제의 기능
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




<br>

## 운영체제구조

![image](https://user-images.githubusercontent.com/88185304/147988857-99e207d1-7755-43d7-aa92-a34a69a91877.png)
![image](https://user-images.githubusercontent.com/88185304/147992446-226ee454-d54b-42a9-9d9c-10a0f87d192d.png)

### 커널
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
    
### 시스템 호출

- 커널이 제공하는 기능 중에서 사용자가 사용할 수 있는 기능들을 모아놓은 것들입니다.


</br>
</br>

## 출처


- https://www.youtube.com/watch?v=EdTtGv9w2sA&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN