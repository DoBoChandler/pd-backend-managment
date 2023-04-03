package com.pd.backend.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author byzhao
 * @version 1.0
 * @description 统一响应数据格式类
 * @date 2022/10/1 22:38:39
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {
    private static final long serialVersionUID = 7735505903525411467L;

    // 成功值
    private static final int SUCCESS_CODE = 1;
    // 失败值
    private static final int ERROR_CODE = 0;

    //状态码
    private int code;
    //消息
    private String msg;
    //返回数据
    private T data;

    private String path;

    private String extra;

    private String timestamp;

    private boolean isError;

    private boolean isSuccess;

    private R(int code){
        this.code = code;
    }
    private R(int code, T data){
        this.code = code;
        this.data = data;
    }
    private R(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private R(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(int code, String msg, T data, String path, String extra, String timestamp, boolean isError, boolean isSuccess) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.path = path;
        this.extra = extra;
        this.timestamp = timestamp;
        this.isError = isError;
        this.isSuccess = isSuccess;
    }
    public R(int code, String msg, T data,Boolean isSuccess) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.isSuccess = isSuccess;
    }
    public static <T> R<T> ok(){
        return new R<T>(SUCCESS_CODE,"success");
    }
    public static <T> R<T> ok(String msg){
        return new R<T>(SUCCESS_CODE,msg);
    }
    public static <T> R<T> ok(T data){
        return new R<T>(SUCCESS_CODE,data);
    }
    public static <T> R<T> ok(String msg, T data){
        return new R<T>(SUCCESS_CODE,msg,data);
    }
    public static <T> R<T> ok(String msg, T data,Boolean isSuccess){
        return new R<T>(SUCCESS_CODE,msg,data,isSuccess);
    }

    public static <T> R<T> error(){
        return new R<T>(ERROR_CODE,"error");
    }
    public static <T> R<T> error(String msg){
        return new R<T>(ERROR_CODE,msg);
    }
    public static <T> R<T> error(int code, String msg){
        return new R<T>(code,msg);
    }
    public static <T> R<T> error(String msg, T data,boolean isError){
        return new R<T>(SUCCESS_CODE,msg,data,isError);
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
    public T getData(){
        return data;
    }
    public String getTimestamp(){
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public String getExtra() {
        return extra;
    }

    public boolean isError() {
        return isError;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}