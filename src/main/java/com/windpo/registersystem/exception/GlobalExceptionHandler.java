package com.windpo.registersystem.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import response.Result;

import java.util.stream.Collectors;

/**
 * @author 风之诗
 * @version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(LocalRunTimeException.class)
    public Result localRunTimeException(LocalRunTimeException e) {
        log.error("异常", e);
        if (e.getErrorEnum() != null) {
            //如果此处为自己抛的异常，则返回自己定义的异常code和msg
            return Result.failure(e.getErrorEnum());
        } else {
            //如果此处为系统抛的异常，则设置异常msg（code设置为500）
            return Result.failure(e.getMessage());
        }
    }

    //拦截传入参数信息太长或者传入参数错误情况
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handlerValidationException(MethodArgumentNotValidException e) {
        log.error("参数校验异常", e);
        //流处理，获取错误信息
        String messages = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("\n"));
        return Result.failure(messages);
    }
}
