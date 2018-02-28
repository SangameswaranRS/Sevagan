package com.example.sangameswaran.sevagan.RestCalls;

import com.android.volley.RequestQueue;
import com.example.sangameswaran.sevagan.Constants.Constants;

/**
 * Created by Sangameswaran on 28-02-2018.
 */

public class RestClientImplementation {
    static RequestQueue queue;

    public static String getAbsoluteURL(String relativeURL){
        return Constants.BASE_URL+relativeURL;
    }



}
