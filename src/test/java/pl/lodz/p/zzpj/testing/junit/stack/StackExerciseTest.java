package pl.lodz.p.zzpj.testing.junit.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackExerciseTest {
    StackExercise stack;

    @Before
    public void setUp() {
        stack = new StackExercise();
    }

    @Test
    public void pushAndPopOneElementTest() throws StackEmptyException {
        assertTrue(stack.isEmpty());
        stack.push("Witam");
        assertFalse(stack.isEmpty());
        assertEquals("Witam", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void topTest() throws StackEmptyException {
        stack.push("Cos");
        stack.push("Cos2");
        stack.push("Cos3");
        stack.push("Cos4");
        assertEquals("Cos4",stack.top());
        // check second time to see that element is
        // not removed after top
        assertEquals("Cos4",stack.top());
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowStackIsEmptyExceptionAfterTop() throws StackEmptyException {
        stack.top();
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowStackIsEmptyExceptionAfterPop() throws StackEmptyException {
        stack.pop();
    }

}
