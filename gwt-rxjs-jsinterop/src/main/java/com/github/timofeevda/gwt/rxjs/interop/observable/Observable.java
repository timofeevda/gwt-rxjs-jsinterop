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

import com.github.timofeevda.gwt.rxjs.interop.functions.Accumulator;
import com.github.timofeevda.gwt.rxjs.interop.functions.AccumulatorWithIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;
import com.github.timofeevda.gwt.rxjs.interop.functions.Action1;
import com.github.timofeevda.gwt.rxjs.interop.functions.Comparator;
import com.github.timofeevda.gwt.rxjs.interop.functions.ConditionFunc;
import com.github.timofeevda.gwt.rxjs.interop.functions.DeferProducer;
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
import com.github.timofeevda.gwt.rxjs.interop.functions.IterateFunc;
import com.github.timofeevda.gwt.rxjs.interop.functions.KeySelector;
import com.github.timofeevda.gwt.rxjs.interop.functions.LetFunction;
import com.github.timofeevda.gwt.rxjs.interop.functions.ObservableFactoryFromResource;
import com.github.timofeevda.gwt.rxjs.interop.functions.OperatorFunction;
import com.github.timofeevda.gwt.rxjs.interop.functions.Predicate;
import com.github.timofeevda.gwt.rxjs.interop.functions.Predicate2;
import com.github.timofeevda.gwt.rxjs.interop.functions.PredicateWithIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.PredicateWithSourceIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.Projector;
import com.github.timofeevda.gwt.rxjs.interop.functions.ResultFunc;
import com.github.timofeevda.gwt.rxjs.interop.functions.ResultSelector;
import com.github.timofeevda.gwt.rxjs.interop.functions.ResultSelectorWithIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.Scanner;
import com.github.timofeevda.gwt.rxjs.interop.functions.TransformingAccumulator;
import com.github.timofeevda.gwt.rxjs.interop.functions.TransformingAccumulatorWithIndex;
import com.github.timofeevda.gwt.rxjs.interop.functions.UnaryFunction;
import com.github.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;
import com.github.timofeevda.gwt.rxjs.interop.subject.Subject;
import com.github.timofeevda.gwt.rxjs.interop.subscription.AnonymousSubscription;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;
import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Contains bindings for the native Rx.Observable instance
 * <p/>
 * Methods which accept {@link Iterable} instances assume that {@link Iterable} implementor is backed by native JavaScript array
 * <p/>
 * Due to limitations of GWT's {@link JsFunction} annotation, pipe method can't be implemented using hierarchy of function
 * definitions, so certain amount of different combinations between {@link UnaryFunction} and {@link OperatorFunction}
 * is implemented
 *
 * @param <T> - observable value
 * @author dtimofeev since 20.12.2016.
 */
@JsType(namespace = "Rx", isNative = true)
@SuppressWarnings("unused")
public class Observable<T> {

    @SafeVarargs
    public native static <T> Observable<T> of(T... args);

    public native static <T> Observable<T> of(T[] args, Scheduler scheduler);

    public native static <T> Observable<T> of(T item1);

    public native static <T> Observable<T> of(T item1, Scheduler scheduler);

    public native static <T> Observable<T> of(T item1, T item2);

    public native static <T> Observable<T> of(T item1, T item2, Scheduler scheduler);

    public native static <T> Observable<T> of(T item1, T item2, T item3);

    public native static <T> Observable<T> of(T item1, T item2, T item3, Scheduler scheduler);

    public native static <T> Observable<T> of(T item1, T item2, T item3, T item4);

    public native static <T> Observable<T> of(T item1, T item2, T item3, T item4, Scheduler scheduler);

    public native static <T> Observable<T> of(T item1, T item2, T item3, T item4, T item5);

    public native static <T> Observable<T> of(T item1, T item2, T item3, T item4, T item5, Scheduler scheduler);

    public native static <T> Observable<T> of(T item1, T item2, T item3, T item4, T item5, T item6);

    public native static <T> Observable<T> of(T item1, T item2, T item3, T item4, T item5, T item6, Scheduler scheduler);

    public native static <T> Observable<T[]> forkJoin(Observable<? extends T> v1,
                                                      Observable<? extends T> v2);

    public native static <T> Observable<T[]> forkJoin(Observable<? extends T> v1,
                                                      Observable<? extends T> v2,
                                                      Observable<? extends T> v3);

    public native static <T> Observable<T[]> forkJoin(Observable<? extends T> v1,
                                                      Observable<? extends T> v2,
                                                      Observable<? extends T> v3,
                                                      Observable<? extends T> v4);

    public native static <T> Observable<T[]> forkJoin(Observable<? extends T> v1,
                                                      Observable<? extends T> v2,
                                                      Observable<? extends T> v3,
                                                      Observable<? extends T> v4,
                                                      Observable<? extends T> v5);

    public native static <T> Observable<T[]> forkJoin(Observable<? extends T> v1,
                                                      Observable<? extends T> v2,
                                                      Observable<? extends T> v3,
                                                      Observable<? extends T> v4,
                                                      Observable<? extends T> v5,
                                                      Observable<? extends T> v6);

    public native static <T, R> Observable<R> forkJoin(Observable<? extends T> v1,
                                                       Func1<? super T, ? extends R> mapper);

    public native static <T, T2, R> Observable<R> forkJoin(Observable<? extends T> v1,
                                                           Observable<? extends T2> v2,
                                                           Func2<? super T, ? super T2, ? extends R> mapper);

    public native static <T, T2, T3, R> Observable<R> forkJoin(Observable<? extends T> v1,
                                                               Observable<? extends T2> v2,
                                                               Observable<? extends T3> v3,
                                                               Func3<? super T, ? super T2, ? super T3, ? extends R> mapper);

    public native static <T, T2, T3, T4, R> Observable<R> forkJoin(Observable<? extends T> v1,
                                                                   Observable<? extends T2> v2,
                                                                   Observable<? extends T3> v3,
                                                                   Observable<? extends T4> v4,
                                                                   Func4<? super T, ? super T2, ? super T3, ? super T4, ? extends R> mapper);

    public native static <T, T2, T3, T4, T5, R> Observable<R> forkJoin(Observable<? extends T> v1,
                                                                       Observable<? extends T2> v2,
                                                                       Observable<? extends T3> v3,
                                                                       Observable<? extends T4> v4,
                                                                       Observable<? extends T5> v5,
                                                                       Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> mapper);

