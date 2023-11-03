package sparta.anonboard.api.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.anonboard.api.board.dto.BoardResponseDto;
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

}