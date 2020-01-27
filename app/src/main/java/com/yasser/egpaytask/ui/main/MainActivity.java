package com.yasser.egpaytask.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Toast;

import com.yasser.egpaytask.R;
import com.yasser.egpaytask.retrofit.APIInterface;

public class MainActivity extends AppCompatActivity implements UserView{

    UserPresenter userPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPresenter = new UserPresenter(MainActivity.this,this);

        Toast.makeText(this,
                userPresenter.sendUser(), Toast.LENGTH_LONG).show();


    }


}
