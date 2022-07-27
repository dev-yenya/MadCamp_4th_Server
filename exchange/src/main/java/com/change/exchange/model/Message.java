package com.change.exchange.model;
import lombok.Data;

@Data

// response message
public class Message {
    
    private StatusEnum status;
    private String message;
    private Object data;

    public Message(){
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }

}

