package org.example.ch05;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * `PublishSubject` は **Reactive Streams** の一部で、Observer（観測者）が
 * `PublishSubject` にサブスクライブ（登録）した後のデータのみを受け取り、
 * リアルタイムでイベントを流す仕組みを提供します。
 * <p>
 * - **`PublishSubject`**:
 * - イベントの送出を扱うオブジェクト。
 * - 複数の `Observer`（観測者）を持つことができ、
 * 登録された `Observer` だけが `onNext` メソッドで送られたデータをリアルタイムに受け取ります。
 * - 過去のイベントを保持しないため、後からサブスクライブした Observer はそれ以前に送られたイベントを受け取れません。
 */
public class Ch5_20 {
    public static void main(String[] args) {
        Subject<String> subject = PublishSubject.create();
        var subscribe = subject.map(String::length)
                .subscribe(System.out::println);
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();

        subscribe.dispose();
    }
}