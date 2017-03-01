package com.vit.riviera14;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Sponsors extends Activity
{

	Typeface font;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sponsors);
		
		font = Typeface.createFromAsset(getAssets(), "BrandonText-Medium.otf");
		
		TextView yourTextView;
		
		
		try
		{
			int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    yourTextView = (TextView) findViewById(titleId);
	    yourTextView.setTypeface(font);
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	    yourTextView = (TextView)findViewById(R.id.sponsorThanks);
	    yourTextView.setTypeface(font);
	    
	}
	
	
	
	
}
