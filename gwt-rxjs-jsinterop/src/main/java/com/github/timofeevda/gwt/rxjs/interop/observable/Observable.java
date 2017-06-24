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
package com.github.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import com.github.timofeevda.gwt.rxjs.interop.subject.Subject;
import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;
import com.github.timofeevda.gwt.rxjs.interop.functions.Action1;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func1;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func2;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func3;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func4;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func5;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func6;
import com.github.timofeevda.gwt.rxjs.interop.functions.FuncN;
import com.github.timofeevda.gwt.rxjs.interop.functions.Producer;
import com.github.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;
import com.github.timofeevda.gwt.rxjs.interop.functions.ProjectWithArray;
import com.google.gwt.dom.client.Element;

/**
 * @author dtimofeev since 20.12.2016.
 * @param <T>
 */
@JsType(namespace = "Rx", isNative = true)
@SuppressWarnings("unused")
public class Observable<T> {

    @SafeVarargs
    public native static <R> Observable<R> of(R... args);

    public native static <R> Observable<R> from(R[] args);

    public native static <R> Observable<R> fromEvent(Element target, String eventName);

    public native static <R> Observable<R> fromEvent(Element target, String eventName, boolean useCapture);

    public native static <R> Observable<R> create(OnSubscribe<? extends R> onSubscribe);

    public native Observable<T> audit(Observable<?> durationSelector);

    public native Observable<T> auditTime(int duration);

    public native Observable<T[]> buffer(Observable closingNotifier);
    
    public native Observable<T[]> bufferCount(int bufferSize);

    public native Observable<T[]> bufferCount(int bufferSize, int startBufferEvery);

    public native Observable<T[]> bufferTime(int bufferTimeSpan);

    public native Observable<T[]> bufferTime(int bufferTimeSpan, int bufferCreationInterval);

    public native Observable<T[]> bufferTime(int bufferTimeSpan, int bufferCreationInterval, int maxBufferSize);

    public native Observable<T[]> bufferToggle(Observable openings, Observable closingsSelector);

    public native Observable<T[]> bufferWhen(Observable closingSelector);

    @JsMethod(name = "catch")
    public native <R> Observable<R> _catch(Func2<?, Observable<? super T>, Observable<? extends R>> catcher);

    public native Observable<T> combineAll();

    public native <R> Observable<R> combineAll(Func1<T[], ? extends R> mapper);

