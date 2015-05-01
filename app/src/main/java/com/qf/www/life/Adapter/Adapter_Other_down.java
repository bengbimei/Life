package com.qf.www.life.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qf.www.life.R;

/**
 * Created by aaa on 15-4-30.
 */
public class Adapter_Other_down extends BaseAdapter{
    Context context;

    public Adapter_Other_down(Context context) {
        this.context = context;
    }

    String title[]={"关于应用","评价应用","建议反馈","活法儿微博","绑定账号","修改邮箱","推荐给好友","清除缓存"};
    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=li.inflate(R.layout.itemdown_other,null);

        TextView tv=(TextView)convertView.findViewById(R.id.tv1_itemdown_other);
        tv.setText(title[position]);
        return convertView;
    }
}
