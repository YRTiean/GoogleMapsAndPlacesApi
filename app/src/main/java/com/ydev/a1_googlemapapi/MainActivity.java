package com.ydev.a1_googlemapapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGoogleMapApi, btnGooglePlacesApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogleMapApi = (Button) findViewById(R.id.btn_GoogleMapApi);
        btnGoogleMapApi.setOnClickListener(this);

        btnGooglePlacesApi = (Button) findViewById(R.id.btn_GooglePlacesApi);
        btnGooglePlacesApi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id){

            case R.id.btn_GoogleMapApi:
                intent =  new Intent(this, GoogleMapApiActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_GooglePlacesApi:
                intent =  new Intent(this, GooglePlacesApiActivity.class);
                startActivity(intent);
                break;
        }
    }
}
