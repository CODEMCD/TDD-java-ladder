package ladder.domain;

import ladder.core.NaturalNumber;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    Marker run(Marker nthOfPerson) {
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            nthOfPerson = row.move(nthOfPerson);
            String result = generate(rows, Position.create(NaturalNumber.createFromArrayIndex(i), nthOfPerson));
            System.out.println(result);
        }
        return nthOfPerson;
    }

    public static String generate(Row[] rows, Position position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            row.generateRow(sb, i, position);
        }
        return sb.toString();
    }
}
