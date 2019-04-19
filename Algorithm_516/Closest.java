
public class Closest {
	//count accessing times, Section 1 for sorting and Section 2 for finding the closest pair
	public static int copy = 0, move = 0, compare = 0, sep = 0, copy2 = 0, swap2 = 0, compare2 =0;
	private static boolean less (double v, double w){
		return v > w;
	}
	
	private static void exch(double[] a, int i, int j){
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void show(double[] a) {
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
	
	public static void merge (double[] a, int lo, int mid, int hi){
		int i = lo, j = mid+1;   //merge part of top-down merge sort
		double aux[] = new double [a.length];
		for (int k = lo; k<=hi;k++){
			aux[k] = a[k];
			copy++;
		}
		for (int k = lo; k<=hi; k++){
			compare++;
			if (i>mid) {
				a[k] = aux[j++];
				move++;
			}
			else if (j>hi)  {
				a[k] = aux[i++];
				move++;
			}
			else if (less(aux[j], aux[i]))  {
				a[k] = aux[j++];
				move++;
			}
			else  {
				a[k] = aux[i++];
				move++;
			}
			
		}
	}
	
	private static void sort(double[] a, int lo, int hi){
		if (hi<=lo) return;  // separate and conquer
		int mid = lo + (hi-lo)/2;
		sep++;  // separate operation, actually, I found separate doesn't take time
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
		
	}
	
	public static double[] sort(double[] a){
		double[] aux = new double[a.length];
		sort(a,0,a.length-1);
		return a;  // finally pass the sorted array to main method
	}
	
	public static void showMinPair (double a[]){
		double[] a3 = new double[a.length-1];  //section 2: find the closest pair
		int mark = 0;  // a new array of the differences of a[i+1] and a[i]
		for (int i=0;i<a.length-1;i++){
			a3[i] = a[i+1]-a[i];
			copy2++;
		}
		for (int i=1;i<a.length-1;i++){
			compare2++;
			if (a[i]<a[0]) {
				mark = i;
				exch(a,i,0);
				swap2++;
			}
		}
				
		StdOut.println("The closest value pair are "+ a[mark-1] +" and "+ a[mark]);
		StdOut.println("Accessories >> compare: "+compare+" copy: "+copy+" move: "+move+" sep: "+sep);
		StdOut.println("Section 2 for MinPair >> compare: "+compare2+" copy: "+copy2+" swap: "+swap2);
	}
	
	public static void main(String[] args)throws Exception{

		String[] a0 = StdIn.readAllStrings();

		double[] a1 = new double[a0.length];
		for(int i=0;i<a0.length;i++)
			a1[i] = Double.parseDouble(a0[i]);
		double[] a2 = sort(a1);
		//assert isSorted(a);
		//show(a2);  //just test
		showMinPair(a2);	//it would change the element where after the mark to the bot		
		
	}
}
