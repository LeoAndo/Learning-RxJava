package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_2 {
    public static void main(String[] args) {
        var source = Observable.create(emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");
                emitter.onNext("Delta");
                emitter.onNext("Epsilon");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        var subscribe = source.subscribe(s -> System.out.println("RECEIVED: " + s),
                Throwable::printStackTrace);
        subscribe.dispose();
    }
}