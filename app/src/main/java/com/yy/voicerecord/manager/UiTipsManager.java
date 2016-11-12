package com.yy.voicerecord.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.yy.voicerecord.R;


/**
 * Created by yy on 2016/11/4.
 */

public class UiTipsManager {
    private static UiTipsManager instance;
    private AlertDialog loadingErrorDialog;
    private Toast toast;

    private UiTipsManager(){
    }

    public static UiTipsManager getInstance(){
        if(instance == null){
            instance = new UiTipsManager();
        }
        return instance;
    }

    public void showLoadingErrorDialog(String error,Context context){
        if(loadingErrorDialog != null){
            loadingErrorDialog.dismiss();
        }
        loadingErrorDialog = new AlertDialog.Builder(context)
                .setTitle(R.string.dialog_title_loading_error)
                .setMessage(error)
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loadingErrorDialog.dismiss();
                    }
                })
                .create();
        loadingErrorDialog.show();

    }

    public void showShortToast(final String message, final Context context){
        Looper mLooper = Looper.myLooper();
        if(mLooper == null){//如果当前线程没有call Looper.prepare,说明不在主线程，如果context也不是Activity，那就不能显示toast
            if (context instanceof Activity) {
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(toast != null){
                            toast.cancel();
                        }
                        toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        } else {
            if(toast != null){
                toast.cancel();
            }
            toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
