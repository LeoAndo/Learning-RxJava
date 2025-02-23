package org.example.ch03;

import io.reactivex.Observable;

/**
 * RECEIVED: Alpha
 * RECEIVED: Beta
 * RECEIVED: Eta
 * RECEIVED: Gamma
 */
public class Ch3_10 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
                        "Delta")
                .distinctUntilChanged(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}