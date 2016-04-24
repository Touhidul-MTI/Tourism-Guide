package io.github.imtilab.tourismguidance;

/**
 * Created by Touhidul_MTI on 05-Apr-16.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomAdapter_CommunityFeed extends ArrayAdapter<String> {
    final Activity context;
    final String[] nameAndMessageArray;
    final int[] peopleArray;
    final String[] locationArray;
    final String[] dateArray;
int u=0;
    public CustomAdapter_CommunityFeed(Activity context, String[] nameAndMessageArray,
                                       int[]peopleArray, String[]locationArray, String[] dateArray) {
        super(context, R.layout.communityfeed_listview_layout, nameAndMessageArray);
        //super content is fixed
        //But I can pass parameter as I wish like normal constructor
        this.context = context;
        this.nameAndMessageArray = nameAndMessageArray;
        this.peopleArray = peopleArray;
        this.locationArray = locationArray;
        this.dateArray = dateArray;

    }


    @Override //this is a override method called automatically
    public View getView(int position, View convertView, ViewGroup parent) {
u++;
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.communityfeed_listview_layout, null, true);

        TextView tv1 = (TextView)rowView.findViewById(R.id.feed_layout_tv11);
        TextView tv2 = (TextView)rowView.findViewById(R.id.feed_layout_tv22);
        TextView tv3 = (TextView)rowView.findViewById(R.id.feed_layout_tv32);
        TextView tv4 = (TextView)rowView.findViewById(R.id.feed_layout_tv42);

        tv1.setText(nameAndMessageArray[position]);
        tv2.setText(peopleArray[position]+"");
        tv3.setText(locationArray[position]);
        tv4.setText(dateArray[position]);
        return rowView;
    }
}
