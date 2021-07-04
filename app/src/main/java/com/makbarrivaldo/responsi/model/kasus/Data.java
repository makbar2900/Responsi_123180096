package com.makbarrivaldo.responsi.model.kasus;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<ContentItem> content;

	public Metadata getMetadata(){
		return metadata;
	}

	public ArrayList<ContentItem> getContent(){
		return content;
	}
}