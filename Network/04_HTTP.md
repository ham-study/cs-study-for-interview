# HTTP

<br>

<details>
    <summary><b>클라이언트와 서버에 대해 설명해주세요</b></summary>
    <br>
    클라이언트는 사용자가 요청을 보내는 측을 뜻하고, 서버는 해당 요청을 처리하여 응답하는 측을 뜻합니다.<br>
    클라이언트와 서버는 주로 HTTP를 사용하여 통신합니다.
</details>

<br>

<details>
    <summary><b>HTTP에 대해 설명해주세요</b></summary>
    <br>
    HTTP는 인터넷에서 데이터를 주고받을 수 있게하는 프로토콜입니다.<br>
    HTTP를 통해서 html, json, xml과 같은 형태의 데이터를 주고받을 수 있게 됩니다.<br>
    HTTP의 특징에는 비연결성과 무상태성이 있습니다.<br>
    비연결성은 클라이언트가 요청을 서버에 보낸 후 서버가 응답하면 연결이 끊어지는 것을 뜻합니다.<br>
    무상태성은 연결을 끊는 순간 클라이언트와 서버의 통신은 끝나며 상태 정보를 유지하지 않는 것을 뜻합니다.
</details>

<br>

<details>
    <summary><b>HTTP method에 대해 설명해주세요</b></summary>
    <br>
    HTTP 메소드는 요청의 목적이나 종류를 나타내는 수단입니다.<br>
    총 9개의 종류가 있으며, 주로 사용되는 메소드는 5가지로 GET, POST, DELETE, PUT, PATCH 가 있습니다.<br>
    HTTP method의 특징으로는 안정성과 멱등성이 있습니다.
</details>

<br>

<details>
    <summary><b>멱등성에 대해 설명해주세요</b></summary>
    <br>
    멱등성이란 여러번 요청한 결과가 한번 요청한 결과와 같은 특징을 말합니다.<br>
    GET 메소드는 데이터를 조회하는 메소드이므로 멱등성을 띄고, POST 메소드는 데이터를 생성하는 메소드이므로 멱등성을 띄지 않습니다.<br>
    PATCH 메소드는 상황에 따라서 멱등성을 띄게 됩니다.<br>
    예를 들어 요청 데이터를 그대로 수정하는 경우에는 멱등성을 띄지만, 조회수 업데이트와 같이 데이터가 1씩 증가하는 경우에는 멱등성을 띄지 않습니다.
</details>

<br>

<details>
    <summary><b>GET과 POST의 차이에 대해 설명해주세요</b></summary>
    <br>
    GET은 조회를 위한 메소드로, 조회 정보를 URI에 담아 요청하며 HTTP Body를 사용하지 않습니다.<br>
    반면 POST는 생성을 위한 메소드로 데이터 생성 정보를 HTTP Body에 담아 요청합니다.<br>
    또한 GET은 멱등성을 가지는 반면 POST는 멱등성을 가지지 않습니다.
</details>

<br>

<details>
    <summary><b>POST와 PUT의 차이에 대해 설명해주세요</b></summary>
    <br>
    POST는 데이터를 생성하는 메소드로, 여러번 요청하면 데이터를 반복적으로 생성하므로 멱등성을 띄지 않습니다. <br>
    반면 PUT은 데이터를 수정 혹은 삭제하는 메소드로, 만약 수정할 데이터가 없다면 생성하고 있다면 해당 데이터를 수정합니다.<br>
    따라서 PUT은 여러번 요청해도 같은 데이터만을 수정하므로, 멱등성을 가집니다.
</details>


<br>

<details>
    <summary><b>PUT과 PATCH의 차이에 대해 설명해주세요</b></summary>
    <br>
    PUT은 데이터의 자체를 변경하는 메소드입니다. <br>
    만약 데이터의 일부만 전달할 경우, 전달하지 않는 데이터는 null로 들어가게 됩니다.<br>
    반면 PATCH는 데이터의 일부를 수정하는 메소드로 데이터 일부만 요청하면 해당 데이터만 변경됩니다.
</details>


<br>

<details>
    <summary><b>HTTP status code에 대해 설명해주세요</b></summary>
    <br>
    HTTP 상태 코드란 http 요청의 처리 결과를 응답에서 알려주기 위한 정보입니다.<br>
    5가지 종류의 상태 코드가 있고 이는 2xx 와 같은 형태로 표기합니다.<br>
    100번대 코드는 요청을 받고 처리중인 상태를 뜻하며 현재는 거의 사용되지 않습니다.<br>
    200번대 코드는 요청이 정상 처리된 상태를 의미합니다.<br>
    300번대 코드는 리다이렉션을 수행해야하는 상태이며 location 헤더가 있다면 해당 location 위치로 이동하도록 합니다.<br>
    400번대 코드는 클라이언트측에서 오류가 발생한 상태를 의미하고, 500번대 코드는 서버측에서 오류가 발생한 상태를 의미합니다.
</details>

<br>