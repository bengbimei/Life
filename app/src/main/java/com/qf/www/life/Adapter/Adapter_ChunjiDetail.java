package com.qf.www.life.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.qf.www.life.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aaa on 15-5-1.
 */
public class Adapter_ChunjiDetail extends BaseAdapter{
    Context context;
    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
    private final  int VIEW_COUNT=2;
    private final  int VIEW_TITLE=0;
    private final  int VIEW_CONTENT=1;
    public Adapter_ChunjiDetail(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
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
    public int getViewTypeCount() {
        return VIEW_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).size() == 1) {
            return VIEW_TITLE;
        }else {
            return VIEW_CONTENT;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (getItemViewType(position)){
            case VIEW_TITLE:
                TitleHolder th;
                if (convertView == null) {
                    th=new TitleHolder();
                    convertView=li.inflate(R.layout.itemtitle_chunjidetail,null);
                    th.tv=(TextView)convertView.findViewById(R.id.tv_itemtitle_chunjidetail);
                    convertView.setTag(th);

                }else {
                    th=(TitleHolder)convertView.getTag();
                }
                th.tv.setText(list.get(position).get("title").toString());
                break;
            case  VIEW_CONTENT:
                ContentHolder ch;
                if (convertView == null) {
                    ch=new ContentHolder();
                    convertView=li.inflate(R.layout.itemcontent_chunjidetail,null);
                    ch.tv1=(TextView)convertView.findViewById(R.id.tv_itemcontent_chunjidetai);
                    ch.tv2=(TextView)convertView.findViewById(R.id.tv2_itemcontent_chunjidetail);
                    ch.iv1=(ImageView)convertView.findViewById(R.id.iv_itemcontent_chunjidetail);
                    convertView.setTag(ch);

                }else {
                    ch=(ContentHolder)convertView.getTag();
                }
                BitmapUtils bm=new BitmapUtils(context);
                bm.display(ch.iv1,list.get(position).get("imageUrl").toString());
                ch.tv1.setText(list.get(position).get("itemTitle").toString());
                ch.tv2.setText(list.get(position).get("itemDesc").toString());
                break;
        }

        return convertView;
    }
    class TitleHolder{
        TextView tv;
    }
    class ContentHolder{
        ImageView iv1;
        TextView tv1,tv2;
    }
}
