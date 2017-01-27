package com.github.timofeevda.gwt.rxjs.interop.tests;

import com.github.timofeevda.gwt.rxjs.interop.observable.Observable;
import com.github.timofeevda.gwt.rxjs.interop.observable.Subscriber;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * @author dtimofeev since 23.01.2017.
 */
@JsType
@SuppressWarnings("unused")
public class SyncTests {

    @JsMethod(name = "create")
    public boolean testCreate() {
        boolean[] tearDown = new boolean[]{false};
        String[] values = new String[]{"1", "2", "3", "4"};
        StringBuilder sb = new StringBuilder();
        Observable<Object> observeStringArray = Observable.create((Subscriber<String> subscriber) -> {
            subscriber.add(() -> tearDown[0] = true);
            for (String value : values) {
                subscriber.next(value);
            }
            subscriber.complete();
            return subscriber;
        });
        Subscription subscription = observeStringArray.subscribe(sb::append);
        return sb.toString().equals("1234") && tearDown[0] && subscription.isClosed();
    }

    @JsMethod(name = "testBufferCount")
    public boolean testBufferCount() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).bufferCount(2).subscribe(v -> sb.append(v.length));
        return sb.toString().equals("21");
    }

    @JsMethod
    public boolean testOf() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).subscribe(sb::append);
        return sb.toString().equals("123");
    }

    @JsMethod
    public boolean testFrom() {
        StringBuilder sb = new StringBuilder();
        Observable.from(new String[]{"1", "2", "3"}).subscribe(sb::append);
        return sb.toString().equals("123");
    }

    @JsMethod(name = "testMap")
    public boolean testMap() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).map(v -> v * 10).subscribe(sb::append);
        return sb.toString().equals("102030");
    }

    @JsMethod(name = "testFilter")
    public boolean testFilter() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).filter(v -> v < 3).subscribe(sb::append);
        return sb.toString().equals("12");
    }

    @JsMethod(name = "testFilter_indexed")
    public boolean testFilterIndexed() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).filter((v, i) -> v < 3).subscribe(sb::append);
        return sb.toString().equals("12");
    }
}
