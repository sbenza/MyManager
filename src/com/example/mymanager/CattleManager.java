package com.example.mymanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CattleManager extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cattle_manager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cattle_manager, menu);
		return true;
	}

}
