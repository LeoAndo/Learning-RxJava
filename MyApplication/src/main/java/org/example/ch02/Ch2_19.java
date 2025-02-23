package org.example.ch02;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch2_19 {
    public static void main(String[] args) {
        var seconds =
                Observable.interval(1, TimeUnit.SECONDS).publish();
//observer 1
        var subscribe = seconds.subscribe(l -> System.out.println("Observer 1: " + l));
        seconds.connect();
//sleep 5 seconds
        sleep(5000);
//observer 2
        var subscribe1 = seconds.subscribe(l -> System.out.println("Observer 2: " + l));
//sleep 5 seconds
        sleep(5000);

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}