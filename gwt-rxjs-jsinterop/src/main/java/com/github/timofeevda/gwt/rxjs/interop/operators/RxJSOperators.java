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
package com.github.timofeevda.gwt.rxjs.interop.operators;

import com.github.timofeevda.gwt.rxjs.interop.functions.Accumulator;
import com.github.timofeevda.gwt.rxjs.interop.functions.AccumulatorWithIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;
import com.github.timofeevda.gwt.rxjs.interop.functions.Action1;
import com.github.timofeevda.gwt.rxjs.interop.functions.Comparator;
import com.github.timofeevda.gwt.rxjs.interop.functions.ElementSelector;
import com.github.timofeevda.gwt.rxjs.interop.functions.ErrorCatcher;
import com.github.timofeevda.gwt.rxjs.interop.functions.Factory;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func0;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func1;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func2;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func3;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func4;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func5;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func6;
import com.github.timofeevda.gwt.rxjs.interop.functions.KeySelector;
import com.github.timofeevda.gwt.rxjs.interop.functions.OperatorFunction;
import com.github.timofeevda.gwt.rxjs.interop.functions.Predicate;
import com.github.timofeevda.gwt.rxjs.interop.functions.Predicate2;
import com.github.timofeevda.gwt.rxjs.interop.functions.PredicateWithIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.PredicateWithSourceIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.Projector;
import com.github.timofeevda.gwt.rxjs.interop.functions.ResultSelector;
import com.github.timofeevda.gwt.rxjs.interop.functions.Scanner;
import com.github.timofeevda.gwt.rxjs.interop.functions.ToObservableMapper;
import com.github.timofeevda.gwt.rxjs.interop.functions.ToObservableProjector;
import com.github.timofeevda.gwt.rxjs.interop.functions.TransformingAccumulator;
import com.github.timofeevda.gwt.rxjs.interop.functions.TransformingAccumulatorWithIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.UnaryArrayFunction;
import com.github.timofeevda.gwt.rxjs.interop.functions.UnaryFunction;
import com.github.timofeevda.gwt.rxjs.interop.observable.ConnectableObservable;
import com.github.timofeevda.gwt.rxjs.interop.observable.GroupedObservable;
import com.github.timofeevda.gwt.rxjs.interop.observable.Observable;
import com.github.timofeevda.gwt.rxjs.interop.observable.Observer;
import com.github.timofeevda.gwt.rxjs.interop.observable.ThrottleConfig;
import com.github.timofeevda.gwt.rxjs.interop.observable.TimeInterval;
import com.github.timofeevda.gwt.rxjs.interop.observable.Timestamp;
import com.github.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;
import com.github.timofeevda.gwt.rxjs.interop.subject.Subject;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Contains higher-order operators which can be used with pipe operator.
 * <p>
 * Methods which accept {@link Iterable} instances assume that {@link Iterable} implementor is backed by native
 * JavaScript array
 */
@JsType(namespace = "rxjs", isNative = true, name = "operators")
@SuppressWarnings("unused")
public class RxJSOperators {

    public native static <T> OperatorFunction<T, T> audit(Func1<T, Observable<?>> durationSelector);

    public native static <T> OperatorFunction<T, T> auditTime(int duration);

