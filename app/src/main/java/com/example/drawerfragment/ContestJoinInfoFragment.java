package com.example.drawerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContestJoinInfoFragment extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contest_join_info,container,false);

        textView = view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        if (bundle !=null){
            String contest_name = bundle.getString("contest_name");
            String contest_desc = bundle.getString("contest_desc");
            String contest_cost = bundle.getString("contest_cost");
            textView.setText("You Joined "+contest_name+ " contest, "+"wining prize is "+contest_desc+" ,joinning ammount is "+contest_cost);
        }

        return view;

    }

}
