package sparta.anonboard.api.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.anonboard.api.board.dto.BoardResponseDto;
import sparta.anonboard.api.board.dto.ModifyBoardRequestDto;
import sparta.anonboard.api.board.dto.PostBoardRequestDto;
import sparta.anonboard.api.board.service.ApiBoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiBoardController {

    private final ApiBoardService apiBoardService;

    @PostMapping("/board")
    public ResponseEntity<BoardResponseDto> postBoard(@Valid @RequestBody PostBoardRequestDto postBoardRequestDto) {

        BoardResponseDto boardResponseDto = apiBoardService.postBoard(postBoardRequestDto);

        return ResponseEntity.ok(boardResponseDto);
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<BoardResponseDto> inquireBoard(@PathVariable Long boardId) {

        BoardResponseDto boardResponseDto = apiBoardService.inquireBoard(boardId);

        return ResponseEntity.ok(boardResponseDto);
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardResponseDto>> inquireAllBoards() {

        List<BoardResponseDto> boards = apiBoardService.inquireAllBoard();

        return ResponseEntity.ok(boards);
    }

    @PatchMapping("/board")
    public ResponseEntity<BoardResponseDto> modifyBoard(
            @Valid @RequestBody ModifyBoardRequestDto modifyBoardRequestDto,
            HttpServletRequest request) {

        String password = request.getHeader("Password");

        BoardResponseDto modifiedBoardDto = apiBoardService.modifyBoard(modifyBoardRequestDto, password);

        return ResponseEntity.ok(modifiedBoardDto);
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long boardId, HttpServletRequest request) {

        String password = request.getHeader("Password");

        apiBoardService.deleteBoard(boardId, password);

        return ResponseEntity.ok(password);
    }

}