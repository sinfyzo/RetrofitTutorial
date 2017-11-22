package com.retrofittutorial.B_objrequestbody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by INFYZO\shailesh.pateliya on 21/11/17.
 */

public interface UserClient {
    @POST("login")
    Call<Request> getUser(@Body Request user);
}
