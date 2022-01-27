## CORS(Cross-Origin Resource Sharing) : 교차 출처 자원 공유

### Origin

SOP(Same Origin Policy) : 다른 출처의 리소스를 사용하는 것에 제한하는 보안 방식

프로토콜+호스트+포트 가 동일하면 서로 같은 출처라 한다.

### 등장 배경
예전에 웹사이트를 만들때는 대부분 하나의 서버에서 브라우저의 모든 요청을 처리했지만 점점 웹 서비스가 커지면서 브라우저가 다른 출처(Origin)의 자원을 요청할 일이 많아졌다. (예를 들어 지도 API를 사용하여 지도 기능을 추가하는 경우) 하지만 SOP와 반대로 아무런 제약도 존재하지 않는다면 보안상 매우 취약하다. 그래서 다른 출처의 리소스가 필요한 경우,  SOP를 우회하기 위한 방법으로 CORS 가 사용되었다.

즉, CORS란 추가 HTTP 헤더를 사용하여 한 출처에서 실행 중인 웹 애플리케이션이 다른 출처의 선택한 자원에 접근 할 수 있는 권한을 부여하도록 브라우저에 알려주는 정책이다.

### 동작 방식
- Preflight Request
Request 의  Origin과 Response의 Access-Control-Allow-Origin이 동일한지 브라우저가 판단한다.
Options 메서드로 예비 요청을 보내고 본 요청을 보낸다. 예비요청에는 Origin 정보 뿐만 아니라 본 요청에 대한 헤더, http 메서드 등의 정보들도 포함한다. Origin이 동일하면 본요청을 보내고 아니면 에러를 발생시킨다. 예비요청의 응답 status code는 200 이다.

- Simple Request
예비 요청이 없이 본 요청에서 origin 검사를 한다. 요청 메소드는 GET, HEAD, POST 만 사용 가능하고 Content-type에서 Json을 사용하지 못하고 헤더에는 JWT를 포함할 수 없기 때문에 잘 사용되지 않는다.

+) Preflight 가 필요한 이유는 cors 에러를 확인하기 전에 DB와 같은 작업 하는 것을 방지 하기 위해

- Credentialed Request (인증 정보 포함 요청)
인증 관련 헤더를 포함할 때 사용하는 요청

기본적으로 브라우저가 제공하는 비동기 리소스 요청 API인 XMLHttpRequest 객체나 fetch API는 별도의 옵션 없이 브라우저의 쿠키 정보나 인증과 관련된 헤더를 함부로 요청에 담지 않는다. 이때 요청에 인증과 관련된 정보를 담을 수 있게 해주는 옵션이 바로 credentials 옵션이다.

옵션
same-origin (기본값) : 같은 출처 간 요청에만 인증 정보를 담는다.
include : 모든 요청에 인증 정보를 담는다.
omit : 모든 요청에 인증 정보를 담지 않는다.

Access-Control-Allow-Origin : * 은 안된다. 정확한 url 명시
Access-Control-Allow-Credentials : true 롤 설정 필수


