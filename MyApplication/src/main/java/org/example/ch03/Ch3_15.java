package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_15 {
    public static void main(String[] args) {
        var items =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        var subscribe = items.filter(s -> s.startsWith("Z"))
                .defaultIfEmpty("None")
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}