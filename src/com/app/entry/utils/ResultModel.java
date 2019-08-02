/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.utils;

/**
 *
 * @author radhikayusuf
 */
public class ResultModel {
    private String message;
    private boolean success;

    public ResultModel(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    
}
