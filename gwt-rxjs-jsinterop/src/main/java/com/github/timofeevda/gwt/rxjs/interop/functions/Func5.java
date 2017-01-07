package com.github.timofeevda.gwt.rxjs.interop.functions;

import jsinterop.annotations.JsFunction;

/**
 * 
 * @author dtimofeev since 06.01.2017.
 * 
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <T5>
 * @param <R> 
 */
@JsFunction
public interface Func5<T1, T2, T3, T4, T5, R> {
    R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
}
