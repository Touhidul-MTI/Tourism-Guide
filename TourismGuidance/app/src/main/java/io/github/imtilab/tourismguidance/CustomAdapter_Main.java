package io.github.imtilab.tourismguidance;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Touhidul_MTI on 06-Apr-16.
 */
public class CustomAdapter_Main extends ArrayAdapter<String> {
    final Activity context;
    final String[] locationNameArray;
    final String[] locationDetailsArray;
    final int[] imgIdArray;
    public CustomAdapter_Main(Activity context, int[] imgIdArray,
                              String[] locationNameArray, String[] locationDetailsArray) {
        super(context, R.layout.main_listview_layout, locationNameArray);
        //super content is fixed
        //But I can pass parameter as I wish like normal constructor
        this.context = context;
        this.locationNameArray = locationNameArray;
        this.locationDetailsArray = locationDetailsArray;
        this.imgIdArray = imgIdArray;
    }


    @Override //this is a override method called automatically
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.main_listview_layout, null, true);

        ImageView iv1 = (ImageView)rowView.findViewById(R.id.main_listview_iv1);
        TextView tv1 = (TextView)rowView.findViewById(R.id.main_listview_tv11);
        TextView tv2 = (TextView)rowView.findViewById(R.id.main_listview_tv12);


        tv1.setText(locationNameArray[position]);
        tv2.setText(locationDetailsArray[position]);
        iv1.setImageResource(imgIdArray[position]);

        return rowView;
    }
}