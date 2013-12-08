package com.proglang2013ep.minesweeper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class Game extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
	}
	
	private void loadThisOnCreate(){
		setContentView(R.layout.game);
		//Localizar los controles
		final TextView nameLblOut = (TextView)findViewById(R.id.Game_Name_Lbl);
		//Recuperamos la información pasada en el intent
		Bundle bundle = this.getIntent().getExtras();
		//Construimos el mensaje a mostrar
		nameLblOut.setText("Playing: " + bundle.getString("NOMBRE"));
		genTable(6,4);
	}
	
	private void genTable(int numRows, int numColumns){
		final GridView table = (GridView)findViewById(R.id.table);
		int index = numRows*numColumns;
		table.setNumColumns(numColumns);
		table.setAdapter(new CellAdapter(this, index));
	}
}
