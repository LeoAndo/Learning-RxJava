package org.example.ch02;

import io.reactivex.Observable;

public class Ch2_11 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
//first observer
        var subscribe = source.subscribe(s -> System.out.println("Observer 1 Received: " + s));
//second observer
        var subscribe1 = source.subscribe(s -> System.out.println("Observer 2 Received: " + s));
        subscribe.dispose();
        subscribe1.dispose();
    }
}