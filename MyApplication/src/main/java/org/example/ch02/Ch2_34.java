package org.example.ch02;

import io.reactivex.Observable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class Ch2_34 {
    public static void main(String[] args) {
        var source =
                Observable.interval(1, TimeUnit.SECONDS);
        var myObserver = new
                ResourceObserver<Long>() {
                    @Override
                    public void onNext(Long value) {
                        System.out.println(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                };
//capture Disposable
        var disposable = source.subscribeWith(myObserver);
    }
}