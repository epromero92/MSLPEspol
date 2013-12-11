package com.proglang2013ep.minesweeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Start extends Activity {
	//Este método es llamado la primera vez que se crea la actividad
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
		 
	}
	
	public void loadThisOnCreate(){
		setContentView(R.layout.start);
		ImageButton btnHola = (ImageButton)findViewById(R.id.BtnStart);
		btnHola.setOnClickListener(new OnClickListener() {
			@Override
	        public void onClick(View v) {
		        Intent intent = new Intent(Start.this, Main.class);
		        startActivity(intent);
	        }
        });
		
	}

}
