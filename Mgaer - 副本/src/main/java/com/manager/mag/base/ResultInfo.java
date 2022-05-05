package com.manager.mag.base;

public class ResultInfo {
    //状态码
    private Integer code=200;//300
    //提示信息
    private String msg="success";//异常
    private Object result;//这个用于存储对象，在前台会看到



    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
