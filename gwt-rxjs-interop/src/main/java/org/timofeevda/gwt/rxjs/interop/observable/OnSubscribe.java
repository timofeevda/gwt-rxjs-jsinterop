package org.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsFunction;
import org.timofeevda.gwt.rxjs.interop.functions.Action0;

/**
 * @author dtimofeev since 20.12.2016.
 */
@JsFunction
public interface OnSubscribe<T> {
    Action0 call(Subscriber<T> subscriber);
}
