package com.example.retorfit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chenyuelun on 2017/6/8.
 */

//接口名，可以随意定义
    //此接口用于设定请求地址的一些信息
public interface AppUrl {

    @GET("TrailerList.api")//此行注解代表Get请求
    Call<MovieBean> getIndex();


}
