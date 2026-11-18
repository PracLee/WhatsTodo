# WhatsTodo

Spring MVC 기반의 할 일 관리 웹 애플리케이션입니다. 사용자별 할 일과 마감일을 관리하고, 완료한 할 일을 따로 조회하며 인기 할 일 목록을 제공합니다.

## 주요 기능

- 회원 가입, 로그인·로그아웃 및 아이디 중복 확인
- 회원 정보 수정 및 탈퇴
- 할 일 등록·수정·삭제
- 마감일 순 개인 할 일 조회
- 할 일 완료 처리 및 완료 목록 조회
- 인기 할 일 목록 제공
- Google 가입·로그인용 컨트롤러 경로 포함

Google 연동은 별도 외부 설정과 동작 확인이 필요합니다.

## 기술 스택

| 구분 | 기술 |
| --- | --- |
| 언어 | Java, JavaScript |
| 서버 | Spring MVC 4.2.4.RELEASE |
| 데이터 접근 | Spring JDBC, JdbcTemplate, Commons DBCP |
| 데이터베이스 | Oracle, ojdbc6 |
| 화면 | JSP, JSTL, Bootstrap 기반 정적 리소스 |
| 빌드·배포 | Maven, WAR |

## 프로젝트 구조

실제 Maven 프로젝트는 저장소 안의 `WhatsTodo/` 폴더입니다.

```text
WhatsTodo/
├── pom.xml
├── Test.sql
└── src/main/
    ├── java/
    │   ├── controller/client/
    │   ├── controller/todo/
    │   └── model/
    ├── resources/applicationContext.xml
    └── webapp/
        ├── login.jsp
        └── WEB-INF/web.xml
```

요청은 컨트롤러를 거쳐 서비스와 DAO에서 처리하며, JSP로 결과를 표시합니다. 로그인 사용자 정보는 세션에서 관리합니다.

## 실행 방법

1. 저장소를 내려받고 프로젝트 폴더로 이동합니다.

   ```bash
   git clone https://github.com/PracLee/WhatsTodo.git
   cd WhatsTodo/WhatsTodo
   ```

2. JDK 8, Maven, Oracle 및 `javax.servlet`을 지원하는 Tomcat 환경을 준비합니다.
3. `pom.xml`의 `jdk.tools` 의존성이 참조하는 Windows 전용 `tools.jar` 경로를 로컬 JDK에 맞게 수정하거나 해당 의존성의 필요 여부를 검토합니다. 컴파일 설정도 `source/target 1.6`으로 되어 있으므로 사용할 JDK에 맞게 조정합니다.
4. `Test.sql`을 검토하여 개발용 Oracle 데이터베이스에 필요한 스키마를 준비합니다.
5. `src/main/resources/applicationContext.xml`의 DataSource URL, 사용자명, 비밀번호를 환경에 맞게 수정합니다. 현재 연결 대상은 `localhost:1521:xe`입니다.
6. WAR 파일을 생성하고 Tomcat에 배포합니다.

   ```bash
   mvn clean package
   ```

7. `http://localhost:8080/<배포 컨텍스트>/goLogin.do`로 접속합니다. 실제 컨텍스트는 서버 배포 설정에 따라 달라집니다.

## 주요 요청 경로

| 경로 | 기능 |
| --- | --- |
| `/goLogin.do`, `/login.do`, `/logout.do` | 로그인 화면 및 세션 처리 |
| `/insertClient.do`, `/idCheck.do` | 가입 및 아이디 중복 확인 |
| `/updateClient.do`, `/deleteClient.do` | 회원 정보 수정·탈퇴 |
| `/main.do` | 개인 할 일 및 인기 목록 |
| `/insertTodo.do`, `/updateTodo.do`, `/deleteTodo.do` | 할 일 관리 |
| `/achieveTodo.do`, `/showComplete.do` | 완료 처리 및 완료 목록 |
| `/googleRegister.do`, `/googleLogin.do` | Google 연동 경로 |

## 실행 시 참고

- 개인 할 일 화면은 로그인 세션을 사용하므로 로그인 후 접근합니다.
- DB 접속 설정과 JDK 경로는 기존 개발 환경에 맞춰져 있어 실행 전 수정이 필요합니다.
- 프로젝트는 Spring Boot 내장 서버 방식이 아닌 외부 서블릿 컨테이너에 WAR를 배포하는 구조입니다.
