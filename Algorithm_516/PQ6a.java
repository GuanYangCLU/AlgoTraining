// For Ordered array
public class PQ6a<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N=0;   
	
	public PQ6a(int maxN){
		pq = (Key []) new Comparable[maxN];
	}
	
	public boolean isEmpty(){
		return N ==0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key v){
		pq[N++] = v;
		for (int i=0;i<N;i++){					
				for (int j = i;j>0 && less(j,j-1);j--){					
					exch(j,j-1);	// T~O(N) because for each step it was sorted			
				}			
		}	
	}
	
	public Key delMax(){
		return pq[--N];    // T~O(1)
	}
	
	private boolean less(int i, int j){
		return (pq[i].compareTo(pq[j])<0);
	}
	
	private void exch (int i, int j){
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	public void show(){
		for (int i=0;i<N;i++)
			StdOut.print(pq[i] + " ");
		StdOut.println();
	}
	
	
	public static void main(String args[]){
		StdOut.println("Check Ordered Array");
		int n = 0;
		PQ6a <Integer> pq = new PQ6a <Integer>(100);
		while(!StdIn.isEmpty()){
			pq.insert(StdIn.readInt());	
			n++;
		}
		pq.show();  // show Phase I
		StdOut.println("Current Size: " + pq.size());
		pq.insert(55);
		pq.show();  // show Phase II
		StdOut.println("Current Size: " + pq.size());
		pq.insert(100);
		pq.show();  // show Phase III
		StdOut.println("Current Size: " + pq.size());
		StdOut.println("Max Value: " + pq.delMax());
		pq.show();  // show Phase IV
		StdOut.println("Current Size: " + pq.size());
	}
}
