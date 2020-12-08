import java.util.*;

public class Main {

    private static Board b;
    private static Coordinate empty;

    public static void main(String[] args) {
        b = new Board(4);

        int times = 50;
        Random r = new Random();
        for (int t = 0; t < times; t++) {
            ArrayList<Board> ad = b.availableDirections();
            b = ad.get(r.nextInt(ad.size()));
        }
        b.setNumMoves(0);

        b.print();
        Board solved = solveAS(b);
        solved.print();
    }


    public static Board solveBS(Board b) {
        HashMap<String, Board> memo = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        String id = b.getID();
        memo.put(id, b);
        q.add(id);   // enqueue

        int counter = 0;

        while (!memo.get(id).isSolved()) {
            id = q.remove();  // dequeue

            counter++;

            ArrayList<Board> rand = memo.get(id).availableDirections();
            for (Board rb : rand) {
                if (memo.get(rb.getID()) == null) {
                    String rID = rb.getID();
                    memo.put(rID, rb);
                    q.add(rID);
                }
            }
        }

        System.out.println("Boards looked at: " + counter);
        System.out.println("Number of moves:  " + memo.get(id).getNumMoves());
        return memo.get(id);
    }

    public static Board solveDS(Board b) {
        HashMap<String, Board> memo = new HashMap<>();
        Stack<String> q = new Stack<>();

        String id = b.getID();
        memo.put(id, b);
        q.push(id);   // enqueue

        int counter = 0;

        while (!memo.get(id).isSolved()) {
            id = q.pop();  // dequeue

            counter++;

            // check neighbors
            ArrayList<Board> rand = memo.get(id).availableDirections();
            for (Board rb : rand) {
                if (memo.get(rb.getID()) == null) {
                    String rID = rb.getID();
                    memo.put(rID, rb);
                    q.push(rID);
                    // rb.print();
                }
            }
        }

        System.out.println("Boards looked at: " + counter);
        System.out.println("Number of moves:  " + memo.get(id).getNumMoves());
        return memo.get(id);
    }

    public static Board solveAS(Board b) {
        HashMap<String, Board> memo = new HashMap<>();
        PriorityQueue<Board> q = new PriorityQueue<>(new HeuristicComparator());

        Board cb = b;
        String id = b.getID();
        memo.put(id, cb);
        q.add(cb);   // enqueue

        int counter = 0;

        while (!cb.isSolved()) {
            cb = q.poll();  // dequeue
            id = cb.getID();

            counter++;

            ArrayList<Board> rand = cb.availableDirections();
            for (Board rb : rand) {
                if (memo.get(rb.getID()) == null) {
                    String rID = rb.getID();
                    memo.put(rID, rb);
                    q.add(rb);
                }
            }
        }

        System.out.println("Boards looked at: " + counter);
        System.out.println("Number of moves:  " + memo.get(id).getNumMoves());
        return memo.get(id);
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
