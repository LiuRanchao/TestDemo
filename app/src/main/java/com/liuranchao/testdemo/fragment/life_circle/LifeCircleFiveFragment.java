package com.liuranchao.testdemo.fragment.life_circle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.utils.ToastUtil;

/**
 * Project Name: TestDemo
 * File Name: LifeCircleFiveFragment
 * Description: TODO
 *
 * @author liuranchao
 * @date 15/10/9 下午1:38
 * Copyright (c) 2015年, My Company Network CO.ltd. All Rights Reserved.
 */
public class LifeCircleFiveFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_life_circle_five, container, false);
        view.findViewById(R.id.btn_forward_fragment_five).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ToastUtil.show("这是 LifeCircleFiveFragment");
    }
}
