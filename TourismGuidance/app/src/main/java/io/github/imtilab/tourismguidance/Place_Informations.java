package io.github.imtilab.tourismguidance;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Place_Informations extends AppCompatActivity{

    TextView tv1, tv2;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place__informations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv1=(TextView)findViewById(R.id.info_tv1);
        //tv2=(TextView)findViewById(R.id.info_tv2);
        iv1=(ImageView)findViewById(R.id.info_iv1);

        tv1.setText(TempListToPlaceInfoDataPass.placename);
        //tv2.setText(TempListToPlaceInfoDataPass.details);
        iv1.setImageResource(TempListToPlaceInfoDataPass.imgid);
    }

    public void ok(View view) {
        ImageView iv1=(ImageView)findViewById(R.id.info_iv1);
        iv1.setImageResource(R.drawable.pb);
    }
    //actionbar back icon action
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    public void transportclicked(View view) {
        Intent i = new Intent(this, Transport_Info.class);
        startActivity(i);
    }

    public void foodclicked(View view) {
        Intent i = new Intent(this, Food_Info.class);
        startActivity(i);
    }
    public void hotelclicked(View view) {
        Intent i = new Intent(this, Hotel_Info.class);
        startActivity(i);
    }
    public void productclicked(View view) {
        Intent i = new Intent(this, Product_Info.class);
        startActivity(i);
    }

    public void agencyclicked(View view) {
        Intent i = new Intent(this, Agency_Info.class);
        startActivity(i);
    }

    public void suggestionsclicked(View view) {
        Intent i = new Intent(this, Suggestion_Info.class);
        startActivity(i);
    }
}
