# 📘 JPA Practice

> JPA 기본 개념을 실습하며 학습한 결과물입니다.

## 📚 목차

- [01. Entity 저장 - persist & commit](#01-entity-저장---persist--commit)
- [02. Entity 조회 - find와 1차 캐시](#02-entity-조회---find와-1차-캐시)
- [03. 변경 감지 - Dirty Checking](#03-변경-감지---dirty-checking)
- [04. 중복 저장 오류 - 제약 조건 위반](#04-중복-저장-오류---제약-조건-위반)
- [05. 엔티티 생명주기](#05-엔티티-생명주기)
- [📝 느낀 점 / 회고](#-느낀-점--회고)

---

## 01. Entity 저장 - persist & commit

```java
User user = new User("user@user.com", "user", LocalDateTime.now());
entityManager.persist(user); // 아직 DB에 INSERT 안 됨
transaction.commit();        // 이 시점에 INSERT 실행
```
- persist()는 영속성 컨텍스트에 등록만 함
- commit() 시점에 DB에 실제 반영됨 (INSERT 쿼리 실행)
