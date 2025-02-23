package org.example.ch04;

import io.reactivex.Observable;

import java.util.Arrays;

public class Ch4_3 {
    public static void main(String[] args) {
        var source1 =
                Observable.just("Alpha", "Beta");
        var source2 =
                Observable.just("Gamma", "Delta");
        var source3 =
                Observable.just("Epsilon", "Zeta");
        var source4 =
                Observable.just("Eta", "Theta");
        var source5 =
                Observable.just("Iota", "Kappa");
        var sources = Arrays.asList(source1, source2, source3, source4, source5);
        var subscribe = Observable.merge(sources)
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}