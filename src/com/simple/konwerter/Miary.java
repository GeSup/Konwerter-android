package com.simple.konwerter;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Miary extends Activity implements OnItemSelectedListener {

	Spinner s1;
	TextView t1, t2, t3;
	int position;
	EditText e1;
	double wpisana, cm, cal, wartCal = 2.54, km, m;
	String wynik;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_miary);
		s1 = (Spinner) findViewById(R.id.spinner1);
		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.textView2);
		t3 = (TextView) findViewById(R.id.textView3);
		e1 = (EditText) findViewById(R.id.editText1);
		s1.setOnItemSelectedListener(this);
		e1.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s) {
			   }
			 
			   public void beforeTextChanged(CharSequence s, int start, 
			     int count, int after) {
			   }
			 
			   public void onTextChanged(CharSequence s, int start, 
			     int before, int count) {
				   wpis();
			   }
		});
	}

	public void wpis() {
	
		try {
			wpisana = Double.parseDouble(e1.getText().toString());
		} catch (NumberFormatException e) {
			wpisana = 0;
		}
		switch (position) {
		case 0:
			cal = wpisana / wartCal;
			km = wpisana / 100000;
			m = wpisana / 1000;
			wynik = String.valueOf(cal) + " w calach";
			t1.setText(wynik);
			wynik = String.valueOf(km) + " km";
			t2.setText(wynik);
			wynik = String.valueOf(m) + " m";
			t3.setText(wynik);
			break;
		case 1:
			cm = wpisana * wartCal;
			km = cm / 100000;
			m = cm / 100;
			wynik = String.valueOf(cm) + " cm";
			t1.setText(wynik);
			wynik = String.valueOf(km) + " km";
			t2.setText(wynik);
			wynik = String.valueOf(m) + " m";
			t3.setText(wynik);
			break;
		case 2:
			cm = wpisana * 100000;
			cal = cm / wartCal;
			m = wpisana * 1000;
			wynik = String.valueOf(cm) + " cm";
			t1.setText(wynik);
			wynik = String.valueOf(cal) + " w calach";
			t2.setText(wynik);
			wynik = String.valueOf(m) + " m";
			t3.setText(wynik);
			break;
		case 3:
			cm = wpisana * 100;
			cal = cm / wartCal;
			km = wpisana / 1000;
			wynik = String.valueOf(cm) + " cm";
			t1.setText(wynik);
			wynik = String.valueOf(cal) + " w calach";
			t2.setText(wynik);
			wynik = String.valueOf(km) + " km";
			t3.setText(wynik);
			break;
		}

	}

	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long arg3) {
		parent.getItemAtPosition(pos);
		if (pos == 0) {
			position = 0;
		} else if (pos == 1) {
			position = 1;
		} else if (pos == 2) {
			position = 2;
		} else if (pos == 3) {
			position = 3;
		}
		wpis();
	}

	public void onNothingSelected(AdapterView<?> adapterView) {
	}
}
