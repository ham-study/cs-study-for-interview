## JDBC (Java Database Connectivity)

: 자바에서 데이터베이스의 종류에 상관없이 데이터베이스에 접속하고, 데이터들을 제어할 수 있도록 제공하는 규격입니다.  
따라서 종류에 따른 JDBC 드라이버가 존재하고, 종류에 맞는 드라이버를 로드해서 데이터베이스와 연결을 합니다.

- 왜 사용하는가?
    - 각 데이터베이스마다 데이터를 처리하는 방법이 다르기 때문에 이를 자바에서 표준화된 방법으로 접속할 수 있도록 만든 인터페이스이다.
    - 대부분의 데이터베이스는 드라이버를 지원한다.

- 단점
    1. 쿼리를 실행하기 전과 후에 많은 코드를 작성해야한다. ex ) 연결 생성, 명령문, ResultSet 닫기, 연결 등
    2. 드라이버 로드 시 예외 처리를 해주어야한다.

- JDBC Driver Manager
  : JDBC 드라이버들을 관리하며 JDBC 드라이를 통해 Connection을 만듭니다.
    - DriverManager는 Class.forName( ) 메소드를 통해서 생성됩니다.

- JDBC URL
  : DBMS와의 연결을 위한 식별값
    - JDBC 드라이버에 따라 형식이 조금씩 다릅니다.

- JDBC 실행 과정
    1. JDBC 드라이버 로드
    2. Connection 객체 생성
    3. Statement 객체 생성
    4. Query 실행
    5. Result 객체로부터 데이터 추출
    6. Result 객체 종료
    7. Statement 객체 종료
    8. Connection 객체 종료

- 데이터베이스 연결 순서
    1. JDBC 드라이버 로딩
        - Class.forName(“driver”)을 이용
        - 드라이버를 찾을 수 없을 때, ClassNotFoundException이 발생할 수 있기에 예외처리를 해주어야한다.
    2. JDBC url, db Id, db password를 사용해 Connection을 생성한다.

- 구조
  ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Foed9z%2FbtqDjGqc8Hh%2FfTNTE08lq5mhxWQecAi5k0%2Fimg.png)
  ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbsyTRf%2FbtqDhwvnosL%2FrguuuOZeGLfE9OpF7CC6H0%2Fimg.png)

## DBCP(DataBse Connection Pool)

: 커넥션 객체들을 모아둔 공간을 의미합니다. 커넥션을 계속 맺고 끊는 경우 오버헤드가 발생할 수 있기 때문에, 커넥션 객체들의 일정량을 생성해두고 계속 재활용하는 방식입니다.

- Spring 혹은 해당 웹 프레임워크를 사용하지 않는 프로젝트에서는 DB Connection에 관한 풀링을 자체로 만들어야 한다.

- 왜 사용하는가?
    - DBMS 입장에서도 커넥션을 계속 맺고 끊어야하기 때문에 오버헤드가 발생한다.
    - 더 빠르게 DB에 접근할 수 있다.

## Spring JDBC

: 기존 Java의 JDBC API의 반복되는 점을 스프링 프레임워크에 위임하여 편리하게 사용될 수 있도록 만든 규격입니다.

- Spring JDBC는 JDBC의 모든 저수준 처리를 스프링 프레임워크에 위임하므로써, Connection 연결 객체 생성 및 종료, Statement 준비/실행 및 종료,
  ResultSet 처리 및 종료, 예외 처리, 트랙잭션 등의 반복되는 처리를 개발자가 직접하지 처리하지 않고 Database에 대한 작업을 수행할 수 있다.

- SQL Query 수행하기 위해 필요한 저수준 작업을 내부적으로 처리해주고 보다 추상적인 기능을 제공하는 JdbcTemplate, SimpleJdbcInsert,
  NamedParameterJdbcTemplate 객체와 Helper 객체(RowMapper) 등을 포함한다.

- 역할
    - Connection 열기와 닫기
    - Statement 준비와 닫기
    - Statement 실행
    - ResultSet Loop처리
    - Exception 처리와 반환
    - Transaction 처리

