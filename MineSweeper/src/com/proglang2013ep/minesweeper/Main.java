//La declaración del paquete debe ser la misma que se usó cuando se creo el proyecto.
package com.proglang2013ep.minesweeper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Main extends Activity {
	//Este método es llamado la primera vez que se crea la actividad
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.loadThisOnCreate();
	}


	public void loadThisOnCreate(){
		/*Con esta llamada le estamos diciendo a Android que debe establecer 
		 *como interfaz gráfica de esta actividad la definida en el archivo
         *layout/main.xml
         **/
        setContentView(R.layout.main);
		//Obtenemos una referencia a los controles de la interfaz.
		final ImageButton nuGameBt = (ImageButton)findViewById(R.id.BtnNuGame);
		final ImageButton rankBt = (ImageButton)findViewById(R.id.BtnRanking);
		final ImageButton aboutBt = (ImageButton)findViewById(R.id.BtnAbout);
      
		//Implementamos el evento "onClick" del botón
        nuGameBt.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//Creamos el Intent
	        	Intent intent = new Intent(Main.this, NewGame.class);
		        //Creamos la información a pasar entre actividades
		        //Bundle b = new Bundle(); 
		        //b.putString("NOMBRE", txtNombre.getText().toString()); 
		        //Añadimos la información al intent
		        //intent.putExtras(b); 
		        //Iniciamos la nueva actividad
		        startActivity(intent);
	        }
        });
        rankBt.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
	        	Intent intent = new Intent(Main.this, Ranking.class);
	        	startActivity(intent);
        	}
        });
        aboutBt.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
	        	Intent intent = new Intent(Main.this, About.class);
	        	startActivity(intent);
        	}
        });
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mine_sweeper, menu);
        return true;
    }
    
    
}
