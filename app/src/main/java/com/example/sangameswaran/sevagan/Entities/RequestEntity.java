package com.example.sangameswaran.sevagan.Entities;

import com.android.volley.VolleyError;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class RequestEntity {
    RequestMiniEntity request;

    public RequestEntity(RequestMiniEntity request) {
        this.request = request;
    }

    public RequestMiniEntity getRequest() {
        return request;
    }

    public void setRequest(RequestMiniEntity request) {
        this.request = request;
    }

    public interface SevaganRestClientInterface{
        public void onRaiseRequest(VolleyError error);
    }
}
