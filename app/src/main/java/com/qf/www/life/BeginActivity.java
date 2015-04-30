package com.qf.www.life;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.qf.www.life.ParesUtils.BeautifulLife_parser;

public class BeginActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        if (isFirst())//如果第一次打开应用，就进入欢迎页面
        {
            System.out.println("-----------欢迎");
            Intent in = new Intent(this, WelActivity.class);
            startActivity(in);
            finish();
        }
        //下载网络数据并解析存储
        HttpUtils httpUtils = new HttpUtils(5000);
        httpUtils.send(HttpRequest.HttpMethod.GET, Url.beautifulLife, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                if (objectResponseInfo != null) {
                    //传人json字符串，解析数据，存储在静态集合中
                    BeautifulLife_parser.getResult(objectResponseInfo.result);
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(BeginActivity.this, "你的网速卡爆了", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //判断是否第一次 打开应用的方法
    public boolean isFirst() {
        SharedPreferences sharedPreferences = getSharedPreferences("isFirst", MODE_PRIVATE);
        if (!sharedPreferences.contains("isFirst")) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("isFirst", false);
            edit.commit();
            return true;
        }
        return false;
    }


}
