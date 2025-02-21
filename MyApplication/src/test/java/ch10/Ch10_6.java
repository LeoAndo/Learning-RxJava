package ch10;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ch10_6 {
    @Test
    public void testLast() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Zeta");
        String lastWithLengthFour = source.filter(s -> s.length()
                == 4)
                .blockingLast();
        assertEquals("Zeta", lastWithLengthFour);
    }
}
