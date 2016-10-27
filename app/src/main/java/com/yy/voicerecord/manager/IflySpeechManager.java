package com.yy.voicerecord.manager;

import android.content.Context;

import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;
import com.yy.voicerecord.Util.Const;

/**
 * Created by yy on 2016/10/26.
 */

public class IflySpeechManager {

    private static IflySpeechManager instance;
    private Context context;
    private SpeechRecognizer mIat;

    private IflySpeechManager(Context context){
        this.context = context;
        initSpeechRecognizer();
    }

    public static IflySpeechManager getInstance(Context context){
        if(instance == null){
            instance = new IflySpeechManager(context);
        }
        return instance;
    }

    public void init(){
        SpeechUtility.createUtility(context, SpeechConstant.APPID +"="+ Const.IFLY_APPID);
    }

    private void initSpeechRecognizer(){
        mIat= SpeechRecognizer.createRecognizer(context, null);
        //2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
        mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");
    }

    public void startSpeech(RecognizerListener mRecoListener){
        mIat.startListening(mRecoListener);
    }

}
