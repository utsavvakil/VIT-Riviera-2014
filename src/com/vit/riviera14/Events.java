package com.vit.riviera14;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Events 
{
	int id;
	String title;
	int day;
	String time;
	String location;
	String googleMapsURL;
	String rules;
	String cashPrizefirst;
	String cashPrizesecond;
	String cashPrizethird;
	String coordinator1;
	String coordinator1Contact;
	String coordinator2;
	String coordinator2Contact;
	String description;
	private String[] prize;
	private JSONObject data;
	
	public Events()
	{
		this.prize= new String[5];
	}
	public Events(int slno, JSONObject jsonData,int dayParam)
	{	this.data= jsonData;
		this.day=dayParam;
		try 
		{
			//id = jsonData.getString("id");
			id= slno+1;
			title = jsonData.getString("event_name");;
			if(title.equals("NULL"))
			{
				title = "Not Available";
			}
			
			time = jsonData.getString("event_time");
			if(time.equals("NULL"))
			{
				time = "Not Available";
			}
			
			location = jsonData.getString("event_location");
			if(location.equals("NULL"))
			{
				location = "Not Available";
			}
			
			googleMapsURL = jsonData.getString("event_loclink");
			if(googleMapsURL.equals("NULL"))
			{
				googleMapsURL = "https://www.google.co.in/maps/preview/place/VIT+University,+Vellore,+Tamil+Nadu/@12.9713945,79.157423,16z/data=!3m1!4b1!4m2!3m1!1s0x3bad47a17f3461c1:0x1ace7a2a7f8ccfbf";
			}
			
			rules = jsonData.getString("event_rules");
			if(rules.equals("NULL"))
			{
				rules = "Not Available";
			}
			
			String temp = jsonData.getString("event_room");
			if(!temp.equals("NULL"))
			{
				location += " ("+temp+")";
			}
			
			description =  jsonData.getString("event_desc");
			if(description.equals("NULL"))
			{
				description = "Not Available";
			}
			
			coordinator1 = jsonData.getString("event_co1");
			coordinator1Contact = jsonData.getString("event_com1");
			if(coordinator1.equals("NULL"))
			{
				coordinator1 = "Not Available";
			}
			if(coordinator1Contact.equals("NULL"))
			{
				coordinator1Contact = "Not Available";
			}
			
			coordinator2 = jsonData.getString("event_co2");
			coordinator2Contact = jsonData.getString("event_com2");
			
			if(coordinator2.equals("NULL"))
			{
				coordinator2 = "Not Available";
			}
			if(coordinator2Contact.equals("NULL"))
			{
				coordinator2Contact = "Not Available";
			}
			
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
	}
	public String getTitle(){
		return this.title;
	}
	public String getTime(){
		return this.time;
	}
	public String getLoc(){
		return this.location;
	}
	public String getCat(){
		return this.location;
	}
	public String getDesc(){
		return this.description;
	}
	public String getRules(){
		return this.rules;
	}
	public String getCor1Name(){
		return this.coordinator1;
	}
	public String getCor2Name(){
		return this.coordinator2;
	}
	public String getCor1phone(){
		return this.coordinator1Contact;
	}
	
	public String getCor2phone()
	{
		return this.coordinator2Contact;
	}
	
	public String getGoogleMapsURL()
	{
		return this.googleMapsURL;
	}
	
	public int getDay()
	{
		return this.day;
	}
	
}
