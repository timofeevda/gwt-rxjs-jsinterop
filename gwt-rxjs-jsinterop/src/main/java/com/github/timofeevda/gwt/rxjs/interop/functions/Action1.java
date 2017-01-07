package com.github.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface Action1<T> {
    void call(T t);
}
