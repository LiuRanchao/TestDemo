package com.liuranchao.testdemo.activity.gson;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;
import com.liuranchao.testdemo.model.gson.Dog;

/**
 * Description:  使用GSON练习
 *
 * @author liuranchao
 * @date 15/11/4 下午11:55
 */
public class GsonActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        mTvShow = (TextView) findViewById(R.id.tv_show);
        findViewById(R.id.btn_create_json_by_object).setOnClickListener(this);
        findViewById(R.id.btn_parse).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_json_by_object:

                createJsonByObject();
                break;
            default:
                break;


        }
    }

    /**
     * 根据对象生成json
     */
    private void createJsonByObject() {

        Gson gson = new Gson();

        Dog dog = new Dog();
        dog.setName("naonao");
        dog.setDogShit("yi tuo");

        String result = gson.toJson(dog);
        mTvShow.setText(result);
    }
}