    public native static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> v1, Observable<? extends T2> v2,
            Func2<? super T1, ? super T2, ? extends R> combineFunction);

    public native static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3,
            Func3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction);

    public native static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4,
            Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction);

    public native static <T, R> Observable<R> combineLatest(Iterable<? extends Observable<? extends T>> observables, FuncN<? extends R> combineFunction);

    public native static <T> Observable<T> combineLatest(Observable<? extends T>[] observables);

    public native Observable<T> concat(Observable<? extends T> v1);

    public native Observable<T> concatAll();

    public native static <T> Observable<T> concat(Observable<? extends T> v1, Observable<? extends T> v2);

    public native static <T> Observable<T> concat(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3);

    public native static <T> Observable<T> concat(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4);

    public native static <T> Observable<T> concat(Iterable<? extends Observable<? extends T>> observables);

    public native static <T> Observable<T> concat(Observable<? extends T>[] observables);

    public native <R> Observable<R> concatMap(Projector<? super T, R> projector);

    public native <I, R> Observable<T> concatMap(Projector<? super T, I> projector, ResultSelector<? super T, ? super I, R> resultSelector);

    public native <I, R> Observable<R> concatMapTo(Observable<I> observable, ResultSelector<? super T, ? super I, R> resultSelector);

    public native Observable<Integer> count();

    public native Observable<Integer> count(Predicate<? super T> predicate);

    public native Observable<Integer> count(IndexedSourcePredicate<? super T> predicate);

    public native Observable<T> debounce(Observable<Integer> durationSelector);

    public native Observable<T> debounceTime(int time);

    public native <R> Observable<R> defaultIfEmpty(R defaultValue);

    public native static <T> Observable<T> defer(Producer<Observable<T>> producer);

    public native Observable<T> delay(int initialDelay);

    public native Observable<T> delayWhen(Func1<? super T, Observable<?>> delayDurationSelector);

    public native Observable<T> delayWhen(Func1<? super T, Observable<?>> delayDurationSelector, Observable<?> subscriptionDelay);

    public native Observable<T> distinct();

    public native <K> Observable<T> distinct(KeySelector<? super T, K> keySelector);

    public native <K> Observable<T> distinct(KeySelector<? super T, K> keySelector, Observable<?> flushes);

    public native Observable<T> distinctUntilChanged();

    public native <K> Observable<T> distinctUntilChanged(KeyComparator<? super T> keyComparator);

    public native <K> Observable<T> distinctUntilChanged(KeyComparator<? super T> keyComparator, KeySelector<? super T, K> keySelector);

    @JsMethod(name = "do")
    public native Observable<T> _do(Action1<T> onNext);

    @JsMethod(name = "do")
    public native Observable<T> _do(Action1<T> onNext, Action1<?> onError, Action0 onCompleted);

    @JsMethod(name = "do")
    public native Observable<T> _do(Observer<? super T> observer);

    public native static <T> Observable<T> empty();

    public native Observable<T> elementAt(int index);

    public native <R extends T> Observable<T> elementAt(int index, R defaultValue);

    public native Observable<T> every(Predicate<? super T> predicate);

    public native Observable<Boolean> every(IndexedSourcePredicate<T> predicate);

    @JsMethod(name = "throw")
    public native static Observable _throw(Object error);

    @JsMethod(name = "throw")
    public native static Observable _throw(Object error, Scheduler scheduler);

    public native Observable<T> exhaust();

    public native <R> Observable<T> exhaustMap(Projector<? super T, R> projector);

    public native <I, R> Observable<T> exhaustMap(Projector<? super T, I> projector, ResultSelector<? super T, ? super I, R> resultSelector);

    public native <R> Observable<R> expand(Projector<? super T, R> projector);

    public native <R> Observable<R> expand(Projector<? super T, R> projector, int concurrent);

    public native <R> Observable<R> expand(Projector<? super T, R> projector, int concurrent, Scheduler scheduler);

    public native Observable<T> filter(Predicate<? super T> predicate);

    public native Observable<T> filter(IndexedPredicate<? super T> indexedPredicate);

    @JsMethod(name = "finally")
    public native Observable<T> _finally(Action0 action);

    public native Observable<T> find(Predicate<? super T> predicate);

    public native Observable<T> find(IndexedPredicate<? super T> indexedPredicate);

    public native Observable<Integer> findIndex(IndexedSourcePredicate<? super T> predicate);

    public native Observable<T> first(Predicate<? super T> predicate);

    public native Observable<T> first(IndexedPredicate<? super T> indexedPredicate);

    public native <I, R> Observable<R> first(Predicate<? super T> predicate, IndexedResultSelector<? super T, R> resultSelector);

    public native <I, R> Observable<R> first(IndexedPredicate<? super T> indexedPredicate, IndexedResultSelector<? super T, R> resultSelector);

    public native <I, R> Observable<R> first(Predicate<? super T> predicate, IndexedResultSelector<? super T, R> resultSelector, R defaultValue);

    public native <I, R> Observable<R> first(IndexedPredicate<? super T> indexedPredicate, IndexedResultSelector<? super T, R> resultSelector, R defaultValue);

    public native <K> Observable<GroupedObservable<K, T>> groupBy(KeySelector<? super T, K> keySelector);

    public native <K, R> Observable<GroupedObservable<K, R>> groupBy(KeySelector<? super T, K> keySelector, ElementSelector<? super T, R> elementSelector);

    public native Observable<T> ignoreElements();

    public native Observable<Boolean> isEmpty();

    @JsMethod(name = "if")
    public native static Observable<Boolean> _if(Producer<Boolean> condition);

    @JsMethod(name = "if")
    public native static <T> Observable<Boolean> _if(Producer<Boolean> condition, Observable<T> thenSource);

    @JsMethod(name = "if")
    public native static <T> Observable<Boolean> _if(Producer<Boolean> condition, Observable<T> thenSource, Observable<T> elseSource);

    public native static Observable<Integer> interval(int period);

    public native static Observable<Integer> interval(int period, Scheduler scheduler);

    public native Observable<T> last(Predicate<? super T> predicate);

    public native Observable<T> last(IndexedPredicate<? super T> indexedPredicate);

    public native <R> Observable<R> last(Predicate<? super T> predicate, IndexedResultSelector<? super T, ? extends R> resultSelector);

    public native <R> Observable<R> last(IndexedPredicate<? super T> indexedPredicate, IndexedResultSelector<? super T, ? extends R> resultSelector);

    public native <R> Observable<R> last(Predicate<? super T> predicate, IndexedResultSelector<? super T, ? extends  R> resultSelector, R defaultValue);

    public native <R> Observable<R> last(IndexedPredicate<? super T> indexedPredicate, IndexedResultSelector<? super T, ? extends R> resultSelector, R defaultValue);

    public native <R> Observable<R> let(Func1<Observable<? super T>, Observable<R>> selector);

    public native <R> Observable<R> map(Func1<? super T, ? extends R> mapper);

    public native <R> Observable<R> mapTo(R value);

    public native Observable<T> max();

    public native Observable<T> max(Comparator<? super T> comparator);

    public native static <T> Observable<T> merge(Observable<T> first, Observable<T> second);

    public native Observable<T> mergeAll();

    public native Observable<T> mergeAll(int concurrent);

    public native <R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector);

    public native <R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector, int concurrent);

    public native <I, R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector, ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> mergeMap(Projector<? super T, ? extends R> projector, ResultSelector<? super T, ? super I, ? extends R> resultSelector, int concurrent);

    public native <R> Observable<R> mergeMapTo(Observable<? extends R> innerObservable);

    public native <R> Observable<R> mergeMapTo(Observable<? extends R> innerObservable, int concurrent);

    public native <I, R> Observable<R> mergeMapTo(Observable<? extends R> innerObservable, ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> mergeMapTo(Observable<? extends R> innerObservable, ResultSelector<? super T, ? super I, ? extends R> resultSelector, int concurrent);

    public native <R> Observable<R> mergeScan(Scanner<? extends R, ? super T> scanner, R seed);

    public native <R> Observable<R> mergeScan(Scanner<? extends R, ? super T> scanner, R seed, int concurrent);

    public native Observable<T> min();

    public native Observable<T> min(Comparator<? super T> comparator);

    public native ConnectableObservable<T> multicast(Subject<? extends T> subject);

    public native ConnectableObservable<T> multicast(Factory<Subject<? extends T>> subjectFactory);

    public native ConnectableObservable<T> multicast(Subject<? extends T> subject, Selector<? super T> selector);

    public native ConnectableObservable<T> multicast(Factory<Subject<? extends T>> subjectFactory, Selector<? extends T> selector);

    public native static <T> Observable<T> multicast(SubjectFactory<? extends T> subjectFactory);

    public native static <T> Observable<T> multicast(SubjectFactory<? extends T> subjectFactory, Selector<? extends T> selector);

    public native static <T> Observable<T> never();

    public native Observable<T> observeOn(Scheduler scheduler);

    public native Observable<T> observeOn(Scheduler scheduler, int delay);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> inputObservable);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4, Observable<? extends T> v5);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4, Observable<? extends T> v5, Observable<? extends T> v6);

    public native static Observable<Object[]> pairs(Object o);

    public native Observable<T[]> pairwise();

    public native Observable<T>[] partition(Func1<? super T, Boolean> predicate);

    public native ConnectableObservable<T> publish();

    public native ConnectableObservable<T> publish(Selector<? super T> selector);

    public native <R extends T> ConnectableObservable<T> publishBehavior(R value);

    public native ConnectableObservable<T> publishLast();

    public native ConnectableObservable<T> publishReplay();

    public native ConnectableObservable<T> publishReplay(int bufferSize);

    public native ConnectableObservable<T> publishReplay(int bufferSize, int windowTime);

    public native ConnectableObservable<T> publishReplay(int bufferSize, int windowTime, Scheduler scheduler);

    public native static <T> Observable<T> race(Observable<? extends T> v1, Observable<? extends T> v2);

    public native static Observable<Integer> range(int start, int count);

    public native static Observable<Integer> range(int start, int count, Scheduler scheduler);

    public native Observable<T> reduce(Accumulator<T> accumulator);

    public native <R> Observable<R> reduce(TransformingAccumulator<R, T> accumulator);

    public native <R> Observable<R> reduce(TransformingAccumulator<R, T> accumulator, R seed);

    public native Observable<T> reduce(Accumulator<T> accumulator, T seed);

    public native Observable<T[]> reduceArray(Accumulator<T[]> accumulator);

    public native Observable<T[]> reduceArray(Accumulator<T[]> accumulator, T[] seed);

    public native Observable<T> repeat();

    public native Observable<T> repeat(int count);

    public native Observable<T> repeatWhen(Observable closingNotifier);

    public native Observable<T> retry();

    public native Observable<T> retry(int count);

    public native Observable<T> retryWhen(Observable closingNotifier);

    public native Observable<T> sample(Observable notifier);

    public native Observable<T> sampleTime(int period);

    public native Observable<T> sampleTime(int period, Scheduler scheduler);

    public native Observable<T> scan(Accumulator<T> accumulator);

    public native <R> Observable<R> scan(TransformingAccumulator<R, T> accumulator);

    public native <R> Observable<R> scan(TransformingAccumulator<R, T> accumulator, R seed);

    public native Observable<T> scan(Accumulator<T> accumulator, T seed);

    public native Observable<T[]> scanArray(Accumulator<T[]> accumulator);

    public native Observable<T[]> scanArray(Accumulator<T[]> accumulator, T[] seed);

    public native Observable<Boolean> sequenceEqual(Observable<T> compareTo, Func2<T, T, Boolean> comparer);

    public native Observable<T> share();

    public native Observable<T> single(IndexedSourcePredicate<T> predicate);

    public native Observable<T> skip(int count);

    public native Observable<T> skipUntil(Observable notifier);

    public native Observable<T> skipWhile(Predicate<T> predicate);

    public native Observable<T> skipWhile(IndexedPredicate<T> indexedPredicate);
    
    public native Observable<T> skipLast(int count);

    public native Observable<T> startWith(T v1);

    public native Observable<T> startWith(T v1, Scheduler scheduler);

    public native Observable<T> startWith(T v1, T v2);

    public native Observable<T> startWith(T v1, T v2, Scheduler scheduler);

    public native Subscription subscribe(Action1<? super T> onNext);

    public native Subscription subscribe(Action1<? super T> onNext, Action1<?> onError);

    public native Subscription subscribe(Action1<? super T> onNext, Action1<?> onError, Action0 onCompleted);

    public native Subscription subscribe(Observer<? super T> observer);

    public native Observable<T> subscribeOn(Scheduler scheduler);

    public native Observable<T> subscribeOn(Scheduler scheduler, int delay);

    @JsMethod(name = "switch")
    public native Observable<T> _switch();

    public native <R> Observable<R> switchMap(Projector<? super T, ? extends R> projection);

    public native <I, R> Observable<R> switchMap(Projector<? super T, ? extends I> projection, ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native <I, R> Observable<R> switchMapTo(Observable<? extends I> observable, ResultSelector<? super T, ? super I, ? extends R> resultSelector);

    public native Observable<T> take(int count);

    public native Observable<T> takeLast(int count);

    public native Observable<T> takeUntil(Observable closingNotifier);

    public native Observable<T> takeWhile(Observable notifier);

    public native Observable<T> throttle(Func1<? super T, Observable<?>> durationSelector);

    public native Observable<T> throttleTime(int duration);

    public native Observable<T> throttleTime(int duration, Scheduler scheduler);

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

    public native Observable<Observable<T>> window(Observable windowBoundaries);

    public native Observable<Observable<T>> windowCount(int windowSize);

    public native Observable<Observable<T>> windowCount(int windowSize, int startWindowEvery);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan);
    
    public native Observable<Observable<T>> windowTime(int windowTimeSpan, Scheduler scheduler);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval);
    
    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, Scheduler scheduler);
    
    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, int maxWindowSize);
    
    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, int maxWindowSize, Scheduler scheduler);

    public native <O> Observable<Observable<T>> windowToggle(Observable<O> openings, Func1<O, Observable> closingSelector);

    public native <O> Observable<Observable<T>> windowWhen(Observable closingSelector);

    public native <T1, T2, R> Observable<R> withLatestFrom(Observable<? extends T1> v1, Observable<? extends T2> v2,
            Func2<? super T1, ? super T2, ? extends R> combineFunction);

    public native <T1, T2, T3, R> Observable<R> withLatestFrom(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3,
            Func3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction);

    public native <T1, T2, T3, T4, R> Observable<R> withLatestFrom(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4,
            Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction);

    public native <R> Observable<R> zip(Func1<? super T, ? extends R> projectFunction);

    public native <T2, R> Observable<R> zip(Observable<? extends T2> v2,
            Func2<? super T, ? super T2, ? extends R> projectFunction);

    public native <T2, T3, R> Observable<R> zip(Observable<? extends T2> v2, Observable<? extends T3> v3,
            Func3<? super T, ? super T2, ? super T3, ? extends R> projectFunction);

    public native <T2, T3, T4, R> Observable<R> zip(
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4,
            Func4<? super T, ? super T2, ? super T3, ? super T4, ? extends R> projectFunction);

    public native <T2, T3, T4, T5, R> Observable<R> zip(
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4, Observable<? extends T5> v5,
            Func5<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> projectFunction);

    public native <T2, T3, T4, T5, T6, R> Observable<R> zip(
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4, Observable<? extends T5> v5, Observable<? extends T6> v6,
            Func6<? super T, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> projectFunction);

    public native <T2> Observable<T[]> zip(Observable<? extends T2> v2);

    public native <T2, T3> Observable<T[]> zip(Observable<? extends T2> v2, Observable<? extends T3> v3);

    public native <T2, T3, T4> Observable<T[]> zip(Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4);

    public native <T2, T3, T4, T5> Observable<T[]> zip(Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4, Observable<? extends T5> v5);

    public native <T2, T3, T4, T5, T6> Observable<T[]> zip(Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4, Observable<? extends T5> v5, Observable<? extends T6> v6);

    public native static <T> Observable<T[]> zip(Observable<? extends T>[] values);

    public native static <T1, T2, R> Observable<R> zip(Observable<? extends T1> v1, Observable<? extends T2> v2,
            Func2<? super T1, ? super T2, ? extends R> projectFunction);

    public native static <T1, T2, T3, R> Observable<R> zip(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3,
            Func3<? super T1, ? super T2, ? super T3, ? extends R> projectFunction);

    public native static <T1, T2, T3, T4, R> Observable<R> zip(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4,
            Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> projectFunction);

    public native static <T1, T2, T3, T4, T5, R> Observable<R> zip(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4, Observable<? extends T5> v5,
            Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> projectFunction);

    public native static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4, Observable<? extends T5> v5, Observable<? extends T6> v6,
            Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> projectFunction);

    public native static <T, R> Observable<R> zip(Observable<? extends T>[] values, ProjectWithArray<? extends T, ? extends R> projectFunction);

    public native Observable<T> zipAll();

    public native <R> Observable<R> zipAll(Func1<T[], ? extends R> mapper);

    @JsFunction
    public interface Accumulator<T> {

        T call(T acc, T value, int index);
    }

    @JsFunction
    public interface TransformingAccumulator<R, T> {

        R call(R acc, T value, int index);
    }

    @JsFunction
    public interface Selector<T> {

        Observable<T> call(Observable<T> observable);
    }

    @JsFunction
    public interface Factory<T> {

        T call();
    }

    @JsFunction
    public interface SubjectFactory<T> {

        Subject<T> call(Observable<T> observable);
    }

    @JsFunction
    public interface Comparator<T> {

        int compare(T i1, T i2);
    }

    @JsFunction
    public interface Projector<T, R> {

        Observable<R> project(T item, int index);
    }

    @JsFunction
    public interface Scanner<R, T> {

        Observable<R> scan(R acc, T item);
    }

    @JsFunction
    public interface ResultSelector<T, I, R> {

        R selectResult(T outerValue, I innerValue, int outerIndex, int innerIndex);
    }

    @JsFunction
    public interface IndexedResultSelector<T, R> {

        R selectResult(T value, int index);
    }

    @JsFunction
    public interface IndexedSourcePredicate<T> {

        boolean test(T value, int index, Observable<T> source);
    }

    @JsFunction
    public interface IndexedPredicate<T> {

        boolean test(T value, int index);
    }

    @JsFunction
    public interface Predicate<T> {

        boolean test(T value);
    }

    @JsFunction
    public interface KeySelector<T, K> {

        K selectKey(T item);
    }

    @JsFunction
    public interface ElementSelector<T, R> {

        R selectElement(T element);
    }

    @JsFunction
    public interface KeyComparator<K> {

        boolean compareKey(K k, K k1);
    }

}
