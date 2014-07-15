package com.canoo.opendolphin.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.List;

public interface JSListHandler<T extends JavaScriptObject> {
	public void handleElements(List<T> elements);
}
