package model;

import org.junit.jupiter.api.Test;
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
}
