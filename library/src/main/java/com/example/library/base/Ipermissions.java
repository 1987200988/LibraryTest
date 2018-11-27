package com.example.library.base;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/28
 */

public interface Ipermissions {
    void onGranted();
    void onDenied(List<String> listDenies);

}
