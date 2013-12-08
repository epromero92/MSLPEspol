package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Debug;
import android.util.DebugUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity {
	String level;
	private int tapsToWin = 0;
	private int numOfMinesAvble = 0;
	private TextView tapsToWinLbl;
	ArrayList<Cell> cells;
	Cell[][] cellsArray;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
	}
	
	private void loadThisOnCreate(){
		setContentView(R.layout.game);
		//Localizar los controles
		tapsToWinLbl = (TextView)findViewById(R.id.TapsToWin_Lbl);
		//Recuperamos la información pasada en el intent
		Bundle bundle = this.getIntent().getExtras();
		//Obtengo el nivel y creo el tablero en base al mismo.
		level = bundle.getString("LEVEL");
		if(level.compareTo(getString(R.string.easy))==0)
			genTable(9,9, 0.6F);
		else if(level.compareTo(getString(R.string.medium))==0)
			genTable(16,16,0.6F);
		else if(level.compareTo(getString(R.string.hard))==0)
			genTable(33,16,0.6F);
	}
	
	private void genTable(int numRows, int numColumns, float probability){
		//create an instance of gridview and then inicialize it with the grid view created in game.xml
		final GridView table = (GridView)findViewById(R.id.table);
		table.setNumColumns(numColumns);
		
		
		tapsToWin= numRows*numColumns;
		cells = new ArrayList<Cell>();
		for(int i =0; i<numColumns*numRows; i++){
			Cell cell = new Cell(this,probability);
			cell.setLayoutParams(new GridView.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			if(cell.isMined()){
				numOfMinesAvble=numOfMinesAvble+1;
				tapsToWin = tapsToWin-1;
			}
			cell.setOnClickListener(new CellClickHandler(numRows,numColumns,this));
			cells.add(cell);
		}
		cellsArray = this.toBiDimenArray(cells, numRows, numColumns);
		table.setAdapter(new CellAdapter(this,cells));
		
		
		//TESTING
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int widthOfScreen = size.x;
		System.out.println("ancho de la pantalla:" + widthOfScreen);
		int horizontalPadding = (widthOfScreen-getResources().getDrawable(R.drawable.mine).getIntrinsicWidth()*numColumns)/2;
		System.out.println("padding:" + horizontalPadding);
		table.setPadding(horizontalPadding, 0,0, 0);
		
		//TESTING
		
		
	}
	
	public Cell[][] toBiDimenArray(ArrayList<Cell> cells, int numRows, int numColumns){
		Cell[][] cellsArray = new Cell[numRows][numColumns];
		int k= 0;
		Cell cell;
		for(int i=0; i<numRows; i++){
			for(int j=0; j<numColumns; j++){
				cell = cells.get(k);
				cell.setRowColumn(i, j);
				cellsArray[i][j] = cell;
				k++;
				
			}
			
		}
		return cellsArray;
	}
	

	class CellClickHandler implements OnClickListener {
		private Context context;
		int numRows, numColumns;
		public CellClickHandler(int numRows, int numColumns, Context context){
			this.context = context;
			this.numRows = numRows;
			this.numColumns = numColumns;
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
				if(!c.wasDiscovered){
					System.out.println("row: " +  c.getRow() + "column: " + c.getColumn());
					floodFill(Game.this.cellsArray, c.getRow(), c.getColumn(), numRows, numColumns );
				}
				
				Game.this.tapsToWinLbl.setText("Taps to win: " + tapsToWin );
			}
		}

		public void floodFill(Cell[][] cellsArray, int row, int column, int maxRows, int maxColumns){
			if(row < 0) return;
			System.out.println("lo logre1");
			if(column < 0) return;
			System.out.println("lo logre2");
			if(row >= maxRows)return;
			System.out.println("lo logre3");
			if(column >= maxColumns) return;
			System.out.println("lo logre4");
			System.out.println("Pase el primer fitro!!");
			System.out.println("SEEEE row: " + row + "column: " + column);
			
			if(cellsArray[row][column].hasMine)return;
			System.out.println("Pase el segundo fitro!!");
			System.out.println("SEEEE row: " + row + "column: " + column);
			if(cellsArray[row][column].wasDiscovered) return;
			
			else{
				cellsArray[row][column].discover();
				cellsArray[row][column].setBackgroundResource(R.drawable.saved);
				Game.this.tapsToWin--;
				System.out.println("SEEEE row: " + row + "column: " + column);
			}
			System.out.println("Pase el tercer fitro!!");
					
			floodFill(cellsArray, row - 1, column, maxRows, maxColumns);
			floodFill(cellsArray, row + 1, column, maxRows, maxColumns);
			floodFill(cellsArray, row, column - 1, maxRows, maxColumns);
			floodFill(cellsArray, row, column + 1, maxRows, maxColumns);
		}
		
		
	}
	
	
}
