package org.example.ch06;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Ch6_13 {
    public static void main(String[] args) {
//Happens on IO Scheduler
        var subscribe = Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO",
                        "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())
                .flatMap(s -> Observable.fromArray(s.split("/")))
//Happens on Computation Scheduler
                .observeOn(Schedulers.computation())
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread "
                        + Thread.currentThread().getName()));
        sleep(1000);

        subscribe.dispose();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}