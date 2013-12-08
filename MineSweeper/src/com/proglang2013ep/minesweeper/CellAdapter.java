package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class CellAdapter extends BaseAdapter {
	private Context mContext;
	private int numOfItems;
	private int numOfRows;
	private int numOfColumns;
	private float probability;
	private static int numOfMinesAvble = 0;
	static int tapsToWin = 0;
	static TextView tapsToWinLbl = null;
	private ArrayList<Cell> cells;
	
	public CellAdapter(Context c, int numOfRows, int numOfColumns, float probability, TextView tapsToWinLbl){
		
		this.mContext = c;
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfColumns;
		this.numOfItems = numOfRows*numOfColumns;
		this.probability = probability;
		CellAdapter.tapsToWin = numOfItems;
		CellAdapter.tapsToWinLbl = tapsToWinLbl;
		cells = new ArrayList<Cell>();
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
		if(convertView == null){
			
			cell = new Cell(mContext, probability);
			cell.setLayoutParams(new GridView.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			//cell.setScaleType(ScaleType.CENTER_CROP);
			//cell.setPadding(8,8,8,8);
			if(cell.isMined()){
				numOfMinesAvble=numOfMinesAvble+1;
				tapsToWin = tapsToWin-1;
			}
			cells.add(cell);
			cell.setOnClickListener(new CellClickHandler(cells, mContext));
			
		}
		else{
			cell = (Cell) convertView;
		}
		return cell;
	}
	public ArrayList<Cell> getCells(){
		return cells;
	}
	
	public void genCells(){
		for(int row = 0; row < numOfRows; row++){
			for(int column = 0; column< numOfColumns; row++){
				
			}
				
		}
		
	}
}


