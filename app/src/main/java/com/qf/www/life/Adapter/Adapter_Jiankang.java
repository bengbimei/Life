package com.qf.www.life.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.www.life.R;

/**
 * Created by aaa on 15-4-30.
 */
public class Adapter_Jiankang extends BaseAdapter{
    Context context;
    int icon[]={R.drawable.artwork_book1,R.drawable.artwork_book1,R.drawable.artwork_book1,R.drawable.artwork_book1,R.drawable.artwork_book1};
    String up[]={"睡不好","睡不好","睡不好","睡不好","睡不好"};
    String down[]={"睡不好，早醒，多梦，心烦等问题","睡不好，早醒，多梦，心烦等问题","睡不好，早醒，多梦，心烦等问题",
            "睡不好，早醒，多梦，心烦等问题","睡不好，早醒，多梦，心烦等问题"};
    public Adapter_Jiankang(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return icon.length;
    }

    @Override
    public Object getItem(int position) {
        return icon[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=li.inflate(R.layout.item_jiankang,null);
        ImageView iv=(ImageView)convertView.findViewById(R.id.iv_item_jiankang);
        TextView tv1=(TextView)convertView.findViewById(R.id.tv1_item_jiankang);
        TextView tv2=(TextView)convertView.findViewById(R.id.tv2_item_jiankang);
        iv.setImageResource(icon[position]);
        tv1.setText(up[position]);
        tv2.setText(down[position]);
        return convertView;
    }
}
