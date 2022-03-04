# cs-study-for-interview

### :triangular_flag_on_post: About
- 개발자가 알아야할 필수 CS에 대해 공부하고 기록하는 스터디 저장소입니다.

### :clipboard: How to
- 스터디는 주 5일 진행하며, 공휴일은 진행하지 않습니다
- 공부할 큰 주제를 선정하고 기간을 설정하여 스터디를 진행합니다.
  - ex: 운영체제 - 1달
- 각자 공부한 내용을 기록할 폴더를 만들고 그곳에 공부한 내용을 기록하고 PR을 등록합니다.
- 발표자 1인을 선정하여 본인이 공부한 내용에 대해 설명하듯 발표를 진행하고, 질답 시간을 가집니다.

### :warning: Panelty
- 불참 시 벌금 2000원이 부과되며 예외는 없습니다
- 벌금 미납 및 한 달 누적 불참 3회 이상 시 강제 퇴장하겠습니다.
- 매달 말일에 벌금의 1/N을 송금합니다.
- 중도 하차 시 벌금을 돌려 받을 수 없습니다.
  - 중도 하차 해도 괜찮으니 편하게 말씀해주세요
- 카카오 뱅크 모임 관리 계좌로 투명하게 관리합니다.  

## :pushpin: 운영체제
- 운영체제 소개
  - 운영체제 필요성
  - 운영체제 정의
  - 운영체제 역할
- 운영체제 구조
  - 커널
  - 시스템 호출
- 프로세스
  - 프로세스 개념
  - 프로세스 상태
  - 프로세스 제어 블록
  - 프로세스 문맥 교환
- 스레드
  - 스레드 개념
  - 멀티스레드의 구조
  - 멀티스레드의 장단점
  - 멀티 프로세스 VS 멀티 스레드
- CPU 스케줄링
  - 장기 스케줄링
  - 중기 스케줄링
  - 단기 스케줄링
- 스케줄링 알고리즘
  - FCFS
  - SJF
  - Round Robin
  - SRT
  - Priority scheduling
  - Multilevel Queue
  - Multilevel Feedback Queue
- 인터럽트
  - 인터럽트 개념
  - 동기적 인터럽트, 비동기적 인터럽트
  - 인터럽트 처리 과정
  - 인터럽트와 이중 모드
- 프로세스 동기화
  - 공유자원, 경쟁상태, 임계구역
  - 피터슨 알고리즘
  - 뮤텍스
  - 세마포어
  - 모니터
- 교착 상태(Deadlock)
  - 교착 상태 정의
  - 교착 상태 조건
  - 교착 상태 해결 방법
  - 식사하는 철학자 문제
- 메모리 관리
  - 메모리 관리 필요성
  - 고정 분할 방식
  - 가변 분할 방식
- 가상 메모리 개요
  - 가상 메모리 정의
  - 가상 메모리 필요성
  - 페이징 기법
  - 세그먼테이션 기법
- 가상 메모리 관리
  - 요구 페이징
  - 페이지 교체 알고리즘
    - FIFO
    - OPT
    - LRU

## :pushpin: 네트워크
- OSI 7계층과 TCP/IP 4계층(1)
- TCP/UDP(2)
  - 3way-handshake, 4way-handshake
  - 흐름제어, 혼잡제어, 오류제어
- IPv4 VS IPv6(3)
- HTTP(4)
  - HTTP status code
  - HTTP METHOD
- HTTP 1.1 VS HTTP 2.0(5)
- HTTPS(5)
- REST API(6)
- Web Server VS WAS(7)
- CORS(7)
- COOKIE & SESSION(8)
- JWT(8)
- 로드밸런서(9)
- DNS(9)
- Blocking/Nonblocking&Synchronous/Asynchronous(9)
- 웹 통신의 흐름(10)
  - www.example.com을 입력했을 때?

## :pushpin: 데이터베이스
- 관계형 데이터베이스(1)
  - 데이터베이스를 사용하는 이유
  - 관계형 데이터베이스의 개념과 장단점
  - DML, DDL, DCL
  - Key
- Join(1)
- Sharding&Master/Slave(2)
- 이상 현상과 정규화(2)
- 트랜잭션(3)
  - 트랜잭션 개념
  - ACID
  - LOCK
- 트랜잭션 격리수준(3)
- 교착상태(3)
- 인덱스(4)
  - 인덱스 개념
  - Clustered index, Non-Clustered index
  - 인덱스 자료구조
- NoSQL(5)
  - NoSQL의 개념
  - RDB VS NoSQL
  - Redis


## :pushpin: 자료구조/알고리즘
- 선형 자료구조 (1)
  - Array
  - List
  - HashTable
  - Queue
  - Stack
- 비선형 자료구조(2)
  - Graph
  - Tree
    - Binary Tree
    - Full Binary Tree
    - Complete Binary Tree
    - Binary Search Tree  
  - Heap
  - Trie
  - AVL Tree
  - Red-Black Tree    
- 정렬 알고리즘(3)
  - 선택 정렬, 거품 정렬, 삽입 정렬
  - 병합 정렬, 퀵 정렬, 힙 정렬 
- 이분 탐색(4)
- 동적계획법(4)
- 최단 경로(4)
- 최소 비용(MST)(4)


## :pushpin: Java

- 객체지향
   - **--- 1일차 ---**
   - 4가지 특징
   - 5원칙 (SOLID)
   - 객체지향 vs 절차지향 vs 함수형 프로그래밍
- JDK, JRE, JVM
   - **--- 2일차 ---**
   - 컴파일 과정
   - 컴파일 언어 vs 인터프리터 언어
   - JVM 메모리 구조
   - Garbage Collector 동작과정
   - Java8의 큰 특징 + Java11과의 차이점
- Java 기초
   - **--- 3일차 ---**
   - 접근제어자
   - 클래스, 객체, 인스턴스 차이
   - Overloading vs Overriding
   - **--- 4일차 ---**
   - Primitive type vs Reference type
      - Call by Reference vs Call by Value
      - Wrapper Class
   - interface vs abstract class 
   - Checked Exception vs UnChecked Exception
   - **--- 5일차 ---**
   - static
   - final
   - generic
   - stream, lambda
   - Reflection & Dynamic Proxy
 - Java 컬렉션
   - **--- 6일차 ---**
   - hashcode() & equals()
   - Thread Safe & Syncronized
   - String
      - String vs StringBuffer vs StringBuilder 
      - Immutable Object
      - `String a = ""` vs `String a = new String("")`
   - **--- 7일차 ---**
   - List
      - ArrayList vs LinkedList
   - Map
      - HashTable vs HashMap vs LinkedHashMap vs TreeMap
      - HashMap vs ConcurrentHashMap

## :pushpin: Design Pattern

- 생성패턴
   - **--- 1일차 ---**
   - 팩토리 메소드
   - 싱글톤
- 구조패턴
   - 데코레이터
   - 프록시
   - **--- 2일차 ---**
   - 어댑터
- 행위패턴
   - 옵저버
   - 템플릿 메소드

