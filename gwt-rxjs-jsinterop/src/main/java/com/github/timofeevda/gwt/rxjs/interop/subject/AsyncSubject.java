package com.github.timofeevda.gwt.rxjs.interop.subject;

import jsinterop.annotations.JsType;

/**
 * @author dtimofeev since 21.12.2016.
 * @param <T>
 */
@JsType(isNative = true, namespace = "Rx")
public class AsyncSubject<T> extends Subject<T> {
}
