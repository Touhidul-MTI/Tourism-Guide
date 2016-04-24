package io.github.imtilab.tourismguidance;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Community_Post extends AppCompatActivity {

    int yearPick, monthPick, dayPick;
    final int doalogId = 0;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_post);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //tvDate = (TextView)findViewById(R.id.community_tv3);

        //Spinner activity
        final String []placesArray = {"Dhaka", "Chittagong","Sylhet","Khulna","Bandarban"};
        Spinner spinner = (Spinner) findViewById(R.id.community_post_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinnerlayout, R.id.spinText, placesArray);

        adapter.setDropDownViewResource(R.layout.spinnerlayout);
        spinner.setAdapter(adapter);
        //final String spinVal = String.valueOf(spinner.getSelectedItem());
       // Toast.makeText(getApplicationContext(), spinVal, Toast.LENGTH_SHORT).show();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Dhaka", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), placesArray[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "nothing selected", Toast.LENGTH_SHORT).show();
            }
        });
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

    public void pickDate(View view) {
        Calendar calendar = Calendar.getInstance();
        dayPick = calendar.get(Calendar.DAY_OF_MONTH);
        monthPick = calendar.get(Calendar.MONTH);
        yearPick = calendar.get(Calendar.YEAR);

        showDialog(doalogId);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == doalogId) {
            return new DatePickerDialog(this, datepickerlistener, yearPick, monthPick, dayPick);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datepickerlistener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    yearPick = year;
                    monthPick = monthOfYear;
                    dayPick = dayOfMonth;
                    Toast.makeText(getApplicationContext(), yearPick + ": " + monthPick + ": " + dayPick,
                            Toast.LENGTH_SHORT).show();
                    //tvDate.setText(dayPick + " " + monthPick + " " + yearPick);
                }
            };

    public void postClicked(View view) {
        Toast.makeText(getApplicationContext(),"New Tour posting..",
                Toast.LENGTH_SHORT).show();
    }
}
