package core;

import junit.framework.TestCase;

public class StackTestCases extends TestCase {
	
	Object testElement1 = 10.5f;
	Object testElement2 = 22.99f;
	Object testElement3 = "Hello World";
	Object testElement4 = "test";
	Object testElement5 = 5;
	Object testElement6 = 52.12f;
	
	//TC1
	public void testCreateNewEmptyStack(){
		Stack s1 = new Stack(5);
		
		/*check that new created s1 is empty*/
		assertEquals(true, s1.isEmpty());
	}
	
	//TC2
	public void testPushElmToNonFullStack() {
		Stack s2 = new Stack(5);
		
		/*check that s2 is not full*/
		assertEquals(false, s2.isFull());
	    
	    /*test for TC2 "push elm to nonfull stack"*/
	    try {
	        s2.pushStack(testElement1);
	        s2.pushStack(testElement2);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }    
	    
	    /*test for TC2 "elm must be on top of stack"*/
	    assertEquals(22.99f, s2.top()); //22.99f(latest input) must be on top of stack
	    //assertEquals(testElement1, s2.top()); //uncomment this line to check if the stack was correct this will return error
	}
	
	//TC3
	public void testSameObjectOnTop() {
		Stack s3 = new Stack(5);
		
		try {
	        s3.pushStack(testElement3);
	        s3.pushStack(testElement4);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }   
		
		/*check that top type is same as last pushed*/
		assertEquals(testElement3.getClass(), s3.top().getClass());
		assertEquals(testElement4.getClass(), s3.top().getClass());
		//assertEquals(testElement5.getClass(), s3.top().getClass()); //uncomment this line to check if the stack was correct this will return error
	    
		/*test for TC3 "if it not same object with the top elm it will get exception and error message"*/
	    try {
	    	s3.pushStack(testElement5);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }  
	}
	
	//TC4
	public void testLIFO() {
		Stack s4 = new Stack(3);
		
		try {
	        s4.pushStack(testElement1);
	        s4.pushStack(testElement2);
	        s4.pushStack(testElement6);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }
		assertEquals(52.12f, s4.top()); //Check that top stack must be latest element that was push to stack	
		assertEquals(52.12f, s4.pop()); //Check that pop element must be latest element that was push to stack
		assertEquals(22.99f, s4.pop()); //Check that pop element must be the same as current top element before pop
		assertEquals(10.5f, s4.pop()); //Check that if we pop 2 element the first push element must be remain in stack
		
		try {
	        s4.pushStack(testElement2);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }
		assertEquals(testElement2, s4.top()); //Check that last push elm must be on top of stack
	}
	
	//TC5
	public void testLimitStack() {
		Stack s5 = new Stack(4); //Create stack that can contain 3 elements
		Stack s6 = new Stack(8); //Create stack that can contain 8 elements
		
		assertEquals(4, s5.getSize()); //Check that s5 size must be 3
		assertEquals(8, s6.getSize()); //Check that s6 size must be 8
		
		/*If input 3 element in s5, stack should be full*/
		try {
	        s5.pushStack(testElement1);
	        s5.pushStack(testElement2);
	        s5.pushStack(testElement6);
	        s5.pushStack(testElement2);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }
		assertEquals(true, s5.isFull()); 
		
		/*Check that if try to add more element it will send exception*/
		try {
	        s5.pushStack(testElement1);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }
		assertEquals(22.99f, s5.top()); //Check that top element should be last element that input before the stack was full
	}
}
