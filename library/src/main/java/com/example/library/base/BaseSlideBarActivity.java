package com.example.library.base;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.library.R;
import com.example.library.utils.ScrollDisabledListView;
import com.jaeger.library.StatusBarUtil;
import com.zhy.autolayout.AutoLayoutActivity;
import com.example.library.adapter.SimplesAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 李韦 on 2016/11/3.
 */
public abstract class BaseSlideBarActivity extends AutoLayoutActivity implements IOnSlideBarCreate {

    private static Ipermissions ipermissions;
    private final static LinkedList<BaseSlideBarActivity> mActivities = new LinkedList<>();
    private static ListView listview;
    private static SimplesAdapter adapter=null;

//    private static SimpleAdapter adapter=null;
    private static List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusBarUtil.setColor(BaseSlideBarActivity.this, getResources().getColor(R.color.main_color_lib));
//        StatusBarUtil_2.StatusBarLightMode(BaseActivity.this, true);
        synchronized (mActivities) {
            mActivities.add(this);
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initViews(savedInstanceState);
        initDatas();
        clickEvents();
        setListView(listview);
        setData(list);
        slideListView(listview);
        slideData(list);
        setSlideData();
    }


    public static LinkedList<BaseSlideBarActivity> getActivities() {
        return mActivities;

    }

    public static void setListView(ListView listview) {
        BaseSlideBarActivity.listview = listview;
    }

    public static void setData(List<Map<String, Object>> list) {
        BaseSlideBarActivity.list = list;
    }

    public void setSlideData() {
        adapter = new SimplesAdapter(this, list);
//        adapter = new SimpleAdapter(this, list, R.layout.slide_item,
//                new String[]{"data_title", "data_image"},
//                new int[]{R.id.si_tv, R.id.si_iv});
        listview.setAdapter(adapter);
    }


    public <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }

    public static void requestRuntimePermissions(String[] permissions, Ipermissions permissionListener) {
        ipermissions = permissionListener;
        List<String> listRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(mActivities.getLast(), permission) != PackageManager.PERMISSION_GRANTED) {
                listRequest.add(permission);
            }
        }
        if (!listRequest.isEmpty()) {
            ActivityCompat.requestPermissions(mActivities.getLast(), listRequest.toArray(new String[listRequest.size()]), 1);

        } else {
            ipermissions.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        ipermissions.onGranted();
                    } else {
                        ipermissions.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }
    }

    public void killAll() {
        LinkedList<BaseSlideBarActivity> baseActivities = new LinkedList<>(mActivities);
        for (BaseSlideBarActivity base : baseActivities) {
            base.finish();
        }
    }


    /**
     * 获取主题色
     */
    public int getColorPrimary() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    /**
     * 获取深主题色
     */
    public int getDarkColorPrimary() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        return typedValue.data;
    }

}