- DataSource란?
    - connectionPool을 관리하는 목적으로 사용되는 객체이다.
    - 커넥션을 얻어오고 반납하는 등의 작업을 수행한다.

- Spring JDBC 설정 과정
    1. Dependency 추가 (build.gradle 또는 pom.xml)
    2. DataSource 설정 (application.yml) - 데이터베이스로부터 커넥션을 얻기 위함
    3. property file을 활용한 datasource 설정

- Spring에서 DataSource 설정 과정
    1. DB와의 연결을 위한 DB Server에 관한 정보(Property)를 설정한다.
        - 설정 정보 ) url, driver, username, password
    2. property file을 통해 DataSource를 Bean으로 등록한다.
        - Spring JDBC를 사용하려면 먼저, DB Connection을 가져오는 DataSource를 Spring IoC 컨테이너의 공유 가능한 Bean으로 등록해야
          한다.
    3. 생성된 DataSource Bean을 Spring JDBC에 주입한다.

![img](https://gmlwjd9405.github.io/images/setting-for-dbprogramming/data-access-layer.png)

## JDBC Template

: JDBC Template는 디자인 패턴 중 탬플릿 메소드 패턴이 적용된 클래스 입니다. 템플릿 메소드 패턴은 복잡하고 반복되는 알고리즘을 캡슐화해서 재사용하는 패턴입니다.
따라서 JDBC 처럼 순서가 일정하게 반복되는 작업에서 유용하게 쓰입니다.

## SQL

- 데이터베이스 제어를 위한 언어이며, 크게 세 종류의 언어로 나뉩니다.
- 테이블의 구조를 정의하는 DDL
    1. create
    2. alter
    3. drop
- 데이터를 조작하는 DML
    1. insert
    2. update
    3. delete
- 데이터베이스의 접근을 제어하는 DCL
    1. grant
    2. revoke

## Persistence Framework

: JDBC를 사용하기 위한 복잡하고 번거로운 작업 없이 간다한 작업으로 데이터베이스와 연동할 수 있게 제공하는 프레임워크입니다.

- 종류
    - ORM : JPA, Hibernate
    - SQL Mapper : Mybatis
- 도메인 모델과 데이터베이스 사이에 존재
- 객체정보를 DB에 저장하고, DB의 정보를 객체로 담아와 사용

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FwdU05%2FbtrbYuiT1i5%2FwEhh4hIKKLs0VyJaFBIqd1%2Fimg.png)

## Sql Mapper(MyBatis)

: 객체와 관계형 데이터베이스의 데이터를 개발자가 작성한 SQL로 매핑시켜주는 프레임워크입니다.

- 개발자가 SQL을 직접 작성해야 하며 SQL문을 실행하고 얻은 데이터를 객체로 매핑시켜줍니다.

- 장점
    1. SQL을 작성 할 줄 안다면 수월하게 사용이 가능하다.
    2. 세부적인 SQL 변경시 편리하다.

- 단점
    1. DBMS에 따라 SQL 문법이 다르기에 DBMS에 종속적이다.
    2. 개발시 SQL를 작성해야 한다.
    3. DBMS 변경시 SQL문의 재사용이 어렵다.
    4. 2개 이상의 DBMS 지원시 유지 보수가 어렵다.

## ORM (Object-relational mapping: 객체 관계 매핑)

: 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑시켜주는 프레임워크입니다.

- 객체는 객체대로 설계하고, 관계형 데이터베이스는 관계형 데이터베이스대로 설계한다.
- 설정된 객체 간의 관계를 바탕으로 자동으로 SQL를 생성하여 실행합니다.
- SQL를 직접 작성할 필요가 없다.

- 장점
    1. 객체 지향적인 코드로 직관적인 비지니스 로직을 작성할 수 있다.
    2. DBMS 종속성이 줄어들고 종류에 관계 없이 빠르게 적용 가능하다.
    3. 쿼리에 집중할 필요 없이 빠르게 개발이 가능하다.
    4. 재사용 유지 보수 편리성이 증가 한다.

