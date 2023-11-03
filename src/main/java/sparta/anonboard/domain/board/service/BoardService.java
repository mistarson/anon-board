package sparta.anonboard.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.anonboard.domain.board.entity.Board;
import sparta.anonboard.domain.board.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board postBoard(Board board) {
       return boardRepository.save(board);
    }

    public Board findBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException());
    }

}