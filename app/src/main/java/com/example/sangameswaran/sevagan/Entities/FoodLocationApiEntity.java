package com.example.sangameswaran.sevagan.Entities;

import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class FoodLocationApiEntity {
    List<FoodLocationEntity> response;

    public List<FoodLocationEntity> getResponse() {
        return response;
    }

    public FoodLocationApiEntity() {
    }

    public FoodLocationApiEntity(List<FoodLocationEntity> response) {
        this.response = response;
    }

    public void setResponse(List<FoodLocationEntity> response) {
        this.response = response;
    }

    public interface SevaganRestClientInterface{
        public void onGetFoodLocation(FoodLocationApiEntity entity, VolleyError error);
    }
}
