package com.liuranchao.testdemo.activity.launch_mode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;
import com.liuranchao.testdemo.activity.launch_mode.single_task.SingleTaskFirstActivity;
import com.liuranchao.testdemo.activity.launch_mode.single_top.SingleTopFirstActivity;
import com.liuranchao.testdemo.activity.launch_mode.standard.StandardFirstActivity;

/**
 * Description: 测试LaunchMode
 *
 * @author liuranchao
 * @date 15/11/16 下午1:16
 */
public class LaunchModelActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);

        findViewById(R.id.btn_standard).setOnClickListener(this);
        findViewById(R.id.btn_single_top).setOnClickListener(this);
        findViewById(R.id.btn_single_task).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_standard:
                startActivity(new Intent(this, StandardFirstActivity.class));
                break;
            case R.id.btn_single_top:
                startActivity(new Intent(this, SingleTopFirstActivity.class));
                break;
            case R.id.btn_single_task:
                startActivity(new Intent(this, SingleTaskFirstActivity.class));
                break;
            default:
                break;
        }
    }
}
