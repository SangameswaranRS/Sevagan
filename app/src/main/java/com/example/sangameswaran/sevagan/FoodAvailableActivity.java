package com.example.sangameswaran.sevagan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.example.sangameswaran.sevagan.Entities.FoodLocationApiEntity;
import com.example.sangameswaran.sevagan.Entities.FoodLocationEntity;
import com.example.sangameswaran.sevagan.RestCalls.RestClientImplementation;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class FoodAvailableActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap map;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_available);
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        MoveAndAnimateCamera(new LatLng(13.011244, 80.231202),10);
        RestClientImplementation.getFoodPointsApi(new FoodLocationApiEntity(), new FoodLocationApiEntity.SevaganRestClientInterface() {
            @Override
            public void onGetFoodLocation(FoodLocationApiEntity entity, VolleyError error) {
                for(FoodLocationEntity e:entity.getResponse()){
                    map.addMarker(new MarkerOptions().position(new LatLng(e.getLatitude(),e.getLongitude())).title(e.getName()));
                }
            }
        },FoodAvailableActivity.this);
    }

    public void MoveAndAnimateCamera(LatLng place,int ZoomLevel) {
        if(map!=null){
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(place, ZoomLevel-1));
            map.animateCamera(CameraUpdateFactory.zoomTo(ZoomLevel), 2000, null);
        }
    }
}
