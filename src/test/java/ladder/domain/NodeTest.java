package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {

    @Test
    void 선이_없는_노드_생성() {
        Node node = Node.createCenterNode();
        assertThat(Node.createCenterNode()).isEqualTo(node);
    }

    @Test
    void 오른쪽으로_상태_변경() {
        Node node = Node.createCenterNode();
        node.changeRight();
        assertThat(Node.createRightNode()).isEqualTo(node);
    }

    @Test
    void 왼쪽으로_상태_변경() {
        Node node = Node.createCenterNode();
        node.changeLeft();
        assertThat(Node.createLeftNode()).isEqualTo(node);
    }

    @Test
    void 오른쪽으로_이동() {
        Node node = Node.createRightNode();
        Marker marker = node.move(new Marker(3));
        assertThat(new Marker(4)).isEqualTo(marker);
    }

    @Test
    void 왼쪽으로_이동() {
        Node node = Node.createLeftNode();
        Marker marker = node.move(new Marker(3));
        assertThat(new Marker(2)).isEqualTo(marker);
    }

    @Test
    void 이동하지않음() {
        Node node = Node.createCenterNode();
        Marker marker = node.move(new Marker(3));
        assertThat(new Marker(3)).isEqualTo(marker);
    }
}
