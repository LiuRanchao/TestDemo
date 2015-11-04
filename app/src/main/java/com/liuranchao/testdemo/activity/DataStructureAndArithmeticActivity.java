package com.liuranchao.testdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.liuranchao.testdemo.R;

/**
 * 数据结构和算法练习
 */
public class DataStructureAndArithmeticActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mEditTextSearchKey;

    private TextView mTextViewShow;

    private int nElems; //number of data items

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_structure_and_arithmetic);

        initView();
    }

    private void initView() {

        mEditTextSearchKey = (EditText) findViewById(R.id.et_search_key);
        mTextViewShow = (TextView) findViewById(R.id.tv_show);
        findViewById(R.id.btn_2_find).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String resultStr = "";
        switch (v.getId()) {
            case R.id.btn_2_find:

                resultStr = String.valueOf(twoFind(Long.parseLong(mEditTextSearchKey.getText().toString())));
                break;
            default:
                break;
        }

        mTextViewShow.setText(resultStr);
    }


    /**
     *
     */
    private long twoFind(long searchKey) {

        int lowerBound = 0;
        int upperBound = nElems - 1;

        int curIn;

        while (true) {


        }


    }
}
