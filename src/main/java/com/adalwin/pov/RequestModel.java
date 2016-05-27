package com.adalwin.pov;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class RequestModel {
@SerializedName("ClubMode")
private Boolean clubMode;
@SerializedName("DeviceType")
private String deviceType;
@SerializedName("MinLastModifiedDateUtc")
private String minLastModifiedDateUtc;
@SerializedName("Resolution")
private String resolution;




public RequestModel(Boolean clubMode,String deviceType,String minLastModifiedDateUtc,String resolution){
	this.clubMode = clubMode;
	this.deviceType = deviceType;
	this.minLastModifiedDateUtc = minLastModifiedDateUtc;
	this.resolution = resolution;
}
/**
* 
* @return
* The clubMode
*/
public Boolean getClubMode() {
return clubMode;
}

/**
* 
* @param clubMode
* The ClubMode
*/
public void setClubMode(Boolean clubMode) {
this.clubMode = clubMode;
}

/**
* 
* @return
* The deviceType
*/
public String getDeviceType() {
return deviceType;
}

/**
* 
* @param deviceType
* The DeviceType
*/
public void setDeviceType(String deviceType) {
this.deviceType = deviceType;
}

/**
* 
* @return
* The minLastModifiedDateUtc
*/
public String getMinLastModifiedDateUtc() {
return minLastModifiedDateUtc;
}

/**
* 
* @param minLastModifiedDateUtc
* The MinLastModifiedDateUtc
*/
public void setMinLastModifiedDateUtc(String minLastModifiedDateUtc) {
this.minLastModifiedDateUtc = minLastModifiedDateUtc;
}

/**
* 
* @return
* The resolution
*/
public String getResolution() {
return resolution;
}

/**
* 
* @param resolution
* The Resolution
*/
public void setResolution(String resolution) {
	this.resolution = resolution;
}
}

