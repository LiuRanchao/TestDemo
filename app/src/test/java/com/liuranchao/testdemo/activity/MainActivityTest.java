package com.liuranchao.testdemo.activity;

import android.app.Activity;
import android.view.Menu;


import com.liuranchao.testdemo.BuildConfig;
import com.liuranchao.testdemo.MainActivity;
import com.liuranchao.testdemo.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;


/**
 * Project Name: TestDemo
 * File Name: MainActivityTest
 * Description: 使用Robolectric单元测试,测试MainActivity
 *
 * @author liuranchao
 * @date 15/10/9 下午5:19
 * Copyright (c) 2015年, My Company Network CO.ltd. All Rights Reserved.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void onCreate_shouldInflateTheMenu() throws Exception {

        Activity activity = Robolectric.setupActivity(MainActivity.class);
        final Menu menu = shadowOf(activity).getOptionsMenu();
        assertThat(menu.findItem(R.id.action_settings).getTitle()).isEqualTo("First menu item");
    }
}
