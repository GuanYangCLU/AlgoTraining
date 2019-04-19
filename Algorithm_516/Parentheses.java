
public class Parentheses <Item>
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
	public int size() // useless for this program but deserves keeping for further development
	{
		return N;
	}
	public void push(Item item)
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

	public static void main (String args[])
	{
		Parentheses <Character> par = new Parentheses <Character>();
		boolean b = false;		
		while (!StdIn.isEmpty())
		{			
			String s0 = StdIn.readString();
			char [] s = new char[s0.length()];
			s = s0.toCharArray();  // the input is hard to use String but easier by charArray
			for (int i=0;i<s.length;i++)
			{
				try{
				//StdOut.print(s[i]);  Track the output of stack
				if (s[i]=='(') par.push(s[i]);
				else if (s[i]=='[') par.push(s[i]);
				else if (s[i]=='{') par.push(s[i]);
				else if (s[i]==')') 
				{
					char p = par.pop();
					if (p=='(') b = true;
					else b = false;
					//StdOut.println(b);  Track the judge of balance
				}
				else if (s[i]==']')
				{
					char p = par.pop();
					if (p=='[') b = true;
					else b = false;
					//StdOut.println(b);  Track the judge of balance
				}
				else if (s[i]=='}')
				{
					char p = par.pop();
					if (p=='{') b = true;
					else b = false;
					//StdOut.println(b);  Track the judge of balance
				}
				}
				catch (Exception e1) // for NullpointerException for ),], and}
				{
					b = false;
					//StdOut.println(b+ "!"); // exception false
					break;
				}
				
			}
			if (!par.isEmpty()) b = false;  // Another condition: lack of right parts
			StdOut.println("Properly balanced? "+b);
			
		}
		
	}
}
