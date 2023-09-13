package store.bizscanner.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor @Getter
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}
