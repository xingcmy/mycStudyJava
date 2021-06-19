package com.learn.demo.exception;

public class AreaException extends Exception {
    static final long serialVersionUID = -7034897190745766939L;

    public AreaException(){
        super();
    }

    public AreaException(String msg){
        super(msg);
    }

    public AreaException(String msg,Throwable cause){
        super(msg,cause);
    }

    public AreaException(Throwable cause){
        super(cause);
    }

    protected AreaException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
