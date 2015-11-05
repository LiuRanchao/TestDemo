package com.liuranchao.testdemo.activity.list_adapter;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.activity.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: SimpleAdapter的测试
 *
 * @author liuranchao
 * @date 15/11/5 上午11:29
 */
public class SimpleAdapterActivity extends BaseActivity {

    private String[] name = {"剑萧舞蝶", "张三", "hello", "诗情画意"};

    private String[] desc = {"魔域玩家", "百家执行", "高级的富一代", "妹子请过来..一个善于跑妹子的。。"};

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        List<Map<String, Object>> listems = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<>();
            listem.put("name", name[i]);
            listem.put("desc", desc[i]);
            listems.add(listem);
        }
        /*SimpleAdapter的参数说明
         * 第一个参数 表示访问整个android应用程序接口，基本上所有的组件都需要
         * 第二个参数表示生成一个Map(String ,Object)列表选项
         * 第三个参数表示界面布局的id  表示该文件作为列表项的组件
         * 第四个参数表示该Map对象的哪些key对应value来生成列表项
         * 第五个参数表示来填充的组件 Map对象key对应的资源一依次填充组件 顺序有对应关系
         * 注意的是map对象可以key可以找不到 但组件的必须要有资源填充  因为 找不到key也会返回null 其实就相当于给了一个null资源
         * 下面的程序中如果 new String[] { "name", "head", "desc","name" } new int[] {R.id.name,R.id.head,R.id.desc,R.id.head}
         * 这个head的组件会被name资源覆盖
         * */
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.item_simple_adapter, new String[]{"name", "desc"},
                new int[]{R.id.name, R.id.desc});

        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(simplead);
    }
}
