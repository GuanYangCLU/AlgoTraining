// For Unordered array
public class PQa6<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N=0;   
	
	public PQa6(int maxN){
		pq = (Key []) new Comparable[maxN];
	}
	
	public boolean isEmpty(){
		return N ==0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key v){
		pq[N++] = v;  // T~O(1)
	}
	
	public Key delMax(){
		Key max = pq[0];
		int m = 0;   // index of max
		for (int i=0;i<N;i++){ // T~O(N) for travel whole array
			if (max.compareTo(pq[i])<0){
				max = pq[i];
				m = i;
			}
		}
		exch(m,N-1);
		return pq[--N];
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
		StdOut.println("Check Unordered Array");
		int n = 0;
		PQa6 <Integer> pq = new PQa6 <Integer>(100);
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
