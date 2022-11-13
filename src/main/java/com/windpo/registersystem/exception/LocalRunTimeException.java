package com.windpo.registersystem.exception;

import com.windpo.registersystem.common.enums.ErrorEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 风之诗
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LocalRunTimeException extends RuntimeException{
    private ErrorEnum errorEnum;

    //默认错误
    public LocalRunTimeException(String message) {
        super(message);
    }

    public LocalRunTimeException(ErrorEnum errorEnum) {
        super(errorEnum.getErrMsg());
        this.errorEnum = errorEnum;
    }
}