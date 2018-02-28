package com.example.sangameswaran.sevagan.RestCalls;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.sangameswaran.sevagan.Constants.CommonFunctions;
import com.example.sangameswaran.sevagan.Constants.Constants;
import com.example.sangameswaran.sevagan.Entities.DonorRegistrationActualEntity;
import com.example.sangameswaran.sevagan.Entities.DonorRegistrationEntity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sangameswaran on 28-02-2018.
 */

public class RestClientImplementation {
    static RequestQueue queue;

    public static String getAbsoluteURL(String relativeURL){
        return Constants.BASE_URL+relativeURL;
    }

    public static void registerDonorApi(final DonorRegistrationActualEntity entity, final DonorRegistrationEntity.SevaganRestClientInterface sevaganRestClientInterface, final Context context){
        String API_URL="http://192.168.137.230:1111/user/donor/register";
        queue= VolleySingleton.getInstance(context).getRequestQueue();
        Gson gson=new Gson();
        String jsonString=gson.toJson(entity);
        try {
            JSONObject postParams= new JSONObject(jsonString);
            JsonBaseRequest postRequest= new JsonBaseRequest(Request.Method.POST, API_URL, postParams, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                        sevaganRestClientInterface.onRegisterEntitySubmit(entity,null);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    CommonFunctions.toastString("Something went wrong..",context);
                }
            });
            queue.add(postRequest);
        } catch (JSONException e) {
            CommonFunctions.toastString(e.getMessage(),context);
            e.printStackTrace();
        }
    }


}
