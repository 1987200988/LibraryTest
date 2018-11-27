package com.example.library.utils.utilslibrary;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.library.R;

import static com.example.library.R.id.btn_nv;


/**
 * Created by Administrator on 2017/4/3.
 */

public class PopUtilsSex {
 private static  PopupWindow pop;
 private static RelativeLayout parent;
 private static LinearLayout ll_popup;
    private SendMessage mSendMessage;
    public static void showSexPup(Activity context, View showAtView, final SendMessage message) {

        if(pop == null) {
            pop = new PopupWindow(context);
            View view = context.getLayoutInflater().inflate(R.layout.edit_sex, null);
            parent = (RelativeLayout)view.findViewById(R.id.parent);
            ll_popup = (LinearLayout)view.findViewById(R.id.ll_popup);
            Button btn_nan = (Button) view.findViewById(R.id.btn_nan);
            Button btn_nv = (Button) view.findViewById(R.id.btn_nv);
            Button btn_cancel = (Button) view.findViewById(R.id.btn_back);
            pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            pop.setBackgroundDrawable(new BitmapDrawable());
            pop.setFocusable(true);
            pop.setOutsideTouchable(true);
            pop.setContentView(view);

            btn_nan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    message.message(0);
                    pop.dismiss();
                    ll_popup.clearAnimation();
                }
            });

            btn_nv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    message.message(1);
                    pop.dismiss();
                    ll_popup.clearAnimation();
                }
            });

            btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    message.message(2);
                    pop.dismiss();
                    ll_popup.clearAnimation();
                }
            });

            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pop.dismiss();
                    ll_popup.clearAnimation();
                }
            });
        }
        ll_popup.startAnimation(AnimationUtils.loadAnimation(context, R.anim.activity_translate_in));
        pop.showAtLocation(showAtView, Gravity.BOTTOM, 0, 0);
    }
  public interface SendMessage{
        void message(int id);

    }

}
