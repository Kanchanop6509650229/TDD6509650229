package core;

public class Stack implements IStack{
	
	private int size;
	private Object[] stack;
	private int top;
	
	public Stack(int size) {
		if(size < 0) {
			this.size = 0; 
		} else {
			this.size = size;
		}
		stack = new Object[this.size];
		top = -1;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return top == -1? true:false;
	}

	@Override
	public void pushStack(Object item) throws Exception{
		if(!isFull() && isEmpty()) {
			stack[++top] = item;
		} else if(!isFull() && !isEmpty()) {
			if(item.getClass() == top().getClass()) {
				stack[++top] = item;
			} else {
				throw new Exception("All elements in the stack must be of the same type.");
			}
		} else {
			throw new Exception("Stack is full");
		}
	}

	@Override
	public boolean isFull() {
		return top == size-1? true:false;
	}

	@Override
	public Object top(){
		return !isEmpty() ?  stack[top] : null;
	}
	
	@Override
	public Object pop() {
		return !isEmpty() ?  stack[top--] : null;
	}
	
}
