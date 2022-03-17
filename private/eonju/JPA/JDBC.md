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
    4.

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
