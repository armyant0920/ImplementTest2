package com.example.implementtest.UI;

import android.os.Handler;
import android.os.Message;

/**
 * targetsdk 修改为27之后，在android 7.1.1 7.1.2 系统的手机上
 * 弹toast可能出现badtokenexception....
 *
 * @author jett
 * @since 2018-08-13.
 */
public class WrapperHandler extends Handler {

    private final Handler delegate;

    WrapperHandler(Handler delegate) {
        this.delegate = delegate;
    }

    @Override
    public void handleMessage(Message msg) {
        try {
            delegate.handleMessage(msg);
        } catch (Exception ignore) {
        }
    }
}
