package com.aditya.touristguide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    private static final String TAG="TourGuide";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isLocationPermissionGranted();
        final String product[]={"RED FORT","QUTB MINAR","HUMAYUN'S TOMB","INDIA GATE","JAMA MASJID","LOTUS TEMPLE","AKSHARDHAM","PURANA QUILA","RAJGHAT","JANTAR MANTAR",
                "BANGLA SAHIB","NATIONAL MUSEUM","AGRASEN KI BAOLI"};
        listView=(ListView)findViewById(R.id.listview);
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.listitem,R.id.productname,product);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Red_Fort.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), Qutb_Minar.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(),Humayun_Tomb.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), India_Gate.class);
                    startActivity(intent);
                }
                else if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(),Jama_Masjid.class);
                    startActivity(intent);
                }
                else if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), Lotus_Temple.class);
                    startActivity(intent);
                }
                else if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(),Akshardham.class);
                    startActivity(intent);
                }
                else if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), Purana_Quila.class);
                    startActivity(intent);
                }
                else if (position == 8) {
                    Intent intent = new Intent(getApplicationContext(),Rajghat.class);
                    startActivity(intent);
                }
                else if (position == 9) {
                    Intent intent = new Intent(getApplicationContext(), Jantar_Mantar.class);
                    startActivity(intent);
                }
                else if (position == 10) {
                    Intent intent = new Intent(getApplicationContext(),Bangla_Sahib.class);
                    startActivity(intent);
                }
                else if (position == 11) {
                    Intent intent = new Intent(getApplicationContext(), Museum.class);
                    startActivity(intent);
                }
                else if (position == 12) {
                    Intent intent = new Intent(getApplicationContext(),Agrasen.class);
                    startActivity(intent);
                }
            }
        });

    }

    public boolean isLocationPermissionGranted() {
        if(Build.VERSION.SDK_INT>=23)
        {
        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission is Granted");
            return true;
        }else{
            Log.v(TAG,"Permission is Revoked");
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            return false;
        }
        }else {
            Log.v(TAG,"Permission is Granted");
            return true;
        }
    }
}
