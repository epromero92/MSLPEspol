package com.proglang2013ep.minesweeper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

public class CellAdapter extends BaseAdapter {
	private Context mContext;
	private int numOfItems;
	
	public CellAdapter(Context c, int numOfItems){
		this.mContext = c;
		this.numOfItems = numOfItems;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return numOfItems;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Cell cell;
		float probability;
		probability = 0.6F;
		if(convertView == null){
			cell = new Cell(mContext, probability);
			cell.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Cell c = (Cell)v;
					if(c.isMined()){
						Toast.makeText(mContext,"Is Mined",Toast.LENGTH_SHORT).show();
						c.setBackgroundResource(R.drawable.mine2);
					}
					else{
						Toast.makeText(mContext,"You were close", Toast.LENGTH_SHORT).show();
					}
				}
				});
		}
		else{
			cell = (Cell) convertView;
		}
		return cell;
	}

}
