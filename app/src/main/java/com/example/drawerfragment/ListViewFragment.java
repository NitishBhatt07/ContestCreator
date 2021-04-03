package com.example.drawerfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {

    ListView lv;

    ArrayList<String> contestname = new ArrayList<String>();
    ArrayList<String> desc = new ArrayList<String>();
    ArrayList<String> cost = new ArrayList<String>();

    String contest;
    String contest_desc;
    String contest_cost;
    ArrayAdapter<String> adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_view, container, false);

        lv = v.findViewById(R.id.listview);


        final ArrayList<String> list = new ArrayList<String>();

       final CustomListview customListview = new CustomListview((MainActivity) getActivity(),contestname,desc,cost);
        lv.setAdapter(customListview);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("ContestDetails");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    list.clear();

                   String name = snapshot.child("contestName").getValue().toString();
                   String venue = snapshot.child("contestVenue").getValue().toString();
                   String fee = snapshot.child("contestFee").getValue().toString();

                   contestname.add(name);
                   desc.add(venue);
                   cost.add(fee);

                }
                customListview.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }
}
