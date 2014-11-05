
package com.canoo.opendolphin.client.js;

import com.canoo.opendolphin.client.gwt.DolphinStarter;

public class DolphinLoaderJS {

	public static void load(String dolphinURL, DolphinStarter dolphinStarter) {
		load(dolphinURL, true, 0, dolphinStarter);
	}

	public final static native void load(String dolphinURL, boolean reset, int slackInMillis, DolphinStarter dolphinStarter) /*-{
		$wnd.require.config({
			baseUrl: 'com.canoo.opendolphin.OpenDolphin'
		});

		$wnd.require([
			'dolphin/OpenDolphin'
		], function (OpenDolphin_js) {
			@com.canoo.opendolphin.client.gwt.DolphinBaseStarter::start(Lcom/canoo/opendolphin/client/js/OpenDolphinJS;Ljava/lang/String;ZILcom/canoo/opendolphin/client/gwt/DolphinStarter;)(OpenDolphin_js, dolphinURL, reset, slackInMillis, dolphinStarter);
		});

	}-*/;


}
