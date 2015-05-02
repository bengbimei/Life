package com.qf.www.life.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.www.life.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aaa on 15-5-1.
 */
public class Adapter_ViewpagerDetail extends BaseAdapter{
    Context context;
    int i;
    List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();

    public Adapter_ViewpagerDetail(Context context, List<Map<String, Object>> list, int i) {
        this.context = context;
        this.list = list;
        this.i=i;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=li.inflate(R.layout.item_viewpagerdetail,null);
        TextView tv1=(TextView)convertView.findViewById(R.id.tv1yi_detail);
        TextView tv2=(TextView)convertView.findViewById(R.id.tv2yi_detail);
        ImageView iv1=(ImageView)convertView.findViewById(R.id.iv_item_detail);
        tv1.setText(list.get(position).get("title").toString());
        tv2.setText(list.get(position).get("desc").toString());
        if(position>=i){
            iv1.setImageResource(R.drawable.icon_ji);
        }
        return convertView;
    }
}
