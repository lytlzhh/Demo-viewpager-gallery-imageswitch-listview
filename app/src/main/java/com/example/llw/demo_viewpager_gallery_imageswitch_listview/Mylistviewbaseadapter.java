package com.example.llw.demo_viewpager_gallery_imageswitch_listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Mylistviewbaseadapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<getlistviewitems> mylist;

    public Mylistviewbaseadapter(List<getlistviewitems> mylist, Context blankFragment_listview) {
        this.context = blankFragment_listview;
        this.mylist = mylist;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return mylist.size();
    }


    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.mylistviewitems, null);
            viewHolder = new ViewHolder();
            viewHolder.textview_list_one = (TextView) convertView.findViewById(R.id.listview_one_id);
            viewHolder.textView_list_two = (TextView) convertView.findViewById(R.id.listview_two_id);
            viewHolder.textView_list_three = (TextView) convertView.findViewById(R.id.listview_three_id);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textview_list_one.setText(mylist.get(position).items_one);
        viewHolder.textView_list_two.setText(mylist.get(position).items_two);
        viewHolder.textView_list_three.setText(mylist.get(position).items_three);
        return convertView;
    }

    public class ViewHolder {
        public TextView textview_list_one;
        public TextView textView_list_two;
        public TextView textView_list_three;
    }
}
