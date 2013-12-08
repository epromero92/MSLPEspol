package com.proglang2013ep.minesweeper;

import android.content.Context;
import android.widget.ImageButton;

public class Cell extends ImageButton {
	boolean mine;
	boolean wasClicked;
	public Cell(Context context, float probability){
		super(context);
		double random = Math.random();
		wasClicked = false;
		if(random > probability)
			mine = true;
		else
			mine = false;
		this.setBackgroundResource(R.drawable.cell);
	}

	
	public boolean isMined(){
		return mine;
		
	}
	
	public void click(){
		wasClicked = true;
		
	}
	
	

}
