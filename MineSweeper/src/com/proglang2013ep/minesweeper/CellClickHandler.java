package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class CellClickHandler implements OnClickListener {
	private ArrayList<Cell> cells;
	private Context context;
	public CellClickHandler(ArrayList<Cell> cells, Context context){
		this.context = context;
		this.cells=cells;
	}
	@Override
	public void onClick(View v) {
		Cell c = (Cell)v;
		if(c.isMined()){
			for(Cell cell: cells){
				
				if( cell.isMined())
					cell.setBackgroundResource(R.drawable.mine);
				cell.setEnabled(false);
				
				
			}
			Toast.makeText(context, "You've lost the game :l", Toast.LENGTH_SHORT).show();
		}
		else{
			if(!c.wasClicked){
				c.setBackgroundResource(R.drawable.saved);
				CellAdapter.tapsToWin = CellAdapter.tapsToWin-1;
			}
			c.click();
			CellAdapter.tapsToWinLbl.setText("Taps to win: " + CellAdapter.tapsToWin);
		}
	}


}
