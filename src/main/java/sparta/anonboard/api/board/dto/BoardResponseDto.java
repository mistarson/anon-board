package sparta.anonboard.api.board.dto;

import lombok.Builder;
import lombok.Getter;
import sparta.anonboard.domain.board.entity.Board;

@Getter
@Builder
public class BoardResponseDto {

    private Long id;

    private String title;

    private String writer;

    private String content;

    public static BoardResponseDto of(Board board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .build();
    }

}