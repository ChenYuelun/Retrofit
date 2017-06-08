package com.example.retorfit;

import android.nfc.Tag;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (EditText) findViewById(R.id.result);
    }

    public void request(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.m.mtime.cn/PageSubArea/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppUrl appUrl = retrofit.create(AppUrl.class);
        Call<MovieBean> call = appUrl.getIndex();
        call.enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                Log.e("TAG","请求成功" );
                MovieBean bean = response.body();
            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {
                Log.e("TAG","请求失败"+t.getMessage());
            }
        });


    }
}
