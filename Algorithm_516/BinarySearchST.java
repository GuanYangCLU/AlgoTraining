import java.util.ArrayList;
import java.util.List;

public class BinarySearchST<Key extends Comparable<Key>,Value> {

	private static final int N = 2;
    private Key[] keys;
    private Value[] values;
    private int size=0;
    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys=(Key[]) new Comparable[capacity];
        values=(Value[]) new Object[capacity];//java does not allow generic array
        this.size=0;
    }
  
    public BinarySearchST() {   	
    	this(N);  // for main method to initialize
	}

	public void put(Key key, Value value) {
        if(value==null) {delete(key); return;}

        int pos=rank(key);  //position level of key
        if (pos<size&&keys[pos].compareTo(key)==0) {
            values[pos]=value;
            return;
        }

        if(size==keys.length) resize(2*keys.length);
        for (int i =size; i>pos; i--) {
            keys[i]=keys[i-1];
            values[i]=values[i-1];
        }
        keys[pos]=key;
        values[pos]=value;
        size++; 
    }

	public boolean isEmpty(){
		return size ==0;
	}

    public Value get(Key key) {  //return the value based on key's rank
        if(isEmpty()) return null;
        int pos=rank(key);
        if (pos<size&&keys[pos].compareTo(key)==0) 
            return values[pos];
        else return null;
    }


    public Value delete(Key key) {
        int pos=rank(key);

        if (pos<size&&keys[pos].compareTo(key)!=0) {
            return null;
        }
        Value value = values[pos];
        if(size<keys.length/2) resize(keys.length/2);
        for (int i = pos; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
        return value;
    }


    public int size() {
        return size;
    }

    public Key min() {
        return keys[0];
    }


    public Key max() {
        return keys[size-1];
    }


    public Key floor(Key key) {
        int pos=rank(key);
        if (pos<size&&keys[pos].compareTo(key)==0) {
            return keys[pos];
        }
        return keys[pos-1]; //lower bound
    }


    public Key ceiling(Key key) {
        int pos=rank(key);
        return keys[pos];  // upper bound
    }


    public int rank(Key key) {
        int low=0;
        int high=size-1;
        while (low<=high) {
            int middle=low+(high-low)/2;
            int cmp=key.compareTo(keys[middle]);
            if (cmp<0) high=middle-1;
            else if(cmp>0) low=middle+1;
            else return middle;
        }
        return low;
    }

    public int rank(Key key,int low,int high) {
        if(low>high) return low;
        int pos=rank(key);
        int cmp=key.compareTo(keys[pos]);
        if (cmp>0) return rank(key, pos+1, high);
        else if(cmp<0) return rank(key,low,pos-1);
        else return pos;
    }
    public Key select(int index) {
        return keys[index];
    }

    public Iterable<Key> keys(Key low, Key high) {
        List<Key> keys=new ArrayList<Key>(size);
        for (int i = 0; i <size; i++) {
            keys.add(this.keys[i]);
        }
        return keys;
    }

    @SuppressWarnings("unchecked")
    public void resize(int capacity) {
        Key[] newKeys=(Key[]) new Comparable[capacity];
        Value[] newValues=(Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newKeys[i]=keys[i];
            newValues[i]=values[i];
        }
        keys=newKeys;
        values=newValues;
    }
    
    public static void main(String[] args){
    	
    	String marks  = "A+    A     A-    B+    B     B-    C+    C     C-    D     F";
    	String points = "4.33  4.00  3.67  3.33  3.00  2.67  2.33  2.00  1.67  1.00  0.00";    				
    	String[] keys = marks.split("\\s+"); // regular expression to separate words
    	String[] vals = points.split("\\s+");
    	double[] values = new double[vals.length];
    	for (int i=0; i<vals.length; i++)
    	values[i] = Double.parseDouble(vals[i]); // transfer String to double

    	BinarySearchST<String, Double> GPA = new BinarySearchST<String, Double>();
    	for (int i=0; i<keys.length; i++){
    		GPA.put(keys[i], values[i]);
    	}
    	double grades = 0;
    	int courses = 0;
    	while (!StdIn.isEmpty())		
    	{
    		grades += GPA.get(StdIn.readLine());
    		courses++;
    	}

    	StdOut.printf("GPA: " + "%.3f\n", grades/courses);
    }
}