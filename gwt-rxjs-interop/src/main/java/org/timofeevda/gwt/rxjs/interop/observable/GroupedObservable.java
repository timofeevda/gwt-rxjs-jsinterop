/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * @author timof
 * @param <K>
 * @param <T>
 */
@JsType(namespace = "Rx", isNative = true)
public class GroupedObservable<K, T> extends Observable<T> {
    @JsProperty
    public K key;
}
