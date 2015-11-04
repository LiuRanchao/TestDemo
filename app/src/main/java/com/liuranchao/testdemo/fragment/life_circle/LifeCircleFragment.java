package com.liuranchao.testdemo.fragment.life_circle;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.utils.LogUtil;


/**
 * 正常启动顺序
 * LifeCircleActivity启动LifeCircleBActivity（包含LifeCircleFragment）
 10-08 21:42:39.281 18177-18177/com.liuranchao.testdemo D/LifeCircleActivity: onCreate
 10-08 21:42:39.281 18177-18177/com.liuranchao.testdemo D/LifeCircleActivity: onStart
 10-08 21:42:39.281 18177-18177/com.liuranchao.testdemo D/LifeCircleActivity: onResume
 10-08 21:42:50.437 18177-18177/com.liuranchao.testdemo D/LifeCircleActivity: onPause
 10-08 21:42:50.459 18177-18177/com.liuranchao.testdemo D/LifeCircleFragment: onAttach
 10-08 21:42:50.459 18177-18177/com.liuranchao.testdemo D/LifeCircleFragment: onCreate
 10-08 21:42:50.460 18177-18177/com.liuranchao.testdemo D/LifeCircleFragment: onCreateView
 10-08 21:42:50.460 18177-18177/com.liuranchao.testdemo D/LifeCircleBActivity: onCreate
 10-08 21:42:50.460 18177-18177/com.liuranchao.testdemo D/LifeCircleFragment: onActivityCreated
 10-08 21:42:50.460 18177-18177/com.liuranchao.testdemo D/LifeCircleFragment: onStart
 10-08 21:42:50.460 18177-18177/com.liuranchao.testdemo D/LifeCircleBActivity: onStart
 10-08 21:42:50.460 18177-18177/com.liuranchao.testdemo D/LifeCircleBActivity: onResume
 10-08 21:42:50.461 18177-18177/com.liuranchao.testdemo D/LifeCircleFragment: onResume
 10-08 21:42:50.984 18177-18177/com.liuranchao.testdemo D/LifeCircleActivity: onStop
 *
 */
public class LifeCircleFragment extends Fragment {

    private static final String TAG = "LifeCircleFragment";

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LifeCircleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LifeCircleFragment newInstance(String param1, String param2) {
        LifeCircleFragment fragment = new LifeCircleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public LifeCircleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, "onCreate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * 创建该Fragment的视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogUtil.d(TAG, "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life_circle, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /**
     * 当Fragment与Activity发生关联时调用。
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        LogUtil.d(TAG, "onAttach");
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * 当Activity的onCreate方法返回时调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.d(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.d(TAG, "onStop");
    }

    /**
     * 与onCreateView想对应，当该Fragment的视图被移除时调用
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, "onDestroy");
    }

    /**
     * 与onAttach相对应，当Fragment与Activity关联被取消时调用
     */
    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.d(TAG, "onDetach");
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
