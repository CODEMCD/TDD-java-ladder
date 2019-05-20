package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @Test
    void runWhenNoLine() {
        Ladder ladder = new Ladder(1, 3);
        int target = ladder.run(0);
        assertEquals(0, target);

        target = ladder.run(2);
        assertEquals(2, target);
    }

    @Test
    void runWhenLineLeft() {
        // 0 1 1
        Ladder ladder = new Ladder(1, 3);
        ladder.drawLine(0, 1);

        int target = ladder.run(2);
        assertEquals(1, target);

        // 1 1 0
        ladder = new Ladder(1, 3);
        ladder.drawLine(0, 0);

        target = ladder.run(0);
    }

    @Test
    void runWhenLineRight() {
        // 0 1 1
        Ladder ladder = new Ladder(1, 3);
        ladder.drawLine(0, 1);

        int target = ladder.run(1);
        assertEquals(2, target);

        // 0 1 1
        ladder = new Ladder(1, 3);
        ladder.drawLine(0, 1);

        target = ladder.run(2);
        assertEquals(1, target);
    }

    @Test
    void runWhenMultiRows() {
        // 1 1 0 0
        // 0 1 1 0
        // 0 0 1 1
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);

        assertEquals(3, ladder.run(0));
        assertEquals(0, ladder.run(1));
        assertEquals(1, ladder.run(2));
        assertEquals(2, ladder.run(3));
    }
}
