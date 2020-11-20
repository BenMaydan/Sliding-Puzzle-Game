import java.util.ArrayList;

public class Board {
    private String id;
    private int numMoves = 0;
    private int board[][];
    private Coordinate empty;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new int[size][size];
        int num = 1;
        for (int i = 0; i < board.length; i++)
            for (int ii = 0; ii < board[i].length; ii++)
                board[i][ii] = num++;

        board = new int[][] {
                {1 , 2 , 3 , 4 },
                {5 , 10, 6 , 8 },
                {0 , 9 , 7 , 11},
                {13, 14, 15, 12}
        };

        empty = new Coordinate(1, 2);
    }

    public Board(int[][] b) {
        this.size = b.length;
        board = b;
        for (int i = 0; i < b.length; i++) {
            for (int ii = 0; ii < b[i].length; ii++) {
                if (board[i][ii] == 0) {
                    empty = new Coordinate(i, ii);
                    return;
                }
            }
        }
    }

    public int get(Coordinate c) {
        return board[c.row][c.col];
    }

    public String getID() {
        return id;
    }

    private void updateID() {
        String id = "";
        for (int i = 0; i < board.length; i++){
            for (int ii = 0; ii < board[i].length; ii++) {
                id += board[i][ii];
            }
        }
        this.id = id;
    }

    public void move(Coordinate from) {
        board[empty.row][empty.col] = board[from.row][from.col];
        empty.row = from.row;
        empty.col = from.col;
        board[from.row][from.col] = 0;
        updateID();
    }

    public Board movec(Coordinate from) {
        int[][] b = new int[size][size];
        for (int i = 0; i < b.length; i++) {
            for (int ii = 0; ii < b[i].length; ii++) {
                b[i][ii] = board[i][ii];
            }
        }
        Board nboard = new Board(b);
        nboard.move(from);
        return nboard;
    }

    public ArrayList<Board> randomDirection() {
        ArrayList<Board> r = new ArrayList<>();
        if (empty.col > 0)
            r.add(movec(new Coordinate(empty.row, empty.col-1)));
        if (empty.col < size-1)
            r.add(movec(new Coordinate(empty.row, empty.col+1)));
        if (empty.row > 0)
            r.add(movec(new Coordinate(empty.row-1, empty.col)));
        if (empty.row < size-1)
            r.add(movec(new Coordinate(empty.row+1, empty.col)));
        return r;
    }

    public boolean isSolved() {
        int prev = 0;
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (board[i][ii] < prev)
                    return false;
                prev = board[i][ii];
            }
        }
        return true;
    }

    public boolean equals(Board b) {
        return id.equals(b.id);
    }

    public void print() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.printf("%4d", board[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
