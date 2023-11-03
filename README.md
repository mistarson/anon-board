# 📋익명게시판

## Use Case Diagram
![image](https://github.com/mistarson/anon-board/assets/40788498/f47b5737-c642-41df-b42b-b5ba7284fb57)

## API 명세서
|기능|Method|URL|Reqeust|Response|
|:---|:---|:---|:---|:---|
|게시글 작성|POST|/api/board|{ "title":title, "writer":writer, "password":password, "content":content }||
|게시글 조회|GET|/api/board/{boardId}|{ "title":title, "writer":writer, "content":content }||
|게시글 전체 목록 조회|GET|/api/boards|||
|게시글 수정|PATCH|/api/board/{boardId}|{ "title":title, "password":password, "content":content }||
|게시글 삭제|DELETE|/api/board/{boardId}|||
