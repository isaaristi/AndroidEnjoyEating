package com.isaaristi.enjoyeating.net;

/**
 * Created by Isabel on 19/06/17.
 */

public class SimpleResponse {

    boolean success;
    String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
