package sparta.anonboard.api.board.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.anonboard.api.board.dto.BoardResponseDto;
import sparta.anonboard.api.board.dto.ModifyBoardRequestDto;
import sparta.anonboard.api.board.dto.PostBoardRequestDto;
import sparta.anonboard.domain.board.entity.Board;
import sparta.anonboard.domain.board.service.BoardService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiBoardService {

    private final BoardService boardService;

    public BoardResponseDto postBoard(PostBoardRequestDto postBoardRequestDto) {

        Board postedBoard = boardService.postBoard(postBoardRequestDto.toEntity());

        return BoardResponseDto.of(postedBoard);
    }

    public BoardResponseDto inquireBoard(Long boardId) {

        Board findBoard = boardService.findBoardById(boardId);

        return BoardResponseDto.of(findBoard);
    }

    public List<BoardResponseDto> inquireAllBoard() {

        return boardService.findAllBoards().stream().map(BoardResponseDto::of).collect(Collectors.toList());
    }

    @Transactional
    public BoardResponseDto modifyBoard(ModifyBoardRequestDto modifyBoardRequestDto, String password) {

        Board findBoard = boardService.findBoardById(modifyBoardRequestDto.getId());
        validatePassword(password, findBoard.getPassword());

        Board modifyBoard = modifyBoardRequestDto.toEntity();

        Board modifiedBoard = boardService.modifyBoard(modifyBoard, findBoard);

        return BoardResponseDto.of(modifiedBoard);
    }

    @Transactional
    public void deleteBoard(Long boardId, String password) {

        Board findBoard = boardService.findBoardById(boardId);
        validatePassword(password, findBoard.getPassword());

        boardService.deleteBoard(boardId);
    }

    private void validatePassword(String passwordInRequest, String passwordInDB) {
        if (!passwordInDB.equals(passwordInRequest)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}