package com.github.timofeevda.gwt.rxjs.interop.subscription;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public interface Unsubscribable {
    void unsubscribe();
}
