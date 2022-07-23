package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText etUserName,etRegNo,etAge,etGender;
    RadioGroup optVac;
    Button btnSubmit,btnOpenDetails;
    RadioButton sRB;
    CheckBox check1,check2,check3,check4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=findViewById(R.id.et_username);
        etRegNo=findViewById(R.id.et_regno);
        etAge=findViewById(R.id.et_age);
        etGender=findViewById(R.id.et_gender);
        optVac=findViewById(R.id.opt_vac);
        btnSubmit=findViewById(R.id.btn_submit);
        check1=findViewById(R.id.radio1);
        check2=findViewById(R.id.radio2);
        check3=findViewById(R.id.radio3);
        check4=findViewById(R.id.radio4);
        btnOpenDetails=findViewById(R.id.btn_open_details);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=optVac.getCheckedRadioButtonId();
                sRB=(RadioButton)findViewById(selectedId);
                String timeStamp = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                DatabaseReference myRef = database.getReference("Survey/"+timeStamp);
                HashMap<String,Object> surveyData=new HashMap<>();
                surveyData.put("Name",etUserName.getText().toString());
                surveyData.put("RegNum",etRegNo.getText().toString());
                surveyData.put("Age",etAge.getText().toString());
                surveyData.put("Gender",etGender.getText().toString());
                surveyData.put("opt_vac",sRB.getText().toString());
                ArrayList<String> checkedList=new ArrayList<>();
                String strCheckedList="";
                if(check1.isChecked()){
                    strCheckedList=strCheckedList+check1.getText().toString()+",";
                    checkedList.add(check1.getText().toString());
                }
                if(check2.isChecked()){
                    strCheckedList=strCheckedList+check2.getText().toString()+",";
                    checkedList.add(check2.getText().toString());
                }
                if(check3.isChecked()){
                    strCheckedList=strCheckedList+check3.getText().toString()+",";
                    checkedList.add(check3.getText().toString());
                }
                if(check4.isChecked()){
                    strCheckedList=strCheckedList+check4.getText().toString();
                    checkedList.add(check4.getText().toString());
                }
                surveyData.put("Preferences",strCheckedList);
                System.out.println(surveyData);
                myRef.setValue(surveyData).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Details Noted to database. Thank You !!!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Details didnt noted Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        btnOpenDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DetailsViewActivity.class));
            }
        });

    }
}