package com.liuranchao.testdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.igexin.sdk.PushConsts;
import com.liuranchao.testdemo.utils.LogUtil;

/**
 * Description: 推送的接收器
 *
 * @author liuranchao
 * @date 15/11/2 下午1:58
 */
public class PushReceiver extends BroadcastReceiver {

    private static final  String TAG = "PushReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        int action = bundle.getInt(PushConsts.CMD_ACTION);

        switch (action) {
            case PushConsts.GET_MSG_DATA:
                // 获取透传数据
                // String appid = bundle.getString("appid");
                byte[] payload = bundle.getByteArray("payload");

                String taskid = bundle.getString("taskid");
                String messageid = bundle.getString("messageid");
                LogUtil.d(TAG, "payload===" + payload);
                LogUtil.d(TAG, "taskid===" + taskid);
                LogUtil.d(TAG, "messageid===" + messageid);

                break;

            case PushConsts.GET_CLIENTID:
                String cid = bundle.getString("clientid");
                LogUtil.d(TAG, "cid===" + cid);
                break;

            default:
                break;
        }
    }
}
