package com.qf.www.life;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.qf.www.life.Adapter.Adapter_ViewpagerDetail;

import utils.HttpUtil;

import utils.JsonUtils_detail;
import utils.NewListView;

/**
 * Created by aaa on 15-5-1.
 */
public class ViewpagerDetail_MainActivity extends Activity{
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
    List<Map<String,Object>> list,list2;
    NewListView lv1,lv2;
    int i;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                list=( List<Map<String,Object>>)msg.obj;
                i=msg.arg1;
                lv1.setAdapter(new Adapter_ViewpagerDetail(getApplicationContext(),list,i));
            }


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Calendar cal=Calendar.getInstance();
        TextView tv=(TextView)findViewById(R.id.tv1top_detail);
        tv.setText(sdf.format(cal.getTime()));
        init();


    }
    public void init(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                lv1=(NewListView)findViewById(R.id.lv1_detail);

                String url="http://api.huofar.com/iA/board?sign=e82734743059052fce90acb0b81c95b7&parameters=dWlkPTMxMjY3ODI1JmJpcnRoZGF5PTE5OTcwMTAxJnByb3ZpbmNlbmFtZT0lRTUlOEMlOTclRTQlQkElQUMmcmlkPSZjb3VudHJ5bmFtZT1jaGluYSZnZW5kZXI9MSZ0aXpoaT1CJmNpdHluYW1lPSVFNSU4QyU5NyVFNCVCQSVBQyZkaXNlYXNlPTA=&v=3.2&app_key=aec410aff0547236c2cec0c62e5baf&uuid=0945750f-06ae-3fa5-8a31-ef38d4e514f9&timestamp=2015-04-29&client=Android+vivo+Y22L%2C4.3";
                String jsonString=HttpUtil.getJsonFromNet(url);
                Message msg=handler.obtainMessage();
                list=JsonUtils_detail.getList_Detail(jsonString);
                Log.i("list",list+"");
                i=JsonUtils_detail.getsize(jsonString);
                msg.obj=list;
                msg.what=1;
                msg.arg1=i;
                handler.sendMessage(msg);


            }
        });
        thread.start();

    }
}
