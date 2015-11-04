package com.liuranchao.testdemo.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liuranchao.testdemo.R;

/**
 * 测试AsyncTask
 * @author liuranchao
 */

public class AsyncTaskActivity extends AppCompatActivity {

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
