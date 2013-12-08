package com.proglang2013ep.minesweeper;

import android.content.Context;
import android.widget.ImageButton;

public class Cell extends ImageButton {
	boolean mine;
	public Cell(Context context, float probability){
		super(context);
		double random = Math.random();
		if(random > probability)
			mine = true;
		else
			mine = false;
		this.setBackgroundResource(R.drawable.answer2);
	}

	
	public boolean isMined(){
		return mine;
		
	}
	
	

}
