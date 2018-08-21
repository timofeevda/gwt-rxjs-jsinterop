package com.github.timofeevda.gwt.rxjs.interop;

import com.github.timofeevda.gwt.rxjs.interop.functions.ConditionFunc;
import com.github.timofeevda.gwt.rxjs.interop.functions.DeferProducer;
import com.github.timofeevda.gwt.rxjs.interop.functions.Func0;
import com.github.timofeevda.gwt.rxjs.interop.functions.IterateFunc;
import com.github.timofeevda.gwt.rxjs.interop.functions.ObservableFactoryFromResource;
import com.github.timofeevda.gwt.rxjs.interop.functions.ResultFunc;
import com.github.timofeevda.gwt.rxjs.interop.observable.EventListenerOptions;
import com.github.timofeevda.gwt.rxjs.interop.observable.Observable;
import com.github.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Unsubscribable;
import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "rxjs")
@SuppressWarnings("unused")
public class RxJS {

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

    public native static <T> Observable<T[]> combineLatest(Iterable<Observable<T>> observables);

    public native static <T> Observable<T[]> combineLatest(Iterable<Observable<T>> observables,
                                                           Scheduler scheduler);

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

    public native static <T> Observable<T> defer(DeferProducer<? extends T> producer);

    public native static <T> Observable<T> empty();

    public native static <T> Observable<T> empty(Scheduler scheduler);


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

    @SafeVarargs
    public native static <T> Observable<T[]> forkJoin(Observable<? extends T>... observables);

    public native static <T> Observable<T[]> forkJoin(Iterable<Observable<T>> observables);

    @SafeVarargs
    public native static <T> Observable<T> from(T... input);

    public native static <T> Observable<T> from(String input);

    public native static <T> Observable<T> from(Observable<? extends T> input);

    public native static <T> Observable<T> from(T[] input, Scheduler scheduler);

    public native static <T> Observable<T> from(String input, Scheduler scheduler);

    public native static <T> Observable<T> from(Observable<? extends T> input, Scheduler scheduler);

    public native static <T> Observable<T> fromArray(T[] array);

    public native static <T> Observable<T> fromArray(T[] array, Scheduler scheduler);

    public native static <T> Observable<T> fromEvent(Element target, String eventName);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, boolean useCapture);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.ListenerOptions listenerOptions);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.CapturingListenerOptions listenerOptions);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.PassiveListenerOptions listenerOptions);

    public native static <T> Observable<T> fromEvent(Element target, String eventName, EventListenerOptions.OnceListenerOptions listenerOptions);

    public native static <T> Observable<T> fromObservable(Observable<? extends T> input);

    public native static <T> Observable<T> fromObservable(Observable<? extends T> input, Scheduler scheduler);

    public native static <T, S> Observable<T> generate(S initialState,
                                                       ConditionFunc<? super S> condition,
                                                       IterateFunc<S> iterate,
                                                       ResultFunc<? super S, ? extends T> resultSelector);

    public native static <T, S> Observable<T> generate(S initialState,
                                                       ConditionFunc<? super S> condition,
                                                       IterateFunc<S> iterate,
                                                       ResultFunc<? super S, ? extends T> resultSelector,
                                                       Scheduler scheduler);


    public native static <T> Observable<T> iif(Func0<Boolean> condition, Observable<? extends T> trueResult);

    public native static <T> Observable<T> iif(Func0<Boolean> condition, Observable<? extends T> trueResult, Observable<? extends T> thenResult);

    public native static Observable<Integer> interval(int period);

    public native static Observable<Integer> interval(int period, Scheduler scheduler);

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

    public native static <T> Observable<T> never();

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

    @SafeVarargs
    public native static <T> Observable<T> onErrorResumeNext(Observable<? extends T>... vs);

    public native static <T> Observable<T> onErrorResumeNext(Iterable<Observable<T>> vs);

    public native static Observable<Object[]> pairs(Object o);

    public native static Observable<Object[]> pairs(Object o, Scheduler scheduler);

    @SafeVarargs
    public native static <T> Observable<T> race(Observable<? extends T>... observables);

    public native static <T> Observable<T> race(Iterable<Observable<T>> observables);

    public native static Observable<Integer> range(int start, int count);

    public native static Observable<Integer> range(int start, int count, Scheduler scheduler);

    public native static <T, R extends T> Observable<T> scalar(R value);

    public native static <T> Observable<T> throwError(Object error);

    public native static <T> Observable<T> throwError(Object error, Scheduler scheduler);

    public native static Observable<Integer> timer(int dueTime);

    public native static Observable<Integer> timer(int dueTime, int period);

    public native static Observable<Integer> timer(int dueTime, int period, Scheduler scheduler);

    public native static Observable<Integer> timer(int dueTime, Scheduler scheduler);

    public native static <T> Observable<T> using(Func0<Unsubscribable> resourceFactory,
                                                 ObservableFactoryFromResource<? extends T> observableFactory);

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

}
