package com.adalwin.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class DataLogExtractorController {

public static String inputFile="/Users/aramar1/Downloads/Pov_demo/Datalog_711/Alien711_DetailLog20160512_000.txt";
public static String xmlTransformFile="/Users/aramar1/Downloads/Pov_demo/Datalog_711/Alien711_DetailLog20160512_000.xml";

public static void main(String args[]){
	try{
		extractDataFromLog();
	}catch (Exception e){
		e.printStackTrace();
	}
	
}	
public static void extractDataFromLog()throws Exception{
	ArrayList <Map<String,String>> arrayListData;
	DataLogFetcher df = new DataLogFetcher(inputFile,xmlTransformFile);
	
	//get the csv file location
	//extract the content
	try{
		
		writeToFile(df.transformToWellFormedXML());
		df.parseXml();
		
	}catch (IOException ioe){
		
	}
	
}

/**
 * this method is used to write into a file using the content and the file
 * object
 * @param pFile
 * @param pContent
 * @return boolean
 */
public static  boolean writeToFile(String dataAsXML) {
    boolean isWriteSuccessful = false;
    File file = new File(xmlTransformFile);
	
    try{
    
    	    // if file doesnt exists, then create it 
    	    if ( ! file.exists( ) )
    	    {
    	    	System.out.println("inside the not exists"+file.getAbsolutePath());
    	        file.createNewFile( );
    	    }
    	    System.out.println("oiyeeee");
    	    FileWriter fw = new FileWriter( file.getAbsoluteFile( ) );
    	    BufferedWriter bw = new BufferedWriter( fw );
    	    bw.write(dataAsXML);
    	    bw.close( );
     }
    catch (IOException l_oIOE) {
    	l_oIOE.printStackTrace();
    }
    finally {
       
    }
    return isWriteSuccessful;
}
	
}
