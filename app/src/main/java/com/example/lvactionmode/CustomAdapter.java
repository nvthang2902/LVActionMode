package com.example.lvactionmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<CountriesModel> countriesData;
    LayoutInflater layoutInflater;
    CountriesModel countriesModel;


    public CustomAdapter(Context context,ArrayList<CountriesModel> countriesData){
        this.context=context;
        this.countriesData=countriesData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return countriesData.size();
    }

    @Override
    public Object getItem(int i) {
        return countriesData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return countriesData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.country_row, null, true);
        }
        //link views
        ImageView countryFlagIv = rowView.findViewById(R.id.countryFlagIv);
        TextView countryNameTv = rowView.findViewById(R.id.countryNameTv);
        TextView populationTv = rowView.findViewById(R.id.populationTv);
        TextView areaTv = rowView.findViewById(R.id.areaTv);

        countriesModel = countriesData.get(position);

        countryFlagIv.setImageResource(countriesModel.getImage());
        countryNameTv.setText(countriesModel.getName());
        populationTv.setText("Singer/Band : " + countriesModel.getPopulation());
        areaTv.setText("View: " + countriesModel.getArea());

        return rowView;
    }
    public void removeItems(List<CountriesModel> items){
        for(CountriesModel item :items){
            countriesData.remove(item);
        }
        notifyDataSetChanged();
    }

}
