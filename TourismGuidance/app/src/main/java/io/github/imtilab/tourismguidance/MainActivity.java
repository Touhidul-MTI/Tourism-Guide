package io.github.imtilab.tourismguidance;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Boolean exit = false;
    String []locationNameArray={"Dhaka", "Bagerhat","Sylhet","Khulna"};
    String []locationDetails={"Lorem ipsum dolor sit amet, his legere lobortis ut, pri ut torquatos",
            "Ignota labitur mel at, dicunt feugiat urbanitas ad mei. Ea hendrerit.",
            "Tota essent persius ius at, quis erant argumentum ea quo.",
            "Lorem ipsum dolor sit amet, his legere lobortis ut, pri ut torquatos."};
    int []imgIdArray = {R.drawable.pa, R.drawable.pb, R.drawable.pc, R.drawable.pa};
    ListView listView;
    boolean lang=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //navigation drawer here
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //main home listview here
        showListView();
    }
    public void showListView(){
        CustomAdapter_Main customArrayAdapter = new CustomAdapter_Main(this, imgIdArray, locationNameArray, locationDetails);

        listView = (ListView)findViewById(R.id.main_Lv1);
        listView.setAdapter(customArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), locationNameArray[position],
                        Toast.LENGTH_SHORT).show();

                TempListToPlaceInfoDataPass.imgid = imgIdArray[position];
                TempListToPlaceInfoDataPass.placename = locationNameArray[position];
                TempListToPlaceInfoDataPass.details = locationDetails[position];
                Intent i = new Intent(MainActivity.this, Place_Informations.class);
                startActivity(i);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menuType){
        super.onCreateOptionsMenu(menuType);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.languagemenu, menuType);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem itemType){

        if(itemType.getItemId()==R.id.bangla){

            if(!lang) {
                Toast.makeText(getApplicationContext(), "Bangla mode ON", Toast.LENGTH_SHORT).show();
                lang=true;
                return true;
            }else{
                Toast.makeText(getApplicationContext(), "English mode ON", Toast.LENGTH_SHORT).show();
                lang=false;
                return true;
            }

        }else{
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (exit) {
                finish(); // finish activity
            } else {
                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);
            }
            //super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_calender) {

        } else if (id == R.id.nav_community) {
            Intent j=new Intent(this, Community_Feed.class);
            startActivity(j);
        } else if (id == R.id.nav_security) {
//            Intent j=new Intent(this, Community_Feed.class);
//            startActivity(j);
        } else if (id == R.id.nav_signin) {

        } else if (id == R.id.nav_signup) {

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
