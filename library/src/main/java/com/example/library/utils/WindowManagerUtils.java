package com.example.library.utils;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.View;
import android.view.WindowManager;
/**
 * Created by 李韦 on 2016/11/3.
 */
public class WindowManagerUtils {
private static WindowManager mWindowManager;
private static WindowManager mWindowManager2;
private static View mNightView;
    private static View mNightView2;
public static void showWindow(Context context) {
    mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    mNightView = new View(context);
    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
               WindowManager.LayoutParams.MATCH_PARENT,
               WindowManager.LayoutParams.MATCH_PARENT,
               WindowManager.LayoutParams.TYPE_APPLICATION,
               WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
 WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
               PixelFormat.TRANSLUCENT);
     mNightView.setBackgroundColor(0xaa000000);
     mWindowManager.addView(mNightView, lp);

}
public static void removeWindow() {
    // TODO Auto-generated method stub
    if(mWindowManager==null||mNightView==null){
        
        return;
    }
    mWindowManager.removeViewImmediate(mNightView);
}
//    public static void showWindow2(Context context) {
//        mWindowManager2 = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        mNightView2 = new View(context);
//        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.MATCH_PARENT,
//                WindowManager.LayoutParams.MATCH_PARENT,
//                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
//                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                WindowManager.LayoutParams.TYPE_INPUT_METHOD_DIALOG,
//                PixelFormat.TRANSLUCENT);
//        mNightView2.setBackgroundColor(0xaa000000);
//        mWindowManager2.addView(mNightView2, lp);
//
//    }
//    public static void removeWindow2() {
//        // TODO Auto-generated method stub
//        if(mWindowManager2==null||mNightView2==null){
//
//            return;
//        }
//        mWindowManager2.removeViewImmediate(mNightView2);
//    }
}