package ladder.domain;

class Ladder {
    private Row[] rows;

    Ladder(int countOfRow, int noOfPerson) {
        rows = new Row[countOfRow];
        for (int i = 0; i < countOfRow; i++) {
            rows[i] = new Row(noOfPerson);
        }
    }

    void drawLine(int noOfRow, int startPosition) {
        rows[noOfRow].drawLine(startPosition);
    }

    int run(int nthOfPerson) {
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            nthOfPerson = row.move(nthOfPerson);;
        }

        return nthOfPerson;
    }
}
