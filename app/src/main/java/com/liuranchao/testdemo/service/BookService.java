package com.liuranchao.testdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.liuranchao.testdemo.aidl.IBook;

/**
 * Description: AIDL服务
 *
 * @author liuranchao
 * @date 15/11/10 上午10:00
 */
public class BookService extends Service{

    private String[] bookNames = {"Java编程思想","设计模式","Android开发设计"};

    private IBinder mIBinder = new BookBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    public String queryBookName(int bookNo) {
        if (bookNo > 0 && bookNo <= bookNames.length) {
            return bookNames[bookNo - 1];
        }
        return null;
    }


    private class BookBinder extends IBook.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String queryBook(int bookNo) throws RemoteException {
            return queryBookName(bookNo);
        }

    }
}
