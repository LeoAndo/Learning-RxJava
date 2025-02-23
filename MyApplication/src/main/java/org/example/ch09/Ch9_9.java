package org.example.ch09;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.functions.Action;
import io.reactivex.subscribers.DisposableSubscriber;

public class Ch9_9 {
    public static void main(String[] args) {
        var subscribe = Flowable.range(1, 5)
                .lift(doOnEmpty(() ->
                        System.out.println("Operation 1 Empty!")))
                .subscribe(v -> System.out.println("Operation 1: "
                        + v));
        var subscribe1 = Flowable.<Integer>empty()
                .lift(doOnEmpty(() ->
                        System.out.println("Operation 2 Empty!")))
                .subscribe(v -> System.out.println("Operation 2: "
                        + v));

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static <T> FlowableOperator<T, T> doOnEmpty(Action
                                                               action) {
        return subscriber -> new DisposableSubscriber<T>() {
            boolean isEmpty = true;

            @Override
            public void onNext(T value) {
                isEmpty = false;
                subscriber.onNext(value);
            }

            @Override
            public void onError(Throwable t) {
                subscriber.onError(t);
            }

            @Override
            public void onComplete() {
                if (isEmpty) {
                    try {
                        action.run();
                    } catch (Exception e) {
                        onError(e);
                        return;
                    }
                }
                subscriber.onComplete();
            }
        };
    }
}