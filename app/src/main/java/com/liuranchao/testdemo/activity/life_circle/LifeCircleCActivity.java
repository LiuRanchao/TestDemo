package com.liuranchao.testdemo.activity.life_circle;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.fragment.life_circle.LifeCircleThreeFragment;

/**
 * 测试Fragment的生命周期等
 * three four five
 */
public class LifeCircleCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle_c);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fl_content, new LifeCircleThreeFragment(), "THREE");
        fragmentTransaction.commit();
    }
}
