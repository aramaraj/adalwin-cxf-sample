package com.adalwin.pov;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class POV {
@SerializedName("Action")
private Action action;
@SerializedName("Description")
private String description;
@SerializedName("EndDate")
private String endDate;
@SerializedName("ImageUrl")
private String imageUrl;
@SerializedName("SequenceNumber")
private Integer sequenceNumber;
@SerializedName("Spotlight")
private Boolean spotlight;
@SerializedName("Title")
private String title;

public Action getAction() {
return action;
}

/**
* 
* @param action
* The Action
*/
public void setAction(Action action) {
this.action = action;
}

/**
* 
* @return
* The description
*/
public String getDescription() {
return description;
}

/**
* 
* @param description
* The Description
*/
public void setDescription(String description) {
this.description = description;
}

/**
* 
* @return
* The endDate
*/
public String getEndDate() {
return endDate;
}

/**
* 
* @param endDate
* The EndDate
*/
public void setEndDate(String endDate) {
this.endDate = endDate;
}

/**
* 
* @return
* The imageUrl
*/
public String getImageUrl() {
return imageUrl;
}

/**
* 
* @param imageUrl
* The ImageUrl
*/
public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

/**
* 
* @return
* The sequenceNumber
*/
public Integer getSequenceNumber() {
return sequenceNumber;
}

/**
* 
* @param sequenceNumber
* The SequenceNumber
*/
public void setSequenceNumber(Integer sequenceNumber) {
this.sequenceNumber = sequenceNumber;
}

/**
* 
* @return
* The spotlight
*/
public Boolean getSpotlight() {
return spotlight;
}

/**
* 
* @param spotlight
* The Spotlight
*/
public void setSpotlight(Boolean spotlight) {
this.spotlight = spotlight;
}

/**
* 
* @return
* The title
*/
public String getTitle() {
return title;
}

/**
* 
* @param title
* The Title
*/
public void setTitle(String title) {
this.title = title;
}


}
