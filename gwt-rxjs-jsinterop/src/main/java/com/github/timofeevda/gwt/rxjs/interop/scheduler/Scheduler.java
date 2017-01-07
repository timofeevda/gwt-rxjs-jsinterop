package com.github.timofeevda.gwt.rxjs.interop.scheduler;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author dtimofeev since 21.12.2016.
 */
@JsType(namespace = "Rx", isNative = true)
public class Scheduler {
    @JsProperty
    public static Scheduler async;
    @JsProperty
    public static Scheduler asap;
    @JsProperty
    public static Scheduler queue;
    @JsProperty
    public static Scheduler animationFrame;
}
