package util;

import org.junit.jupiter.api.Test;
import model.Actions;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack<String, String> stackActions;

    public void setUp1(){
        stackActions = new Stack<>();
    }

    public void setUp2(){
        stackActions = new Stack<>();
        stackActions.push("addTask",  "Studying discreetly");
        stackActions.push("deleteTask", "Studying discreetly");
        stackActions.push("addTask", "Studying all day");
        stackActions.push("modifiedTask", "Studying all day", "Going to the gym");
    }

    @Test
    public void pushActionInStackEmpty(){
        setUp1();
        stackActions.push("addTask", "making an integrator");

        assertEquals(stackActions.getHead(),stackActions.top());

    }
    @Test
    public void pushActionNotEmptyStack(){
        setUp2();
        stackActions.push("modifiedTask", "Studying all day", "making an integrator");

        assertEquals(stackActions.getTail(), stackActions.top());

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
