package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class Game extends Activity {
	String level;
	static int tapsToWin = 0;
	static TextView tapsToWinLbl = null;
	ArrayList<Cell> cells;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
	}
	
	private void loadThisOnCreate(){
		setContentView(R.layout.game);
		//Localizar los controles
		final TextView nameLblOut = (TextView)findViewById(R.id.Game_Name_Lbl);
		final TextView tapsToWinLlb= (TextView)findViewById(R.id.TapsToWin_Lbl);
		//Recuperamos la información pasada en el intent
		Bundle bundle = this.getIntent().getExtras();
		//Construimos el mensaje a mostrar
		nameLblOut.setText("Playing: " + bundle.getString("NAME"));
		//Obtengo el nivel y creo el tablero en base al mismo.
		level = bundle.getString("LEVEL");
		if(level.compareTo(getString(R.string.easy))==0)
			genTable(9,9, 0.8F,tapsToWinLlb);
		else if(level.compareTo(getString(R.string.medium))==0)
			genTable(16,16,0.8F,tapsToWinLlb);
		else if(level.compareTo(getString(R.string.hard))==0)
			genTable(33,16,0.7F,tapsToWinLlb);
	}
	
	private void genTable(int numRows, int numColumns, float probability, TextView tapsToWinLbl){
		final GridView table = (GridView)findViewById(R.id.table);
		int numElements = numRows*numColumns;
		table.setNumColumns(numColumns);
		CellAdapter adapter = new CellAdapter(this, numRows, numColumns, probability, tapsToWinLbl);
		cells = adapter.getCells();
		table.setAdapter(adapter);
	}
}
