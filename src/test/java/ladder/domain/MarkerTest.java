package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkerTest {
    @Test
    void 오른쪽_이동() {
        Marker marker = new Marker(3);
        assertThat(new Marker(4)).isEqualTo(marker.moveRight());
    }

    @Test
    void 왼쪽_이동() {
        Marker marker = new Marker(3);
        assertThat(new Marker(2)).isEqualTo(marker.moveLeft());
    }
}
