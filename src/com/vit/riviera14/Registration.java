package com.vit.riviera14;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Registration extends Activity implements OnClickListener
{
	Typeface font;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		
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
	    
	    yourTextView = (TextView) findViewById(R.id.tvReg1);
	    yourTextView.setTypeface(font);
		
	    yourTextView = (TextView) findViewById(R.id.tvReg2);
	    yourTextView.setTypeface(font);
	    
	    yourTextView = (TextView) findViewById(R.id.tvRegister);
	    yourTextView.setTypeface(font);
	    yourTextView.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) 
	{
		 String str="http://academics.vit.ac.in/riviera";

		 Intent register = new Intent(Intent.ACTION_VIEW,Uri.parse(str));
	     startActivity(register);
	}
	
}