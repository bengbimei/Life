package com.qf.www.life;

import android.app.Activity;
import android.os.Bundle;

import com.qf.www.life.Adapter.Adapter_Other_down;
import com.qf.www.life.Adapter.Adapter_Other_up;
import utils.NewListView;

/**
 * Created by aaa on 15-4-30.
 */
public class OtherActivity extends Activity{
    NewListView lv1,lv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        lv1=(NewListView)findViewById(R.id.lv1_other);
        lv1.setAdapter(new Adapter_Other_up(getApplicationContext()));
        lv2=(NewListView)findViewById(R.id.lv2_other);
        lv2.setAdapter(new Adapter_Other_down(getApplicationContext()));
    }
}
