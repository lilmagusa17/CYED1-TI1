package model;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack<String>stackActions;

    public void setUp1(){
        stackActions = new Stack<>();
    }

    public void setUp2(){
        stackActions = new Stack<>();
        stackActions.push(new Actions<>("addTask", "Studying discreetly"));
        stackActions.push(new Actions<>("deleteTask", "Studying discreetly"));
        stackActions.push(new Actions<>("addTask", "Studying all day"));
        stackActions.push(new Actions<>("modifiedTask", "Studying all day", "Going to the gym"));
    }

    @Test
    public void pushActionInStackEmpty(){
        setUp1();
        Actions<String>node = new Actions<>("addTask", "making an integrator");
        stackActions.push(node);

        assertEquals(stackActions.getHead(),node);

    }
    @Test
    public void pushActionNotEmptyStack(){
        setUp2();
        Actions<String>node = new Actions<>("modifiedTask", "making an integrator", "Taking my dogs out");
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
        
       /* boolean isExceptionThrow = false;

        try{
            stackActions.pop();
        }catch (EmptyStackException e){
            isExceptionThrow = true;
        }
        assertFalse(isExceptionThrow);*/

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
