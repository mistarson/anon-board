# 📋익명게시판

## Use Case Diagram
![image](https://github.com/mistarson/anon-board/assets/40788498/f47b5737-c642-41df-b42b-b5ba7284fb57)

<br>
<br>

## API 명세서
|기능|Method|URL|Header|Reqeust|Response|
|:---|:---|:---|:---|:---|:---|
|게시글 작성|POST|/api/boards||{ "title":title, "writer":writer, "password":password, "content":content }|{ "id":id, "title":title, "writer":writer, "content":content }|
|게시글 조회|GET|/api/boards/{boardId}||{ "id":id, "title":title, "writer":writer, "content":content }|
|게시글 전체 목록 조회|GET|/api/boards||[{ "id":id, "title":title, "writer":writer, "content":content }, { "id":id, "title":title, "writer":writer, "content":content }]|
|게시글 수정|PATCH|/api/boards|Password:"password"|{ "title":title, "content":content }|{ "id":id, "title":title, "writer":writer, "content":content }|
|게시글 삭제|DELETE|/api/boards/{boardId}|Password:"password"|||

<br>
<br>

## ERD
![image](https://github.com/mistarson/anon-board/assets/40788498/17a4dd4a-6765-48fa-94f6-e4a3545bba8c)

<br>
<br>

## 기능 요구 사항
- [x] 게시글 등록을 위해 게시글 정보를 보내오면 게시글을 등록해야 한다.
- [x] 게시글 정보(제목, 작성자명, 비밀번호, 작성 내용)중 null, "", " "이 존재하면 에러문구 응답을 보내준다.
- [x] 게시글 등록 후, 게시글에 대한 정보를 응답으로 보내준다. (비밀번호는 제외)
- [x] Id를 이용하여 게시글 조회 요청하면, 게시글에 대한 정보를 응답으로 보내준다. (비밀번호는 제외)
- [x] 존재하지 않는 게시글 조회 요청하면, "없는 게시글입니다."라는 에러문구 응답을 보내준다.
- [x] 게시글 전체 목록 조회시, 게시글의 전체 목록을 보여준다. (작성일 기준 내림차순)
- [x] Id와 게시글 수정 정보를 요청하면 게시글에 대한 수정을 진행한다.
- [x] 게시글 수정 정보에서 보내온 password가 일치할 때만 게시글 수정이 가능하고 불일치하다면 "비밀번호가 일치하지 않습니다."라는 에러문구 응답을 보내준다.
- [x] Id를 이용하여 게시글 삭제를 요청하면 해당 Id를 가진 게시글을 삭제한다.
- [x] 게시글 삭제 정보에서 보내온 password가 일치할 때만 게시글 삭제가 가능하고 불일치하다면 "비밀번호가 일치하지 않습니다."라는 에러문구 응답을 보내준다.

## 질문 & 답변
### 1. 수정, 삭제 API의 request를 어떤 방식으로 사용 하셨나요? (param, query, body)
수정은 body를 사용하였고, 삭제는 query를 사용하였습니다.
수정의 경우 PATCH 메서드를 사용하여 Requestbody를 통해 json으로 통신하였습니다. 삭제의 경우 DELETE 메서드를 사용하여 Requestbody 통하여 password를 전달하려 하였지만 DELETE 메서드는 body 사용을 지양하라는 글을 읽고 다른 방법을 찾았다. param과 query는 url 상에 노출이 된다. Header도 노출이 되지 않는건 아니지만 전의 두 방법보다 안전하다고 생각하여 Password라는 이름의 Http Header를 통해 통신하도록 하였다. 이에 따라 수정 API 또한, Password 헤더를 통해 통신하도록 하였다.

### 2. RESTful한 API를 설계하셨나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
API 명세서를 작성할 때, 기능별로 자원과 행위를 분리하도록 노력하였다. url을 구성할 때, 처음에는 조회, 수정, 삭제는 특정한 board 취급하기 때문에 단수인 board를 사용하였고, 전체 목록 조회일 때만 boards라는 복수를 사용하였다. 하지만 몇몇 글을 찾아봤을 때, 단수든 복수든 사용하는 것은 상관없지만 둘을 혼용해서 사용하는 것은 지양해야 한다고 말한다. 그래서 모두 복수형으로 변경하였다.

### 3. 적절한 관심사 분리를 적용하셨나요? (Controller, Service, Repository)
하나의 Controller, Service, Repository로 구성하게 되면 도메인 로직이 dto에 종속성을 가지게 된다. 그래서 도메인 레이어(Controller, Service, Repository)와 API 레이어(Controller, Service, Repository)로 구성하였다.
추후에 성격이 다른 게시글을 작성하는 API들을 구현한다면 또다른 DTO 계속해서 만들어야 할 것이고 도메인 Service에 해당 DTO를 위한 메서드를 새로 만들어야해서 유지보수하기 힘들어 지기 때문에 도메인 레이어와 api 레이어로 나누어 관심사를 분리하였다.

### 4. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
응답에 대한 데이터를 성공과 실패로 나뉘어 표현하지 못하였다.

