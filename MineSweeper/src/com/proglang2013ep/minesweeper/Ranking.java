package com.proglang2013ep.minesweeper;

import android.app.Activity;
import android.os.Bundle;

public class Ranking extends Activity {
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		loadThisOnCreate();
	}
	public void loadThisOnCreate(){
		setContentView(R.layout.ranking);		
	}
	
}
