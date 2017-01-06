package tests;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.timofeevda.gwt.rxjs.interop.functions.Action0;
import org.timofeevda.gwt.rxjs.interop.observable.Observable;
import org.timofeevda.gwt.rxjs.interop.scheduler.Scheduler;
import org.timofeevda.gwt.rxjs.interop.subscription.Subscription;

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

    @JsMethod(name = "merge")
    public String testMerge() {
        final StringHolder sh = new StringHolder();
        Observable.merge(Observable.of("1"), Observable.of("2")).subscribe(v -> sh.value += v);
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
        Observable.of(1, 2, 3, 4).mergeMap((Integer item, int index) -> item % 2 == 0 ? Observable.of("1") : Observable.<String>empty()).subscribe(v -> sh.value += v);
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
        Observable.of("1", "2","3").map(Observable::of).exhaust().subscribe(v -> sh.value += v);
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
        Observable<String>[] obs = Observable.of("1", "3").partition(v -> v.equals("3"));
        obs[1].subscribe(v -> sh.value += v);
        return sh.value;
    }
    
    @JsMethod(name = "range")
    public String testRange(Action0 jasmineDone) {
        final StringHolder sh = new StringHolder();
        Observable.range(1,3).subscribe(v -> sh.value += v);
        return sh.value;
    }
    
    @JsMethod(name = "throw")
    public String testThrow(Action0 jasmineDone) {
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
    
}
