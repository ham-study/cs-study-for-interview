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
    - [IP Address](###IP-Address)
    - [IPv4](###IPv4)
    - [IPv6](###IPv6)
4. [HTTP](#HTTP)
    - [HTTP란?](###HTTP란?)
    - [HTTP status code](###HTTP-status-code)
    - [HTTP method](###HTTP-method)
5. [HTTP/1.1 VS HTTP/2.0](#HTTP/1.1-VS-HTTP/2.0)
    - [HTTP/1.1](###HTTP/1.1)
    - [HTTP/2.0](###HTTP/2.0)
    - [QUIC(HTTP/3.0)](###QUIC(HTTP/3.0))
6. [HTTPS](#HTTPS)
    - [HTTPS 정의](###HTTPS-정의)
    - [SSL 디지털 인증서](###SSL-디지털-인증서)
    - [SSL 통신 과정](###SSL-통신-과정)
7. [REST API](#REST-API)
    - [정의](###정의)
    - [REST 디자인 원칙](###REST-디자인-원칙)
    - [리소스를 중심으로 API 디자인 구성](#리소스를-중심으로-API-디자인-구성)
    - [HTTP 의미 체계 준수](###HTTP-의미-체계-준수)
    - [비동기 작업](###비동기-작업)
    - [HATEOAS를 사용하여 관련 리소스 탐색](###HATEOAS를-사용하여-관련-리소스-탐색)
    - [REST API 버전 관리](###REST-API-버전-관리)
8. [Web Server vs WAS](#Web-Server-vs-WAS)
9. [CORS](#CORS)
10. [COOKIE & SESSION](#COOKIE-&-SESSION)
11. [JWT](#JWT)
12. [Load balancer](#Load-balancer)
13. [DNS](#DNS)
14. [Nonblocking&Synchronous/Asynchronous](#Nonblocking&Synchronous/Asynchronous)
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


</br></br>

# HTTP

### HTTP란?
- HTTP(HyperText Transfer Protocol, 문화어: 초본문전송규약, 하이퍼본문전송규약)는 W3 상에서 정보를 주고받을 수 있는 프로토콜입니다. 주로 HTML 문서를 주고받는 데에 쓰인다. 주로 TCP를 사용하고 HTTP/3 부터는 UDP를 사용하며, 80번 포트를 사용합니다. 
- HTTP는 클라이언트와 서버 사이에 이루어지는 요청/응답(request/response) 프로토콜입니다. 예를 들면, 클라이언트인 웹 브라우저가 HTTP를 통하여 서버로부터 웹페이지(HTML)나 그림 정보를 요청하면, 서버는 이 요청에 응답하여 필요한 정보를 해당 사용자에게 전달하게 됩니다. 이 정보가 모니터와 같은 출력 장치를 통해 사용자에게 나타나는 것입니다.

### HTTP status code

- 1xx (정보): 요청을 받았으며 프로세스를 계속 진행합니다.
- 2xx (성공): 요청을 성공적으로 받았으며 인식했고 수용하였습니다.
- 3xx (리다이렉션): 요청 완료를 위해 추가 작업 조치가 필요합니다.
- 4xx (클라이언트 오류): 요청의 문법이 잘못되었거나 요청을 처리할 수 없습니다.
- 5xx (서버 오류): 서버가 명백히 유효한 요청에 대해 충족을 실패했습니다.

![image](https://user-images.githubusercontent.com/88185304/150718512-e1f0f09d-9c83-4bd5-8b46-8c1ef1b74f29.png)


### HTTP method

- 종류
    - GET: 서버로 부터 데이터를 취득
    - POST: 서버에 데이터를 추가, 작성 등
    - PUT: 서버의 데이터를 갱신, 작성 등
    - DELETE: 서버의 데이터를 삭제
    
- 멱등성 
    - 여러번 수행해도 결과가 같음을 의미합니다.. 즉, 호출로 인하여 데이터가 변형이 되지 않는다는 것을 의미합니다.

- GET
    - HTTP 명세에 의하면 GET 요청은 오로지 데이터를 읽을 때만 사용되고 수정할 때는 사용하지 않습니다.
    - GET 요청은 idempotent 합니다.
    - URL을 통해 데이터를 주고 받습니다.

- POST
    - POST 요청은 idempotent 하지 않다. 
    - URL을 통해서 데이터를 받지 않고, Body 값을 통해서 받습니다.


<br><br>

# HTTP/1.1 VS HTTP/2.0

### HTTP/1.1

- 파이프라인
    HTTP/1.0에서 클라이언트는 새로운 요청이 있을 때마다 TCP 연결을 끊고 다시 만들어야 했으며, 이는 시간과 리소스 측면에서 많은 비용이 드는 일이었습니다. HTTP/1.1은 지속적인 연결과 파이프라이닝을 도입하여 이 문제를 처리합니다. 지속적인 연결을 사용하면 HTTP/1.1은 TCP 연결을 닫으라고 직접 지시하지 않는 한 계속 열려 있어야 한다고 가정합니다. 이를 통해 클라이언트는 각각에 대한 응답을 기다리지 않고 동일한 연결을 따라 여러 요청을 보낼 수 있으므로 HTTP/1.0보다 HTTP/1.1의 성능이 크게 향상됩니다.
    그러나 이 최적화 전략에는 병목 현상 발생할 여지는 있습니다. 

    ![image](https://user-images.githubusercontent.com/88185304/150910245-dd20ee4b-14ea-4033-b145-724218e38232.png)

- 버퍼 오버 플로우 방지 방법
    HTTP/1.1에서 흐름 제어는 기본 TCP 연결에 의존합니다. 이 연결이 시작되면 클라이언트와 서버 모두 시스템 기본 설정을 사용하여 버퍼 크기를 설정합니다. HTTP/1.1은 버퍼 오버플로를 피하기 위해 전송 계층에 의존하기 때문에 각각의 새로운 TCP 연결에는 별도의 흐름 제어 메커니즘이 필요합니다. 그에 비해 HTTP/2는 단일 TCP 연결 내에서 스트림을 다중화하며 다른 방식으로 흐름 제어를 구현해야 합니다.

- 리소스 요청 예측
    HTTP/1.1에서 개발자는 클라이언트 시스템이 페이지를 렌더링하는 데 필요한 추가 리소스를 미리 알고 있으면 리소스 인라인 이라는 기술을 사용 하여 서버가 응답으로 보내는 HTML 문서 내에 필요한 리소스를 직접 포함할 수 있습니다. 초기 GET요청. 예를 들어 클라이언트가 페이지를 렌더링하기 위해 특정 CSS 파일이 필요한 경우 해당 CSS 파일을 인라인하면 요청하기 전에 클라이언트에 필요한 리소스를 제공하여 클라이언트가 보내야 하는 총 요청 수를 줄입니다.

    그러나 리소스 인라인에는 몇 가지 문제가 있습니다. HTML 문서에 리소스를 포함하는 것은 더 작은 텍스트 기반 리소스에 대한 실행 가능한 솔루션이지만 텍스트가 아닌 형식의 더 큰 파일은 HTML 문서의 크기를 크게 증가시킬 수 있으며, 이는 궁극적으로 연결 속도를 감소시키고 원래의 이점을 무효화할 수 있습니다

- 압축 방법
    gzip 과 같은 프로그램은 특히 CSS 및 JavaScript 파일의 크기를 줄이기 위해 HTTP 메시지로 전송된 데이터를 압축하는 데 오랫동안 사용되어 왔습니다. 그러나 메시지의 헤더 구성 요소는 항상 일반 텍스트로 전송됩니다. 각 헤더는 매우 작지만 이러한 압축되지 않은 데이터의 부담은 요청이 많을수록 연결에 점점 더 무거워지며, 특히 다양한 리소스와 다양한 리소스 요청을 필요로 하는 복잡하고 API가 많은 웹 애플리케이션에 불이익을 줍니다. 또한 쿠키를 사용하면 헤더가 훨씬 더 커질 수 있으므로 일종의 압축이 필요합니다.

    이 병목 현상을 해결하기 위해 HTTP/2는 HPACK 압축을 사용하여 헤더 크기를 줄입니다. 



### HTTP/2.0

- 바이너리 프레이밍 레이어
    HTTP/2에서 이진 프레이밍 계층은 요청/응답을 인코딩하고 더 작은 정보 패킷으로 잘라 데이터 전송의 유연성을 크게 높입니다.
    그리고 바이너리 프레이밍 레이어에 내재된 멀티플렉싱이 HTTP/1.1의 특정 문제를 해결하지만 동일한 리소스를 기다리는 여러 스트림은 여전히 ​​성능 문제를 일으킬 수 있습니다. HTTP/2의 디자인은 이것을 고려하지만 스트림 우선 순위 지정을 사용하용 합니다.

- 스트림 우선 순위 지정
    스트림 우선 순위 지정은 동일한 리소스에 대해 경쟁하는 요청의 가능한 문제를 해결할 뿐만 아니라 개발자가 요청의 상대적 가중치를 사용자 지정하여 애플리케이션 성능을 더 잘 최적화할 수 있도록 합니다.

- 버퍼 오버 플로우 방지 방법
    HTTP/2는 클라이언트와 서버가 전송 계층에 의존하지 않고 자체 흐름 제어를 구현합니다. 응용 프로그램 계층은 사용 가능한 버퍼 공간을 통신하여 클라이언트와 서버가 다중화된 스트림 수준에서 수신 창을 설정할 수 있도록 합니다.
    예를 들어, 클라이언트는 이미지의 첫 번째 스캔을 가져와 사용자에게 표시하고 사용자가 더 중요한 리소스를 가져오는 동안 미리 볼 수 있도록 할 수 있습니다. 클라이언트가 이러한 중요한 리소스를 가져오면 브라우저는 이미지의 나머지 부분 검색을 재개합니다. 

- 서버 푸시
    서버 푸시는 HTTP/2는 클라이언트의 초기 요청에 대한 다중 동시 응답을 가능하게 하기 때문에 GET서버는 요청된 HTML 페이지와 함께 클라이언트에 리소스를 보내 클라이언트가 요청하기 전에 리소스를 제공하는 것을 의미합니다.
    HTTP/2에서 이 프로세스는 서버 PUSH_PROMISE가 리소스를 푸시할 것임을 클라이언트에 알리는 프레임을 보낼 때 시작됩니다. 이 프레임에는 메시지의 헤더만 포함되며 클라이언트가 서버가 푸시할 리소스를 미리 알 수 있습니다. 리소스가 이미 캐시된 경우 클라이언트는 RST_STREAM응답으로 프레임을 보내 푸시를 거부할 수 있습니다. 프레임은 또한 PUSH_PROMISE서버가 푸시할 리소스를 알고 있기 때문에 클라이언트가 서버에 중복 요청을 보내는 것을 방지합니다.
    여기서 서버 푸시의 강조점은 클라이언트 제어라는 점에 유의하는 것이 중요합니다. 클라이언트가 서버 푸시의 우선 순위를 조정하거나 비활성화해야 하는 경우 언제든지 SETTINGS이 HTTP/2 기능을 수정하기 위해 프레임을 보낼 수 있습니다.
    이 기능에는 많은 잠재력이 있지만 서버 푸시가 항상 웹 애플리케이션 최적화에 대한 답은 아닙니다. 예를 들어 클라이언트에 이미 캐시된 리소스가 있더라도 일부 웹 브라우저는 푸시된 요청을 항상 취소할 수 없습니다. 클라이언트가 실수로 서버가 중복 리소스를 보내도록 허용하면 서버 푸시가 연결을 불필요하게 사용할 수 있습니다. 결국 서버 푸시는 개발자의 판단에 따라 사용해야 합니다. 

- 압축 방법
    HTTP/2에서 계속해서 등장한 주제 중 하나는 바이너리 프레이밍 레이어를 사용하여 세부 사항을 더 잘 제어할 수 있다는 것입니다. 헤더 압축의 경우에도 마찬가지입니다. HTTP/2는 데이터에서 헤더를 분할하여 헤더 프레임과 데이터 프레임을 생성할 수 있습니다. HTTP/2 전용 압축 프로그램 HPACK 은 이 헤더 프레임을 압축할 수 있습니다. 
    HTTP/2는 HPACK 및 기타 압축 방법을 사용하여 클라이언트-서버 대기 시간을 줄일 수 있는 기능을 하나 더 제공합니다.

    - 요청

        ```
        # 요청 1

        method:     GET
        scheme:     https
        host:       example.com
        path:       /academy
        accept:     /image/jpeg
        user-agent: Mozilla/5.0 ...

        # 요청2

        method:     GET
        scheme:     https
        host:       example.com
        path:       /academy/images
        accept:     /image/jpeg
        user-agent: Mozilla/5.0 ...

        출처: https://www.digitalocean.com/community/tutorials/http-1-1-vs-http-2-what-s-the-difference

        ```
        
    - 헤더 프레임

        ```
        # 요청 1 헤더프레임

        method:     GET
        scheme:     https
        host:       example.com
        path:       /academy
        accept:     /image/jpeg
        user-agent: Mozilla/5.0 ...

        # 요청 2 헤더프레임

        path:       /academy/images

        출처: https://www.digitalocean.com/community/tutorials/http-1-1-vs-http-2-what-s-the-difference

        ```

### QUIC(HTTP/3.0)

HTTP/3는 HTTP와 HTTP/2와 더불어 월드 와이드 웹상의 정보를 교환하기 위해 사용되는 HTTP의 차기 주요 버전이자 3번째 프로토콜입니다..

HTTP 시맨틱스는 이 버전들 모두 동일한다: 동일 요청 메소드, 상태 코드, 메시지 필드가 일반적으로 모든 버전에 적용된다. 이 시맨틱스의 매핑 내에서의 차이점은 기반이 되는 트랜스포트입니다. HTTP와 HTTP/2는 TCP를 자신들의 트랜스포트로 사용한다. HTTP/3는 사용자 공간 혼잡 제어를 사용자 데이터그램 프로토콜(UDP)를 경유하여 사용되는, 처음에 구글이 개발한 전송 계층 통신 프로토콜의 하나인 QUIC를 사용합니다. QUIC로의 전환은 헤드 오브 라인 블로킹이라는 HTTP/2의 주된 문제를 해결하는 것이 목적입니다.
    
<br><br>

# HTTPS

### HTTPS 정의

HTTPS (HTTP Secure) 는 HTTP protocol의 암호화된 버전이다. 이것은 대개 클라이언트와 서버 간의 모든 커뮤니케이션을 암호화 하기 위하여 SSL 이나 TLS을 사용합니다. 이 커넥션은 클라이언트가 민감한 정보를 서버와 안전하게 주고받도록 해줍니다. 예를들면 금융 활동 이나 온라인 쇼핑이 있을 수 있습니다.


### SSL 디지털 인증서

- 정의
    - SSL 인증서는 클라이언트와 서버간의 통신을 제3자가 보증해주는 전자화된 문서입니다.
- 이점
    - 통신 내용이 공격자에게 노출되는 것을 막을 수 있습니다. 
    - 클라이언트가 접속하려는 서버가 신뢰 할 수 있는 서버인지를 판단할 수 있습니다.
    - 통신 내용의 악의적인 변경을 방지할 수 있습니다. 
- 사용하는 암호화의 종류
    - 대칭키
        - 암호를 만드는 행위인 암호화를 할 때 사용하는 일종의 비밀번호를 키(key)라고 합니다. 이 키에 따라서 암호화된 결과가 달라지기 때문에 키를 모르면 암호를 푸는 행위인 복호화를 할 수 없습니다. 대칭키는 동일한 키로 암호화와 복호화를 같이 할 수 있는 방식의 암호화 기법을 의미합니다.
        - 대칭키 방식은 단점으로는 암호를 주고 받는 사람들 사이에 대칭키를 전달하는 것이 어렵다는 점입니다. 대칭키가 유출되면 키를 획득한 공격자는 암호의 내용을 복호화 할 수 있기 때문에 암호가 무용지물이 되기 때문입니다. 
    - 공개키
        - 공개키 방식은 두개의 키를 갖게 되는데 A키로 암호화를 하면 B키로 복호화 할 수 있고, B키로 암호화하면 A키로 복호화 할 수 있는 방식입니다. 이 방식에 착안해서 두개의 키 중 하나를 비공개키(private key, 개인키, 비밀키라고도 부른다)로하고, 나머지를 공개키(public key)로 지정합니다.
        - 공개키가 유출된다고해도 비공개키를 모르면 정보를 복호화 할 수 없기 때문에 안전합니다. 공개키로는 암호화는 할 수 있지만 복호화는 할 수 없기 때문입니다.
- CA
    - 인증서의 역할은 클라이언트가 접속한 서버가 클라이언트가 의도한 서버가 맞는지를 보장하는 역할을 합니다. 이 역할을 하는 민간기업들이 있는데 이런 기업들을 CA(Certificate authority) 혹은 Root Certificate 라고 부릅니다. 
- 사설 인증기관
    - 개발이나 사적인 목적을 위해서 SSL의 암호화 기능을 이용하려한다면 자신이 직접 CA의 역할을 할 수도 있습니다. 물론 이것은 공인된 인증서가 아니기 때문에 이러한 사설 CA의 인증서를 이용하는 경우 브라우저는 아래와 같은 경고를 출력합니다.
- SSL 인증서의 내용
    - 서비스의 정보 (인증서를 발급한 CA, 서비스의 도메인 등등)
    - 서버 측 공개키 (공개키의 내용, 공개키의 암호화 방법)

    ![image](https://user-images.githubusercontent.com/88185304/151083659-278695bd-9a22-43fd-b64f-6ec82e93c5c6.png)

### SSL 통신 과정

1. Handshake
    1. 클라이언트가 서버에 접속합니다. 이 단계를 Client Hello라고 한다. 이 단계에서 주고 받는 정보는 아래와 같습니다.
        - 클라이언트 측에서 생성한 랜덤 데이터 : 아래 3번 과정 참조
        - 클라이언트가 지원하는 암호화 방식들 : 클라이언트와 서버가 지원하는 암호화 방식이 서로 다를 수 있기 때문에 상호간에 어떤 암호화 방식을 사용할 것인지에 대한 협상을 해야 합니다. 이 협상을 위해서 클라이언트 측에서는 자신이 사용할 수 있는 암호화 방식을 전송합니다.
        - 세션 아이디 : 이미 SSL 핸드쉐이킹을 했다면 비용과 시간을 절약하기 위해서 기존의 세션을 재활용하게 되는데 이 때 사용할 연결에 대한 식별자를 서버 측으로 전송합니다.
    2. 서버는 Client Hello에 대한 응답으로 Server Hello를 하게 됩니다. 이 단계에서 주고 받는 정보는 아래와 같습니다.
        - 서버 측에서 생성한 랜덤 데이터 : 아래 3번 과정 참조
        - 서버가 선택한 클라이언트의 암호화 방식 : 클라이언트가 전달한 암호화 방식 중에서 서버 쪽에서도 사용할 수 있는 암호화 방식을 선택해서 클라이언트로 전달합니다. 이로써 암호화 방식에 대한 협상이 종료되고 서버와 클라이언트는 이 암호화 방식을 이용해서 정보를 교환하게 됩니다.
        - 인증서
    3. 클라이언트는 서버의 인증서가 CA에 의해서 발급된 것인지를 확인하기 위해서 클라이언트에 내장된 CA 리스트를 확인합니다. CA 리스트에 인증서가 없다면 사용자에게 경고 메시지를 출력합니다.
        - 클라이언트는 상기 2번을 통해서 받은 서버의 랜덤 데이터와 클라이언트가 생성한 랜덤 데이터를 조합해서 pre master secret라는 키를 생성합니다.
        - 서버의 공개키로 pre master secret 값을 암호화해서 서버로 전송하면 서버는 자신의 비공개키로 안전하게 복호화 할 수 있습니다.
    4. 서버는 클라이언트가 전송한 pre master secret 값을 자신의 비공개키로 복호화합니다. 이로서 서버와 클라이언트가 모두 pre master secret 값을 공유하게 되었습니다. 그리고 서버와 클라이언트는 모두 일련의 과정을 거쳐서 pre master secret 값을 master secret 값으로 만듭니다. master secret는 session key를 생성하는데 이 session key 값을 이용해서 서버와 클라이언트는 데이터를 대칭키 방식으로 암호화 한 후에 주고 받습니다. 
    5. 클라이언트와 서버는 핸드쉐이크 단계의 종료를 서로에게 알립니다.

2. 전송
세션은 실제로 서버와 클라이언트가 데이터를 주고 받는 단계입니다. 이 단계에서 핵심은 정보를 상대방에게 전송하기 전에 session key 값을 이용해서 대칭키 방식으로 암호화 한다는 점입니다. 암호화된 정보는 상대방에게 전송될 것이고, 상대방도 세션키 값을 알고 있기 때문에 암호를 복호화 할 수 있습니다.

Q. 그냥 공개키를 사용하면 될 것을 대칭키와 공개키를 조합해서 사용하는 이유는 무엇을까? 
A. 그것은 공개키 방식이 많은 컴퓨터 파워를 사용하기 때문이다. 만약 공개키를 그대로 사용하면 많은 접속이 몰리는 서버는 매우 큰 비용을 지불해야 할 것이다. 반대로 대칭키는 암호를 푸는 열쇠인 대칭키를 상대에게 전송해야 하는데, 암호화가 되지 않은 인터넷을 통해서 키를 전송하는 것은 위험하기 때문이다. 그래서 속도는 느리지만 데이터를 안전하게 주고 받을 수 있는 공개키 방식으로 대칭키를 암호화하고, 실제 데이터를 주고 받을 때는 대칭키를 이용해서 데이터를 주고 받는 것이다.

3. 세션 종료
데이터의 전송이 끝나면 SSL 통신이 끝났음을 서로에게 알려줍니다. 이 때 통신에서 사용한 대칭키인 세션키를 폐기합니다.

<br><br>

# REST API

### 정의

- API 또는 애플리케이션 프로그래밍 인터페이스는 애플리케이션이나 디바이스가 서로 간에 연결하여 통신할 수 있는 방법을 정의하는 규칙 세트입니다. REST API는 REST(REpresentational State Transfer) 아키텍처 스타일의 디자인 원칙을 준수하는 API입니다. 이러한 이유 때문에 REST API를 종종 RESTful API라고도 합니다.

### REST 디자인 원칙

- REST API는 리소스를 중심으로 디자인되며, 클라이언트에서 액세스할 수 있는 모든 종류의 개체, 데이터 또는 서비스가 리소스에 포함됩니다
- 리소스마다 해당 리소스를 고유하게 식별하는 URI인 식별자가 있습니다. 예를 들어 특정 고객 주문의 URI는 다음과 같습니다.
    ```
    https://adventure-works.com/orders/1
    ```
- 클라이언트가 리소스의 표현을 교환하여 서비스와 상호 작용합니다. 많은 Web API가 교환 형식으로 JSON을 사용합니다. 예를 들어 위에 나열된 URI에 대한 GET 요청은 이 응답 본문을 반환할 수 있습니다.
    ```
    {"orderId":1,"orderValue":99.90,"productId":1,"quantity":1}
    ```
- REST API는 균일한 인터페이스를 사용하므로 클라이언트와 서비스 구현을 분리하는 데 도움이 됩니다. HTTP를 기반으로 하는 REST API의 경우 리소스에 표준 HTTP 동사 수행 작업을 사용하는 것이 균일한 인터페이스에 포함됩니다. 가장 일반적인 작업은 GET, POST, PUT, PATCH 및 DELETE입니다.
- REST API는 상태 비저장 요청 모델을 사용합니다. HTTP 요청은 독립적이어야 하고 임의 순서로 발생할 수 있으므로, 요청 사이에 일시적인 상태 정보를 유지할 수 없습니다. 정보는 리소스 자체에만 저장되며 각 요청은 자동 작업이어야 합니다. 이러한 제약 조건이 있기 때문에 웹 서비스의 확장성이 우수합니다. 클라이언트와 특정 서버 사이에 선호도를 유지할 필요가 없기 때문입니다. 모든 서버는 모든 클라이언트의 모든 요청을 처리할 수 있습니다.
- REST API는 표현에 포함된 하이퍼미디어 링크에 따라 구동됩니다. (HATEOAS)
    ```
    {
    "orderID":3,
    "productID":2,
    "quantity":4,
    "orderValue":16.60,
    "links": [
        {"rel":"product","href":"https://adventure-works.com/customers/3", "action":"GET" },
        {"rel":"product","href":"https://adventure-works.com/customers/3", "action":"PUT" }
        ]
    }
    ```
### 리소스를 중심으로 API 디자인 구성

- 리소스는 단일 물리적 데이터 항목을 기반으로 할 필요가 없습니다. 예를 들어 주문 리소스는 내부적으로 관계형 데이터베이스의 여러 테이블로 구현할 수 있지만 클라이언트에 대해서는 단일 엔터티로 표시됩니다. 
- URI에 일관적인 명명 규칙을 적용합니다. 일반적으로 이렇게 하면 컬렉션을 참조하는 URI에 대해 복수 명사를 사용할 수 있습니다. 컬렉션 및 항목에 대한 URI를 계층 구조로 구성하는 것이 좋습니다. 예를 들어 /customers는 고객 컬렉션의 경로이고, /customers/5는 ID가 5인 고객의 경로입니다. 
- 서로 다른 리소스 형식과 이러한 연결을 표시하는 방법 사이의 관계도 고려해야 합니다. 예를 들어 /customers/5/orders는 고객 5에 대한 모든 주문을 나타낼 수 있습니다. 반대 방향으로 이동하여 /orders/99/customer 같은 URI를 사용하여 주문에서 고객으로의 연결을 표시할 수도 있습니다. 단, 리소스 URI를 `컬렉션/항목/컬렉션`보다 더 복잡하게 요구하지 않는 것이 좋습니다.
- Web API와 기본 데이터 원본 사이에 종속성이 발생하지 않도록 해야 합니다. 예를 들어 데이터가 관계형 데이터베이스에 저장되는 경우 Web API는 각 테이블을 리소스 컬렉션으로 표시할 필요가 없습니다. 사실 이것은 서투른 디자인입니다. 그 대신 Web API를 데이터베이스의 추상화라고 생각해 보세요. 필요하다면 데이터베이스와 Web API 사이에 매핑 계층을 도입합니다. 이 방법을 사용하면 클라이언트 애플리케이션이 기본 데이터베이스 스키마의 변경 내용으로부터 격리됩니다.

### HTTP 의미 체계 준수

- Media types
    - HTTP 프로토콜에서 형식은 MIME 유형이라고도 하는 미디어 유형을 사용하여 지정됩니다. 이진이 아닌 데이터의 경우 대부분의 Web API는 JSON(미디어 유형 = 애플리케이션/json) 및 XML(미디어 유형 = 애플리케이션/xml)을 지원합니다.
    ```
    POST https://adventure-works.com/orders HTTP/1.1
    Content-Type: application/json; charset=utf-8
    Content-Length: 57

    {"Id":1,"Name":"Gizmo","Category":"Widgets","Price":1.99}
    ```
- GET
    - 성공적인 GET 메서드는 일반적으로 HTTP 상태 코드 200(정상)를 반환합니다. 리소스를 찾을 수 없는 경우 메서드가 404(찾을 수 없음)를 반환해야 합니다.
- POST
    - POST 메서드는 새 리소스를 만드는 경우 HTTP 상태 코드 201(만들어짐)을 반환합니다. 새 리소스의 URI는 응답의 Location 헤더에 포함됩니다. 응답 본문은 리소스의 표현을 포함합니다.
    - 이 메서드가 일부 처리를 수행하지만 새 리소스를 만들지 않는 경우 메서드는 HTTP 상태 코드 200을 반환하고 작업의 결과를 응답 본문에 포함할 수 있습니다. 또는 반환할 결과가 없으면 메서드가 응답 본문 없이 HTTP 상태 코드 204(내용 없음)를 반환할 수 있습니다.
    - 클라이언트가 잘못된 데이터를 요청에 배치하면 서버에서 HTTP 상태 코드 400(잘못된 요청)을 반환해야 합니다. 응답 본문에는 오류에 대한 추가 정보 또는 자세한 정보를 제공하는 URI 링크가 포함될 수 있습니다.
- PUT
    - PUT 메서드는 POST 메서드와 마찬가지로 새 리소스를 만드는 경우 HTTP 상태 코드 201(만들어짐)을 반환합니다. 이 메서드는 기존 리소스를 업데이트할 경우 200(정상) 또는 204(내용 없음)를 반환합니다. 상황에 따라 기존 리소스를 업데이트할 수 없는 경우도 있습니다. 이 경우 HTTP 상태 코드 409(충돌)를 반환하는 방안을 고려해야 합니다.
- PATCH
    - 클라이언트는 PATCH 요청을 사용하여 업데이트를 패치 문서의 형태로 기존 리소스에 보냅니다. 서버는 패치 문서를 처리하여 업데이트를 수행합니다. 패치 문서는 리소스 전체가 아니라 적용할 변경 내용만 설명합니다. 
- DELETE
    - 삭제 작업에 성공 하면 웹 서버는 프로세스가 성공적으로 처리 되었음을 나타내는 HTTP 상태 코드 204 (콘텐츠 없음)를 사용 하 여 응답 해야 하지만 응답 본문에는 추가 정보가 포함 되지 않습니다. 
    - 리소스가 없는 경우 웹 서버는 HTTP 404(찾을 수 없음)를 반환할 수 있습니다.

### 비동기 작업
-  처리 작업이 완료될 때까지 기다렸다가 클라이언트에 응답을 보내는 경우 허용되지 않는 수준의 대기 시간이 발생할 수 있습니다. 이 경우 비동기 작업을 수행하는 방안을 고려해 보아야 합니다. 
- 요청 처리가 수락되었지만 아직 완료되지 않았음을 나타내는 HTTP 상태 코드 202(수락됨)를 반환합니다.
    ```
    HTTP/1.1 202 Accepted
    Location: /api/status/12345
    ```
- 클라이언트가 이 엔드포인트에 GET 요청을 보내는 경우 응답에 요청의 현재 상태가 포함되어야 합니다. 필요에 따라 예상 완료 시간 또는 작업 취소 링크를 포함할 수 있습니다.
    ```
    HTTP/1.1 200 OK
    Content-Type: application/json

    {
        "status":"In progress",
        "link": { "rel":"cancel", "method":"delete", "href":"/api/status/12345" }
    }
    ```
- 비동기 작업에서 새 리소스를 만드는 경우 작업 완료 후 상태 엔드포인트에서 상태 코드 303(다른 항목 보기)을 반환해야 합니다. 303 응답에 새 리소스의 URI를 제공하는 Location 헤더를 포함합니다.
    ```
    HTTP/1.1 303 See Other
    Location: /api/orders/12345 
    ```

### HATEOAS를 사용하여 관련 리소스 탐색
- 예시
    ```
    {
    "orderID":3,
    "productID":2,
    "quantity":4,
    "orderValue":16.60,
    "links":[
        {
        "rel":"customer",
        "href":"https://adventure-works.com/customers/3",
        "action":"GET",
        "types":["text/xml","application/json"]
        },
        {
        "rel":"customer",
        "href":"https://adventure-works.com/customers/3",
        "action":"PUT",
        "types":["application/x-www-form-urlencoded"]
        },
        {
        "rel":"customer",
        "href":"https://adventure-works.com/customers/3",
        "action":"DELETE",
        "types":[]
        },
        {
        "rel":"self",
        "href":"https://adventure-works.com/orders/3",
        "action":"GET",
        "types":["text/xml","application/json"]
        },
        {
        "rel":"self",
        "href":"https://adventure-works.com/orders/3",
        "action":"PUT",
        "types":["application/x-www-form-urlencoded"]
        },
        {
        "rel":"self",
        "href":"https://adventure-works.com/orders/3",
        "action":"DELETE",
        "types":[]
        }]
    }
    ```
### REST API 버전 관리

- 버전관리 없음
- url을 통해 버전 관리
    ```
    https://adventure-works.com/customers/3
    ```
- 쿼리 문자열로 버전 관리
    ```
    https://adventure-works.com/customers/3?version=2
    ```
- 미디어 형식으로 버전 관리
    ```
    GET https://adventure-works.com/customers/3 HTTP/1.1
    Accept: application/vnd.adventure-works.v1+json
    ```
    ```
    HTTP/1.1 200 OK
    Content-Type: application/vnd.adventure-works.v1+json; charset=utf-8

    {"id":3,"name":"Contoso LLC","address":"1 Microsoft Way Redmond WA 98053"}
    ```

<br><br>

# Web Server vs WAS

<br><br>

# CORS

<br><br>

# COOKIE & SESSION

<br><br>

# JWT

<br><br>

# Load balancer

<br><br>

# DNS

<br><br>

# Nonblocking&Synchronous/Asynchronous

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
- https://ko.wikipedia.org/wiki/HTTP
- https://velog.io/@yh20studio/CS-Http-Method-란-GET-POST-PUT-DELETE
- https://www.digitalocean.com/community/tutorials/http-1-1-vs-http-2-what-s-the-difference
- https://ko.wikipedia.org/wiki/HTTP/3
- https://opentutorials.org/course/228/4894
- https://docs.microsoft.com/ko-kr/azure/architecture/best-practices/api-design
- https://www.ibm.com/kr-ko/cloud/learn/rest-apis


