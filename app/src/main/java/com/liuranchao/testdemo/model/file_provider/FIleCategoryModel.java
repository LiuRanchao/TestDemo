package com.liuranchao.testdemo.model.file_provider;

import com.liuranchao.testdemo.model.BaseModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author liuranchao
 * @date 15/11/9 下午10:45
 */
public class FIleCategoryModel implements BaseModel{

    /**
     * 类别名
     */
    private String mName;

    /**
     * 类别包含哪些文件
     */
    private List<File> mFileList = new ArrayList<>();

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<File> getFileList() {
        return mFileList;
    }

    public void setFileList(List<File> fileList) {
        mFileList = fileList;
    }
}
