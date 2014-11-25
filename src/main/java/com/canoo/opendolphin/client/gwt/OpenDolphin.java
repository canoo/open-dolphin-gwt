package com.canoo.opendolphin.client.gwt;

public class OpenDolphin {

	public final static native ClientDolphin dolphin(String dolphinURL, boolean reset, int slackInMillis) /*-{
		return $wnd.opendolphin.dolphin(dolphinURL, reset, slackInMillis);
	}-*/;

}
