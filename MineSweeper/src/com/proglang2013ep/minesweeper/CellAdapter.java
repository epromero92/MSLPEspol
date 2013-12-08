package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CellAdapter extends BaseAdapter {
	private ArrayList<Cell> cells;
	public CellAdapter(Context c, ArrayList<Cell> cells){
		//Member variables
			this.cells = cells;		
	}
	@Override
	public int getCount() {
		
		return cells.size();
	}

	@Override
	public Object getItem(int arg0) {
		return cells.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return cells.get(arg0).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Cell cell = cells.get(position);
		return cell;
	}
	public ArrayList<Cell> getCells(){
		return cells;
	}
	
}


