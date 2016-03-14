package com.example.root.testapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomSearchAdapter extends ArrayAdapter<String> {
	View view;

	public CustomSearchAdapter(Context context, int resource,
							   int textViewResourceId, List<String> objects) {
		super(context, resource, textViewResourceId, objects);

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		view = super.getView(position, convertView, parent);
		try {
			TextView txtitem = (TextView) view.findViewById(R.id.textitem);



		} catch (Exception e) {
		}
		return view;
	}
}