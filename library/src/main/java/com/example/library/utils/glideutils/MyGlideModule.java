package com.example.library.utils.glideutils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/28
 */

public class MyGlideModule implements GlideModule{
//    此类已经在类库的清单文件中注册
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
  /*      http://blog.csdn.net/shangmingchao/article/details/51026742
        MemoryCache和BitmapPool的默认大小由MemorySizeCalculator类决定，
        MemorySizeCalculator会根据给定屏幕大小可用内存算出合适的缓存大小，
        这也是推荐的缓存大小，我们可以根据这个推荐大小做出调整*/
//        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
//        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
//        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
//
//        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
//        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);
//
//        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
//        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
//
//
        /*为glide的硬盘缓存重新分配空间*/
//        String path = context.getExternalCacheDir().getPath();
//
//        builder.setDiskCache(
//                new DiskLruCacheFactory(path,"image",200*1024*1024));




    }

    @Override
    public void registerComponents(Context context, Glide glide) {
//注意：new HTTPSUtils(context).getInstance()为已经通过认证的okhttpclient
//        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new HTTPSUtils(context).getInstance()));

    }
}
