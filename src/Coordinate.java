public class Coordinate {
    public int row;
    public int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "<" + row + "," + col + ">";
    }

    // compare coordinates
    public boolean equals(Coordinate c2) {
        return row == c2.row && col == c2.col;
    }
}