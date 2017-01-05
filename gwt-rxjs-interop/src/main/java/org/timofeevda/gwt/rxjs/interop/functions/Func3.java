package org.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface Func3<T1, T2, T3, R> {
    R call(T1 t1, T2 t2, T3 t3);
}
