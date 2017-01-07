package com.github.timofeevda.gwt.rxjs.interop.subscription;

import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;

/**
 * @author dtimofeev since 21.12.2016.
 */
public class Subscriptions {
    public static Subscription create(Action0 unsubscribe) {
        return new BooleanSubscription(unsubscribe);
    }
}
