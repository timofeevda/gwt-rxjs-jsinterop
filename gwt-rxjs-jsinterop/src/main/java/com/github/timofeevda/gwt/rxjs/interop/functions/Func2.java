package com.github.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface Func2<T1, T2, R> {
    R call(T1 t1, T2 t2);
}
