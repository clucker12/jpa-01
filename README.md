# JPA 프로젝트 학습 기록

## 목차
- [persistence.xml과 application.properties 차이](#persistencexml과-applicationproperties-차이)
- [프로젝트 구조 및 위치 설명](#프로젝트-구조-및-위치-설명)
- [요약 및 결론](#요약-및-결론)

---

## persistence.xml과 application.properties 차이

| 구분 | `persistence.xml` | `application.properties` |
| --- | --- | --- |
| 사용 환경 | **순수 JPA** 또는 **Hibernate 직접 사용 시** | **Spring Boot + Spring Data JPA 사용 시** |
| 역할 | 영속성 단위(`persistence-unit`) 정의 및 DB 설정 | Spring Boot가 자동으로 JPA 설정을 구성 |
| 파일 위치 | `src/main/resources/META-INF/persistence.xml` | `src/main/resources/application.properties` |
| 초기화 주체 | `Persistence.createEntityManagerFactory("단위이름")` | Spring Boot가 자동으로 EntityManagerFactory 생성 |
| 작성 필요 여부 | ✅ (직접 작성해야 함) | ❌ (Spring Boot가 자동 설정) |

---

## 쉽게 말하면

| 상황 | 설정 파일 |
| --- | --- |
| 💡 **직접 EntityManager를 생성하는 순수 JPA 프로젝트** | → `persistence.xml` 필요 |
| ⚙️ **Spring Boot + JPA 사용 (일반적인 경우)** | → `application.properties`만 필요 |

---

## 두 설정을 비교해보기

| 설정 항목 | `persistence.xml` | `application.properties` |
| --- | --- | --- |
| JDBC URL | `<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost/jpabegin?characterEncoding=utf8"/>` | `spring.datasource.url=jdbc:mysql://localhost:3306/jpabegin?serverTimezone=UTC&useSSL=false` |
| 사용자명 | `<property name="jakarta.persistence.jdbc.user" value="jpauser"/>` | `spring.datasource.username=root` |
| 비밀번호 | `<property name="jakarta.persistence.jdbc.password" value="jpapass"/>` | `spring.datasource.password=your_password` |
| Hibernate Dialect | `<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>` | `spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect` |
| DDL 자동 생성 | 없음 (직접 지정해야 함) | `spring.jpa.hibernate.ddl-auto=update` |
| SQL 로그 출력 | 없음 (직접 지정) | `spring.jpa.show-sql=true` |

---

## 결론 정리

✅ **Spring Boot 프로젝트라면 → `persistence.xml` 필요 없음**  
Spring Boot가 `application.properties` 내용을 읽고 내부적으로  
`EntityManagerFactory`와 `DataSource`를 자동으로 구성합니다.

✅ **순수 JPA 프로젝트라면 → `persistence.xml` 필수**  
Spring Boot가 없기 때문에, JPA 표준 방식으로 직접 연결 정보를 정의해야 합니다.

---

## 프로젝트 구조 및 위치 설명

📁 src  
└─ 📁 main  
　├─ 📁 java  
　│　└─ jpabasic/reserve/domain/User.java  
　└─ 📁 resources  
　　　└─ 📁 META-INF ← 여기에 persistence.xml 생성!  
　　　　　└─ 📄 persistence.xml

JPA는 내부적으로  
`classpath`의 `META-INF/persistence.xml` 파일을 자동으로 찾습니다.

즉,

- `resources/META-INF/` 폴더 아래에 있어야  
- 빌드 후 `target/classes/META-INF/persistence.xml` 경로로 복사되어  
- JPA가 클래스패스에서 인식할 수 있게 됩니다.

---

## 요약 및 결론

| 항목 | Spring Boot + JPA | 순수 JPA 학습용 (지금 설정) |
| --- | --- | --- |
| 설정 파일 | `application.properties` | `META-INF/persistence.xml` |
| DB 연결 방식 | Spring Boot 자동 설정 | JPA 표준 `Persistence` API 직접 호출 |
| EntityManager 관리 | Spring이 자동 관리 | 직접 `EntityManagerFactory` 생성 |
| 목적 | 실무용 (자동화 중심) | 학습용 (JPA 내부 구조 이해 중심) |

---
