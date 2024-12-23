package umc7th.spring_study.study.apiPayload.exception.handler;

import umc7th.spring_study.study.apiPayload.code.BaseErrorCode;
import umc7th.spring_study.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
