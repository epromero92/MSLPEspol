package com.proglang2013ep.minesweeper;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class NewGame extends Activity {
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
	}
	
	public void loadThisOnCreate(){
		setContentView(R.layout.newgame);
		final Button acceptBtn = (Button)findViewById(R.id.AcceptBtn);
	    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.levels_layout, R.array.levels);
		//ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.levels, R.layout.levels_layout);
		final Spinner listOfLevels = (Spinner)findViewById(R.id.ListOfLevels);
		listOfLevels.setBackgroundColor(getResources().getColor(R.color.gray));
		ArrayList<ComposedItem> levels = new ArrayList<ComposedItem>();
		levels.add(new ComposedItem("Easy"));
		levels.add(new ComposedItem("Medium"));
		levels.add(new ComposedItem("Hard"));
		
		LOLAdapter adapter = new LOLAdapter(this, levels);
		listOfLevels.setAdapter(adapter);
						
		acceptBtn.setOnClickListener(new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(NewGame.this, Game.class);
		        //Creamos la información a pasar entre actividades
		        Bundle b = new Bundle(); 
		        b.putString("LEVEL", ((ComposedItem)listOfLevels.getSelectedItem()).getLevel());
		        //Añadimos la información al intent
		        intent.putExtras(b); 
		        //Iniciamos la nueva actividad
		        startActivity(intent);
	        }
        });
		
		
		
	}
}
