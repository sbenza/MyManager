package com.example.vacao;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.vacao.DaoMaster.DevOpenHelper;


public class CattleDetail extends Activity {
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private CattleDao cattleDao;
	
	private Cursor cursor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cattle_detail);
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "myCattle", null);
		db= helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();
		cattleDao = daoSession.getCattleDao();
		
		String stampColumn = CattleDao.Properties.Stamp.columnName;
		cursor = db.query(cattleDao.getTablename(), cattleDao.getAllColumns(), null, null, null, null, null);
		String[] from = { stampColumn, CattleDao.Properties.Stamp.columnName };
		int[] to = { android.R.id.text1, android.R.id.text2 };

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from,
                to);
		ListView myList=(ListView)findViewById(android.R.id.list);

		myList.setAdapter(adapter);
        
		

		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cattle_detail, menu);
		return true;
	}

}
