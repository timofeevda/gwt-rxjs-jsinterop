package org.timofeevda.gwt.rxjs.interop.observable;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.timofeevda.gwt.rxjs.interop.subject.Subject;
import org.timofeevda.gwt.rxjs.interop.functions.Action0;
import org.timofeevda.gwt.rxjs.interop.functions.Action1;
import org.timofeevda.gwt.rxjs.interop.functions.Func1;
import org.timofeevda.gwt.rxjs.interop.functions.Func2;
import org.timofeevda.gwt.rxjs.interop.functions.Func3;
import org.timofeevda.gwt.rxjs.interop.functions.Func4;
import org.timofeevda.gwt.rxjs.interop.functions.FuncN;
import org.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;
import org.timofeevda.gwt.rxjs.interop.subscription.Subscription;

/**
 * @author dtimofeev since 20.12.2016.
 * @param <T>
 */
@JsType(namespace = "Rx", isNative = true)
public class Observable<T> {

    public native static <T> Observable<T> of(T... args);
    
    public native static <T> Observable<T> from(T[] args);
    
//    public native static <T> Observable<T> from(Iterable<T> args);

    public native static <T> Observable<T> create(OnSubscribe<T> onSubscribe);

    public native Observable<T> audit(Observable durationSelector);

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
    public native <R> Observable<R> _catch(Func2<?, Observable<T>, Observable<R>> catcher);

    public native Observable<T> combineAll();

    public native <R> Observable<R> combineAll(Func1<T[], R> mapper);

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

    public native static <T> Observable<T> concatAll();

    public native static <T> Observable<T> concat(Observable<? extends T> v1, Observable<? extends T> v2);

    public native static <T> Observable<T> concat(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3);

    public native static <T> Observable<T> concat(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4);

    public native static <T> Observable<T> concat(Iterable<? extends Observable<? extends T>> observables);

    public native static <T> Observable<T> concat(Observable<? extends T>[] observables);

    public native <R> Observable<R> concatMap(Projector<T, R> projector);

    public native <I, R> Observable<T> concatMap(Projector<T, I> projector, ResultSelector<T, I, R> resultSelector);

    public native <I, R> Observable<R> concatMapTo(Observable<I> observable, ResultSelector<T, I, R> resultSelector);

    public native Observable<Integer> count();

    public native Observable<Integer> count(CountPredicate<T> predicate);

    public native Observable<T> debounce(Observable<Integer> durationSelector);

    public native Observable<T> debounceTime(int time);

    public native <R> Observable<R> defaultIfEmpty(R defaultValue);

    public native Observable<T> delay(int initialDelay);

    public native Observable<T> delayWhen(Func1<T, Observable<?>> delayDurationSelector);

    public native Observable<T> delayWhen(Func1<T, Observable<?>> delayDurationSelector, Observable<?> subscriptionDelay);

    public native Observable<T> distinct();

    public native <K> Observable<T> distinct(KeySelector<T, K> keySelector);

    public native <K> Observable<T> distinct(KeySelector<T, K> keySelector, Observable<?> flushes);

    public native Observable<T> distinctUntilChanged();

    public native <K> Observable<T> distinctUntilChanged(KeyComparator<T, K> keyComparator);

    public native <K> Observable<T> distinctUntilChanged(KeyComparator<T, K> keyComparator, KeySelector<T, K> keySelector);

    @JsMethod(name = "do")
    public native <R> Observable<R> _do(Action1<T> onNext);

    @JsMethod(name = "do")
    public native Subscription _do(Action1<T> onNext, Action1<?> onError, Action0 onCompleted);

    @JsMethod(name = "do")
    public native <R> Observable<R> _do(Observer<T> observer);

    public native Observable<T> elementAt(int index);

    public native Observable<T> elementAt(int index, T defaultValue);

    public native Observable<Boolean> every(CountPredicate<T> predicate);

    public native Observable<T> exhaust();

    public native <R> Observable<T> exhaustMap(Projector<T, R> projector);

    public native <I, R> Observable<T> exhaustMap(Projector<T, I> projector, ResultSelector<T, I, R> resultSelector);

    public native <R> Observable<T> expand(Projector<T, R> projector);

    public native <R> Observable<T> expand(Projector<T, R> projector, int concurrent);

    public native <R> Observable<T> expand(Projector<T, R> projector, int concurrent, Scheduler scheduler);

