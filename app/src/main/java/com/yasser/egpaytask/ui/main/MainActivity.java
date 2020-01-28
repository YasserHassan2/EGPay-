package com.yasser.egpaytask.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements UserView {

    UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userPresenter = new UserPresenter(MainActivity.this, this);
        setContentView(userPresenter.initViews(MainActivity.this));



    }



}
