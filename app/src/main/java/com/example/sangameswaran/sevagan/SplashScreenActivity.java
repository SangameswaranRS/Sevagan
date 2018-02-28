package com.example.sangameswaran.sevagan;

import android.*;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

/**
 * Created by Sangameswaran on 28-02-2018.
 */

public class SplashScreenActivity extends AppCompatActivity {
    AlertDialog.Builder permissionChecker;
    RelativeLayout drf,rbf,fsf;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        rbf=(RelativeLayout) findViewById(R.id.rbf);
        drf=(RelativeLayout) findViewById(R.id.drf);
        fsf=(RelativeLayout) findViewById(R.id.fsf);
        askRequiredPermissionsForApplication();
        rbf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(SplashScreenActivity.this,RequestActivity.class);
                startActivity(intent);
            }
        });
        drf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashScreenActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
        fsf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashScreenActivity.this,FoodAvailableActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean askRequiredPermissionsForApplication()
    {
        Dexter.withActivity(this).withPermissions(android.Manifest.permission.READ_PHONE_STATE,android.Manifest.permission.CALL_PHONE,android.Manifest.permission.SEND_SMS, Manifest.permission.ACCESS_COARSE_LOCATION).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if(report.areAllPermissionsGranted()){
                    /*Intent intent = new Intent(SplashScreenActivity.this,RequestActivity.class);
                    startActivity(intent);*/
                }
                else {
                    permissionChecker=new AlertDialog.Builder(SplashScreenActivity.this);
                    permissionChecker.setTitle("Permission check Error").setMessage("Enable All permissions to use application").setCancelable(false).setPositiveButton("CLOSE APP", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SplashScreenActivity.this.finishAffinity();
                        }
                    }).show();
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).withErrorListener(new PermissionRequestErrorListener() {
            @Override
            public void onError(DexterError error) {
                Toast.makeText(getApplicationContext(),"DexterError",Toast.LENGTH_LONG).show();
            }
        }).onSameThread().check();
        return true;
    }

}
