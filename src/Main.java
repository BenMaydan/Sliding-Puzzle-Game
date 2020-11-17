public class Main {

    private static Coordinate empty;

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


    public void solve(int[][] puzzle) {
        // solve like a rubik's cube?
        // solve each row (last row is challenging)

        // heuristic (look ahead)
        //  how close it is to where it is supposed to be
        //
    }
}
