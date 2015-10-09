package com.liuranchao.testdemo.utils;

import android.widget.Toast;

import com.liuranchao.testdemo.MyApplication;

/**
 * Project Name: TestDemo
 * File Name: ToastUtil
 * Description: 调用系统的toast
 *
 * @author liuranchao
 * @date 15/10/9 下午1:41
 * Copyright (c) 2015年, My Company Network CO.ltd. All Rights Reserved.
 */
public class ToastUtil {

    /**
     * 显示Toast
     *
     * @param msg Message
     */
    public static void show(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_LONG);
    }
}
