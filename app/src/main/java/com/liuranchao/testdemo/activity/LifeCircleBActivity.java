package com.liuranchao.testdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.utils.LogUtil;

public class LifeCircleBActivity extends AppCompatActivity {

    private static final String TAG = "LifeCircleBActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle_b);
        LogUtil.d(TAG, "onCreate");
    }


    /**
     * 被用户可见
     */
    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG, "onStart");
    }

    /**
     * 用户可见
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(TAG, "onRestart");
    }

    /**
     * 用户可见
     */
    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, "onResume");
    }

    /**
     * 用户不可见
     */
    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG, "onPause");
    }

    /**
     * 用户不可见
     */
    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG, "onStop");
    }

    /**
     * 用户不可见
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, "onDestroy");
    }
}
