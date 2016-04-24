package io.github.imtilab.tourismguidance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Food_Info extends ActionBarActivity {

    private SlidingTabLayout tabLayout;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__info);
        getSupportActionBar().hide();

        tabLayout= (SlidingTabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        tabLayout.setCustomTabView(R.layout.food_tab_view, R.id.food_tab_title);
        MyAdapter adapter =  new MyAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabLayout.setDistributeEvenly(true);
        tabLayout.setViewPager(pager);
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

    public void agencyclicked(View view) {
        Intent i = new Intent(this, Agency_Info.class);
        startActivity(i);
        finish();
    }

    public void su1(View view) {
        Intent i = new Intent(this, Suggestion_Info.class);
        startActivity(i);
        finish();
    }
}
class MyAdapter extends FragmentStatePagerAdapter {
    String[] title = {"REGULAR FOOD", "LOCAL FOOD"};

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new Food_FragA();
        if (position == 1)
            fragment = new Food_FragB();
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //instead of using array, you can directly return the tab name as
        //string too, using if else condition
        return title[position];
    }
}