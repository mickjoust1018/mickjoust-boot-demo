package com.mickjoust.demo.spring.boot.properties.domain;

/**
 * Created by mickjoust on 2016/6/14.
 * com.hjf.boot.demo.boot_properties.domain
 */
public class JsonResp {

    private int code;
    private String msg;
    private Object data;

    public JsonResp(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Object success(Object object){
        return new JsonResp(1,"sucess",object);
    }
    public static Object success(Object object,String msg){
        return new JsonResp(1,msg,object);
    }
    public static Object fail(){
        return new JsonResp(0,"error",null);
    }
    public static Object fail(String msg){
        return new JsonResp(0,msg,null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
