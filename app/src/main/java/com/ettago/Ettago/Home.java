package com.ettago.Ettago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
private CardView cabs,flights,buses,hotels;
AdView adView,adView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        adView1 = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_home);
        cabs=findViewById(R.id.cabs);
        flights=findViewById(R.id.flights);
        buses=findViewById(R.id.buses);
        hotels=findViewById(R.id.hotels);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.home:

                                return true;
                            case R.id.support:
                                Intent intent2=new Intent(Home.this, Support.class);
                                startActivity(intent2);

                                return true;
                            case R.id.offers:
                                Intent intent1=new Intent(Home.this,Offers.class);
                                startActivity(intent1);

                                return  true;

                            case R.id.aboutus:
                                Intent intent3=new Intent(Home.this,AboutUs.class);
                                startActivity(intent3);
                                return true;
                        }
                        return true;
                    }
                }
        );

        cabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,MainActivity.class);
                intent.putExtra("id","https://book.ettago.com/SearchCabs");
                startActivity(intent);
            }
        });
        flights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent=new Intent(Home.this,MainActivity.class);
intent.putExtra("id","https://book.ettago.com/SearchFlights");
startActivity(intent);
            }
        });
        buses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,MainActivity.class);
                intent.putExtra("id","https://book.ettago.com/SearchBuses");
                startActivity(intent);
            }
        });
        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,MainActivity.class);
                intent.putExtra("id","https://book.ettago.com/SearchHotels");
                startActivity(intent);
            }
        });


        adView = findViewById(R.id.adView);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        adView.loadAd(adRequest1);
    }
}