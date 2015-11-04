package com.liuranchao.testdemo.activity.async_task;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;
import com.liuranchao.testdemo.utils.LogUtil;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 测试AsyncTask
 * 注意不能在非main thread中调用
 * @author liuranchao
 */

public class AsyncTaskActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 输出结果的TextView
     */
    private TextView mTvResult;

    /**
     * 加载文件地址
     */
    private static final String URL_ADDRESS = "http://h.hiphotos.baidu.com/baike/w%3D268/sign=ac2fd0baad64034f0fcdc50097c27980/86d6277f9e2f0708cfec3467ef24b899a801f2e8.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        findViewById(R.id.btn_start).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_start:
                new MyAsyncTask().execute("a");
                break;
            default:
                break;
        }
    }

    /**
     * async task
     */
    private class MyAsyncTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            mTvResult.setText("onPreExecute...");
            LogUtil.d(TAG, "onPreExecute...");
        }

        @Override
        protected String doInBackground(String... params) {
            LogUtil.d(TAG, "doInBackground..." + params);
            try {

                URL url = new java.net.URL(URL_ADDRESS);
                HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                //设置输入和输出流
                urlConn.setDoOutput(true);
                urlConn.setDoInput(true);

                InputStream is = urlConn.getInputStream();
                long total = urlConn.getContentLength();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int count = 0;
                int length = -1;
                while ((length = is.read(buf)) != -1) {
                    baos.write(buf, 0, length);
                    count += length;
                    //调用publishProgress公布进度,最后onProgressUpdate方法将被执行
                    publishProgress((int) ((count / (float) total) * 100));
                    //为了演示进度,休眠500毫秒
                    Thread.sleep(500);
                }
                return new String(baos.toByteArray(), "gb2312");
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            LogUtil.d(TAG, "onProgressUpdate..." + values);
        }

        @Override
        protected void onCancelled() {
            LogUtil.d(TAG, "onCancelled...");
        }

        @Override
        protected void onPostExecute(String s) {
            LogUtil.d(TAG, "onPostExecute..." + s);
        }
    }
}
