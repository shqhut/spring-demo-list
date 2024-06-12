package com.shq.demo.orderSeata.pojo;

public class Result<T> {

    private String code;

    private String msg;

    private T data;

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> error(String code, String msg) {
        return new Result<T>(code, msg);
    }

    public static <T> Result<T> error(T data) {
        return new Result<T>("500", "请求异常", data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>("200", "调用成功", data);
    }

    public static <T> Result<T> success() {
        return new Result<T>("200", "调用成功");
    }
}
