package com.example.vacao;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VaccineManager extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vaccine_manager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vaccine_manager, menu);
		return true;
	}

}
