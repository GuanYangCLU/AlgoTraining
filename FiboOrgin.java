public class fbnc{
	public static void main(String[] args) {
		int n = 10
		System.out.println(fib(n));

		// int a=0, b=1;
		// for (i=0;i<100;i++){
		// 	a=a+b;
		// 	b=b+a;
		// 	System.out.println(a+" "+b)
		// }

	}
	public int fib(int n){
		if (n<2) return n;
		else return(fib(n-1)+fib(n-2));
	}
}