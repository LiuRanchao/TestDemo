package com.liuranchao.testdemo.activity.launch_mode.single_instance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;
import com.liuranchao.testdemo.activity.launch_mode.single_task.SingleTaskSecondActivity;

/**
 * Description: singleInstance启动方式
 *
 * @author liuranchao
 * @date 15/11/16 下午1:26
 */
public class SingleInstanceFirstActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance_first);
        findViewById(R.id.btn_go_second).setOnClickListener(this);

        TextView tvObjData = (TextView) findViewById(R.id.tv_obj_data);

        TextView tvTaskName = (TextView) findViewById(R.id.tv_task_name);

        tvObjData.setText("obj=" + this.toString());

        tvTaskName.setText("Task id=" + getTaskId());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go_second:
                startActivity(new Intent(this, SingleInstanceSecondActivity.class));
                break;
        }
    }
}
