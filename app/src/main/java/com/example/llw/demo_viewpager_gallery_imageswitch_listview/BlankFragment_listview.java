package com.example.llw.demo_viewpager_gallery_imageswitch_listview;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment_listview extends Fragment {
    private ListView listView;
    private LayoutInflater layoutInflater;
    private Context context;

    List<getlistviewitems> mylist = new ArrayList<getlistviewitems>();

    public BlankFragment_listview(MainActivity mainActivity) {
        // Required empty public constructor
        this.context = mainActivity;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //   View view = layoutInflater.inflate(R.layout.fragment_blank_fragment_listview, null);
        // listView = (ListView) view.findViewById(R.id.mylistview_id);

        container = (ViewGroup) layoutInflater.inflate(R.layout.fragment_blank_fragment_listview, null);
        listView = (ListView) container.findViewById(R.id.mylistview_id);

        for (int i = 0; i < 40; i++) {
            mylist.add(new getlistviewitems("hello word!", "你好吗?", "天空"));
        }
        listView.setAdapter(new Mylistviewbaseadapter(mylist, context));
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(context, "你好吗！", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context, "hehehehe", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return container;
    }

    class Myadapter extends BaseAdapter {
        @Override
        public int getCount() {

            return mylist.size();
        }

        @Override
        public Object getItem(int position) {

            return position;
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
    }


    public class ViewHolder {
        public TextView textview_list_one;
        public TextView textView_list_two;
        public TextView textView_list_three;
    }


}
