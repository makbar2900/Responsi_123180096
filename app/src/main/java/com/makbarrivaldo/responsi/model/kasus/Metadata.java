package com.makbarrivaldo.responsi.model.kasus;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("last_update")
	private Object lastUpdate;

	public Object getLastUpdate(){
		return lastUpdate;
	}
}