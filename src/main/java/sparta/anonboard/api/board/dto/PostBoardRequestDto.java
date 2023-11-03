package sparta.anonboard.api.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.anonboard.domain.board.entity.Board;

@Getter
@NoArgsConstructor
public class PostBoardRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String writer;

    @NotBlank
    private String password;

    @NotBlank
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .writer(writer)
                .password(password)
                .content(content)
                .build();
    }

}