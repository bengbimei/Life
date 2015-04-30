package Adapter;

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
public class Adapter_Other_up extends BaseAdapter{
    Context context;

    public Adapter_Other_up(Context context) {
        this.context = context;
    }

    int icon[]={R.drawable.hfmoreiconnotification,R.drawable.hfmoreiconorder,R.drawable.icon_favorites};
    String title[]={"我的通知","我的订单","收藏夹"};

    @Override
    public int getCount() {
        return 3;
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
        convertView=li.inflate(R.layout.itemup_other,null);
        ImageView iv=(ImageView)convertView.findViewById(R.id.iv_itemup_other);
        TextView tv=(TextView)convertView.findViewById(R.id.tv_itemup_other);
        iv.setImageResource(icon[position]);
        tv.setText(title[position]);
        return convertView;
    }
}
