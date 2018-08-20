/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Denis Timofeev <timofeevda@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 */
package com.github.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

public class EventListenerOptions {

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class ListenerOptions {
        public boolean capture;
        public boolean passive;
        public boolean once;
    }

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class CapturingListenerOptions {
        public boolean capture;
    }

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class PassiveListenerOptions {
        public boolean passive;
    }

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class OnceListenerOptions {
        public boolean once;
    }
}
