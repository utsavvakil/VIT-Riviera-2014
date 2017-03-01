package com.vit.riviera14;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SearchResultsActivity extends Activity implements OnItemClickListener {



	int count = 0;
	int[] indexes;
	String[] titles;
	String[] location;
	String[] category;
	String[] time;
	String[] description;
	String[] rules;
	String[] cord1_name;
	String[] cord2_name;
	String[] cord1_contact;
	String[] cord2_contact;
	String[] googleMaps;
	String googleMapsLink;
	int[] days;


	Typeface font;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
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


		String sharedPrefKey = "searchbuddy";
		SharedPreferences pref = getSharedPreferences(sharedPrefKey, 0);
		String str = pref.getString("searchstate", "error");

		if(str.equals("sports"))
		{
			String query = getSearchString(getIntent());
			Intent intent = new Intent(this, SportsSearch.class);
			
			Bundle bundle = new Bundle();
			bundle.putString("query", query);
			intent.putExtras(bundle);
			finish();
			
			startActivity(intent);
		}
		else
		{
			handleIntent(getIntent());
		}

	}

	private String getSearchString(Intent intent) 
	{
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) 
		{
			String query = intent.getStringExtra(SearchManager.QUERY);
			return query;
		}
		else
		{
			return null;
		}
	}

	@Override
	protected void onNewIntent(Intent intent) {
		setIntent(intent);
		handleIntent(intent);
	}

	/**
	 * Handling intent data
	 */
	private void handleIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);

			/**
			 * Use this query to display search results like 
			 * 1. Getting the data from SQLite and showing in listview 
			 * 2. Making webrequest and displaying the data 
			 * For now we just display the query only
			 */

			DatabaseHandler db = new DatabaseHandler(this);



			List<Events> event_1=db.getEvents(1);
			List<Events> event_2=db.getEvents(2);
			List<Events> event_3=db.getEvents(3);
			List<Events> event_4=db.getEvents(4);


			titles = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			location = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			category = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			time = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			description = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			rules = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			cord1_name = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			cord2_name = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			cord1_contact = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			cord2_contact = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			googleMaps = new String[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			days = new int[event_1.size()+event_2.size()+event_3.size()+event_4.size()];
			int i=0;
			for (Events cn : event_1)
			{

				titles[i]=""+cn.getTitle();
				time[i]=""+cn.getTime();
				location[i]=""+cn.getLoc();
				category[i]=""+cn.getCat();
				description[i]=""+cn.getDesc();
				rules[i]=""+cn.getRules();
				cord1_name[i]=""+cn.getCor1Name();
				cord2_name[i]=""+cn.getCor2Name();
				cord1_contact[i]=""+cn.getCor1phone();
				cord2_contact[i]=""+cn.getCor2phone();
				googleMaps[i] = ""+cn.getGoogleMapsURL();
				days[i] = cn.getDay()+5;
				i++;

			}
			for (Events cn : event_2)
			{

				titles[i]=""+cn.getTitle();
				time[i]=""+cn.getTime();
				location[i]=""+cn.getLoc();
				category[i]=""+cn.getCat();
				description[i]=""+cn.getDesc();
				rules[i]=""+cn.getRules();
				cord1_name[i]=""+cn.getCor1Name();
				cord2_name[i]=""+cn.getCor2Name();
				cord1_contact[i]=""+cn.getCor1phone();
				cord2_contact[i]=""+cn.getCor2phone();
				googleMaps[i] = ""+cn.getGoogleMapsURL();
				days[i] = cn.getDay()+5;
				i++;

			}
			for (Events cn : event_3)
			{

				titles[i]=""+cn.getTitle();
				time[i]=""+cn.getTime();
				location[i]=""+cn.getLoc();
				category[i]=""+cn.getCat();
				description[i]=""+cn.getDesc();
				rules[i]=""+cn.getRules();
				cord1_name[i]=""+cn.getCor1Name();
				cord2_name[i]=""+cn.getCor2Name();
				cord1_contact[i]=""+cn.getCor1phone();
				cord2_contact[i]=""+cn.getCor2phone();
				googleMaps[i] = ""+cn.getGoogleMapsURL();
				days[i] = cn.getDay()+5;
				i++;

			}
			for (Events cn : event_4)
			{

				titles[i]=""+cn.getTitle();
				time[i]=""+cn.getTime();
				location[i]=""+cn.getLoc();
				category[i]=""+cn.getCat();
				description[i]=""+cn.getDesc();
				rules[i]=""+cn.getRules();
				cord1_name[i]=""+cn.getCor1Name();
				cord2_name[i]=""+cn.getCor2Name();
				cord1_contact[i]=""+cn.getCor1phone();
				cord2_contact[i]=""+cn.getCor2phone();
				googleMaps[i] = ""+cn.getGoogleMapsURL();
				days[i] = cn.getDay()+5;
				i++;

			}

			indexes = new int[200];

			for(int j = 0 ; j <i ; j++)
			{
				if((titles[j]).toUpperCase().indexOf(query.toUpperCase()) != -1)
				{

					boolean check = true;
					for(int x = 0; x < count ; x++)
					{
						if(titles[j].equals(titles[indexes[x]]))
						{
							days[indexes[x]] = (days[indexes[x]]*10) + days[j];
							check = false;
						}
					}

					if(check == true)
					{
						indexes[count] = j;
						count++;
					}

				}
			}

			if(count == 0)
			{
				TextView tvNoResults = (TextView)findViewById(R.id.tvNoResults);
				tvNoResults.setVisibility(View.VISIBLE);
			}


			ListView listView=(ListView)findViewById(R.id.listViewSports);

			List<RowItem> rowItems;
			rowItems = new ArrayList<RowItem>();
			for ( int a = 0; a<count ; a++)
			{
				RowItem item = new RowItem(titles[indexes[a]],time[indexes[a]],location[indexes[a]],"","#CCCCCC");
				rowItems.add(item);
			}
			CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems,font);
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(this);

		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
	{
		position = indexes[position];	

		String heading = titles[position];
		String time1 = time[position];
		String desc = description[position];
		String rules1 = rules[position];
		String venue = location[position];
		String coordinator1 = cord1_name[position];
		String coordinator1_contact = cord1_contact[position];
		String coordinator2 = cord2_name[position];
		String coordinator2_contact = cord2_contact[position];
		ImageView imageView;
		googleMapsLink = googleMaps[position];
		String date = "";

		int temp = days[position];
		int count = 0;
		int digit;
		while(temp > 0)
		{
			digit = temp%10;
			temp = temp/10;
			count++;
			date += digit+" ,";
		}

		date = date.substring(0, date.length()-2);
		StringBuffer sb = new StringBuffer(date);
		sb.reverse();
		date = sb.toString();
		date += " February";




		Dialog d = new Dialog(this);
		d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		d.setContentView(R.layout.cultural_dialog);
		((TextView)d.findViewById(R.id.tvEventName)).setText(heading);
		((TextView)d.findViewById(R.id.tvEventName)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvEventDates)).setText("Date : "+date);
		((TextView)d.findViewById(R.id.tvEventDates)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvEventTime)).setText("Time: "+time1);
		((TextView)d.findViewById(R.id.tvEventTime)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvEventVenue)).setText("Venue: "+venue+"\n");
		((TextView)d.findViewById(R.id.tvEventVenue)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvEventDesc)).setText("\nDescription: \n"+desc);
		((TextView)d.findViewById(R.id.tvEventDesc)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvHeadingCoordinators)).setTypeface(font);
		if(rules1.equals("NULL"))
		{
			rules1 = "Not Available";
		}
		else
		{
			if(rules1.length() == 6 )
			{
				rules1 = "Not Available";
			}
		}
		((TextView)d.findViewById(R.id.tvEventRules)).setText("\nRules: \n"+rules1);
		((TextView)d.findViewById(R.id.tvEventRules)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvCoord1)).setText(coordinator1 + " : ");
		((TextView)d.findViewById(R.id.tvCoord1)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvCoordPhone1)).setText(coordinator1_contact);
		((TextView)d.findViewById(R.id.tvCoordPhone1)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvCoord2)).setText(coordinator2 + " : ");
		((TextView)d.findViewById(R.id.tvCoord2)).setTypeface(font);
		((TextView)d.findViewById(R.id.tvCoordPhone2)).setText(coordinator2_contact);
		((TextView)d.findViewById(R.id.tvCoordPhone2)).setTypeface(font);

		imageView = (ImageView)d.findViewById(R.id.ivImageLocation);
		imageView.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View view) 
			{
				try
				{
					Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					startActivity(openMaps);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(googleMapsLink);
				}
			}
		}); 

		d.show();

	}
}
