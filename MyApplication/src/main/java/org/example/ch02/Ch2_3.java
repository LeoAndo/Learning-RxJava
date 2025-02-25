package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_3 {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
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
        var lengths = source.map(String::length);
        var filtered = lengths.filter(i -> i >= 5);
        var subscribe = filtered.subscribe(s -> System.out.println("RECEIVED: " +
                s));
        subscribe.dispose();
    }
}