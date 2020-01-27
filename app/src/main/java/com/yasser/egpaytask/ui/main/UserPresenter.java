package com.yasser.egpaytask.ui.main;


import android.content.Context;
import android.widget.Toast;

import com.yasser.egpaytask.Pojo.User;
import com.yasser.egpaytask.retrofit.APIInterface;
import com.yasser.egpaytask.retrofit.ApiUtil;

import retrofit2.Callback;

public class UserPresenter {

    UserView userView;
    APIInterface apiInterface;
    String result="";
    Context mContext;

    public UserPresenter(UserView userView,Context context) {
        this.mContext= context;
        this.userView = userView;
    }


    public String sendUser() {
        apiInterface = ApiUtil.getAPIService();
        apiInterface.saveUser(1520,"Yasser","yes","type","defult","multi"
                ,"2").enqueue(new Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, retrofit2.Response<User> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(mContext, "Added Successfully", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {
                Toast.makeText(mContext, "Fail! " + t, Toast.LENGTH_SHORT).show();

            }
        });
        return result;
    }

}
