package com.example.greencommute.exception;

public class JobNotFoundException extends  RuntimeException{

    public JobNotFoundException(String message,Throwable cause){
        super(message,cause);
    }

    public JobNotFoundException(String message){
        super(message);
    }

    public JobNotFoundException(Throwable cause ){
        super(cause);
    }
}
