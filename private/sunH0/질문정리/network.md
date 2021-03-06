- 로드밸런서에 대해 설명해주세요

로드 밸런싱은 성능을 최적화 하기 위하여 서버나 장비 부하를 분산시켜주는 장치 또는 기술입니다. 하드웨어를 향상시키는 것 보다 적은 비용으로 대용량 트래픽을 감당 할 수 있고, 여러 대의 Server 덕분에 무중단 서비스를 제공할 수 있습니다. <br>

+) 대용량 트래픽을 대응하는 방안으로 하드웨어의 성능을 올리거나(Scale-up) 여러대의 서버를 추가하여 요청은 나눠주는 것(Scale-out)이 있다. 하드웨어 성능을 높이는 방법은 비용이 많이 들고 서버가 여러대면 무중단 서비스를 제공하는 환경 구성이 용이하므로 Scale-out이 효과적이다.

+) 트래픽(traffic)이란 서버와 스위치 등 네트워크 장치에서 일정 시간 내에 흐르는 데이터의 양을 말한다. 웹사이트에 트래픽이 많다는 것은 사용자 접속이 많아서 전송하는 데이터의 양이 많다는 것을 뜻한다.

- 로드 밸런서 동작과정

L4 로드 벨런서 기준으로, <br>

클라이언트로부터 요청이 들어오면 로드 밸런서는 헬스체크를 통해 살아있는 서버를 확인합니다. 로드밸런서가 서버를 특정하면 NAT를 적용하여 IP주소를 변조 후 (공인 → 사설) 데이터를 캡슐화 하여 서버에 전송합니다.  <br>

서버에서 클라이언트로 되돌아가는 경우, 목적지를 클라이언트로 설정한 다음 네트워크 장비나 로드 밸런서를 거치지 않고 바로 클라이언트로 찾아가 로드밸런서의 부하를 줄일 수 있습니다.(DSR)

- 로드 밸런서 유형

로드밸런서는 여러 계층에서 사용되지만 대표적으로 전송계층에서  L4와 application 계층의 L7 이 있습니다.  <br>

L4 로드밸런싱은 **IP와** TCP, UDP의 port를 기반으로 트래픽을 서버에 분산합니다. 데이터 안을 보지 않고 패킷 레벨에서만 로드를 분산하기 때문에 섬세한 라우팅이 어렵지만 속도가 빠르고 비용이 저렴합니다. <br>

L7 로드밸런싱은 L4 로드 밸런서의 기능을 포함하고, HTTP 헤더, 쿠키,URL 등과 같은 패킷의 내용을 분석하여  좀 더 정교한 로드밸런싱이 가능합니다.  또한, 데이터 분석을 통해 바이러스를 감지하거나 비정상적인 트래픽을 필터링 할 수 있습니다.

+) L4 로드 밸런서와 L7 로드 밸런서가 가장 많이 활용되는 이유 : L4부터 포트 정보를 바탕으로 분산하는 것이 가능하기 때문이다. 한 대의 서버에 각각 다른 포트 번호를 부여하여 다수의 서버 프로그램을 운영하는 경우라면 최소 L4 이상을 사용해야 한다.

- *****로드 밸런서의 기본 기능*****

서버의 이상 유무를 파악하는 상태 확인(Health Check), 패킷을 캡슐화해서 연결된 상호 간에만 패킷을 구별할 수 있게 해주는 터널링(Tunneling), IP 주소를 변환해주는 NAT 기능이 있습니다.

- 로드 밸런서 장애 대비

로드 밸런서에 장애 발생 시, 서비스 운영 중단 시간을 최소한으로 하기 위해 대기 서버를 사용합니다. (이중화)  평소에는 대기 서버에 트래픽을 분배하지 않다가, Acitve 중인 로드밸런서와 Standby 상태의 로드밸런서가 heartbeat를 주고 받으며 서로 정상적으로 동작하는 지 health check를 합니다. Ative L/B에 장애가 발생했을 경우 Standby L/B가 작업을 이어받는다.****

- 로드 밸런서 알고리즘

L4 로드 밸런서 알고리즘으로는, <br>

(1) 라운드 로빈 (Round Robin) : 요청이 들어오는 대로 서버마다 균등하게 요청을 분배 <br>

(2) 가중치 라운드 로빈 : 라운드 로빈 방식으로 분배하지만, 서버의 가중치에 따라 클라이언트 요청을 우선적으로 배분한다. <br>

(3) 해시 기반 스케줄링 : 사용자의 IP를 해싱한 후 그 결과에 따라 서버로 요청을 분배하기 때문에 특정 클라이언트는 특정 서버로만 할당하는 방식이다. <br>

L7 로드 밸런서 알고리즘으로는, <br>

(1) URL 스위칭 방식 : 특정 하위 URL들은 특정 서버로 처리하는 방식 ex) /images, .video <br>

(2) 쿠키 지속성 : 쿠키 정보를 바탕으로 클라이언트가 연결했었던 서버에 계속 할당해 주는 방식

- DNS

