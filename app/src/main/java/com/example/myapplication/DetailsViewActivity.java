package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DetailsViewActivity extends AppCompatActivity {
    TextView txtUserName,txtRegNum,txtAge,txtGender,txtVacinated,txtPreference;
    ListView detailsView;
    DatabaseReference dbref;
    ArrayAdapter<Details> arrayAdapter;
    ArrayList<Details> arrayList;
    Details surveyDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        detailsView=findViewById(R.id.lv_details);
        surveyDetails=new Details();
        dbref= FirebaseDatabase.getInstance().getReference("Survey");
//        detailsView.setAdapter(arrayAdapter);
        arrayList=new ArrayList<>();
//        arrayAdapter=new DetailsViewAdapter<Details>(this, R.layout.survey_etails,arrayList);

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    surveyDetails=snapshot1.getValue(Details.class);
                    arrayList.add(surveyDetails);
                }
                DetailsListAdapter adapter=new DetailsListAdapter(getApplicationContext(),R.layout.survey_etails,arrayList);
                detailsView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        dbref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                String value=snapshot.getValue(Details.class).toString();
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    private class DetailsAapter extends BaseAdapter {
        Context c;
        public DetailsAapter(DetailsViewActivity detailsViewActivity) {
            c=detailsViewActivity;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}