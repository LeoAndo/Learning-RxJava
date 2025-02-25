package org.example.ch04;

import io.reactivex.Observable;

public class Ch4_11 {
    public static void main(String[] args) {
        var source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        var subscribe = source.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}