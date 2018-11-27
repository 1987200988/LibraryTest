package com.example.library.utils.netutils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * 类描述：Interceptor管理器
 * 创建人：liwei
 * 创建时间：2016/7/6 10:47
 */
public class InterceptorHelper {

    private List<Interceptor> mList=new ArrayList<>();

    private InterceptorHelper(){
    }

    public static InterceptorHelper getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void add(Interceptor interceptor){
        mList.add(interceptor);
    }

    public void remove(Interceptor interceptor){
        mList.remove(interceptor);
    }

    public List<Interceptor> getInterceptors(){
        return mList;
    }

    private static final class LazyHolder {
        private static final InterceptorHelper INSTANCE = new InterceptorHelper();
    }
}
