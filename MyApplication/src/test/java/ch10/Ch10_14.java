package ch10;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;

public class Ch10_14 {
    @Test
    public void debugWalkthrough() {
        TestObserver<String> testObserver = new TestObserver<>();

        Observable<String> items =
                Observable.just("521934/2342/Foxtrot",
                        "Bravo/12112/78886/Tango",
                        "283242/4542/Whiskey/2348562");

        items.flatMap(s ->
                        Observable.fromArray(s.split("/"))
                )
                .subscribe(testObserver);

        testObserver
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(11); // Total number of elements after splitting

        // If using flatMap, don't assert specific order
        testObserver.values()
                .forEach(value -> System.out.println(value));
    }
}

