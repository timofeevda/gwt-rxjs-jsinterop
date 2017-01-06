package org.timofeevda.gwt.rxjs.interop.subscription;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author dtimofeev since 20.12.2016.
 */
@JsType
public interface Subscription {
    @JsProperty
    boolean isClosed();
    void unsubscribe();
    Subscription add(Subscription subscription);
    void remove(Subscription subscription);
}
