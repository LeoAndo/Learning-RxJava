package org.example.ch06;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class Ch6_8 {
    public static void main(String[] args) {
        var lengths =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                                "Epsilon")
                        .subscribeOn(Schedulers.computation())
                        .map(Ch6_8::intenseCalculation)
                        .map(String::length);
        var subscribe = lengths.subscribe(i ->
                System.out.println("Received " + i + " on thread " +
                        Thread.currentThread().getName()));
        var subscribe1 = lengths.subscribe(i ->
                System.out.println("Received " + i + " on thread " +
                        Thread.currentThread().getName()));
        sleep(10000);


        subscribe.dispose();
        subscribe1.dispose();
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}