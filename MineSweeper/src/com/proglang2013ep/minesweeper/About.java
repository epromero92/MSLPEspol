package com.proglang2013ep.minesweeper;


import android.app.Activity;
import android.os.Bundle;


public class About extends Activity {
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.loadThisOnCreate();
		
	}
	

	public void loadThisOnCreate(){
		setContentView(R.layout.about);		
	}
}
