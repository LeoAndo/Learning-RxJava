package org.example.ch08;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.example.ch05.Ch5_21;

public class Ch8_8 {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isDisposed())
                    return;
                emitter.onNext(i);
            }
            emitter.onComplete();
        });
        var subscribe = source.observeOn(Schedulers.io())
                .subscribe(System.out::println);
        Ch5_21.sleep(1000);

        subscribe.dispose();
    }
}