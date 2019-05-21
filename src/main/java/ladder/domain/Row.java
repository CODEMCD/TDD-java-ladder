package ladder.domain;

class Row {
    private Node[] nodes;

    Row(NaturalNumber noOfPersons) {
        this.nodes = new Node[noOfPersons.getNumber()];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Node.createCenterNode();
        }
    }

    void drawLine(NaturalNumber startPosition) {
        int startIndex = startPosition.toArrayIndex();
        if (startIndex >= nodes.length - 1) {
            throw new IllegalArgumentException(String.format("시작점은 &d 미만이어야 합니다. 현재 값 : %d", nodes.length - 1, startPosition));
        }

        if(nodes[startIndex].equals(Node.createLeftNode())) {
            throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
        }

        nodes[startIndex].changeRight();
        nodes[startIndex + 1].changeLeft();
    }

    Marker move(Marker startMarker) {
        return nodes[startMarker.toArrayIndex()].move(startMarker);
    }
}
