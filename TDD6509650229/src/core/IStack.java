package core;

public interface IStack {
	public int getSize(); //TC1
	public boolean isEmpty(); //TC1
	public void pushStack(Object item) throws Exception; //TC2
	public boolean isFull(); //TC2
	public Object top(); //TC2
	public Object pop(); //TC4
}
