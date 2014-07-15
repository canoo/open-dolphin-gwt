package com.canoo.opendolphin.client.js;

import com.canoo.opendolphin.client.gwt.ClientDolphin;
import com.google.gwt.core.client.JavaScriptObject;

public class OpenDolphinJS extends JavaScriptObject
{

	protected OpenDolphinJS() {
	}

	public final native ClientDolphin newClientDolphinInstance(String dolphinURL, boolean reset, int slack) /*-{
		return this.dolphin(dolphinURL, reset, slack);
	}-*/;

}

