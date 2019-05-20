package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    void runWhenMultiRows() {
        // 1 1 0 0
        // 0 1 1 0
        // 0 0 1 1
        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));

        assertEquals(3, ladder.run(0));
        assertEquals(0, ladder.run(1));
        assertEquals(1, ladder.run(2));
        assertEquals(2, ladder.run(3));
    }

    @Test
    void 사다리_높이_위치가_0미만인_사다리에_그리는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
            ladder.drawLine(new NaturalNumber(0), new NaturalNumber(2));
        });
    }

    @Test
    void 사다리_최대_높이를_넘어서_그리는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
            ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
        });
    }
}
