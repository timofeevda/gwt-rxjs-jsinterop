package com.github.timofeevda.gwt.rxjs.interop.functions;


import com.github.timofeevda.gwt.rxjs.interop.observable.Observable;
import jsinterop.annotations.JsFunction;

@JsFunction
@FunctionalInterface
public interface UnaryArrayFunction<T, R> {
    Observable<R>[] call(Observable<T> t);
}