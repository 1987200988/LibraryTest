package com.example.library.utils.loaddialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.library.R;

import java.util.HashMap;

/**
 * @author http://blog.csdn.net/finddreams
 * @Description:自定义对话框
 */
public class CustomProgressDialog extends Dialog {

    private AnimationDrawable mAnimation;
    private Context mContext;
    private ImageView mImageView;
    private String mLoadingTip;
    private TextView mLoadingTv;

    private LinearLayout Dialog_Linear;
    private TextView Dialog_TopTv;
    private RelativeLayout Dialog_Relative;


    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;

        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
    }

    /**
     * 当窗口焦点改变时调用
     */
    public void onWindowFocusChanged(boolean hasFocus) {
        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        // 获取ImageView上的动画背景
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        // 开始动画
        spinner.start();
    }

    /**
     * 给Dialog设置提示信息
     *
     * @param message
     */
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.message);
            txt.setText(message);
            txt.invalidate();
        }
    }

    /**
     * 弹出自定义ProgressDialog
     *
     * @param context        上下文
     * @param message        提示
     * @param cancelable     是否按返回键取消
     * @param cancelListener 按下返回键监听
     * @return
     */
    public static CustomProgressDialog show(Context context, CharSequence message, boolean cancelable,
                                            OnCancelListener cancelListener, int paddingTop) {
        CustomProgressDialog dialog = new CustomProgressDialog(context, R.style.dialog_no_phone);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_dialog);
       /* if (message == null || message.length() == 0) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            //TextView txt = (TextView) dialog.findViewById(R.id.message);
            // if (!TextUtils.isEmpty(message))
            // txt.setText(message);
        }*/
        // 按返回键是否取消
        dialog.setCancelable(cancelable);
        // 监听返回键处理
        dialog.setOnCancelListener(cancelListener);
        // 设置居中
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        map = Util.getScreen((Activity) context);
        /*
         * lp.height = map.get("screenHeight") - preferences.getInt("height", 0)
		 * - paddingTop; lp.width = map.get("screenWidth");
		 */

        // 设置背景层透明度
        lp.dimAmount = 0.0f;
        // lp.verticalMargin = preferences.getInt("height", 0) + paddingTop;
        dialog.getWindow().setAttributes(lp);
        // dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        return dialog;
    }
}
