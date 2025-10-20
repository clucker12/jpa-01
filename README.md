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
## Day1 JPA 기본설정
- [persistence.xml과 application.properties 차이](https://www.notion.so/JPA-28eb45b7ffa2802c9ce7d0d28017184f?p=abc123def456)
---
## Day2 JPA 실행시점
- [저장과 수정 시점]([https://www.notion.so/JPA-28eb45b7ffa2802c9ce7d0d28017184f?p=abc123def456](https://www.notion.so/JPA-292b45b7ffa2808e870dd4ca62531972)
- [영속 컨텍스트란]([[https://www.notion.so/JPA-28eb45b7ffa2802c9ce7d0d28017184f?p=abc123def456](https://www.notion.so/JPA-292b45b7ffa2808e870dd4ca62531972)](https://www.notion.so/292b45b7ffa280e8b429c363899cc315)
