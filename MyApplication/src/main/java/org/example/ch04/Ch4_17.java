package org.example.ch04;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class Ch4_17 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(s -> s.length());
    }
}