package com.seat.emp.common;

import com.seat.emp.common.enums.ExceptionEnum;
import lombok.Data;

@Data
public class Result<T> {
    private Integer code;

    private String msg;

    private T data;

    private Result(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    private Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static<T> Result<T> success(T data){
        return new Result<T>(ExceptionEnum.SUCCESS.getCode(), ExceptionEnum.SUCCESS.getDesc(), data);
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(ExceptionEnum error){
        return new Result(error.getCode(), error.getDesc());
    }
    public static<T> Result<T> error(ExceptionEnum error, T data){
        return new Result(error.getCode(), error.getDesc(), data);
    }
}
