package com.target.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApplicationUtil {

	private static final Gson GSON_MAPPER = new GsonBuilder().serializeNulls().create();

	public static <T> T convertJsonToObject(String jsonString, Class<T> clazz) {
		T requestObject = GSON_MAPPER.fromJson(jsonString, clazz);
		return requestObject;
	}
}
