package com.cc.monitor.client.exception;

public class LMCMonitorException extends Exception {

    private String msg;

    public LMCMonitorException() {
        super();
    }

    public LMCMonitorException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public LMCMonitorException(Exception rootCause, String msg) {
        super(msg, rootCause);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
