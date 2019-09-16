package com.mickjoust.demo.spring.boot.web.api;

/**
 * name: com.hjf.boot.demo.web.api
 * author: mickjoust
 * date: 2018/4/27
 **/
public class ApiResponse<T> {

    public static final int SUCCESS_CODE = 0;
    public static final int ERROR_CODE = 1;
    private int code; //0-成功，1错误
    private String msg;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(SUCCESS_CODE);
        response.setData(data);
        response.setMsg("sucess");
        return response;
    }

    public static <T> ApiResponse<T> error(String error,T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(ERROR_CODE);
        response.setData(data);//注意这里的该怎么处理？对于移动端来说，如果抛null会直接导致app退出
        response.setMsg((null==error||"".equals(error)?"error":error));
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}
