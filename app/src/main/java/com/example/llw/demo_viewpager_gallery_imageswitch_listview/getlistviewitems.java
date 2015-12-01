package com.example.llw.demo_viewpager_gallery_imageswitch_listview;

import java.io.Serializable;

/**
 * Created by llw on 2015/12/1.
 */
public class getlistviewitems implements Serializable {
    public String items_one;
    public String items_two;
    public String items_three;

    public getlistviewitems(String items_one, String items_two, String items_three) {
        this.items_one = items_one;
        this.items_two = items_two;
        this.items_three = items_three;
    }
}
