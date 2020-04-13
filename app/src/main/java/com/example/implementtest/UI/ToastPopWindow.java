package com.example.implementtest.UI;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.Spanned;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.implementtest.R;

import java.lang.reflect.Field;

public class ToastPopWindow {


    protected Context context;
    protected TextView mTitleView;
    private Toast mToast;
    private Handler mHandler = new Handler();
    private int duration = 10*1000;
    private boolean canceled = false;



    public ToastPopWindow(Context context, String text, int duration) {
        this.context = context;
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_toast_popwindow, null);
        mTitleView = (TextView) rootView.findViewById(R.id.view_message);
        mTitleView.setText(text);
        mToast = createToast(context);
        mToast.setView(rootView);
        mToast.setGravity(Gravity.CENTER, 0, 600);
        this.duration = duration;
        mToast.setDuration(10*1000);


        System.out.println("duration"+this.duration);
    }

    /**
     * 重载一个支持一个字符串内文字字体大小颜色不同的特性
     */
    public ToastPopWindow(Context context, Spanned spanned) {
        this.context = context;
        View rootView = LayoutInflater.from(context).inflate(R.layout.view_toast_popwindow, null);
        mTitleView = (TextView) rootView.findViewById(R.id.view_message);
        mTitleView.setText(spanned);
        mToast = createToast(context);
        mToast.setView(rootView);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        //mToast.setDuration(Toast.LENGTH_SHORT);
        System.out.println("another");

    }

    /**
     * targetsdk 修改为27之后，在android 7.1.1 7.1.2 系统的手机上
     * 弹toast可能出现badtokenexception....
     */
    private Toast createToast(Context context) {
        Toast toast = new Toast(context);
//        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.N_MR1) {
//            return toast;
//        }
        try {
            Field tnField = toast.getClass().getDeclaredField("mTN");
            tnField.setAccessible(true);
            Object mTN = tnField.get(toast);
            Field handlerField = mTN.getClass().getDeclaredField("mHandler");
            handlerField.setAccessible(true);
            Handler mHandler = (Handler) handlerField.get(mTN);
            WrapperHandler wrapperHandler = new WrapperHandler(mHandler);
            handlerField.set(mTN, wrapperHandler);
        } catch (Exception e) {

        }
        System.out.println("createToastDuration:"+toast.getDuration());
        return toast;
    }

    private void refreshText(String text) {
        mTitleView.setText(text);
    }

    /**
     * 隐藏pop界面
     */
    public void hidden() {
        if (!canceled) {
            mToast.cancel();
        }
        canceled = true;
    }

    /**
     * 显示pop界面
     */
    public void show() {
        mToast.show();

        mHandler.postDelayed(new Runnable() {


            @Override
            public void run() {
                //的确是10秒后才执行
                hidden();
                System.out.println("执行hide");
            }
        }, duration);
        System.out.println("hiddenTime"+duration);
    }
}
