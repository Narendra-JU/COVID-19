package com.example.covid_19infodemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private Button buttonworldstat;
    private Button buttonindiastat;
    private Button buttonwestbengalstat;
    private Button buttoninfofromwho;

    private AdView mAdView;
    int a=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        buttonworldstat=(Button)findViewById(R.id.worldstat);



        buttonworldstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNetworkAvailable()){

                Intent myIntent = new Intent(v.getContext(), worldstat.class);
                startActivityForResult(myIntent, 0);}
                else{
                    Toast.makeText(MainActivity.this,"You are not connected to the Internet",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonindiastat=(Button)findViewById(R.id.indiastat);



        buttonindiastat.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if(isNetworkAvailable()){

                    Intent myIntent = new Intent(v.getContext(), indiastat.class);
                    startActivityForResult(myIntent, 0);}
                else{
                    Toast.makeText(MainActivity.this,"You are not connected to the Internet",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonwestbengalstat=(Button)findViewById(R.id.westbengalstat);



        buttonwestbengalstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNetworkAvailable()){

                    Intent myIntent = new Intent(v.getContext(), westbengalstat.class);
                    startActivityForResult(myIntent, 0);}
                else{
                    Toast.makeText(MainActivity.this,"You are not connected to the Internet",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttoninfofromwho=(Button)findViewById(R.id.infofromwho);



        buttoninfofromwho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNetworkAvailable()){

                    Intent myIntent = new Intent(v.getContext(), infofromwho.class);
                    startActivityForResult(myIntent, 0);}
                else{
                    Toast.makeText(MainActivity.this,"You are not connected to the Internet",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id== R.id.search){
            Intent myIntent = new Intent(this, aboutme.class);
            startActivityForResult(myIntent, 0);

        }
        return true;

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo!=null && activeNetworkInfo.isConnected();
    }





}














