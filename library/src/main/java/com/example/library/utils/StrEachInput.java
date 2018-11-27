package com.example.library.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 李韦 on 2016/11/10 21:04
 */

public class StrEachInput {
    public static InputStream getStringStream(String sInputString){
        if (sInputString != null && !sInputString.trim().equals("")){
            try{
                ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
                return tInputStringStream;
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
//    将输入流转换成字符串
    public static String inputToStr(InputStream input) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        byte[] arr = new byte[1024];
        while((len=input.read(arr))!=-1){
            out.write(arr, 0, len);
        }
        return out.toString();
    }
}
