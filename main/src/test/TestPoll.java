package test;

import model.Poll;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPoll {

    @Test
    public void TestGetTitle(){
        Poll p = new Poll();
        p.setTitle("Cars");
        assertEquals("Cars",p.getTitle());

    }

    @Test
    public void TestGetListSize0(){
        Poll p = new Poll();
        p.newList();
        p.addChoice(0);
        assertEquals(0,p.getListSize());
    }

    @Test
    public void TestGetListSize2() {
        Poll p = new Poll();
        p.newList();
        p.addChoice(2);
        assertEquals(2, p.getListSize());
    }





}
