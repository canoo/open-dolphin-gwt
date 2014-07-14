package com.canoo.opendolphin.client.gwt;

import com.canoo.opendolphin.client.js.ClientAttributeJS;
import com.canoo.opendolphin.client.js.ClientPresentationModelJS;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.List;

public class ClientPresentationModel {
	final ClientPresentationModelJS pmJS;

	private final List<ClientAttribute> attributes = new ArrayList<ClientAttribute>();

	public ClientPresentationModel(final ClientPresentationModelJS pmJS) {
		this.pmJS = pmJS;
		JsArray<ClientAttribute> clientAttributes = pmJS.getClientAttributes();
		for (int i = 0; i < clientAttributes.length(); i++) {
			attributes.add(clientAttributes.get(i));
		}
	}

	public String getId() {
		return pmJS.getId();
	}

	public String getPresentationModelType() {
		return pmJS.getPresentationModelType();
	}

	public List<ClientAttribute> getAttributes() {
		return attributes;
	}

	public ClientAttribute getAt(String propertyName) {
		ClientAttribute attribute = pmJS.getAt(propertyName);
		return attribute;
	}

	public ClientAttribute getAt(String propertyName, String tag) {
		ClientAttribute attribute = pmJS.getAt(propertyName, tag);
		return attribute;
	}
	public ClientAttribute findAttributeByPropertyName(String propertyName) {
		return getAt(propertyName);
	}
	public ClientAttribute findAttributeByPropertyNameAndTag(String propertyName, String tag) {
		return getAt(propertyName, tag);
	}
	public ClientAttribute findAttributeById(String id) {
		ClientAttribute attribute = pmJS.findAttributeById(id);
		return attribute;
	}
	public ClientAttribute findAttributeByQualifier(String qualifier) {
		ClientAttribute attribute = pmJS.findAttributeByQualifier(qualifier);
		return attribute;
	}
	public List<ClientAttribute> findAllAttributesByPropertyName(String propertyName) {
		JsArray<ClientAttribute> jsAttributes = pmJS.findAllAttributesByPropertyName(propertyName);
		return clientAttributesFromJSAttributes(jsAttributes);
	}
	public boolean isDirty() {
		return pmJS.isDirty();
	}
	public void rebase() {
		pmJS.rebase();
	}

	public void syncWith(ClientPresentationModel pm) {
		pmJS.syncWith(pm.pmJS);
	}

	public void addDirtyChangeHandler(BooleanChangeHandler booleanChangeHandler) {
		pmJS.addDirtyChangeHandler(booleanChangeHandler);
	}
	public void addInvalidationHandler(PresentationModelInvalidationHandler handler) {
		pmJS.addInvalidationHandler(new PresentationModelInvalidationHandlerAdapter(handler));
	}

	// === private ===

	private List<ClientAttribute> clientAttributesFromJSAttributes(JsArray<ClientAttribute> jsAttributes) {
		final List<ClientAttribute> result = new ArrayList<ClientAttribute>();
		for (int i = 0; i < jsAttributes.length(); i++) {
			result.add(jsAttributes.get(i));
		}
		return result;
	}

}
