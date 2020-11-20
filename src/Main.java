import java.util.*;

public class Main {

    private static Coordinate empty;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        Board b = new Board(4);
        solveBFS(b);
        // solveDFS(b);
    }


    public static void solveBFS(Board b) {
        HashMap<String, Board> memo = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        String id = b.getID();
        memo.put(id, b);
        q.add(id);   // enqueue

        while (!memo.get(id).isSolved()) {
            id = q.remove();  // dequeue

            // check neighbors
            for (int rr = -1; rr <= 1; rr++) {
                for (int cc = -1; cc <= 1; cc++) {
                    if (rr*cc != 0)
                        continue;

                    ArrayList<Board> rand = memo.get(id).randomDirection();
                    for (Board rb : rand) {
                        if (memo.get(rb.getID()) == null) {
                            String rID = rb.getID();
                            memo.put(rID, rb);
                            q.add(rID);
                            rb.print();
                            break;
                        }
                    }
                }
            }
        }

        memo.get(id).print();
    }

    public static void solveDFS(Board b) {
        HashMap<String, Board> memo = new HashMap<>();
        Stack<String> q = new Stack<>();

        String id = b.getID();
        memo.put(id, b);
        q.push(id);   // enqueue

        while (!memo.get(id).isSolved()) {
            id = q.pop();  // dequeue

            // check neighbors
            for (int rr = -1; rr <= 1; rr++) {
                for (int cc = -1; cc <= 1; cc++) {
                    if (rr*cc != 0)
                        continue;

                    ArrayList<Board> rand = memo.get(id).randomDirection();
                    for (Board rb : rand) {
                        if (memo.get(rb.getID()) == null) {
                            String rID = rb.getID();
                            memo.put(rID, rb);
                            q.push(rID);
                            rb.print();
                            break;
                        }
                    }
                }
            }
        }

        memo.get(id).print();
    }


    public static void solve(int[][] puzzle) {
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
        //
        // this is assuming you have four of the numbers you need to solve that row somewhere in those two rows
        // but they are not in the correct order
    }
}
