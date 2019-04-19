
public class SortTest {
	private static boolean less (double v, double w){
		return v > w;
	}
	
	private static void exch(double[] a, int i, int j){
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void show(double[] a) {  // just for test the sorted array
		for(int i=0;i<a.length;i++){
			StdOut.print(a[i] +" ");
			StdOut.println();
		}
	}
	
	public static boolean isSorted(double[] a){
		for (int i=0;i<a.length;i++)  // not used here, but might be used later
			if (less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static double timeTrial(int N){
		int MAX = 1000000;
		double [] a = new double[N];
		for (int i=0;i<N;i++)
			a[i] = StdRandom.uniform(-MAX, MAX);  // establish a random array to sort
		Stopwatch timer = new Stopwatch();
		// ***pick one sort from the next three lines>> 
		//select(a);
		insert(a);
		//quick(a);
		// ***above are three kinds of sort, compare them
		return timer.elapsedTime();  // record the time
		
	}
	
	public static void select (double[] a){
		int N = a.length;
		for (int i=0;i<N;i++){
			int min = i;
			for (int j=i+1;j<N;j++)
				if (less(a[j],a[min])) min = j;
			exch(a,i,min);			
		}
		
	}
	
	public static void insert (double[] a){
		int N = a.length;
		for (int i=1;i<N;i++){			
			for (int j=i;j>0&&(less(a[j],a[j-1]));j--)
				exch(a,j,j-1);			
		}
	}
	
	public static void quick (double[] a){
		//StdRandom.shuffle(a);  // random array may not need this?
		quick(a,0,a.length-1);
	}
	
	private static void quick(double[] a, int lo, int hi){
		if(hi<=lo) return;
		int j = partition(a,lo,hi);
		quick(a,lo,j-1);
		quick(a,j+1,hi);
	}
	
	private static int partition (double[] a, int lo, int hi){
		int i = lo, j = hi+1;
		double v = a[lo];
		while(true){
			while (less(a[++i], v)) if (i==hi) break;
			while (less(v, a[--j])) if (j==lo) break;
			if (i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	public static void main(String[] args){
		for (int N = 1000; true; N+=N){
			double time = 0, ttime = 0;
			for (int i=0;i<1000;i++){   // do 1000 times and get the average time
				time = timeTrial(N);
				ttime += time;
			}
			StdOut.printf("%7d %5.6f\n", N, ttime/1000);
		}
	}
}
