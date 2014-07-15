package com.canoo.opendolphin.client.gwt;

import com.canoo.opendolphin.client.js.*;
import com.google.gwt.core.client.JavaScriptObject;

public class ClientModelStore extends JavaScriptObject {

	protected ClientModelStore() {}

	public final native ClientAttribute findAttributeById(String attributeId) /*-{
		var result = this.findAttributeById(attributeId);
		return (result === undefined) ? null : result;
	}-*/;


	public final void addModelStoreListener(final ModelStoreChangeHandler handler) {

		internal_addModelStoreListener(new ModelStoreChangeHandlerJS() {
			public void handleChange(String changeType, ClientPresentationModel pm) {
				handler.handleChange(ModelStoreChangeEventType.fromTypeValue(changeType), pm);
			}
		});
	}
	private native void internal_addModelStoreListener(ModelStoreChangeHandlerJS handler) /*-{
		this.onModelStoreChange(function (event)  {
			handler.@com.canoo.opendolphin.client.js.ModelStoreChangeHandlerJS::handleChange(Ljava/lang/String;Lcom/canoo/opendolphin/client/gwt/ClientPresentationModel;)(event.eventType, event.clientPresentationModel);
		} );
	}-*/;

}
