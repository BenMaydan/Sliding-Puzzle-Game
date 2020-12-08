import java.util.Comparator;

class HeuristicComparator implements Comparator<Board> {
    public int compare(Board b1, Board b2) {
        // int diff = (b1.getPercentageSolved() + b1.getCloseness()+2*b1.getNumMoves()) - (b2.getPercentageSolved() + b2.getCloseness()+2*b2.getNumMoves());
        int diff = (b1.getCloseness()+2*b1.getNumMoves()) - (b2.getCloseness()+2*b2.getNumMoves());
        return diff;
    }


//    public int compare(String id1, String id2) {
//        int idx1 = id1.indexOf(":");
//        int idx2 = id2.indexOf(":");
//
//        int n1 = Integer.parseInt(id1.substring(0, idx1));
//        int n2 = Integer.parseInt(id2.substring(0, idx2));
//
//        int n3 = Integer.parseInt(id1.substring(idx1+1));
//        int n4 = Integer.parseInt(id1.substring(idx2+1));
//
//        return (n1 + n3) - (n2 + n4);
//    }

//    public int compare(Board b1, Board b2) {
//        String id1 = b1.getID();
//        String id2 = b2.getID();
//        for (int i = 0; i < id1.length(); i++) {
//            int compareTo = id1.substring(i, i+1).compareTo(id2.substring(i, i+1));
//            if (compareTo > 0)
//                return compareTo + b1.getNumMoves();
//            else if (compareTo < 0)
//                return compareTo + b2.getNumMoves();
//        }
//        return 0;
//    }
}
