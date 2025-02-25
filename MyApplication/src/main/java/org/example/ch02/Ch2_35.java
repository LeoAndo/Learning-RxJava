package org.example.ch02;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

import java.util.concurrent.TimeUnit;

public class Ch2_35 {
    private static final CompositeDisposable disposables
            = new CompositeDisposable();

    public static void main(String[] args) {
        var seconds =
                Observable.interval(1, TimeUnit.SECONDS);
//subscribe and capture disposables
        var disposable1 =
                seconds.subscribe(l -> System.out.println("Observer 1: " +
                        l));
        var disposable2 =
                seconds.subscribe(l -> System.out.println("Observer 2: " +
                        l));
//put both disposables into CompositeDisposable
        disposables.addAll(disposable1, disposable2);
//sleep 5 seconds
        sleep(5000);
//dispose all disposables
        disposables.dispose();
//sleep 5 seconds to prove
//there are no more emissions
        sleep(5000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}