package com.vit.riviera14;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.vit.riviera14.Culturals;

public class HomeActivity extends Activity implements OnClickListener
{
	
	SharedPreferences preferencesRef;
	ImageView ivCulturals, ivSports, ivRegistration, ivProshows, ivSponsors, ivContact;
	Typeface font;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		
		
		
		
		setContentView(R.layout.activity_home);
		
		
		
		font = Typeface.createFromAsset(getAssets(), "BrandonText-Medium.otf");
		
		try
		{
		int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    TextView yourTextView = (TextView) findViewById(titleId);
	    yourTextView.setTypeface(font);
		}
		catch(NullPointerException e )
		{
			e.printStackTrace();
		}
		preferencesRef=getSharedPreferences("refresh",0);
		SharedPreferences.Editor editor = preferencesRef.edit();
		editor.putString("status", "On destroy");
		editor.commit();
		 
		ivCulturals = (ImageView)findViewById(R.id.ivCulturals);
		ivCulturals.setOnClickListener(this);
		
		ivSports = (ImageView)findViewById(R.id.ivSports);
		ivSports.setOnClickListener(this);
		
		ivRegistration = (ImageView)findViewById(R.id.ivRegistration);
		ivRegistration.setOnClickListener(this);
		
		ivProshows = (ImageView)findViewById(R.id.ivProshows);
		ivProshows.setOnClickListener(this);
		
		ivSponsors = (ImageView)findViewById(R.id.ivSponsors);
		ivSponsors.setOnClickListener(this);
		
		ivContact = (ImageView)findViewById(R.id.ivContact);
		ivContact.setOnClickListener(this);
		
		
	
	}



	@Override
	public void onClick(View view)
	{
		
		Intent intent;
		switch(view.getId())
		{
			case R.id.ivCulturals:
				intent = new Intent(HomeActivity.this,Culturals.class);
				startActivity(intent);
			break;
			
			case R.id.ivSports:
				intent = new Intent(HomeActivity.this,Sports.class);
				startActivity(intent);
			break;
			
			case R.id.ivRegistration:
				intent = new Intent(HomeActivity.this,Registration.class);
				startActivity(intent);
			break;
			
			case R.id.ivProshows:
				intent = new Intent(HomeActivity.this,Proshows.class);
				startActivity(intent);
			break;
			
			case R.id.ivSponsors:
				intent = new Intent(HomeActivity.this,Sponsors.class);
				startActivity(intent);
			break;
			
			case R.id.ivContact:
				intent = new Intent(HomeActivity.this,Contact.class);
				startActivity(intent);
			break;
		}
	}
	


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
		super.onPause();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.privacypolicy, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		Intent intent = new Intent(this, PrivacyPolicy.class);
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}
	
	
	
}
