package com.example.vacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class StockManager extends SherlockFragmentActivity {

	// Declare Tab Variable
	Tab tab;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Create the Actionbar
		ActionBar actionBar = getSupportActionBar();

		// Hide Actionbar Icon
		actionBar.setDisplayShowHomeEnabled(false);

		// Hide Actionbar Title
		actionBar.setDisplayShowTitleEnabled(true);

		// Create Actionbar Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create first Tab
		tab = actionBar.newTab().setTabListener(new CattleManager());
		// Create your own custom icon
		tab.setText(R.string.cattle);
		actionBar.addTab(tab);

		// Create Second Tab
		tab = actionBar.newTab().setTabListener(new VaccineManager());
		// Set Tab Title
		tab.setText(R.string.vaccine);
		actionBar.addTab(tab);

		// Create Third Tab
		tab = actionBar.newTab().setTabListener(new BullManager());
		// Set Tab Title
		tab.setText(R.string.insemination_bull);
		actionBar.addTab(tab);
	}

	public void openNewCattle(View view) {
//		CharSequence text = "Hello open!";
		// int duration = Toast.LENGTH_SHORT;
		Toast.makeText(MyApp.getInstance(), "llego", Toast.LENGTH_SHORT).show();

		Intent intent = new Intent(MyApp.getInstance(), NewCattle.class);
		startActivity(intent);
	}

	public void openCattleDetail(View view) {
//		CharSequence text = "Hello open!";
		// int duration = Toast.LENGTH_SHORT;
		Toast.makeText(MyApp.getInstance(), "llego", Toast.LENGTH_SHORT).show();

		Intent intent = new Intent(MyApp.getInstance(), CattleDetail.class);
		startActivity(intent);

	}

}
