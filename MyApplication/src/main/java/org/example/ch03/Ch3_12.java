package org.example.ch03;

import io.reactivex.Observable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * RECEIVED: 2016-01-03
 * RECEIVED: 2016-05-09
 * RECEIVED: 2016-10-12
 */
public class Ch3_12 {
    public static void main(String[] args) {
        var dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        var subscribe = Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
                .map(s -> LocalDate.parse(s, dtf))
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        subscribe.dispose();
    }
}