package com.liuranchao.testdemo;

import android.app.Application;

/**
 * Project Name: TestDemo
 * File Name: MyApplication
 * Description:
 *
 * @author liuranchao
 * @date 15/10/9 下午1:42
 * Copyright (c) 2015年, My Company Network CO.ltd. All Rights Reserved.
 */
public class MyApplication extends Application {

    private static MyApplication sInstance;

    public static MyApplication getInstance() {
        synchronized (MyApplication.class) {
            if (sInstance == null) {
                sInstance = new MyApplication();
            }
        }
        return sInstance;
    }

    private MyApplication() {

    }

}
