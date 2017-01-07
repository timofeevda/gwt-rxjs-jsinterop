package com.github.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * * @author dtimofeev since 21.12.2016.
 * @param <K>
 * @param <T>
 */
@JsType(namespace = "Rx", isNative = true)
public class GroupedObservable<K, T> extends Observable<T> {
    @JsProperty
    public K key;
}
