package com.github.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsType;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;

/**
 *
 * @author dtimofeev since 21.12.2016.
 */
@JsType(namespace = "Rx", isNative = true)
public class ConnectableObservable<T> extends Observable<T> {

    public native Subscription connect();

    public native Observable<T> refCount();
}
