package com.example.sangameswaran.sevagan.BackgroundServices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.example.sangameswaran.sevagan.Constants.CommonFunctions;

/**
 * Created by Sangameswaran on 28-02-2018.
 */

public class RequestService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        CommonFunctions.toastString("Service Started",this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
