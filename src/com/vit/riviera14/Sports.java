package com.vit.riviera14;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class Sports extends Activity implements OnItemClickListener
{

	
	ImageView imageView;
	Typeface font;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sports);
		
		 
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
		
		
		
		ListView listView=(ListView)findViewById(R.id.listViewSports);
		
		List<RowItem> rowItems;
		rowItems = new ArrayList<RowItem>();
		for ( int i = 0; i<SportsStrings.titles.length ; i++)
		{
			RowItem item = new RowItem( SportsStrings.titles[i],SportsStrings.time[i],SportsStrings.venue[i],"","#CCCCCC");
			rowItems.add(item);
		}
		CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems,font);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
		/*ListView listView=(ListView)findViewById(R.id.listViewSports);
	        List<RowItemsports> rowItems;
	        rowItems = new ArrayList<RowItemsports>();
	        for (int i = 0; i<SportsStrings.titles.length; i++) 
	        {
	            RowItemsports item = new RowItemsports( SportsStrings.titles[i],SportsStrings.time[i],SportsStrings.venue[i],"#D47F28");
	            rowItems.add(item);
	        }
	        customBaseAdapterSports adapter = new customBaseAdapterSports(this, rowItems);
	        listView.setAdapter(adapter);
	        
	     listView.setOnItemClickListener(this);*/
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
	{
		String heading = SportsStrings.titles[position];
        String time = SportsStrings.time[position];
        String date = SportsStrings.dates[position];
        String venue = SportsStrings.venue[position];
        final String googleMapsLink = SportsStrings.googleMapsLinks[position];
        
        Dialog d = new Dialog(this);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d.setContentView(R.layout.sportsdialog);
        ((TextView)d.findViewById(R.id.tvSportName)).setText(heading);
        ((TextView)d.findViewById(R.id.tvSportName)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsDates)).setText("Dates: "+date);
        ((TextView)d.findViewById(R.id.tvSportsDates)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsTime)).setText("Time: "+time);
        ((TextView)d.findViewById(R.id.tvSportsTime)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsVenue)).setText("Venue: "+venue+"\n");
        ((TextView)d.findViewById(R.id.tvSportsVenue)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsRules)).setText(SportsStrings.RULES);
        ((TextView)d.findViewById(R.id.tvSportsRules)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsCo1)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsCom1)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsCo2)).setTypeface(font);
        ((TextView)d.findViewById(R.id.tvSportsCom2)).setTypeface(font);
        
        imageView = (ImageView)d.findViewById(R.id.ivSportsLocation);
        imageView.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View view) 
			{
				 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
			     startActivity(openMaps);
			}
		});
        
        d.show();
        
	}
	
	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		
		String sharedPrefKey = "searchbuddy";
		SharedPreferences pref = getSharedPreferences(sharedPrefKey, 0);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("searchstate", "sports");
		editor.commit();

		try
		{
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.splash, menu);

			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) 
			{
			// Associate searchable configuration with the SearchView
			SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
			SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
			searchView.setSearchableInfo(searchManager
					.getSearchableInfo(getComponentName()));
			}
		}
		catch(Exception e)
		{

		}

		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId()) 
	    {
	        case R.id.search:
	        	if (!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB))
	        	{
	        		onSearchRequested();
	        	}
	            return true;
	        default:
	            return false;
	    }
	}

	
}
