# JPA 프로젝트 학습 기록

## 로컬 환경 구성
1. MySQL 설치

- 직접 설치
다음 사이트에서 환경에 맞는 설치 파일을 받아서 설치하세요:  
[MySQL 다운로드](https://dev.mysql.com/downloads/)

- 도커 이용 설치
  
컨테이너 생성:
```bash
docker create --name mysql8 -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 mysql:8.0.27
```
MYSQL_ROOT_PASSWORD 환경변수는 DB root 사용자의 암호를 지정합니다.
위 명령어는 root 암호를 root로 설정합니다.
<br>
컨테이너 시작:
```bash
docker start mysql8
```
2. 데이터베이스와 계정 생성
- root 사용자로 MySQL에 접속한 뒤, jpabegin 데이터베이스와 jpauser 계정을 생성합니다:

```sql
create database jpabegin CHARACTER SET utf8mb4;

CREATE USER 'jpauser'@'localhost' IDENTIFIED BY 'jpapass';
CREATE USER 'jpauser'@'%' IDENTIFIED BY 'jpapass';

GRANT ALL PRIVILEGES ON jpabegin.* TO 'jpauser'@'localhost';
GRANT ALL PRIVILEGES ON jpabegin.* TO 'jpauser'@'%';
```
---
## ch1 JPA 기본설정
- [persistence.xml과 application.properties 차이](https://www.notion.so/JPA-28eb45b7ffa2802c9ce7d0d28017184f?p=abc123def456)
  
## ch2 JPA 실행시점
- [저장과 수정 시점](https://www.notion.so/JPA-292b45b7ffa2808e870dd4ca62531972)
- [영속 컨텍스트란](https://www.notion.so/292b45b7ffa280e8b429c363899cc315)

## ch3 엔티티 메서드 정리
- [엔티티 메서드 정리](https://www.notion.so/292b45b7ffa280a18d61f8f2c9db4cef)

## ch4 엔티티 매핑 설정
- [엔티티 매핑 설정](https://www.notion.so/292b45b7ffa280f68b06dd0801a158f2)

## ch5 엔티티 식별자 생성 방식
- [엔티티 식별자 생성 방식](https://www.notion.so/292b45b7ffa280cfb2e7faad7aa5dc6d#292b45b7ffa28029bf7cf2e780f6cd5d)

## ch6 Embeddable에 대하여 1
- [Embeddable에 대하여 1](https://www.notion.so/Embeddable-1-293b45b7ffa2800a9c18eb25167c48f6)

## ch7 Embeddable에 대하여 2
- [Embeddable에 대하여 2](https://www.notion.so/Embeddable-2-295b45b7ffa28067bb44c93476783cfc#298b45b7ffa28062ac9bcc0c3780461a)

## ch8 값 컬렉션 Set 매핑
- [값 컬렉션 Set 매핑](https://www.notion.so/Set-299b45b7ffa280019c07e986af538432?pvs=97#299b45b7ffa28091b7efd7c66a91ad7a)

## ch9 단순 값 List 매핑
- [단순 값 List 매핑](https://www.notion.so/List-299b45b7ffa280a28a11c70e560558e2#299b45b7ffa280058d3edf1c27a7c21f)

## ch10 단순 값 Map 매핑
- [단순 값 Map 매핑](https://www.notion.so/Map-299b45b7ffa280adb18bdeb57c253aee#299b45b7ffa28062b4b7c407ea16c584)

## ch11 값 컬렉션 주의사항
- [값 컬렉션 주의사항](https://www.notion.so/299b45b7ffa2803e82c2df812291e973#299b45b7ffa2806f9203d11173a22ae2)

## ch12 영속 컨텍스트와 라이프 사이클
- [영속 컨텍스트와 라이프 사이클](https://www.notion.so/29ab45b7ffa280598f5cf8b99a745f18#29ab45b7ffa2809ba1e3c332dad1aab6)