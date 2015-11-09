package com.liuranchao.testdemo.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.liuranchao.testdemo.R;
import com.liuranchao.testdemo.model.file_provider.FIleCategoryModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 文件共享的adapter
 *
 * @author liuranchao
 * @date 15/11/9 下午10:39
 */
public class FileProviderExpandableAdapter extends BaseExpandableListAdapter {

    private Context mContext;

    private final LayoutInflater mLayoutInflater;

    private List<FIleCategoryModel> mGroupFile;


    public FileProviderExpandableAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mGroupFile = new ArrayList<>();

        FIleCategoryModel categoryExternalModel = new FIleCategoryModel();
        categoryExternalModel.setName("外部文件");
        categoryExternalModel.setFileList(getExternalStorage());

        FIleCategoryModel categoryInternalModel = new FIleCategoryModel();
        categoryInternalModel.setName("内部文件");
        categoryInternalModel.setFileList(getInternalStorage());

        mGroupFile.add(categoryExternalModel);
        mGroupFile.add(categoryInternalModel);
    }

    private List<File> getExternalStorage() {
        String fileDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "files";
        File dirFile = new File(fileDirPath);
        File[] files = dirFile.listFiles();
        return Arrays.asList(files);
    }

    private List<File> getInternalStorage() {
        File dirFile = mContext.getFilesDir().getAbsoluteFile();
        return Arrays.asList(dirFile.listFiles());
    }

    @Override
    public int getGroupCount() {
        return mGroupFile.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroupFile.get(groupPosition).getFileList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupFile.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroupFile.get(groupPosition).getFileList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_group_view, parent, false);
        }

        TextView textViewName = (TextView) convertView.findViewById(R.id.tv_group_name);


        textViewName.setText(mGroupFile.get(groupPosition).getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_child_view, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvSize = (TextView) convertView.findViewById(R.id.tv_size);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_date);

        File file = mGroupFile.get(groupPosition).getFileList().get(childPosition);

        tvName.setText(file.getName());

        tvSize.setText(String.valueOf(file.length()));

        tvDate.setText(file.lastModified() + "");

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
