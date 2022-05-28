
package com.miapp.springboot;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseObj{
    String payloads;
    String errors;
    String messages;

public ResponseObj(String payloads, String errors, String messages) {
        this.payloads = payloads;
        this.errors = errors;
        this.messages = messages;
    }

    public ResponseObj() {
    }

    
};