TCP/IP 네트워크 상에서 사람이 기억하기 쉽게 문자로 만들어진 도메인주소를 숫자로된 IP 주소로 바꾸는 서버입니다.   <br>

도메인을 IP주소로 변환하려면 DNS 서버에 도메인 쿼리를 하는 과정을 거쳐야 합니다.

DNS 서버에 질의를 보낼 때 UDP를 사용하고, 일정 데이터 영역을 초과하는 패킷을 전송하는 경우 초과하는 패킷을 전송해야 할 경우 TCP를 사용합니다. <br>

DNS는 계층적 구조로 되어 있으며 local dns 서버이자 주로 통신사 서버인 Recursive DNS Server, root dns 서버, 최상위 도메인 dns 서버, 실제 개인 도메인과 IP 주소의 관계가 기록/저장/변경되는 서버인 Authoritative DNS Server가 있습니다.

+) 배경 : 네트워크 안에서 호스트들을 식별하기 위한 목적으로 IP 주소를 사용하는데, 사람의 경우 숫자보다 문자를 사용하는 것이 더 편해 도메인 이름을 사용하여 호스트를 식별한다. 최종적으로는 IP 주소를 알고 있어야 상대방과 연결이 가능하기 때문에, 네트워크에서 도메인이나 호스트 이름을 숫자로 된 IP 주소로 해석해주는 DNS 가 등장 했다.

- DNS 서버를 여러 종류로 나누는 이유는?

존재하는 도메인 수가 많기 때문에 DNS 서버를 계층화해 단계적으로 처리하여 트래픽을 분산하고 유지 및 관리를 안정적으로 하기 위해서 입니다.

- 도메인 구조

도메인은 .으로 구분되는 계층적 구조입니다. 최상위에 루트가 존재하고(생략가능) 루트 아래로 국가 코드 도메인 (kr)이나 com과 같은 일반 도메인 중 최상위 도메인(TLD)이 존재합니다. 최상위 도메인 하위 서브 도메인에는 조직의 속성을 구분하는 'co'(영리 기업), 'go'(정부 기관), 'ac'(대학) 이 있습니다. 그 하위에는 조직이나 서비스 이름을 나타내는 도메인이 있습니다. (google) 마지막으로는 호스트(www)가 위치합니다.

- DNS 동작 과정

(1) 사용자가 도메인 주소를 입력하면 브라우저 local DNS인 통신사 DNS 서버에 해당하는 IP 주소를 요청합니다. (2) local DNS 서버에 캐시 데이터가 있으면 응답하고 없으면 root DNS 서버에게 최상위 DNS 서버 주소를 안내받습니다. (3) 원하는 IP 주소를 응답 받을 때까지 계층 하위로 안내받습니다. (4) IP 주소를 반환하는 서버를 찾았다면 local DNS 서버는 ip 주소를 캐싱하고 PC에 전달해 줍니다.

+) local dns → root dns → com → naver.com → local 캐싱 → PC

- DNSM가 UDP를 사용하는 이유

DNS는 신뢰성보다 속도가 더 중요한 서비스입니다. 그래서 비연결성이라 속도가 빠르고, TCP에 비해 헤더가 가벼워 더 많은 요청을 수용할 수 있는 UDP가 적합합니다. 

+) DNS에 전송되는 패킷 사이즈가 매우 작기 때문에 신뢰성이 보장되지 않아도 된다. (유실되면 다시 전달하면 된다,)

- 브라우저에서 주소창에 www.example.com(특정 URL)을 입력했을 때 ****웹 통신 흐름
1. 브라우저에서 url의 내용을 파싱하여 프로토콜, url, 포트번호등의 정보를 확인 
2. 브라우저는 os를 통해 url을 IP로 변경
    - 자신의 로컬 hosts 파일과 브라우저 캐시에 해당 URL이 존재하는지 확인
    - 존재하지 않는다면 해당 url을 DNS 서버에 요청하여 컴퓨터가 읽을 수 있는 IP로 변경
3. HTTP 프로토콜을 이용해서 HTTP 요청 메세지를 생성한다.
4. 라우터를 통해 해당 주소까지의 경로를 라우팅 하여 해당 서버의 게이트웨이까지 이동
5. ARP(Address Resolution Protocol)를 통해 IP주소를 MAC주소로 변환한다.
6. 3-way-handshake을 거쳐서 통신할 서버의 TCP 소켓 연결
7. 연결이 완료된 해당 서버에서 HTTP(HTTPS)프로토콜을 통해 응답(HTML, CSS, Javascript 등으로 구성)을 브라우저로 전달한다.
8. 브라우저에서 서버가 보낸 응답을 화면에 렌더링한다.
9. 

+) HTTP 메시지는 메소드, URI, HTTP 버전, 헤더, 페이로드로 구성

+) 메시지 전송은 브라우저가 직접하는 것이 아니라 OS 를 통해 메세지를 전달한다.

+) 브라우저는 이 HSTS의 리스트에 우리가 요청할 웹 사이트가 존재하는지 확인한다. 이후 목록에 해당 웹사이트가 존재한다면 브라우저가 HTTP 대신 HTTPS 프로토콜을 사용하여 요청을 보내게 된다.
