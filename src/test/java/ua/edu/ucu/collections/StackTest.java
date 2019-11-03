package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.push(112);
        assertEquals(112, stack.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmpty() {
        Stack stack = new Stack();
        stack.peek();
    }

    @Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push(112);
        stack.push(113);
        assertEquals(113, stack.peek());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        stack.push(112);
        stack.push(113);
        assertEquals(113, stack.peek());
        Object popped = stack.pop();
        assertEquals(112, stack.peek());
        assertEquals(113, popped);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmpty() {
        Stack stack = new Stack();
        stack.pop();
    }
}
