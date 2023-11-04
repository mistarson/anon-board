package sparta.anonboard.error.exception.custom;

import sparta.anonboard.error.exception.BusinessException;
import sparta.anonboard.error.exception.ErrorCode;

public class MismatchedPasswordException extends BusinessException {

    public MismatchedPasswordException(ErrorCode errorCode) {
        super(errorCode);
    }

}
