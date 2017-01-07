/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Denis Timofeev <timofeevda@gmail.com>
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
package com.github.timofeevda.gwt.rxjs.interop.subscription;

import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;

/**
 * @author dtimofeev since 21.12.2016.
 */
public class BooleanSubscription implements Subscription {

    private Action0 unsubscribeAction;

    public BooleanSubscription(Action0 unsubscribeAction) {
        this.unsubscribeAction = unsubscribeAction;
    }


    @Override
    public boolean isClosed() {
        return unsubscribeAction == null;
    }

    @Override
    public void unsubscribe() {
        try {
            unsubscribeAction.call();
        } finally {
            unsubscribeAction = null;
        }
    }

    @Override
    public Subscription add(Subscription subscription) {
        return null;
    }

    @Override
    public void remove(Subscription subscription) {

    }
}
