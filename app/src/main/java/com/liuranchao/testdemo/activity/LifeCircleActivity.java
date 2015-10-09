package com.liuranchao.testdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.utils.LogUtil;

/**
 * 测试生命周期
 * <p/>
 * 正常启动的生命周期流程
 * onCreate -> onStart -> onResume -> onPause -> onStop -> onDestroy
 * <p/>
 * 按下Home的生命周期
 * onPause -> onStop
 * <p/>
 * Home返回的生命周期
 * onRestart -> onStart -> onResume
 * <p/>
 * 跳转到其他Activity的生命周期
 * A:onPause -> B:onCreate -> B:onStart -> B:onResume -> A:onStop
 * B:onPause -> A:onRestart -> A:onStart -> A:onResume -> B:onStop -> B:onDestroy
 */
public class LifeCircleActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LifeCircleActivity";

    /**
     * 用户不可见
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle);

        findViewById(R.id.btn_forward_b).setOnClickListener(this);
        findViewById(R.id.btn_forward_c).setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_forward_b:
                startActivity(new Intent(this, LifeCircleBActivity.class));
                break;
            case R.id.btn_forward_c:
                startActivity(new Intent(this, LifeCircleCActivity.class));
                break;
            default:
                break;
        }
    }
}
