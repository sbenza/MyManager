package com.example.vacao;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockListFragment;
import com.example.vacao.DaoMaster.DevOpenHelper;

public class BullManager extends SherlockListFragment implements
		ActionBar.TabListener {
	private Fragment mFragment;
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private BullOriginDao bullOriginDao;

	private Cursor cursor;

	
	public BullManager() {
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from fragment2.xml
		getActivity().setContentView(R.layout.activity_bull_manager);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle data) {
		// Inflate the ListView layout file.
		return inflater.inflate(R.layout.activity_bull_manager, null);
	}

	@Override
	public void onViewCreated(View arg0, Bundle arg1) {
		super.onViewCreated(arg0, arg1);
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApp.getInstance(),
				"myCattle", null);
		db = helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();
		bullOriginDao = daoSession.getBullOriginDao();

		String nameColumn = BullOriginDao.Properties.Name.columnName;
		cursor = db.query(bullOriginDao.getTablename(), bullOriginDao.getAllColumns(),
				null, null, null, null, null);
		String[] from = { nameColumn, BullOriginDao.Properties.Name.columnName };
		int[] to = { android.R.id.text1, android.R.id.text2 };
		@SuppressWarnings("deprecation")
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
				MyApp.getInstance(), android.R.layout.simple_list_item_2,
				cursor, from, to);
		setListAdapter(adapter);
	}


	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mFragment = new BullManager();
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
