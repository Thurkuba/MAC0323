import edu.princeton.cs.algs4.*;

public class PointST<Value> {

    private RedBlackBST<Point2D, Value> redblack;

    public PointST() {

	redblack = new RedBlackBST<Point2D, Value>();
    }

    public boolean isEmpty() {

	return redblack.isEmpty();
    }

    public int size() {

	return redblack.size();
    }

    public void put(Point2D p, Value val) {

	verify(p);
	redblack.put(p, val);
    }

    public Value get(Point2D p) {

	verify(p);
	return redblack.get(p);
    }

    private void verify(Point2D p) {

	if(p == null) throw new java.lang.IllegalArgumentException();
    }
      
    public boolean contains(Point2D p) {

	verify(p);
	return (redblack.get(p)!=null);
    }

    public Iterable<Point2D> points() {

	return redblack.keys();
    }

    public Iterable<Point2D> range(RectHV rect) {

	if(rect==null) throw new java.lang.IllegalArgumentException();
	Queue<Point2D> q = new Queue<Point2D>();
	for(Point2D p : redblack.keys()) {

	    if(rect.contains(p)) q.enqueue(p);
	}

	return q;
    }
    
    public Point2D nearest(Point2D p) {

	verify(p);
	Point2D nearest = new Point2D(0, 0);
	for(Point2D q : redblack.keys()) {

	    if(nearest!=null && p.distanceTo(q)<p.distanceTo(nearest)) {
		nearest = q; StdOut.println("nearest = " + nearest.x() + " " + nearest.y());
	    }
	    
	}
	
	return nearest;
    }

    public Iterable<Point2D> nearest(Point2D p, int k) {

	verify(p);
	Queue<Point2D> nearest = new Queue<Point2D>();
	BST<Double, Point2D> bst = new BST<Double, Point2D>();
	for(Point2D q : redblack.keys()) {
	    bst.put(p.distanceTo(q), q);
	}

	for(int i = 0; i < k; i++){
	    nearest.enqueue(bst.get(bst.min()));
	    bst.deleteMin();
	}

	return nearest;
    }

	
    public static void main(String[] args) {

	PointST<String> st = new PointST<String>();
	StdOut.println(st.isEmpty());
	Point2D p = new Point2D(0, 2);
	st.put(p ," bola");
	Point2D q = new Point2D(1, 2);
	st.put(q, "queijo");
	StdOut.println(st.isEmpty());
	StdOut.println(st.get(p));
	StdOut.println(st.get(q));
	Point2D k = new Point2D(2, 3);
	st.put(k, "lalalaue");
	Point2D near = st.nearest(k);
	StdOut.println("haha" + st.get(near));
	StdOut.println("huaehiuhi" + st.get(p));
	RectHV rect = new RectHV(0.0, 0.0, 5.0, 5.0);
	for(Point2D ins : st.range(rect)) {
	    StdOut.println("Esse ponto ta dentro: " + ins.x() + ", " + ins.y());
	}
	StdOut.println("Size: " + st.size());
	StdOut.println("Contem o ponto k?" + st.contains(k));
	Point2D c = new Point2D(4, 4);
	Point2D emvol = new Point2D(5, 5);
	st.put(c, "isaaaae");
	for(Point2D j : st.nearest(emvol, 3)){
		StdOut.println("testete" + j.x() + " " + j.y());
	    }
	
    }
	
}
