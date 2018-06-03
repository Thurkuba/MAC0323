import edu.princeton.cs.algs4.*;

public class KdTreeST<Value> {

    private int size;
    private Node root;
    
    private class Node {
	private Point2D p;     
	private Value val;   
	private RectHV rect;    
	private Node lb;       
	private Node rt;
	private boolean vert; //Orientacao: se True, vertical. Se False, horizontal.

	public Node(Point2D p, Value val, boolean vert) {
	    this.p = p;
	    this.val = val;
	    this.vert = vert;
	   
	}

	//	public double getx() {
	//	    return p.x();
	//	}

	//	public double gety() {
	//	    return p.y(); 
	//	}

	public boolean vert(){
	    return vert;
	}

	private int compareTo(Point2D q){ 
	    int cmp = 0;
	    this.p = p; //   Point2D point = this.p;
	    if(vert()){
		if(p.x() > q.x()) cmp = -1;
		else if (p.x() < q.x()) cmp = +1;
	    }
	    else
		if(p.y() > q.y()) cmp = -1;
		else if (p.y() < q.y()) cmp = +1;
    
	    return cmp;
	}
	
    }

    public KdTreeST() {
	this.size=0;
    }
    
    private void incsize(){
	size++;
    }
    
    public boolean isEmpty() {

	return (root==null);
    }

    public int size() {
	
	return size;
    }

    public void put(Point2D p, Value val) {

	if (p == null) throw new IllegalArgumentException();
      
        
        if(isEmpty()) root = put(root, p, val, true);
	else root = put(root, p, val, root.vert());

       
    }

    private Node put(Node x, Point2D p, Value val, boolean vert){
        
	if(x == null){incsize(); return new Node (p, val, vert);}
        
	int cmp = x.compareTo(p);
	
        
	if (cmp < 0) x.lb = put(x.lb, p, val, !vert);
	else if (cmp >= 0 && !(x.p.x()==p.x()&&x.p.y()==p.y())) x.rt = put(x.rt, p, val, !vert);
	else x.val = val; 
        
	return x;
	
    }
    //compara um nó e um ponto, levando em consideração se o nó é vertical ou horizontal. Retorna 1 para qdo o nó é maior que o ponto.

    public Value get(Point2D p){
	verify(p);
	return get(root, p);
    }

    private Value get(Node x, Point2D p){
	verify(p);
	if (x == null) return null;
	int cmp = x.compareTo(p);

	if (cmp < 0) return get(x.lb, p); 
	else if (cmp > 0) return get(x.rt, p);
	else{StdOut.println("vert de " +x.val + "-- "+ x.p.x() + " " + x.p.y() + " :"+ x.vert()); return x.val;}
    }

    public boolean contains(Point2D p) {

	verify(p);
	return (get(p)!=null);
    }

    public Iterable<Point2D> points() {
	Queue<Point2D> queue = new Queue<Point2D>();
	Node x = root;
	while(x!=null){
	    queue.enqueue(x.p);
	    x = x.lb;
	}
	return queue;
    }

    public Iterable<Point2D> range(RectHV rect) {
	if(rect==null) throw new java.lang.IllegalArgumentException();
	Queue<Point2D> queue = new Queue<Point2D>();
	Node x = root;
	while(x!=null){
	    queue.enqueue(x.p);
	    x = x.lb;
	}
	return queue;
    }

    public Iterable<Point2D> nearest(Point2D p, int k) {
	verify(p);
	if(k<=0) throw new java.lang.IllegalArgumentException();
	Queue<Point2D> queue = new Queue<Point2D>();
	Node x = root;
	while(x!=null&&k>0){
	    queue.enqueue(x.p);
	    x = x.lb;
	    k--;
	}
        return queue; 
    }

    
    private void verify(Point2D p) {

	if(p == null) throw new java.lang.IllegalArgumentException();
    }

    public static void main(String[] args){
	KdTreeST<String> kd = new KdTreeST<String>();
	Point2D p = new Point2D(3, 1);
	Point2D p1 = new Point2D(0, 2);
	Point2D p2 = new Point2D(7, 5);
	Point2D p3 = new Point2D(10, 1);
	Point2D p4 = new Point2D(4, 3);
	kd.put(p,"haha");
	kd.put(p1,"VAAAAAAAAAAAAAAAAAI");
	kd.put(p2,"TESEEEEEE");
       	kd.put(p3,"124555a");
	kd.put(p4,"p4");

	
	StdOut.println(kd.get(p));
	StdOut.println(kd.get(p1));
	StdOut.println(kd.get(p2));
	StdOut.println(kd.get(p3));
	StdOut.println(kd.get(p4));
	StdOut.println(kd.size());

    }
}
