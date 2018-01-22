package com.hr.girl.enums;

public enum ResultEnums {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"May Be 小学生"),
    MIDDLE_SCHOOL(101,"May Be 初中学生");

    ;

    private Integer code;
    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
