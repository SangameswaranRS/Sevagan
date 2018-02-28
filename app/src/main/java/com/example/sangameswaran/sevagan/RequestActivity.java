package com.example.sangameswaran.sevagan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sangameswaran on 01-03-2018.
 */

public class RequestActivity extends AppCompatActivity{

    Spinner bloodGroupSpinnerRequest,paceSelectioSpinner;
    EditText etPatientName,etUnitsRequired,fallbackLocation,etContactNum;
    Button proceedBtn;
    List<String> bloodGroupEntries;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        bloodGroupEntries = new ArrayList<>();
        bloodGroupEntries.add("O+");
        bloodGroupEntries.add("O-");
        bloodGroupEntries.add("A+");
        bloodGroupEntries.add("A-");
        bloodGroupEntries.add("AB+");
        bloodGroupEntries.add("AB-");
        bloodGroupEntries.add("B+");
        bloodGroupEntries.add("B-");
        ArrayAdapter<String> bloodGroupDataAdapter = new ArrayAdapter<String>(RequestActivity.this,android.R.layout.simple_spinner_item,bloodGroupEntries);
        bloodGroupDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinnerRequest=(Spinner) findViewById(R.id.bloodGroupSpinnerRequest);
        bloodGroupSpinnerRequest.setAdapter(bloodGroupDataAdapter);
        etPatientName=(EditText) findViewById(R.id.etPatientName);
        etUnitsRequired=(EditText) findViewById(R.id.etUnitsRequired);
        paceSelectioSpinner=(Spinner) findViewById(R.id.paceSelectioSpinner);
        fallbackLocation=(EditText)findViewById(R.id.fallbackLocation);
        etContactNum=(EditText) findViewById(R.id.etContactNum);
        proceedBtn=(Button) findViewById(R.id.proceedBtn);
        ArrayAdapter<String> paceAdapter;
        List<String> pace = new ArrayList<>();
        pace.add("Urgent");
        pace.add("Normal");
        paceAdapter = new ArrayAdapter<String>(RequestActivity.this,android.R.layout.simple_spinner_item,pace);
        paceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paceSelectioSpinner.setAdapter(paceAdapter);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestActivity.this,MainActivity.class);
                intent.putExtra("bloodGroup",bloodGroupSpinnerRequest.getSelectedItemPosition()+1);
                intent.putExtra("patientName",etPatientName.getText().toString());
                intent.putExtra("unitsRequired",etUnitsRequired.getText().toString());
                intent.putExtra("fallbackLocation",fallbackLocation.getText().toString());
                intent.putExtra("contactNumber",etContactNum.getText().toString());
                intent.putExtra("pace",paceSelectioSpinner.getSelectedItemPosition()+1);
                startActivity(intent);
            }
        });
    }
}
