## 4.15 주제

관계형 데이터베이스  
데이터베이스를 사용하는 이유  
관계형 데이터베이스의 개념과 장단점  
[참고](https://medium.com/@duddk1551/db-rdb-%EA%B4%80%EA%B3%84%ED%98%95%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%99%80-nosql-adbd21f6f9f1)    
DML, DDL, DCL  
Key  
Join  
NoSQL  
NoSQL의 개념  
RDB VS NoSQL  
Redis  
Sharding&Master/Slave  
[참고](https://gmlwjd9405.github.io/2018/09/24/db-partitioning.html)
이상 현상과 정규화
---
**예상질문**

1. 관계형 데이터베이스가 무엇인가요? 그냥 데이터베이스랑 어떻게 다른가요?
    - 가장 많이 사용되고 있는 데이터베이스 중 하나
    - 테이블로 이루어져있고, Key-value 값으로 관계를 나타낸다.
    - 즉, 행과 열로 이루어진 각각의 테이블을 고유값(Primary Key)을 참조하여 서로 종속되는 관계(=연결하는 것)를 표현

2. DBMS의 특징이 무엇인가요?
    - 데이터의 독립성, 무결성, 보안성, 일관성, 중복 최소화을 지키기 위해서 사용합니다.
    - 독립성이란 물리적 독립성과 논리적 독립성이 있습니다.
      물리적 독립성이란 내부 스키마가 변경되어도 외부/개념 스키마가 영향을 받지 않도록 지원
      논리적 독립성이란 개념 스키마가 변경되어도 외부 스키마에는 영향을 미치지 않도록 지원
    - 무결성이란 잘못된 경로를 통해 이상한 데이터가 쓰이는 것을 유효성 검사를 통해 데이터 무결성을 제공합니다.
    - 보안성이란 인증된 사용자들만 데이터베이스에 접근하여 데이터를 수정하거나 삭제하는 등의 조작행위를 할 수 있도록 해줍니다.
    - 일관성이란 논리적 구조로 관리함으로써 연관된 데이터들을이 값이 함께 변할 수 있도록 하여 데이터들의 일관성을 지켜줍니다.
    - 중복 최소화란 데이터를 통합하여 관리함을써 파일 시스템의 가장 큰 문제점인 중복 문제를 해결해줍니다.

3. 관계형 데이터베이스의 장점 2가지와 단점 2가지 말해주세요.
    - 장점
        1. 범용적이고 안정적이며 데이터의 일관성을 보장한다.
        2. 복잡한 형태의 쿼리가 가능해서 원하는 데이터를 추출할수 있다. (join등의 연산을 지원)
    - 단점
        1. 테이블간의 관계를 맺는 과정이 굉장히 복잡하다.
        2. 대량의 데이터 입력, 조회시 성능이 저하된다.
        3. 테이블 구조의 변경시 많은 패널티가 따른다.

4. DML, DDL, DCL이 무엇인지 설명해주세요.

5. Key의 종류에 대해서 설명해주세요.

6. Join의 종류에 대해서 설명해주세요.

7. NoSQL이 무엇인가요?
    - RDB와 달리 관계가 없는 비관계형 데이터베이스입니다.
    - RDBMS가 처리하지 못하는 비정형 데이터를 처리하고 용량의 한계를 뛰어넘기 위해서 나타났습니다.
    - 대표적으로 MongoDB, Redis가 있습니다.

8. NoSQL의 특징 및 장단점에 대해서 이야기해주세요.
    - 특징
        - 유연성 : 스키마 선언 없이 필드의 추가 및 삭제가 자유로운 Schema-less 구조
        - 확장성 : 스케일 아웃에 의한 서버 확장이 용이
        - 고성능 : 대용량 데이터를 처리하는 성능이 뛰어나다
        - 가용성 : 여러 대의 백업 서버 구성이 가능하여 장애 발생 시에도 무중단 서비스가 가능
    - 장점
        - 스키마가 없기 때문에 유연하다. 즉 언제든지 데이터를 조정하고 새로운 필드를 추가할 수 있다.
        - 수직 및 수평적 확장(샤딩) 이 가능하므로 데이터베이스가 애플리케이션에서 발생시키는 모든 읽기 / 쓰기 요청 처리가 가능하다
        - 데이터는 애플리케이션이 필요로 하는 형식으로 저장된다. 이렇게 하면 데이터를 읽어오는 속도가 빨라진다.
    - 단점
        - 데이터베이스 일관성에 약하다. 이 일관성을 가용성, 분할 용인, 속도와 맞바꾸었다
            - 분할 용인 : 네트워크 실패로 인하여 임의의 분할이 발생해도 시스템은 계속적으로 동작해야 한다. 임의의 메시지들의 손실 또는 시스템의 부분 실패에도
              불구하고, 시스템은
              지속적으로 동작
        - key값에 대한 입출력만 지원한다.
        - 스키마가 정해져 있지 않아, 데이터에 대한 규격화가 되어 있지 않다.
        - 데이터가 여러 컬렉션에 중복되어 있어서 데이터를 UPDATE 하는 경우 모든 컬렉션에서 수행해야하기 때문에 느리다.
        - 데이터 중복으로 인한 수정 작업의 번거로움

9. RDB와 NoSQL의 차이점에 대해서 이야기해주세요.
    - NoSQL은 비정형적인 데이터를 다룰 수 있습니다.

10. Redis가 뭔가요?
    - NoSQL DBMS입니다.
    - Key, Value 구조의 비정형 데이터를 저장하고 관리하기 위한 오픈 소스 기반의 비관계형 데이터 베이스 관리 시스템 (DBMS)
    - 캐싱, 세션 관리, 대기열 등으로 사용되며 인메모리 데이터 구조를 가진 저장소

11. Redis의 특징이 무엇인가요?
    - 다양한 데이터 타입을 저장할 수 있습니다.
        - redis 는 디스크가 아닌 메모리 기반의 데이터 저장소 입니다.  
          디스크 접근에 걸리는 시간이 없기 때문에 캐시로도 많이 사용됩니다.  
          하지만 메모리에만 의존하지 않기 때문에 서버가 shutdown 되더라도 정보가 유실되지 않습니다.  
          중간마다 디스크에 저장하는 snapshot 방식을 사용하고 모든 로그를 기록해 서버가 재시작 할 시에 로그를 기준으로 데이터를 복구합니다.

12. Sharding이 무엇인가요?

13. Master/Slave가 무엇인가요?

14. DB의 이상현상이 무엇인가요?
    - 갱신이상
      : 어떤 값을 업데이트 했을때 그 속성의 다른 속성값들과의 불일치가 발생하는 현상
    - 삭제이상
      : 원하는 값만 테이블에서 삭제하고 싶은데, 하나의 튜플이 삭제를 원하지 않는 속성값도 갖고 있기 때문에 같이 지워져서 발생하는 문제
    - 삽입이상
      : 원치 않는 필드의 값도 삽입해야 하는 경우

15. 어떻게 이상현상을 해결할 수 있나요?

16. 정규화가 무엇인가요?
    - 테이블 간에 중복된 데이타를 허용하지 않는다는 것
    - 무결성(Integrity)를 유지할 수 있습니다.
    - 너무 많이 분리를 하게 된다면 쿼리가 복잡해지고 조인이 자주 진행될 수 있습니다.
    - 따라서 성능이 저하될 수 있기 떄문에 반정규화를 진행해야할 수도 있습니다.

---

## 트랜잭션

### 트랜잭션 개념

: 데이터베이스의 상태를 변환시키는 하나의 논리적 기능을 수행하기 위한 작업의 단위 또는 한꺼번에 모두 수행되어야 할 일련의 연산들

- Atomicity(원자성)
    1. 트랜잭션의 연산은 데이터베이스에 모두 반영되든지 아니면 전혀 반영되지 않아야 한다.
    2. 트랜잭션 내의 모든 명령은 반드시 완벽히 수행되어야 하며, 모두가 완벽히 수행되지 않고 어느하나라도 오류가 발생하면 트랜잭션 전부가 취소되어야 한다.
- Consistency(일관성)
    1. 트랜잭션이 그 실행을 성공적으로 완료하면 언제나 일관성 있는 데이터베이스 상태로 변환한다.
    2. 시스템이 가지고 있는 고정요소는 트랜잭션 수행 전과 트랜잭션 수행 완료 후의 상태가 같아야 한다.
- Isolation(독립성,격리성)
    1. 둘 이상의 트랜잭션이 동시에 병행 실행되는 경우 어느 하나의 트랜잭션 실행중에 다른 트랜잭션의 연산이 끼어들 수 없다.
    2. 수행중인 트랜잭션은 완전히 완료될 때까지 다른 트랜잭션에서 수행 결과를 참조할 수 없다.
- Durablility(영속성,지속성)
    1. 성공적으로 완료된 트랜잭션의 결과는 시스템이 고장나더라도 영구적으로 반영되어야 한다.

### ACID

- Atomicity(원자성)
    1. 트랜잭션의 연산은 데이터베이스에 모두 반영되든지 아니면 전혀 반영되지 않아야 한다.
    2. 트랜잭션 내의 모든 명령은 반드시 완벽히 수행되어야 하며, 모두가 완벽히 수행되지 않고 어느하나라도 오류가 발생하면 트랜잭션 전부가 취소되어야 한다.
- Consistency(일관성)
    1. 트랜잭션이 그 실행을 성공적으로 완료하면 언제나 일관성 있는 데이터베이스 상태로 변환한다.
    2. 시스템이 가지고 있는 고정요소는 트랜잭션 수행 전과 트랜잭션 수행 완료 후의 상태가 같아야 한다.
- Isolation(독립성,격리성)
    1. 둘 이상의 트랜잭션이 동시에 병행 실행되는 경우 어느 하나의 트랜잭션 실행중에 다른 트랜잭션의 연산이 끼어들 수 없다.
    2. 수행중인 트랜잭션은 완전히 완료될 때까지 다른 트랜잭션에서 수행 결과를 참조할 수 없다.
- Durablility(영속성,지속성)
    1. 성공적으로 완료된 트랜잭션의 결과는 시스템이 고장나더라도 영구적으로 반영되어야 한다.

### LOCK

: RDB에서는 locking은 데이터를 읽을 타이밍과 데이터를 사용하는 타이밍 사이의 데이터 변경으로부터 데이터를 방어하는 행동입니다.

- 데이터의 일관성과 무결성을 지킬 수 있습니다.
- 동시에 한 데이터에 접근시 데이터의 일관성을 지키기 위해서 그 순서를 보장하는 것이다.
- lock 종류
    1. Shared Lock (공유 락) : 읽기 O, 쓰기 X
        - Read Lock라고도 하는 공유락은 데이터를 읽을 때 사용하는 Lock입니다. Read Lock은 같은 Read Lock 끼리는 동시에 접근이 가능합니다.
          Database의 주요 기능인 데이터 일관성과 무결성을 해치지 않기 때문입니다. 사용자가 데이터를 읽어 갈 뿐, 데이터 변경이 없기 때문에 가능합니다.
          대신 그 다음에 나올 Exclusive Lock의 접근을 막습니다.
    2. Exclusive Lock (배타 락) : 읽기 X, 쓰기 X
        - Write Lock이라고도 하는 베타락은 데이터를 변경할 때 사용하는 Lock입니다. 트랜잭션이 완료될 때까지 유지됩니다. Exclusive Lock이 끝나기
          전까지 어떠한 접근도 허용하지 않습니다. 이 Lock은 다른 트랜잭션이 수행되고 있는 데이터에 대해서 접근하여 Lock을 걸 수 없습니다.
       
- lock 전략
    1. optimistic (낙관적 락)

    - 여러개의 트랜잭션이 서로에게 영향을 주는 것없이 완료할 수 있다고 가정하는 것입니다.
    - commit 전에 각 트랜잭션은 자신의 데이터가 다른 트랜잭션들에게 변경되지 않았는지를 검증합니다. 만약 변경되어서 충돌된다면 commit 된 트랜잭션은 롤백되게
      됩니다.

    2. pessimistic (비관적 락)

    - concurrent하게 돌아가는 트랜잭션은 결국 서로 충돌한다고 가정하는 것입니다.
    - 데이터를 읽을 때 lock 하는 것이 필요하고, 데이터 사용을 끝냈을 경우에만 애플리케이션 lock 을 해제합니다.
    - 데드락(Dead Lock)의 위험성이 있다.
        1. Shared Lock : 동시에 읽기 O, Update/Delete X
        2. Exclusive Lock : 읽기, 수정, 삭제 모두 X

### 트랜잭션 격리수준 : 여러 트랜잭션이 처리될 때, 트랜잭션끼리 얼마나 서로 고립되어 있는지를 나타내는 것

- READ UNCOMMITTED : 격리 수준 낮음
- READ COMMITTED
- REPEATABLE READ
- SERIALIZABLE     : 격리 수준 높음
- 일반적으로 온라인 서비스 중에는 READ COMMITTED나 REPEATABLE READ 중 하나를 사용한다.
- oracle = READ COMMITTED, mysql = REPEATABLE READ

🍒 **종류별 설명**

- READ UNCOMMITTED
    - 어떤 트랜잭션의 변경내용이 COMMIT이나 ROLLBACK과 상관없이 다른 트랜잭션에서 보여진다.
    - *더티리드(Dirty Read) 문제*가 발생할 수도 있다.

- READ COMMITTED
    - 어떤 트랜잭션의 변경 내용이 COMMIT 되어야만 다른 트랜잭션에서 조회할 수 있다.
    - *NON-REPETABLE READ 부정합 문제*가 발생할 수도 있다.
- REPETABLE READ
    - 트랜잭션이 시작되기 전에 커밋된 내용에 대해서만 조회할 수 있는 격리수준
    - 자신의 트랜잭션 번호보다 낮은 트랜잭션 번호에서 변경된(+커밋된) 것만 보게 되는 것이다.
    - NON-REPETABLE READ 부정합이 발생하지 않는다.
    - *UPDATE 부정합 문제*가 발생할 수 있다. (해결 방법 : UPDATE의 경우 변경을 수행할 로우에 대해 잠금이 필요하다.)
    - *Phantom READ 문제*가 발생할 수 있다.
- SERIALIZABLE
    - 가장 단순하고 가장 엄격한 격리수준이다.
    - 읽기 작업에도 공유 잠금을 설정하게 되고, 이러면 동시에 다른 트랜잭션에서 이 레코드를 변경하지 못하게 된다.
    - 동시처리 능력이 다른 격리수준보다 떨어지고, 성능저하가 발생하게 된다.

🍊 [참고블로그](https://joont92.github.io/db/%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B2%A9%EB%A6%AC-%EC%88%98%EC%A4%80-isolation-level/)

## 인덱스

### 인덱스 개념 : 추가적인 쓰기 작업과 저장 공간을 활용하여 데이터베이스 테이블의 검색 속도를 향상시키기 위한 자료구조

- 인덱스를 활용하면, 데이터를 조회하는 *SELECT 외에도 UPDATE나 DELETE의 성능이 함께 향상*된다. 그러한 이유는 해당 연산을 수행하려면 해당 대상을 조회해야만
  작업을
  할 수 있기 때문이다.

- 인덱스(index)의 장점과 단점
    - 장점
        1. 테이블을 조회하는 속도와 그에 따른 성능을 향상시킬 수 있다.
        2. 전반적인 시스템의 부하를 줄일 수 있다.
    - 단점
        1. 인덱스를 관리하기 위해 DB의 약 10%에 해당하는 저장공간이 필요하다.
        2. 인덱스를 관리하기 위해 추가 작업이 필요하다.
        3. 인덱스를 잘못 사용할 경우 오히려 성능이 저하되는 역효과가 발생할 수 있다.

- 인덱스(index)를 사용하면 좋은 경우
    - 규모가 작지 않은 테이블
    - INSERT, UPDATE, DELETE가 자주 발생하지 않는 컬럼
    - JOIN이나 WHERE 또는 ORDER BY에 자주 사용되는 컬럼
    - 데이터의 중복도가 낮은 컬럼

🍊 [참고 블로그](https://mangkyu.tistory.com/96)

### Clustered index, Non-Clustered index

- Clustered index
    - Clustered Index는 테이블의 데이터를 지정된 컬럼에 대해 *물리적으로 데이터를 재배열*
    - 범위 검색에 강력하다
    - 입력/수정/삭제 시에도 정렬을 수행하여 입력/수정/삭제 속도는 더 느리다.
    - 한 테이블당 하나만 존재한다.
- Non-Clustered index
    - Clustered Index는 *루트 페이지*와 *리프 페이지*로 구성되며, 리프 페이지는 데이터 그 자체
    - Clustered Index보다 검색 속도는 느리지만, 데이터의 입력/수정/삭제는 더 빠르다.
    - 한 테이블당 여러개가 존재할 수 있다.

### 인덱스 자료구조

1. Hash Table
    - key-value 형태로 데이터를 저장
    - 시간복잡도는 O(1)이며 매우 빠른 검색을 지원
    - 빠른 데이터 검색이 필요할 때 유용
    - Key 충돌이 있는 경우에는 정책에 따라 부가적인 처리가 필요
    - DB 인덱스에서 해시 테이블이 사용되는 경우는 제한적
    - 이유는 해시가 등호(=) 연산에만 특화되었기 때문, 만일 해시함수가 조금이라도 달라지면 전혀 다른 값을 생성
    - 부등호 연산(>, <)이 자주 사용되는 데이터베이스 검색을 위해서는 해시 테이블이 적합하지 않다.
    - 따라서 인덱스 혜택을 전혀 받지 못함. -> B+Tree 자료구조를 활용 多
2. B-Tree
3. B+Tree

🍊 [참고 블로그](https://junhyunny.github.io/information/data-structure/db-index-data-structure/)

## 예상질문

1. 프로젝트 하실 때 트랜잭션 처리할 것이 있었나요? 있었다면 어떻게 처리했는지 알려주세요.
    - Event 조회에 관련된 기능 개발을 맡았습니다.
    - 그때 조회에서 스프링에서 제공해주는 읽기 전용 모드를 사용해서 트랜잭션을 설정해주었습니다.
    - 그렇게 처리하였을 때 hibernate 세션 플러쉬 모드를 Manual
      🍊 [참고](https://willseungh0.tistory.com/75)
2. 프로젝트 하실 때 인덱스 어떻게 사용하셨는지 설명해주세요.