
public class CutoffInsert {
	public static int M = 30;
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
	
	public static double timeTrial(int N){       //  time it***
		int MAX = 1000000;
		double [] a = new double[N];
		for (int i=0;i<N;i++)
			a[i] = StdRandom.uniform(-MAX, MAX);  // establish a random array to sort
		Stopwatch timer = new Stopwatch();
		cutoff(a);
		return timer.elapsedTime();  // record the time
		
	}
	
	public static void insert (double[] a, int lo, int hi){
		//int N = a.length;
		for (int i=lo+1;i<hi;i++){			
			for (int j=i;j>0&&(less(a[j],a[j-1]));j--)
				exch(a,j,j-1);			
		}
	}
	
	public static void cutoff (double[] a){
		//StdRandom.shuffle(a);  
		//int M = 30;
		if (a.length>M) quick(a,0,a.length-1);
		else insert(a,0,a.length-1);
	}
	
	private static void quick(double[] a, int lo, int hi){
		if(hi<=lo) return;
		//int M = 30;
		int j = partition(a,lo,hi);
		if ((j-1-lo)>M) quick(a,lo,j-1);
		else insert(a,lo,j-1);
		if ((hi-j-1)>M) quick(a,j+1,hi);
		else insert(a,j+1,hi);
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
		for (M=30;M>1;M--){
			for (int N = 1000; N<2000000; N*=10){  // N
				double time = 0, ttime = 0;
				for (int i=0;i<1000;i++){   // do 1000 times and get the average time
					time = timeTrial(N);
					ttime += time;
				}
				StdOut.printf("%4d %7d %5.6f\n", M, N, ttime/1000);
			}
		}
	}
}
