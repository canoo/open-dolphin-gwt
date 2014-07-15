package com.canoo.opendolphin.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.List;

public class ClientPresentationModel extends JavaScriptObject {

	protected ClientPresentationModel() {}

	public final native String getId()/*-{
		return this.id;
	}-*/;

	public final native String getPresentationModelType()/*-{
		return this.presentationModelType;
	}-*/;

	private final native JsArray<ClientAttribute> internal_getAttributes()/*-{
		return this.attributes;
	}-*/;
	public final List<ClientAttribute> getAttributes() {
		return JsArrays.jsArrayToList(internal_getAttributes());
	}

	public final native ClientAttribute getAt(String propertyName)/*-{
		var js = this.getAt(propertyName, undefined);
		return js === undefined ? null : js;
	}-*/;

	public final native ClientAttribute getAt(String propertyName, String tag)/*-{
		return this.getAt(propertyName, tag);
	}-*/;

	public final ClientAttribute findAttributeByPropertyName(String propertyName) {
		return getAt(propertyName);
	}
	public final ClientAttribute findAttributeByPropertyNameAndTag(String propertyName, String tag) {
		return getAt(propertyName, tag);
	}
	public final native ClientAttribute findAttributeById(String id)/*-{
		return this.findAttributeById(id);
	}-*/;
	public final native ClientAttribute findAttributeByQualifier(String qualifier)/*-{
		return this.findAttributeByQualifier(qualifier);
	}-*/;
	private native JsArray<ClientAttribute> internal_findAllAttributesByPropertyName(String propertyName)/*-{
		return this.findAllAttributesByPropertyName(propertyName);
	}-*/;
	public final List<ClientAttribute> findAllAttributesByPropertyName(String propertyName) {
		return JsArrays.jsArrayToList(internal_findAllAttributesByPropertyName(propertyName));
	}
	public final native boolean isDirty()/*-{
		return this.isDirty();
	}-*/;
	public final native boolean rebase()/*-{
		return this.rebase();
	}-*/;

	public final native void syncWith(ClientPresentationModel pm) /*-{
		this.syncWith(pm);
	}-*/;

	public final native void addDirtyChangeHandler(BooleanChangeHandler handler) /*-{
		this.onDirty(function (data) {
			handler.@com.canoo.opendolphin.client.gwt.BooleanChangeHandler::handleChange(ZZ)(data.oldValue, data.newValue);
		});
	}-*/;
	public final native void addInvalidationHandler(PresentationModelInvalidationHandler handler) /*-{
		this.onInvalidated(function (data) {
			handler.@com.canoo.opendolphin.client.gwt.PresentationModelInvalidationHandler::handleChange(Lcom/canoo/opendolphin/client/gwt/ClientPresentationModel;)(data.source);
		});
	}-*/;

}
