package com.proglang2013ep.minesweeper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Game extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		//Localizar los controles
		TextView nameLblOut = (TextView)findViewById(R.id.NameLblOut);
		//Recuperamos la información pasada en el intent
		Bundle bundle = this.getIntent().getExtras();
		//Construimos el mensaje a mostrar
		nameLblOut.setText("Playing: " + bundle.getString("NOMBRE"));
	}
}
