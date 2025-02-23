package org.example.ch05;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_5 {
    public static void main(String[] args) {
        var threeRandoms = Observable.range(1, 3).map(i -> randomInt()).publish();
        var subscribe = threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        var subscribe1 = threeRandoms.subscribe(i -> System.out.println("Observer 2: " + i));
        threeRandoms.connect();

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}