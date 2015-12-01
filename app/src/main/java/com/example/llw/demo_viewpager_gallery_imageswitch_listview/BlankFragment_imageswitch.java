package com.example.llw.demo_viewpager_gallery_imageswitch_listview;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment_imageswitch extends Fragment implements View.OnClickListener {
    private ImageSwitcher imageSwitcher;
    private Button btn_shang;
    private Button btn_xia;
    private int[] images = new int[]{R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.ic_launcher, R.mipmap.j, R.mipmap.k, R.mipmap.l,
            R.mipmap.m, R.mipmap.n, R.mipmap.v, R.mipmap.z};

    private int index = 0;
    private Context context;
    private LayoutInflater layoutInflater;

    public BlankFragment_imageswitch(MainActivity mainActivity) {
        // Required empty public constructor
        this.context = mainActivity;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = layoutInflater.inflate(R.layout.fragment_blank_fragment_imageswitch, null);
        btn_shang = (Button) view.findViewById(R.id.button_shangyzh_id);
        btn_xia = (Button) view.findViewById(R.id.button_xiayzh_id);
        btn_xia.setOnClickListener(this);
        btn_shang.setOnClickListener(this);

        imageSwitcher = (ImageSwitcher) view.findViewById(R.id.imageswitch_id);
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out));
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
        imageSwitcher.setImageResource(index);

        return view;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_shangyzh_id:
                if (index > 0) {
                    index--;
                } else {
                    index = images.length - 1;
                }
                imageSwitcher.setImageResource(images[index]);
                break;
            case R.id.button_xiayzh_id:
                if (index < images.length - 1) {
                    index++;
                } else {
                    index = 0;
                }
                imageSwitcher.setImageResource(images[index]);
                break;
        }

    }
}
