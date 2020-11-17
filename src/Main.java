import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static Coordinate empty;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        int[][] puzzle = new int[4][4];
        int num = 1;
        for (int i = 0; i < puzzle.length; i++)
            for (int ii = 0; ii < puzzle[i].length; ii++)
                puzzle[i][ii] = num++;

        puzzle = new int[][] {
                {1 , 2 , 3 , 4 },
                {5 , 10, 6 , 8 },
                {0 , 9 , 7 , 11},
                {13, 14, 15, 12}
        };

        empty = new Coordinate(1, 2);
        rows = puzzle.length;
        cols = puzzle.length;
    }


    public boolean isSolved(int[][] puzzle) {
        int prev = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int ii = 0; ii < puzzle[i].length; ii++) {
                if (puzzle[i][ii] < prev)
                    return false;
                prev = puzzle[i][ii];
            }
        }
        return true;
    }


    public void move(int[][] puzzle, Coordinate from) {
        puzzle[empty.row][empty.col] = puzzle[from.row][from.col];
        empty.row = from.row;
        empty.col = from.col;
        puzzle[from.row][from.col] = 0;
    }


    public void solveBFS(int[][] puzzle) {
//        Queue<Coordinate> q = new LinkedList<>();
//
//        q.add(empty);   // enqueue
//
//        while (!isSolved(puzzle)) {
//            Coordinate c = q.remove();  // dequeue
//
//            // check neighbors
//            for (int rr = -1; rr <= 1; rr++) {
//                for (int cc = -1; cc <= 1; cc++) {
//                    if (rr*cc != 0)
//                        continue;
//
//                    Coordinate n = new Coordinate(c.row+rr, c.col+cc);
//                    if (n.row == -1 || n.row == rows || n.col == -1 || n.col == cols)
//                        continue;
//
//                    if (m[n.row][n.col] == 0) {
//                        m[n.row][n.col] = m[c.row][c.col] + 1;
//                        q.add(n);
//                    }
//                }
//            }
//        }
    }


    public void solve(int[][] puzzle) {
        // solve like a rubik's cube?
        // solve each row (last row is challenging)

        // heuristic (look ahead)
        //  how close it is to where it is supposed to be
        //

        // make sure you are not in a loop
        //      check that you have not seen this board

        // you only need to keep track of two rows at a time, in order to solve a row
        // for example, if you are solving the first row, you only need to keep track of the moves for
        //      the first and second row
        //      you don't even need to look at the third or fourth row
    }
}
