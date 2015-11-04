package com.liuranchao.testdemo.fragment.life_circle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.liuranchao.testdemo.R;

/**
 * Project Name: TestDemo
 * File Name: LifeCircleThreeFragment
 * Description: 测试Fragment
 *
 * @author liuranchao
 * @date 15/10/9 上午10:58
 * Copyright (c) 2015年, My Company Network CO.ltd. All Rights Reserved.
 */
public class LifeCircleThreeFragment extends Fragment implements View.OnClickListener {

    private Button mBtnForward;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life_circle_three, container, false);
        mBtnForward = (Button) view.findViewById(R.id.btn_forward_fragment_four);
        mBtnForward.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_forward_fragment_four:
                LifeCircleFourFragment fourFragment = new LifeCircleFourFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fl_content, fourFragment, "FOUR");
                ft.addToBackStack(null);
                ft.commit();
                break;
        }
    }
}
