package io.github.imtilab.tourismguidance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Product_Info extends ActionBarActivity {

    private SlidingTabLayout tabLayout;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__info);
        getSupportActionBar().hide();

        tabLayout= (SlidingTabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        tabLayout.setCustomTabView(R.layout.product_tab_view, R.id.p_tab_title);
        MyAdapter4 adapter =  new MyAdapter4(getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabLayout.setDistributeEvenly(true);
        tabLayout.setViewPager(pager);
    }
    public void homeclicked(View view) {
        finish();
    }

    public void foodclicked(View view) {

        Intent i = new Intent(this, Food_Info.class);
        startActivity(i);
        finish();
    }

    public void hotelclicked(View view) {

        Intent i = new Intent(this, Hotel_Info.class);
        startActivity(i);
        finish();
    }

    public void transportclicked(View view) {
        Intent i = new Intent(this, Transport_Info.class);
        startActivity(i);
        finish();
    }

    public void agencyclicked(View view) {
        Intent i = new Intent(this, Agency_Info.class);
        startActivity(i);
        finish();
    }

    public void suggestionsclicked(View view) {
        Intent i = new Intent(this, Suggestion_Info.class);
        startActivity(i);
        finish();
    }
}
class MyAdapter4 extends FragmentStatePagerAdapter {
    String[] title = {"FOOD", "CLOTHS", "OTHERS"};

    public MyAdapter4(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new Transport_FragA();
        if (position == 1)
            fragment = new Transport_FragB();
        if (position == 2)
            fragment = new Transport_FragC();
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //instead of using array, you can directly return the tab name as
        //string too, using if else condition
        return title[position];
    }
}