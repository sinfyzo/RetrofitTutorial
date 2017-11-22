package com.retrofittutorial.B_objrequestbody;

/**
 * Created by INFYZO\shailesh.pateliya on 21/11/17.
 */

public class UserDemo {
    private String username;
    private String password;
    private String uuid;
    private double lat;
    private double lon;
    private String fgcmToken;

    private String _id;
    private String fname;
    private String lname;
    private String email;

    public UserDemo(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getFgcmToken() {
        return fgcmToken;
    }

    public void setFgcmToken(String fgcmToken) {
        this.fgcmToken = fgcmToken;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
