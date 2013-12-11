package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
public class LOLAdapter extends BaseAdapter implements SpinnerAdapter{
		private Activity activity;
		private ArrayList<Level> levels;
		
	public LOLAdapter(Activity activity, ArrayList<Level> lvls){
	    this.activity = activity;
	    this.levels = lvls;
	}
	
	public int getCount() {
	    return levels.size();
	}
	
	public Object getItem(int position) {
	    return levels.get(position);
	}
	
	public long getItemId(int position) {
	    return position;
	}
	
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View spinView;
		if( convertView == null ){
		    LayoutInflater inflater = activity.getLayoutInflater();
		    spinView = inflater.inflate(R.layout.levels_layout, null);
		} else {
		     spinView = convertView;
		}
		ImageView icon = (ImageView) spinView.findViewById(R.id.Level_icon);
		switch(levels.get(position).getId()){
			case 1:
				icon.setBackgroundResource(R.drawable.easy);
				break;
			case 2:
				icon.setBackgroundResource(R.drawable.medium);
				break;
			case 3:
				icon.setBackgroundResource(R.drawable.hard);
				break;
			case 4:
				icon.setBackgroundResource(R.drawable.custom);
				break;
		}
		
		//TextView lbl = (TextView) spinView.findViewById(R.id.Level_lbl);
		//lbl.setText(String.valueOf(levels.get(position).getLevel()));
		return spinView;
	}
}
