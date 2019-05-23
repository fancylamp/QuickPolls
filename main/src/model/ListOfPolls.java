package model;

import java.io.*;
import java.util.ArrayList;

// Represents the list of polls
public class ListOfPolls implements Serializable {

    private static final long serialVersionUID = 1L;

    public static ArrayList<Poll> listOfPolls = new ArrayList<>();


    public ArrayList<Poll> getListOfPolls(){
        return listOfPolls;
    }

    // EFFECTS: prints out the current polls
    public void printListOfPolls(){

        for (Poll p: listOfPolls){
            System.out.println("Here are the List of Polls");
            System.out.println("Title: " + p.getTitle());
            System.out.println(p.getDescription());
            System.out.println("************************");
        }

    }

    public static ArrayList<String> getListOfTitles(){
        ArrayList<String> listOfTitles = new ArrayList<String>();
        for (Poll p: listOfPolls){
            listOfTitles.add(p.getTitle());
        }
        return listOfTitles;
    }


}
