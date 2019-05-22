package ladder.domain;

import java.util.Objects;

class Node {

    private enum Direction {
        LEFT(-1), RIGHT(1), CENTER(0);

        private int symbol;

        private Direction(int symbol) {
            this.symbol = symbol;
        }
    }

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    void changeRight() {
        this.direction = Direction.RIGHT;
    }

    void changeLeft() {
        this.direction = Direction.LEFT;
    }

    boolean isLeftDirection() {
        return this.direction == Direction.LEFT;
    }

    boolean isRightDirection() {
        return this.direction == Direction.RIGHT;
    }

    Marker move(Marker marker) {
        if (isRightDirection()) {
            return marker.moveRight();
        }
        if (isLeftDirection()) {
            return marker.moveLeft();
        }
        return marker;
    }

    static Node createCenterNode() {
        return new Node(Direction.CENTER);
    }

    static Node createRightNode() {
        return new Node(Direction.RIGHT);
    }

    static Node createLeftNode() {
        return new Node(Direction.LEFT);
    }

    public void appendSymbol(StringBuilder sb) {
        sb.append(direction.symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return direction == node.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
