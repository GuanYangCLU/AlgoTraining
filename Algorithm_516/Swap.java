
public class Swap <Item>
{
	private Node first;
	private int N;
	private class Node
	{
		Item item;
		Node next;
	}
	public boolean isEmpty()
	{
		return first == null;
	}
	public int size()
	{
		return N;
	}
	public void push(Item item)  // same as 2a and 2b
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop()
	{
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public static void main(String[] args)
	{
		Swap <String> s = new Swap <String>();
		
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-swap"))  // except the switch
			{
				s.push(item);
			}
			else if(!s.isEmpty()&&item.equals("-swap"))  // A switch to control swap
			{
				do
				{
					StdOut.print(s.pop()+ " ");
				}
				while(!s.isEmpty());  // print until stack is empty
			}
						
		}
	}
}
