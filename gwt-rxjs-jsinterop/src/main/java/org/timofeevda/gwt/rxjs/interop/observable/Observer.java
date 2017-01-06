package org.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsType;

/**
 * @author dtimofeev since 20.12.2016.
 * @param <T>
 */
@JsType(isNative = true)
public interface Observer<T> {
    void error(Object error);
    void next(T value);
    void complete();
}
