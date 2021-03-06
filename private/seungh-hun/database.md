# Database
:open_book: Contents
- [Database](#database)
  - [관계형 데이터베이스란?](#관계형-데이터베이스란)
    - [구성요소](#구성요소)
    - [데이터베이스를 사용하는 이유](#데이터베이스를-사용하는-이유)
    - [관계형 데이터베이스의 특징](#관계형-데이터베이스의-특징)
    - [관계형 데이터베이스 언어](#관계형-데이터베이스-언어)
    - [Key](#key)
    - [Join](#join)
  - [Replication](#replication)
    - [Replication 사용 목적](#replication-사용-목적)
  - [Sharding](#sharding)
    - [장점](#장점)
    - [단점](#단점)
  - [이상현상](#이상현상)
  - [정규화](#정규화)
    - [나쁜 릴레이션](#나쁜-릴레이션)
    - [함수적 종속성](#함수적-종속성)
    - [제 1정규형](#제-1정규형)
    - [제 2정규형](#제-2정규형)
    - [제 3정규형](#제-3정규형)
    - [정규화의 장점](#정규화의-장점)
    - [정규화의 단점](#정규화의-단점)
    - [반정규화](#반정규화)
  - [트랜잭션](#트랜잭션)
    - [트랜잭션 상태](#트랜잭션-상태)
    - [트랜잭션과 잠금](#트랜잭션과-잠금)
    - [ACID - 트랜잭션의 특성](#acid---트랜잭션의-특성)
  - [트랜잭션 격리 수준](#트랜잭션-격리-수준)
    - [READ UNCOMMITTED](#read-uncommitted)
    - [READ COMMITTED](#read-committed)
    - [REPEATABLE READ](#repeatable-read)
    - [SERIALIZABLE](#serializable)
  - [교착상태](#교착상태)
    - [교착상태의 발생 빈도를 낮추는 방법](#교착상태의-발생-빈도를-낮추는-방법)
    - [MySQL의 자동 데드락 감지](#mysql의-자동-데드락-감지)
  - [인덱스](#인덱스)
    - [디스크 읽기 방식](#디스크-읽기-방식)
    - [인덱스란?](#인덱스란)
    - [B-Tree 인덱스](#b-tree-인덱스)
    - [Hash 인덱스](#hash-인덱스)
    - [클러스터링 인덱스](#클러스터링-인덱스)
    - [유니크 인덱스](#유니크-인덱스)
  - [NoSQL](#nosql)
  - [NoSQL의 분류](#nosql의-분류)
    - [Key-Value Model](#key-value-model)
    - [Document Model](#document-model)
    - [Column Model](#column-model)
  - [SQL VS NoSQL](#sql-vs-nosql)
    - [SQL의 장점](#sql의-장점)
    - [SQL의 장점](#sql의-장점-1)
    - [NoSQL의 장점](#nosql의-장점)
    - [NoSQL의 단점](#nosql의-단점)
    - [SQL이 더 좋을 때](#sql이-더-좋을-때)
    - [NoSQL이 더 좋을 때](#nosql이-더-좋을-때)
---

## 관계형 데이터베이스란?
현재 가장 많이 사용되는 데이터베이스로 테이블로 이루어져있다.

### 구성요소
- 테이블
  - 행과 열로 이루어진 데이터의 집합을 테이블이라 한다
  - 일반적인 데이터베이스에서는 행과 열만 있으면 테이블이라고 하지만, 관계형 데이터베이스에서는 특별한 제약을 추가해서 **릴레이션**이라한다.
  - 아래 조건을 만족하는 테이블만 릴레이션이 될 수 있다
    - 모든 값은 유일한 값을 가진다
    - 하나의 릴레이션에 중복되는 행이 존재하면 안된다.

- 행
  - 테이블을 구성하는 데이터들 중 가로로 묶은 데이터셋을 의미한다
  - 관계형 데이터베이스에서는 튜플 또는 레코드라고 한다

- 열
  - 테이블을 구성하는 데이터들 중 세로로 묶은 데이터셋을 의미한다
  - 일반적으로 열은 테이블의 속성을 의미하며 구성하는 값들은 같은 도메인으로 되어있다.
  - 관계형 데이터베이스에서 속성이라한다.

- 도메인
  - 필드에 채워질 수 있는 값의 집합이다
  - 도메인이 정수인 속성 필드에 문자열이 들어갈 수 없다

- 스키마
  - 데이터베이스의 구조를 전반적으로 기술한 것을 의미한다
  - 구체적으로 데이터베이스를 구성하는 데이터의 레코드 크기, 키의 정의, 레코드 간 관계 등을 정의한 것을 말한다
  - 사용자 관점에 따라 내부, 외부 개념 스키마로 구분한다
  - DBMS는 외부 스키마에 명세된 사용자의 요구를 개념 스키마로 변환하고, 다시 내부 스키마로 변환한다.

  - 외부 스키마
    - 사용자의 입장에서 정의한 데이터베이스 논리구조
    - 데이터들을 어떤 형식, 구조, 화면을 통해 사용자에게 보여줄 것인가에 대한 명세를 말한다
    - 데이터베이스는 여러 개의 외부 스키마가 있을 수 있다
    - 일반 사용자에게는 질의어를 통해 DB를 쉽게 사용할 수 있도록 하고 응용 프로그래머는 언어를 사용해서 DB에 접근하도록 한다

  - 개념 스키마
    - 조직체 전체를 관장하는 입장에서 DB를 정의한 스키마
    - DB에 대한 모든 논리적 구조를 기술하기 때문에 데이터베이스 하나만 존재하며, 통상 스키마라고 하면 개념 스키마를 일컫는다

  - 내부 스키마
    - 데이터베이스가 어떻게 저장 장치에 저장될 지에 대한 명세
    - 물리적인 저장 장치와 데이터베이스 간의 관계를 정의하므로 시스템 프로그래머나 시스템 설계자가 보는 관점의 스키마이다.

### 데이터베이스를 사용하는 이유
데이터베이스가 존재하기 이전에는 파일 시스템을 이용하여 데이터들을 관리하였다. 데이터를 각각의 파일 단위로 저장하며 이런 일들을 처리하기 위한 독립적인 애플리케이션과 상호 연동되어야 한다. 이때 문제점은 데이터의 종속성과 중복성, 무결성이다. 파일 시스템을 사용하면서 발생하는 문제점을 해결하기 위해 데이터베이스를 사용한다.

1. 데이터의 독립성
   - 물리적 독립성: 데이터베이스의 사이즈를 늘리거나 성능 향상을 위해 데이터 파일을 늘리거나 새롭게 추가하더라도 관련된 응용 프로그램을 수정할 필요가 없다
   - 데이터베이스는 논리적인 구조로 다양한 응용 프로그램의 논리적 요구를 만족시켜줄 수 있다.
2. 데이터의 무결성
   - 여러 경로를 통해 잘못된 데이터가 발생하는 경우의 수를 방지하는 기능으로 데이터의 유효성 검사를 통해 데이터의 무결성을 구현하게 된다
3. 데이터의 보안성
   - 인가된 사용자들만 데이터베이스나 데이터베이스 내의 자원에 접근할 수 있도록 계정 관리 또는 접근 권한을 설정함으로써 모든 데이터에 보안을 구현할 수 있다
4. 데이터의 일관성
   - 연관된 정보를 논리적인 구조로 관리함으로써 어떤 하나의 데이터만 변했을 경우 발생할 수 있는 데이터의 불일치성을 배제할 수 있다. 또한 작업 중 일부 데이터만 변경되어 나머지 데이터와 일치하지 않는 경우의 수를 배제할 수 있다.
5. 데이터 중복 최소화
   - 데이터를 통합해서 관리함으로써 파일 시스템의 단점 중 하나인 자료의 중복과 데이터의 중복성 문제를 해결할 수 있다

### 관계형 데이터베이스의 특징
1. 데이터의 분류, 정렬, 탐색 속도가 빠르다
2. 데이터의 무결성을 보장해준다
3. 기존에 작성된 스키마를 수정하기 어렵다
4. 조인으로 인해 복잡한 쿼리가 발생하거나 성능 저하가 발생할 수 있다


### 관계형 데이터베이스 언어
- DDL
  - 데이터 정의어
  - 데이터베이스의 스키마를 정의한다
  - CREATE, ALTER, DROP
- DML
  - 데이터 조작어
  - 데이터베이스의 데이터를 수정, 삽입, 삭제, 검색 한다
  - UPDATE, INSERT, DELETE, SELECT
- DCL
  - 데이터 제어어
  - 데이터베이스에 접근하고 데이터를 사용할 수 있는 권한을 제어한다
  - GRANT, REVOKE

### Key
- 슈퍼키
  - 유일성 특성을 만족하는 속성 또는 속성의 집합
  - 유일성은 만족하지만 최소성은 만족하지 않는다
- 후보키
  - 슈퍼키들 중 유일성과 최소성을 모두 만족하는 속성 또는 속성들의 집합
  - 후보키를 구성하는 어떤 속성이 제외되면 튜플을 유일하게 식별할 수 없다
- 기본키
  - 여러 후보키들 중 기본적으로 사용할 키를 선택한 것
  - 기본키의 고려 사항은 아래와 같다
    - 기본키는 null이 될 수 없다
    - 기본키의 값이 변경되는 경우 매번 기본키로 적합한지 검사해야하므로, 불변값이 적절하다
- 외래키
  - 다른 릴레이션의 기본키
  - 한 릴레이션이 다른 릴레이션을 참조하기 위해 사용하는 키
- 대체키
  - 기본키로 선택되지 못한 후보키

### Join
두 개 이상의 테이블이나 데이터베이스를 연결하여 데이터를 검색하는 방법이다. 테이블을 연결하기 위해서는 적어도 하나의 컬럼을 서로 공유해야 한다.

관계형 데이터베이스에서 정규화를 수행하면 의미있는 테이블로 데이터들이 나뉜다. 따라서 서로 관계가 있는 테이블을 효과적으로 검색하기 위해 조인을 사용한다.

- INNER JOIN
  - 조인 구문에 기반한 두 개의 테이블의 컬럼 값을 결합하여 새로운 결과 테이블을 생성한다
  - 컬럼 값이 동일한 경우만 가져온다
- OUTER JOIN
  - 조인 대상 테이블에서 특정 테이블의 모든 데이터가 필요한 경우 사용한다
  - LEFT OUTER JOIN
    - 좌측 테이블의 모든 데이터가 필요한 경우 사용한다
    - 우측 테이블에 조인 컬럼 데이터가 없는 경우 NULL로 처리된다
  - RIGHT OUTER JOIN
    - 우측 테이블의 모든 데이터가 필요한 경우 사용한다
    - 좌측 테이블에 조인 컬럼 데이터가 없는 경우 NULL로 처리된다
  - FULL OUTER JOIN
    - 양쪽의 모든 데이터가 필요한 경우 사용한다
- CORSS JOIN
  - 조인이되는 두 테이블의 카르티시안 곱을 한다
  - 따라서 M*N 크기의 새로운 테이블이 생성된다
- SELF JOIN
  - 한 테이블에서 자기 자신을 조인한다

## Replication
중앙의 데이터베이스에 저장된 데이터를 다른 데이터베이스에 복제하는 것을 의미한다. 중앙 데이터베이스 서버를 **소스 서버**, 복제된 데이터를 가지고 있는 데이터베이스 서버를 **레플리카 서버**라 한다.

쓰기 연산은 소스 서버에서만 이루어지고, 레플리카 서버에서는 소스 서버로 부터 사본을 전달받아 읽기 연산만 수행한다.

### Replication 사용 목적
- 스케일 아웃
  - 갑자기 늘어나는 트래픽을 대응하는데 유연한 구조
- 데이터 백업
  - 레플리카를 하지 않더라도 데이터를 백업해야한다
  - 백업 과정은 실제 처리중인 쿼리에 영향을 미칠 수 있다
  - 레플리카 서버에서 데이터를 백업하여 소스 서버에서 백업시 발생하는 문제를 해결할 수 있다
- 데이터 분석
  - 분석용 쿼리는 대량의 데이터를 조회하고 쿼리 자체가 무거운 경우가 많다
  - 레플리카 서버에서 분석용 쿼리만 적용하는 것이 좋다
- 데이터의 지리적 분산
  - 데이터베이스와 애플리케이션 서버가 멀리 떨어져 있다면 응답을 늦게 받게 된다
  - 빠른 응답을 위해서 애플리케이션 서버에 가깝게 서버를 구성하는 것이 좋다
  - 자연 재해와 같은 이유로 데이터베이스 서버 중 하나가 파괴되어도 데이터는 보존된다
- 쿼리 병렬 처리
  - 데이터 변경은 소스 서버에서 이루어지고, 읽기 연산은 레플리카에 분산되어 병렬로 처리할 수 있는 쿼리가 늘어난다 

## Sharding
샤딩은 하나의 거대한 데이터베이스를 수평적으로 확장하여 여러 개의 작은 단위로 나눈 후, 물리적으로 다른 위치에 분산하여 저장 및 관리하는 기술을 의미한다. 각각의 데이터베이스를 샤드라고 하며, 모든 샤드는 같은 스키마를 사용하지만 데이터 사이는 중복되지 않는다.

샤딩 전략을 구현할 때 가장 중요한 것은 샤딩 키를 어떻게 정하느냐이다. 샤딩 키는 파티션 키라고도 부르는데, 데이터가 어떻게 분산될지 정하는 하나 이상의 컬럼으로 구성된다. 샤딩을 통해 데이터베이스의 크기나 트래픽을 분산하여 성능을 높일 수 있다.

### 장점
- 수평적 확장이 용이하다
- 한 테이블을 여러 테이블로 분할하여 쿼리의 행 수가 줄어들고 결과 집합이 빠르게 반환된다
- 데이터베이스 손상으로 일부 사용자는 서비스를 사용할 수 없을 수 있지만, 전체 데이터베이스가 손상되지는 않는다.

### 단점
- 데이터의 재샤딩
  - 데이터가 너무 많아져 하나의 샤드로 감당하기 어렵거나 데이터 분포가 균등하지 않는경우 샤드 키를 계산하는 함수를 변경하고 데이터를 재배치해야한다
- 특정 샤드에 질의가 집중되어 서버에 과부하가 걸릴 수 있다
- 조인과 정규화
  - 하나의 데이터베이스를 여러 샤드로 쪼개면 여러 샤드에 걸친 데이터를 조인하기 힘들다
  - 이를 해결하기 위해 데이터베이스를 비정규화하여 하나의 테이블에서 질의가 수행될 수 있도록한다

## 이상현상
삽입, 삭제, 수정과 같은 데이터베이스의 상태를 변경하는 작업에서 발생할 수 있는 현상을 의미한다
- 삽입 이상
  - 불필요한 데이터를 추가적으로 삽입해야하는 경우를 의미한다. 
  - 수강 테이블에 수업을 수강하지 않는 학생 정보를 삽입할 때 굳이 미수강 데이터를 추가해야한다
- 갱신 이상
  - 데이터를 일부만 변경하여 발생하는 데이터 불일치 현상을 의미한다.
  - 수업 담당 교수님이 변경되었을 때 해당하는 다른 모든 레코드에서 값을 변경해야하는데 실수로 변경하지 못한 경우
- 삭제 이상
  - 튜플 삭제로인해 필수적인 데이터까지 함께 삭제되는 경우를 의미한다
  - 어떤 학생이 수강을 철회하는 경우 수강 정보와 함께 학생 정보도 제거될 수 있다.

## 정규화
관계형 데이터베이스에서 중복을 최소화하기 위해 데이터를 구조화하는 작업이다. 더 구체적으로 불만족스러운 나쁜 릴레이션의 애트리뷰트를 나누어서 좋은 작은 릴레이션으로 분해하는 작업을 의미한다. 정규화 과정을 거치면서 정규형을 만족하게 되며, 정규형이란 특정 조건을 만족하는 릴레이션의 스키마 형태를 의미한다.

### 나쁜 릴레이션
엔티티를 구성하고 있는 애트리뷰트간 함수적 종속성을 판단하여 좋은 릴레이션인지, 나쁜 릴레이션인지 정하게된다.

### 함수적 종속성
애트리뷰트 데이터들의 의미와 애트리뷰트들 간의 상호 관계로부터 유도되는 제약조건의 일종이다. X와 Y를 임의의 애트리뷰트 집합이라고 했을 때, X의 값이 Y의 값을 유일하게 결정한다면 'X는 Y를 함수적으로 결정한다'라고 한다.

### 제 1정규형
애트리뷰트의 도메인이 원자값을 가지는 형태를 말한다.

### 제 2정규형
모든 비주요 애트리뷰트들이 주요 애트리뷰트에 대해서 완전 함수적 종속이면 제 2정규형에 만족한다고 한다. 완전 함수적 종속이란 X가 Y를 함수적으로 결정할 때 X의 어떤 애트리뷰트라도 제거하면 더 이상 함수적 종속을 만족하지 않는 경우를 의미한다.

쉽게 말하면 X는 후보키이다.

### 제 3정규형
어떠한 비주요 애트리뷰트도 기본키에 대해서 이행적 종속되지 않으면 제 3정규형을 만족한다고 한다. 이행 함수적 종속이란 X가 Y를 함수적으로 결정하고, Y가 Z를 함수적으로 결정할 때 X가 Z를 함수적으로 결정하는 것을 의미한다.

### 정규화의 장점
- 데이터베이스의 이상 현상을 막을 수 있다
- 정규화된 데이터베이스 구조에서 새로운 데이터 형의 추가로인한 확장 시, 그 구조를 변경하지 않아도 되거나 일부만 변경해도된다.
- 사용자에게 데이터 모델을 더욱 의미있게 제공한다. 정규화된 테이블의 관계는 현실 세계의 개념들과 관계를 반영한다.

### 정규화의 단점
- 릴레이션의 분해로 조인 연산이 많아진다

조회 쿼리에서 조인 연산으로 인한 성능 저하가 크게 발생하면 반정규화를 적용한다.

### 반정규화
반정규화는 정규화된 엔티티, 속성, 관계를 시스템의 성능 향상 및 개발과 운영의 단순화를 위해 중복 통합, 분리 등을 수행하는 데이터 모델링 기법 중 하나이다. 디스크 I/O 량이 많아서 조회 시 성능이 저하되거나, 테이블끼리 경로가 너무 멀어 조인으로 인한 성능 저하가 예상되거나, 컬럼을 계산하여 조회할 때 성능이 저하될 것이 예상되는 경우 반정규화를 수행하게된다.

반정규화를 고려할만한 상황은 아래와 같다
- 자주 사용되는 테이블에 액세서하는 프로세스의 수가 가장 많고, 항상 일정 범위만 조회하는 경우
- 테이블에 대량 데이터가 있고, 대량 범위를 자주 처리하는 경우
- 테이블에 지나치게 조인을 많이 사용하게 되어 데이터를 조회하는 것이 기술적으로 어려운 경우 


## 트랜잭션
트랜잭션이란 작업의 완전성을 보장해주는 것을 의미한다. 다시말해 하나의 논리적인 작업 셋이 트랜잭션이다. 작업 셋에는 쿼리가 하나 혹은 둘 이상일 수 있다. 여러 세부 작업으로 이루어진 작업 셋이 모두 성공하면 데이터베이스에 반영하고 하나라도 실패하면 트랜잭션 이전 상태로 되돌린다.

### 트랜잭션 상태
- Active: 트랜잭션이 활성화된 상태
- Failed: 트랜잭션 실패 상태
- Partially Committed: 트랜잭션의 Commit 명령이 도착한 상태. 작업을 완료하고 Commit만 남은 상태
- Aborted: 트랜잭션 취소 상태
- Committed: 트랜잭션 완료상태

### 트랜잭션과 잠금
트랜잭션과 잠금(Lock)은 비슷해 보이지만 사용 목적이 다르다. 트랜잭션은 작업의 완전성을 보장하여 데이터베이스의 무결성을 보장하는 것이고, 잠금은 공유 자원에 대한 접근 순서를 결정하는 것이다. 따라서 트랜잭션의 작업이 수행될 때 한 데이터에 대해서 여러 커넥션의 접근을 막기 위해서 잠금을 사용한다.

### ACID - 트랜잭션의 특성
- 원자성: 트랜잭션의 작업이 하나라도 실패하면 이전 상태로 되돌리고, 모두 성공한 경우에만 데이터베이스에 반영한다
- 일관성: 트랜잭션이 완료된 이후에도 이전과 같이 데이터베이스의 일관성을 보장해야한다
- 격리성: 각각의 트랜잭션은 서로의 간섭 없이 작업을 수행한다
- 지속성: 트랜잭션이 정상적으로 종료되면 변경된 내용을 데이터베이스에 영구히 반영해야한다.

## 트랜잭션 격리 수준
여러 트랜잭션이 동시에 작업을 수행할 때 한 트랜잭션이 다른 트랜잭션에서 변경하거나 조회하는 데이터를 볼 수 있게 결정하는 것을 의미한다.

- READ UNCOMMITTED
- READ COMMITTED
- REPEATABLE READ
- SERIALIZABLE

### READ UNCOMMITTED
한 트랜잭션이 데이터를 변경하고 데이터베이스에 반영하기 전에 다른 트랜잭션에서 변경된 데이터를 조회할 수 있는 수준이다. 데이터를 변경한 트랜잭션이 성공적으로 COMMIT하면 문제가 없지만, 실패하여 ROLLBACK된 경우 엉뚱한 값을 다른 트랜잭션에서 조회할 수 있다. 이러한 문제를 DIRTY READ라 한다.

### READ COMMITTED
READ UNCOMMITTED의 Dirty read 문제를 해결하기 위한 격리 수준이다. 한 트랜잭션에서 데이터를 변경하고 COMMIT한 경우에만 다른 트랜잭션에서 변경된 데이터를 읽을 수 있고, COMMIT 이전에는 변경 전 데이터를 조회한다.

MySQL에서는 READ COMMITTED를 지원하기 위해 언두 로그를 사용한다. 한 트랜잭션에서 데이터를 변경하면 변경전 데이터는 언두 로그에 저장되고, 다른 트랜잭션에서 해당 데이터를 조회할 때 언두 로그에서 변경전 데이터를 조회한다.

하지만 READ COMMITTED 수준에서 Non-Repeatable read 문제가 발생할 수 있다. 데이터의 값을 변경한 트랜잭션이 다른 트랜잭션이 종료되기 전에 COMMIT되고, 다른 트랜잭션은 데이터를 변경한 트랜잭션이 데이터를 변경하기 전과 후에 데이터를 조회할 경우 데이터가 불일치할 수 있다.

### REPEATABLE READ
REPEATABLE READ는 Non-Repeatable read 문제를 해결하기 위한 격리 수준이다. 말 그대로 한 트랜잭션에서 얼마든지 데이터를 조회해도 항상 같은 값을 조회할 수 있는 격리 수준이다.

MySQL에서는 이를 제공하기 위해 언두 로그에 트랜잭션 ID를 함께 저장한다. 한 트랜잭션에서 데이터를 변경하면 트랜잭션 ID과 변경 전의 값이 언두 로그에 저장된다. 그리고 다른 트랜잭션이 데이터를 조회할 때 언두 로그에서 자신의 트랜잭션 ID보다 작은 값을 읽어 온다.

REPEATABLE READ에서는 Phantom read 문제가 발생할 수 있다. 데이터를 조회하는 트랜잭션이 SELETE FOR UPDATE를 하는 경우, 다시 말해 갱신을 위한 조회를 하는 경우에는 언두 로그에 락을 걸 수 없어 실제 데이터베이스에서 값을 조회하게된다. 

### SERIALIZABLE
가장 단순하면서 엄격한 격리 수준이다. 단순 읽기 작업에서도 해당 행에 대해서 락을 건다. 이로 인해 다른 격리 수준에 비해서 동시 처리 성능이 떨어진다. 

## 교착상태
교착상태란 두 개 이상의 트랜잭션이 특정 자원의 잠금을 획득한 채 다른 트랜잭션이 소유하고 있는 잠금을 요구하면 두 트랜잭션이 하염없이 작업을 대기하는 상태에 빠지게 되는 것을 의미한다.

### 교착상태의 발생 빈도를 낮추는 방법
- 트랜잭션을 자주 커밋한다
- 정해진 순서로 테이블에 접근한다.
- 읽기 잠금 획득(SELECT ~ FOR UPDATE)의 사용을 피한다
- 테이블 단위로 잠금을 획득하면 동시성은 떨어지지만 교착상태를 회피할 수 있다

### MySQL의 자동 데드락 감지
InnoDB 스토리지 엔진은 내부적으로 데드락을 감시하기 위해 잠금 대기 목록을 그래프 형태로 관리한다. 데드락 감지 스레드를 가지고 있어서 데드락 감지 스레드가 주기적으로 잠금 대기 그래프를 검사해 교착 상태에 빠진 트랜잭션을 찾아서 그 중 하나를 강제 종료한다. 강제 종료하는 트랜잭션을 정하는 언두 로그의 양이다. 언두 로그의 양이 더 적은 트랜잭션이 일반적으로 롤백의 대상이된다.

## 인덱스
### 디스크 읽기 방식

**HDD VS SSD**

- HDD는 플레이트를 회전하며 데이터를 읽는 반면, SSD는 플래시 메모리로 되어있어 원판을 기계적으로 회전할 필요가 없다
- 순차I/O와 랜덤 I/O 모두 HDD에 비해서 SSD가 성능이 우수하다
- 순차I/O에서는 그 차이가 크지 않을 수 있지만 데이터베이스 서버에서는 랜덤I/O의 비중이 훨씬 크다


**랜덤I/O VS 순차I/O**

<p align=middle>
    <img src=https://user-images.githubusercontent.com/60502370/149604393-dd5cd21d-c0e1-440b-9a65-1c6ae4e1383b.png width=300>
</p>

- 순차I/O는 3개의 페이지를 디스크에 기록하기 위해 1번의 시스템 콜을 요청했고, 랜덤I/O는 3번의 시스템 콜을 요청했다
  - 즉 디스크 헤더를 순차I/O는 한번, 랜덤I/O는 세번 움직인 것이다.
- 디스크의 성능은 헤더가 몇번 움직이냐에 따라 결정되므로 랜덤I/O의 부하가 훨씬 크다
- SSD에서도 순차I/O 보다 랜덤I/O의 부하가 훨씬 크다
- 일반적으로 쿼리를 튜닝한다는 것은 랜덤I/O 자체를 줄여주는 것이 목적이다.
  - 꼭 필요한 데이터만 읽도록 쿼리를 개선하는 것
- 데이터웨어하우스나 통계 작업에서는 인덱스를 사용하지 않고 풀 테이블 스캔하도록 유도하기도 한다.
  - 인덱스 레인지 스캔은 데이터를 읽기 위해 주로 랜덤 I/O를 사용하고 풀 테이블 스캔은 순차 I/O를 사용하기 떄문이다.

### 인덱스란?

테이블의 특정 컬럼의 값과 해당 레코드가 저장된 주소를 키와 값의 쌍(key-value)으로 삼아 별도로 정렬하여 저장한 자료구조이다. 테이블의 모든 데이터를 검색하면 시간이 오래걸리기 때문에 사용한다.

인덱스는 항상 정렬된 상태를 유지하기 때문에 값을 탐색하는 작업은 빠르지만 값을 삭제하거나 수정하는 작업은 느리다. 결론적으로 인덱스는 데이터의 저장 성능을 희생하고 대신 데이터의 검색 속도를 높인 것이다. 따라서 SELECT 쿼리 문장의 WHERE 조건절에 사용되는 컬럼이라고 해서 전부 인덱스로 생성하면 데이터 저장 성능이 떨어지고 인덱스의 크기가 비대해져 오히려 역효과가 발생할 수 있다

### B-Tree 인덱스
데이버베이스의 인덱싱 알고리즘 가운데 가장 일반적으로 사용되고, 가장 먼저 도입된 알고리즘이다. B-Tree는 칼럼의 원래 값을 변형시키지 않고 인덱스 구조체 내에서는 항상 정렬된 상태로 유지한다. B-Tree는 루트 노드, 브랜치 노드, 리프 노드로 구성된다.

- 루트 노드: 최상위 노드
- 브랜치 노드: 중간 노드
- 리프 노드: 최하위 노드

B-Tree 인덱스 알고리즘은 특정 컬럼의 값과 해당 레코드가 저장된 참조 값을 키와 값의 쌍으로 저장한다. 루트 노트와 브랜치 노드는 인덱스 키와 자식 노드의 참조 값이 저장되어 있고, 리프 노트에는 인덱스 키와 레코드 참조 값이 저장되어 있다. 인덱스 키는 항상 정렬된 상태로 유지된다.

인덱스 키를 삽입하는 경우 리프 노드에 해당 컬럼의 값과 레코드 참조 값이 저장된다. 만약 리프 노드가 가득찬 경우 리프 노드가 분리되어야 하는데, 이러한 작업이 상위 브랜치 노드까지 범위가 넓어지기 때문에 비용이 많이 든다.

인덱스 키를 삭제하는 경우는 해당 리프 노드를찾아서 삭제 마크만 하면된다. 삭제 마킹된 공간은 재사용하거나 방치할 수 있다. 마킹 작업 또한 디스크 쓰기가 발생하므로 디스크 I/O가 필요한 작업이다

인덱스 키를 수정하는 경우는 단순히 인덱스상의 키 값만 변경할 수 없다. 먼저 키 값을 삭제한 후 다시 새로운 키를 추가하는 형태로 처리된다.

따라서 INSERT, DELETE, UPDATE 작업을 할 때 인덱스 관리에 추가적인 비용이든다. 하지만 이러한 추가 비용을 감당하면서도 빠른 검색을 위해서 인덱스를 사용한다. 인덱스 키를 트리 탐색을 통해서 빠른 시간에 할 수 있다.

**B-Tree 인덱스 성능에 영향을 미치는 요소**

- 인덱스를 구성하는 컬럼의 크기
  - 컬럼의 크기가 커지면 메모리에 캐시해 둘 수 있는 레코드 수가 줄어들어 성능이 저하될 수 있다
- 유니크한 인덱스 키 값의 개수
  - 인덱스 키 값의 중복이 많으면, 해당 값에 대한 탐색이 추가적으로 이루어지기 때문에 성능이 저하될 수 있다

**다중 컬럼 인덱스**

두 개 이상의 컬럼으로 구성된 인덱스를 다중 컬럼 인덱스라고 한다. 다중 컬럼 인덱스는 컬럼들의 저장된 순서가 중요하다. 저장 순서에 따라서 정렬 기준의 우선순위가 결정되기 때문이다. 

### Hash 인덱스
B-Tree가 컬럼의 값을 변형시키지 않는 것과 다르게 컬럼의 값을 해시 값으로 계산해서 인뎅싱하는 알고리즘이다. 매우 빠른 검색을 지원하지만 값을 변형하기 때문에 값의 일부만 검색하거나 범위를 검색할 때는 해시 인덱스를 사용할 수 없다

### 클러스터링 인덱스
프라이머리 키 값이 비슷한 레코드끼리 묶어서 저장하는 것을 클러스터링 인덱스라고 한다. 중요한 것은 프라이머리 키 값에 의해 레코드 저장 위치가 결정된다는 것이다. 그리고 프라이머리 키 값이 변경된다면 해당 레코드의 물리적은 저장 위치가 바뀌어야 한다.

구조 자체는 B-Tree와 비슷하지만, 리프 노드에 레코드의 모든 컬럼이 같이 저장되어있다는 차이점이 있다. 클러스터링 테이블은 그 자체가 하나의 거대한 인덱스 구조로 관리되고 있는 것이다.

테이블의 프라이머리 키를 설정하지 않으면 MySQL InnoDB 엔진은 NOT NULL, UNITQUE INDEX 중 첫 번째 인덱스를 키로 선택하고 이마저 없으면 자동으로 레코드의 일련번호 컬럼을 생성한다. 자동으로 생성된 일련번호는 아무 의미 없는 숫자 값으로 클러스터링 되는 것이므로 아무런 혜택을 주지 않는다. 따라서 되도록이면 프라이머리 키를 설정하는 것이 좋다

**클러스터링 인덱스의 장점**
- 프라이머리 키로 검색할 때 처리 성능이 매우 빠르다
- 테이블의 모든 세컨더리 인덱서그 프라이머리 키를 가지고 있기 때문에 인덱스만으로 처리될 수 있는 경우가 많다

**클러스터링 인덱스의 단점**
- 테이블의 모든 세컨더리 인덱스가 클러스터링 키를 갖기 때문에 키 값의 크기가 클 경우 전체적으로 인덱스의 크기가 커진다
- 세컨더리 인덱스를 통해 검색할 때 프라이머리 키로 다시 한 번 검색해야 하므로 성능이 느리다
- INSERT할 때 프라이머리 키에 의해 레코드의 물리적 저장 위치가 결정되기 때문에 처리 성능이 느리다
- 프라이머리 키를 변경할 때 레코드를 DELETE 하고 INSERT 하는 작업이 필요하기 때문에 처리 성능이 느리다

### 유니크 인덱스
유니크는 인덱스라기보다는 제약 조건에 가깝다. 테이블이나 인덱스에 같은 값이 두 개 이상 저장될 수 없음을 의미한다. MySQL에서는 인덱스 없이 유니크 제약만 설정할 방법이 없다.

새로운 레코드가 INSERT 되거나 인덱스 컬럼의 값이 변경되는 경우에는 해당 값이 중복되지 않는지 확인해야 하기 때문에 일반 세컨더리 인덱스의 INSERT 보다 느리다.

## NoSQL
관계형 데이터 모델을 지양하며 대량의 분산된 데이터를 저장하고 조회하는데 특화되었으며 스키마 없이 사용 가능하거나 느슨한 스키마를 제공하는 저장소를 말한다.

대량의 데이터를 빠르게 처리하기 위해 메모리에 임시 저장하고 응답하는 등의 방법을 사용한다. 동적인 스케일 아웃을 지원하기도 하며, 가용성을 위하여 데이터 복제 등의 방법으로 관계형 데이터베이스가 제공하지 못하는 성능과 특징을 제공한다.

## NoSQL의 분류
### Key-Value Model
가장 기본적인 형태의 NoSQL 이며 키 하나로 데이터 하나를 저장하고 조회할 수 있는 단일 키-값 구조를 갖는다. 단순한 저장구조로 인하여 복잡한 조회 연산을 지원하지 않는다. 또한 고속 읽기와 쓰기에 최적화된 경우가 많다. 사용자의 프로필 정보, 웹 서버 클러스터를 위한 세션 정보, 장바구니 정보, URL 단축 정보 저장 등에 사용한다. 하나의 서비스 요청에 다수의 데이터 조회 및 수정 연산이 발생하면 트랜잭션 처리가 불가능하여 데이터 정합성을 보장할 수 없다. ex) Redis

### Document Model
키-값 모델을 개념적으로 확장한 구조로 하나의 키에 하나의 구조화된 문서를 저장하고 조회한다. 논리적인 데이터 저장과 조회 방법이 관계형 데이터베이스와 유사하다. 키는 문서에 대한 ID 로 표현된다. 또한 저장된 문서를 컬렉션으로 관리하며 문서 저장과 동시에 문서 ID 에 대한 인덱스를 생성한다. 문서 ID 에 대한 인덱스를 사용하여 O(1) 시간 안에 문서를 조회할 수 있다.

대부분의 문서 모델 NoSQL 은 B 트리 인덱스를 사용하여 2 차 인덱스를 생성한다. B 트리는 크기가 커지면 커질수록 새로운 데이터를 입력하거나 삭제할 때 성능이 떨어지게 된다. 그렇기 때문에 읽기와 쓰기의 비율이 7:3 정도일 때 가장 좋은 성능을 보인다. 중앙 집중식 로그 저장, 타임라인 저장, 통계 정보 저장 등에 사용된다. ex) MongoDB

### Column Model
하나의 키에 여러 개의 컬럼 이름과 컬럼 값의 쌍으로 이루어진 데이터를 저장하고 조회한다. 모든 컬럼은 항상 타임 스탬프 값과 함께 저장된다.

구글의 빅테이블이 대표적인 예로 차후 컬럼형 NoSQL 은 빅테이블의 영향을 받았다. 이러한 이유로 Row key, Column Key, Column Family 같은 빅테이블 개념이 공통적으로 사용된다. 저장의 기본 단위는 컬럼으로 컬럼은 컬럼 이름과 컬럼 값, 타임스탬프로 구성된다. 이러한 컬럼들의 집합이 로우(Row)이며, 로우키(Row key)는 각 로우를 유일하게 식별하는 값이다. 이러한 로우들의 집합은 키 스페이스(Key Space)가 된다.

대부분의 컬럼 모델 NoSQL 은 쓰기와 읽기 중에 쓰기에 더 특화되어 있다. 데이터를 먼저 커밋로그와 메모리에 저장한 후 응답하기 때문에 빠른 응답속도를 제공한다. 그렇기 때문에 읽기 연산 대비 쓰기 연산이 많은 서비스나 빠른 시간 안에 대량의 데이터를 입력하고 조회하는 서비스를 구현할 때 가장 좋은 성능을 보인다. 채팅 내용 저장, 실시간 분석을 위한 데이터 저장소 등의 서비스 구현에 적합하다.

## SQL VS NoSQL

### SQL의 장점
- 명확하게 정의된 스키마, 이를 통한 데이터의 무결성 보장
- 관계는 각 데이터를 중복없이 한 번만저장
### SQL의 장점
- 스키마를 사전에 계획하고, 덜 유연하다
- 데이터가 테이블로 분리되어있어 조인으로 인한 성능 저하
- 대체적으로 수직적 확장만 가능하다

### NoSQL의 장점
- 스키마가 없어서 유연하다. 언제든지 저장된 데이터를 조정하고 새로운 필드를 추가할 수 있다
- 데이터는 애플리케이션이 필요한 형태로 저장된다. 데이터를 읽어오는 속도가 빨라진다
- 수직 및 수평적 확장이 용이하다

### NoSQL의 단점
- 유연성으로 인해 데이터 구조 결정을 미루게 될 수 있다
- 데이터 중복을 계속 업데이트 해야한다
- 데이터가 여러 컬렉션에 중복되어 있기 때문에 수정 시 모든 컬렉션에 수행해야한다

### SQL이 더 좋을 때
- 관계를 맺고 있는 데이터가 자주 변경되는 경우
- 변경될 여지가 없고 명확한 스키마가 사용자와 데이터에게 중요한 경우

### NoSQL이 더 좋을 때
- 정확한 데이터 구조를 알 수 없거나 변경/확장 될 수 있는 경우
- 읽기를 자주하지만 데이터 변경은 자주 없는 경우
- 데이터베이스를 수평으로 확장해야하는 경우