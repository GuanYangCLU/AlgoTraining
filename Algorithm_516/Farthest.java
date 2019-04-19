
public class Farthest {
	
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
		
		public static void showMaxPair (double a[]){
			int compare = 0, swap = 0;    // count the access times
			for (int i=0;i<a.length;i++){
				compare++; 
				if (a[i]<a[0]) {
					//min value to bot
					exch(a,i,0);
					swap++;
				}
			}
			for (int i=a.length-1;i>0;i--){
				compare++; 
				if (a[i]>a[a.length-1]) {
					//max value to top
					exch(a,i,a.length-1);
					swap++;
				}
			}
					
			StdOut.println("The farthest value pair are "+ a[0] +" and "+ a[a.length-1]);
			StdOut.println("Accessories >> compare: "+compare+" swap: "+swap);
		}
		
		public static void main(String[] args)throws Exception{

			String[] a0 = StdIn.readAllStrings();

			double[] a1 = new double[a0.length];
			for(int i=0;i<a0.length;i++)
				a1[i] = Double.parseDouble(a0[i]);
			
			showMaxPair(a1);	//it would change the element where after the mark to the bot		
			
		}
}
