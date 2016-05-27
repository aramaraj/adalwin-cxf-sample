package com.adalwin.pov;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;


public class Action {
@SerializedName("ItemId")
private String itemId;
@SerializedName("Link")
private String link;
@SerializedName("Name")
private String name;
@SerializedName("RequiresAuthentication")
private Boolean requiresAuthentication;
@SerializedName("Tag")
private String tag;

/**
* 
* @return
* The itemId
*/
public String getItemId() {
return itemId;
}

/**
* 
* @param itemId
* The ItemId
*/
public void setItemId(String itemId) {
this.itemId = itemId;
}

/**
* 
* @return
* The link
*/
public String getLink() {
return link;
}

/**
* 
* @param link
* The Link
*/
public void setLink(String link) {
this.link = link;
}

/**
* 
* @return
* The name
*/
public String getName() {
return name;
}

/**
* 
* @param name
* The Name
*/
public void setName(String name) {
this.name = name;
}

/**
* 
* @return
* The requiresAuthentication
*/
public Boolean getRequiresAuthentication() {
return requiresAuthentication;
}

/**
* 
* @param requiresAuthentication
* The RequiresAuthentication
*/
public void setRequiresAuthentication(Boolean requiresAuthentication) {
this.requiresAuthentication = requiresAuthentication;
}

/**
* 
* @return
* The tag
*/
public String getTag() {
return tag;
}

/**
* 
* @param tag
* The Tag
*/
public void setTag(String tag) {
this.tag = tag;
}


}