package org.example.ch05;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class Ch5_23 {
    public static void main(String[] args) {
        Subject<String> subject =
                BehaviorSubject.create();
        var subscribe = subject.subscribe(s -> System.out.println("Observer 1: " +
                s));
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        var subscribe1 = subject.subscribe(s -> System.out.println("Observer 2: " +
                s));

        subscribe.dispose();
        subscribe1.dispose();
    }
}