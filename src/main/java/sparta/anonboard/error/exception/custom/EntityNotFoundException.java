package sparta.anonboard.error.exception.custom;

import sparta.anonboard.error.exception.BusinessException;
import sparta.anonboard.error.exception.ErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

}
