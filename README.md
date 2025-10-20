# JPA 프로젝트 학습 기록

로컬 환경 구성
MySQL 설치
직접 설치
다음 사이트에서 환경에 맞는 설치 파일 받아서 설치

https://dev.mysql.com/downloads/
도커 이용 설치
컨테이너 생성:

docker create --name mysql8 -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 mysql:8.0.27
MYSQL_ROOT_PASSWORD 환경변수는 DB root 사용자 암호를 지정하는데 위 명령어는 root 암호로 root를 사용

컨테이너 시작:

docker start mysql8
데이터베이스와 계정 생성
root 사용자로 MySQL에 접속한 뒤에 jpabegin DB와 jpauser 사용자 생성

create database jpabegin CHARACTER SET utf8mb4;

CREATE USER 'jpauser'@'localhost' IDENTIFIED BY 'jpapass';
CREATE USER 'jpauser'@'%' IDENTIFIED BY 'jpapass';

GRANT ALL PRIVILEGES ON jpabegin.* TO 'jpauser'@'localhost';
GRANT ALL PRIVILEGES ON jpabegin.* TO 'jpauser'@'%';


## Day1 JPA 기본설정
- [persistence.xml과 application.properties 차이](https://www.notion.so/JPA-28eb45b7ffa2802c9ce7d0d28017184f?p=abc123def456)
