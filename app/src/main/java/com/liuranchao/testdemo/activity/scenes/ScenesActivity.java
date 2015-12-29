package com.liuranchao.testdemo.activity.scenes;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;

/**
 * Description: Scenes练习
 * todo 没跑起来
 *
 * @author liuranchao
 * @date 15/12/28 下午4:31
 */
public class ScenesActivity extends BaseActivity implements View.OnClickListener {

    private ViewGroup mSceneRoot;


    private Scene mAScene;

    private Scene mAnotherScene;

    private Transition mFadeTransition;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);

        findViewById(R.id.btn_change).setOnClickListener(this);
        mSceneRoot = (ViewGroup) findViewById(R.id.fl_scene_root);

        // Create the scenes
        mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scenes_a, this);
        mAnotherScene =
                Scene.getSceneForLayout(mSceneRoot, R.layout.scenes_anther, this);

        mFadeTransition =
                TransitionInflater.from(this).
                        inflateTransition(R.transition.fade_transition);

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change:
                TransitionManager.go(mAnotherScene, mFadeTransition);
                break;
            default:
                break;
        }
    }
}
