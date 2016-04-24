package io.github.imtilab.tourismguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Suggestion_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion__info);
    }
    public void homeclicked(View view) {
        finish();
    }

    public void transportclicked(View view) {

        Intent i = new Intent(this, Transport_Info.class);
        startActivity(i);
        finish();
    }

    public void hotelclicked(View view) {

        Intent i = new Intent(this, Hotel_Info.class);
        startActivity(i);
        finish();
    }

    public void productclicked(View view) {
        Intent i = new Intent(this, Product_Info.class);
        startActivity(i);
        finish();
    }

    public void food1(View view) {
        Intent i = new Intent(this, Food_Info.class);
        startActivity(i);
        finish();
    }

    public void agencyclicked(View view) {
        Intent i = new Intent(this, Agency_Info.class);
        startActivity(i);
        finish();
    }
}
