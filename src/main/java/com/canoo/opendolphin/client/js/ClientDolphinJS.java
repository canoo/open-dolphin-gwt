package com.canoo.opendolphin.client.js;

import com.canoo.opendolphin.client.gwt.ClientAttribute;
import com.canoo.opendolphin.client.gwt.ClientModelStore;
import com.canoo.opendolphin.client.gwt.ClientPresentationModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ClientDolphinJS extends JavaScriptObject
{

	protected ClientDolphinJS() {
	}

	public final native ClientDolphinJS newInstance() /*-{
		return this();
	}-*/;

	public final native void send(String commandName) /*-{
		this.send(commandName);
	}-*/;
	public final native void send(String commandName, JSArrayHandler<ClientPresentationModel> handler) /*-{
		this.send(commandName, {onFinished: function (pms)  {
			handler.@com.canoo.opendolphin.client.js.JSArrayHandler::handleElements(Lcom/google/gwt/core/client/JsArray;)(pms)
			}
		});
	}-*/;
	public final native void sendEmpty(JSArrayHandler<ClientPresentationModel> handler) /*-{
		this.sendEmpty({onFinished: function (pms)  {
			handler.@com.canoo.opendolphin.client.js.JSArrayHandler::handleElements(Lcom/google/gwt/core/client/JsArray;)(pms)
		}
		});
	}-*/;

	public final native ClientAttribute attribute(String propertyName, String qualifier, String value) /*-{
		return this.attribute(propertyName, qualifier, value);
	}-*/;
	public final native ClientAttribute attribute(String propertyName, String qualifier, String value, String tag) /*-{
		var result = this.attribute(propertyName, qualifier, value, tag);
		return result;
	}-*/;

	public final native ClientPresentationModel presentationModel(String pmId, String[] attributeNames) /*-{
		return this.presentationModel(pmId, attributeNames);
	}-*/;
	public final native ClientPresentationModel presentationModel(String pmId, String type, JsArray<ClientAttribute> clientAttributes) /*-{
		return this.presentationModel(pmId, type, clientAttributes);
	}-*/;

	public final native ClientModelStore getClientModelStore() /*-{
		return this.getClientModelStore();
	}-*/;
	public final native void setClientModelStore(ClientModelStore clientModelStoreJS) /*-{
		return this.setClientModelStore(clientModelStoreJS);
	}-*/;
	public final native String[] listPresentationModelIds() /*-{
		return this.listPresentationModelIds();
	}-*/;
	public final native ClientPresentationModel[] listPresentationModels() /*-{
		return this.listPresentationModels();
	}-*/;
	public final native ClientPresentationModel[] findAllPresentationModelsByType(String pmType) /*-{
		return this.findAllPresentationModelByType(pmType);
	}-*/;
	public final native ClientPresentationModel getAt(String pmId) /*-{
		var pm = this.getAt(pmId);
		return (pm === undefined) ? null : pm;
	}-*/;
	public final native ClientPresentationModel findPresentationModelById(String pmId) /*-{
		var pm = this.findPresentationModelById(pmId);
		return (pm === undefined) ? null : pm;
	}-*/;
	public final native void deletePresentationModel(ClientPresentationModel pm) /*-{
		this.deletePresentationModel(pm);
	}-*/;
	public final native void deleteAllPresentationModelsOfType(String pmType) /*-{
		this.deleteAllPresentationModelOfType(pmType);
	}-*/;
	public final native void tag(ClientPresentationModel pm, String propertyName, Object value, String tag) /*-{
		this.tag(pm, propertyName, value, tag);
	}-*/;
	public final native ClientAttribute attribute(String propertyName, String qualifier, Object value, String tag) /*-{
		return this.attribute(propertyName, qualifier, value, tag);
	}-*/;
	public final native void addAttributeToModel(ClientPresentationModel pm, ClientAttribute attribute) /*-{
		this.addAttributeToModel(pm, attribute);
	}-*/;
	public final native void startPushListening(String pushActionName, String releaseActionName) /*-{
		this.startPushListening(pushActionName, releaseActionName);
	}-*/;
	public final native void stopPushListening() /*-{
		this.stopPushListening();
	}-*/;
}

