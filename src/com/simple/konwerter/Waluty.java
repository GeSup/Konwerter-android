package com.simple.konwerter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Waluty extends Activity {

	Button b1;

	TextView t1, t2, t3, t4;
	EditText e1, e2, e3, e4;
	double eur, gbp, zl, usd, kursEUR = 4.3311, kursUSD = 3.672, kursGBP = 5.5395;
	String wynik;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_waluty);

		b1 = (Button) findViewById(R.id.button1);
		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.textView2);
		t3 = (TextView) findViewById(R.id.textView3);
		t4 = (TextView) findViewById(R.id.textView4);
		e1 = (EditText) findViewById(R.id.editText1);
		e2 = (EditText) findViewById(R.id.editText2);
		e3 = (EditText) findViewById(R.id.editText3);
		e4 = (EditText) findViewById(R.id.editText4);
		wynik = String.valueOf(kursEUR);
		e2.setText(wynik);
		wynik = String.valueOf(kursUSD);
		e3.setText(wynik);
		wynik = String.valueOf(kursGBP);
		e4.setText(wynik);

	}

	public void wpis(View V) {
		try {
			zl = Double.parseDouble(e1.getText().toString());
			kursEUR = Double.parseDouble(e2.getText().toString());
			kursUSD = Double.parseDouble(e3.getText().toString());
			kursGBP = Double.parseDouble(e4.getText().toString());

		} catch (NumberFormatException e) {
		}
		eur = zl * kursEUR;
		eur = (((int)(100*eur))/100.0);
		usd = zl * kursUSD;
		usd = (((int)(100*usd))/100.0);
		gbp = zl * kursGBP;
		gbp = (((int)(100*gbp))/100.0);
		wynik = String.valueOf(eur);
		t1.setText(wynik+" EUR");
		wynik = String.valueOf(usd);
		t2.setText(wynik+" USD");
		wynik = String.valueOf(gbp);
		t3.setText(wynik+" GBP");
	}

}
