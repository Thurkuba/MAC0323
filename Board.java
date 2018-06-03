import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.lang.System;

public class Board {
    int[][] tiles;
    
    public Board(int[][] tiles){
	//	if(n>=2&&n<=32768)
	this.tiles = tiles;
	//	else throw new java.lang.IllegalArgumentException("n need to be between 2 and 32768");
    }

    public String toString(){
	StringBuilder boardstr = new StringBuilder();
        boardstr.append(" " + size() + "\n");
	for (int[] linhas : tiles) {
	    for (int num : linhas) {
		if(num<10)
		    boardstr.append("  " + num);
		else
		    boardstr.append(" " + num);
	    }
	    boardstr.append("\n");
	}
	String boardfinal = boardstr.toString();
	return boardfinal;
     
    }
    

    public int tileAt(int row, int col){
	int n = size();
	if(row>=n||row<0||col>=n||col<0)
	    throw new java.lang.IllegalArgumentException("row and col must be between 0 and n-1");
        else return tiles[row][col];
	    
	
    }

    public int size(){
    return tiles[0].length;
	
    }

    public int hamming(){
	int ham = 0;
	int n = size();
        for (int i = 0; i < n; i++)
	    for(int j = 0; j < n; j++)
		if (tiles[i][j] != i*n + j + 1) ham++;
	ham--;
	return ham;
    }

    public int manhattan(){
	int manht = 0;
	int n = size();
	for (int i = 0; i < n; i++)
	    for(int j = 0; j < n; j++){
		int m = tiles[i][j];
		if (m!=0)
		    manht += Math.abs(i - righti(m)) + Math.abs(j - rightj(m));
	    }
	return manht;
    }

    private int righti(int m){
	m--;
	int n = size();
	int i = m/n;
	return i;
    }

    private int rightj(int m){
	m--;
	int n = size();
	int j = m%n;
	return j;
    }

    public boolean isGoal(){
	return (hamming() == 0 && manhattan() == 0);
    }

    public boolean equals(Object y){
	Board that = (Board) y;
	int ysize = that.size();
        if (y == null) return false;
        if (this == y) return true;
        if (this.getClass() != y.getClass()) return false;
        if (size() != ysize) return false;
        
        return Arrays.deepEquals(this.tiles, that.tiles );
    }

    public boolean isSolvable(){
	int inv = inversions();
	int n = size();
	int blankrow = findblank()[0];
	if (n%2==1){
	    if (inv%2==0) return true;
	}
	else
	    if ((inv+blankrow)%2==1) return true;
	return false;		
    }

    private int[] findblank(){
	int n = size();
	int[] pos = new int[2];
	for(int i = 0; i < n; i++)
	    for(int j = 0; j < n; j++)
		if(tiles[i][j] == 0){
		    pos[0] = i;
		    pos[1] = j;
		    return pos;
		}
	return pos;
    }
    
    private int inversions(){ 
	int n = size();
	int[] array = new int[n*n];
	int k = 0;
	int inv = 0;
	for (int i = 0; i < n; i++)
	    for(int j = 0; j < n; j++){
		array[k] = tiles[i][j];
		k++;
	    }	
	for(int a = 0; a < n*n; a++)
	    for(int p = a + 1; p < n*n; p++)
		if (array[a] > array[p] && array[p] != 0) inv++;
	return inv;
		
    }

    public Iterable<Board> neighbors(){
	Stack<Board> boards = new Stack<Board>();
	int blankpos[] = findblank();
	int zeroRow = blankpos[0];
	int zeroCol = blankpos[1];
	int n = size();

	
	if(zeroRow > 0){
	    Board boardUP = new Board(swap(tiles,-1,0));
	    boards.push(boardUP);
	}
      
	if(zeroRow < n-1){
	    Board boardDown = new Board(swap(tiles,1,0));
	    boards.push(boardDown);
	}
      
	if(zeroCol > 0){
	    Board boardLeft = new Board(swap(tiles,0,-1));
	    boards.push(boardLeft);
	}
      
	if(zeroCol < n-1){
	    Board boardRight = new Board(swap(tiles,0,1));
	    boards.push(boardRight);
	}

	return boards;
    }

    private int[][] swap(int[][] board, int rowOffset, int colOffset){
	int[][] tempBoard =  deepCopy(board);
	int[] blankpos = findblank();
	int zeroRow = blankpos[0];
	int zeroCol = blankpos[1];
	tempBoard[zeroRow][zeroCol]= tiles[zeroRow+rowOffset][zeroCol+colOffset];
	tempBoard[zeroRow+rowOffset][zeroCol+colOffset]=0;

	return tempBoard;
    }

    private int[][]deepCopy(int[][] array){
	int n = size();
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] =array[i][j];
            }
        }
        return copy;
    }
    
    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	int[][] meuboard = new int[n][n];

       
	for (int j = 0; j < n; j++)
	    for(int i = 0; i < n; i++) meuboard[j][i] = (j*n + i +1);
	meuboard[0][0] = 2;
	meuboard[0][1] = 1;
	meuboard[1][1] = 0;
	meuboard[1][2] = 5;
	meuboard[2][1] = 8;
	meuboard[2][2] = 6;
	Board board = new Board(meuboard);
	String aueaue = board.toString();
	StdOut.println("Primeiro Board: \n" + aueaue);

	int[][] meuboard2 = new int[n][n];
	for (int j = 0; j < n; j++)
	    for(int i = 0; i < n; i++) meuboard2[j][i] = (j*n + i +1);
	
	for(Board vizinho : board.neighbors()){
	    StdOut.println(vizinho.toString());
	}

	StdOut.println(board.isSolvable());
    }
}
