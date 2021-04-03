package com.example.drawerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.common.data.DataHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateContest extends Fragment {

    EditText nameField,venueField,feeField,usernameField;
    Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_contest,container,false);

        nameField = view.findViewById(R.id.nameField);
        venueField = view.findViewById(R.id.venueField);
        feeField = view.findViewById(R.id.feeField);
        usernameField = view.findViewById(R.id.usernameField);
        submitButton = view.findViewById(R.id.submitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String created_contest_name = nameField.getText().toString().trim();
                String created_contest_desc = venueField.getText().toString().trim();
                String created_contest_cost = feeField.getText().toString().trim();
                String username = usernameField.getText().toString().trim();

                Dataholder obj = new Dataholder(created_contest_name,created_contest_desc,created_contest_cost);

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("ContestDetails");
                node.child(username).setValue(obj);

                Toast.makeText(getActivity(),"your data saved",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
