package com.example.library.utils.utilslibrary;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Window;

import com.example.library.utils.loaddialog.CustomProgressDialog;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

/**
 * ================================================
 * 作    者：liwei
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：对于网络请求是否需要弹出进度对话框
 * 修订历史：
 * ================================================
 */
public abstract class DialogCallback extends StringCallback {



    private ProgressDialog dialog;
    private CustomProgressDialog mDia;


    public DialogCallback() {

    }

    private void initDialog(Activity activity) {


//        dialog = new ProgressDialog(activity);
//        dialog.setMessage("请求网络中...");
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        mDia = CustomProgressDialog.show(activity, "正在加载中...", true, null,
                50);


    }

    public DialogCallback(Activity activity) {
        super();
        initDialog(activity);


    }
    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //网络请求前显示对话框
//        if (dialog != null && !dialog.isShowing()) {
//            dialog.show();
//        }
        if(mDia!=null&&!mDia.isShowing()){
            mDia.show();
        }



    }

    @Override
    public void onAfter(String s, Exception e) {
        super.onAfter(s, e);
//        if (dialog != null && dialog.isShowing()) {
//            dialog.dismiss();
//        }
        try{
            if(mDia!=null&&mDia.isShowing()){
                mDia.dismiss();
            }
        }catch (Exception we){
            we.printStackTrace();
        }


    }
}