    public native static <T, T2, T3, T4, T5, T6, R> Observable<R> forkJoin(Observable<? extends T> v1,
                                                                           Observable<? extends T2> v2,
                                                                           Observable<? extends T3> v3,
                                                                           Observable<? extends T4> v4,
                                                                           Observable<? extends T5> v5,
                                                                           Observable<? extends T6> v6,
                                                                           Func6<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> mapper);

    @SafeVarargs
    public native static <T> Observable<T[]> forkJoin(Observable<? extends T>... observables);

    public native static <T, R> Observable<R> forkJoin(Observable<? extends T>[] observables,
                                                       Func1<T[], ? extends R> mapper);

    public native static <T> Observable<T[]> forkJoin(Iterable<Observable<T>> observables);

    public native static <T, R> Observable<R> forkJoin(Iterable<Observable<T>> observables,
                                                       Func1<T[], ? extends R> mapper);

    public native static <T> Observable<T> from(T[] args);

    public native static <T> Observable<T> from(String characters);

    public native static <T> Observable<T> fromEvent(Element target, String eventName);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, boolean useCapture);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.ListenerOptions listenerOptions);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.CapturingListenerOptions listenerOptions);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.PassiveListenerOptions listenerOptions);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.OnceListenerOptions listenerOptions);

    public native static <T, S> Observable<T> generate(S initialState,
                                                       ConditionFunc<? super S> condition,
                                                       IterateFunc<S> iterate,
                                                       ResultFunc<? super S, ? extends T> resultSelector);

    public native static <T, S> Observable<T> generate(S initialState,
                                                       ConditionFunc<? super S> condition,
                                                       IterateFunc<S> iterate,
                                                       ResultFunc<? super S, ? extends T> resultSelector,
                                                       Scheduler scheduler);

    public native static <T> Observable<T> create(OnSubscribe<? extends T> onSubscribe);

    public native Observable<T> audit(Func1<T, Observable<?>> durationSelector);

    public native Observable<T> auditTime(int duration);

    public native Observable<T> auditTime(int duration, Scheduler scheduler);

    public native Observable<T[]> buffer(Observable closingNotifier);

    public native Observable<T[]> bufferCount(int bufferSize);

    public native Observable<T[]> bufferCount(int bufferSize, int startBufferEvery);

    public native Observable<T[]> bufferTime(int bufferTimeSpan);

    public native Observable<T[]> bufferTime(int bufferTimeSpan, Scheduler scheduler);

    public native Observable<T[]> bufferTime(int bufferTimeSpan, int bufferCreationInterval);

    public native Observable<T[]> bufferTime(int bufferTimeSpan, int bufferCreationInterval, Scheduler scheduler);

    public native Observable<T[]> bufferTime(int bufferTimeSpan, int bufferCreationInterval, int maxBufferSize);

    public native Observable<T[]> bufferTime(int bufferTimeSpan, int bufferCreationInterval, int maxBufferSize, Scheduler scheduler);

    public native <O> Observable<T[]> bufferToggle(Observable<O> openings, Func1<? super O, Observable<?>> closingSelector);

    public native Observable<T[]> bufferWhen(Func0<Observable<?>> closingSelector);

    @JsMethod(name = "catch")
    public native <R> Observable<R> _catch(ErrorCatcher<? super T, ? extends R> catcher);

    public native Observable<T> combineAll();

    public native <R> Observable<R> combineAll(Func1<T[], ? extends R> combiner);

    public native static <T, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                            Func1<? super T, ? extends R> combiner);

    public native static <T, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                            Func1<? super T, ? extends R> combiner,
                                                            Scheduler scheduler);

    public native static <T, T2, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                Observable<? extends T2> v2,
                                                                Func2<? super T, ? super T2, ? extends R> combiner);

    public native static <T, T2, R> Observable<R> combineLatest(Observable<? extends T> v,
                                                                Observable<? extends T2> v2,
                                                                Func2<? super T, ? super T2, ? extends R> combiner,
                                                                Scheduler scheduler);

    public native static <T, T2, T3, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                    Observable<? extends T2> v2,
                                                                    Observable<? extends T3> v3,
                                                                    Func3<? super T, ? super T2, ? super T3, ? extends R> combiner);

    public native static <T, T2, T3, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                    Observable<? extends T2> v2,
                                                                    Observable<? extends T3> v3,
                                                                    Func3<? super T, ? super T2, ? super T3, ? extends R> combiner,
                                                                    Scheduler scheduler);

    public native static <T, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                        Observable<? extends T2> v2,
                                                                        Observable<? extends T3> v3,
                                                                        Observable<? extends T4> v4,
                                                                        Func4<? super T, ? super T2, ? super T3, ? super T4, ? extends R> combiner);

    public native static <T, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                        Observable<? extends T2> v2,
                                                                        Observable<? extends T3> v3,
                                                                        Observable<? extends T4> v4,
                                                                        Func4<? super T, ? super T2, ? super T3, ? super T4, ? extends R> combiner,
                                                                        Scheduler scheduler);

    public native static <T, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                            Observable<? extends T2> v2,
                                                                            Observable<? extends T3> v3,
                                                                            Observable<? extends T4> v4,
                                                                            Observable<? extends T5> v5,
                                                                            Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combiner);

    public native static <T, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                            Observable<? extends T2> v2,
                                                                            Observable<? extends T3> v3,
                                                                            Observable<? extends T4> v4,
                                                                            Observable<? extends T5> v5,
                                                                            Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combiner,
                                                                            Scheduler scheduler);


    public native static <T, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                                Observable<? extends T2> v2,
                                                                                Observable<? extends T3> v3,
                                                                                Observable<? extends T4> v4,
                                                                                Observable<? extends T5> v5,
                                                                                Observable<? extends T6> v6,
                                                                                Func6<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combiner);


    public native static <T, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T> v1,
                                                                                Observable<? extends T2> v2,
                                                                                Observable<? extends T3> v3,
                                                                                Observable<? extends T4> v4,
                                                                                Observable<? extends T5> v5,
                                                                                Observable<? extends T6> v6,
                                                                                Func6<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combiner,
                                                                                Scheduler scheduler);


    public native static <T> Observable<T[]> combineLatest(Observable<? extends T> v1,
                                                           Observable<? extends T> v2);

    public native static <T> Observable<T[]> combineLatest(Observable<? extends T> v1,
                                                           Observable<? extends T> v2,
                                                           Scheduler scheduler);

    public native static <T> Observable<T[]> combineLatest(Observable<? extends T> v1,
                                                           Observable<? extends T> v2,
                                                           Observable<? extends T> v3);

    public native static <T> Observable<T[]> combineLatest(Observable<? extends T> v1,
                                                           Observable<? extends T> v2,
                                                           Observable<? extends T> v3,
                                                           Scheduler scheduler);

    public native static <T> Observable<T[]> combineLatest(Observable<? extends T> v1,
                                                           Observable<? extends T> v2,
                                                           Observable<? extends T> v3,
                                                           Observable<? extends T> v4);

    public native static <T> Observable<T[]> combineLatest(Observable<? extends T> v1,
                                                           Observable<? extends T> v2,
                                                           Observable<? extends T> v3,
                                                           Observable<? extends T> v4,
                                                           Scheduler scheduler);

    public native static <T> Observable<T> combineLatest(Observable<? extends T> v1,
                                                         Observable<? extends T> v2,
                                                         Observable<? extends T> v3,
                                                         Observable<? extends T> v4,
                                                         Observable<? extends T> v5);

    public native static <T> Observable<T> combineLatest(Observable<? extends T> v1,
                                                         Observable<? extends T> v2,
                                                         Observable<? extends T> v3,
                                                         Observable<? extends T> v4,
                                                         Observable<? extends T> v5,
                                                         Scheduler scheduler);

    public native static <T> Observable<T> combineLatest(Observable<? extends T> v1,
                                                         Observable<? extends T> v2,
                                                         Observable<? extends T> v3,
                                                         Observable<? extends T> v4,
                                                         Observable<? extends T> v5,
                                                         Observable<? extends T> v6);

    public native static <T> Observable<T> combineLatest(Observable<? extends T> v1,
                                                         Observable<? extends T> v2,
                                                         Observable<? extends T> v3,
                                                         Observable<? extends T> v4,
                                                         Observable<? extends T> v5,
                                                         Observable<? extends T> v6,
                                                         Scheduler scheduler);


    @SafeVarargs
    public native static <T> Observable<T[]> combineLatest(Observable<? extends T>... observables);

    public native static <T> Observable<T[]> combineLatest(Observable<? extends T>[] observables,
                                                           Scheduler scheduler);

    public native static <T, R> Observable<R> combineLatest(Observable<? extends T>[] observables,
                                                            Func1<T[], ? extends R> combiner);

    public native static <T, R> Observable<R> combineLatest(Observable<? extends T>[] observables,
                                                            Func1<T[], ? extends R> combiner,
                                                            Scheduler scheduler);

    public native static <T> Observable<T[]> combineLatest(Iterable<Observable<T>> observables);

    public native static <T> Observable<T[]> combineLatest(Iterable<Observable<T>> observables,
                                                           Scheduler scheduler);

    public native static <T, R> Observable<R> combineLatest(Iterable<Observable<T>> observables,
                                                            Func1<T[], ? extends R> combiner,
                                                            Scheduler scheduler);

    public native Observable<T> concatAll();

    public native static <T> Observable<T> concat(Observable<? extends T> v1);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Scheduler scheduler);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Scheduler scheduler);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Scheduler scheduler);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4,
                                                  Scheduler scheduler);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4,
                                                  Observable<? extends T> v5);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4,
                                                  Observable<? extends T> v5,
                                                  Scheduler scheduler);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4,
                                                  Observable<? extends T> v5,
                                                  Observable<? extends T> v6);

    public native static <T> Observable<T> concat(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4,
                                                  Observable<? extends T> v5,
                                                  Observable<? extends T> v6,
                                                  Scheduler scheduler);

    @SafeVarargs
    public native static <T> Observable<T> concat(Observable<? extends T>... observables);

    public native static <T> Observable<T> concat(Observable<? extends T>[] observables, Scheduler scheduler);

    public native static <T> Observable<T> concat(Iterable<Observable<T>> observables);

    public native static <T> Observable<T> concat(Iterable<Observable<T>> observables, Scheduler scheduler);

    public native <R> Observable<R> concatMap(Func1<? super T, ? extends R> mapper);

    public native <R> Observable<R> concatMap(Projector<? super T, ? extends R> projector);

    public native <I, R> Observable<T> concatMap(Func1<? super T, ? extends I> mapper,
                                                 ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<T> concatMap(Projector<? super T, ? extends I> projector,
                                                 ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <R> Observable<R> concatMapTo(Observable<? extends R> observable);

    public native <I, R> Observable<R> concatMapTo(Observable<I> observable,
                                                   ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native Observable<Integer> count();

    public native Observable<Integer> count(Predicate<? super T> predicate);

    public native Observable<Integer> count(PredicateWithIndex<? super T> predicate);

    public native Observable<Integer> count(PredicateWithSourceIndex<? super T> predicate);

    public native Observable<T> debounce(Func1<? super T, Observable<Integer>> durationSelector);

    public native Observable<T> debounceTime(int dueTime);

    public native Observable<T> debounceTime(int dueTime, Scheduler scheduler);

    public native Observable<T> defaultIfEmpty();

    public native <R extends T> Observable<R> defaultIfEmpty(R defaultValue);

    public native static <T> Observable<T> defer(DeferProducer<? extends T> producer);

    public native Observable<T> delay(int delay);

    public native Observable<T> delay(int delay, Scheduler scheduler);

    public native Observable<T> delayWhen(Func1<? super T, Observable<?>> delayDurationSelector);

    public native Observable<T> delayWhen(Func1<? super T, Observable<?>> delayDurationSelector,
                                          Observable<?> subscriptionDelay);

    public native Observable<T> distinct();

    public native <K> Observable<T> distinct(Func1<? super T, K> keySelector);

    public native <K> Observable<T> distinct(Func1<? super T, K> keySelector, Observable<?> flushes);

    public native Observable<T> distinctUntilChanged();

    public native Observable<T> distinctUntilChanged(Predicate2<? super T> predicate);

    public native <K> Observable<T> distinctUntilChanged(Predicate2<? super K> predicate,
                                                         Func1<? super T, K> keySelector);

    public native Observable<T> distinctUntilKeyChanged(String key);

    public native <K> Observable<T> distinctUntilKeyChanged(String key, Predicate2<? super K> predicate);

    @JsMethod(name = "do")
    public native Observable<T> _do(Action1<? super T> onNext);

    @JsMethod(name = "do")
    public native Observable<T> _do(Action1<? super T> onNext, Action1<?> onError, Action0 onCompleted);

    @JsMethod(name = "do")
    public native Observable<T> _do(Observer<? super T> observer);

    public native static <T> Observable<T> empty();

    public native Observable<T> elementAt(int index);

    public native <R extends T> Observable<T> elementAt(int index, R defaultValue);

    public native Observable<Boolean> every(Predicate<? super T> predicate);

    public native Observable<Boolean> every(PredicateWithIndex<? super T> predicate);

    public native Observable<Boolean> every(PredicateWithSourceIndex<? super T> predicate);

    @JsMethod(name = "throw")
    public native static <R> Observable<R> _throw(Object error);

    @JsMethod(name = "throw")
    public native static <R> Observable<R> _throw(Object error, Scheduler scheduler);

    public native Observable<T> exhaust();

    public native <R> Observable<T> exhaustMap(Func1<? super T, ? extends R> mapper);

    public native <R> Observable<T> exhaustMap(Projector<? super T, ? extends R> projector);

    public native <I, R> Observable<T> exhaustMap(Func1<? super T, ? extends I> mapper,
                                                  ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<T> exhaustMap(Projector<? super T, ? extends I> projector,
                                                  ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <R> Observable<R> expand(Func1<? super T, ? extends R> mapper);

    public native <R> Observable<R> expand(Projector<? super T, ? extends R> projector);

    public native <R> Observable<R> expand(Func1<? super T, ? extends R> mapper, int concurrent);

    public native <R> Observable<R> expand(Projector<? super T, ? extends R> projector, int concurrent);

    public native <R> Observable<R> expand(Func1<? super T, ? extends R> mapper, int concurrent, Scheduler scheduler);

    public native <R> Observable<R> expand(Projector<? super T, ? extends R> projector, int concurrent, Scheduler scheduler);

    public native Observable<T> filter(Predicate<? super T> predicate);

    public native Observable<T> filter(PredicateWithIndex<? super T> predicateWithIndex);

    @JsMethod(name = "finally")
    public native Observable<T> _finally(Action0 action);

    public native Observable<T> find(Predicate<? super T> predicate);

    public native Observable<T> find(PredicateWithIndex<? super T> predicate);

    public native Observable<Integer> findIndex(Predicate<? super T> predicate);

    public native Observable<Integer> findIndex(PredicateWithIndex<? super T> predicate);

    public native Observable<Integer> findIndex(PredicateWithSourceIndex<? super T> predicate);

    public native Observable<T> first(Predicate<? super T> predicate);

    public native Observable<T> first(PredicateWithIndex<? super T> predicate);

    public native Observable<T> first(PredicateWithSourceIndex<? super T> predicate);

    public native <I, R> Observable<R> first(Predicate<? super T> predicate,
                                             ResultSelectorWithIndex<? super T, ? extends R> resultSelector);

    public native <I, R> Observable<R> first(PredicateWithIndex<? super T> predicateWithIndex,
                                             ResultSelectorWithIndex<? super T, ? extends R> resultSelector);

    public native <I, R> Observable<R> first(PredicateWithSourceIndex<? super T> predicate,
                                             ResultSelectorWithIndex<? super T, ? extends R> resultSelector);

    public native <I, R> Observable<R> first(Predicate<? super T> predicate,
                                             ResultSelectorWithIndex<? super T, ? extends R> resultSelector,
                                             R defaultValue);

    public native <I, R> Observable<R> first(PredicateWithSourceIndex<? super T> predicateWithIndex,
                                             ResultSelectorWithIndex<? super T, ? extends R> resultSelector,
                                             R defaultValue);

    public native <I, R> Observable<R> first(PredicateWithIndex<? super T> predicateWithIndex,
                                             ResultSelectorWithIndex<? super T, ? extends R> resultSelector,
                                             R defaultValue);

    public native <K> Observable<GroupedObservable<K, T>> groupBy(KeySelector<? super T, ? extends K> keySelector);

    public native <K, R> Observable<GroupedObservable<K, R>> groupBy(KeySelector<? super T, ? extends K> keySelector,
                                                                     ElementSelector<? super T, ? extends R> elementSelector);

    public native Observable<T> ignoreElements();

    public native Observable<Boolean> isEmpty();

    @JsMethod(name = "if")
    public native static Observable<Boolean> _if(Func0<Boolean> condition);

    @JsMethod(name = "if")
    public native static Observable<Boolean> _if(Func0<Boolean> condition, Observable<?> thenSource);

    @JsMethod(name = "if")
    public native static Observable<Boolean> _if(Func0<Boolean> condition, Observable<?> thenSource, Observable<?> elseSource);

    public native static Observable<Integer> interval(int period);

    public native static Observable<Integer> interval(int period, Scheduler scheduler);

    public native Observable<T> last(Predicate<? super T> predicate);

    public native Observable<T> last(PredicateWithIndex<? super T> predicateWithIndex);

    public native <R> Observable<R> last(Predicate<? super T> predicate,
                                         ResultSelectorWithIndex<? super T, ? extends R> resultSelector);

    public native <R> Observable<R> last(PredicateWithIndex<? super T> predicateWithIndex,
                                         ResultSelectorWithIndex<? super T, ? extends R> resultSelector);

    public native <R> Observable<R> last(PredicateWithSourceIndex<? super T> predicate,
                                         ResultSelectorWithIndex<? super T, ? extends R> resultSelector);

    public native <R> Observable<R> last(Predicate<? super T> predicate,
                                         ResultSelectorWithIndex<? super T, ? extends R> resultSelector, R defaultValue);

    public native <R> Observable<R> last(PredicateWithIndex<? super T> predicateWithIndex,
                                         ResultSelectorWithIndex<? super T, ? extends R> resultSelector, R defaultValue);


    public native <R> Observable<R> last(PredicateWithSourceIndex<? super T> predicateWithIndex,
                                         ResultSelectorWithIndex<? super T, ? extends R> resultSelector, R defaultValue);

    public native <R> Observable<R> let(LetFunction<? super T, ? extends R> func);

    public native <R> Observable<R> map(Func1<? super T, ? extends R> mapper);

    public native <R> Observable<R> map(Projector<? super T, ? extends R> project);

    public native <R> Observable<R> mapTo(R value);

    public native Observable<T> max();

    public native Observable<T> max(Comparator<? super T> compare);

    public native static <T> Observable<T> merge(Observable<? extends T> v1);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Scheduler scheduler);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 int concurrent);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 int concurrent,
                                                 Scheduler scheduler);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 int concurrent);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 int concurrent,
                                                 Scheduler scheduler);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 int concurrent);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 int concurrent,
                                                 Scheduler scheduler);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5,
                                                 int concurrent);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5,
                                                 int concurrent,
                                                 Scheduler scheduler);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5,
                                                 Observable<? extends T> v6);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5,
                                                 Observable<? extends T> v6,
                                                 int concurrent);

    public native static <T> Observable<T> merge(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5,
                                                 Observable<? extends T> v6,
                                                 int concurrent,
                                                 Scheduler scheduler);

    public native Observable<T> mergeAll();

    public native Observable<T> mergeAll(int concurrent);

    public native <R> Observable<R> mergeMap(Func1<? super T, ? extends R> mapper);

    public native <R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector);

    public native <R> Observable<R> mergeMap(Func1<? super T, ? extends R> mapper, int concurrent);

    public native <R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector, int concurrent);

    public native <I, R> Observable<R> mergeMap(Func1<? super T, ? extends R> mapper,
                                                ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector,
                                                ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> mergeMap(Func1<? super T, ? extends R> mapper,
                                                ResultSelector<? super T, ? super I, ? extends R> resultSelector,
                                                int concurrent);

    public native <I, R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector,
                                                ResultSelector<? super T, ? super I, ? extends R> resultSelector,
                                                int concurrent);

    @JsMethod(name = "mergeMap")
    public native <R> Observable<R> flatMap(Func1<? super T, ? extends R> mapper);

    @JsMethod(name = "mergeMap")
    public native <R> Observable<R> flatMap(Projector<? super T, ? extends R> projector);

    @JsMethod(name = "mergeMap")
    public native <R> Observable<R> flatMap(Func1<? super T, ? extends R> mapper, int concurrent);

    @JsMethod(name = "mergeMap")
    public native <R> Observable<R> flatMap(Projector<? super T, ? extends R> projector, int concurrent);

    @JsMethod(name = "mergeMap")
    public native <I, R> Observable<R> flatMap(Projector<? super T, ? extends R> projector,
                                               ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    @JsMethod(name = "mergeMap")
    public native <I, R> Observable<R> flatMap(Func1<? super T, ? extends R> mapper,
                                               ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    @JsMethod(name = "mergeMap")
    public native <I, R> Observable<R> flatMap(Func1<? super T, ? extends R> mapper,
                                               ResultSelector<? super T, ? super I, ? extends R> resultSelector,
                                               int concurrent);

    @JsMethod(name = "mergeMap")
    public native <I, R> Observable<R> flatMap(Projector<? super T, ? extends R> projector,
                                               ResultSelector<? super T, ? super I, ? extends R> resultSelector,
                                               int concurrent);

    public native <R> Observable<R> mergeMapTo(Observable<? extends R> observable);

    public native <R> Observable<R> mergeMapTo(Observable<? extends R> observable, int concurrent);

    public native <I, R> Observable<R> mergeMapTo(Observable<? extends I> innerObservable,
                                                  ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> mergeMapTo(Observable<? extends I> innerObservable,
                                                  ResultSelector<? super T, ? super I, ? extends R> resultSelector,
                                                  int concurrent);

    @JsMethod(name = "mergeMapTo")
    public native <R> Observable<R> flatMapTo(Observable<? extends R> observable);

    @JsMethod(name = "mergeMapTo")
    public native <R> Observable<R> flatMapTo(Observable<? extends R> observable, int concurrent);

    @JsMethod(name = "mergeMapTo")
    public native <I, R> Observable<R> flatMapTo(Observable<? extends I> innerObservable,
                                                 ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    @JsMethod(name = "mergeMapTo")
    public native <I, R> Observable<R> flatMapTo(Observable<? extends I> innerObservable,
                                                 ResultSelector<? super T, ? super I, ? extends R> resultSelector,
                                                 int concurrent);

    public native <R> Observable<R> mergeScan(Scanner<R, ? super T> scanner, R seed);

    public native <R> Observable<R> mergeScan(Scanner<R, ? super T> scanner, R seed, int concurrent);

    public native Observable<T> min();

    public native Observable<T> min(Comparator<? super T> compare);

    public native ConnectableObservable<T> multicast(Subject<? extends T> subject);

    public native ConnectableObservable<T> multicast(Factory<Subject<? extends T>> subjectFactory);

    public native <R> ConnectableObservable<R> multicast(Subject<? extends T> subject,
                                                         OperatorFunction<? super T, ? extends R> selector);

    public native <R> ConnectableObservable<R> multicast(Factory<Subject<? extends T>> subjectFactory,
                                                         OperatorFunction<? super T, ? extends R> selector);

    public native static <T> Observable<T> never();

    public native Observable<T> observeOn(Scheduler scheduler);

    public native Observable<T> observeOn(Scheduler scheduler, int delay);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1,
                                                  Observable<? extends T> v2);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4,
                                                  Observable<? extends T> v5);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1,
                                                  Observable<? extends T> v2,
                                                  Observable<? extends T> v3,
                                                  Observable<? extends T> v4,
                                                  Observable<? extends T> v5,
                                                  Observable<? extends T> v6);

    public native Observable<T> onErrorResumeNext(Observable<? extends T>... vs);

    public native Observable<T> onErrorResumeNext(Iterable<Observable<T>> vs);

    public native static Observable<Object[]> pairs(Object o);

    public native Observable<T[]> pairwise();

    public native Observable<T>[] partition(Predicate<? super T> predicate);

    public native Observable<T>[] partition(PredicateWithIndex<? super T> predicate);


    public native Observable<T> pipe();

    public native <A> Observable<A> pipe(OperatorFunction<T, A> op1);

    public native <A, B> Observable<B> pipe(OperatorFunction<T, A> op1,
                                            OperatorFunction<A, B> op2);

    public native <A, B, C> Observable<C> pipe(OperatorFunction<T, A> op1,
                                               OperatorFunction<A, B> op2,
                                               OperatorFunction<B, C> op3);

    public native <A, B, C, D> Observable<D> pipe(OperatorFunction<T, A> op1,
                                                  OperatorFunction<A, B> op2,
                                                  OperatorFunction<B, C> op3,
                                                  OperatorFunction<C, D> op4);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E, F> Observable<F> pipe(OperatorFunction<T, A> op1,
                                                        OperatorFunction<A, B> op2,
                                                        OperatorFunction<B, C> op3,
                                                        OperatorFunction<C, D> op4,
                                                        OperatorFunction<D, E> op5,
                                                        OperatorFunction<E, F> op6);

    public native <A, B, C, D, E, F, G> Observable<G> pipe(OperatorFunction<T, A> op1,
                                                           OperatorFunction<A, B> op2,
                                                           OperatorFunction<B, C> op3,
                                                           OperatorFunction<C, D> op4,
                                                           OperatorFunction<D, E> op5,
                                                           OperatorFunction<E, F> op6,
                                                           OperatorFunction<F, G> op7);

    public native <A, B, C, D, E, F, G, H> Observable<H> pipe(OperatorFunction<T, A> op1,
                                                              OperatorFunction<A, B> op2,
                                                              OperatorFunction<B, C> op3,
                                                              OperatorFunction<C, D> op4,
                                                              OperatorFunction<D, E> op5,
                                                              OperatorFunction<E, F> op6,
                                                              OperatorFunction<F, G> op7,
                                                              OperatorFunction<G, H> op8);

    public native <A, B, C, D, E, F, G, H, I> Observable<I> pipe(OperatorFunction<T, A> op1,
                                                                 OperatorFunction<A, B> op2,
                                                                 OperatorFunction<B, C> op3,
                                                                 OperatorFunction<C, D> op4,
                                                                 OperatorFunction<D, E> op5,
                                                                 OperatorFunction<E, F> op6,
                                                                 OperatorFunction<F, G> op7,
                                                                 OperatorFunction<G, H> op8,
                                                                 OperatorFunction<H, I> op9);

    public native <A> Observable<A> pipe(UnaryFunction<T, A> op1);

    public native <A, B> Observable<B> pipe(UnaryFunction<T, A> op1,
                                            UnaryFunction<A, B> op2);

    public native <A, B, C> Observable<C> pipe(UnaryFunction<T, A> op1,
                                               UnaryFunction<A, B> op2,
                                               UnaryFunction<B, C> op3);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  UnaryFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  UnaryFunction<C, D> op4);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E, F> Observable<F> pipe(UnaryFunction<T, A> op1,
                                                        UnaryFunction<A, B> op2,
                                                        UnaryFunction<B, C> op3,
                                                        UnaryFunction<C, D> op4,
                                                        UnaryFunction<D, E> op5,
                                                        UnaryFunction<E, F> op6);

    public native <A, B, C, D, E, F, G> Observable<G> pipe(UnaryFunction<T, A> op1,
                                                           UnaryFunction<A, B> op2,
                                                           UnaryFunction<B, C> op3,
                                                           UnaryFunction<C, D> op4,
                                                           UnaryFunction<D, E> op5,
                                                           UnaryFunction<E, F> op6,
                                                           UnaryFunction<F, G> op7);

    public native <A, B, C, D, E, F, G, H> Observable<H> pipe(UnaryFunction<T, A> op1,
                                                              UnaryFunction<A, B> op2,
                                                              UnaryFunction<B, C> op3,
                                                              UnaryFunction<C, D> op4,
                                                              UnaryFunction<D, E> op5,
                                                              UnaryFunction<E, F> op6,
                                                              UnaryFunction<F, G> op7,
                                                              UnaryFunction<G, H> op8);

    public native <A, B, C, D, E, F, G, H, I> Observable<I> pipe(UnaryFunction<T, A> op1,
                                                                 UnaryFunction<A, B> op2,
                                                                 UnaryFunction<B, C> op3,
                                                                 UnaryFunction<C, D> op4,
                                                                 UnaryFunction<D, E> op5,
                                                                 UnaryFunction<E, F> op6,
                                                                 UnaryFunction<F, G> op7,
                                                                 UnaryFunction<G, H> op8,
                                                                 UnaryFunction<H, I> op9);

    public native <A, B> Observable<B> pipe(UnaryFunction<T, A> op1,
                                            OperatorFunction<A, B> op2);

    public native <A, B> Observable<B> pipe(OperatorFunction<T, A> op1,
                                            UnaryFunction<A, B> op2);

    public native <A, B, C> Observable<C> pipe(UnaryFunction<T, A> op1,
                                               OperatorFunction<A, B> op2,
                                               OperatorFunction<B, C> op3);

    public native <A, B, C> Observable<C> pipe(UnaryFunction<T, A> op1,
                                               UnaryFunction<A, B> op2,
                                               OperatorFunction<B, C> op3);

    public native <A, B, C> Observable<C> pipe(OperatorFunction<T, A> op1,
                                               UnaryFunction<A, B> op2,
                                               UnaryFunction<B, C> op3);

    public native <A, B, C> Observable<C> pipe(OperatorFunction<T, A> op1,
                                               OperatorFunction<A, B> op2,
                                               UnaryFunction<B, C> op3);

    public native <A, B, C> Observable<C> pipe(OperatorFunction<T, A> op1,
                                               UnaryFunction<A, B> op2,
                                               OperatorFunction<B, C> op3);

    public native <A, B, C> Observable<C> pipe(UnaryFunction<T, A> op1,
                                               OperatorFunction<A, B> op2,
                                               UnaryFunction<B, C> op3);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  OperatorFunction<A, B> op2,
                                                  OperatorFunction<B, C> op3,
                                                  OperatorFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  UnaryFunction<A, B> op2,
                                                  OperatorFunction<B, C> op3,
                                                  OperatorFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  UnaryFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  OperatorFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(OperatorFunction<T, A> op1,
                                                  UnaryFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  OperatorFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(OperatorFunction<T, A> op1,
                                                  OperatorFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  OperatorFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(OperatorFunction<T, A> op1,
                                                  OperatorFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  UnaryFunction<C, D> op4);


    public native <A, B, C, D> Observable<D> pipe(OperatorFunction<T, A> op1,
                                                  UnaryFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  UnaryFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  OperatorFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  UnaryFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  UnaryFunction<A, B> op2,
                                                  OperatorFunction<B, C> op3,
                                                  UnaryFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  OperatorFunction<A, B> op2,
                                                  OperatorFunction<B, C> op3,
                                                  UnaryFunction<C, D> op4);

    public native <A, B, C, D> Observable<D> pipe(UnaryFunction<T, A> op1,
                                                  OperatorFunction<A, B> op2,
                                                  UnaryFunction<B, C> op3,
                                                  OperatorFunction<C, D> op4);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     UnaryFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     UnaryFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     UnaryFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(UnaryFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     OperatorFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native <A, B, C, D, E> Observable<E> pipe(OperatorFunction<T, A> op1,
                                                     OperatorFunction<A, B> op2,
                                                     UnaryFunction<B, C> op3,
                                                     OperatorFunction<C, D> op4,
                                                     OperatorFunction<D, E> op5);

    public native Observable<T> pipe(OperatorFunction<T, T>... operations);

    public native <R> Observable<R> pluck(String... properties);

    public native ConnectableObservable<T> publish();

    public native <R> ConnectableObservable<R> publish(OperatorFunction<? super T, ? extends R> operatorFunction);

    public native <R extends T> ConnectableObservable<T> publishBehavior(R value);

    public native ConnectableObservable<T> publishLast();

    public native ConnectableObservable<T> publishReplay();

    public native ConnectableObservable<T> publishReplay(int bufferSize);

    public native ConnectableObservable<T> publishReplay(int bufferSize, int windowTime);

    public native ConnectableObservable<T> publishReplay(int bufferSize, int windowTime, Scheduler scheduler);

    public native <R> ConnectableObservable<R> publishReplay(int bufferSize,
                                                             int windowTime,
                                                             OperatorFunction<? super T, ? extends R> selector,
                                                             Scheduler scheduler);

    @SafeVarargs
    public native static <T> Observable<T> race(Observable<? extends T>... observables);

    public native static <T> Observable<T> race(Iterable<Observable<T>> observables);

    public native static Observable<Integer> range(int start, int count);

    public native static Observable<Integer> range(int start, int count, Scheduler scheduler);

    public native Observable<T> reduce(Accumulator<T> accumulator);

    public native Observable<T> reduce(Accumulator<T> accumulator, T seed);

    public native Observable<T> reduce(AccumulatorWithIndex<T> accumulator);

    public native Observable<T> reduce(AccumulatorWithIndex<T> accumulator, T seed);

    public native <R> Observable<R> reduce(TransformingAccumulator<T, R> accumulator);

    public native <R> Observable<R> reduce(TransformingAccumulator<T, R> accumulator, R seed);

    public native <R> Observable<R> reduce(TransformingAccumulatorWithIndex<T, R> accumulator);

    public native <R> Observable<R> reduce(TransformingAccumulatorWithIndex<T, R> accumulator, R seed);

    @JsMethod(name = "reduce")
    public native Observable<T[]> reduceArray(Accumulator<T[]> accumulator);

    @JsMethod(name = "reduce")
    public native Observable<T[]> reduceArray(Accumulator<T[]> accumulator, T[] seed);

    @JsMethod(name = "reduce")
    public native Observable<T[]> reduceArray(AccumulatorWithIndex<T[]> accumulator);

    @JsMethod(name = "reduce")
    public native Observable<T[]> reduceArray(AccumulatorWithIndex<T[]> accumulator, T[] seed);

    public native Observable<T> repeat();

    public native Observable<T> repeat(int count);

    public native Observable<T> repeatWhen(Func1<Observable<?>, Observable<?>> notifier);

    public native Observable<T> retry();

    public native Observable<T> retry(int count);

    public native Observable<T> retryWhen(Func1<Observable<?>, Observable<?>> notifier);

    public native Observable<T> sample(Observable notifier);

    public native Observable<T> sampleTime(int period);

    public native Observable<T> sampleTime(int period, Scheduler scheduler);

    public native Observable<T> scan(Accumulator<T> accumulator);

    public native Observable<T> scan(Accumulator<T> accumulator, T seed);

    public native Observable<T> scan(AccumulatorWithIndex<T> accumulator);

    public native Observable<T> scan(AccumulatorWithIndex<T> accumulator, T seed);

    public native <R> Observable<R> scan(TransformingAccumulator<T, R> accumulator, R seed);

    public native <R> Observable<R> scan(TransformingAccumulatorWithIndex<T, R> accumulator, R seed);

    @JsMethod(name = "scan")
    public native Observable<T[]> scanArray(Accumulator<T[]> accumulator);

    @JsMethod(name = "scan")
    public native Observable<T[]> scanArray(Accumulator<T[]> accumulator, T[] seed);

    @JsMethod(name = "scan")
    public native Observable<T[]> scanArray(AccumulatorWithIndex<T[]> accumulator);

    @JsMethod(name = "scan")
    public native Observable<T[]> scanArray(AccumulatorWithIndex<T[]> accumulator, T[] seed);

    public native Observable<Boolean> sequenceEqual(Observable<? extends T> compareTo, Predicate2<? super T> predicate);

    public native Observable<T> share();

    public native Observable<T> shareReplay(int bufferSize);

    public native Observable<T> shareReplay(int bufferSize, int windowTime);

    public native Observable<T> shareReplay(int bufferSize, int windowTime, Scheduler scheduler);

    public native Observable<T> single(Predicate<T> predicate);

    public native Observable<T> single(PredicateWithIndex<T> predicate);

    public native Observable<T> single(PredicateWithSourceIndex<T> predicate);

    public native Observable<T> skip(int count);

    public native Observable<T> skipLast(int count);

    public native Observable<T> skipUntil(Observable<?> notifier);

    public native Observable<T> skipWhile(Predicate<T> predicate);

    public native Observable<T> skipWhile(PredicateWithIndex<T> predicateWithIndex);

    public native Observable<T> startWith(T v1);

    public native Observable<T> startWith(T v1, Scheduler scheduler);

    public native Observable<T> startWith(T v1, T v2);

    public native Observable<T> startWith(T v1, T v2, Scheduler scheduler);

    public native Observable<T> startWith(T v1, T v2, T v3);

    public native Observable<T> startWith(T v1, T v2, T v3, Scheduler scheduler);

    public native Observable<T> startWith(T v1, T v2, T v3, T v4);

    public native Observable<T> startWith(T v1, T v2, T v3, T v4, Scheduler scheduler);

    public native Observable<T> startWith(T v1, T v2, T v3, T v4, T v5);

    public native Observable<T> startWith(T v1, T v2, T v3, T v4, T v5, Scheduler scheduler);

    public native Observable<T> startWith(T v1, T v2, T v3, T v4, T v5, T v6);

    public native Observable<T> startWith(T v1, T v2, T v3, T v4, T v5, T v6, Scheduler scheduler);

    public native Subscription subscribe(Action1<? super T> onNext);

    public native Subscription subscribe(Action1<? super T> onNext, Action1<?> onError);

    public native Subscription subscribe(Action1<? super T> onNext, Action1<?> onError, Action0 onCompleted);

    public native Subscription subscribe(Observer<? super T> observer);

    public native Observable<T> subscribeOn(Scheduler scheduler);

    public native Observable<T> subscribeOn(Scheduler scheduler, int delay);

    @JsMethod(name = "switch")
    public native Observable<T> _switch();

    public native <R> Observable<R> switchMap(Func1<? super T, ? extends R> mapper);

    public native <R> Observable<R> switchMap(Projector<? super T, ? extends R> project);

    public native <I, R> Observable<R> switchMap(Func1<? super T, ? extends I> mapper,
                                                 ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> switchMap(Projector<? super T, ? extends I> project,
                                                 ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> switchMapTo(Observable<? extends I> observable,
                                                   ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native Observable<T> take(int count);

    public native Observable<T> takeLast(int count);

    public native Observable<T> takeUntil(Observable<?> notifier);

    public native Observable<T> takeWhile(Predicate<T> predicate);

    public native Observable<T> takeWhile(PredicateWithIndex<T> predicate);

    public native Observable<T> throttle(Func1<? super T, Observable<?>> durationSelector);

    public native Observable<T> throttle(Func1<? super T, Observable<?>> durationSelector,
                                         ThrottleConfig throttleConfig);

    public native Observable<T> throttleTime(int duration);

    public native Observable<T> throttleTime(int duration, Scheduler scheduler);

    public native Observable<T> throttleTime(int duration, Scheduler scheduler, ThrottleConfig throttleConfig);

    public native Observable<TimeInterval<T>> timeInterval();

    public native Observable<TimeInterval<T>> timeInterval(Scheduler scheduler);

    public native Observable<T> timeout(int due);

    public native Observable<T> timeout(int due, Scheduler scheduler);

    public native Observable<T> timeoutWith(int due, Observable<? extends T> withObservable);

    public native Observable<T> timeoutWith(int due, Observable<? extends T> withObservable, Scheduler scheduler);

    public native static Observable<Integer> timer(int initialDelay);

    public native static Observable<Integer> timer(int initialDelay, int period);

    public native static Observable<Integer> timer(int initialDelay, int period, Scheduler scheduler);

    public native Observable<Timestamp<T>> timestamp();

    public native Observable<Timestamp<T>> timestamp(Scheduler scheduler);

    public native Observable<T[]> toArray();

    public native static <T> Observable<T> using(Func0<AnonymousSubscription> resourceFactory,
                                                 ObservableFactoryFromResource<? extends T> observableFactory);

    public native Observable<Observable<T>> window(Observable<?> windowBoundaries);

    public native Observable<Observable<T>> windowCount(int windowSize);

    public native Observable<Observable<T>> windowCount(int windowSize, int startWindowEvery);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, Scheduler scheduler);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, Scheduler scheduler);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, int maxWindowSize);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, int maxWindowSize, Scheduler scheduler);

    public native <O> Observable<Observable<T>> windowToggle(Observable<O> openings, Func1<O, Observable<?>> closingSelector);

    public native Observable<Observable<T>> windowWhen(Func0<Observable<?>> notifier);

    public native <R> Observable<R> withLatestFrom(Func1<? super T, ? extends R> combiner);

    public native <T2, R> Observable<R> withLatestFrom(Observable<? extends T2> v2,
                                                       Func2<? super T, ? super T2, ? extends R> combiner);

    public native <T2, T3, R> Observable<R> withLatestFrom(Observable<? extends T2> v2,
                                                           Observable<? extends T2> v3,
                                                           Func3<? super T, ? super T2, ? super T3, ? extends R> combiner);

    public native <T2, T3, T4, R> Observable<R> withLatestFrom(Observable<? extends T2> v2,
                                                               Observable<? extends T3> v3,
                                                               Observable<? extends T4> v4,
                                                               Func4<? super T, ? super T2, ? super T3, ? super T4, ? extends R> combiner);

    public native <T2, T3, T4, T5, R> Observable<R> withLatestFrom(Observable<? extends T2> v2,
                                                                   Observable<? extends T3> v3,
                                                                   Observable<? extends T5> v4,
                                                                   Observable<? extends T4> v5,
                                                                   Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combiner);

    public native <T2, T3, T4, T5, T6, R> Observable<R> withLatestFrom(Observable<? extends T2> v2,
                                                                       Observable<? extends T3> v3,
                                                                       Observable<? extends T4> v4,
                                                                       Observable<? extends T5> v5,
                                                                       Observable<? extends T6> v6,
                                                                       Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T6, ? extends R> combiner);

    public native <R> Observable<R> withLatestFrom(Observable<? extends T>... observables);

    public native <R> Observable<R> withLatestFrom(Observable<? extends T>[] observables,
                                                   Func1<T[], ? extends R> combiner);

    public native <R> Observable<R> withLatestFrom(Iterable<Observable<T>> observables);

    public native <R> Observable<R> withLatestFrom(Iterable<Observable<T>> observables,
                                                   Func1<T[], ? extends R> combiner);


    public native static <T, T2, R> Observable<R> zip(Observable<? extends T> v1,
                                                      Func1<? super T, ? extends R> mapper);

    public native static <T, T2, R> Observable<R> zip(Observable<? extends T> v1,
                                                      Observable<? extends T2> v2,
                                                      Func2<? super T, ? super T2, ? extends R> mapper);

    public native static <T, T2, T3, R> Observable<R> zip(Observable<? extends T> v1,
                                                          Observable<? extends T2> v2,
                                                          Observable<? extends T3> v3,
                                                          Func3<? super T, ? super T2, ? super T3, ? extends R> mapper);

    public native static <T, T2, T3, T4, R> Observable<R> zip(Observable<? extends T> v1,
                                                              Observable<? extends T2> v2,
                                                              Observable<? extends T3> v3,
                                                              Observable<? extends T4> v4,
                                                              Func4<? super T, ? super T2, ? super T3, ? super T4, ? extends R> mapper);

    public native static <T, T2, T3, T4, T5, R> Observable<R> zip(Observable<? extends T> v1,
                                                                  Observable<? extends T2> v2,
                                                                  Observable<? extends T3> v3,
                                                                  Observable<? extends T4> v4,
                                                                  Observable<? extends T5> v5,
                                                                  Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> mapper);

    public native static <T, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<? extends T> v1,
                                                                      Observable<? extends T2> v2,
                                                                      Observable<? extends T3> v3,
                                                                      Observable<? extends T4> v4,
                                                                      Observable<? extends T5> v5,
                                                                      Observable<? extends T6> v6,
                                                                      Func6<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> mapper);

    public native static <T> Observable<T[]> zip(Observable<? extends T> v1,
                                                 Observable<? extends T> v2);

    public native static <T> Observable<T[]> zip(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3);

    public native static <T> Observable<T[]> zip(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4);

    public native static <T> Observable<T[]> zip(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5);

    public native static <T> Observable<T[]> zip(Observable<? extends T> v1,
                                                 Observable<? extends T> v2,
                                                 Observable<? extends T> v3,
                                                 Observable<? extends T> v4,
                                                 Observable<? extends T> v5,
                                                 Observable<? extends T> v6);

    @SafeVarargs
    public native static <T> Observable<T[]> zip(Observable<? extends T>... values);

    public native static <T> Observable<T[]> zip(Iterable<Observable<T>> values);

    public native static <T, R> Observable<R> zip(Observable<? extends T>[] values,
                                                  Func1<T[], ? extends R> mapper);

    public native static <T, R> Observable<R> zip(Iterable<Observable<T>> values,
                                                  Func1<T[], ? extends R> mapper);

    public native Observable<T> zipAll();

    public native <R> Observable<R> zipAll(Func1<T[], ? extends R> mapper);

}
