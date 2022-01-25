## HTTP 1.1

HTTP1.1은 기본적으로 연결당 하나의 요청과 응답을 처리합니다. 이 때문에 여러 개의 리소를 동시에 처리하는 것은 불가능하고 어쩔 수 없이 순차적으로 처리합니다.

이렇게 순차적으로 처리를 하기 때문에 발생하는 몇 가지 단점들이 있습니다.

- Head Of Line Blocking
  - HOL 블로킹이란 네트워크에서 여러 패킷을 전송할 때 첫 번째 패킷이 지연되면 나머지 패킷도 지연되는 것입니다.
- Round Trip Time 증가
  - 일반적으로 하나의 커넥션당 하나의 요청을 처리합니다. 이 과정에서 요청마다 3-way handshaking을 해야 하는 오버헤드가 발생하고 불필요한 RTT 증가로 네트워크 성능을 저하시킵니다.
- 연속된 요청의 경우 Header 데이터의 중복

이러한 특징들 때문에 다수의 리소스를 처리하기에 부적합합니다.

## HTTP 2

HTTP2는 1.1의 문제를 해결하고 성능을 향상 시킨 버전.

- 메시지 전송 방식이 바이너리 프레이밍 계층 사용하는 것으로 변경
  - 파싱, 전송 속도가 좋아지고 오류 발생 가능성이 낮아졌다.

![img](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cb4e09f5-1ed3-4d3f-8df5-a8f029959071/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220125%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220125T034549Z&X-Amz-Expires=86400&X-Amz-Signature=e4a19607bb4748b1bbba87c8591078798dac6da9fb17aeab8d67b93c5cc37d98&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- 요청과 응답이 Multiplexing 방식을 사용
  - 한 커넥션에서 여러 개의 요청을 주고 받을 수 있음
  - 응답은 요청 순서에 상관 없이 Stream으로 주고 받는다.
  - Head Of Line Blocking 문제 해결
- Stream Prioritization
  - 문제 상황 : 클라이언트가 css 파일 1개와 이미지 파일 2개를 요청한 상황에서 이미지 파일보다 css 파일의 수신이 늦어지면 브라우저 렌더링에 문제가 발생한다.
  - 이를 위해 리소스간 우선 순위를 설정할 수 있다.

![img](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1d7e43d8-e120-43f7-a60c-aedced20d5de/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220125%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220125T034523Z&X-Amz-Expires=86400&X-Amz-Signature=66d6bb51ba77e5b106b779810f95b6009ea87113ef7fe53d9db89f195bfdcee0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- Server Push
  - 클라이언트가 요청하지 않은 리소스를 서버가 푸시해서 보내준다. 이렇게 푸시가 가능해지면 클라이언트가 HTML 문서를 요청했을 때 해당 문서 내의 css나 img 같은 리소스도 같이 보내서 클라이언트 요청을 최소화할 수 있다.
- 헤더 압축 → 헤더의 크기를 줄여서 페이지 로드 시간 감소
  - 중복된 것은 인덱스만 기록하고 중복되지 않은 데이터는 허프만 인코딩 방식으로 헤더를 압축