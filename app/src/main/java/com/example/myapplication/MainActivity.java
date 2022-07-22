package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio11:
                if (checked)
                    break;
            case R.id.radio22:
                if (checked)
                    break;
        }
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.radio1:
                if (checked){}
                else{}
                break;
            case R.id.radio2:
                if (checked){}
                else{}
                break;
            case R.id.radio3:
                if (checked){}
                else {}
                break;
            case R.id.radio4:
                if (checked){}
                else{}
                break;
        }
    }
}