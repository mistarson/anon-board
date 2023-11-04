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
수정의 경우 PATCH 메서드를 사용하여 Requestbody를 통해 json으로 통신하였습니다. 삭제의 경우 DELETE 메서드를 사용하여 Requestbody 통하여 password를 전달하려 하였지만 DELETE 메서드는 body 사용을 지양하라는 글을 읽고 Password Http Header를 통해 통신하도록 하였다. 이에 따라 수정 API 또한, Password 헤더를 통해 통신하도록 하였다.

### 2. RESTful한 API를 설계하셨나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
API 명세서를 작성할 때, 기능별로 자원과 행위를 분리하도록 노력하였다. 처음에는 전체 목록 조회일 때만 boards라는 복수를 사용하였는데

### 3. 적절한 관심사 분리를 적용하셨나요? (Controller, Service, Repository)

### 4. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
