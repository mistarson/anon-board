package sparta.anonboard.domain.board.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.anonboard.domain.board.entity.Board;
import sparta.anonboard.domain.board.repository.BoardRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board postBoard(Board board) {
       return boardRepository.save(board);
    }

    public Board findBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Board> findAllBoards() {
        return boardRepository.findAll(Sort.by(Direction.DESC, "createTime"));
    }

    public Board modifyBoard(Board modifyBoard, Board findBoard) {

        findBoard.modify(modifyBoard);

        return findBoard;
    }

}