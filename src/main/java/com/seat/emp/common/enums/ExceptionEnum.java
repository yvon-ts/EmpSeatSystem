package com.seat.emp.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    SUCCESS(200, "success");

    private final Integer code;
    private final String desc;

    public String toStringDetails() {
        return toString() + ": 錯誤代碼 " + getCode() + ", " + getDesc();
    }
}
