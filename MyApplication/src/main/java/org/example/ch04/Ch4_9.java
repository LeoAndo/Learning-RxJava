package org.example.ch04;

import io.reactivex.Observable;

public class Ch4_9 {
    public static void main(String[] args) {
        var source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        var source2 = Observable.just("Zeta", "Eta", "Theta");
        var subscribe = Observable.concat(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        subscribe.dispose();
    }
}