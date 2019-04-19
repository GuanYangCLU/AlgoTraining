package test1;
import java.util.*;
import java.math.*;
public class CoachTom {
	private int[] id;
	private int[] sz;
	private static int connection = 0;	
	public CoachTom(int N)
	{
		id = new int[N];
		for (int i=0;i<N;i++) id[i]=i;
		sz = new int[N];
		for (int i=0;i<N;i++) sz[i]=i;
	}
		
	public boolean connected(int p, int q)
	{
		return find(p)==find(q);
	}
	private int find(int p)
	{
		
		while (p!=id[p]) 
		{
			p=id[p];			
		}
		return p;
	}
	public void union(int p, int q)
	{
		int i = find(p);
		int j = find(q);
		if (i==j) 
			{				
				return;
			}
		
		if (sz[i]<sz[j])
		{
			id[i]=j;			
			sz[j]+=sz[i];
			sz[i]=sz[j];
		}
		else
		{
			id[j]=i;			
			sz[i]+=sz[j];
			sz[j]=sz[i];
		}
	}
	
	public static int count(int N)
	{
		if (N<2) return 0;
		else if (N==2) return 1;
		else
		{
			CoachTom ct = new CoachTom(N);		
			for (int i=0;i<N;i++)              
			{
				while (ct.sz[i]==i)
				{
					Random r = new Random();
					int p = r.nextInt(N);
					int q = r.nextInt(N);						
					if (!ct.connected(p, q))
					{
						ct.union(p, q);
						connection++;										
					}
				}
			}										
			return connection;	
		}		
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a positive interger >>");
		int N = input.nextInt();		
		System.out.println("There are " +count(N)+ " connections.");
		
	}
}
