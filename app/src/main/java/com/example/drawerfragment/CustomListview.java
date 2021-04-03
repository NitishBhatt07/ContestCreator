package com.example.drawerfragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListview extends ArrayAdapter<String> {

    ArrayList<String> contestname;
    ArrayList<String> desc;
    ArrayList<String> cost;


    Activity context;

    public CustomListview(MainActivity context, ArrayList<String> contestname, ArrayList<String> desc,ArrayList<String> cost) {
        super(context, R.layout.listview_layout,contestname);

        this.context = context;
        this.contestname = contestname;
        this.desc = desc;
        this.cost = cost;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        Viewholder viewholder ;

        if(r==null){
            LayoutInflater layoutInflater= context.getLayoutInflater();
            r= layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewholder = new Viewholder(r);
            r.setTag(viewholder);
        }else{
            viewholder = (Viewholder) r.getTag();
        }

        viewholder.tvw1.setText(contestname.get(position));
        viewholder.tvw2.setText(desc.get(position));
        viewholder.tvw3.setText(cost.get(position));

        return r;
    }

    class Viewholder{

        TextView tvw1,tvw2,tvw3;

        Viewholder(View v){
            tvw1 = v.findViewById(R.id.tvcontestname);
            tvw2 = v.findViewById(R.id.tvdescription);
            tvw3 = v.findViewById(R.id.tvcost);
        }
    }


}
