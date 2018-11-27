package com.example.library.base;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.library.utils.ScrollDisabledListView;

import java.util.List;
import java.util.Map;

/**
 * Created by 李韦 on 2016/11/8 20:11
 */

public interface IOnSlideBarCreate {

    void initViews(Bundle bundle);
    void initDatas();
    void clickEvents();
    void slideListView(ListView listview);
    void slideData(List<Map<String, Object>> list);


}
