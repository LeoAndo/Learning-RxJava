package org.example.ch02;

import io.reactivex.Completable;

public class Ch2_32 {
    public static void main(String[] args) {
        var subscribe = Completable.fromRunnable(Ch2_32::runProcess)
                .subscribe(() -> System.out.println("Done!"));

        subscribe.dispose();
    }

    public static void runProcess() {
//run process here
    }
}