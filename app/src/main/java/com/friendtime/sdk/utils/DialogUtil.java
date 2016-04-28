package com.friendtime.sdk.utils;

import android.app.Activity;
import android.app.Dialog;

import com.friendtime.sdk.R;

/**
 * Created by wutao on 2016/2/25.
 */
public class DialogUtil {



    /**
     * 普通对话框
     *
     * @param context
     * @return
     */
    public static Dialog getCustomeDilogForNormal(final Activity context) {

        final Dialog dialog = new Dialog(context, R.style.Dialog);
        dialog.setContentView(R.layout.base_dialog);
        return dialog;
    }

    /**
     * 普通对话框
     *
     * @param context
     * @return
     */
    public static Dialog getCustomeDilog(final Activity context) {

        final Dialog dialog = new Dialog(context, R.style.Dialog);
        dialog.setContentView(R.layout.dialog);
        return dialog;
    }
}
