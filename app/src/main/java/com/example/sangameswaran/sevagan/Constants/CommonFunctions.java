package com.example.sangameswaran.sevagan.Constants;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.widget.Toast;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by Sangameswaran on 28-02-2018.
 */

public class CommonFunctions {
    public static void toastString(String message, Context context){
        Toast t=Toast.makeText(context,message,Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER,0,0);
        t.show();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
