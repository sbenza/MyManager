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

public class NewCattle extends Activity {
	private SQLiteDatabase db;
	
	private EditText stampText;
	private EditText tagText;
	private EditText colorText;
	private EditText commentText;
	private EditText breedText;
	private EditText hornText;
	private EditText typeText;
	
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private CattleDao cattleDao;
	
	private Cursor cursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_cattle);
		Toast.makeText(MyApp.getInstance(), "llego", Toast.LENGTH_SHORT).show();
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "myCattle", null);
		db= helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();
		cattleDao = daoSession.getCattleDao();
		
		stampText = (EditText) findViewById(R.id.stamp);
		tagText = (EditText) findViewById(R.id.tag);
		colorText = (EditText) findViewById(R.id.color);
		commentText = (EditText) findViewById(R.id.comment);
		breedText = (EditText) findViewById(R.id.breed);
		typeText = (EditText) findViewById(R.id.type);
		hornText = (EditText) findViewById(R.id.horn);
		
		
	}
	
	public void onMyButtonClick(View view) {
		Context context = getApplicationContext();
		 CharSequence text = "Cattle Added!!!";
	        int duration = Toast.LENGTH_SHORT;

	        Toast toast = Toast.makeText(context, text, duration);
	        toast.show();
	        
	        String stamp = stampText.getText().toString();
	        stampText.setText("");

	        
	        Cattle cattle= new Cattle(null,stamp, stamp,stamp,stamp,stamp,stamp,stamp);
	        cattleDao.insert(cattle);

	}
	
	 
	 
	 private void addCattle() {
	        String stamp = stampText.getText().toString();
	        stampText.setText("");

	        
	        Cattle cattle= new Cattle(null,stamp, stamp,stamp,stamp,stamp,stamp,stamp);
	        cattleDao.insert(cattle);
	       
	        cursor.requery();
	    }

	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_cattle, menu);
		return true;
	}

}
