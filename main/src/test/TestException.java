package test;

import exception.BadInputException;
import model.Poll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.fail;

public class TestException {

    Poll a;

    @BeforeEach
    public void runBefore(){
        a = new Poll();
    }

    @Test
    public void testBadInputExceptionPositive(){
        try{
            a.setTemp(0);
            fail();
        }
        catch(BadInputException e){

        }

    }

    @Test
    public void testBadInputExceptionNegative(){
        try{
            a.setTemp(1);
        }
        catch(BadInputException e){
            fail();
        }
    }


}
