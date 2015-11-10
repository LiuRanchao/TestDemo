package com.liuranchao.testdemo.activity.file_provider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ExpandableListView;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;
import com.liuranchao.testdemo.adapter.FileProviderExpandableAdapter;
import com.liuranchao.testdemo.utils.LogUtil;

import java.io.File;
import java.io.IOException;


/**
 * Description: 测试FileProvider,配合的见TestDemoClient
 *
 * @author liuranchao
 * @date 15/11/9 下午3:29
 */
public class FileProviderActivity extends BaseActivity implements View.OnClickListener, ExpandableListView.OnChildClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_provider);
        findViewById(R.id.btn_create_internal_file).setOnClickListener(this);
        findViewById(R.id.btn_create_external_file).setOnClickListener(this);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        FileProviderExpandableAdapter adapter = new FileProviderExpandableAdapter(this);

        expandableListView.setOnChildClickListener(this);

        expandableListView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_internal_file:

                createInternalFiles();
                break;

            case R.id.btn_create_external_file:

                createExternalFiles();
                break;
        }
    }

    /**
     * 创建外部文件
     */
    private void createExternalFiles() {
        new Thread() {
            @Override
            public void run() {
                try {
                    String fileDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "files";
                    new File(fileDirPath).mkdir();
                    for (int i = 0; i < 10; i++) {

                        String filePath = fileDirPath + File.separator + "外部文件" + i + ".txt";
                        new File(filePath).createNewFile();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                LogUtil.d(TAG, "createExternalFiles complete");
            }
        }.start();

    }

    /**
     * 创建内部文件
     */
    private void createInternalFiles() {

        new Thread() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 10; i++) {

                        String path = getFilesDir().getAbsoluteFile() + File.separator + "内部文件" + i + ".txt";
                        new File(path).createNewFile();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                LogUtil.d(TAG, "createInternalFiles complete");
            }
        }.start();

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        File file = (File) parent.getExpandableListAdapter().getChild(groupPosition, childPosition);
        Uri fileUri;
        try {
            fileUri = FileProvider.getUriForFile(
                    FileProviderActivity.this,
                    getResources().getString(R.string.fileprovider_authority),
                    file);
            Intent resultIntent = new Intent();
            if (fileUri != null) {
                resultIntent.addFlags(
                        Intent.FLAG_GRANT_READ_URI_PERMISSION);
                // Put the Uri and MIME type in the result Intent
                resultIntent.setDataAndType(
                        fileUri,
                        getContentResolver().getType(fileUri));
                // Set the result
                setResult(Activity.RESULT_OK,
                        resultIntent);
            } else {
                resultIntent.setDataAndType(null, "");
                setResult(RESULT_CANCELED,
                        resultIntent);
            }
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
