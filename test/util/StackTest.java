package model;

import org.junit.jupiter.api.Test;
import util.Stack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack<String, String, String> stackActions;

    public void setUp1(){
        stackActions = new Stack<>();
    }

    public void setUp2(){
        stackActions = new Stack<>();
        stackActions.push(new Actions<>("addTask", new HashNode<>("1", "Studying discreetly")));
        stackActions.push(new Actions<>("deleteTask", new HashNode<>("2", "Studying discreetly")));
        stackActions.push(new Actions<>("addTask", new HashNode<>("3", "Studying all day")));
        stackActions.push(new Actions<>("modifiedTask", new HashNode<>("3", "Studying all day"), new HashNode<>("3", "Going to the gym")));
    }

    @Test
    public void pushActionInStackEmpty(){
        setUp1();
        Actions<String, String, String>node = new Actions<>("addTask", new HashNode<>("1", "making an integrator"));
        stackActions.push(node);

        assertEquals(stackActions.getHead(),node);

    }
    @Test
    public void pushActionNotEmptyStack(){
        setUp2();
        Actions<String, String, String>node = new Actions<>("modifiedTask", new HashNode<>("1", "making an integrator"), new HashNode<>("1", "Taking my dogs out"));
        stackActions.push(node);

        assertEquals(stackActions.getTail(),node);

    }

    @Test
    public void isEmptyStack(){
        setUp1();
        boolean isEmpty = stackActions.isEmpty();
        assertTrue(isEmpty);
    }

    @Test
    public void notIsEmptyStack(){
        setUp2();
        boolean isEmpty = stackActions.isEmpty();
        assertFalse(isEmpty);

    }

    @Test
    public void popActionInStack(){
        setUp2();

        assertEquals(stackActions.getTail(), stackActions.pop());



    }

    @Test
    public void popActionInStackEmpty(){
        setUp1();
        boolean isExceptionThrow = false;

        try {
            stackActions.pop();
        }catch (EmptyStackException e){
            isExceptionThrow = true;
        }
        assertTrue(isExceptionThrow);

    }

    @Test
    public void topActionInStack(){
        setUp2();
        assertEquals(stackActions.getTail(), stackActions.top());
    }

    @Test
    public void topActionInStackEmpty(){
        setUp1();
        boolean isExceptionThrow = false;

        try {
            stackActions.pop();
        }catch (EmptyStackException e){
            isExceptionThrow = true;
        }
        assertTrue(isExceptionThrow);

    }
}
