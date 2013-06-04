package com.example.mymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	//public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

	/** Called when the user clicks a button */
	public void openStock(View view) {
		Intent intent = new Intent(this, StockManager.class);
		startActivity(intent);

	}

	public void openActivities(View view) {
		Intent intent = new Intent(this, ControlManager.class);
		startActivity(intent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	
}
