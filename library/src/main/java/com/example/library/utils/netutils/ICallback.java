package com.example.library.utils.netutils;

/**
 * 类描述：网络请求回调接口
 * 创建人：liwei
 * 创建时间：2016/7/6 10:45
 */
public interface ICallback<T> {
    /**
     * 完成
     * @param t
     */
    void onCompleted(T t);

    /**
     * 失败
     * @param errMsg
     */
    void onFailed(String errMsg);
}
