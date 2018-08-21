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

import com.github.timofeevda.gwt.rxjs.interop.RxJS;
import com.github.timofeevda.gwt.rxjs.interop.event.KeyboardEvent;
import com.github.timofeevda.gwt.rxjs.interop.event.MouseEvent;
import com.google.gwt.dom.client.Element;

/**
 * {@link Observable} extensions for type friendly signatures
 *
 * @author timofeevda since 12/01/2017
 */
public class ObservableEx {

    public static Observable<MouseEvent> fromMouseEvent(Element element, String mouseEvent, boolean useCapture) {
        return RxJS.fromEvent(element, mouseEvent, useCapture);
    }

    public static Observable<MouseEvent> fromMouseEvent(Element element, String mouseEvent) {
        return RxJS.fromEvent(element, mouseEvent);
    }

    public static Observable<KeyboardEvent> fromKeyboardEvent(Element element, String keyboardEvent) {
        return RxJS.fromEvent(element, keyboardEvent);
    }
}
