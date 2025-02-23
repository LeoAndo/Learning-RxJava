package org.example.ch05;

import io.reactivex.Observable;

public class Ch5_1 {
    public static void main(String[] args) {
        var threeIntegers = Observable.range(1, 3);
        var subscribe = threeIntegers.subscribe(i -> System.out.println("Observer One: " + i));
        var subscribe1 = threeIntegers.subscribe(i -> System.out.println("Observer Two: " + i));

        subscribe.dispose();
        subscribe1.dispose();
    }
}