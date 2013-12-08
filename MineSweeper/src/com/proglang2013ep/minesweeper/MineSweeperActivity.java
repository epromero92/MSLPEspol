//La declaración del paquete debe ser la misma que se usó cuando se creo el proyecto.
package com.proglang2013ep.minesweeper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import android.content.Intent;

public class MineSweeperActivity extends Activity {
	//Este método es llamado la primera vez que se crea la actividad
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Con esta llamada le estamos diciendo a Android que debe establecer
        //como interfaz gráfica de esta actividad la definida en el archivo
        //layout/main.xml
        setContentView(R.layout.main);
      //Obtenemos una referencia a los controles de la interfaz.
        final EditText txtNombre = (EditText)findViewById(R.id.TxtNombre);
        final Button btnHola = (Button)findViewById(R.id.BtnHola);
      
      //Implementamos el evento "click" del botón
        btnHola.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//Creamos el Intent
		        Intent intent = new Intent(MineSweeperActivity.this, FrmMessage.class);
		        //Creamos la información a pasar entre actividades
		        Bundle b = new Bundle(); 
		        b.putString("NOMBRE", txtNombre.getText().toString()); 
		        //Añadimos la información al intent
		        intent.putExtras(b); 
		        //Iniciamos la nueva actividad
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
