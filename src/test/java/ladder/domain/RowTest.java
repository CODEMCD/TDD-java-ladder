package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {
    private Row row;

    @BeforeEach
    void setUp() {
        row = new Row(new NaturalNumber(3));
    }

    @Test
    void startPositionWhenMinus() {
        assertThrows(IllegalArgumentException.class, () -> {
           row.drawLine(new NaturalNumber(0));
        });
    }

    @Test
    void startPositionWhenOverNoOfPersons() {
        assertThrows(IllegalArgumentException.class, () -> {
            row.drawLine(new NaturalNumber(3));
        });
    }

    @Test
    void drawLineWhenAlreadyDrawingPoint() {
        assertThrows(IllegalArgumentException.class, () -> {
            row.drawLine(new NaturalNumber(1));
            row.drawLine(new NaturalNumber(2));
        });
    }

    @Test
    void 사다리_시작_위치가_음수인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            row.move(-1);
        });
    }

    @Test
    void moveWhenNoLine() {
        int target = row.move(0);
        assertEquals(0, target);

        target = row.move(2);
        assertEquals(2, target);
    }

    @Test
    void moveWhenLineLeft() {
        // 0 1 1
        row.drawLine(new NaturalNumber(2));

        int target = row.move(2);
        assertEquals(1, target);
    }

    @Test
    void moveWhenLineRight() {
        // 0 1 1
        row.drawLine(new NaturalNumber(2));

        int target = row.move(1);
        assertEquals(2, target);
    }
}
