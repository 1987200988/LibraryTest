package com.example.library.utils.glideutils.imageutils;


import static com.example.library.utils.glideutils.imageutils.ImageUtilsManager.Type.GLIDE;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/28
 */

public class ImageUtilsManager {
    public static IImageLoader getGlideUtils(Type type){
        if(GLIDE==type){
            return GlideUtils.getInstance();
        }
        return GlideUtils.getInstance();
    }

    public enum Type{
        GLIDE;
    }
}
