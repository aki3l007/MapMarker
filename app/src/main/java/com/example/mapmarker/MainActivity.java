package com.example.mapmarker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends Activity {

    private EditText mDlGeo;
    private EditText mSzGeo;
    private Button mPokazNaMapie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDlGeo = (EditText) findViewById(R.id.dlugoscGeograficznaEditText);
        mSzGeo = (EditText) findViewById(R.id.szerkoscGeograficznaeditText);
        mPokazNaMapie = (Button) findViewById(R.id.button);

        mDlGeo.setText("144.962");
        mSzGeo.setText("-37.813");

        mPokazNaMapie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("map_bundle_szerokosc",mSzGeo.getText().toString());
                bundle.putString("map_bundle_dlugosc",mDlGeo.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
