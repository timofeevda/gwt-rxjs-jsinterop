package org.timofeevda.gwt.rxjs.interop.subject;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author dtimofeev since 21.12.2016.
 * @param <T>
 */
@JsType(isNative = true, namespace = "Rx")
public class BehaviorSubject<T> extends Subject<T> {

    @JsConstructor
    public BehaviorSubject(T initialValue) {

    }

    public native T getValue();

}
