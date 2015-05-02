package com.qf.www.life.ParesUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;
import com.qf.www.life.Adapter.Adapter_ChunjiDetail;
import com.qf.www.life.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.HttpUtil;
import utils.JsonUtils_ChunjiDetail;

import utils.NewListView;

/**
 * Created by aaa on 15-5-1.
 */
public class ChunjiDetail_MainActivity extends Activity{
    ImageView iv_toptitle;
    LinearLayout iv_topll;

    TextView tv_top;
    ListView lv;
    Map<String,Object> map=new HashMap<String,Object>();
    List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                map=(Map<String,Object>)msg.obj;
                tv_top.setText(map.get("sceneDesc").toString());
                BitmapUtils bm=new BitmapUtils(getApplicationContext());
                bm.display(iv_topll,map.get("sceneImageUrl").toString());
                bm.display(iv_toptitle,map.get("sceneImageTitleUrl").toString());
            }
            if (msg.what == 2) {
                list=(List<Map<String,Object>>)msg.obj;
                lv.setAdapter(new Adapter_ChunjiDetail(getApplicationContext(),list));
                Log.i("lv",lv.getHeight()+",,,,"+lv.getMeasuredHeight());
                Log.i("end","end");
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chunjidetail);
        lv=(ListView)findViewById(R.id.lv_itemcontent_chunjidetail);
        //Log.i("iv_topll",iv_topll.getHeight()+"");
        View v= LayoutInflater.from(getApplicationContext()).inflate(R.layout.chunji_head,null);
        tv_top=(TextView)v.findViewById(R.id.tv_top_chunjidetail);
        iv_topll=(LinearLayout)v.findViewById(R.id.ll_top_chunjidetail);
        iv_toptitle=(ImageView)v.findViewById(R.id.iv_top_chunjidetail);
        lv.addHeaderView(v);
        init();


    }
    public void init(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {


            String path="http://api.huofar.com/iA/scene/show?sign=59648209f220e7283cb6a381fd940528&parameters=cHJvdmluY2U9JUU1JThDJTk3JUU0JUJBJUFDJnRpemhpPUImZGlzZWFzZT0mc2NlbmVJZD0xMDU4JmNpdHk9JUU1JThDJTk3JUU0JUJBJUFDJmtleXdvcmQ9&v=3.2&app_key=aec410aff0547236c2cec0c62e5baf&uuid=0945750f-06ae-3fa5-8a31-ef38d4e514f9&timestamp=2015-04-29&client=Android+vivo+Y22L%2C4.3";
            String JsonString=HttpUtil.getJsonFromNet(path);
            map=JsonUtils_ChunjiDetail.gettop(JsonString);
           Message msg=handler.obtainMessage();
                msg.what=1;
                msg.obj=map;
                handler.sendMessage(msg);
            list=JsonUtils_ChunjiDetail.getList(JsonString);
                Log.i("list",list+"");
            Message msg2=handler.obtainMessage();
                msg2.what=2;
                msg2.obj=list;
                handler.sendMessage(msg2);
            }
        });
        thread.start();
    }

}
