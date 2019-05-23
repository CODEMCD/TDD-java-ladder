package ladder.domain;

import ladder.core.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameTest {

    @Test
    void runWhenMultiRows() {
        // 1 -1 0 0
        // 0 1 -1 0
        // 0 0 1 -1
        LadderGame ladder = new LadderGame(new NaturalNumber(3), new NaturalNumber(4));
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));

        assertEquals(new Marker(4), ladder.run(new Marker(1)));
        assertEquals(new Marker(1), ladder.run(new Marker(2)));
        assertEquals(new Marker(2), ladder.run(new Marker(3)));
        assertEquals(new Marker(3), ladder.run(new Marker(4)));
    }

    @Test
    void 사다리_높이_위치가_0미만인_사다리에_그리는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderGame ladder = new LadderGame(new NaturalNumber(1), new NaturalNumber(3));
            ladder.drawLine(new NaturalNumber(0), new NaturalNumber(2));
        });
    }

    @Test
    void 사다리_최대_높이를_넘어서_그리는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderGame ladder = new LadderGame(new NaturalNumber(1), new NaturalNumber(3));
            ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
        });
    }
}
