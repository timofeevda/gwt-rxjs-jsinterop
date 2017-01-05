package org.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface Action2<T1, T2> {
    void call(T1 t1, T2 t2);
}
