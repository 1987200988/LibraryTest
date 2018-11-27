package com.example.library.mvp.ibase;

/**
 * 类描述：View模块的基类接口
 * 创建人：yekh
 * 创建时间：2016/7/6 10:18
 */
public interface IBaseView {
    /**
     * 打开等待界面
     */
    void showLoading();

    /**
     * 关闭等待界面
     */
    void hideLoading();

}