package com.liuranchao.testdemo.activity.async_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;

/**
 * 测试AsyncTask
 * @author liuranchao
 */

public class AsyncTaskActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                return null;
            }
        };

        asyncTask.execute("");
    }
}