    public native static <T> OperatorFunction<T, T> auditTime(int duration, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T[]> buffer(Observable<?> closingNotifier);

    public native static <T> OperatorFunction<T, T[]> bufferCount(int bufferSize);

    public native static <T> OperatorFunction<T, T[]> bufferCount(int bufferSize, int startBufferEvery);

    public native static <T> OperatorFunction<T, T[]> bufferTime(int bufferTimeSpan);

    public native static <T> OperatorFunction<T, T[]> bufferTime(int bufferTimeSpan, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T[]> bufferTime(int bufferTimeSpan, int bufferCreationInterval);

    public native static <T> OperatorFunction<T, T[]> bufferTime(int bufferTimeSpan,
                                                                 int bufferCreationInterval,
                                                                 Scheduler scheduler);

    public native static <T> OperatorFunction<T, T[]> bufferTime(int bufferTimeSpan,
                                                                 int bufferCreationInterval,
                                                                 int maxBufferSize);

    public native static <T> OperatorFunction<T, T[]> bufferTime(int bufferTimeSpan,
                                                                 int bufferCreationInterval,
                                                                 int maxBufferSize,
                                                                 Scheduler scheduler);

    public native static <T, O> OperatorFunction<T, T[]> bufferToggle(Observable<O> openings,
                                                                      Func1<O, Observable<?>> closingSelector);

    public native static <T, O> OperatorFunction<T, T[]> bufferWhen(Func0<Observable<?>> closingSelector);

    public native static <T, R> OperatorFunction<T, R> catchError(ErrorCatcher<? super T, ? extends R> errorCatcher);

    public native static <T> OperatorFunction<T, T> combineAll();

    public native static <T, R> OperatorFunction<T, R> combineAll(Func1<Object[], ? extends R> combiner);

    public native static <T> OperatorFunction<T, T> concatAll();

    public native static <T, R> OperatorFunction<T, R> concatMap(Func1<? super T, ? extends R> mapper);

    public native static <T, R> OperatorFunction<T, R> concatMap(Projector<? super T, ? extends R> project);

    public native static <T, I, R> OperatorFunction<T, R> concatMap(ToObservableMapper<? super T, ? extends I> mapper,
                                                                    ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native static <T, I, R> OperatorFunction<T, R> concatMap(ToObservableProjector<? super T, ? extends I> project,
                                                                    ResultSelector<? super T, ? super I, R> resultSelector);

    public native static <T, R> OperatorFunction<T, R> concatMapTo(Observable<? extends R> observable);

    public native static <T, I, R> OperatorFunction<T, R> concatMapTo(Observable<I> observable,
                                                                      ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native static <T> OperatorFunction<T, Integer> count();

    public native static <T> OperatorFunction<T, Integer> count(Predicate<? super T> predicate);

    public native static <T> OperatorFunction<T, Integer> count(PredicateWithIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, Integer> count(PredicateWithSourceIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> debounce(Func1<? super T, Observable<Integer>> durationSelector);

    public native static <T> OperatorFunction<T, T> debounceTime(int dueTime);

    public native static <T> OperatorFunction<T, T> debounceTime(int dueTime, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> defaultIfEmpty();

    public native static <T, R extends T> OperatorFunction<T, R> defaultIfEmpty(R defaultValue);

    public native static <T> OperatorFunction<T, T> delay(int delay);

    public native static <T> OperatorFunction<T, T> delay(int delay, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> delayWhen(Func1<? super T, Observable<?>> delayDurationSelector);

    public native static <T> OperatorFunction<T, T> delayWhen(Func1<? super T, Observable<?>> delayDurationSelector,
                                                              Observable<?> subscriptionDelay);

    public native static <T> OperatorFunction<T, T> delayWhen(Projector<? super T, Observable<?>> delayDurationSelector);

    public native static <T> OperatorFunction<T, T> delayWhen(Projector<? super T, Observable<?>> delayDurationSelector,
                                                              Observable<?> subscriptionDelay);

    public native static <T> OperatorFunction<T, T> distinct();

    public native static <T, K> OperatorFunction<T, T> distinct(Func1<? super T, K> keySelector);

    public native static <T, K> OperatorFunction<T, T> distinct(Func1<? super T, K> keySelector,
                                                                Observable<?> flushes);

    public native static <T> OperatorFunction<T, T> distinctUntilChanged();

    public native static <T> OperatorFunction<T, T> distinctUntilChanged(Predicate2<? super T> predicate);

    public native static <T, K> OperatorFunction<T, T> distinctUntilChanged(Predicate2<? super K> predicate,
                                                                            KeySelector<? super T, K> keySelector);


    public native static <T> OperatorFunction<T, T> distinctUntilKeyChanged(String key);

    public native static <T, K> OperatorFunction<T, T> distinctUntilKeyChanged(String key, Predicate2<? super K> predicate);

    public native static <T> OperatorFunction<T, T> elementAt(int index);

    public native static <T, R extends T> OperatorFunction<T, T> elementAt(int index, R defaultValue);

    public native static <T> OperatorFunction<T, T> endWith();

    public native static <T> OperatorFunction<T, T> endWith(Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> endWith(T v1);

    public native static <T> OperatorFunction<T, T> endWith(T v1, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3, T v4);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3, T v4, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3, T v4, T v5);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3, T v4, T v5, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3, T v4, T v5, T v6);

    public native static <T> OperatorFunction<T, T> endWith(T v1, T v2, T v3, T v4, T v5, T v6, Scheduler scheduler);

    public native static <T> OperatorFunction<T, Boolean> every(Predicate<T> predicate);

    public native static <T> OperatorFunction<T, Boolean> every(PredicateWithIndex<T> predicate);

    public native static <T> OperatorFunction<T, Boolean> every(PredicateWithSourceIndex<T> predicate);

    public native static <T> OperatorFunction<T, T> exhaust();

    public native static <T, R> OperatorFunction<T, R> exhaustMap(Func1<? super T, ? extends R> mapper);

    public native static <T, R> OperatorFunction<T, R> exhaustMap(Projector<? super T, ? extends R> project);

    public native static <T, R> OperatorFunction<T, R> expand(Func1<? super T, ? extends R> mapper);

    public native static <T, R> OperatorFunction<T, R> expand(Projector<? super T, ? extends R> project);

    public native static <T, R> OperatorFunction<T, R> expand(Func1<? super T, ? extends R> mapper, int concurrent);

    public native static <T, R> OperatorFunction<T, R> expand(Projector<? super T, ? extends R> project, int concurrent);

    public native static <T, R> OperatorFunction<T, R> expand(Func1<? super T, ? extends R> mapper, int concurrent,
                                                              Scheduler scheduler);

    public native static <T, R> OperatorFunction<T, R> expand(Projector<? super T, ? extends R> project, int concurrent,
                                                              Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> filter(Predicate<? super T> predicate);

    public native static <T> OperatorFunction<T, T> filter(PredicateWithIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> finalize(Action0 action);

    public native static <T> OperatorFunction<T, T> find(Predicate<? super T> predicate);

    public native static <T> OperatorFunction<T, T> find(PredicateWithIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> find(PredicateWithSourceIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, Integer> findIndex(Predicate<? super T> predicate);

    public native static <T> OperatorFunction<T, Integer> findIndex(PredicateWithIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, Integer> findIndex(PredicateWithSourceIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> first();

    public native static <T> OperatorFunction<T, T> first(Predicate<? super T> predicate);

    public native static <T> OperatorFunction<T, T> first(PredicateWithIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> first(PredicateWithSourceIndex<? super T> predicate);

    public native <T, R> OperatorFunction<T, R> first(Predicate<? super T> predicate,
                                                      R defaultValue);

    public native <T, R> OperatorFunction<T, R> first(PredicateWithIndex<? super T> predicate,
                                                      R defaultValue);

    public native <T, R> OperatorFunction<T, R> first(PredicateWithSourceIndex<? super T> predicate,
                                                      R defaultValue);

    public native static <T, K> OperatorFunction<T, GroupedObservable<K, T>> groupBy(
            KeySelector<? super T, ? extends K> keySelector);

    public native static <T, K, R> OperatorFunction<T, GroupedObservable<K, R>> groupBy(
            KeySelector<? super T, ? extends K> keySelector,
            ElementSelector<? super T, ? extends R> elementSelector);

    public native static <T, K, R> OperatorFunction<T, GroupedObservable<K, R>> groupBy(
            KeySelector<? super T, ? extends K> keySelector,
            ElementSelector<? super T, ? extends R> elementSelector,
            Func1<GroupedObservable<K, R>, Observable<?>> durationSelector);

    public native static <T, K, R> OperatorFunction<T, GroupedObservable<K, R>> groupBy(
            KeySelector<? super T, ? extends K> keySelector,
            ElementSelector<? super T, ? extends R> elementSelector,
            Func1<GroupedObservable<K, R>, Observable<?>> durationSelector,
            Func0<Subject<R>> subjectSelector);

    public native static <T> OperatorFunction<T, T> ignoreElements();

    public native static <T> OperatorFunction<T, Boolean> isEmpty();

    public native static <T> OperatorFunction<T, T> last();

    public native static <T> OperatorFunction<T, T> last(Predicate<? super T> predicate);

    public native static <T> OperatorFunction<T, T> last(PredicateWithIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> last(PredicateWithSourceIndex<? super T> predicate);

    public native static <T, R> OperatorFunction<T, R> last(Predicate<? super T> predicate,
                                                            R defaultValue);

    public native static <T, R> OperatorFunction<T, R> last(PredicateWithIndex<? super T> predicate,
                                                            R defaultValue);

    public native static <T, R> OperatorFunction<T, R> last(PredicateWithSourceIndex<? super T> predicate,
                                                            R defaultValue);

    public native static <T, R> OperatorFunction<T, R> map(Func1<? super T, ? extends R> mapper);

    public native static <T, R> OperatorFunction<T, R> map(Projector<? super T, ? extends R> project);

    public native static <T, R> OperatorFunction<T, R> mapTo(R value);

    public native static <T> OperatorFunction<T, T> max();

    public native static <T> OperatorFunction<T, T> max(Comparator<? super T> compare);

    public native static <T> OperatorFunction<T, T> mergeAll();

    public native static <T> OperatorFunction<T, T> mergeAll(int concurrent);

    public native static <T, R> OperatorFunction<T, R> mergeMap(ToObservableMapper<? super T, ? extends R> mapper);

    public native static <T, R> OperatorFunction<T, R> mergeMap(ToObservableProjector<? super T, ? extends R> project);

    @JsMethod(name = "mergeMap")
    public native static <T, R> OperatorFunction<T, R> flatMap(ToObservableMapper<? super T, ? extends R> mapper);

    @JsMethod(name = "mergeMap")
    public native static <T, R> OperatorFunction<T, R> flatMap(ToObservableProjector<? super T, ? extends R> project);

    public native static <T, R> OperatorFunction<T, R> mergeMapTo(Observable<? extends R> observable);

    public native static <T, R> OperatorFunction<T, R> mergeMapTo(Observable<? extends R> observable, int concurrent);


    @JsMethod(name = "mergeMapTo")
    public native static <T, R> OperatorFunction<T, R> flatMapTo(Observable<? extends R> observable);

    @JsMethod(name = "mergeMapTo")
    public native static <T, R> OperatorFunction<T, R> flatMapTo(Observable<? extends R> observable, int concurrent);

    public native static <T, R> OperatorFunction<T, R> mergeScan(Scanner<R, ? super T> scanner, R seed);

    public native static <T, R> OperatorFunction<T, R> mergeScan(Scanner<R, ? super T> scanner, R seed, int concurrent);

    public native static <T> OperatorFunction<T, T> min();

    public native static <T> OperatorFunction<T, T> min(Comparator<? super T> compare);

    public native static <T> UnaryFunction<Observable<T>, ConnectableObservable<T>> multicast(Subject<? extends T> subject);

    public native static <T> UnaryFunction<Observable<T>, ConnectableObservable<T>> multicast(Factory<Subject<? extends T>> subjectFactory);

    public native static <T, R> UnaryFunction<Observable<T>, ConnectableObservable<R>> multicast(Subject<? extends T> subject, OperatorFunction<? super T, ? extends R> selector);

    public native static <T, R> UnaryFunction<Observable<T>, ConnectableObservable<R>> multicast(Factory<Subject<? extends T>> subjectFactory, OperatorFunction<? super T, ? extends R> selector);

    public native static <T> OperatorFunction<T, T> observeOn(Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> observeOn(Scheduler scheduler, int delay);

    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Observable<? extends T> v1);

    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Observable<? extends T> v1,
                                                                      Observable<? extends T> v2);

    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Observable<? extends T> v1,
                                                                      Observable<? extends T> v2,
                                                                      Observable<? extends T> v3);

    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Observable<? extends T> v1,
                                                                      Observable<? extends T> v2,
                                                                      Observable<? extends T> v3,
                                                                      Observable<? extends T> v4);

    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Observable<? extends T> v1,
                                                                      Observable<? extends T> v2,
                                                                      Observable<? extends T> v3,
                                                                      Observable<? extends T> v4,
                                                                      Observable<? extends T> v5);

    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Observable<? extends T> v1,
                                                                      Observable<? extends T> v2,
                                                                      Observable<? extends T> v3,
                                                                      Observable<? extends T> v4,
                                                                      Observable<? extends T> v5,
                                                                      Observable<? extends T> v6);

    @SafeVarargs
    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Observable<? extends T>... vs);

    public native static <T> OperatorFunction<T, T> onErrorResumeNext(Iterable<Observable<T>> inputObservables);

    public native static <T> OperatorFunction<T, T[]> pairwise();

    public native static <T> UnaryFunction<Observable<T>, Observable<T>[]> partition(Predicate<? super T> predicate);

    public native static <T> UnaryArrayFunction<T, T> partition(PredicateWithIndex<? super T> predicate);

    public native static <T, R> OperatorFunction<T, R> pluck(String... props);

    public native static <T> UnaryFunction<Observable<T>, ConnectableObservable<T>> publish();

    public native static <T, R> UnaryFunction<Observable<T>, ConnectableObservable<R>> publish(OperatorFunction<? super T, ? extends R> selector);

    public native static <R extends T, T> UnaryFunction<Observable<T>, ConnectableObservable<T>> publishBehavior(R value);

    public native static <R extends T, T> UnaryFunction<Observable<T>, ConnectableObservable<T>> publishLast(T value);

    public native static <T> UnaryFunction<Observable<T>, ConnectableObservable<T>> publishReplay();

    public native static <T> UnaryFunction<Observable<T>, ConnectableObservable<T>> publishReplay(int bufferSize);

    public native static <T> UnaryFunction<Observable<T>, ConnectableObservable<T>> publishReplay(int bufferSize, int windowTime);

    public native static <T> UnaryFunction<Observable<T>, ConnectableObservable<T>> publishReplay(int bufferSize,
                                                                                                  int windowTime,
                                                                                                  Scheduler scheduler);

    public native static <T, R> UnaryFunction<Observable<T>, ConnectableObservable<R>> publishReplay(int bufferSize,
                                                                                                     int windowTime,
                                                                                                     OperatorFunction<? super T, ? extends R> selector,
                                                                                                     Scheduler scheduler);

    @SafeVarargs
    public native static <T> OperatorFunction<T, T> race(Observable<? extends T>... observables);

    public native static <T> OperatorFunction<T, T> race(Iterable<Observable<T>> observables);

    public native static <T> OperatorFunction<T, T> reduce(Accumulator<T> accumulator);

    public native static <T> OperatorFunction<T, T> reduce(Accumulator<T> accumulator, T seed);

    public native static <T> OperatorFunction<T, T> reduce(AccumulatorWithIndex<T> accumulator);

    public native static <T> OperatorFunction<T, T> reduce(AccumulatorWithIndex<T> accumulator, T seed);

    public native static <T, R> OperatorFunction<T, R> reduce(TransformingAccumulator<R, T> accumulator);

    public native static <T, R> OperatorFunction<T, R> reduce(TransformingAccumulator<R, T> accumulator, R seed);

    public native static <T, R> OperatorFunction<T, R> reduce(TransformingAccumulatorWithIndex<R, T> accumulator);

    public native static <T, R> OperatorFunction<T, R> reduce(TransformingAccumulatorWithIndex<R, T> accumulator, R seed);

    @JsMethod(name = "reduce")
    public native static <T> OperatorFunction<T, T[]> reduceArray(Accumulator<T[]> accumulator);

    @JsMethod(name = "reduce")
    public native static <T> OperatorFunction<T, T[]> reduceArray(Accumulator<T[]> accumulator, T[] seed);

    @JsMethod(name = "reduce")
    public native static <T> OperatorFunction<T, T[]> reduceArray(AccumulatorWithIndex<T[]> accumulator);

    @JsMethod(name = "reduce")
    public native static <T> OperatorFunction<T, T[]> reduceArray(AccumulatorWithIndex<T[]> accumulator, T[] seed);

    public native static <T> OperatorFunction<T, T> refCount();

    public native static <T> OperatorFunction<T, T> repeat();

    public native static <T> OperatorFunction<T, T> repeat(int count);

    public native static <T> OperatorFunction<T, T> repeatWhen(Func1<Observable<?>, Observable<?>> notifier);

    public native static <T> OperatorFunction<T, T> retry();

    public native static <T> OperatorFunction<T, T> retry(int count);

    public native static <T> OperatorFunction<T, T> retryWhen(Func1<Observable<?>, Observable<?>> notifier);

    public native static <T> OperatorFunction<T, T> sample(Observable<?> notifier);

    public native static <T> OperatorFunction<T, T> sampleTime(int period);

    public native static <T> OperatorFunction<T, T> sampleTime(int period, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> scan(Accumulator<T> accumulator);

    public native static <T> OperatorFunction<T, T> scan(Accumulator<T> accumulator, T seed);

    public native static <T> OperatorFunction<T, T> scan(AccumulatorWithIndex<T> accumulator);

    public native static <T> OperatorFunction<T, T> scan(AccumulatorWithIndex<T> accumulator, T seed);

    public native static <T, R> OperatorFunction<T, R> scan(TransformingAccumulator<R, T> accumulator);

    public native static <T, R> OperatorFunction<T, R> scan(TransformingAccumulator<R, T> accumulator, R seed);

    public native static <T, R> OperatorFunction<T, R> scan(TransformingAccumulatorWithIndex<R, T> accumulator);

    public native static <T, R> OperatorFunction<T, R> scan(TransformingAccumulatorWithIndex<R, T> accumulator, R seed);

    @JsMethod(name = "scan")
    public native static <T> OperatorFunction<T, T[]> scanArray(Accumulator<T[]> accumulator);

    @JsMethod(name = "scan")
    public native static <T> OperatorFunction<T, T[]> scanArray(Accumulator<T[]> accumulator, T[] seed);

    @JsMethod(name = "scan")
    public native static <T> OperatorFunction<T, T[]> scanArray(AccumulatorWithIndex<T[]> accumulator);

    @JsMethod(name = "scan")
    public native static <T> OperatorFunction<T, T[]> scanArray(AccumulatorWithIndex<T[]> accumulator, T[] seed);

    public native static <T> OperatorFunction<T, Boolean> sequenceEqual(Observable<? extends T> compareTo, Predicate2<? super T> predicate);

    public native static <T> OperatorFunction<T, T> share();

    public native static <T> OperatorFunction<T, T> shareReplay(int bufferSize);

    public native static <T> OperatorFunction<T, T> shareReplay(int bufferSize, int windowTime);

    public native static <T> OperatorFunction<T, T> shareReplay(int bufferSize, int windowTime, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> single(Predicate<? super T> predicate);

    public native static <T> OperatorFunction<T, T> single(PredicateWithIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> single(PredicateWithSourceIndex<? super T> predicate);

    public native static <T> OperatorFunction<T, T> skip(int count);

    public native static <T> OperatorFunction<T, T> skipLast(int count);

    public native static <T> OperatorFunction<T, T> skipUntil(Observable<?> notifier);

    public native static <T> OperatorFunction<T, T> skipWhile(Predicate<T> predicate);

    public native static <T> OperatorFunction<T, T> skipWhile(PredicateWithIndex<T> predicate);

    public native static <T> OperatorFunction<T, T> startWith(T v1);

    public native static <T> OperatorFunction<T, T> startWith(T v1, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3, T v4);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3, T v4, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3, T v4, T v5);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3, T v4, T v5, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3, T v4, T v5, T v6);

    public native static <T> OperatorFunction<T, T> startWith(T v1, T v2, T v3, T v4, T v5, T v6, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> subscribeOn(Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> subscribeOn(Scheduler scheduler, int delay);

    public native static <T> OperatorFunction<Observable<T>, T> switchAll();

    public native static <T, R> OperatorFunction<T, R> switchMap(Func1<? super T, ? extends R> mapper);

    public native static <T, R> OperatorFunction<T, R> switchMap(Projector<? super T, ? extends R> project);

    public native static <T, R> OperatorFunction<T, R> switchMapTo(Observable<? extends R> observable);

    public native static <T> OperatorFunction<T, T> take(int count);

    public native static <T> OperatorFunction<T, T> takeLast(int count);

    public native static <T> OperatorFunction<T, T> takeUntil(Observable<?> notifier);

    public native static <T> OperatorFunction<T, T> takeWhile(Predicate<T> predicate);

    public native static <T> OperatorFunction<T, T> takeWhile(PredicateWithIndex<T> predicate);

    public native static <T> OperatorFunction<T, T> tap(Action1<? super T> onNext);

    public native static <T> OperatorFunction<T, T> tap(Action1<? super T> onNext, Action1<?> onError, Action0 onCompleted);

    public native static <T> OperatorFunction<T, T> tap(Observer<? super T> observer);

    public native static <T> OperatorFunction<T, T> throttle(Func1<? super T, Observable<?>> durationSelector);

    public native static <T> OperatorFunction<T, T> throttleTime(int duration);

    public native static <T> OperatorFunction<T, T> throttleTime(int duration, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> throttleTime(int duration, Scheduler scheduler,
                                                                 ThrottleConfig throttleConfig);

    public native static <T> OperatorFunction<T, T> throwIfEmpty(Func0<?> errorFactory);

    public native static <T> OperatorFunction<T, TimeInterval<T>> timeInterval();

    public native static <T> OperatorFunction<T, TimeInterval<T>> timeInterval(Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> timeout(int due);

    public native static <T> OperatorFunction<T, T> timeout(int due, Scheduler scheduler);

    public native static <T> OperatorFunction<T, T> timeoutWith(int due, Observable<? extends T> withObservable);

    public native static <T> OperatorFunction<T, T> timeoutWith(int due, Observable<? extends T> withObservable, Scheduler scheduler);

    public native static <T> OperatorFunction<T, Timestamp<T>> timestamp();

    public native static <T> OperatorFunction<T, Timestamp<T>> timestamp(Scheduler scheduler);

    public native static <T> OperatorFunction<T, T[]> toArray();

    public native static <T> OperatorFunction<T, Observable<T>> window(Observable<?> windowBoundaries);

    public native static <T> OperatorFunction<T, Observable<T>> windowCount(int windowSize);

    public native static <T> OperatorFunction<T, Observable<T>> windowCount(int windowSize, int startWindowEvery);

    public native static <T> OperatorFunction<T, Observable<T>> windowTime(int windowTimeSpan);

    public native static <T> OperatorFunction<T, Observable<T>> windowTime(int windowTimeSpan, Scheduler scheduler);

    public native static <T> OperatorFunction<T, Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval);

    public native static <T> OperatorFunction<T, Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, Scheduler scheduler);

    public native static <T> OperatorFunction<T, Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, int maxWindowSize);

    public native static <T> OperatorFunction<T, Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, int maxWindowSize, Scheduler scheduler);

    public native static <T, O> OperatorFunction<T, T[]> windowToggle(Observable<O> openings,
                                                                      Func1<O, Observable<?>> closingSelector);

    public native static <T, O> OperatorFunction<T, T[]> windowWhen(Func0<Observable<?>> closingSelector);

    public native static <T, R> OperatorFunction<T, R> withLatestFrom(Func1<? super T, ? extends R> combiner);

    public native static <T, T2, R> OperatorFunction<T, R> withLatestFrom(Observable<? extends T2> v2,
                                                                          Func2<? super T, ? super T2, ? extends R> combiner);

    public native static <T, T2, T3, R> OperatorFunction<T, R> withLatestFrom(Observable<? extends T2> v2,
                                                                              Observable<? extends T3> v3,
                                                                              Func3<? super T, ? super T2, ? super T3, ? extends R> combiner);

    public native static <T, T2, T3, T4, R> OperatorFunction<T, R> withLatestFrom(Observable<? extends T2> v2,
                                                                                  Observable<? extends T3> v3,
                                                                                  Observable<? extends T4> v4,
                                                                                  Func4<? super T, ? super T2, ? super T3, ? super T4, ? extends R> combiner);

    public native static <T, T2, T3, T4, T5, R> OperatorFunction<T, R> withLatestFrom(Observable<? extends T2> v2,
                                                                                      Observable<? extends T3> v3,
                                                                                      Observable<? extends T4> v4,
                                                                                      Observable<? extends T5> v5,
                                                                                      Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combiner);

    public native static <T, T2, T3, T4, T5, T6, R> OperatorFunction<T, R> withLatestFrom(Observable<? extends T2> v2,
                                                                                          Observable<? extends T3> v3,
                                                                                          Observable<? extends T4> v4,
                                                                                          Observable<? extends T5> v5,
                                                                                          Observable<? extends T6> v6,
                                                                                          Func6<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combiner);

    public native static <T> OperatorFunction<T, T[]> withLatestFrom(Observable<? extends T> v2);

    public native static <T> OperatorFunction<T, T[]> withLatestFrom(Observable<? extends T> v2,
                                                                     Observable<? extends T> v3);

    public native static <T> OperatorFunction<T, T[]> withLatestFrom(Observable<? extends T> v2,
                                                                     Observable<? extends T> v3,
                                                                     Observable<? extends T> v4);

    public native static <T> OperatorFunction<T, T[]> withLatestFrom(Observable<? extends T> v2,
                                                                     Observable<? extends T> v3,
                                                                     Observable<? extends T> v4,
                                                                     Observable<? extends T> v5);

    public native static <T> OperatorFunction<T, T[]> withLatestFrom(Observable<? extends T> v2,
                                                                     Observable<? extends T> v3,
                                                                     Observable<? extends T> v4,
                                                                     Observable<? extends T> v5,
                                                                     Observable<? extends T> v6);

    public native static <T> OperatorFunction<T, T[]> withLatestFrom(Observable<? extends T>[] observables);

    public native static <T> OperatorFunction<T, T[]> withLatestFrom(Iterable<Observable<T>> observables);

    public native static <T, R> OperatorFunction<T, R> withLatestFrom(Observable<? extends T>[] observables,
                                                                      Func1<T[], ? extends R> combiner);

    public native static <T, R> OperatorFunction<T, R> withLatestFrom(Iterable<Observable<T>> observables,
                                                                      Func1<T[], ? extends R> combiner);

    public native static <T> OperatorFunction<T, T> zipAll();

    public native static <T, R> OperatorFunction<T, R> zipAll(Func1<T[], ? extends R> mapper);

}
