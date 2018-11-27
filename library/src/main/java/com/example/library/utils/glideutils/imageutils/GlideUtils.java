package com.example.library.utils.glideutils.imageutils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.library.utils.glideutils.GlideCircleTransform;
import com.example.library.utils.glideutils.GlideRoundTransform;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/28
 */

public class GlideUtils implements IImageLoader{


    public static GlideUtils glideUtils;
    private GlideUtils(){}
    public static GlideUtils getInstance(){
        if(glideUtils==null){
            synchronized (GlideUtils.class){
                if(glideUtils==null){
                    glideUtils = new GlideUtils();
                }
            }
        }
        return glideUtils;
    }




    @Override
    public void display(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);

    }

    @Override
    public void display(ImageView imageView, String url, int loadingImg, int errorImg) {
        Glide.with(imageView.getContext()).load(url).placeholder(loadingImg).error(errorImg)
                .into(imageView);
    }

    @Override
    public void displayCircleImg(ImageView imageView, int resId) {
        Glide.with(imageView.getContext()).load(resId).transform(new GlideCircleTransform(imageView.getContext())).into(imageView);


    }

    @Override
    public void displayCircleImg(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).transform(new GlideCircleTransform(imageView.getContext())).into(imageView);

    }

    @Override
    public void displayRoundImg(ImageView imageView, int resId) {
        Glide.with(imageView.getContext()).load(resId).transform(new GlideRoundTransform(imageView.getContext())).into(imageView);

    }

    @Override
    public void displayRoundImg(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).transform(new GlideRoundTransform(imageView.getContext())).into(imageView);

    }

    @Override
    public void displayRoundImg(ImageView imageView, String url, int conners) {
        Glide.with(imageView.getContext()).load(url).transform(new GlideRoundTransform(imageView.getContext(),conners)).into(imageView);
    }

    @Override
    public void displayImgQuick(ImageView imageView, String url, float num, DiskCacheStrategy diskCacheStrategy) {
        Glide.with(imageView.getContext()).load(url)
                .thumbnail(num)
                .diskCacheStrategy(diskCacheStrategy)
                .into(imageView);

    }
}
