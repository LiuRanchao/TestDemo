package com.liuranchao.testdemo.activity.custom_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;


/**
 * Description: TODO
 *
 * @author liuranchao
 * @date 16/1/16 下午10:32
 */
public class CustomViewMainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_main);
        findViewById(R.id.btn_double_image_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_double_image_view:
                startActivity(new Intent(this, DoubleImageActivity.class));
                break;
            default:
                break;
        }
    }
}
