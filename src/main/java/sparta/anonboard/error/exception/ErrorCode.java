package sparta.anonboard.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BOARD_NOT_FOUND(400, "게시글 정보가 존재하지 않습니다."),
    MISMATCHED_PASSWORD(401, "패스워드가 일치하지 않습니다.");

    private final int status;

    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
