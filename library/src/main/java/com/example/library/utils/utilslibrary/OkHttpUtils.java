package com.example.library.utils.utilslibrary;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;



/**
 * Created by 李韦 on 2016/11/3.
 */

public class OkHttpUtils {

    private static OkHttpClient mClient;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static int resultCodeGet;
    public static int resultCodePost;
    public OkHttpUtils(){}
    public static Object objectGet;
    public static Object objectPost;
    private static Handler mHandler;

    public static OkHttpClient getOkHttpClient(){
        if(mClient==null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            mClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request request = chain.request();
//                            request = request.newBuilder()
//                                    .addHeader("key","value")
//                                    .build();
//                            return chain.proceed(request);
//                        }
//                    })
                    .build();
            mHandler = new Handler(Looper.getMainLooper());

        }
        return mClient;
    }

    /**
     * 异步post  参数为对象
     * @param url
     * @param obj
     * @param callback
     */
    public static void post(String url,Object obj,Callback callback){
        post(url,new Gson().toJson(obj),callback);
    }
//json串要用\“ （正则表达式）来标记引号
    /**
     * 异步post  参数为json
     * @param url
     * @param json
     * @param callback
     */
    public static void post(String url,String json,Callback callback){
        RequestBody body = RequestBody.create(JSON,json);
        Request request =new Request.Builder()
                .url(url)
                .post(body)
                .build();
        getOkHttpClient().newCall(request).enqueue(callback);
    }

    /**
     * 异步post 参数为Map
     * @param url
     * @param map
     * @param callback
     */
    public static void post(String url, Map<String,String> map, Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        for(String key:map.keySet())
            builder.add(key,map.get(key));

        RequestBody body = builder.build();

        Request request =new Request.Builder()
                .url(url)
                .post(body)
                .build();
        getOkHttpClient().newCall(request).enqueue(callback);
    }

    /**此方法为post的升级版
     *
     *
     * @param url
     * @param map
     *
     *
     */


    public static  void  post(String url, Map<String,String> map,  final Class<? extends Object> cls, final IObjectCallBack object){
        FormBody.Builder builder = new FormBody.Builder();
        for(String key:map.keySet())
            builder.add(key,map.get(key));

        RequestBody body = builder.build();

        Request request =new Request.Builder()
                .url(url)
                .post(body)
                .build();
        getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        object.objectFailure(e);

                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(data, cls);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                       object.objectSuccess(o);

                    }
                });

            }
        });
    }





    /**
     * 异步get
     *
     *
     */
    public static void get(String url,Callback callback){

        Request request =new Request.Builder()
                .url(url)
                .build();
        getOkHttpClient().newCall(request).enqueue(callback);

    }

    /**次方法为get的升级版
     *下面方法通过get方法利用url和该类字节码和view对象的传参来返回一个
     * 数据对象之后操作已经切换到主线程利用结果码判断是否请求成功
     *
     * @param url
     * @param cls
     * @param view
     */

    /**对象回调接口
     *
     */
    public interface IObjectCallBack{
        void objectSuccess(Object object);
        void objectFailure(IOException e);

    }



    public static  void  get(String url, final Class<? extends Object> cls,  final IObjectCallBack object){
        Request request =new Request.Builder()
                .url(url)
                .build();
        getOkHttpClient().newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
//                Log.e("net-failure", "onFailure: "+"网络数据加载失败" );
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        object.objectFailure(e);

                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response)  {
                String data = null;
                try {
                    data = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                final Object o = gson.fromJson(data, cls);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        object.objectSuccess(o);

                    }
                });
            }
        });

    }


    /**
     * 同步get
     *
     *
     */
    public static String get(String url){

        Request request =new Request.Builder()
                .url(url)
                .build();
        try {
            Call call = getOkHttpClient().newCall(request);
            Response response = call.execute();

            if(response.isSuccessful()){
                return response.body().string();
            }else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 分发失败的时候调用
     *
     *
     *
     *
     */
    private static void deliverDataFailure(final Request request, final IOException e, final DataCallBack callBack) {
        /**
         * 在这里使用异步处理
         */
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.requestFailure(request, e);
                }
            }
        });
    }

    /**
     * 分发成功的时候调用
     *
     * @param result
     * @param callBack
     */
    private static void deliverDataSuccess(final String result, final String fileName, final DataCallBack callBack) {
        /**
         * 在这里使用异步线程处理
         */
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    try {
                        callBack.requestSuccess(result,fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 数据回调接口
     */
    public interface DataCallBack {
        void requestFailure(Request request, IOException e);

        void requestSuccess(String result,String fileName) throws Exception;
    }
    //-------------------------文件下载--------------------------
    public static void downloadAsync(String url, String desDir, DataCallBack callBack) {
        inner_downloadAsync(url, desDir, callBack);
    }

    /**
     * 下载文件的内部逻辑处理类
     *
     * @param url      下载地址
     * @param desDir   目标地址
     *
     */
    private static void inner_downloadAsync(final String url, final String desDir, final DataCallBack callBack) {
        final Request request = new Request.Builder().url(url).build();
        getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                deliverDataFailure(request, e, callBack);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                /**
                 * 在这里进行文件的下载处理
                 */
                InputStream inputStream = null;
                FileOutputStream fileOutputStream = null;
                try {
                    //文件名和目标地址
                    File file = new File(desDir, getFileName(url));
                    //把请求回来的response对象装换为字节流
                    inputStream = response.body().byteStream();
                    fileOutputStream = new FileOutputStream(file);
                    int len = 0;
                    byte[] bytes = new byte[2048];
                    //循环读取数据
                    while ((len = inputStream.read(bytes)) != -1) {
                        fileOutputStream.write(bytes, 0, len);
                    }
                    //关闭文件输出流
                    fileOutputStream.flush();
                    //调用分发数据成功的方法
                    deliverDataSuccess(file.getAbsolutePath(),getFileName(url), callBack);
                } catch (IOException e) {
                    //如果失败，调用此方法
                    deliverDataFailure(request, e, callBack);
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }

                }
            }

        });
    }

    /**
     * 根据文件url获取文件的路径名
     *
     *
     *
     */
    private static String getFileName(String url) {
        int separatorIndex = url.lastIndexOf("/");
        String path = (separatorIndex < 0) ? url : url.substring(separatorIndex + 1, url.length());
        return path;
    }

}
