package com.liuranchao.testdemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.liuranchao.testdemo.R;

/**
 * Description: Chronometer测试
 *
 * @author liuranchao
 * @date 15/12/17 下午7:17
 */
public class ChronometerActivity extends BaseActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {

    private Chronometer mChronometer;

    private Button mBtnStart, mBtnEnd , mBtnNull;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);
        initView();
    }

    private void initView() {
        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        mChronometer.setOnChronometerTickListener(this);
        mBtnStart =(Button)findViewById(R.id.chronometer_start);
        mBtnEnd =(Button)findViewById(R.id.chronometer_end);
        mBtnNull =(Button)findViewById(R.id.chronometer_null);

        mBtnStart.setOnClickListener(this);
        mBtnEnd.setOnClickListener(this);
        mBtnNull.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chronometer_start:
                mChronometer.start();
                mBtnStart.setText("正在计时...");
                break;
            case R.id.chronometer_end:
                mChronometer.stop();
                mBtnStart.setText("继续计时");
                break;
            case R.id.chronometer_null:
                //调用stop()方法停止计时
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
                mBtnStart.setText("正在计时...");
                break;
            default:
                break;
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        Log.e(TAG, "chronometer.getText()=" + chronometer.getText());
    }
}
