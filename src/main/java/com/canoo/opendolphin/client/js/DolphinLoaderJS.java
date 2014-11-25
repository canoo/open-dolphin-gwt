
package com.canoo.opendolphin.client.js;

import com.canoo.opendolphin.client.gwt.ClientDolphin;

public class DolphinLoaderJS {

	public final static native ClientDolphin newClientDolphin(String dolphinURL, boolean reset, int slackInMillis) /*-{
		return $wnd.opendolphin.dolphin(dolphinURL, reset, slackInMillis);
	}-*/;

}
