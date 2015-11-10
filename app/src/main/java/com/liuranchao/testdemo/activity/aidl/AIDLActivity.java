package com.liuranchao.testdemo.activity.aidl;

import android.os.Bundle;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;

/**
 * Description: 测试AIDL类,详情见BookService
 *
 * @author liuranchao
 * @date 15/11/10 上午9:29
 */
public class AIDLActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
    }
}
