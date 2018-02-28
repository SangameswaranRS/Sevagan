package com.example.sangameswaran.sevagan;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.sangameswaran.sevagan.BackgroundServices.RequestService;
import com.example.sangameswaran.sevagan.Constants.CommonFunctions;
import com.example.sangameswaran.sevagan.RestCalls.RestClientImplementation;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    Button findBtn;
    Spinner distanceSelectionSpinner;
    private GoogleMap map;
    private FusedLocationProviderClient mFusedLocationClient;
    AlertDialog locationAlert;
    boolean locationPreferenceFlag = false;
    AlertDialog.Builder locationAlertBuilder;
    RadioGroup locationPreferenceSelector;
    LatLng requestLocation;
    List<String> searchRadius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findBtn = (Button) findViewById(R.id.findBtn);
        distanceSelectionSpinner = (Spinner) findViewById(R.id.distanceSelectionSpinner);
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        showLocationAlert();
        searchRadius = new ArrayList<>();
        initSearchRadius();
        distanceSelectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(map!=null && requestLocation!=null) {
                    if (i == 0) {
                            map.clear();
                            map.addMarker(new MarkerOptions().position(requestLocation).title("Request Location"));
                            drawCircle(requestLocation, 800);
                    } else if (i == 1) {
                            map.clear();
                            map.addMarker(new MarkerOptions().position(requestLocation).title("Request Location"));
                            drawCircle(requestLocation, 1500);
                    } else if (i == 2) {
                            map.clear();
                            map.addMarker(new MarkerOptions().position(requestLocation).title("Request Location"));
                            drawCircle(requestLocation, 2000);
                    } else if (i == 3) {
                            map.clear();
                            map.addMarker(new MarkerOptions().position(requestLocation).title("Request Location"));
                            drawCircle(requestLocation, 4000);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonFunctions.toastString("Requesting Donors at the selected Range",MainActivity.this);
                Intent intent = new Intent(MainActivity.this, RequestService.class);
                startService(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            CommonFunctions.toastString("Location Permission Problem", MainActivity.this);
            return;
        }
        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null && !locationPreferenceFlag) {
                    map.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("My Location"));
                    requestLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    drawCircle(requestLocation,800);
                }
            }
        });
    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (map != null && locationPreferenceFlag) {
            map.clear();
            map.addMarker(new MarkerOptions().title("Request Location").position(latLng)).showInfoWindow();
            requestLocation = latLng;
            drawCircle(requestLocation,800);
        }
    }

    public void showLocationAlert() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.location_alert, null);
        locationAlertBuilder = new AlertDialog.Builder(this);
        locationPreferenceSelector = (RadioGroup) dialogView.findViewById(R.id.locationPreferenceSelector);
        locationPreferenceSelector.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rbCurrentLocation) {
                    locationPreferenceFlag = false;
                } else if (i == R.id.rbChooseLocation) {
                    locationPreferenceFlag = true;
                }
            }
        });
        locationAlertBuilder.setView(dialogView);
        locationAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setCancelable(false);
        locationAlertBuilder.show();
    }

    public void initSearchRadius(){
        if(searchRadius != null){
            searchRadius.add("5 Km Radius");
            searchRadius.add("15 Km Radius");
            searchRadius.add("20Km Radius");
            searchRadius.add("Beyond 20 Km");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,searchRadius);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            if(distanceSelectionSpinner != null){
                distanceSelectionSpinner.setAdapter(dataAdapter);
            }
        }
    }

    private void drawCircle(LatLng point,int radius){
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(point);
        circleOptions.radius(radius);
        circleOptions.strokeColor(Color.BLACK);
        circleOptions.fillColor(0x30ff0000);
        circleOptions.strokeWidth(2);
        map.addCircle(circleOptions);

    }
}
