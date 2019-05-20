package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RowTest {
    @Test
    void moveWhenNoLine() {
        Row row = new Row(3);
        int target = row.move(0);
        assertEquals(0, target);

        target = row.move(2);
        assertEquals(2, target);
    }

    @Test
    void moveWhenLineLeft() {
        // 0 1 1
        Row row = new Row(3);
        row.drawLine(1);

        int target = row.move(2);
        assertEquals(1, target);
    }

    @Test
    void moveWhenLineRight() {
        // 0 1 1
        Row row = new Row(3);
        row.drawLine(1);

        int target = row.move(1);
        assertEquals(2, target);
    }
}
