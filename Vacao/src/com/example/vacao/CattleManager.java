package com.example.vacao;

import com.example.vacao.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class CattleManager extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cattle_manager);
	}
	public void openNewCattle(View view) {
//		 Context context = getApplicationContext();
//		 CharSequence text = "Hello open!";
//	        int duration = Toast.LENGTH_SHORT;
//
//	        Toast toast = Toast.makeText(context, text, duration);
//	        toast.show();
	        
		Intent intent = new Intent(this, NewCattle.class);
		startActivity(intent);

	}

	public void openEditCattle(View view) {
		Intent intent = new Intent(this, EditCattle.class);
		startActivity(intent);

	}
	
	public void openCattleDetail(View view) {
		Intent intent = new Intent(this, CattleDetail.class);
		startActivity(intent);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cattle_manager, menu);
		return true;
	}

}
