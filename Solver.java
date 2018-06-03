import edu.princeton.cs.algs4.*;

public class Solver {
    private boolean isSolvable;
    private int totalmoves;
    private searchNode last;
    
    private class searchNode implements Comparable<searchNode>{
	private searchNode previous;
	private Board board;
	private int moves;
	private int priority;

	private searchNode(Board board, int m, searchNode previous){
	    this.previous = previous;
	    this.board = board;
	    this.moves = m;
	    this.priority = board.manhattan() + moves;
	}
	
	public int compareTo(searchNode other) {
            if (this.priority > other.priority) return 1;
            if (this.priority < other.priority) return -1;
            return 0;
	}
    }
    public int moves(){
	return totalmoves;
    }


    private void enqueueNodes(searchNode node, MinPQ<searchNode> pq) {
	for (Board next: node.board.neighbors()) {
	    if ((node.previous == null) || (!next.equals(node.previous.board))) {
		pq.insert(new searchNode(next, node.moves + 1, node));
	    }
	}
    }
	    
    public Solver(Board initial){
	if(initial==null) throw new java.lang.IllegalArgumentException("can't initialize Solver with null Board");
	if(!initial.isSolvable()) throw new java.lang.IllegalArgumentException("Unsolvable Board");
	
	MinPQ<searchNode> pq = new MinPQ<searchNode>();
	searchNode sn = new searchNode(initial, 0, null);
	pq.insert(sn);
	//	searchNode aqui 

    public Iterable<Board> solution() {
        Stack<Board> solution = new Stack<Board>();

	searchNode s = last;
	while (s != null) {
	    solution.push(s.board);
	    s = s.previous;
	}
    
	return solution;
    }

    
    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	int[][] meuboard = new int[n][n];
	for (int j = 0; j < n; j++)
	    for(int i = 0; i < n; i++) meuboard[j][i] = (j*n + i +1);
	meuboard[0][0] = 0;
	meuboard[0][1] = 1;
	meuboard[0][2] = 3;
	meuboard[1][1] = 2;
	meuboard[1][2] = 5;
	meuboard[2][2] = 6;
	Board board = new Board(meuboard);
	Solver solver = new Solver(board);
	//	StdOut.println("Minimum number of moves = " + solver.moves());
	for (Board sboard : solver.solution())
	    StdOut.println(board);
    }
}
