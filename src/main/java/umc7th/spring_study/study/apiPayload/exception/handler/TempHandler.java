package umc7th.spring_study.study.apiPayload.exception.handler;

import umc7th.spring_study.study.apiPayload.code.BaseErrorCode;
import umc7th.spring_study.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
