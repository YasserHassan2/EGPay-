package com.yasser.egpaytask.retrofit;


import com.yasser.egpaytask.Pojo.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

    //send user  to database for and get response
    @POST("/")
    @FormUrlEncoded
    Call<User> saveUser(@Field("id") int id,
                        @Field("name") String name,
                        @Field("required") String required,
                        @Field("type") String type,
                        @Field("default_value") String default_value,
                        @Field("multiple") String multiple,
                        @Field("sort") String sort);




}
