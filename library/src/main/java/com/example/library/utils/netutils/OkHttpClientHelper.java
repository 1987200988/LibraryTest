package com.example.library.utils.netutils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * 类描述：OkHttpClient辅助类
 * 创建人：liwei
 * 创建时间：2016/7/6 10:48
 */
public class OkHttpClientHelper {
    private OkHttpClient mOkHttpClient;
    private static final int TIME_OUT_LIMIT = 60 * 1000;

    private OkHttpClientHelper() {
    }

    public OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    //设置超时时间
                    .connectTimeout(TIME_OUT_LIMIT, TimeUnit.MILLISECONDS)
                    .readTimeout(TIME_OUT_LIMIT, TimeUnit.MILLISECONDS)
                    .writeTimeout(TIME_OUT_LIMIT, TimeUnit.MILLISECONDS)
                    .retryOnConnectionFailure(true);//错误重连
            //添加监听器
            List<Interceptor> interceptors = InterceptorHelper.getInstance().getInterceptors();
            for (Interceptor interceptor : interceptors)
                builder.addInterceptor(interceptor);

            mOkHttpClient = builder.build();
        }
        return mOkHttpClient;
    }

    public static OkHttpClientHelper getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static final class LazyHolder {
        private static final OkHttpClientHelper INSTANCE = new OkHttpClientHelper();
    }
}