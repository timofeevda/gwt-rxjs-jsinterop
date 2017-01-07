package com.github.timofeevda.gwt.rxjs.interop.tests;

import com.google.gwt.core.client.EntryPoint;


/**
 * @author dtimofeev since 21.12.2016.
 */
public class TestsEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        exportTestsContainer(new TestsContainer());
    }

    private native void exportTestsContainer(TestsContainer testsContainer) /*-{
      $wnd.testsContainer = testsContainer;
    }-*/;
}
