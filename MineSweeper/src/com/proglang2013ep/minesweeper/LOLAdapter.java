package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

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
		private ArrayList<ComposedItem> levels;
	public LOLAdapter(Activity activity, ArrayList<ComposedItem> lvls){
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
		TextView lbl = (TextView) spinView.findViewById(R.id.Level_lbl);
		lbl.setText(String.valueOf(levels.get(position).getLevel()));
		return spinView;
	}
}
