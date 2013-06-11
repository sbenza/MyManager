package com.example.vacao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockListFragment;
import com.example.vacao.DaoMaster.DevOpenHelper;

public class CattleManager extends SherlockListFragment implements
		ActionBar.TabListener {
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private CattleDao cattleDao;
	
	private Cursor cursor;
	private Fragment mFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from fragment2.xml
		getActivity().setContentView(R.layout.activity_cattle_manager);
		
		Log.i("vacao", "db criando");
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApp.getInstance(), "this",null);
//		DaoMaster.DevOpenHelper(this, "myCattle", null);
		db= helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();
		cattleDao = daoSession.getCattleDao();
		
		Log.i("vacao", "db criado");
		
		String stampColumn = CattleDao.Properties.Stamp.columnName;
		cursor = db.query(cattleDao.getTablename(), cattleDao.getAllColumns(), null, null, null, null, null);
		String[] from = { stampColumn, CattleDao.Properties.Stamp.columnName };
		int[] to = { android.R.id.text1, android.R.id.text2 };

		Log.i("vacao", "list");
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(MyApp.getInstance(), android.R.layout.simple_list_item_2, cursor, from,
                to);
		ListView myList=(ListView)getActivity().findViewById(R.id.listView1);
//
		myList.setAdapter(adapter);
//		

        
        
	}
//	public void openNewCattle(View view) {
//		 Context context = getApplicationContext();
//		 CharSequence text = "Hello open!";
//	        int duration = Toast.LENGTH_SHORT;
//
//	        Toast toast = Toast.makeText(context, text, duration);
//	        toast.show();
//	        
//		Intent intent = new Intent(this, NewCattle.class);
//		startActivity(intent);
//
//	}
//
//	public void openEditCattle(View view) {
//		Intent intent = new Intent(this, EditCattle.class);
//		startActivity(intent);
//
//	}
//	
//	public void openCattleDetail(View view) {
//		Intent intent = new Intent(this, CattleDetail.class);
//		startActivity(intent);
//
//	}

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mFragment = new CattleManager();
		// Attach fragment2.xml layout
		ft.add(android.R.id.content, mFragment);
		ft.attach(mFragment);
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Remove fragment2.xml layout
		ft.remove(mFragment);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

}
