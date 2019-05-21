package ladder.domain;

import ladder.core.NaturalNumber;
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
    void moveWhenNoLine() {
        NaturalNumber target = row.move(new Marker(1));
        assertEquals(1, target.getNumber());

        target = row.move(new Marker(2));
        assertEquals(2, target.getNumber());
    }

    @Test
    void moveWhenLineLeft() {
        // 0 1 1
        row.drawLine(new NaturalNumber(2));

        NaturalNumber target = row.move(new Marker(3));
        assertEquals(2, target.getNumber());
    }

    @Test
    void moveWhenLineRight() {
        // 0 1 1
        row.drawLine(new NaturalNumber(2));

        NaturalNumber target = row.move(new Marker(2));
        assertEquals(3, target.getNumber());
    }
}
