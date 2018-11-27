package com.example.library.mvp.ibase;

/**
 * 类描述：针对activity中的onCreate方法重新规划生命周期
 * 创建人：yekh
 * 创建时间：2016/7/6 10:16
 */
public interface IActivity extends IOnCreate{
    /**
     * setContentView方法调用前的一些设置
     */
    void beforeContentView();
}
