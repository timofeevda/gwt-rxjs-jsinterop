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
package com.github.timofeevda.gwt.rxjs.interop.onpage;

import com.github.timofeevda.gwt.rxjs.interop.RxJS;
import com.github.timofeevda.gwt.rxjs.interop.functions.ToObservableProjector;
import com.github.timofeevda.gwt.rxjs.interop.observable.Observable;
import com.github.timofeevda.gwt.rxjs.interop.observable.ObservableEx;
import com.github.timofeevda.gwt.rxjs.interop.operators.RxJSOperators;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import static com.github.timofeevda.gwt.rxjs.interop.operators.RxJSOperators.map;
import static com.github.timofeevda.gwt.rxjs.interop.operators.RxJSOperators.take;

/**
 * @author dtimofeev since 12/01/2017.
 */
public class OnPageTest implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get("main");
        final Button button = new Button("Click me");
        rootPanel.add(button);

        ObservableEx.fromKeyboardEvent(button.getElement(), "keydown")
                .pipe(
                        map(event -> event.ctrlKey),
                        take(5))
                .subscribe(v -> log("ctrlKey " + v));

        ObservableEx.fromMouseEvent(button.getElement(), "click")
                .pipe(
                        map(event -> event.clientX),
                        take(5))
                .subscribe(v -> log("clientX " + v));

        RxJS.from(new Integer[]{1, 2, 3, 4, 5})
                .pipe(RxJSOperators.flatMap(new ToObservableProjector<Integer, Object>() {
                            @Override
                            public Observable<Object> call(Integer t) {
                                log("" + t);
                                return RxJS.throwError(null);
                            }
                        }),
                        RxJSOperators.retryWhen(o -> o.pipe(RxJSOperators.delay(1000))))
                .subscribe((i) -> {
                });
    }

    private static native void log(String value) /*-{
        console.log(value);
    }-*/;
}
