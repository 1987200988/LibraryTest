package com.example.library.utils;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;


/**
 * Created by 李韦 on 2016/11/8 15:09
 */
//supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//<android.support.v7.widget.Toolbar
//        android:layout_width="match_parent"
//        android:layout_height="30dp"
//        android:id="@+id/toolbar"
//        android:fitsSystemWindows="true"
//        android:clipToPadding="true"
//        android:background="@color/colorPrimary"
//
//        ></android.support.v7.widget.Toolbar>


public class ToolBarUtils {
    public static void initToolBar(Activity context) {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
