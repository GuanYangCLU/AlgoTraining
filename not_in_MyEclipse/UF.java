package test1;

import java.util.Scanner;

public class UF {
	private int [] id;
	private int count;
	public UF (int N)
	{
		count = 0;
		id = new int[N];
		for (int i=0;i<N;i++)
		{
			id[i] = i;
		}
	}
	public int count()
	{
		return count;
	}
	public boolean connected (int p, int q)
	{
		return find(p) == find(q);
	}
	public int find(int p)
	{
		return id[p];
	}
	public void union(int p, int q)
	{
		int pID = find(p);
		count++;
		int qID = find(q);
		count++;
		
		if (pID == qID) return;
		
		for (int i=0;i<id.length;i++)
		{
			count++;
			if (id[i] == pID) 
			{
				id[i] = qID;
				count++;
			}
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
		UF uf = new UF(N);
		while (N>0){
			int p = input.nextInt();
			int q = input.nextInt();
			//if (uf.connected(p, q)) continue;
			uf.union(p, q);
			uf.print();
		}
	}
}