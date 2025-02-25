package org.example.ch03;

import io.reactivex.Observable;

import java.time.LocalDate;

public class Ch3_28 {
    public static void main(String[] args) {
        var subscribe = Observable.just("2016-01-01", "2016-05-02", "2016-09-12",
                        "2016-04-03")
                .map(LocalDate::parse)
                .any(dt -> dt.getMonthValue() >= 6)
                .subscribe(s -> System.out.println("Received: " + s));

        subscribe.dispose();
    }
}