    public native Observable<T> filter(Predicate<T> predicate);

    @JsMethod(name = "finally")
    public native Observable<T> _finally(Action0 action);

    public native Observable<T> find(Predicate<T> predicate);

    public native Observable<Integer> findIndex(CountPredicate<T> predicate);

    public native Observable<T> first(Predicate<T> predicate);

    public native <I, R> Observable<R> first(Predicate<T> predicate, ResultSelector<T, I, R> resultSelector);

    public native <I, R> Observable<R> first(Predicate<T> predicate, ResultSelector<T, I, R> resultSelector, R defaultValue);

    public native <K> Observable<GroupedObservable<K, T>> groupBy(KeySelector<T, K> keySelector);

    public native <K, R> Observable<GroupedObservable<K, R>> groupBy(KeySelector<T, K> keySelector, ElementSelector<T, R> elementSelector);

    public native Observable<T> ignoreElements();

    public native Observable<Boolean> isEmpty();

    public native Observable<T> last(Predicate<T> predicate);

    public native <I, R> Observable<R> last(Predicate<T> predicate, ResultSelector<T, I, R> resultSelector);

    public native <I, R> Observable<R> last(Predicate<T> predicate, ResultSelector<T, I, R> resultSelector, R defaultValue);

    public native <R> Observable<R> let(Func1<Observable<T>, Observable<R>> selector);

    public native <R> Observable<R> map(Func1<T, R> mapper);

    public native <R> Observable<R> mapTo(R value);

    public native Observable<T> max();

    public native Observable<T> max(Comparer<T> comparer);

    public native static <T> Observable<T> merge(Observable<T> first, Observable<T> second);

    public native <T> Observable<T> mergeAll();

    public native <T> Observable<T> mergeAll(int concurrent);

    public native <R> Observable<R> mergeMap(Projector<T, R> projector);

    public native <R> Observable<R> mergeMap(Projector<T, R> projector, int concurrent);

    public native <I, R> Observable<R> mergeMap(Projector<T, R> projector, ResultSelector<T, I, R> resultSelector);

    public native <I, R> Observable<R> mergeMap(Projector<T, R> projector, ResultSelector<T, I, R> resultSelector, int concurrent);

    public native <R> Observable<R> mergeMapTo(Observable<R> innerObservable);

    public native <R> Observable<R> mergeMapTo(Observable<R> innerObservable, int concurrent);

    public native <I, R> Observable<R> mergeMapTo(Observable<R> innerObservable, ResultSelector<T, I, R> resultSelector);

    public native <I, R> Observable<R> mergeMapTo(Observable<R> innerObservable, ResultSelector<T, I, R> resultSelector, int concurrent);

    public native <R> Observable<R> mergeScan(Scanner<R, T> scanner, R seed);

    public native <R> Observable<R> mergeScan(Scanner<R, T> scanner, R seed, int concurrent);

    public native Observable<T> min();

    public native Observable<T> min(Comparer<T> comparer);

    public native ConnectableObservable<T> multicast(Subject<T> subject);

    public native ConnectableObservable<T> multicast(Factory<Subject<T>> subjectFactory);

    public native ConnectableObservable<T> multicast(Subject<T> subject, Selector<T> selector);

    public native ConnectableObservable<T> multicast(Factory<Subject<T>> subjectFactory, Selector<T> selector);

    public native static <T> Observable<T> multicast(SubjectFactory<T> subjectFactory);

    public native static <T> Observable<T> multicast(SubjectFactory<T> subjectFactory, Selector<T> selector);

    public native <R> Observable<R> observeOn(Scheduler scheduler);

