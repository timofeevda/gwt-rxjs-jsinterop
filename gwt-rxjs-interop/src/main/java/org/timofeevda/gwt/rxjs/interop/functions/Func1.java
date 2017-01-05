package org.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface Func1<T, R> {
    R call(T t);
}
