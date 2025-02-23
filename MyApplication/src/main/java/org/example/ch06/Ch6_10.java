package org.example.ch06;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.net.URL;
import java.util.Scanner;

public class Ch6_10 {
    public static void main(String[] args) {
        var subscribe = Observable.fromCallable(() ->
                        getResponse("https://api.github.com/users/thomasnield/starred")
                ).subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
        sleep(10000);

        subscribe.dispose();
    }

    private static String getResponse(String path) {
        try {
            return new Scanner(new URL(path).openStream(),
                    "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}