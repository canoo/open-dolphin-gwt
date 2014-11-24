package com.canoo.opendolphin.client.gwt;

import com.canoo.opendolphin.client.js.*;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

import java.util.ArrayList;
import java.util.List;

public class ClientDolphin extends JavaScriptObject {

	protected ClientDolphin() {}

	public final native void send(String commandName) /*-{
		this.send(commandName);
	}-*/;

	private final native void internal_send(String commandName, JSArrayHandler<ClientPresentationModel> handler) /*-{
		this.send(commandName, {onFinished: function (pms)  {
			handler.@com.canoo.opendolphin.client.js.JSArrayHandler::handleElements(Lcom/google/gwt/core/client/JsArray;)(pms)
		}
		});
	}-*/;
    public final void send(String commandName, final OnFinishedHandler handler) {
		internal_send(commandName, new JSArrayHandler<ClientPresentationModel>() {
			public void handleElements(JsArray<ClientPresentationModel> elements) {
				handler.handlePresentationModels(JsArrays.jsArrayToList(elements));
			}
		});
    }

	private final native void internal_sendEmpty(JSArrayHandler<ClientPresentationModel> handler) /*-{
		this.sendEmpty({onFinished: function (pms)  {
			handler.@com.canoo.opendolphin.client.js.JSArrayHandler::handleElements(Lcom/google/gwt/core/client/JsArray;)(pms)
		}
		});
	}-*/;
    public final void sendEmpty(final OnFinishedHandler handler) {
		internal_sendEmpty(new JSArrayHandler<ClientPresentationModel>() {
			public void handleElements(JsArray<ClientPresentationModel> elements) {
				handler.handlePresentationModels(JsArrays.jsArrayToList(elements));
			}
		});
    }

	/** new Attribute with tag 'VALUE' */
	public final native ClientAttribute attribute(String propertyName, String qualifier, String value) /*-{
		return this.attribute(propertyName, qualifier, value);
	}-*/;
	public final native ClientAttribute attribute(String propertyName, String qualifier, String value, String tag) /*-{
		return this.attribute(propertyName, qualifier, value, tag);
	}-*/;

	private native ClientPresentationModel internal_presentationModel(String pmId, String[] attributeNames) /*-{
		return this.presentationModel(pmId, attributeNames);
	}-*/;
    public final ClientPresentationModel presentationModel(String id, String... attributeNames) {
		return this.presentationModelWithType(id, null, attributeNames);
	}
    public final ClientPresentationModel presentationModelWithType(String id, String type, String... clientAttributePropertyNames) {

		List<ClientAttribute> clientAttributes = new ArrayList<ClientAttribute>();
		for (String propertyName : clientAttributePropertyNames) {
			clientAttributes.add(this.attribute(propertyName, null, null));
		}
		return this.presentationModelWithType(id, type, clientAttributes.toArray(new ClientAttribute[clientAttributes.size()]));
    }
	private native ClientPresentationModel presentationModel(String pmId, String type, JsArray<ClientAttribute> clientAttributes) /*-{
		return this.presentationModel(pmId, type, clientAttributes);
	}-*/;
	public final ClientPresentationModel presentationModelWithType(String id, String type, ClientAttribute... clientAttributes) {
		JsArray jsAttributes = ClientAttribute.createArray().cast();
		for (ClientAttribute clientAttribute : clientAttributes) {
			jsAttributes.push(clientAttribute);
		}

		return presentationModel(id, type, jsAttributes);
	}

	public final native ClientModelStore getClientModelStore() /*-{
		return this.getClientModelStore();
	}-*/;


	private native JsArrayString internal_listPresentationModelIds() /*-{
		return this.listPresentationModelIds();
	}-*/;
	public final List<String> listPresentationModelIds() {
		return jsArrayStringAsList(internal_listPresentationModelIds());
	}

	private native JsArray<ClientPresentationModel> internal_listPresentationModels() /*-{
		return this.listPresentationModels();
	}-*/;
	public final List<ClientPresentationModel> listPresentationModels() {
		return jsArrayPmsAsList(internal_listPresentationModels());
	}

	private native JsArray<ClientPresentationModel> internal_findAllPresentationModelsByType(String pmType) /*-{
		return this.findAllPresentationModelByType(pmType);
	}-*/;
	public final List<ClientPresentationModel> findAllPresentationModelsByType(String pmType) {
		JsArray<ClientPresentationModel> pms = internal_findAllPresentationModelsByType(pmType);
		return jsArrayPmsAsList(pms);
	}

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

	public final ClientAttribute findAttributeById(String id) {
		return getClientModelStore().findAttributeById(id);
	}

	public final native void addAttributeToModel(ClientPresentationModel pm, ClientAttribute attribute) /*-{
		this.addAttributeToModel(pm, attribute);
	}-*/;

	public final void addModelStoreListener(ModelStoreChangeHandler handler) {
		getClientModelStore().addModelStoreListener(handler);
	}

	public final native void startPushListening(String pushActionName, String releaseActionName) /*-{
		this.startPushListening(pushActionName, releaseActionName);
	}-*/;

	public final native void stopPushListening() /*-{
		this.stopPushListening();
	}-*/;

	private List<ClientPresentationModel> jsArrayPmsAsList(JsArray<ClientPresentationModel> pms) {
		List<ClientPresentationModel> result = new ArrayList<ClientPresentationModel>(pms.length());
		for (int i = 0; i < pms.length(); i++) {
			result.add(pms.get(i));
		}
		return result;
	}
	private List<String> jsArrayStringAsList(JsArrayString jsStrings) {
		List<String> result = new ArrayList<String>(jsStrings.length());
		for (int i = 0; i < jsStrings.length(); i++) {
			result.add(jsStrings.get(i));
		}
		return result;
	}
}
