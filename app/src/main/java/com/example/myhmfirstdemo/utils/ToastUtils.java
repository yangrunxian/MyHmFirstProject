package com.example.myhmfirstdemo.utils;

import ohos.app.Context;

public class ToastUtils {
    public static void showTips(Context context, String content) {
        Toast.makeToast(context, content, Toast.TOAST_SHORT).show();
    }
}
