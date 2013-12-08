package com.proglang2013ep.minesweeper;

import android.content.Context;
import android.widget.ImageButton;

public class Cell extends ImageButton {
	boolean hasMine;
	boolean wasDiscovered;
	int row;
	int column;
	public Cell(Context context, float probability){
		super(context);
		double random = Math.random();
		wasDiscovered = false;
		if(random > probability)
			hasMine = true;
		else
			hasMine = false;
		if(this.isMined()){
			this.setBackgroundResource(R.drawable.mine);
		}
		else{
			this.setBackgroundResource(R.drawable.cell);
		}
	}
	public boolean isMined(){
		return hasMine;
	}
	public void discover(){
		wasDiscovered = true;
	}
	public void setRowColumn(int row, int column){
		this.row = row;
		this.column = column;
	}
	public int getRow(){
		return this.row;
	}
	public int getColumn(){
		return this.column;
		
	}

}
