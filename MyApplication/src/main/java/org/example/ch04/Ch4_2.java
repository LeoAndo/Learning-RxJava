package org.example.ch04;

import io.reactivex.Observable;

public class Ch4_2 {
    public static void main(String[] args) {
        var source1 = Observable.just("Alpha", "Beta");
        var source2 = Observable.just("Gamma", "Delta");
        var source3 = Observable.just("Epsilon", "Zeta");
        var source4 = Observable.just("Eta", "Theta");
        var source5 = Observable.just("Iota", "Kappa");
        var subscribe =
                Observable.mergeArray(source1, source2, source3, source4, source5)
                        .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}