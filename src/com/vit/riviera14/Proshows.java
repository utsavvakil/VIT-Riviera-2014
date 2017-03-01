package com.vit.riviera14;


import java.util.Locale;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Proshows extends FragmentActivity
{

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	static Typeface font;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.proshows);
		
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
		
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		mViewPager = (ViewPager) findViewById(R.id.pagerPro);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}

	
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		Bundle args;
		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.

			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			switch (position) {

			case 0:
				Fragment fragment = new DummySectionFragment();
				args = new Bundle();
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				fragment.setArguments(args);
				return fragment;

			case 1:
				Fragment fragment2 = new DummySectionFragment2();
				args = new Bundle();
				args.putInt(DummySectionFragment2.ARG_SECTION_NUMBER, position + 2);
				fragment2.setArguments(args);
				return fragment2;
			case 2:
				Fragment fragment3 = new DummySectionFragment3();
				args = new Bundle();
				args.putInt(DummySectionFragment3.ARG_SECTION_NUMBER, position + 3);
				fragment3.setArguments(args);
				return fragment3;
			case 3:
				Fragment fragment4 = new DummySectionFragment4();
				args = new Bundle();
				args.putInt(DummySectionFragment4.ARG_SECTION_NUMBER, position + 4);
				fragment4.setArguments(args);
				return fragment4;



			default:
				return null;
			}


		}


		@Override
		public int getCount() {
			// Show 3 total pages.
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);

			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	String heading;
    String time;
    String desc;
    String link;
    String venue = "Outdoor Stadium";
    final String googleMapsLink = ProshowsStrings.location;

	public static class DummySectionFragment extends Fragment implements OnClickListener, OnDismissListener
	{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		String heading;
	    String time;
	    String desc;
	    String link;
	    String venue = "Outdoor Stadium";
	    final String googleMapsLink = ProshowsStrings.location;

		
		ViewFlipper viewFlipper;
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() 
		{
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) 
		{
			View rootView = inflater.inflate(R.layout.proday1, container, false);
			viewFlipper = (ViewFlipper)rootView.findViewById(R.id.vfDay1Flipper);
			viewFlipper.setFlipInterval(1500);
			viewFlipper.startFlipping();
			
			ImageView ivShakthisree = (ImageView)rootView.findViewById(R.id.ivShakthisree);
			ivShakthisree.setOnClickListener(this);
			
			ImageView ivSalimSulaiman = (ImageView)rootView.findViewById(R.id.ivSalimSulaiman);
			ivSalimSulaiman.setOnClickListener(this);
			
			ImageView ivRannvijay = (ImageView)rootView.findViewById(R.id.ivRannvijay);
			ivRannvijay.setOnClickListener(this);

			return rootView;
		}

		@Override
		public void onClick(View view) 
		{
			Activity a = getActivity();
			Dialog d;
			ImageView imageView, imageView1;
			viewFlipper.stopFlipping();
			switch(view.getId())
			{
			case R.id.ivShakthisree:
				
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[0];
		        time = "7:45 PM";
		        link = ProshowsStrings.tubelinks[0];
		        desc = ProshowsStrings.description[0];
		        venue = "Outdoor Stadium";		        
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");

		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});

				d.show();
				d.setOnDismissListener(this);
				break;
				
			case R.id.ivRannvijay:
				
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[10];
		        time = "6:00 PM";
		        link = ProshowsStrings.tubelinks[11];
		        desc = ProshowsStrings.description[10];
		        venue = "Outdoor Stadium";		        
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");

		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});
				d.show();
				d.setOnDismissListener(this);
				break;

			case R.id.ivSalimSulaiman:
				
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[1];
		        time = "8:30 PM";
		        link = ProshowsStrings.tubelinks[1];
		        desc = ProshowsStrings.description[1];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});
				d.show();
				d.setOnDismissListener(this);
				break;			
			}
		}

		@Override
		public void onDismiss(DialogInterface arg0)
		{
			viewFlipper.startFlipping();
			
		}
		
		
	}
	public static class DummySectionFragment2 extends Fragment implements OnClickListener, OnDismissListener
	{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		ViewFlipper viewFlipper;
		String heading;
	    String time;
	    String desc;
	    String link;
	    String venue = "Outdoor Stadium";
	    final String googleMapsLink = ProshowsStrings.location;

		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment2() 
		{
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) 
		{
			View rootView = inflater.inflate(R.layout.proday2, container, false);
			viewFlipper = (ViewFlipper)rootView.findViewById(R.id.vfDay2Flipper);
			viewFlipper.setFlipInterval(1500);
			viewFlipper.startFlipping();
			
			ImageView ivSivamani = (ImageView)rootView.findViewById(R.id.ivSivamani);
			ivSivamani.setOnClickListener(this);
			
			ImageView ivStephen = (ImageView)rootView.findViewById(R.id.ivStephen);
			ivStephen.setOnClickListener(this);
			
			ImageView ivHaricharan = (ImageView)rootView.findViewById(R.id.ivHaricharan);
			ivHaricharan.setOnClickListener(this);
			
			ImageView ivSwetha = (ImageView)rootView.findViewById(R.id.ivSwethaMohan);
			ivSwetha.setOnClickListener(this);
			
			ImageView ivSreeram = (ImageView)rootView.findViewById(R.id.ivSreeram);
			ivSreeram.setOnClickListener(this);
			
			ImageView ivYesudas = (ImageView)rootView.findViewById(R.id.ivYesudas);
			ivYesudas.setOnClickListener(this);
			
			
			
			return rootView;
		}
		
		@Override
		public void onClick(View view) 
		{
			Activity a = getActivity();
			Dialog d;
			ImageView imageView;
			ImageView imageView1;
			viewFlipper.stopFlipping();
			switch(view.getId())
			{
			case R.id.ivSivamani:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[2];
		        time = "7:45 PM";
		        link = ProshowsStrings.tubelinks[2];
		        desc = ProshowsStrings.description[2];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});


				d.show();
				d.setOnDismissListener(this);
				break;			
				
			case R.id.ivStephen:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[3];
		        time = "7:45 PM";
		        link = ProshowsStrings.tubelinks[3];
		        desc = ProshowsStrings.description[3];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});


				d.show();
				d.setOnDismissListener(this);
				break;						
			case R.id.ivHaricharan:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[4];
		        time = "7:45 PM";
		        link = ProshowsStrings.tubelinks[4];
		        desc = ProshowsStrings.description[4];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});


				d.show();
				d.setOnDismissListener(this);
				break;						
			case R.id.ivSwethaMohan:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[5];
		        time = "7:45 PM";
		        link = ProshowsStrings.tubelinks[5];
		        desc = ProshowsStrings.description[5];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		       
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});

				d.show();
				d.setOnDismissListener(this);
				break;	
				
			case R.id.ivSreeram:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[9];
		        time = "6:00 PM";
		        link = ProshowsStrings.tubelinks[9];
		        desc = ProshowsStrings.description[9];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});


				d.show();
				d.setOnDismissListener(this);
				break;			
				
			case R.id.ivYesudas:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[6];
		        time = "7:45 PM";
		        link = ProshowsStrings.tubelinks[6];
		        desc = ProshowsStrings.description[6];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});

				d.show();
				d.setOnDismissListener(this);
				break;					
			}
		}

		@Override
		public void onDismiss(DialogInterface arg0)
		{
			viewFlipper.startFlipping();
			
		}
	}
	public static class DummySectionFragment3 extends Fragment implements OnClickListener, OnDismissListener
	{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		ViewFlipper viewFlipper;
		String heading;
	    String time;
	    String link;
	    String desc;
	    String venue = "Outdoor Stadium";
	    final String googleMapsLink = ProshowsStrings.location;
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment3() 
		{
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) 
		{
			View rootView = inflater.inflate(R.layout.proday3, container, false);
			viewFlipper = (ViewFlipper)rootView.findViewById(R.id.vfDay3Flipper);
			viewFlipper.setFlipInterval(1500);
			viewFlipper.startFlipping();
			
			ImageView ivPentagram = (ImageView)rootView.findViewById(R.id.ivPentagram);
			ivPentagram.setOnClickListener(this);
			
			ImageView ivFrisk = (ImageView)rootView.findViewById(R.id.ivFrisk);
			ivFrisk.setOnClickListener(this);
			
			ImageView ivJohnson = (ImageView)rootView.findViewById(R.id.ivJohnson);
			ivJohnson.setOnClickListener(this);

			return rootView;
		}
		
		@Override
		public void onClick(View view) 
		{
			Activity a = getActivity();
			Dialog d;
			ImageView imageView;
			ImageView imageView1;
			viewFlipper.stopFlipping();
			switch(view.getId())
			{
			case R.id.ivPentagram:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[7];
		        time = "9:15 PM";
		        link = ProshowsStrings.tubelinks[7];
		        desc = ProshowsStrings.description[7];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});

				d.show();
				d.setOnDismissListener(this);
				break;		
				
			case R.id.ivFrisk:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[12];
		        time = "6:00 PM";
		        link = ProshowsStrings.tubelinks[7];
		        desc = ProshowsStrings.description[12];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setVisibility(View.GONE);
		      

				d.show();
				d.setOnDismissListener(this);
				break;		
			case R.id.ivJohnson:
				d = new Dialog(a);
				
				heading = ProshowsStrings.titles[11];
		        time = "8:40 PM";
		        link = ProshowsStrings.tubelinks[7];
		        desc = ProshowsStrings.description[11];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setVisibility(View.GONE);

				d.show();
				d.setOnDismissListener(this);
				break;		

			}
		}

		@Override
		public void onDismiss(DialogInterface arg0)
		{
			viewFlipper.startFlipping();
			
		}
	}
	public static class DummySectionFragment4 extends Fragment implements OnClickListener, OnDismissListener
	{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		ViewFlipper viewFlipper;
		String heading;
	    String time;
	    String link;
	    String desc;
	    String venue = "Outdoor Stadium";
	    final String googleMapsLink = ProshowsStrings.location;

		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment4() 
		{
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) 
		{
			View rootView = inflater.inflate(R.layout.proday4, container, false);
			viewFlipper = (ViewFlipper)rootView.findViewById(R.id.vfDay4Flipper);
			viewFlipper.setFlipInterval(1500);
			viewFlipper.startFlipping();
			
			ImageView ivDJNight = (ImageView)rootView.findViewById(R.id.ivDJNight);
			ivDJNight.setOnClickListener(this);
			
			ImageView ivKarthi = (ImageView)rootView.findViewById(R.id.ivKarthi);
			ivKarthi.setOnClickListener(this);

			
			return rootView;
		}
		
		@Override
		public void onClick(View view) 
		{
			Activity a = getActivity();
			Dialog d;
			ImageView imageView;
			ImageView imageView1;
			viewFlipper.stopFlipping();
			switch(view.getId())
			{
			case R.id.ivDJNight:
				d = new Dialog(a);
				viewFlipper.stopFlipping();
				heading = ProshowsStrings.titles[8];
		        time = "6:00 PM";
		        link = ProshowsStrings.tubelinks[10];
		        desc = ProshowsStrings.description[8];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent youtube = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
					     startActivity(youtube);
					}
				});


				d.show();
				d.setOnDismissListener(this);
				break;		
			case R.id.ivKarthi:
				d = new Dialog(a);
				viewFlipper.stopFlipping();
				heading = ProshowsStrings.titles[13];
		        time = "6:00 PM";
		        link = ProshowsStrings.tubelinks[8];
		        desc = ProshowsStrings.description[13];
		        venue = "Outdoor Stadium";
		        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        d.setContentView(R.layout.prodialog);
		        ((TextView)d.findViewById(R.id.tvProName)).setText(heading);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setText(desc);
		        ((TextView)d.findViewById(R.id.tvProTime)).setText("Time: "+time);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setText("Venue: "+venue+"\n");
		        
		        ((TextView)d.findViewById(R.id.tvProName)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProDescription)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProTime)).setTypeface(font);
		        ((TextView)d.findViewById(R.id.tvProVenue)).setTypeface(font);
		        
		        
		        imageView = (ImageView)d.findViewById(R.id.ivProLocation);
		        imageView.setOnClickListener(new OnClickListener() 
		        {
					
					@Override
					public void onClick(View view) 
					{
						 Intent openMaps = new Intent(Intent.ACTION_VIEW,Uri.parse(googleMapsLink));
					     startActivity(openMaps);
					}
				});
		        imageView1 = (ImageView)d.findViewById(R.id.ivProTube);
		        imageView1.setVisibility(View.GONE);


				d.show();
				d.setOnDismissListener(this);
				break;		
				
						}
		}

		@Override
		public void onDismiss(DialogInterface arg0)
		{
			viewFlipper.startFlipping();
			
		}
	}
		
}
