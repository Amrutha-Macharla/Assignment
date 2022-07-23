package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DetailsListAdapter extends ArrayAdapter<Details> {
    private Context mContext;
    int mResourse;

    public DetailsListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Details> objects) {
        super(context, resource, objects);
        mContext=context;
        mResourse=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String Name=getItem(position).getName();
        String Age=getItem(position).getAge();
        String Gender=getItem(position).getGender();
        String Vaccinated=getItem(position).getOpt_vac();
        String preference=getItem(position).getPreferences();
        String RegNum=getItem(position).getRegNum();
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResourse,parent,false);
        TextView AName= convertView.findViewById(R.id.txt_username);
        TextView AAge=convertView.findViewById(R.id.txt_age);
        TextView AGender=convertView.findViewById(R.id.txt_gender);
        TextView AVaccinated=convertView.findViewById(R.id.txt_vacinated);
        TextView APreference=convertView.findViewById(R.id.txt_preference);
        TextView ARegNum=convertView.findViewById(R.id.txt_regnum);
        AName.setText(Name.toString());
        AAge.setText(Age.toString());
        AGender.setText(Gender.toString());
        AVaccinated.setText(Vaccinated.toString());
        APreference.setText(preference.toString());
        ARegNum.setText(RegNum.toString());
        return convertView;
    }
}
