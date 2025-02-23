package org.example.ch05;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_13 {
    public static void main(String[] args) {
        var threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt())
                .publish()
                .autoConnect(2);

        //Observer 1 - print each random integer
        var subscribe = threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        //Observer 2 - sum the random integers, then print
        var subscribe1 = threeRandoms.reduce(0, Integer::sum)
                .subscribe(i -> System.out.println("Observer 2: " + i));
        //Observer 3 - receives nothing
        var subscribe2 = threeRandoms.subscribe(i -> System.out.println("Observer 3:" + i));

        subscribe.dispose();
        subscribe1.dispose();
        subscribe2.dispose();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}