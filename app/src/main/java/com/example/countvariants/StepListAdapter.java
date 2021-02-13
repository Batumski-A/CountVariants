package com.example.countvariants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StepListAdapter extends ArrayAdapter<Step> {
    private Context context;
    int mResource;
    public StepListAdapter(Context context, int resource, ArrayList<Step> objects) {
        super(context, resource,objects);
        this.context = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int stepone = getItem(position).getStepOne();
        int steptwo = getItem(position).getStepTwo();

        Step step = new Step(stepone,steptwo);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(mResource,parent,false);

        TextView one = (TextView) convertView.findViewById(R.id.OneStem);
        TextView two = (TextView) convertView.findViewById(R.id.TwoStep);

        one.setText(String.valueOf(stepone));
        two.setText(String.valueOf(steptwo));

        return convertView;

    }
}
