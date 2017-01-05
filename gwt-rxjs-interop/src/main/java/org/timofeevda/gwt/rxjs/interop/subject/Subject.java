package org.timofeevda.gwt.rxjs.interop.subject;

import org.timofeevda.gwt.rxjs.interop.observable.Observer;
import org.timofeevda.gwt.rxjs.interop.observable.Observable;
import jsinterop.annotations.JsType;

/**
 * @author dtimofeev since 21.12.2016.
 */
@JsType(isNative = true, namespace = "Rx")
public class Subject<T> extends Observable<T> implements Observer<T> {
    @Override
    public native void error(Object error);

    @Override
    public native void next(T value);

    @Override
    public native void complete();

    public native Observable<T> asObservable();
}
