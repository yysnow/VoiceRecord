package com.yy.voicerecord;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.yy.voicerecord.Util.Const;
import com.yy.voicerecord.manager.IflySpeechManager;

/**
 * Created by yy on 2016/10/26.
 */

public class VRApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        IflySpeechManager.getInstance(this).init();
    }
}
