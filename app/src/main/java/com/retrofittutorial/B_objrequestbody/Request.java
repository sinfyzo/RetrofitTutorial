package com.retrofittutorial.B_objrequestbody;

/**
 * Created by INFYZO\shailesh.pateliya on 21/11/17.
 */

public class Request {
    private User data;
    private int responseCode;
    private String responseMsg;

    public User getUser() {
        return data;
    }

    public void setUser(User data) {
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }
}
