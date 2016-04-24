package io.github.imtilab.tourismguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Community_Feed extends AppCompatActivity {

    ListView listView;

    String []nameAndMessageArray={"ORIO", "KIYOT", "RAKIB","SHAHID","ANIK","SHAHRIAR"};
    int []peopleArray={2,3,4,5,6,7};
    String []locationArray={"Dhaka", "Chittagong", "Rajshahi","Potuakhali","Bandarban","Sylhet"};
    String []dateArray={"11/12/12","12/12/12","13/12/12","14/12/12","14/12/12","14/12/12"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_feed);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //listview activity
        CustomAdapter_CommunityFeed customArrayAdapter = new CustomAdapter_CommunityFeed(this, nameAndMessageArray,
                peopleArray, locationArray, dateArray);

        listView = (ListView)findViewById(R.id.communityfeed_Lv1);
        listView.setAdapter(customArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position + " :"
                        + nameAndMessageArray[position], Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent j=new Intent(Community_Feed.this, Community_info.class);
                    startActivity(j);
                }
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

    public void onClicked_communityfeed_b1(View view) {
        Intent postIntent = new Intent(this, Community_Post.class);
        startActivity(postIntent);
    }
}
