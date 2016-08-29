package com.adalwin.controller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.cxf.helpers.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * This class mainly meant to get the data from Xls, and Csv file format
 * 
 * @author aramar1
 * @version 1.0
 * @since 1.0
 */
public class DataLogFetcher {

	private String rawFileName = null;
	private String xmlFileName = null;
	private String env;
	private static final Logger s_logger = LoggerFactory
			.getLogger(DataLogFetcher.class);
	private String[] csvHeaders;
	private Method currentTestMethod;
	/**
	 * This is the constructor to assign file name.
	 * 
	 * @param fileName
	 */
	public DataLogFetcher(String rawFileName,String xmlFileName) {
		this.rawFileName = rawFileName;
		this.xmlFileName = xmlFileName;
	}
	
	
	/**
	 * This function is to read data from CSV
	 * 
	 * @return Data from CSV in array of string format
	 * @throws IOException
	 */
	public String transformToWellFormedXML() throws IOException {

		ArrayList<String> dataInputAsLines=null;
		int recordsSize=0;
		 StringBuilder transfromedLines = new StringBuilder();
		 StringBuilder stationConfiguration = new StringBuilder();
		InputStream inputLogFile;
			try {
			//Reader br = new FileReader(fileName);
			//System.out.println(in);
			File file = new File(rawFileName);
	        List<String> lines = FileUtils.readLines(file);
	       
	        for (String s : lines){
	        	//s.replace("\\s+(</[^>]+>)\\s+(<[^>]+>)","");
	        	s = s.replaceAll("\\s*<\\s*", "<");
	        	s = s.replaceAll("\\s*>\\s*", ">");
	        	s = s.replaceAll("\\s*</\\s*", "</");
	        	transfromedLines.append(s);
	        	transfromedLines.append("\n");
	        }
	        	
	        
			} catch (Exception e) {
				s_logger.error("Exception in reading Log file " + e.getMessage());
			}
			transfromedLines.append("</TopLevel>");
			return transfromedLines.toString();
	}
	
	public boolean matchPattern(String tagName, String dataLine){

		
		
		
	}
	public void parseXml(){
		
		
		try {

			File fXmlFile = new File(xmlFileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("StationConfiguration");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					System.out.println("DateTime" + eElement.getElementsByTagName("DateTime").item(0).getTextContent());
					
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		
		
	}
	
	
}
