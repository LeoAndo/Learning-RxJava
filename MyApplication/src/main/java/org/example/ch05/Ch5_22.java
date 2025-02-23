package org.example.ch05;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class Ch5_22 {
    public static void main(String[] args) {
        Subject<String> subject = PublishSubject.create();
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        // `onComplete()` は、`PublishSubject` がこれ以上データを発行しないことを通知します。
        // これにより、データフローが終了します。
        subject.onComplete();


        // `onComplete()` が既に呼び出された後に購読されるため、
        //    購読者には何もデータが届きません。
        var subscribe = subject.map(String::length)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}