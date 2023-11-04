package sparta.anonboard.api.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.anonboard.domain.board.entity.Board;

@Getter
@NoArgsConstructor
public class ModifyBoardRequestDto {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
