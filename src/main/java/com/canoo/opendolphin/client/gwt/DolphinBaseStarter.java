package com.canoo.opendolphin.client.gwt;

import com.canoo.opendolphin.client.js.OpenDolphinJS;

public class DolphinBaseStarter {
	public static void start(OpenDolphinJS openDolphinJS, String dolphinURL, boolean reset, int slackInMillis, DolphinStarter dolphinStarter) {
		ClientDolphin clientDolphin = openDolphinJS.newClientDolphinInstance(dolphinURL, reset, slackInMillis);
		dolphinStarter.start(clientDolphin);

	}
}
