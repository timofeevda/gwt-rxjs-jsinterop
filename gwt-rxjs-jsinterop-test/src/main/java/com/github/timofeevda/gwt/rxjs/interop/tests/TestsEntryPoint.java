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
package com.github.timofeevda.gwt.rxjs.interop.tests;

import com.google.gwt.core.client.EntryPoint;


/**
 * @author dtimofeev since 21.12.2016.
 */
public class TestsEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        exportTestsContainer(new TestsContainer());
        exportGeneratedTests(new MethodsDefinitionsTest());
    }

    private native void exportTestsContainer(TestsContainer testsContainer) /*-{
      $wnd.testsContainer = testsContainer;
    }-*/;

    private native void exportGeneratedTests(MethodsDefinitionsTest test) /*-{
        $wnd.generatedTests = test;
    }-*/;
}
