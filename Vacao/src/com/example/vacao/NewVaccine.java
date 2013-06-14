package com.example.vacao;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vacao.DaoMaster.DevOpenHelper;

public class NewVaccine extends Activity {
private SQLiteDatabase db;
	
	private EditText nameText;

	
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private VaccineDao vaccineDao;
	
	private Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_vaccine);
		Toast.makeText(MyApp.getInstance(), "llego", Toast.LENGTH_SHORT).show();
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "myCattle", null);
		db= helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();
		vaccineDao = daoSession.getVaccineDao();
		
		nameText = (EditText) findViewById(R.id.vaccineName);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_vaccine, menu);
		return true;
	}
	
	public void onAddVaccineButtonClick(View view) {
		Context context = getApplicationContext();
		 CharSequence text = "Cattle Added!!!";
	        int duration = Toast.LENGTH_SHORT;

	        Toast toast = Toast.makeText(context, text, duration);
	        toast.show();
	        
	        String name = nameText.getText().toString();
	        nameText.setText("");

	        
	        Vaccine vaccine= new Vaccine(null,name);
	        vaccineDao.insert(vaccine);

	}

}
