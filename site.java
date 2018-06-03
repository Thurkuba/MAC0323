public class site {
    boolean sopen, sfull;

    public site(){
	sopen = false;
	sfull = false;
    }
    
    public boolean getSopen(){
	return sopen;
    }

    public boolean getSfull(){
	return sfull;
    }

    public void openSite(){
	sopen = true;
    }

    public void fullSite(){
	sfull = true;

    }

    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	site[] grid = new site[n];
	for(int i = 0; i < n; i++) grid[i] = new site();
	grid[0].openSite();
	boolean eae = grid[0].getSopen();
	
	System.out.println(eae);
    }
}
