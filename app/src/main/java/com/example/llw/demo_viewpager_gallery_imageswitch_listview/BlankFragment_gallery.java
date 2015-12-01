package com.example.llw.demo_viewpager_gallery_imageswitch_listview;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment_gallery extends Fragment {
    private Gallery gallery;
    private LayoutInflater layoutInflater;
    private Context context;

    private int[] images = new int[]{R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.ic_launcher, R.mipmap.j, R.mipmap.k, R.mipmap.l,
            R.mipmap.m, R.mipmap.n, R.mipmap.v, R.mipmap.z};

    public BlankFragment_gallery(MainActivity mainActivity) {
        // Required empty public constructor
        this.context = mainActivity;
        layoutInflater = LayoutInflater.from(context);
    }


    List<ImageView> mylist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = layoutInflater.inflate(R.layout.fragment_blank_fragment_gallery, null);
        gallery = (Gallery) view.findViewById(R.id.gallery_id);

        gallery.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
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
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(images[position]);

                return imageView;
            }
        });
        return view;
    }

}
