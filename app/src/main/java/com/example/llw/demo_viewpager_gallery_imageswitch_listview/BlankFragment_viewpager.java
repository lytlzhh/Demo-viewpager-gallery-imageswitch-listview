package com.example.llw.demo_viewpager_gallery_imageswitch_listview;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment_viewpager extends Fragment {

    private ViewPager viewPager;
    private Context context;
    private LayoutInflater layoutInflater;

    private int[] images = new int[]{R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.ic_launcher, R.mipmap.j, R.mipmap.k, R.mipmap.l,
            R.mipmap.m, R.mipmap.n, R.mipmap.v, R.mipmap.z};

    public BlankFragment_viewpager(MainActivity mainActivity) {
        // Required empty public constructor
        this.context = mainActivity;
        layoutInflater = LayoutInflater.from(context);
    }


    List<ImageView> mylist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = layoutInflater.inflate(R.layout.fragment_blank_fragment_viewpager, null);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_id);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(images[position]);
                mylist.add(imageView);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mylist.get(position));
            }
        });
        return view;
    }

}
