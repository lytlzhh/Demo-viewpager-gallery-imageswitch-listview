package com.example.llw.demo_viewpager_gallery_imageswitch_listview;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_lisview;
    private Button btn_gallery;
    private Button btn_viewpager;
    private Button btn_imageswitch;

    private BlankFragment_gallery blankFragment_gallery;
    private BlankFragment_imageswitch blankFragment_imageswitch;
    private BlankFragment_listview blankFragment_listview;
    private BlankFragment_viewpager blankFragment_viewpager;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lisview = (Button) findViewById(R.id.button_one_id);
        btn_imageswitch = (Button) findViewById(R.id.button_two);
        btn_gallery = (Button) findViewById(R.id.button_three);
        btn_viewpager = (Button) findViewById(R.id.button_four);

        btn_gallery.setOnClickListener(this);
        btn_viewpager.setOnClickListener(this);
        btn_imageswitch.setOnClickListener(this);
        btn_lisview.setOnClickListener(this);
        fragmentManager = getFragmentManager();

    }


    @Override
    public void onClick(View v) {
        setAllbutton();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.button_one_id:
                Clearfragmentlayout(fragmentTransaction);
                fun(0);
                break;
            case R.id.button_two:
                Clearfragmentlayout(fragmentTransaction);
                fun(1);
                break;
            case R.id.button_three:
                Clearfragmentlayout(fragmentTransaction);
                fun(2);
                break;
            case R.id.button_four:
                Clearfragmentlayout(fragmentTransaction);
                fun(3);
                break;
        }
        fragmentTransaction.commit();
    }

    public void setAllbutton() {
        btn_gallery.setTextColor(Color.BLACK);
        btn_gallery.setBackgroundColor(Color.BLUE);
        btn_lisview.setTextColor(Color.BLACK);
        btn_lisview.setBackgroundColor(Color.BLUE);
        btn_imageswitch.setTextColor(Color.BLACK);
        btn_imageswitch.setBackgroundColor(Color.BLUE);
        btn_viewpager.setTextColor(Color.BLACK);
        btn_viewpager.setBackgroundColor(Color.BLUE);
    }

    public void Clearfragmentlayout(FragmentTransaction fragmentTransaction) {

        if (blankFragment_listview != null) {
            fragmentTransaction.hide(blankFragment_listview);
        }

        if (blankFragment_imageswitch != null) {
            fragmentTransaction.hide(blankFragment_imageswitch);
        }

        if (blankFragment_gallery != null) {
            fragmentTransaction.hide(blankFragment_gallery);
        }

        if (blankFragment_viewpager != null) {
            fragmentTransaction.hide(blankFragment_viewpager);
        }
    }

    public void fun(int flages) {
        switch (flages) {
            case 0:
                btn_lisview.setTextColor(Color.RED);
                btn_lisview.setBackgroundColor(Color.BLACK);

                if (blankFragment_listview == null) {
                    blankFragment_listview = new BlankFragment_listview(MainActivity.this);
                    fragmentTransaction.add(R.id.framelayout_id, blankFragment_listview);
                } else {
                    fragmentTransaction.show(blankFragment_listview);
                }
                break;
            case 1:
                btn_imageswitch.setTextColor(Color.RED);
                btn_imageswitch.setBackgroundColor(Color.BLACK);

                if (blankFragment_imageswitch == null) {
                    blankFragment_imageswitch = new BlankFragment_imageswitch(MainActivity.this);
                    fragmentTransaction.add(R.id.framelayout_id, blankFragment_imageswitch);
                } else {
                    fragmentTransaction.show(blankFragment_imageswitch);
                }
                break;
            case 2:
                btn_gallery.setTextColor(Color.RED);
                btn_gallery.setBackgroundColor(Color.BLACK);

                if (blankFragment_gallery == null) {
                    blankFragment_gallery = new BlankFragment_gallery(this);
                    fragmentTransaction.add(R.id.framelayout_id, blankFragment_gallery);
                } else {
                    fragmentTransaction.show(blankFragment_gallery);
                }
                break;
            case 3:
                btn_viewpager.setTextColor(Color.RED);
                btn_viewpager.setBackgroundColor(Color.BLACK);

                if (blankFragment_viewpager == null) {
                    blankFragment_viewpager = new BlankFragment_viewpager(this);
                    fragmentTransaction.add(R.id.framelayout_id, blankFragment_viewpager);
                } else {
                    fragmentTransaction.show(blankFragment_viewpager);
                }
                break;
        }
    }
}
