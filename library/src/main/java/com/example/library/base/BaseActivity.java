package com.example.library.base;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.library.R;
import com.example.library.utils.StatusBarUtil_2;
import com.example.library.utils.utilslibrary.SystemBarTintManager;
import com.jaeger.library.StatusBarUtil;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by 李韦 on 2016/11/3.
 */
public abstract class BaseActivity extends AutoLayoutActivity implements IOnCreate {

    private static Ipermissions ipermissions;
    private final static LinkedList<BaseActivity> mActivities = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(BaseActivity.this, getResources().getColor(R.color.main_color_lib));
//        StatusBarUtil_2.setSystemUI(BaseActivity.this, false);
//        StatusBarUtil_2.StatusBarLightMode(BaseActivity.this, true);
        synchronized (mActivities) {
            mActivities.add(this);
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initViews(savedInstanceState);
        initDatas();
        clickEvents();
    }

    public static LinkedList<BaseActivity> getActivities() {
        return mActivities;

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
//                    if (deniedPermissions.isEmpty()) {
//                        ipermissions.onGranted();
//                    } else {
//                        ipermissions.onDenied(deniedPermissions);
//                    }
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
        LinkedList<BaseActivity> baseActivities = new LinkedList<>(mActivities);
        for (BaseActivity base : baseActivities) {
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
