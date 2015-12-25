package com.liuranchao.testdemo.activity.handler_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;

/**
 * Description: 测试HandlerThread
 *
 * @author liuranchao
 * @date 15/12/24 下午7:21
 */
public class HandlerThreadActivity extends BaseActivity implements View.OnClickListener {

    private HandlerThread mHandlerThread;

    private TextView mTvShow;

    Handler mThreadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        mHandlerThread = new HandlerThread("lrc thread");
        mHandlerThread.start();
        Looper looper = mHandlerThread.getLooper();
        //工作執行緒的經理人並將工作執行緒的循環器傳入(管理工作執行緒的MessageQueue)
        mThreadHandler = new Handler(looper);


        findViewById(R.id.btn_start).setOnClickListener(this);
        mTvShow = (TextView) findViewById(R.id.tv_show);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_start:
                MyRunnable runnable = new MyRunnable(mUIHandler);
                //將runnable傳入工作執行緒的MessageQueue
                mThreadHandler.post(runnable);
                break;
            default:
                break;
        }
    }

    Handler mUIHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                mTvShow.setText(msg.arg1 + "");
            }
        }
    };
}
