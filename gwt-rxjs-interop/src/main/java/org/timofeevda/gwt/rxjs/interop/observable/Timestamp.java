package org.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * @author timof
 */
@JsType(namespace="Rx")
public class Timestamp<T> {
    @JsProperty
    public T value;
    @JsProperty
    public int timestamp;
}
