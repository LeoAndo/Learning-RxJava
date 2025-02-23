package org.example.ch06;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Ch6_18 {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        var assigner = new AtomicInteger(0);
        var subscribe = Observable.range(1, 10)
                .groupBy(i -> assigner.incrementAndGet() %
                        coreCount)
                .flatMap(grp -> grp.observeOn(Schedulers.io())
                        .map(Ch6_18::intenseCalculation)
                )
                .subscribe(i -> System.out.println("Received " + i +
                        " "
                        + LocalTime.now() + " on thread "
                        + Thread.currentThread().getName()));
        sleep(20000);

        subscribe.dispose();
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}