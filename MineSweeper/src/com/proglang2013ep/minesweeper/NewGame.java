package com.proglang2013ep.minesweeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewGame extends Activity {
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);
		
		final EditText nameTextBox = (EditText)findViewById(R.id.NameTextBox);
		final Button acceptBtn = (Button)findViewById(R.id.AcceptBtn);
		
		acceptBtn.setOnClickListener(new OnClickListener() {
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
	}
}
