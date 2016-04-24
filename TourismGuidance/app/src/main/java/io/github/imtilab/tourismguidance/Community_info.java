package io.github.imtilab.tourismguidance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Community_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_info);
    }

    public void done(View view) {
        finish();
    }
}