- 단점
    1. 초기 적용에 러닝 커브가 어느 정도 있다.
    2. 프로젝트의 복잡성이 커질경우 난이도가 올라간다.
    3. 잘못 적용할 경우 속도 저하가 발생 할 수 있다.
    4. 복잡한 SQL의 사용하지 못할 수 도 있다.

## JPA(Java Persistence API)

: 자바의 ORM 기술 표준으로 인터페이스의 모음입니다.

- JPA 인터페이스를 구현한 대표적인 오픈소스로 Hibernate가 있습니다.

- JPA의 구현체들
  ![img](https://user-images.githubusercontent.com/73349375/158725866-e1ee9a8b-b175-4cf7-9b0b-1a3d0cb90c9b.png)

- JPA를 왜 사용해야 하는가?
    1. 생산성 향상 - 반복적인 행위를 줄여줌으로.
    2. 유지보수 측면 - 단순히 필드를 추가해주면되고, SQL은 JPA가 해줌.

- 버전별 특징
    - JPA 1.0(JSR 220) 2006년 : 초기 버전. 복합 키와 연관관계 기능이 부족
    - JPA 2.0(JSR 317) 2009년 : 대부분의 ORM 기능을 포함, JPA Criteria 추가
    - JPA 2.1(JSR 338) 2013년 : 스토어드 프로시저 접근, 컨버터(Converter), 엔티티 그래프 기능이 추가

- JPA의 동작과정
  ![img](https://user-images.githubusercontent.com/73349375/158726204-af45d275-addf-4d04-97a1-a576d0502343.png)

## Hibernate

: 자바 언어를 위한 ORM 프레임워크이며, 내부적으로 JDBC API를 사용합니다.

- 장점
    1. 반복적인 작업을 줄일 수 있어 생산성이 높아집니다.  
       Hibernate는 SQL을 직접 사용하지 않고, 메서드 호출만으로 쿼리가 수행됩니다.
    2. 유지보수가 편해집니다.  
       왜냐면, 테이블 컬럼이 변경되었을 때, 테이블과 관련된 DAO의 파라미터, 결과, SQL 등을 대신 수행해줍니다.
    3. JPA는 추상화된 데이터 접근 계층을 제공하기 때문에 특정 벤더에 종속적이지 않습니다.
       설정 파일에서 JPA에게 어떤 데이터베이스를 사용하는지만 알려주면 편하게 DB를 변경할 수 있습니다.

- 단점
    1. 메소드만으로 DB를 조작하는 것은 한계가 있습니다.
       (따라서, JPQL 또는 NativeQuery를 지원합니다. 하지만 이는 또 특정 DB에 종속됨)
    2. 메소드 호출로 쿼리를 실행하는 것은 성능상 좋지 않습니다.

- 프로젝트에서 Hibernate를 택한 이유?
    1. Spring Starter의 Data JPA의존성에는 Hibernate 구현체가 기본적으로 포함되어있어요.
    2. 다른 구현체에 비해 가장 JPA와 호환이 잘된다 생각해요.

## JDBC vs JPA vs Spring JPA vs Spring Data JDBC vs Hibernate

- 참고링크) [링크](https://skyblue300a.tistory.com/7)

---

## 영속성 컨텍스트

: 엔티티를 영구 저장하는 환경

- 애플리케이션과 데이터베이스 사이에 위치
- 엔티티 매니저를 통해 엔티티들을 영속성 컨텍스트에 저장하거나 조회한다.
- 엔티티 매니저가 하나 생성될 때 영속성 컨텍스트가 하나가 생성됩니다.

- 영속성 컨텍스트 특징
    1. 데이터 베이스의 기본키를 사용해 영속성 컨텍스트의 엔티티는 반드시 식별자를 가진다.
        - 조회시 식별자 값으로 구분한다.

- 영속성 컨텍스트 이점
    1. 1차 캐시가 있다. -> DB에 직접 접근하는 횟수 줄어듬.
        - 1차 캐시 조회 과정
            1. 조회 시 처음 1차 캐시에 해당 데이터가 있는지 탐색을 한다. -> 만약 있으면 바로 리턴
            2. 조회 결과 1차 캐시에 데이터가 없으면 데이터베이스에 접근해 값을 탐색한다.
            3. 탐색 결과를 바로 리턴하는 것이 아닌 다음 탐색에서 재사용할 수 있도록 1차 캐시에 저장한다.
        - EntityManager는 트랜잭션 단위이기 때문에 트랜잭션이 끝나면 1차 캐시도 지워버린다.

    2. 영속 엔티티의 동일성을 보장한다.(==)
       : 1차 캐시내에서 값을 가져오기 때문에 동일성이 보장된다.

    3. 쓰기 지연
        - 엔티티들을 1차 캐시에 저장시 '쓰기 지연 SQL 저장소'에 SQL문도 함께 저장
        - 저장하고 있다가, 트랜잭션 커밋시 저장소의 SQL문들을 한번에 실행한다.

    4. 변경 감지
        - JPA로 엔티티를 수정할 때는 단순히 엔티티를 조회해서 데이터를 변경하면 된다.
        - 단, 영속 상태인 엔티티들만 가능하다.
        - 변경감지의 흐름
            1. 트랙잭션을 커밋하면 엔티티 매니저 내부에서 먼저 플러시가 호출된다.
            2. 엔티티와 스냅샷을 비교하여 변경된 엔티티를 찾는다.
            3. 변경된 엔티티가 있으면 수정 쿼리를 생성해서 쓰기 지연 SQL 저장소에 저장한다.
            4. 쓰기 지연 저장소의 SQL을 플러시한다.
            5. 데이터베이스 트랜잭션을 커밋한다.

- flush?  
  : 플러시는 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영한다.
  영속성 컨텍스트의 엔티티를 지우는게 아니라 변경 내용을 데이터베이스에 동기화하는 것이다.


- 영속성 컨택스트 플러쉬하는 방법
    1. 엔티티 매니저의 flush() 메소드를 사용 (직접 호출)
    2. Transaction Commit()이 수행 (자동 호출)
    3. JPQL 쿼리 실행 (자동 호출)

## Entity

: 식별자를 지닌 하나의 데이터 집합으로, 데이터베이스에 의해 관리되어야할 데이터입니다.

- 엔티티 생명주기
    1. 비영속 (new/transient)
        - 엔티티 객체는 생성되었지만 아직 영속성 컨텍스트에 저장되지 않은 상태
        - 영속성 컨텍스트와 전혀 관계가 없는 상태
    2. 영속 (managed)
        - 영속성 컨텍스트에 저장되어 관리받는 상태
        - persist()
    3. 준영속 (detached)
        - 영속성 컨텍스트에 저장되었다가 분리된 상태
        - detach(), clear(), close()
        - 1차 캐시, 쓰기 지연, 변경 감지, 지연 로딩을 포함한 영속성 컨텍스트가 제공하는 어떠한 기능도 동작하지 않는다.
        - 식별자 값을 가지고 있다.
    4. 삭제 (removed)
        - 영속성 컨텍스트와 데이터베이스에서 삭제된 상태
        - remove()
          ![img](https://media.vlpt.us/images/neptunes032/post/ecd3b113-862f-4158-a208-e1eeec92d61d/image.png)

## 즉시/지연 로딩

### 지연 로딩

: 원하는 엔티티는 바로 조회 쿼리문이 나가지만, 연관관계에 있는 엔티티는 프록시 객체로 가져온다.
단, 연관관계에 있는 엔티티를 직접적으로 사용하는 시점에 DB에 쿼리문이 나가게 된다.

- 로딩되는 시점에 Lazy 로딩 설정이 되어있는 Team 엔티티는 프록시 객체로 가져온다.
- 후에 실제 객체를 사용하는 시점에(Team을 사용하는 시점에) 초기화가 된다. DB에 쿼리가 나간다.
- JPQL의 fetch Join을 사용하면 두 번의 쿼리가 날라갈 것을 한 번에 날라가게 할 수 있다.

### 즉시 로딩

: 원하는 엔티티를 조회시 연관관계가 있는 객체까지 모두 DB에서 조회해서 가져온다.

- 프록시 객체가 아닌 진짜 객체를 가져온다.

- 주의사항
    - 즉시 로딩을 사용하면 예상하지 못한 SQL문이 날라갈 수 있기 때문에 지연 로딩을 써야합니다.
    - 즉시 로딩은 JPQL 사용시 N+1문제를 만들 수 있습니다.
    - N+1 문제 : ORM을 사용하면 가장 쉽게 접할 수 있는 문제 중에 하나이다.
      1번 쿼리를 날렸는데 추가로 N번 더 쿼리문을 날려야 하는 상황을 1+N이라고 불린다.

- N+1 문제 해결방법
    1. join fetch를 사용한다.
        - 조회시 바로 가져오고 싶은 Entity 필드를 지정 (join fetch a.subjects)하는 것입니다.
        - 중복되는 데이터가 생겨 DISTINCT 해주어야 한다.
        - leftOuter
    2. @EntityGraph를 사용한다.
        - attributePaths에 쿼리 수행시 바로 가져올 필드명을 지정하면 Lazy가 아닌 Eager 조회로 가져오게 된다.
    3. [참고자료](https://jojoldu.tistory.com/165)

## 프록시

: 실제 엔티티 객체 대신에 데이터베이스 조회를 지연할 수 있는 가짜 객체가 필요한데 이것을 프록시 객체라 한다.

- 프록시 객체의 메소드를 호출하면 프록시 객체는 실제 객체의 메소드를 호출한다.
- 프록시 객체는 처음 사용할 때 한 번만 초기화 된다.
- 프록시 객체를 초기화 할 때, 프록시 객체가 실제로 엔티티로 바뀌는 것은 아니다.
- EntityManager.getReference()

- 프록시 초기화
  : 프록시 객체가 실제 사용될 때 데이터베이스를 조회해서 실제 엔티티 객체를 생성하는 것

    - 과정
        1. 프록시 객체에 member.getName()을 호출해서 실제 데이터를 조회한다.
        2. 프록시 객체는 실제 엔티티가 생성되어 있지 않으면 영속성 컨텍스트 실제 엔티티 생성을 요청한다.
        3. 영속성 컨텍스트는 데이터베이스를 조회해서 실제 엔티티 객체를 생성한다.
        4. 프록시 객체는 생성된 실제 엔티티 객체의 참조를 Member target 멤버변수에 보관한다.
        5. 프록시 객체는 실제 엔티티 객체의 getName()을 호출해서 결과를 반환한다.
           ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FclMuqx%2FbtrpqytaMa5%2FBCvgvyAPJO5g5i458KFQW0%2Fimg.png)

    - 특징
        - 프록시 객체는 처음 사용할 때 한 번만 초기화된다.
        - 프록시 객체는 원본 엔티티를 상속받은 객체이다.
        - 프록시 객체를 초기화한다고 프록시 객체가 실제 엔티티로 바뀌는 것은 아니다.
        - 프록시 객체가 초기화되면 프록시 객체를 통해서 실제 엔티티에 접근할 수 있다.
        - 프록시 객체는 원본 엔티티를 상속받은 객체이므로 타입 체크 시에 주의해야 한다.
        - == 비교 실패, 대신 instance of 사용
        - 영속성 컨텍스트에 찾은 엔티티가 이미 있으면 데이터베이스를 조회할 필요가 없으므로 em.getReference()를 호출해도 실제 엔티티를 반환한다.

## 단뱡향/양방향 매핑

- 연관관계 매핑이란?
  : 객체의 참조와 테이블의 외래 키를 매핑하는 것

- 객체 관계 매핑시 고려해야할 점
    1. 방향 : 참조하는 것이 단방향이냐 양방향이냐?
    2. 다중성 : 다대일(N:1), 일대다(1:N), 일대일(1:1), 다대다(N:M) 이냐?
    3. 연관관계의 주인 : 양방향인 경우 주인을 정해야한다. (보통 N이 주인)

- 객체 연관관계 vs 테이블 연관관계 정리
    1. 객체는 참조(주소)로 연관관계를 맺는다.
    2. 테이블은 외래 키로 연관관계를 맺는다.
    3. 참조를 사용하는 객체의 연관관계는 단방향이다.
    4. 외래 키를 사용하는 테이블의 연관관계는 양방향이다.
       A JOIN B , B JOIN A 둘다 가능하며 결과값도 같다.

- 연관관계 매핑의 필요성
  - 테이블에서는 외래키를 통해 연관관계를 맺을 수 있지만
  - 객체간의 관계를 표현하기 위해서는 외래키로 관계를 형성하면 객체지향적이지 않습니다.
  - 그래서 연관 관계 매핑을 통해 관계를 나타내야합니다.
  
## 영속성 전이(CASCADE)

: 특정 엔티티를 영속 상태로 만들고 싶을 때 연관된 객체들도 모두 영속 상태로 만드는 것을 의미한다.

- When?
    - 특정 엔티티를 영속 상태로 만들때 연관된 엔티티도 함께 영속 상태로 만들고 싶을때 사용합니다.
    - 하나의 부모가 자식들을 관리할 때 사용.
    - 자식의 연관 관계가 2개 이상일 때는 사용하면 안됨.

- 옵션
    1. ALL : 모두 적용
        - REMOVE + PERSIST
    2. PERSIST : 영속
        - 부모 엔티티를 저장할 때 연관된 자식 엔티티도 같이 저장
    3. REMOVE : 삭제
        - 부모 엔티티를 삭제할때 연관되어 있는 자식 엔티티도 같이 삭제하는 옵션
    4. MERGE : 병합
    5. REFRESH : REFRESH
    6. DETACH : DETACH

## 고아객체

- 부모 엔티티와 연관 관계가 끊어진 자식 엔티티
- 자동 삭제 기능 있음. (orphanRemoval = true)

- CASCADE.REMOVE vs orphanRemoval = true
    - CascadeType.REMOVE는 부모 엔티티가 삭제될 때 같이 삭제되는 것이지만, orphanRemoval은 부모와 연관관계가 끊길때 삭제가 된다.

## Transactional

- 스프링에서 제공하는 트랜잭션 처리 중 하나이다.
- 클래스나 메소드에 붙여 사용하게 되면 AOP를 사용해 트랜잭션 처리를 해준다.
- Private method에는 적용이 안됩니다.
    - 인터페이스를 상속받아 프록시 객체를 생성해야 하기 때문에 상속받을 수 없는 private 메소드는 트랜잭션 관리가 되지 않는다.
- 내부의 메소드 호출시 트랜잭션 관리가 되지 않는다.
    - 트랜잭션이 아닌 메소드에서 트랜잭션이 선언된 내부의 메소드를 호출하면 프록시 객체가 아닌 대상 객체의 메소드를 호출하기 때문에 트랜잭션이 적용되지 않는다.

### 트랜잭션 동작 원리

- Spring AOP를 기반으로 동작합니다.
- 프록시 객체를 통해 기능을 수행하고 이상이 없으면 Commit을, 예외가 발생하면 Rollback을 수행합니다.

### @Transactional(readonly = true) 동작원리

- 스프링 프레임워크가 Hibernate 세션 플러쉬 모드를 MANUAL로 설정합니다.
- 강제로 플러시를 하지 않는 이상 플러시가 일어나지 않습니다.
- 따라서 커밋을 하게 되더라도 엔티티의 수정, 삭제 등이 일어나지 않습니다.
- 영속성 컨텍스트는 변경 감지를 위한 스냅샷 저장도 일어나지 않아 성능이 향상됩니다.

### Transaction 격리 수준

: 특정 트랜잭션이 다른 트랜잭션에 의해 변경된 데이터를 볼 수 있도록 허용할지 말지를 결정하는 것, 트랜잭션들끼리 얼마나 고립되어있는지 (잠금수준)를 나타내는 것
: 트랜잭션 수준 읽기 일관성 (Transaction-Level Read Consistency)을 지키기 위해서 격리 수준이 필요합니다.(즉, 동시성 제어를 위함)
- READ UNCOMMITTED (Level 0)
  - 트랜잭션에서 처리 중인, 아직 커밋되지 않은 데이터를 다른 트랜잭션이 읽는 것을 허용한다.
  - Dirty Read, Non-Repeatable Read, Phantom Read 현상이 발생
  - 정합성 문제가 많아 RDBMS 표준에서는 격리수준으로 인정하지 않는다.
- READ COMMITTED (Level 1)
  - RDB에서 대부분 기본적으로 사용되고 있는 격리 수준
  - 실제 테이블 값을 가져오는 것이 아니라 Undo 영역에 백업된 레코드에서 값을 가져온다.
  - Dirty Read 가 발생하지 않는다.
  - 하지만, Non-Repeatable Read, Phantom Read 현상은 여전히 발생
- REPEATABLE READ (Level 2)
  - 트랜잭션이 시작되기 전에 COMMIT된 내용에 대해서만 조회할 수 있는 격리수준
  - MySQL에서는 트랜잭션마다 트랜잭션 ID를 부여하여 트랜잭션 ID보다 작은 트랜잭션 번호에서 변경한 것만 읽게 된다.
  - Dirty Read와 같은 현상은 발생하지 않지만 Phantom Read 현상은 여전히 발생
- SERIALIZABLE (Level 3)
  - 선행 트랜잭션이 특정 테이블을 읽는 경우(SELECT) 공유 잠금(shared lock) 을 걸어, 다른 트랜잭션에서 해당 테이블의 데이터를 UPDATE, DELETE, INSERT 작업을 못하도록 막는다.
  - 동시 처리 능력이 다른 격리수준보다 떨어지고 성능저하가 발생하여 데이터베이스에서 거의 사용되지 않는다.
[참고링크](https://velog.io/@guswns3371/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B2%A9%EB%A6%AC%EC%88%98%EC%A4%80#read-uncommitted-%ED%8A%B8%EB%A0%8C%EC%A0%9D%EC%85%98-%EB%A0%88%EB%B2%A8-0)

### Transactioinal 전파
- propagation을 통해 설정할 수 있습니다.
- 종류
  - REQUIRED(기본값) : 부모 트랜잭션이 존재한다면 부모 트랜잭션으로 합류합니다. 부모 트랜잭션이 없다면 새로운 트랜잭션을 생성합니다.
    - 중간에 롤백이 발생한다면 모두 하나의 트랜잭션이기 때문에 진행사항이 모두 롤백됩니다.
  - REQUIRES_NEW : 무조건 새로운 트랜잭션을 생성합니다.
    - 각각의 트랜잭션이 롤백되더라도 서로 영향을 주지 않습니다.
  - MANDATORY : 부모 트랜잭션에 합류합니다.
    - 만약 부모 트랜잭션이 없다면 예외를 발생시킵니다.
  - NESTED : 부모 트랜잭션이 존재한다면 중첩 트랜잭션을 생성합니다.
    - 중첩된 트랜잭션 내부에서 롤백 발생시 해당 중첩 트랜잭션의 시작 지점 까지만 롤백됩니다.
    - 중첩 트랜잭션은 부모 트랜잭션이 커밋될 때 같이 커밋됩니다. 
    - 부모 트랜잭션이 존재하지 않는다면 새로운 트랜잭션을 생성합니다.

### OSIV
- 영속성 컨텍스트를 뷰까지 열어두는 기능
- default는 true이다.

## 예상질문

1. 객체들이 연관관계를 맺는다는 것이 어떤 의미인가요?
2. 영속성 전이가 무엇인가요?
3. 영속성 전이의 옵션에는 어떤 것이 있나요?
4. 고아 객체가 무엇인가요?
5. @Transactional이 어떻게 동작하나요?
6. 언제 @Transactional을 사용하나요?
7. 트랜잭션 전파에는 어떤 것이 있나요?
8. Spring에서의 트랜잭션 격리는 어떻게 적용하나요?
9. OSIV가 무엇인가요?
