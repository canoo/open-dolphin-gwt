package com.canoo.opendolphin.client.js;

import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.google.gwt.core.client.JavaScriptObject;

public class ClientModelStoreJS extends JavaScriptObject
{

	protected ClientModelStoreJS() {
	}

	public final native ClientAttribute findAttributeById(String attributeId) /*-{
		var result = this.findAttributeById(attributeId);
		return (result === undefined) ? null : result;
	}-*/;

	public final native void addModelStoreListener(ModelStoreChangeHandlerJS handler) /*-{
		this.onModelStoreChange(function (event)  {
			handler.@com.canoo.opendolphin.client.js.ModelStoreChangeHandlerJS::handleChange(Ljava/lang/String;Lcom/canoo/opendolphin/client/gwt/ClientPresentationModel;)(event.eventType, event.clientPresentationModel);
		} );
	}-*/;
}

