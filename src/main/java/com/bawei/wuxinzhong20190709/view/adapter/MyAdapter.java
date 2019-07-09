package com.bawei.wuxinzhong20190709.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wuxinzhong20190709.R;
import com.bawei.wuxinzhong20190709.model.bean.Beans;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public class MyAdapter extends BaseAdapter {
    private List<Beans.ResultBean> list;
    private Context context;

    public MyAdapter(List<Beans.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.layout, null);
            holder = new ViewHolder();
            holder.commodityName = convertView.findViewById(R.id.commodityName);
            holder.price = convertView.findViewById(R.id.price);
            holder.masterPic = convertView.findViewById(R.id.masterPic);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.commodityName.setText(list.get(position).commodityName);
        holder.price.setText(list.get(position).price);
        Glide.with(context).load(list.get(position).masterPic).into(holder.masterPic);
        return convertView;
    }

    class ViewHolder {
        private ImageView masterPic;
        private TextView commodityName, price;
    }
}
