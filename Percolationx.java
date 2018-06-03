import edu.princeton.cs.algs4.*;

public class Percolation {
    WeightedQuickUnionUF UF;
    int n;
    int opensites;
    int top;
    boolean[][] opened;
    
    public Percolation (int n) {
	this.n = n;
	top = 0;
	validate(n);
	int count = n*n;
	opensites = 0;
	UF = new WeightedQuickUnionUF(count+1);
	opened = new boolean[n][n];
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++) {opened[i][j] = false;} 
	for (int k = 0; k < n; k++) UF.union(k, top); ***** 
    }

    public boolean isOpen(int row, int col){
	return opened[row][col];
    }

    public boolean isOpen(int index){
	int[] coords = convertindex(index);
	int row = coords[0];
	int col = coords[1];
	return opened[row][col];
    }

    public void open(int row, int col){
	validate(row, col);
	if(!isOpen(row, col)){
	    opensites++;
	    opened[row][col] = true;	
	    int index = convertindex(row, col);
	    unionNeighbors(index);
	}
    }

    public void open(int index){
	int[] coords = convertindex(index);
	int row = coords[0];
	int col = coords[1];
	open(row, col);
    }
	    
    public void unionNeighbors(int index){ ***
	int[] coords = convertindex(index);
	int row = coords[0]; 
	int col = coords[1];
	
	if(check(row-1, col)){
	    if(UF.find(index)<n||UF.find(convertindex(row-1, col))<n){
		UF.union(convertindex(row-1, col), top); 
	}
			    
	if(check(row+1, col)){
	    if(UF.find(index)<n||UF.find(convertindex(row+1, col))<n){
		UF.union(convertindex(row+1, col), top); 
		}
	}
	if(check(row, col-1)){
	    if(UF.find(index)<n||UF.find(convertindex(row, col-1))<n){
		UF.union(convertindex(row, col-1), top); 
		}
	}
	if(check(row, col+1)){
	    if(UF.find(index)<n||UF.find(convertindex(row, col+1))<n){
		UF.union(convertindex(row, col+1), top);
		}
	}
    }
    	    				    
    private boolean check(int row, int col){

	if(row>=0 && row<=n-1 && col>=0 && col<=n-1 && opened[row][col])
	   
	    return true;
	
	return false;
    }
    
    public boolean isFull(int row, int col){
        int index = convertindex(row, col);
	if (UF.find(index)==top) return true;
	return false;
    }

    public int numberOfOpenSites(){
        return opensites;
    }

    public boolean percolates(){
	for(int i = n*n-1; i >= n*n - n; i--){
	    if(UF.find(i)==top) return true; **
	}
	return false;
    }
     
    public int convertindex(int row, int col){
	validate(row, col); 
	int index = row*this.n + col;
	return index;
    }

    public int[] convertindex(int index){
	validate(index);
	int[] coords = new int[2];
	coords[0] = index/this.n; 
	coords[1] = index%this.n;
	return coords;
    }

    private void validate(int row, int col){
	if(row>=n||row<0||col<0||col>=n) throw new java.lang.IllegalArgumentException("Row/Col is not between 0 and " + n);
    }

    private void validate(int p){
	if(p < 0 || p >= n*n) throw new java.lang.IllegalArgumentException("Index out of range");
    }
	    
    public static void main(String[] args){
	int k = Integer.parseInt(args[0]);
	Percolation meugrid = new Percolation(k);
        		
    }
    
}
