package com.retrofittutorial.A_gettingstarted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.retrofittutorial.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GettingStartedActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);
        listView = (ListView)findViewById(android.R.id.list);

        //Create Retrofit Builder
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());
        //Create Retrofit Object
        Retrofit retrofit = builder.build();


        GitHubClient gitHubClient = retrofit.create(GitHubClient.class);
        Call<List<GitHubRepo>> call = gitHubClient.reposForUser("fs-opensource");
        //Call api
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> list = response.body();
                listView.setAdapter(new GitHubRepoAdapter(GettingStartedActivity.this, list));

            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(GettingStartedActivity.this, "Error :)", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
