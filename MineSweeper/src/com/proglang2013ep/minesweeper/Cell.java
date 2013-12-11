package com.proglang2013ep.minesweeper;


import android.content.Context;
import android.widget.ImageButton;

public class Cell extends ImageButton {
	private boolean hasMine;
	private boolean wasDiscovered;
	private int row;
	private int column;
	private int adjacentMines;
	public Cell(Context context, float probability){
		super(context);
		double random = Math.random();
		wasDiscovered = false;
		if(random < probability)
			hasMine = true;
		else
			hasMine = false;
			this.setBackgroundResource(R.drawable.cell);
	
		adjacentMines = 0;
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
	public int getAdjacentMines(){
		return adjacentMines;
	}
	public void addOneAdjacentMine(){
		this.adjacentMines += 1;
	}
	public boolean wasDiscovered(){
		return this.wasDiscovered;
	}
}
