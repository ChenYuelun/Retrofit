package com.example.retorfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
    }

    public void request(View v) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.40:8080/Web_Server/").build();
        AppUrl appUrl = retrofit.create(AppUrl.class);
        Call<ResponseBody> call = appUrl.getIndex();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //请求成功
               // try {
                try {
                    Log.e("TAG", "请求成功" +response.body().string());
                    String string = response.body().string();
                    result.setText(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //请求失败
                Log.e("TAG", "请求失败"+t.getMessage());
            }
        });


    }
}
