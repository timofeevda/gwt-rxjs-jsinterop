package org.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsType;
import org.timofeevda.gwt.rxjs.interop.subscription.Subscription;

/**
 *
 * @author timof
 */
@JsType(namespace = "Rx", isNative = true)
public class ConnectableObservable<T> extends Observable<T> {

    public native Subscription connect();

    public native Observable<T> refCount();
}
