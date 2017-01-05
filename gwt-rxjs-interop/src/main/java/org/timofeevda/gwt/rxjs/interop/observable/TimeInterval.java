/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * @author dtimofeev since 21.12.2016.
 * @param <T>
 */
@JsType(namespace="Rx")
public class TimeInterval<T> {
    @JsProperty
    public T value;
    @JsProperty
    public int interval;
}
