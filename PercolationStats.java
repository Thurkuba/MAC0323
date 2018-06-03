import edu.princeton.cs.algs4.*;

public class PercolationStats {
    int n, trials;
    double[] mean;
    double[] stddev;
    double confidenceLow;
    double confidenceHigh;
    
    public PercolationStats (int n, int trials) {
	validate(n, trials);
	this.n = n;
	this.trials = trials;
	mean = new double[n];
	
	for(int i = 0; i < trials; i++){
	    Percolation grid = new Percolation(n);
	    int x = 0;

	    while(!grid.percolates()){
		int random = StdRandom.uniform(0, n*n);
		grid.open(random);
		x++;
	    }
	    mean[i] = x; StdOut.println(x);
	}
    }

    private void validate(int n, int T){
	if(n<=0 || T<=0) throw new java.lang.IllegalArgumentException("n/trials need to be greater than 0");
    }

    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	int trials = Integer.parseInt(args[1]);
	PercolationStats teste = new PercolationStats(n, trials);

    }
}
