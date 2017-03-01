package com.vit.riviera14;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact extends Activity implements OnClickListener
{

	Typeface font;
	ImageView ivWWW, ivFacebook;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		font = Typeface.createFromAsset(getAssets(), "BrandonText-Medium.otf");
		TextView yourTextView;
		
		ivWWW = (ImageView)findViewById(R.id.ivwww);
		ivWWW.setOnClickListener(this);
		ivFacebook = (ImageView)findViewById(R.id.ivfacebook);
		ivFacebook.setOnClickListener(this);
		
		
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
	    
	    yourTextView = (TextView) findViewById(R.id.tvVIT1);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvVIT2);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvVIT3);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tVName1);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvPhone1);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tVName2);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvPhone2);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tVName3);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvPhone3);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvEmail);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvEmailID);
	    yourTextView.setTypeface(font);
	}

	@Override
	public void onClick(View view)
	{
		
		switch(view.getId())
		{
			case R.id.ivwww:
				String URL1= "http://vitriviera.com/";
				Intent website1 = new Intent(Intent.ACTION_VIEW,Uri.parse(URL1));
			     startActivity(website1);
				
				break;
			
			case R.id.ivfacebook:
				String URL2 = "https://www.facebook.com/riviera.vit14";
				Intent website2 = new Intent(Intent.ACTION_VIEW,Uri.parse(URL2));
			     startActivity(website2);
				break;
		}
	}
	
	
}