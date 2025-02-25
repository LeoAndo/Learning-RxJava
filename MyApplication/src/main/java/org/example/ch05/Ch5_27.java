package org.example.ch05;

import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class Ch5_27 {
    public static void main(String[] args) {
        Subject<String> subject =
                UnicastSubject.create();
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1) * 300) + " milliseconds")
                .subscribe(subject);
        sleep(2000);
//multicast to support multiple Observers
        var multicast =
                subject.publish().autoConnect();
//bring in first Observer
        var subscribe = multicast.subscribe(s -> System.out.println("Observer 1: "
                + s));
        sleep(2000);
//bring in second Observer
        var subscribe1 = multicast.subscribe(s -> System.out.println("Observer 2: "
                + s));
        sleep(1000);


        subscribe.dispose();
        subscribe1.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}