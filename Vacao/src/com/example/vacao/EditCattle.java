package com.example.vacao;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class EditCattle extends SherlockFragmentActivity  {

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
        actionBar.setDisplayShowTitleEnabled(false);
 
        // Create Actionbar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
 
        // Create first Tab
//        tab = actionBar.newTab().setTabListener(new FragmentsTab1());
//        // Create your own custom icon
//        tab.setIcon(R.drawable.tab1);
//        actionBar.addTab(tab);
 
        // Create Second Tab
//        tab = actionBar.newTab().setTabListener(new BullManager());
//        // Set Tab Title
//        tab.setText("Tab2");
//        actionBar.addTab(tab);
 
//        // Create Third Tab
//        tab = actionBar.newTab().setTabListener(new FragmentsTab3());
//        // Set Tab Title
//        tab.setText("Tab3");
//        actionBar.addTab(tab);
    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        //setTheme(SampleList.THEME); //Used for theme switching in samples
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_edit_cattle);
//        mSelected = (TextView)findViewById(R.id.text);
//
//        
//        
//        
//        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        for (int i = 1; i <= 3; i++) {
//            ActionBar.Tab tab = getSupportActionBar().newTab();
//            tab.setText("Tab " + i);
//            tab.setTabListener(this);
//            getSupportActionBar().addTab(tab);
//        }
//    }
//
//    @Override
//    public void onTabReselected(Tab tab, FragmentTransaction transaction) {
//    }
//
//    @Override
//    public void onTabSelected(Tab tab, FragmentTransaction transaction) {
//        mSelected.setText("Selected: " + tab.getText());
//    }
//
//    @Override
//    public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
//    }
}