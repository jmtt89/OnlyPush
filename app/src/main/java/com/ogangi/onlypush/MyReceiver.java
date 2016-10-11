package com.ogangi.onlypush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ogangi.messangi.android.sdk.vo.MessageVO;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String json = intent.getStringExtra("message");
        MessageVO message = null;
        try {
            message = MessageVO.fromJson(json);
            // Here you can do anything you want with last received notification, at moment our only print it in console
            NewNotification.notify(context,message,message.hashCode());
            Log.d(TAG, "onReceive: "+message.toString());
        }catch(Exception _e){
            _e.printStackTrace();
            Log.e(TAG, "onReceive: "+ _e.getLocalizedMessage(), _e);
        }
    }
}
