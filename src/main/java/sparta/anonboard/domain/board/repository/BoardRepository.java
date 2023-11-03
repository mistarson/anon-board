package sparta.anonboard.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.anonboard.domain.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}