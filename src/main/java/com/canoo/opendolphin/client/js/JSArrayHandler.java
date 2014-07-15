package com.canoo.opendolphin.client.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public interface JSArrayHandler<T extends JavaScriptObject> {
	public void handleElements(JsArray<T> elements);
}
