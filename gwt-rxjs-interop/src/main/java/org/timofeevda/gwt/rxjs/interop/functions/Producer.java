package org.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

/**
 *
 * @author dtimofeev since 05.01.2017
 * @param <T>
 */
@JsFunction
public interface Producer<T> {
    T call();
}
