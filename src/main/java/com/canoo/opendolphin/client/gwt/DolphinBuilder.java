package com.canoo.opendolphin.client.gwt;

public class DolphinBuilder {

	String url;
	boolean reset;
	int slackMS;
	int maxBatchSize;
	boolean supportCORS;
	DolphinErrorHandler dolphinErrorHandler;

	public DolphinBuilder() {
		reset = false;
		slackMS = 300;
		maxBatchSize = 50;
		supportCORS = false;
	}

	public DolphinBuilder url(String url) {
		this.url = url;
		return this;
	}
	public DolphinBuilder reset(boolean reset) {
		this.reset = reset;
		return this;
	}
	public DolphinBuilder slackMS(int slackMS) {
		this.slackMS = slackMS;
		return this;
	}
	public DolphinBuilder maxBatchSize(int maxBatchSize) {
		this.maxBatchSize = maxBatchSize;
		return this;
	}
	public DolphinBuilder supportCORS(boolean supportCORS) {
		this.supportCORS = supportCORS;
		return this;
	}
	public DolphinBuilder errorHandler(DolphinErrorHandler dolphinErrorHandler) {
		this.dolphinErrorHandler = dolphinErrorHandler;
		return this;
	}

	public final ClientDolphin build() {
		return build_(url, reset, slackMS, maxBatchSize, supportCORS, dolphinErrorHandler);
	}
	public final native ClientDolphin build_(String url, boolean reset, int slackMS, int maxBatchSize, boolean supportCORS, DolphinErrorHandler errorHandler) /*-{
		var eh = function(evt) {
			if (errorHandler) {
				var de = @com.canoo.opendolphin.client.gwt.DolphinErrorEvent::new(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)(evt.kind, evt.url, evt.httpStatus, evt.message);
				errorHandler.@com.canoo.opendolphin.client.gwt.DolphinErrorHandler::handleError(*)(de);
			}
			else {
				console.log("** Error occured. No ErrorHandler is configured: ", evt);
			}

		};
		return $wnd.opendolphin.makeDolphin().url(url).reset(reset).slackMS(slackMS).errorHandler(eh).supportCORS(supportCORS).build();
	}-*/;

}
