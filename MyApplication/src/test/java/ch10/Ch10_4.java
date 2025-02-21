package ch10;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ch10_4 {
    @Test
    public void testFirst() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Zeta");
        String firstWithLengthFour = source.filter(s -> s.length()
                == 4)
                .blockingFirst();
        assertEquals("Beta", firstWithLengthFour);
    }
}
