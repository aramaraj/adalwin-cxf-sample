package com.adalwin.pov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;


public class MobilePov {
@SerializedName("Status")
private Integer status;
@SerializedName("Message")
private String message;
@SerializedName("Request")
private RequestModel request;
@SerializedName("LastModified")
private String lastModified;
@SerializedName("POVs")
private List<POV> POVs = new ArrayList<POV>();


/**
* 
* @return
* The status
*/
public Integer getStatus() {
return status;
}

/**
* 
* @param status
* The Status
*/
public void setStatus(Integer status) {
this.status = status;
}

/**
* 
* @return
* The message
*/
public String getMessage() {
return message;
}

/**
* 
* @param message
* The Message
*/
public void setMessage(String message) {
this.message = message;
}

/**
* 
* @return
* The request
*/
public RequestModel getRequest() {
return request;
}

/**
* 
* @param request
* The Request
*/
public void setRequest(RequestModel request) {
this.request = request;
}

/**
* 
* @return
* The lastModified
*/
public String getLastModified() {
return lastModified;
}

/**
* 
* @param lastModified
* The LastModified
*/
public void setLastModified(String lastModified) {
this.lastModified = lastModified;
}

/**
* 
* @return
* The pOVs
*/
public List<POV> getPOVs() {
return POVs;
}

/**
* 
* @param pOVs
* The POVs
*/
public void setPOVs(List<POV> POVs) {
this.POVs = POVs;
}



}