## CPU 스케줄링

> 👉**CPU스케쥴링이 필요한 이유**
>
> - 연산작업같이 CPU를 길게 쓰는 프로세스인 **CPU bound 프로세스**와 I/O 입력이 필요한 사용자 프로세스같이 CPU를 짧게 쓰는 **I/O bound 프로세스**가 섞여있기 때문에 시스템 자원을 효율적으로 사용하기 위해 CPU 스케쥴링이 필요하다.

> 👉**CPU Scheduler** 🆚 **Dispatcher**
>
> - CPU Scheduler : Ready 프로세스 中 이번에 CPU를 할당받을 프로세스를 고르는 코드
> - Dispatcher : CPU의 제어권을 CPU scheduler가 고른 프로세스에게 넘기는 코드(문맥교환)

### 1️⃣장기 스케줄링

- 메모리 스케쥴러
- 시작 프로세스 中 Ready Queue로 보낼 프로세스를 결정하는 스케쥴링
- time sharing system에는 보통 장기 스케쥴러가 없고, 무조건 ready시킨다.

> **👉장기스케쥴러 대체**
>
> - [https://jhnyang.tistory.com/372](https://jhnyang.tistory.com/372)

### 2️⃣단기 스케줄링

- CPU 스케쥴러
- CPU를 어떤 프로세스에게 줄 지 고르는 스케쥴링
- time interrupt걸릴 때마다 호출되므로(자주 호출) 빨라야한다.

### 3️⃣중기 스케줄링

- Swapper(프로세스에서 메모리를 뺏는 swap)
- 여유공간 마련을 위해 프로세스를 통째로 메모리에서 디스크로 보내는 스케쥴링

## 스케줄링 알고리즘

### 1️⃣FCFS

- 프로세스 도착순서대로 프로세스를 할당해주는 비선점 방식 스케쥴링
- 장점 : starvation이 없다
- 단점 : cpu를 오래 사용하는 프로세스가 먼저 오는 경우 비효율적이게 된다.

### 2️⃣Round Robin

- 프로세스에 동일한 cpu할당시간을 주고, 할당시간을 초과한 프로세스는 다시 ready queue에 넣고 다음 프로세스가 cpu를 할당받을 수 있도록 하는 선점 방식 스케쥴링
- 장점
    - starvation이 없다
    - 응답시간이 비교적 짧다
- 단점 : cpu 할당시간이 너무 짧아지면 문맥교환이 자주 일어나 오버헤드가 커진다.

### 3️⃣Priority scheduling

- 중요도에 따른 우선순위를 반영한 스케쥴링
- 선점, 비선점 방식으로 구현할 수 있다.
- 단점
    - 우선순위가 낮은 프로세스의 starvation → aging(기다리는 시간이 길수록 우선순위가 증가)을 통해 해소
    - 우선순위를 바꾸는 과정에서의 오버헤드

> **👉우선순위 스케쥴링 종류**
>
> 1. **SJF(Shortest-Job First)**
     >     - 프로세스의 cpu burst time 순으로 할당해주는 우선순위 스케쥴링
>     - 선점, 비선점 방식으로 구현할 수 있다.
>     - 장점 : 대기시간이 짧다.
>     - 단점
        >         - cpu burst time이 긴 프로세스의 starvation
>         - cpu burst time을 예측하기 어렵다(과거 cpu burst time을 통해 예측)
> 2. **SRT(SJF + RR)**
     >     - Round Robin방식으로 진행되는데 ready queue가 SJF방식과 같이 cpu burst time 순 우선순위 큐인 선점 방식 스케쥴링
>     - 장점 : 평균 대기 시간이 짧다
>     - 단점
        >         - 문맥교환으로 인한 오버헤드
>         - cpu burst time을 예측하기 어렵다

### 4️⃣Multilevel Queue

- Ready Queue를 여러 개로 분할하고 각 큐가 독립적인 스케줄링 알고리즘을 가지는 스케줄링
    - 보통 interactive 프로세스가 우선순위가 높으며 상위 큐(foreground)에 대기하고, 연산작업 같은 batch 프로세스가 우선순위가 낮고 하위 큐(batch)에 대기한다.
    - 상위 큐가 다 처리되면 하위 큐를 처리하기 시작한다.
- 단점
    - 프로세스는 다른 큐로의 이동이 불가능하기 때문에 우선순위가 낮은 프로세스의 starvation이 생길 수 있음 → 각 큐에 cpu 할당시간을 적절한 비율로 할당하여 해결

### 5️⃣Multilevel Feedback Queue

- Ready Queue를 여러 개로 분할하고, 각 큐는 하위로 갈수록 타임 슬라이스가 커지는 RR방식 큐로 구현한 스케쥴링
    - 상위 큐에서 선점당한 프로세스는 우선순위가 낮아지고, 타임 슬라이스가 좀 더 큰 하위 큐로 이동한다.(aging)
- 프로세스가 다른 큐로의 이동이 가능하고 우선순위가 변하는 변동 우선순위 알고리즘
- 오늘날 os가 일반적으로 사용하는 cpu 스케쥴링 알고리즘

## 인터럽트

### 1️⃣인터럽트

- CPU가 프로세스를 실행하고 있을 때, 입출력 하드웨어 등의 장치에 예외상황이 발생하여 처리가 필요할 경우에 CPU에게 알려 처리할 수 있도록 하는 것

### 2️⃣인터럽트 처리 과정

- 인터럽트 당한 시점의 **레지스터**와 **PC**(program counter : 다음번에 실행할 명령어 주소) 를 PCB(Process Control Block)에 저장해두고 CPU의 제어를 **인터럽트 서비스 루틴**(Interrupt Service Routine)에 넘긴다.
- 인터럽트 서비스 루틴이 끝나면 레지스터와 PC값을 복원하여 이전 실행위치로 복원한다.

### 3️⃣동기적 인터럽트, 비동기적 인터럽트

- 동기적 인터럽트
    - 소프트웨어가 발생시키는 인터럽트
    - **`Exception`**, `**software interrupt**`
    - 소프트웨어 생성 인터럽트들은 명령어 때문에 인터럽트가 발생하므로 **동기**
    - Exception : 프로세스가 권한없는 코드를 실행하거나 할 수 없는 연산을 실행하는 경우
    - System call : 프로세스가 커널함수를 호출하는 경우
- 비동기적 인터럽트
    - 하드웨어(I/O)가 아무때나 발생시키는 인터럽트
    - `**interrupt**`, `**hardware interrupt**`
    - 입출력과 같은 외부 개체들은 실행되는 명령어와 무관하게 작동하므로 **비동기**

### 4️⃣인터럽트와 이중 모드

- mode bit
    - 유저 프로세스가 컴퓨터에 치명적인 명령어를 사용할 수 없도록 하는 보호장치 [→ 자세히](https://velog.io/@codemcd/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9COS-3.-%EC%9D%B4%EC%A4%91%EB%AA%A8%EB%93%9C%EC%99%80-%EB%B3%B4%ED%98%B8)
    - 하드웨어적으로 두 가지 모드(이중 모드)의 operation 지원
        - 1 유저모드
        - 0 모니터모드/커널모드

  > **👉CPU 수행명령**
  >
  > - **일반 명령** : 메모리에서 자료를 읽어오고 계산을 하는 등 모든 프로그램이 수행(mode bit가 0, 1일 때 모두 수행가능)할 수 있는 명령
  > - **특권 명령** : I/O나 timer에 접근하는 등 보안을 해칠 수 있어 OS만 수행할 수 있는(mode bit가 커널모드인 0일 때만 수행가능) 명령
- 시스템콜
    - 운영체제의 서비스(ex. I/O입력)를 받기위해 스스로 인터럽트를 걸어 커널함수를 호출해 os로 cpu를 권한을 넘긴다

  > **👉시스템콜부터 인터럽트 과정**
  >
  >
  > 프로세스A가 디스크로 부터 파일을 읽어오라는 명령을 실행한다고 했을 때
  >
  > 1. A가 시스템 콜을 요청하면서 CPU 내에 인터럽트 라인을 세팅한다.
  > 2. CPU는 실행 중이던 명령어를 마치고 인터럽트 라인을 통해 인터럽트가 걸렸음을 인지한다.
  > 3. 사용자 모드에서 커널 모드로 변경 후 OS에게 CPU 제어권을 넘긴다.
  > 4. 현재 실행 중이던 프로세서의 상태 및 정보를 **PCB**(Process Control block)에 저장한다
  > 5. **PC**(Problem Counter, 다음 실행할 기계어의 메모리 주소를 가진 register)에는 다음에 실행할 명령어의 주소를 저장한다.
  > 6. 시스템 콜 루틴에 해당하는 곳으로 점프하고, 시스템 콜 테이블을 참조하여 파일 읽기에 해당하는 시스템 콜을 실행한다.
  > 7. 해당 루틴이 끝나면, 다시 사용자 모드로 바꾸고, PCB에 저장했던 프로세스를 복원한다.
  > 8. PC에 저장되어 있던 주소로 점프하여 계속 프로세스를 진행한다.

---

> 🔗**참고**
>
> - 인터럽트
>     - [https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=shj1126zzang&logNo=90193106131](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=shj1126zzang&logNo=90193106131)
>     - [http://melonicedlatte.com/computerarchitecture/2019/02/12/213856.html](http://melonicedlatte.com/computerarchitecture/2019/02/12/213856.html)
>     - [https://jdh5202.tistory.com/424](https://jdh5202.tistory.com/424)
>     - [https://medium.com/@lazypanda43/인터럽트-종류와-처리과정과-우선순위-c95c26909472](https://medium.com/@lazypanda43/%EC%9D%B8%ED%84%B0%EB%9F%BD%ED%8A%B8-%EC%A2%85%EB%A5%98%EC%99%80-%EC%B2%98%EB%A6%AC%EA%B3%BC%EC%A0%95%EA%B3%BC-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-c95c26909472)
>     - [https://guimong.tistory.com/entry/인터럽트와-예외](https://guimong.tistory.com/entry/%EC%9D%B8%ED%84%B0%EB%9F%BD%ED%8A%B8%EC%99%80-%EC%98%88%EC%99%B8)
>     - [https://watchout31337.tistory.com/193](https://watchout31337.tistory.com/193)
>     - [https://doh-an.tistory.com/31](https://doh-an.tistory.com/31)
> - CPU 스케줄링
>     - [https://hidemasa.tistory.com/51](https://hidemasa.tistory.com/51)
>     - [https://velog.io/@chappi/OS는-할껀데-핵심만-합니다.-6편-스케줄링3-선점형-스케줄링-알고리즘Round-Robin-SRT-우선-순위-방식-Multilevel-Queue](https://velog.io/@chappi/OS%EB%8A%94-%ED%95%A0%EA%BB%80%EB%8D%B0-%ED%95%B5%EC%8B%AC%EB%A7%8C-%ED%95%A9%EB%8B%88%EB%8B%A4.-6%ED%8E%B8-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%813-%EC%84%A0%EC%A0%90%ED%98%95-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Round-Robin-SRT-%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%EB%B0%A9%EC%8B%9D-Multilevel-Queue)
>     - [https://www.crocus.co.kr/1375](https://www.crocus.co.kr/1375)