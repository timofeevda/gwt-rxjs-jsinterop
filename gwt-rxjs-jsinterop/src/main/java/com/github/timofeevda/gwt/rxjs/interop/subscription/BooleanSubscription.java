package com.github.timofeevda.gwt.rxjs.interop.subscription;

import com.github.timofeevda.gwt.rxjs.interop.functions.Action0;

/**
 * @author dtimofeev since 21.12.2016.
 */
public class BooleanSubscription implements Subscription {

    private Action0 unsubscribeAction;

    public BooleanSubscription(Action0 unsubscribeAction) {
        this.unsubscribeAction = unsubscribeAction;
    }


    @Override
    public boolean isClosed() {
        return unsubscribeAction == null;
    }

    @Override
    public void unsubscribe() {
        try {
            unsubscribeAction.call();
        } finally {
            unsubscribeAction = null;
        }
    }

    @Override
    public Subscription add(Subscription subscription) {
        return null;
    }

    @Override
    public void remove(Subscription subscription) {

    }
}
