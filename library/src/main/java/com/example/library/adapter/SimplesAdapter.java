package com.example.library.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.R;

import java.util.List;
import java.util.Map;

/**
 * Created by 70665 on 2018/4/16.
 */

public class SimplesAdapter extends BaseAdapter {
    private List<Map<String, Object>> stuList;
    private LayoutInflater mInflater;
    public SimplesAdapter() {}

    public SimplesAdapter(Context context,List<Map<String, Object>> stuList) {
        this.stuList = stuList;
        this.mInflater= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return this.stuList.size();
    }
    @Override
    public Object getItem(int i) {
        return this.stuList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.slide_item,null);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.si_tv);
            holder.icon = (ImageView) convertView.findViewById(R.id.si_iv);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }


        String data_title = this.stuList.get(position).get("data_title") + "";
        if (data_title.length() == 3) {

            holder.text.setMaxLines(1);
            holder.text.setMaxEms(3);
            holder.text.setText(data_title + "");
        } else {
//    holder.text.setMaxLines(2);
            holder.text.setText(this.stuList.get(position).get("data_title") + "");
        }


        holder.icon.setImageResource((int) this.stuList.get(position).get("data_image"));
        return convertView;
    }



    static class ViewHolder {
        TextView text;
        ImageView icon;
    }
}
