package com.qf.www.life;

import android.app.Activity;
import android.os.Bundle;

import com.qf.www.life.Adapter.Adapter_Jiankang;
import utils.NewListView;

/**
 * Created by aaa on 15-4-30.
 */
public class JiankangActivity extends Activity{
    NewListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiankang);
        lv=(NewListView)findViewById(R.id.lv_jiangkang);
        lv.setAdapter(new Adapter_Jiankang(getApplicationContext()));

    }
}
