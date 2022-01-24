# Network

🗂 Contents

1. [OSI 모델과 TCP/IP 모델](#OSI-모델와-TCP/IP-모델)
    - [기본 개념 정리](###기본-개념-정리)
    - [계층 모델의 장점](###계층-모델의-장점)
    - [OSI 모델](###OSI-모델)
        - [응용 계층 (application layer)](####응용-계층-(application-layer))
        - [표현 계층 (presentation layer)](####표현-계층-(presentation-layer))
        - [세션 계층 (session layer)](####세션-계층-(session-layer))
        - [전송 계층 (transport layer)](####전송-계층-(transport-layer))
        - [네트워크 계층 (network layer)](####네트워크-계층-(network-layer))
        - [데이터 링크 계층 (data link layer)](####데이터-링크-계층-(data-link-layer))
        - [물리 계층 (physical layer)](####물리-계층-(physical-layer))
    - [TCP/IP 모델](###TCP/IP-모델)
        - [네트워크 인터페이스 계층 (network layer)](####네트워크-인터페이스-계층-(network-layer))
        - [인터넷 계층 (internet layer)](####인터넷-계층-(internet-layer))
        - [전송 계층 (transport layer)](####전송-계층-(transport-layer))
        - [응용 계층 (application layer)](####응용-계층-(application-layer))
    - [OSI 모델과 TCP/IP 차이점](###OSI-모델과-TCP/IP-차이점)
2. [TCP와 UDP](#TCP와-UDP)
    - [TCP(Transmission Control Protocol)](###TCP(Transmission-Control-Protocol))
        - [TCP란?](####-TCP란?)
        - [TCP Header](####TCP-Header)
        - [TCP 3way handshake](####TCP-3way-handshake)
        - [TCP 4way handshake](####TCP-4way-handshake)
        - [흐름제어](####흐름제어)
        - [혼잡제어](####혼잡제어)
        - [오류제어](####오류제어)
        - [문제점](####문제점)
    - [UDP](###UDP(User-Datagram-Protocol))
        - [UDP란?](####DUP란?)
        - [UDP Header](####UDP-Header)
3. [IPv4 VS IPv6](#IPv4-VS-IPv6)


<br>

# OSI 모델와 TCP/IP 모델

### 기본 개념 정리

![image](https://user-images.githubusercontent.com/88185304/150045680-b758fcee-56f0-43f0-8c87-0c34e7522907.png)

- Encapsulation는 발신 컴퓨터에서 발생합니다. 프로토콜 정보가 데이터에 추가되는 과정을 의미합니다.
- Decapsulation 수신 컴퓨터에서 발생합니다. Decapsulation 프로세스에서 캡슐화 과정에서 붙은 헤더와 트레일러가 제거됩니다.
- 헤더란 데이터 앞에 추가된 정보를 의미하고, 트레일러는 데이터 뒤에 추가된 정보를 의미합니다.
- 순서 제어는 전송되는 데이터의 순서를 조율하고 이를 통해 데이터가 중복되거나 유실되는지 확인하는 것을 의미합니다.
- 흐름 제어 : 송신되어 데이터의 양과 전송률을 제한하는 기능을 의미합니다.
- 오류 제어 : 데이터가 올바르게 수신되었는지 에러 검출 코드를 통해 체크하는 기능을 의미합니다.
- 계층 별 PDU (OSI 7계층에서 PDU(Process Data Unit)란 각 계층에서 전송되는 단위)

    ![image](https://user-images.githubusercontent.com/88185304/150050471-5a990ddf-6db0-400b-a1d4-f89c625f1b4e.png)

    - 1계층 : Bits
    - 2계층 : Frames
    - 3계층 : Packets
    - 4계층 : Segments
    - 5~7계층 : Data


### 계층 모델의 장점

- 데이터 흐름을 한 눈에 파악하기 쉽습니다.
- 표준화된 규칙을 기반으로 하기 떄문에 다른 제조사 장비들끼리도 통신이 가능합니다.
- 장애 처리시, 계층별로 체크하면 되기 때문에 장애 대응에 유리합니다.
- 다른 계층끼리는 각 전달 과정을 알 필요 없이 자신의 계층에만 집중하면 됩니다. 따라서 캡슐화와 은닉이 가능합니다.


### OSI 모델

OSI(Open System interconnection) 7계층 : 2개의 시스템이 연결하기 위해서 일련의 절차들을 7단계로 나눈 것을 의미합니다.

![image](https://user-images.githubusercontent.com/88185304/150044571-e4747d4c-2e64-4ebb-80a6-31914e733540.png)

#### 응용 계층 (application layer)

    application을 편지지라고 가정했을 때, 편지지를 활용하여 편지를 작성할 수 있는 계층이라고 할 수 있습니다.

- 사용자와 가장 밀접한 계층으로 인터페이스 역할을 담당합니다.
- 응용 프로세스 간의 정보 교환을 담당합니다.
- 사용자에게 보이는 유일한 계층입니다.

#### 표현 계층 (presentation layer)

    말 그대로 표현하는 계층입니다. 내가 영어로 편지를 쓸지, 한국어로 편지를 쓸지 정하여 표현하는 계층입니다. 내가 영어로 쓴 편지를 상대방이 읽으려면, 제가 어떤 언어로 작성했는지 알아야겠쥬?

- 데이터를 어떻게 표현할지 결정하는 역할을 합니다. (데이터의 형식 결정)
- 송신자에게서 온 데이터를 해석하기 위한 데이터 부호화, 변화 담당합니다.
- 데이터의 인코딩, 디코딩 담당을 당담합니다.
- 데이터의 암호화, 복호화 담당을 당담합니다.

#### 세션 계층 (session layer)

    어떤 방식으로 편지를 주고 받을 지 정하는 겁니다. 예를 들어, 편지를 보내는 이와 받는 이가 채팅처럼 주고 받을지, 알림처럼 보내는 이만 전달을 할지, 썅방으로 막 보낼지를 정해야 합니다. 

- 통신 장치 간 상호작용 및 동기화를 당담합니다.
- 연결 세션에서 데이터 교환과 에러 발생시 복구를 관리합니다.
- OS가 세션 계층에 속합니다.

#### 전송 계층 (transport layer)

    우체국에 가서 편지를 부치고자 합니다. 편지 봉투에 누가 보냈고 누가 받는지 적습니다. 이때 적는 내용은 port 정보를 적습니다. 그리고 우체국 직원에게 일반으로 보낼지 등기로 보낼지를 정하여 말씀드려야 합니다.

- 종단 간 신뢰성 있고 정확한 데이터 전송을 담당합니다.
- 데이터 전송을 위해 Port 번호 사용합니다.
- 주로 TCP, UDP 프로토콜을 사용합니다.
- 송신자와 수신자 간의 신뢰성있고 효율적인 데이터 전송을 위해 오류 검출 및 복구, 흐름제어와 중복검사등 수행합니다.

#### 네트워크 계층 (network layer)

    편지 봉투에 구체적인 주소(ip)를 적는 단게입니다. 본 편지가 어느 경로를 통해서 이동해야 하는지에 대한 정보를 주소는 담고 있어야 합니다. (to 서울시 영등포구 당산로 .. 로 적힌 편지의 이동 : 서울특별시 -> 영등포구 -> 당산로 -> ... )

- 라우팅(Routing)기능을 담당합니다. 즉, 목적지까지 가장 빠르고 안전하게 데이터를 보낼 최적의 경로를 설정하는 역할을 합니다.  
- 주소(IP)를 정하고 경로(Route)를 선택해 패킷(packet)을 전달합니다.

    - 패킷이란?
        정보 기술에서 패킷 방식의 컴퓨터 네트워크가 전달하는 데이터의 형식화된 블록입니다. 패킷은 제어 정보와 사용자 데이터로 이루어지며, 이는 페이로드라고도 합니다. 패킷을 지원하지 않는 컴퓨터 통신 연결은 단순히 바이트, 문자열, 비트를 독립적으로 연속하여 데이터를 전송합니다. 데이터가 패킷으로 형식이 바뀔 때, 네트워크는 장문 메시지를 더 효과적이고 신뢰성 있게 보낼 수 있습니다.

#### 데이터 링크 계층 (data link layer)

    편지가 건물까지 도착!! 어? 근데 몇 층이고 몇 번지지?

- 물리적인 연결을 통하여 인접한 두 장치의 신뢰성 있는 정보 전송을 담당합니다.
- MAC 주소를 통해서 통신합니다.
- 헤더에는 수신 측에 프레임이 도착했음을 알리는 비트(Preamble)가 있고, 트레일러에는 프레임의 끝을 나타내는 비트와 오류를 제어하는 비트(FCS) 등이 있습니다.
- 한 번에 전송할 데이터양을 조절하고, 연속으로 프레임을 전송할 때 수신 여부를 확인하는 기능을 수행합니다.
- 허브를 사용(LAN 통신)하면 데이터 간의 충돌이 발생하는데 이를 제어하기 위해 CSMA/CD를 사용합니다.

    - 스위치란?
        - 데이터 링크 계층의 네트워크 접속 장치입니다.
        - MAC 주소 테이블(브릿지 테이블)이 있는데 이 테이블은 스위치의 포트 번호와 해당 포트에 연결되어 있는 컴퓨터의 MAC 주소가 등록되어 있는 데이터베이스입니다.

#### 물리 계층 (physical layer)

- 전기적 신호 처리합니다.
- 프레임(Frame)이라는 단위를 사용합니다.
- 신호의 전기적 특성과 데이터 전송에 필요한 순서를 정의합니다.
- 단지 데이터 전달의 역할을 할 뿐, 알고리즘이나 오류제어 기능이 없습니다.


### TCP/IP 모델

OSI 7계층 보다 조금 간소화된 모델이라고 볼 수 있습니다. 그러나 OSI 모델로부터 진화한 계층 모델이 아닌, TCP/IP 모델은 그 자체의 별도의 모델이라고 볼 수 있습니다.(심지어 OSI 모델보다 TCP/IP가 먼저 등장하였습니다.) 또한 SSL, TLS을 설명하고자 할 때는 TCP/IP 모델이 OSI 보다 더 잘 들어맞을 수 있습니다. 

![image](https://user-images.githubusercontent.com/88185304/150044726-3b7bfef2-753c-4175-b744-d02f5aaa8012.png)

#### 네트워크 인터페이스 계층 (network layer)

- OSI 모델에서 물리 계층과 데이터 링크 계층에 해당하는 계층입니다. 
- 네트워크 드라이버와 같은 물리적 TCP/IP  패킷의 전달 및 수신 과정에 대해 담당하고 있는 계층입니다. 

#### 인터넷 계층 (internet layer)

- OSI 모델에서 네트워크 계층과 대응되는 계층입니다. 
- 논리적인 주소인 ip 주소를 판독하고 목적지의 네트워크를 찾아가서 해당 목적지(host)가 잘 받을 수 있도록 전송하는 역할만 합니다.

#### 전송 계층 (transport layer)

- OSI 모델에서 전송 계층과 동일한 계층입니다. 
- 전달되는 패킷의 오류를 검사하고 재전송을 요구하는 등의 전반적인 제어를 담당하는 계층입니다.

#### 응용 계층 (application layer)

- OSI 모델에서 네트워크 계층과 대응되는 계층입니다. 
- 사용자의 응용프로그램 레벨에서 데이터를 처리하는 계층입니다. 하위계층으로부터 받은 메시지를 변환하거나, 하위 걔충으로 메시지를 전달합니다. 


### OSI 모델과 TCP/IP 차이점

-  TCP/IP는 클라이언트-서버 모델입니다. 즉, 클라이언트가 서비스를 요청하면 서버가 제공합니다. 반면 OSI는 개념 모델입니다.
-  TCP/IP는 인터넷을 포함한 모든 네트워크에 사용되는 표준 프로토콜이지만 OSI는 프로토콜이 아니라 시스템 아키텍처를 이해하고 설계하는 데 사용되는 참조 모델입니다.
-  TCP/IP는 4 개의 계층 모델이며, OSI는 7 개의 계층을 가지고 있습니다.
-  TCP/IP는 수직 접근 방식을 따릅니다. 한편, OSI 모델은 수평 적 접근을 지원합니다.
-  TCP/IP는 위에서 아래로의 접근 방식을 따르는 반면 OSI 모델은 상향식 접근 방식을 따릅니다.

</br></br>

# TCP와 UDP

### TCP(Transmission Control Protocol)

#### TCP란?

- 신뢰성있는 데이터 통신을 가능하게 해주는 프로토콜입니다.
- 양방향 통신을 합니다. (3 way-handshake)
- 데이터의 순차 전송을 보장합니다.
- 흐름 제어의 역할 합니다.
- 혼잡 제어의 역할을 합니다.
- 오류 감지 역할을 합니다.
- 서로 연결된 네트워크를 통해 패깃을 전달하는 목적으로 사용합니다.

#### TCP Header

![image](https://user-images.githubusercontent.com/88185304/150253442-fb105b5e-6e67-4b88-ac8b-b768a1f7c36e.png)

- TCP Flag
    - C · E : 혼잡제어시 사용합니다.
    - URG : 긴급 포인터(Urgent Pointer)가 있음을 표시합니다. (예를 들면, telnet에서 Ctrl + c 등의 인터럽트형 명령 전송할 경우)
    - ACK : Acknoledgement Number 사용중을 의미합니다.
    - PSH : Telnet 등의 실시간 대화형 데이터를 상위계층(응용계층)으로 전송하여 처리 요구를 의미합니다.
    - RST : 연결 재설정, 포트가 닫혔을 때 에러 메시지가 있음을 의미합니다.
    - SYN : 연결을 초기화화기 위해 순서 번호를 동기화할 때 사용합니다.
    - FIN : 송신 측이 데이터 전송을 종료함을 의미합니다. (연결 해제)
- Window : 수신자 측이 받을 수 있는 데이터 사이즈를 수신자 축에서 송신자 측으로 전송하는 값 입니다.
- Checksum : TCP 헤더 데이터를 포함한 세그먼트 전체에 대한 계산값을 의미합니다. (에러체크)
- Urgent Pointer : 긴급히 처리해야 할 필요가 있는 데이터의 마지막 Byte 위치를 의미합니다. 

#### TCP 3way handshake

![image](https://user-images.githubusercontent.com/88185304/150261373-b897f19d-7857-4884-a480-682f1dfb2cc4.png)

1) Client는 Server에 접속을 요구하는 SYN 패킷을 전송하는데, 이 때 Client는 SYN을 보낸 후 SYN/ACK응답을 기다리는 SYN_SENT 상태 (Seq는 랜덤, Ack는 Seq + 1)

2) Server는 SYN 요청을 받고 Client에게 요청을 수락한다는 ACK와 SYN Flag가 설정된 패킷을 발송 후 다시 ACK 응답을 기다리며, 이 때 Server는 SYN_RECEIVED 상태

3) Client는 Server에게 ACK를 보내고 이후부터 연결이 이루어지고 데이터를 전송하며 이 때 Server의 상태는 ESTABLISHED

#### TCP 4way handshake

![image](https://user-images.githubusercontent.com/88185304/150261459-5d5c171d-dc54-499c-8e1d-a24f1bffc718.png)

1) 통신을 종료하고자 하는 Client는 Server에게 FIN Flag를 세팅한 패킷을 전송 후 FIN_WAIT_1 상태

2) FIN을 수신한 Server는 ACK를 Client에게 전송하고 소켓의 상태를 CLOSE_WAIT_2로 변경

3) ACK를 수신한 Client는 Server가 FIN을 잘 받았다고 생각하고 FIN_WAIT_2로 소켓의 상태 변경 후 다시 FIN 패킷을 기다림

4) ACK를 Client에게 전송한 Server는 다시 FIN 패킷을 Client로 전송 후 소켓을 LAST_ACK상태로 변경

5) FIN을 수신한 Client는 Server에게 ACK를 전송 후 소켓의 상태를 TIME_WAIT 상태로 변경

#### 흐름제어

수신측의 버퍼 오버 플로우로 인한 패킷 손실이 발생할 수 있기 때문에, 생산자가 데이터를 만드는 속도와 소비자가 데이터를 사용하는 속도의 균형을 맞추는 것을 흐름제어라고 할 수 있습니다. <br>
쉽게 말하자면 수신측의 버퍼 오버 플로우를 막기 위해 송신측의 흐름을 제어하는 방식이라고 할 수 있습니다. 그리고 흐름을 제어하기 위해 수신측의 수신 윈도우 변수를 이용합니다. 

- Stop and Wait(정지 - 대기)
    - 매번 전송한 패킷에 대한 확인 응답을 받아야 그 다음 패킷을 전송할 수 있다. 이러한 구조로 인해 비효율적이라는 단점이 있다.

- Sliding Window(슬라이딩 윈도우)
    - 수신측에서 설정한 윈도우 크기만큼 송신측에서 확인 응답 없이 세그먼트를 전송할 수 있게 하여 데이터 흐름을 동적으로 조절하는 기법입니다. 따라서 송신측에서는 ACK 프레임을 수신하지 않더라도 여러 개의 프레임을 연속적으로 전송할 수 있습니다.
    - 송신측에서 0, 1, 2, 3, 4, 5, 6을 보낼 수 있는 프레임을 가지고 있고 데이터 0, 1을 전송했다고 가정하면 슬라이딩 윈도우 구조는 2, 3, 4, 5, 6처럼 변하게 됩니다. 이때 만약 수신측으로부터 ACK라는 프레임을 받게 된다면 송신측은 이전에 보낸 데이터 0, 1을 수신측에서 정상적으로 받았음을 알게 되고 송신측의 슬라이딩 윈도우는 ACK 프레임의 수만큼 오른쪽으로 경계가 확장됩니다.
    - Stop and Wait의 비효율성을 개선되었습니다.

    ![image](https://user-images.githubusercontent.com/88185304/150265864-1ebd4477-cd0b-4d6e-bc3f-27665efd1f9b.png)


#### 혼잡제어

공유자원인 네트워크망의 혼잡을 악화시켜 통신에 충돌이 나게 하는 것을 줄이고, 한정된 자원을 잘 분배하여 원활히 돌아갈 수 있도록 제어하는 것을 혼잡 제어라고 합니다. 

- AIMD(Additive Increase Multicative Decrease)
    - 합 증가/곱 감소 알고리즘이라고 합니다. 
    - 처음에 패킷 하나를 보내는 것으로 시작하여 전송한 패킷이 문제 없이 도착한다면 Window Size를 1씩 증가시키며 전송하는 방법입니다. 만약, 패킷 전송을 실패하거나 TIME_OUT이 발생하면 Window Size를 절반으로 감소시킵니다.
    - 이 방식을 사용하는 여러 호스트가 한 네트워크를 공유하고 있으면 나중에 진입하는 쪽이 처음에는 불리하지만 시간이 흐르면 평형 상태로 수렴하게 되는 특징이 있습니다.
    - 문제점은 초기에 네트워크의 높은 대역폭을 사용하지 못하여 오랜 시간이 걸리게 되고, 네트워크가 혼잡해지는 상황을 미리 감지하지 못합니다. 즉, 네트워크가 혼잡해지고 나서야 대역폭을 줄이는 방식입니다.

- Slow Start
    - AIMD가 네트워크 수용량 주변에서는 효율적으로 동작하지만, 처음에 전송 속도를 올리는데 시간이 너무 길다는 단점이 있습니다. slow start는 이 단점을 보완한 방법입니다. 
    - Slow Start는 AIMD와 마찬가지로 패킷을 하나씩 보내는 것부터 시작합니다. 이 방식은 패킷이 문제 없이 동작하여 ACK 패킷마다 Window Size를 1씩 늘립니다. 즉, 한 주기를 지나면 Window Size는 2배가 됩니다.
    - 혼잡 현상이 발생하면 Window Size를 1로 떨어뜨립니다.
    - 처음에는 네트워크의 수용량을 예측할 수 있는 정보가 없지만 한번 혼잡 현상이 발생하였던 Window Size의 절반까지는 이전처럼 지수 함수 꼴로 Window Size를 증가시키고 그 이후부터는 완만하게 1씩 증가시키는 방식입니다.
    - 미리 정해진 임계값(threshold)에 도달할 때까지 윈도우의 크기를 2배씩 증가시킵니다.
    - Slow Start라는 이름을 사용하지만, 매 전송마다 2배씩 증가하기 때문에 전송되어지는 데이터의 크기는 지수함수적으로 증가합니다.

    ![image](https://user-images.githubusercontent.com/88185304/150267425-3d6a48c5-4e85-4a5b-af28-84be5825c39e.png)


#### 오류제어

오류 검출과 재전송을 포함하며, ARQ(Automatic Repeat Request) 기법을 사용해 프레임이 손상되었거나 손실되었을 경우, 재전송을 통해 오류를 복구합니다. ARQ 기법은 흐름 제어 기법과 연관되어 있습니다.

- Stop and Wait ARQ
    - 송신 측에서 1개의 프레임을 송신하고, 수신측에서 수신된 프레임의 에러 유무에 따라 ACK 혹은 NAK(Negative Acknowledgement)를 보내는 방식입니다.
    - 식별을 위해 데이터 프레임과 ACK 프레임은 각각 0, 1 번호를 번갈아가며 부여합니다.
    - 수신측에 데이터를 받지 못했을 경우 NAK를 보내고, NAK를 받은 송신측은 데이터를 재전송합니다.
    - 만약, 데이터나 ACK가 분실되었을 경우 일정 간격의 시간을 두고 타임아웃이 되면 송신측은 데이터를 재전송합니다.

- Go-Back-n ARQ
    - 전송된 프레임이 손상되거나 분실된 경우 그리고 ACK 패킷의 손실로 인한 TIME_OUT이 발생한 경우, 확인된 마지막 프레임 이후로 모든 프레임을 재전송합니다.
    - 슬라이딩 윈도우는 연속적인 프레임 전송 기법으로 전송측은 전송된 프레임의 복사본을 가지고 있어야 하며, ACK와 NAK 모두 각각 구별해야 합니다. 
        - ACK : 다음 프레임을 전송
        - NAK : 손상된 프레임 자체 번호를 반환

    - 재전송 되는 경우
        - NAK 프레임을 받았을 경우 : 만약 수신측으로 0 ~ 5까지의 데이터를 보냈다고 가정했을 때, 수신측에서 데이터를 받았음을 확인하는 데이터 오류 프레임 2를 발견하고 NAK2를 전송측에 보낸다고 가정해봅시다. NAK2를 받은 전송측은 데이터 프레임 2가 잘못되었다는 것을 알고 데이터를 재전송합니다. GBn ARQ의 특징은 데이터를 재전송하는 부분입니다. NAK(n)를 받아 데이터를 재전송하빈다.

    - 전송 데이터 프레임의 분실
        - GBn ARQ의 특징은 확인된 데이터 이후의 모든 데이터 프레임 재전송과 수신측의 폐기입니다. 수신측에서 데이터 1을 받고 다음 데이터로 3을 받게 된다면 데이터 2를 받지 못했으므로 수신측에서는 데이터 3을 폐기하고 데이터 2를 받지 못했다는 NAK2를 전송측에 보냅니다. NAK를 받은 전송측은 '재전송 되는 경우'와 마찬가지로 NAK(n) 데이터로부터 모든 데이터를 재전송하며 수신측은 기존에 받았던 데이터 중 NAK(n)으로 보냈던 대상 데이터 이후의 모든 데이터를 폐기하고 재전송 받습니다.

        ![image](https://user-images.githubusercontent.com/88185304/150266462-885027d8-b16d-4bdd-b49a-d64521acfeb1.png)

    - 지정된 타임 아웃 내의 ACK 프레임 분실
        - 전송측은 분실된 ACK를 다루기 위해 타이머를 가지고 있습니다. 또한 전송측에서는 이 타이머의 타임 아웃 동안 수신측으로부터 ACK 데이터를 받지 못했을 경우, 마지막 ACK된 데이터부터 재전송합니다. 

        ![image](https://user-images.githubusercontent.com/88185304/150266522-937a438a-96f9-4934-a420-8a34f0736d7f.png)

    - 정리 
        - 전송측은 NAK 프레임을 받았을 경우, NAK 프레임 번호부터 데이터를 재전송합니다.
        - 수신측은 원하는 프레임이 아닐 경우, 데이터를 모두 폐기 처분합니다.
        - 타임아웃(ACK 분실)의 경우, 마지막 ACK된 데이터부터 재전송합니다.

- SR(Selective-Reject) ARQ
    - GBn ARQ의 확인된 마지막 프레임 이후의 모든 프레임을 재전송하는 단점을 보완하는 기법입니다.
    - SR ARQ는 손상되거나 손실된 프레임만 재전송합니다.
    - 그렇기 때문에 별도의 데이터 재정렬을 수행해야 하며, 별도의 버퍼를 필요로 합니다.
    - 수신 측에 버퍼를 두어 받은 데이터의 정렬이 필요합니다.


#### 문제점

- 전송의 신뢰성은 보장하지만, 매번 connect을 해서 시간 손실이 발생합니다. (3-way-handshake)
- 패킷을 조금만 손실해도 재전송 과정이 진행됩니다.


### UDP(User Datagram Protocol)

#### UDP란?

- TCP보다 신뢰성이 떨어지지만 전송 속도가 일반적으로 빠른 프로토콜입니다. 
- 3 way-handshake와 같은 연결과정이 진행되지 않습니다. 단방향 통신을 합니다.
- 비교적 데이터의 신뢰성이 중요하지 않을 때 사용합니다. (ex 유튜브 동영상 스트리밍)
- Error Detction
- 서로 연결된 네트워크를 통해 패킷 데이터그램을 전달하는 목적으로 사용합니다. 

#### UDP Header

![image](https://user-images.githubusercontent.com/88185304/150261633-34d5b022-ce89-412e-a261-9557f7f287fb.png)

- Length : UDP Header(8 byte) 와 Data 의 길이를 합한 값입니다.
- Checksum : 데이터 오류 검사할 때 사용합니다.

</br></br>

# IPv4 VS IPv6

### IP Address 
- 정의
    - 컴퓨터 네트워크에 연결된 각 장치에 할당된 고유 식별자입니다.

- public ip 와 private ip

    ![image](https://user-images.githubusercontent.com/88185304/150715146-b188ebb1-28c6-472b-a0e5-6690871b9371.png)



### IPv4

![image](https://user-images.githubusercontent.com/88185304/150716056-eb941dfb-d8d0-40f4-a36b-9011506fbb0f.png)

- IPv4의 주소 길이는 32비트입니다.	
- 수동 및 DHCP 주소 구성을 지원합니다.
- 4.29×10^9 주소 공간 을 생성할 수 있습니다.
- 보안 기능은 애플리케이션에 따라 다릅니다.
- IPv4의 주소 표현은 10진수입니다.
- 브로드캐스트 메시지 전송 방식이 있습니다.
- IPv4에서 암호화 및 인증 기능이 제공되지 않음
- IPv4의 헤더는 20-60바이트입니다.

### IPv6

![image](https://user-images.githubusercontent.com/88185304/150716849-3c03a7b8-24b4-49a2-9aa0-f26e19ea8aaf.png)

![image](https://user-images.githubusercontent.com/88185304/150717330-e3ce4e6a-abbe-4b77-abd6-0a3b58cd0977.png)

- IPv6의 주소 길이는 128비트입니다.
- 자동 및 번호 재지정 주소 구성을 지원합니다.
- IPv6의 주소 공간은 상당히 커서 3.4×10^38 주소 공간 을 생성할 수 있습니다.
- IPSEC는 IPv6 프로토콜에 내장된 보안 기능입니다.
- IPv6의 주소 표현은 16진수입니다.
- IPv6에서는 체크섬 필드를 사용할 수 없습니다.
- IPv6에서는 암호화 및 인증이 제공됩니다. 
- IPv6에는 40바이트의 헤더가 고정되어 있습니다. 







<br><br>

## 출처
- https://www.youtube.com/watch?v=aTPy201F0AA
- https://www.computernetworkingnotes.com/ccna-study-guide/data-encapsulation-and-de-encapsulation-explained.html
- https://velog.io/@inyong_pang/OSI-7-%EA%B3%84%EC%B8%B5%EA%B3%BC-TCPIP-%EA%B3%84%EC%B8%B5
- https://code-lab1.tistory.com/18
- https://ko.wikipedia.org/wiki/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC_%ED%8C%A8%ED%82%B7
- https://velog.io/@inyong_pang/OSI-7-%EA%B3%84%EC%B8%B5%EA%B3%BC-TCPIP-%EA%B3%84%EC%B8%B5
- https://ko.gadget-info.com/difference-between-tcp-ip
- https://www.stevenjlee.net/2020/02/09/%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-osi-7%EA%B3%84%EC%B8%B5-%EA%B7%B8%EB%A6%AC%EA%B3%A0-tcp-ip-4%EA%B3%84%EC%B8%B5/
- https://www.youtube.com/watch?v=ikDVGYp5dhg
- https://brainbackdoor.tistory.com/124
- https://roka88.dev/114
- https://velog.io/@jsj3282/TCP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-%EC%98%A4%EB%A5%98%EC%A0%9C%EC%96%B4
- https://www.geeksforgeeks.org/differences-between-ipv4-and-ipv6/
- https://www.youtube.com/watch?v=EDAnsWpOjGM&list=PLF1hDMPPRqGxpYdo0ctaa7MxfOi9vjs1u&index=8







