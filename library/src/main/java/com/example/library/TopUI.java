package com.example.library;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/12/14.
 */

public class TopUI {
//
//
//    /**
//     * 设置状态栏字体图标为深色，需要MIUIV6以上
//     *
//     * @param window 需要设置的窗口
//     * @param dark   是否把状态栏字体及图标颜色设置为深色
//     * @return boolean 成功执行返回true
//     */
//    public boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
//        boolean result = false;
//        if (window != null) {
//            Class clazz = window.getClass();
//            try {
//                int darkModeFlag = 0;
//                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
//                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
//                darkModeFlag = field.getInt(layoutParams);
//                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
//                if (dark) {
//                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
//                } else {
//                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
//                }
//                result = true;
//            } catch (Exception e) {
//
//            }
//        }
//        return result;
//    }
//
//
//    /**
//     * 通过设置全屏，设置状态栏透明
//     *
//     * @param activity
//     */
//    public void fullScreen(Activity activity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
//                Window window = activity.getWindow();
//                View decorView = window.getDecorView();
//                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
//                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                decorView.setSystemUiVisibility(option);
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                window.setStatusBarColor(Color.TRANSPARENT);
//                //导航栏颜色也可以正常设置
////                window.setNavigationBarColor(Color.TRANSPARENT);
//            } else {
//                Window window = activity.getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
//                attributes.flags |= flagTranslucentStatus;
////                attributes.flags |= flagTranslucentNavigation;
//                window.setAttributes(attributes);
//            }
//        }
//    }
//
//
//    /**
//     * 通过设置全屏，设置状态栏透明
//     *
//     * @param activity
//     */
//    public void fullScreen2(Activity activity, int state, int color, int statusBarAlpha,boolean flag) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
//                Window window = activity.getWindow();
//                View decorView = window.getDecorView();
//                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                if (state == 2) {
//                    int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                    decorView.setSystemUiVisibility(option);
//                    decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                    window.setStatusBarColor(calculateStatusColor(color, statusBarAlpha));
//                    window.setNavigationBarColor(Color.WHITE);
//                    MIUISetStatusBarLightMode(window, flag);
//                } else {
//                    window.setStatusBarColor(activity.getResources().getColor(R.color.white));
//                    MIUISetStatusBarLightMode(window, flag);
//                    window.setNavigationBarColor(Color.WHITE);
//                }
//                //导航栏颜色也可以正常设置
////                window.setNavigationBarColor(Color.TRANSPARENT);
//            } else {
//                Window window = activity.getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
//                attributes.flags |= flagTranslucentStatus;
////                attributes.flags |= flagTranslucentNavigation;
//                window.setAttributes(attributes);
//            }
//        }
//    }
//
//    /**
//     * 计算状态栏颜色
//     *
//     * @param color color值
//     * @param alpha alpha值
//     * @return 最终的状态栏颜色
//     */
//    private static int calculateStatusColor(@ColorInt int color, int alpha) {
//        float a = 1 - alpha / 255f;
//        int red = color >> 16 & 0xff;
//        int green = color >> 8 & 0xff;
//        int blue = color & 0xff;
//        red = (int) (red * a + 0.5);
//        green = (int) (green * a + 0.5);
//        blue = (int) (blue * a + 0.5);
//        return 0xff << 24 | red << 16 | green << 8 | blue;
//    }

}
