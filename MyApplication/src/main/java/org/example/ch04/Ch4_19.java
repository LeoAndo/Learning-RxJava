package org.example.ch04;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class Ch4_19 {
    public static void main(String[] args) {
        var source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(String::length);
        var subscribe = byLengths.flatMapSingle(grp ->
                grp.reduce("", (x, y) -> x.isEmpty() ? y : x + ", " + y)
                        .map(s -> grp.getKey() + ": " + s)
        ).subscribe(System.out::println);

        subscribe.dispose();
    }
}