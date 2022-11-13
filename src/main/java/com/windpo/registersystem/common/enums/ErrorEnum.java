package com.windpo.registersystem.common.enums;

/**
 * @author 风之诗
 * @version 1.0
 */
public enum ErrorEnum {
    ERROR1(401,"已存在该队员"),
    ERROR2(402,"填入学号重复");

    private Integer errCode;
    private String errMsg;

    ErrorEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
