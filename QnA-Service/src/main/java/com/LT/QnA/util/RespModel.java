package com.LT.QnA.util;

/**
 * Response model common object
 * 
 * @author Dhruvil
 * @version 1.0
 */
public class RespModel {

    private Object lt_response;

    public RespModel() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RespModel(Object lt_response) {
        this.lt_response = lt_response;
    }

    public Object getLt_response() {
        return lt_response;
    }

    public void setLt_response(Object lt_response) {
        this.lt_response = lt_response;
    }
}
