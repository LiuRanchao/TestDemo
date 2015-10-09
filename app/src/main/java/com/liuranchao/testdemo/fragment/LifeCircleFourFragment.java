package com.liuranchao.testdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuranchao.testdemo.R;

/**
 * Project Name: TestDemo
 * File Name: LifeCircleFourFragment
 * Description: 测试Fragment
 *
 * @author liuranchao
 * @date 15/10/9 上午11:09
 * Copyright (c) 2015年, My Company Network CO.ltd. All Rights Reserved.
 */
public class LifeCircleFourFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_life_circle_four, container, false);
        view.findViewById(R.id.btn_forward_fragment_five).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        LifeCircleFiveFragment fragment = new LifeCircleFiveFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(this);
        fragmentTransaction.add(R.id.fl_content, fragment, "FIVE");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
