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

import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;
import com.github.timofeevda.gwt.rxjs.interop.functions.Action1;
import com.github.timofeevda.gwt.rxjs.interop.functions.OperatorFunction;
import com.github.timofeevda.gwt.rxjs.interop.functions.UnaryArrayFunction;
import com.github.timofeevda.gwt.rxjs.interop.functions.UnaryFunction;
import com.github.timofeevda.gwt.rxjs.interop.subscription.Subscription;
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
@JsType(namespace = "rxjs", isNative = true)
@SuppressWarnings("unused")
public class Observable<T> {

    public native static <T> Observable<T> create(OnSubscribe<? extends T> onSubscribe);

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

    public native <A> Observable<A>[] pipe(UnaryArrayFunction<T, A> op1);

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

    public native Subscription subscribe(Action1<? super T> onNext);

    public native Subscription subscribe(Action1<? super T> onNext, Action1<?> onError);

    public native Subscription subscribe(Action1<? super T> onNext, Action1<?> onError, Action0 onCompleted);

    public native Subscription subscribe(Observer<? super T> observer);

}
