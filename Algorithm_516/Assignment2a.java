

public class Assignment2a <Item>
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
	public void push(Item item)   // push them into stack
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop()   // pop out from the last element
	{
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public static void main(String[] args)
	{
		Assignment2a <String> s = new Assignment2a<String>();  // generic is convenient
		
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-")&&!item.equals("???"))
			{
				s.push(item);
			}
			else if(!s.isEmpty()&&!item.equals("???"))
			{
				StdOut.print(s.pop()+ " ");
			}
			else if (item.equals("???"))  // set a switch to show the number of elements
			{
				StdOut.println("( "+ s.size() + " left on stack)");
			}			
		}
		//StdOut.println("( "+ s.size() + " left on stack)");   // didn't work
	}
}

