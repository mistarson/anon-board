package sparta.anonboard.domain.board.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.anonboard.domain.board.entity.Board;
import sparta.anonboard.domain.board.repository.BoardRepository;
import sparta.anonboard.error.exception.ErrorCode;
import sparta.anonboard.error.exception.custom.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board postBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board findBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.BOARD_NOT_FOUND));
    }

    public List<Board> findAllBoards() {
        return boardRepository.findAll(Sort.by(Direction.DESC, "createTime"));
    }

    @Transactional
    public Board modifyBoard(Board modifyBoard, Board findBoard) {

        findBoard.modify(modifyBoard);

        return findBoard;
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}