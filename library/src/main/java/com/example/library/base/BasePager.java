package com.example.library.base;

import android.app.Activity;
import android.view.View;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/30
 */

public abstract class BasePager<T> {
    public View basePagerView;
    public Activity basePagerActivity;
    public BasePager(Activity activity){
        basePagerActivity = activity;
        basePagerView = initViews();

    }
    public abstract View initViews();
    public abstract void initDatas(List<T> list);
}
