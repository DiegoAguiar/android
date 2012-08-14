package com.example.conceito;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tela1Activity extends Activity implements OnClickListener {

	private ProgressDialog dialogo;
	private Handler handler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela1);

		Button button = (Button) findViewById(R.id.btProcessar);
		button.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.tela1, menu);
		return true;
	}

	public void onClick(View arg0) {
		Toast.makeText(Tela1Activity.this, "click", Toast.LENGTH_SHORT).show();

		Runnable contar = new Runnable() {
			public void run() {
				processar();
			}
		};

		Thread paralelo = new Thread(contar);
		paralelo.start();

		dialogo = ProgressDialog.show(Tela1Activity.this, "Aguarde",
				"Processando");

	}

	@SuppressLint({ "ParserError", "ParserError" })
	public void processar() {
		for (int contador = 0; contador < 1000; contador++) {
			Log.i("Tela1", "Estou no " + contador);
		}
		handler.post(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				TextView label = (TextView) findViewById(R.id.textView1);
				label.setText("Cansei... Mas Terminei");
				dialogo.dismiss();

				// intents - intenção de ir pra algum lugar - pedida para o adroid
				/*Intent intencaoDeIrPraTelaDois = new Intent(Tela1Activity.this,
						Tela2Activity.class);
				startActivity(intencaoDeIrPraTelaDois);*/
				
				Intent queroLigar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:989865654"));
				startActivity(queroLigar);

			}
		});
	}

}
