package com.adalwin.controller;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adalwin.pov.Action;
import com.adalwin.pov.MobilePov;
import com.adalwin.pov.POV;
import com.adalwin.pov.RequestModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * This class mainly meant to get the data from Xls, and Csv file format
 * 
 * @author aramar1
 * @version 1.0
 * @since 1.0
 */
public class DataFetcher {

	private String fileName = null;
	private String env;
	private static final Logger s_logger = LoggerFactory
			.getLogger(DataFetcher.class);
	private String[] csvHeaders;
	private Method currentTestMethod;
	/**
	 * This is the constructor to assign file name.
	 * 
	 * @param fileName
	 */
	public DataFetcher(String fileName) {
		this.fileName = fileName;
	}
	
	
	/**
	 * This function is to read data from CSV
	 * 
	 * @return Data from CSV in array of string format
	 * @throws IOException
	 */
	public ArrayList<Map<String,String>> getDataFromCSV() throws IOException {
		ArrayList<CSVRecord> records = new ArrayList<CSVRecord>();
		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<Map<String,String>> jsonValues=null;
		int recordsSize=0;
		InputStream inputCSVFile;
			try {
			Reader in = new FileReader(fileName);
			System.out.println(in);
				CSVParser parser = CSVFormat.DEFAULT.parse(in);
				records =(ArrayList)parser.getRecords();
				recordsSize=records.size();
				jsonValues=new ArrayList<Map<String,String>>(records.size()-1);
					for (int i = 0;i<recordsSize;i++) {
						if(i == 0){
							int columnSize=records.get(i).size();
							for(int column=0;column<columnSize;column++){
								headers.add(records.get(i).get(column));
							}
						}else{
							Map <String,String> recordsMap = new HashMap<String,String>();
							for(int valueColumn=0;valueColumn<headers.size();valueColumn++){
								recordsMap.put(headers.get(valueColumn),records.get(i).get(valueColumn));
							}
							jsonValues.add(recordsMap);
							}
						}
			} catch (Exception e) {
				s_logger.error("Exception in reading CSV file " + e.getMessage());
			}
			return jsonValues;
	}
	
	public String getJsonString(ArrayList<Map<String,String>> arrayListJson) throws Exception{
		//Gson gson = new Gson();
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		RequestModel reqModel=new RequestModel(true,"mweb", "/Date(-2208924000000-0600)/",null);
		MobilePov mobilePovJson=new MobilePov();
		mobilePovJson.setRequest(reqModel);
		mobilePovJson.setStatus(0);
		mobilePovJson.setLastModified("/Date(-2208924000000-0600)/");
		mobilePovJson.setMessage("OK");
		String finalJson=null;
		List<POV> pOVs = new ArrayList<POV>();
		System.out.println("Array list json size "+arrayListJson.size());
		for(Map<String,String> recordValue : arrayListJson){
			Action actionObject = new Action();
			POV pov = new POV();
			
			if(recordValue.get("Action/ItemId").isEmpty()){
				actionObject.setItemId(null);
			}else{
				actionObject.setItemId(recordValue.get("Action/ItemId"));	
			}
			if(recordValue.get("Action/Link").isEmpty()){
				throw new Exception("Action link canot be empty");
			}else{
				actionObject.setLink(recordValue.get("Action/Link"));
			}
			
			actionObject.setName(recordValue.get("Action/Name"));
			actionObject.setRequiresAuthentication(Boolean.parseBoolean(recordValue.get("Action/RequiresAuthentication")));
			if(recordValue.get("Action/Tag").isEmpty()){
				actionObject.setTag(null);
			}else{
				actionObject.setTag(recordValue.get("Action/Tag"));
			}
			pov.setDescription(recordValue.get("Description"));
			pov.setEndDate(recordValue.get("EndDate"));
			pov.setImageUrl(recordValue.get("ImageUrl"));
			pov.setSequenceNumber(Integer.parseInt(recordValue.get("SequenceNumber")));
			pov.setSpotlight(Boolean.parseBoolean(recordValue.get("Spotlight")));
			pov.setTitle(recordValue.get("Title"));
			pov.setAction(actionObject);
			pOVs.add(pov);
		}
		mobilePovJson.setPOVs(pOVs);
		finalJson=gson.toJson(mobilePovJson).toString();
		System.out.println("finalJson"+finalJson);
		return finalJson;
	}
}
