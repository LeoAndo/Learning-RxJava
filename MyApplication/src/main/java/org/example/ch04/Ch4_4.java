package org.example.ch04;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch4_4 {
    public static void main(String[] args) {
//emit every second
        var source1 = Observable.interval(1,
                        TimeUnit.SECONDS)
                .map(l -> l + 1) // emit elapsed seconds
                .map(l -> "Source1: " + l + " seconds");
//emit every 300 milliseconds
        var source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                        .map(l -> "Source2: " + l + " milliseconds");
//merge and subscribe
        var subscribe = Observable.merge(source1, source2)
                .subscribe(System.out::println);
//keep alive for 3 seconds
        sleep(3000);

        subscribe.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}