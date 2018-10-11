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

import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func1;
import com.github.timofeevda.gwt.rxjs.interop.observable.Observable;
import com.github.timofeevda.gwt.rxjs.interop.observable.OnSubscribe;
import com.github.timofeevda.gwt.rxjs.interop.observable.Subscriber;
import com.github.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Arrays;

/**
 * @author dtimofeev since 21.12.2016.
 */
@SuppressWarnings("unused")
@JsType
class TestsContainer {
    private class BooleanHolder {
        boolean value;
    }

    private class StringHolder {
        String value = "";
    }

    private class IndexHolder {
        Integer index = -1;
    }

    @JsProperty
    public int x = 10;

    @JsMethod(name="subscribers")
    public boolean testSubscribers() {
        Subscriber[] subscribers = new Subscriber[10];
        for(int i=0; i < 10; i++) {
            final int index = i;
            Observable.create((OnSubscribe<String>) subscriber -> subscribers[index] = subscriber).subscribe(s -> {});
        }
        Arrays.stream(subscribers).forEach(Subscription::unsubscribe);
        return true;
    }

    @JsMethod(name = "create")
    public boolean testCreate() {
        BooleanHolder teardownTriggered = new BooleanHolder();
        StringHolder stringHolder = new StringHolder();
        String[] values = new String[]{"1","2","3","4"};
        // dummy "observable" implementation, just for API testing
        Observable<Object> observeStringArray = Observable.create((Subscriber<String> subscriber) -> {
            subscriber.add(() -> teardownTriggered.value = true);
            for(String value : values) {
                subscriber.next(value);
            }
            subscriber.complete();
            return subscriber;
        });
        Subscription subscription = observeStringArray.subscribe(v -> stringHolder.value += v);
        return stringHolder.value.equals("1234") && teardownTriggered.value && subscription.isClosed();
    }

    @JsMethod(name = "createWithAdditionalSubscription")
    public boolean testCreateWithAdditionalSubscription() {
        BooleanHolder teardownTriggered = new BooleanHolder();
        StringHolder stringHolder = new StringHolder();
        // dummy "observable" implementation, just for API testing
        Observable<String> observeStringArray = Observable.create((Subscriber<String> subscriber) -> {
            subscriber.next("1");
            subscriber.complete();
            return subscriber;
        });
        Subscription subscription = observeStringArray.subscribe(v -> stringHolder.value += v);
        subscription.add(() -> teardownTriggered.value = true);
        return teardownTriggered.value;
    }

    @JsMethod(name = "of")
    public boolean testOf() {
        final BooleanHolder bh = new BooleanHolder();
        Observable.of(true).subscribe(aBoolean -> bh.value = aBoolean);
        return bh.value;
    }

    @JsMethod(name = "from")
    public String testFrom() {
        final StringHolder bh = new StringHolder();
        Observable.from(new String[]{"3", "4", "7"}).subscribe(aBoolean -> bh.value = aBoolean);
        return bh.value;
    }

    @JsMethod(name = "map")
    public boolean testMap() {
        final BooleanHolder bh = new BooleanHolder();
        Observable.of(true).map(v -> false).subscribe(aBoolean -> bh.value = aBoolean);
        return bh.value;
    }

    @JsMethod(name = "filter")
    public boolean testFilter() {
        final BooleanHolder bh = new BooleanHolder();
        Observable.of(false, true).filter((v,i) -> false).subscribe(aBoolean -> bh.value = aBoolean);
        return bh.value;
    }

    @JsMethod(name = "filterPredicate")
    public boolean testFilterPredicate() {
        final BooleanHolder bh = new BooleanHolder();
        Observable.of(false, true).filter(v -> false).subscribe(aBoolean -> bh.value = aBoolean);
        return bh.value;
    }

