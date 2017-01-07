package com.github.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsType;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;

/**
 * @author dtimofeev since 20.12.2016.
 * @param <T>
 */
@JsType
public interface Subscriber<T> extends Subscription {
    void error(Object object);
    void next(T value);
    void complete();
}
