package org.example.ch05;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;

public class Ch5_25 {
    public static void main(String[] args) {
        Subject<String> subject =
                AsyncSubject.create();
        var subscribe = subject.subscribe(s ->
                        System.out.println("Observer 1: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Observer 1 done!")
        );
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
        var subscribe1 = subject.subscribe(s ->
                        System.out.println("Observer 2: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Observer 2 done!")
        );


        subscribe.dispose();
        subscribe1.dispose();
    }
}