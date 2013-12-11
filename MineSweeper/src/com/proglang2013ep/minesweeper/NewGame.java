package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NewGame extends Activity {
	private Button continueBtn;
	private EditText numOfRows, numOfColumns, percentOfMines;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
	}
	
	@SuppressLint("NewApi")
	public void loadThisOnCreate(){
		setContentView(R.layout.newgame);
		continueBtn = (Button)findViewById(R.id.continueBtn);
		numOfRows = (EditText)findViewById(R.id.numOfRows);
		numOfColumns = (EditText)findViewById(R.id.numOfColumns);
		percentOfMines= (EditText)findViewById(R.id.percentOfMines);
		
	    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.levels_layout, R.array.levels);
		//ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.levels, R.layout.levels_layout);
		final Spinner listOfLevels = (Spinner)findViewById(R.id.ListOfLevels);
	
		//listOfLevels.setBackgroundColor(getResources().getColor(R.color.gray));
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(new Level("Easy",1));
		levels.add(new Level("Medium",2));
		levels.add(new Level("Hard",3));
		levels.add(new Level("Custom",4));
		
		LOLAdapter adapter = new LOLAdapter(this, levels);
		listOfLevels.setAdapter(adapter);
						
		continueBtn.setOnClickListener(new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(NewGame.this, Game.class);
		        //Creamos la información a pasar entre actividades
		        Bundle b = new Bundle(); 
		        b.putString("LEVEL", ((Level)listOfLevels.getSelectedItem()).getLevel());
		        if(listOfLevels.getSelectedItemPosition()==3){
		        	try{
		        	b.putInt("ROWS",Integer.parseInt(numOfRows.getText().toString()));
		        	b.putInt("COLUMNS",Integer.parseInt(numOfColumns.getText().toString()));
		        	b.putFloat("PERCENT",Float.parseFloat(percentOfMines.getText().toString()));
		        	}catch(Exception e){
		        		System.out.println(e);
		        	}
		        }
		        //Añadimos la información al intent
		        intent.putExtras(b); 
		        //Iniciamos la nueva actividad
		        startActivity(intent);
	        }
        });
		
		listOfLevels.setOnItemSelectedListener(new OnItemSelectedListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if(position==3){
					NewGame.this.numOfRows.setText("");
					NewGame.this.numOfColumns.setText("");
					NewGame.this.percentOfMines.setText("");
					NewGame.this.numOfRows.setEnabled(true);
					NewGame.this.numOfColumns.setEnabled(true);
					NewGame.this.percentOfMines.setEnabled(true);
				}else{
					switch(position){
					case 0:
						NewGame.this.numOfRows.setText("9");
						NewGame.this.numOfColumns.setText("9");
						NewGame.this.percentOfMines.setText("0.1");
						break;
					case 1:
						NewGame.this.numOfRows.setText("16");
						NewGame.this.numOfColumns.setText("16");
						NewGame.this.percentOfMines.setText("0.2");
						break;
					case 2:
						NewGame.this.numOfRows.setText("33");
						NewGame.this.numOfColumns.setText("16");
						NewGame.this.percentOfMines.setText("0.2");
						break;
					}
					NewGame.this.numOfRows.setEnabled(false);
					NewGame.this.numOfColumns.setEnabled(false);
					NewGame.this.percentOfMines.setEnabled(false);
					
				}

								
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	
			
		
		});
		
		
		
	}
}
