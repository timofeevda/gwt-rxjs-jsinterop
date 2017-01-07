package com.github.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

/**
 * @author dtimofeev since 21.12.2016.
 * @param <R>
 */
@JsFunction
public interface FuncN<R> {
    R call(Object...args);
}