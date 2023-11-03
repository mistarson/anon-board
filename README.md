# 📋익명게시판

## Use Case Diagram
![image](https://github.com/mistarson/anon-board/assets/40788498/f47b5737-c642-41df-b42b-b5ba7284fb57)

<br>
<br>

## API 명세서
|기능|Method|URL|Reqeust|Response|
|:---|:---|:---|:---|:---|
|게시글 작성|POST|/api/board|{ "title":title, "writer":writer, "password":password, "content":content }|{ "id":id, "title":title, "writer":writer, "content":content }|
|게시글 조회|GET|/api/board/{boardId}||{ "title":title, "writer":writer, "content":content }|
|게시글 전체 목록 조회|GET|/api/boards|||
|게시글 수정|PATCH|/api/board/{boardId}|{ "title":title, "password":password, "content":content }|{ "id":id, "title":title, "writer":writer, "content":content }|
|게시글 삭제|DELETE|/api/board/{boardId}|{ "password":password }||

<br>
<br>

## 기능 요구 사항
- [ ] 게시글 등록을 위해 게시글 정보를 보내오면 게시글을 등록해야 한다.
- [ ] 게시글 등록 후, 게시글에 대한 정보를 응답으로 보내준다. (비밀번호는 제외)
- [ ] Id를 이용하여 게시글 조회 요청하면, 게시글에 대한 정보를 응답으로 보내준다. (비밀번호는 제외)
- [ ] 존재하지 않는 게시글 조회 요청하면, "없는 게시글입니다."라는 에러문구 응답을 보내준다.
- [ ] 게시글 전체 목록 조회시, 게시글의 전체 목록을 보여준다. (작성일 기준 내림차순)
- [ ] Id와 게시글 수정 정보를 요청하면 게시글에 대한 수정을 진행한다.
- [ ] 게시글 수정 정보에서 보내온 password가 일치할 때만 게시글 수정이 가능하고 불일치하다면 "비밀번호가 일치하지 않습니다."라는 에러문구 응답을 보내준다.
- [ ] Id를 이용하여 게시글 삭제를 요청하면 해당 Id를 가진 게시글을 삭제한다.
- [ ] 게시글 삭제 정보에서 보내온 password가 일치할 때만 게시글 삭제가 가능하고 불일치하다면 "비밀번호가 일치하지 않습니다."라는 에러문구 응답을 보내준다.
