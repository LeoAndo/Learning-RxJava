package org.example.ch05;

import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

/**
 * - **`UnicastSubject`** は、RxJavaで提供される特別な種類の
 * `Subject` です。1つのObserverのみがデータを購読（subscribe）可能です。
 * - この例では `UnicastSubject` を使用しており、Subjectは1つのObserverに対して順次データを発行します。
 * <p>
 * 1. **UnicastSubjectの特性**:
 * - `UnicastSubject` は、複数のObserverをサポートしません（1つだけ購読可能）。
 * - 複数のObserverを登録しようとすると、例外がスローされます。
 */
public class Ch5_26 {
    public static void main(String[] args) {
        Subject<String> subject =
                UnicastSubject.create();
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1) * 300) + " milliseconds")
                .subscribe(subject);
        sleep(2000);
        var subscribe = subject.subscribe(s -> System.out.println("Observer 1: " +
                s));
        sleep(2000);

        subscribe.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}