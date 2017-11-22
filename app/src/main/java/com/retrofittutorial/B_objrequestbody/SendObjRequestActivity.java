package com.retrofittutorial.B_objrequestbody;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.BuildConfig;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.retrofittutorial.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SendObjRequestActivity extends AppCompatActivity {
    private TextView userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_obj_request);
        Log.e(SendObjRequestActivity.class.getSimpleName(), "in SendObjRequestActivity....");
        userInfo = (TextView)findViewById(R.id.userInfo);
        Request request = new Request();
        User user = new User();
        user.setUsername("fbd1@lovecoy.com");
        user.setPassword("Health@2017");
        user.setLat(72.5042949);
        user.setLon(23.0143033);
        user.setFgcmToken("cSM9AfwFj5g:APA91bG-40GZ0AveqiOuEM5SGDbxAic-KP7aiHf4mODbndmLCJ3IFsSy7jkigffOSXpLhPuNmoD-uJ2nQvmCo9u2Nv-IPukullgOvG8ntAu1MXr_TiyI-DH4hYJ1Yar2E3g75HjC2sMB");
        user.setUuid("57ced5867f0b4f");
        request.setUser(user);
        sendRequestObj(request);
    }

    private void sendRequestObj(final Request user) {
        //Create Okhttp client
        OkHttpClient.Builder okhttpclientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //Do it only when in debug mode
        if(BuildConfig.DEBUG){
            okhttpclientBuilder.addInterceptor(logging);
        }

        //Create Retrofit instance
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.1.104:9000/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpclientBuilder.build());

        Retrofit retrofit = builder.build();
        UserClient userClient = retrofit.create(UserClient.class);
        Call<Request>  call = userClient.getUser(user);
        call.enqueue(new Callback<Request>() {
            @Override
            public void onResponse(Call<Request> call, Response<Request> response) {
                Request request = response.body();
                User user1 = request.getUser();
                Log.e("request", request.getResponseCode()+"|"+ request.getResponseMsg());
                userInfo.setText(user1.getFname() + " " + user1.getLname());
            }

            @Override
            public void onFailure(Call<Request> call, Throwable t) {
                Toast.makeText(SendObjRequestActivity.this, "Errot :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
