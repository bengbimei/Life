package com.qf.www.life;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.qf.www.life.ParesUtils.ChunjiDetail_MainActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent();
        intent.setClass(getApplicationContext(), JiankangActivity.class);
        startActivity(intent);
    }

}
