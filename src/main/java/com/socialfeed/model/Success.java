package com.socialfeed.model;

public class Success {
    private boolean success;
    private int code;

    public Success(boolean success,int code){
        this.success = success;
        this.code = code;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
