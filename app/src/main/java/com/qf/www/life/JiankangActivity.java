package com.qf.www.life;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qf.www.life.Adapter.Adapter_Jiankang;
import utils.NewListView;

/**
 * Created by aaa on 15-4-30.
 */
public class JiankangActivity extends Activity{
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiankang_activity_item);
        lv=(ListView)findViewById(R.id.lv_jiangkang);

        View v= LayoutInflater.from(getApplicationContext()).inflate(R.layout.jiankang_bottom,null);
        //TextView tv=(TextView)v.findViewById(R.id.tv_jiangkang_bottom);
       // tv.setText("1111111");
        lv.addFooterView(v);
        lv.setAdapter(new Adapter_Jiankang(getApplicationContext()));
    }
}
