package com.canoo.opendolphin.client.gwt;

import com.canoo.opendolphin.client.js.*;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientDolphin {

    private final ClientDolphinJS clientDolphinJS;

    public ClientDolphin(ClientDolphinJS clientDolphinJS) {
		this.clientDolphinJS = clientDolphinJS;
    }

    public void send(String commandName) {
		clientDolphinJS.send(commandName);
	}

    public void send(String commandName, final OnFinishedHandler handler) {
		clientDolphinJS.send(commandName, new JSArrayHandler<ClientPresentationModel>() {
			public void handleElements(JsArray<ClientPresentationModel> elements) {
				handler.handlePresentationModels(JsArrays.jsArrayToList(elements));
			}
		});
    }

    public void sendEmpty(final OnFinishedHandler handler) {
		clientDolphinJS.sendEmpty(new JSArrayHandler<ClientPresentationModel>() {
			public void handleElements(JsArray<ClientPresentationModel> elements) {
				handler.handlePresentationModels(JsArrays.jsArrayToList(elements));
			}
		});
    }

	/** new Attribute with tag 'VALUE' */
    public ClientAttribute attribute(String propertyName, String qualifier, String value) {
		ClientAttribute clientAttribute = clientDolphinJS.attribute(propertyName, qualifier, value);
		return clientAttribute;
	}

    public ClientAttribute attribute(String propertyName, String qualifier, String value, String tag) {
		ClientAttribute clientAttribute = clientDolphinJS.attribute(propertyName, qualifier, value, tag);
		return clientAttribute;
	}

    public ClientPresentationModel presentationModel(String id, String... attributeNames) {
		return this.presentationModelWithType(id, null, attributeNames);
	}
    public ClientPresentationModel presentationModelWithType(String id, String type, String... clientAttributePropertyNames) {

		List<ClientAttribute> clientAttributes = new ArrayList<ClientAttribute>();
		for (String propertyName : clientAttributePropertyNames) {
			ClientAttribute clientAttribute = this.attribute(propertyName, null, null);
			clientAttributes.add(clientAttribute);
		}
		return this.presentationModelWithType(id, type, clientAttributes.toArray(new ClientAttribute[clientAttributes.size()]));
    }
	public ClientPresentationModel presentationModelWithType(String id, String type, ClientAttribute... clientAttributes) {
		JsArray jsAttributes = ClientAttribute.createArray().cast();
		for (ClientAttribute clientAttribute : clientAttributes) {
			jsAttributes.push(clientAttribute);
		}

		return clientDolphinJS.presentationModel(id, type, jsAttributes);
	}

    public ClientModelStore getClientModelStore() {
        return new ClientModelStore(clientDolphinJS.getClientModelStore());
    }


	public List<String> listPresentationModelIds() {
		String[] pmIds = clientDolphinJS.listPresentationModelIds();
		return Arrays.asList(pmIds);
	}

	public List<ClientPresentationModel> listPresentationModels() {
		return Arrays.asList(clientDolphinJS.listPresentationModels());
	}
	public List<ClientPresentationModel> findAllPresentationModelsByType(String pmType) {
		return Arrays.asList(clientDolphinJS.findAllPresentationModelsByType(pmType));
	}

	public ClientPresentationModel getAt(String pmId) {
		return clientDolphinJS.getAt(pmId);
	}
	public ClientPresentationModel findPresentationModelById(String pmId) {
		return clientDolphinJS.findPresentationModelById(pmId);
	}

	public void deletePresentationModel(ClientPresentationModel pm) {
		clientDolphinJS.deletePresentationModel(pm);
	}
	public void deleteAllPresentationModelsOfType(String pmType) {
		clientDolphinJS.deleteAllPresentationModelsOfType(pmType);
	}
	public void tag(ClientPresentationModel pm, String propertyName, Object value, String tag) {
		clientDolphinJS.tag(pm, propertyName, value, tag);
	}
	public ClientAttribute attribute(String propertyName, String qualifier, Object value, String tag) {
		ClientAttribute attribute = clientDolphinJS.attribute(propertyName, qualifier, value, tag);
		return attribute;
	}

	public ClientAttribute findAttributeById(String id) {
		return getClientModelStore().findAttributeById(id);
	}

	public void addAttributeToModel(ClientPresentationModel pm, ClientAttribute attribute) {
		clientDolphinJS.addAttributeToModel(pm, attribute);
	}

	public void addModelStoreListener(ModelStoreChangeHandler handler) {
		getClientModelStore().addModelStoreListener(handler);
	}

	public void startPushListening(String pushActionName, String releaseActionName) {
		clientDolphinJS.startPushListening(pushActionName, releaseActionName);
	}
	public void stopPushListening() {
		clientDolphinJS.stopPushListening();
	}

}