    @JsMethod(name = "mergeTwo")
    public String testMergeTwo() {
        final StringHolder sh = new StringHolder();
        Observable.merge(Observable.of("1"), Observable.of("2")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "mergeThree")
    public String testMergeThree() {
        final StringHolder sh = new StringHolder();
        Observable.merge(Observable.of("1"), Observable.of("2"), Observable.of("3")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "defer")
    public String testDefer() {
        final StringHolder sh = new StringHolder();
        Observable.defer(() -> Observable.of("1")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "race")
    public String testRace() {
        final StringHolder sh = new StringHolder();
        Observable.race(Observable.of("1"), Observable.of("2")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "do")
    public String testDo() {
        final StringHolder sh = new StringHolder();
        Observable.of("1")._do(v -> sh.value += v).subscribe(v -> {});
        return sh.value;
    }

    @JsMethod(name = "empty")
    public String testEmpty() {
        final StringHolder sh = new StringHolder();
        Observable.of(1, 2, 3, 4).mergeMap((Integer item, Integer index) -> item % 2 == 0 ? Observable.of("1") : Observable.<String>empty()).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "ifThen")
    public boolean testIfThen() {
        BooleanHolder bh = new BooleanHolder();
        Observable._if(() -> true, Observable.of(true)).subscribe(v -> bh.value = v);
        return bh.value;
    }

    @JsMethod(name = "ifElse")
    public boolean testIfElse() {
        BooleanHolder bh = new BooleanHolder();
        Observable._if(() -> false, Observable.of(true), Observable.of(false)).subscribe(v -> bh.value = v);
        return bh.value;
    }

    @JsMethod(name = "elementAt")
    public String testElementAt() {
        final StringHolder sh = new StringHolder();
        Observable.of("1", "2", "3").elementAt(2).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "elementAtDefault")
    public String testElementAtDefault() {
        final StringHolder sh = new StringHolder();
        Observable.of("1", "2","3").elementAt(5, "-1").subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "every")
    public boolean testEvery() {
        final BooleanHolder sh = new BooleanHolder();
        Observable.of("1", "2","3").every((value, index, source) -> value.length() < 2).subscribe(v -> sh.value = v);
        return sh.value;
    }

    @JsMethod(name = "exhaust")
    public String testExhaust() {
        final StringHolder sh = new StringHolder();
        Observable.of("1", "2","3").map((Func1<String, Observable<String>>) Observable::of).exhaust().subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "exhaustMap")
    public String testExhaustMap() {
        final StringHolder sh = new StringHolder();
        Observable.of("1", "2","3").exhaustMap((item, index) -> Observable.of(item + "0")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "take")
    public String testTake() {
        final StringHolder sh = new StringHolder();
        Observable.of("1", "2","1").take(2).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "expand")
    public String testExpand() {
        final StringHolder sh = new StringHolder();
        Observable.of("1").expand((item, index) -> Observable.of(item + "0")).take(3).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "finally")
    public String testFinally() {
        final StringHolder sh = new StringHolder();
        Observable.of("1")._finally(() -> sh.value = "finally").subscribe(v -> {});
        return sh.value;
    }

    @JsMethod(name = "find")
    public String testFind() {
        final StringHolder sh = new StringHolder();
        Observable.of("3", "1", "2","1").find((value, index) -> value.equals("1")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "findIndex")
    public String testFindIndex() {
        final StringHolder sh = new StringHolder();
        Observable.of("3", "1", "2","1").findIndex((value, index, source) -> value.equals("1")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "first")
    public String testFirst() {
        final StringHolder sh = new StringHolder();
        Observable.of("3", "1", "2","1", "2").first((v,i) -> v.equals("2")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "groupBy")
    public String testGroupBy() {
        final StringHolder sh = new StringHolder();
        Observable.of("3", "1", "2","1", "2").groupBy((String item) -> item).subscribe(v -> sh.value += v.key);
        return sh.value;
    }

    @JsMethod(name = "ignoreElements")
    public String testIgnoreElements() {
        final StringHolder sh = new StringHolder();
        Observable.of("3", "1", "2","1", "2").ignoreElements().subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "last")
    public String testLast() {
        final StringHolder sh = new StringHolder();
        Observable.of("3", "1", "2","1", "2").first((v,i) -> v.equals("1")).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "mapTo")
    public String testMapTo() {
        final StringHolder sh = new StringHolder();
        Observable.of("3", "1", "2","1", "2").mapTo("5").subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "max")
    public String testMax() {
        final StringHolder sh = new StringHolder();
        Observable.of(3, 5, 8, 1, 2).max().subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "maxComparer")
    public String testMaxComparer() {
        final StringHolder sh = new StringHolder();
        Observable.of(3, 5, 8, 12, -1).max(Integer::compareTo).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "mergeAll")
    public String testMergeAll() {
        final StringHolder sh = new StringHolder();
        Observable.of(Observable.of("1"), Observable.of("3")).mergeAll().subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "pairwise")
    public String testPairwise() {
        final StringHolder sh = new StringHolder();
        Observable.of("1", "3").pairwise().subscribe(v -> sh.value += v[0] + v[1]);
        return sh.value;
    }

    @JsMethod(name = "partition")
    public String testPartition() {
        final StringHolder sh = new StringHolder();
        Observable<String>[] obs = Observable.of("1", "3").partition((v, i) -> v.equals("3"));
        obs[1].subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "range")
    public String testRange() {
        final StringHolder sh = new StringHolder();
        Observable.range(1,3).subscribe(v -> sh.value += v);
        return sh.value;
    }

    @JsMethod(name = "throw")
    public String testThrow() {
        final StringHolder sh = new StringHolder();
        Observable._throw(1).subscribe(v -> {}, v -> sh.value += v, () -> {});
        return sh.value;
    }

    @JsMethod(name = "asyncScheduler")
    public void testAsyncScheduler(Action0 jasmineDone) {
        Observable.of("1").observeOn(Scheduler.async).subscribe(v -> jasmineDone.call());
    }

    @JsMethod(name = "interval")
    public void testInterval(Action0 jasmineDone) {
        Subscription subscription = Observable.interval(200).subscribe(v -> jasmineDone.call());
        Observable.timer(400).subscribe(v -> subscription.unsubscribe());
    }
    
    @JsMethod(name = "testBufferCount")
    public boolean testBufferCount() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).bufferCount(2).subscribe(v -> sb.append(v.length));
        return sb.toString().equals("21");
    }

    @JsMethod(name = "testFilter_indexed")
    public boolean testFilterIndexed() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).filter((v, i) -> v < 3).subscribe(sb::append);
        return sb.toString().equals("12");
    }

    @JsMethod(name = "testWithLatestFrom")
    public boolean testWithLatestFrom() {
        StringBuilder sb = new StringBuilder();
        Observable.of(1, 2, 3).withLatestFrom(Observable.of(0, 2), (i1, i2) -> i1 * i2).subscribe(sb::append);
        return sb.toString().equals("246");
    }
    
}
