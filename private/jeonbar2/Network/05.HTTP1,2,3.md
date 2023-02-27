## HTTP 1.1

- TCP기반
- 기본적으로 하나의 요청에 하나의 응답을 보낼수 있도록 설계 되었다.
- 동시 전송이 불가능하고, 요청과 응답이 순차적으로 이루어진다.
- 다수의 리소스를 처리하려면 요청할 리소스 개수에 비례하여 Latency(대기시간)은 길어진다
- 단점
  - `HOLB (Head Of Line Blocking)` ; 특정 응답의 지연

    - 패킷이 순서대로 도착해야하므로 패킷이 도착할때 까지 그이후 패킷은 전송되지 못하는 것
      - http 1.1은 동시 전송이 불가능
    - 패킷이 정상적으로 도착하지 못할 때마다 재요청이 일어남
    - 해결방법
      - `Http Pipelining` : 요청에 대한 응답을 기다리지 않고 여러개의 요청을 보낸다.

  - `RTT(Round Trip Time) 증가`

    - TCP기반 (신뢰성 보장)이기 때문에 요청별로 커넥션을 생성하고, 이때마다 3-way Handshaking가 반복적으로 발생하여 불필요한 RTT증가와 네트워크 지연을 초래
    - 해결방법
      - `connection keep-alive` : TCP 커넥션을 재사용하는것

  - `무거운 Header구조`
    - Http 1.1 은 다수의 http 요청이 발생할 때 마다 중복된 헤더값을 전송
      - 쿠키정보도 헤더에 담겨 요청되므로 헤더가 매우 무거워짐
    - 해결방법
      - 헤더 정보를 직접 압축

## HTTP 2.0

- HTTP 1.1 을 완전하게 재작성한 것이 아니라 프로토콜 성능에 초점을 맞춰 수정한 버전
- Multiplexed Streams
  - Connection 한 개로 동시에 여러개의 메시지를 주고 받을수 있으며, 응답은 순서에 상관없이 stream으로 주고받는다
  - http pipelining 과 connection keep-alive 를 개선
- Header Compression
  - 헤더 정보를 압축하는 방식
  - 요청간 중복되는 헤더는 index 값만 전송

## HTTP 3.0

- TCP기반의 자체적 한계를 개선하기 위해 UDP 프로토콜을 사용, 정확히 말하면 HTTP3는 QUIC라는 프로토콜 위에서 돌아가는 HTTP인데, QUIC는 Quick UDP Internet Connection이다
- UDP 기반이라 3-way handshake와 같은 과정이 없고, 이는 RTT단축으로 이어진다
- 멀티플렉싱을 지원하여 HOLB가 없다
