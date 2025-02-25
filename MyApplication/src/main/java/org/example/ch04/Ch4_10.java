package org.example.ch04;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch4_10 {
    public static void main(String[] args) {
//emit every second, but only take 2 emissions
        var source1 =
                Observable.interval(1, TimeUnit.SECONDS)
                        .take(2)
                        .map(l -> l + 1) // emit elapsed seconds
                        .map(l -> "Source1: " + l + " seconds");
//emit every 300 milliseconds
        var source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                        .map(l -> "Source2: " + l + " milliseconds");
        var subscribe = Observable.concat(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
//keep application alive for 5 seconds
        sleep(5000);

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