import java.util.ArrayList;
import java.util.Random;

public class Board {
    private String id = "";
    private int numMoves = 0;
    public int board[][];
    public Coordinate empty;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new int[size][size];
        int num = 1;
        for (int i = 0; i < board.length; i++)
            for (int ii = 0; ii < board[i].length; ii++)
                board[i][ii] = num++;

        board[size-1][size-1] = 0;
        empty = new Coordinate(size-1, size-1);
        update();
    }

    public Board(int[][] b) {
        this.size = b.length;
        board = copy(b);
        update();
    }

    public int[][] copy(int[][] f) {
        int[][] c = new int[f.length][f.length];
        for (int i = 0; i < f.length; i++)
            for (int ii = 0; ii < f[i].length; ii++)
                c[i][ii] = f[i][ii];
        return c;
    }

    public String getID() {
        return id;
    }

    public String update() {
        StringBuilder newID = new StringBuilder();
        for (int i = 0; i < board.length; i++){
            for (int ii = 0; ii < board[i].length; ii++) {
                if (board[i][ii] == 0)
                    empty = new Coordinate(i, ii);
                newID.append(board[i][ii]);
            }
        }
        id = newID.toString();
        return id;
    }

    public void move(Coordinate from) {
        board[empty.row][empty.col] = board[from.row][from.col];
        empty.row = from.row;
        empty.col = from.col;
        board[from.row][from.col] = 0;
        update();
    }

    public Board movec(Coordinate from) {
        Board nboard = new Board(board);
        nboard.move(from);
        nboard.setNumMoves(numMoves+1);
        nboard.update();
        return nboard;
    }

    public ArrayList<Board> availableDirections() {
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
        int count = 1;
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (board[i][ii] != count++ && !(i == board.length-1 && ii == board.length-1))
                    return false;
            }
        }
        return true;
    }

    public int getPercentageSolved() {
        int percent = 0;
        int num = 1;
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (board[i][ii] == num)
                    percent++;
                num++;
            }
        }
        return percent;
    }

    public int getCloseness() {
        // measures closeness of each tile using manhattan distance
        int closenessSum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                int n = board[i][ii];
                int expectedCol = n%4 -1;
                int expectedRow = (int)Math.ceil((double)n/4)-1;
                closenessSum += Math.abs(ii-expectedCol) + Math.abs(i-expectedRow);
            }
        }
        return closenessSum;
    }

    public void setNumMoves(int num) {
        numMoves = num;
    }

    public int getNumMoves() {
        return numMoves;
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
