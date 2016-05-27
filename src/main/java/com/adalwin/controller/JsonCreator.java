package com.adalwin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class JsonCreator {


public static void main(String args[]){
	try{
		extractJson();
	}catch (Exception e){
		e.printStackTrace();
	}
	
}	
public static void extractJson()throws Exception{
	ArrayList <Map<String,String>> arrayListData;
	DataFetcher df = new DataFetcher("/Users/aramar1/Downloads/pov_mweb.csv");

	//get the csv file location
	//extract the content
	try{
		arrayListData = df.getDataFromCSV();
		df.getJsonString(arrayListData);
	}catch (IOException ioe){
		
	}
	
}
	
}
