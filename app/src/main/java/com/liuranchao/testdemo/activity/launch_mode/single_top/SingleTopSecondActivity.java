package com.liuranchao.testdemo.activity.launch_mode.single_top;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;

/**
 * Description: singleTop启动方式
 *
 * @author liuranchao
 * @date 15/11/16 下午1:26
 */
public class SingleTopSecondActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top_second);
        findViewById(R.id.btn_go_first).setOnClickListener(this);

        TextView tvObjData = (TextView) findViewById(R.id.tv_obj_data);

        TextView tvTaskName = (TextView) findViewById(R.id.tv_task_name);

        tvObjData.setText("obj=" + this.toString());

        tvTaskName.setText("Task id=" + getTaskId());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go_first:
                startActivity(new Intent(this, SingleTopFirstActivity.class));
                break;
        }
    }
}
