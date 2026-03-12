package jp.terasoluna.batch.sample.sample003;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import jp.terasoluna.fw.collector.validate.ValidateErrorStatus;
import jp.terasoluna.fw.collector.validate.ValidationErrorHandler;
import jp.terasoluna.fw.collector.vo.DataValueObject;

public class CustomValidationErrorHandler implements ValidationErrorHandler {

    /**
     * Log.
     */
    private static final Logger log = LoggerFactory
            .getLogger(CustomValidationErrorHandler.class);

    public ValidateErrorStatus handleValidationError(
            DataValueObject dataValueObject, Errors errors) {

        if (log.isWarnEnabled()) {
            List<FieldError> fieldErrorList = errors.getFieldErrors();
            for (FieldError fieldError : fieldErrorList) {
                log.warn("{} フィールドにおいて必須入力チェックエラー発生", fieldError.getField());
            }
        }

        // エラーデータをとばして、そのまま処理を続行する
        return ValidateErrorStatus.SKIP;
    }
}
