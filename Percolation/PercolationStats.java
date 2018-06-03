import edu.princeton.cs.algs4.*;

public class PercolationStats {
    int n, trials;
    double[] xt;
    double[] stddev;
    double confidenceLow;
    double confidenceHigh;
    
    public PercolationStats (int n, int trials) {
	validate(n, trials); 
	this.n = n;
	this.trials = trials;
	int gridsize = n*n;
	xt = new double[trials];
	
	for(int i = 0; i < trials; i++){	    
	    Percolation grid = new Percolation(n);
	    while(!grid.percolates()){
		int random = StdRandom.uniform(0, n*n);
		int[] coords = grid.convertindex(random);
		int row = coords[0];
		int col = coords[1];
		if(!grid.isOpen(random)){
		    grid.open(row, col);		    
		}
	    }
	    xt[i] = ((double)grid.opensites)/gridsize; 
	}
    }

    private void validate(int n, int T){
	if(n<=0 || T<=0) throw new java.lang.IllegalArgumentException("n/trials need to be greater than 0");
    }

    public double mean(){
	return StdStats.mean(xt);
	    
    }

    public double stddev(){
	return StdStats.stddev(xt);
    }

    public double confidenceLow(){
	return (mean() - (1.96*stddev())/(Math.sqrt(trials))) ;
    }

    public double confidenceHigh(){
	return (mean() + (1.96*stddev())/(Math.sqrt(trials))) ;
    }

    public static void main(String[] args){
	Stopwatch stop = new Stopwatch();
	int n = Integer.parseInt(args[0]);
	int trials = Integer.parseInt(args[1]);
	PercolationStats teste = new PercolationStats(n, trials);
	StdOut.println("mean = " + teste.mean());
	StdOut.println("stddev = " + teste.stddev());
	StdOut.println("confidenceLow = " + teste.confidenceLow());
	StdOut.println("confidenceHigh = " + teste.confidenceHigh());
	double elapsedtime = stop.elapsedTime();
	StdOut.println("elapsedTime = " + elapsedtime);
    }
}
