package com.example.sangameswaran.sevagan.Entities;

import com.android.volley.VolleyError;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class RequestEntity {
    RequestMiniEntity request;
    String phone;
    String threshold;

    public RequestEntity(RequestMiniEntity request,String phone,String threshold) {
        this.request = request;
        this.phone=phone;
        this.threshold=threshold;
    }

    public String getPhone() {
        return phone;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RequestMiniEntity getRequest() {
        return request;
    }

    public void setRequest(RequestMiniEntity request) {
        this.request = request;
    }

    public interface SevaganRestClientInterface{
        public void onRaiseRequest(LocationResponseEntity entity,VolleyError error);
    }
}
