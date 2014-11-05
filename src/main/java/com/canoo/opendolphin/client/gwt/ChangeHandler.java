package com.canoo.opendolphin.client.gwt;

public interface ChangeHandler<T> {
	public void handleChange(T oldValue, T newValue);
}
