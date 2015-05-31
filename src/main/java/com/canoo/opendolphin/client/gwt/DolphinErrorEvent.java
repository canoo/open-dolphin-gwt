package com.canoo.opendolphin.client.gwt;

public class DolphinErrorEvent {

	public static final String KIND_ONERROR = "onerror";
	public static final String KIND_APPLICATION = "application";

	public final String kind;
	public final String url;
	public final int httpStatus;
	public final String message;

	public DolphinErrorEvent(String kind, String url, int httpStatus, String message) {
		this.kind = kind;
		this.url = url;
		this.httpStatus = httpStatus;
		this.message = message;
	}

}
