package org.example.ch04;

import io.reactivex.Observable;

public class Ch4_18 {
    public static void main(String[] args) {
        var source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        var byLengths = source.groupBy(String::length);
        var subscribe = byLengths.flatMapSingle(Observable::toList)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}