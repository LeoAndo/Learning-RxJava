package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_31 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        var subscribe = source.firstElement().subscribe(
                s -> System.out.println("RECEIVED " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));

        subscribe.dispose();
    }
}