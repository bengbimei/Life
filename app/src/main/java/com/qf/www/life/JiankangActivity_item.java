package com.qf.www.life;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class JiankangActivity_item extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //github,和studio 一样不好用s
        setContentView(R.layout.activity_jiankang_activity_item);
    }
}
