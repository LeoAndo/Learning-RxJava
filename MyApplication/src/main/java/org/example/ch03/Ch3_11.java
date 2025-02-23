package org.example.ch03;

import io.reactivex.Observable;

public class Ch3_11 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
                        "Delta")
                .elementAt(3)
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}