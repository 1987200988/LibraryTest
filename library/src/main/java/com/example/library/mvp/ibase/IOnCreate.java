package com.example.library.mvp.ibase;

import android.os.Bundle;

/**
 * 类描述：重载onCreate方法的接口,包括activity、fragment
 * 创建人：yekh
 * 创建时间：2016/7/6 10:14
 */
public interface IOnCreate {
    /**
     * 返回layout的布局文件ID
     */
//    int bindLayout();

    /**
     * 初始化变量，包括Intent带的数据和Activity内的变量
     */
//    void initVariables();

    /**
     * 初始化控件，为控件挂上事件方法
     */
//    void initViews(Bundle savedInstanceState);

    /**
     * 调用MobileAPI获取初始化数据 by onResume()
     */
//    void loadData();
}