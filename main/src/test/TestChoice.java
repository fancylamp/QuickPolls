package test;

import model.Choice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestChoice {


    @Test
    public void TestGetDescription(){
        Choice c = new Choice();
        c.setDescription("How many people are European?");
        assertEquals("How many people are European?",c.getDescription());
    }

    @Test
    public void TestGetNumberOfVotes(){
        Choice c = new Choice();
        c.setNumberOfVotes(25000);
        assertEquals(25000,c.getNumberOfVotes());

    }

}
