package com.liuranchao.testdemo.activity.life_circle;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.fragment.life_circle.LifeCircleFragment;
import com.liuranchao.testdemo.fragment.life_circle.LifeCircleOneFragment;
import com.liuranchao.testdemo.fragment.life_circle.LifeCircleTwoFragment;
import com.liuranchao.testdemo.utils.LogUtil;

/**
 *
 */
public class LifeCircleBActivity extends AppCompatActivity implements LifeCircleFragment.OnFragmentInteractionListener, View.OnClickListener {

    private static final String TAG = "LifeCircleBActivity";

    private FragmentManager mFragmentManager;

    private Fragment mFragmentOne;

    private Fragment mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle_b);
        LogUtil.d(TAG, "onCreate");


        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);

        mFragmentOne = new LifeCircleOneFragment();
        mFragmentTwo = new LifeCircleTwoFragment();

        setDefaultFragment();

    }

    private void setDefaultFragment() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, mFragmentOne);
        transaction.commit();

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
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();


        switch (v.getId()) {
            case R.id.btn_one:
                transaction.replace(R.id.fl_content, mFragmentOne);
                break;
            case R.id.btn_two:
                transaction.replace(R.id.fl_content, mFragmentTwo);
                break;
            default:
                break;

        }
        transaction.commit();
    }
}
