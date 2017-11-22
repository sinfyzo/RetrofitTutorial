package com.retrofittutorial.A_gettingstarted;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by INFYZO\shailesh.pateliya on 21/11/17.
 */

public interface GitHubClient {
    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);
}
