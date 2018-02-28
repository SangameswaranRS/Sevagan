package com.example.sangameswaran.sevagan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.VolleyError;
import com.example.sangameswaran.sevagan.Constants.CommonFunctions;
import com.example.sangameswaran.sevagan.Entities.DonorRegistrationActualEntity;
import com.example.sangameswaran.sevagan.Entities.DonorRegistrationEntity;
import com.example.sangameswaran.sevagan.RestCalls.RestClientImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sangameswaran on 28-02-2018.
 */

public class RegistrationActivity extends AppCompatActivity {

    EditText etName,etAge,etWeight,etEmailId,etPassword,etLocationString,etAddressString,etPhone;
    Spinner bloodGroupSpinner,PreferencePeriodSpinner,genderSelectionSpinner;
    List<String> bloodGroupEntries,preferencePeriodEntries,genderEntry;
    Button btnRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bloodGroupEntries = new ArrayList<>();
        preferencePeriodEntries = new ArrayList<>();
        bloodGroupEntries.add("O+");
        bloodGroupEntries.add("O-");
        bloodGroupEntries.add("A+");
        bloodGroupEntries.add("A-");
        genderEntry = new ArrayList<>();
        genderEntry.add("Male");
        genderEntry.add("Female");
        genderEntry.add("Others");
        bloodGroupEntries.add("AB+");
        bloodGroupEntries.add("AB-");
        bloodGroupEntries.add("B+");
        bloodGroupEntries.add("B-");
        preferencePeriodEntries.add("3 month");
        preferencePeriodEntries.add("6 month");
        preferencePeriodEntries.add("12 month");
        genderSelectionSpinner= (Spinner) findViewById(R.id.genderSelectionSpinner);
        etName = (EditText)findViewById(R.id.etName);
        etAge = (EditText)findViewById(R.id.etAge);
        etWeight = (EditText)findViewById(R.id.etWeight);
        etEmailId = (EditText)findViewById(R.id.etEmailId);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone=(EditText) findViewById(R.id.etPhone);
        etLocationString = (EditText) findViewById(R.id.etLocationString);
        etAddressString = (EditText) findViewById(R.id.etAddressString);
        bloodGroupSpinner = (Spinner) findViewById(R.id.bloodGroupSpinner);
        PreferencePeriodSpinner= (Spinner) findViewById(R.id.PreferencePeriodSpinner);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        ArrayAdapter<String> bloodGroupDataAdapter = new ArrayAdapter<String>(RegistrationActivity.this,android.R.layout.simple_spinner_item,bloodGroupEntries);
        bloodGroupDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(bloodGroupDataAdapter);
        ArrayAdapter<String> preferenceDataAdapter = new ArrayAdapter<String>(RegistrationActivity.this,android.R.layout.simple_spinner_item,preferencePeriodEntries);
        preferenceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PreferencePeriodSpinner.setAdapter(preferenceDataAdapter);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(RegistrationActivity.this,android.R.layout.simple_spinner_item,genderEntry);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSelectionSpinner.setAdapter(genderAdapter);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DonorRegistrationEntity entity = new DonorRegistrationEntity();
                entity.setAddress(etAddressString.getText().toString());
                entity.setAge(etAge.getText().toString());
                entity.setEmail(etEmailId.getText().toString());
                entity.setName(etName.getText().toString());
                entity.setLocation(etLocationString.getText().toString());
                entity.setWeight(etWeight.getText().toString());
                entity.setPassword(etPassword.getText().toString());
                entity.setBloodgroup(bloodGroupSpinner.getSelectedItemPosition()+1);
                entity.setPeriod(PreferencePeriodSpinner.getSelectedItemPosition()+1);
                entity.setGender(genderSelectionSpinner.getSelectedItemPosition()+1);
                entity.setPhone(etPhone.getText().toString());
                DonorRegistrationActualEntity entity1 = new DonorRegistrationActualEntity();
                entity1.setDonor(entity);
                RestClientImplementation.registerDonorApi(entity1, new DonorRegistrationEntity.SevaganRestClientInterface() {
                    @Override
                    public void onRegisterEntitySubmit(DonorRegistrationActualEntity entity, VolleyError error) {
                        if(error ==null){
                            CommonFunctions.toastString("Donor Registered",RegistrationActivity.this);
                        }
                    }
                },RegistrationActivity.this);
            }
        });
    }
}
