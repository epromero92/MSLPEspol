package com.proglang2013ep.minesweeper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewGame extends Activity {
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
	}
	
	public void loadThisOnCreate(){
		setContentView(R.layout.newgame);
		final EditText nameTextBox = (EditText)findViewById(R.id.NameTextBox);
		final Button acceptBtn = (Button)findViewById(R.id.AcceptBtn);
		
		acceptBtn.setOnClickListener(new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(NewGame.this, Game.class);
		        //Creamos la información a pasar entre actividades
		        Bundle b = new Bundle(); 
		        b.putString("NOMBRE", nameTextBox.getText().toString()); 
		        //Añadimos la información al intent
		        intent.putExtras(b); 
		        //Iniciamos la nueva actividad
		        startActivity(intent);
	        }
        });
		
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, R.array.levels);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.levels, android.R.layout.simple_spinner_item);
		final Spinner listOfLevels = (Spinner)findViewById(R.id.ListOfLevels);
		listOfLevels.animate();
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listOfLevels.setAdapter(adapter);
		listOfLevels.setBackgroundColor(Color.GRAY);
		listOfLevels.setOnItemSelectedListener(
		new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id){
									
			}
			public void onNothingSelected(AdapterView<?> parent) { 
			
			}
		});
		
	}
}
