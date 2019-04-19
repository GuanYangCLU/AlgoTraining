package test1;

import java.util.Scanner;

public class WQUUF 
{
	private int[] id;
	private int[] sz;
	private int count;
	
	public WQUUF(int N)
	{
		count = 0;
		id = new int[N];
		for (int i=0;i<N;i++) id[i]=i;
		sz = new int[N];
		for (int i=0;i<N;i++) sz[i]=i;
	}
	public int count()
	{
		return count;
	}
	public boolean connected(int p, int q)
	{
		return find(p)==find(q);
	}
	private int find(int p)
	{
		count++;
		while (p!=id[p]) 
		{
			p=id[p];
			count++;
		}
		return p;
	}
	public void union(int p, int q)
	{
		int i = find(p);
		int j = find(q);
		if (i==j) return;
		
		if (sz[i]<sz[j])
		{
			id[i]=j;
			count++;
			sz[j]+=sz[i];			
		}
		else
		{
			id[j]=i;
			count++;
			sz[i]+=sz[j];
		}
	}
	public void print()
	{
		for (int i=0;i<id.length;i++)
		{
			System.out.print(id[i]+" ");
		}
		System.out.println();
		System.out.println("Accessed times: " + count);
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		WQUUF wq = new WQUUF(N);
		while (N>0){
			int p = input.nextInt();
			int q = input.nextInt();
			//if (wq.connected(p, q)) continue;
			wq.union(p, q);
			wq.print();
		}
	}
}