    public native <R> Observable<R> observeOn(Scheduler scheduler, int delay);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> inputObservable);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4, Observable<? extends T> v5);

    public native Observable<T> onErrorResumeNext(Observable<? extends T> v1, Observable<? extends T> v2, Observable<? extends T> v3, Observable<? extends T> v4, Observable<? extends T> v5, Observable<? extends T> v6);

    public native Observable<T[]> pairwise();

    public native Observable<T>[] partition(Func1<T, Boolean> predicate);

    public native ConnectableObservable<T> publish();

    public native ConnectableObservable<T> publish(Selector<T> selector);

    public native ConnectableObservable<T> publishBehavior(T value);

    public native ConnectableObservable<T> publishLast();

    public native ConnectableObservable<T> publishReplay();

    public native ConnectableObservable<T> publishReplay(int bufferSize);

    public native ConnectableObservable<T> publishReplay(int bufferSize, int windowTime);

    public native ConnectableObservable<T> publishReplay(int bufferSize, int windowTime, Scheduler scheduler);

    public native static <T> Observable<T> race(Observable<? extends T> v1, Observable<? extends T> v2);

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

    public native Observable<T> single(CountPredicate<T> predicate);

    public native Observable<T> skip(int count);

    public native Observable<T> skipUntil(Observable notifier);

    public native Observable<T> skipWhile(Predicate<T> predicate);

    public native Observable<T> startWith(T v1);

    public native Observable<T> startWith(T v1, Scheduler scheduler);

    public native Observable<T> startWith(T v1, T v2);

    public native Observable<T> startWith(T v1, T v2, Scheduler scheduler);

    public native Subscription subscribe(Action1<T> onNext);

    public native Subscription subscribe(Action1<T> onNext, Action1<?> onError, Action0 onCompleted);

    public native Subscription subscribe(Observer<T> observer);

    public native <R> Observable<R> subscribeOn(Scheduler scheduler);

    public native <R> Observable<R> subscribeOn(Scheduler scheduler, int delay);

    @JsMethod(name = "switch")
    public native <R> Observable<R> _switch();

    public native <R> Observable<R> switchMap(Projector<T, R> projection);

    public native <I, R> Observable<R> switchMap(Projector<T, I> projection, ResultSelector<T, I, R> resultSelector);

    public native <I, R> Observable<R> switchMapTo(Observable<I> observable, ResultSelector<T, I, R> resultSelector);

    public native Observable<T> take(int count);

    public native Observable<T> takeLast(int count);

    public native Observable<T> takeUntil(Observable closingNotifier);

    public native Observable<T> takeWhile(Observable notifier);

    public native static Observable<Void> timer(int initialDelay);

    public native Observable<T> throttle(Func1<T, Observable<?>> durationSelector);

    public native Observable<T> throttleTime(int duration);

    public native Observable<T> throttleTime(int duration, Scheduler scheduler);

    public native Observable<TimeInterval<T>> timeInterval();

    public native Observable<TimeInterval<T>> timeInterval(Scheduler scheduler);

    public native Observable<T> timeout(int due);

    public native Observable<T> timeout(int due, Scheduler scheduler);

    public native Observable<T> timeoutWith(int due, Observable<T> withObservable);

    public native Observable<T> timeoutWith(int due, Observable<T> withObservable, Scheduler scheduler);

    public native Observable<Timestamp<T>> timestamp();

    public native Observable<Timestamp<T>> timestamp(Scheduler scheduler);

    public native Observable<T[]> toArray();

    public native Observable<Observable<T>> window(Observable windowBoundaries);

    public native Observable<Observable<T>> windowCount(int windowSize);

    public native Observable<Observable<T>> windowCount(int windowSize, int startWindowEvery);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval);

    public native Observable<Observable<T>> windowTime(int windowTimeSpan, int windowCreationInterval, Scheduler scheduler);

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

    public native static <T1, T2, R> Observable<R> zip(Observable<? extends T1> v1, Observable<? extends T2> v2,
            Func2<? super T1, ? super T2, ? extends R> combineFunction);

    public native static <T1, T2, T3, R> Observable<R> zip(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3,
            Func3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction);

    public native static <T1, T2, T3, T4, R> Observable<R> zip(Observable<? extends T1> v1,
            Observable<? extends T2> v2, Observable<? extends T3> v3, Observable<? extends T4> v4,
            Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction);

    public native Observable<T> zipAll();

    public native <R> Observable<R> zipAll(Func1<T[], R> mapper);

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

        Observable<T> call(Observable<T> source);
    }

    @JsFunction
    public interface Factory<T> {

        T call();
    }

    @JsFunction
    public interface SubjectFactory<T> {

        Subject<T> call(Observable<T> obs);
    }

    @JsFunction
    public interface Comparer<T> {

        int project(T i1, T i2);
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
    public interface CountPredicate<T> {

        Boolean test(T value, int index, Observable<T> source);
    }

    @JsFunction
    public interface Predicate<T> {

        Boolean test(T value, int index);
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
    public interface KeyComparator<K, K1> {

        boolean selectKey(K k, K1 k1);
    }

}
