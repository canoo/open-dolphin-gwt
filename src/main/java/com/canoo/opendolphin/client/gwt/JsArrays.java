package com.canoo.opendolphin.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.List;

public class JsArrays {

	/**
	 * {@code JsArray<T> array} converted to {@code List<T>}
	 */
	public static <T extends JavaScriptObject> List<T> jsArrayToList(JsArray<T> array) {
		List<T> result = new ArrayList<T>(array.length());
		for (int i = 0; i < array.length(); i++) {
			 result.add(array.get(i));

		}
		return result;
	}
}
