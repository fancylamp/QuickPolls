package model;

import java.io.Serializable;

// Represents a Choice
public class Choice implements Serializable {

    private String description;

    private int numberOfVotes = 0;

    // EFFECTS: returns the number of votes
    public int getNumberOfVotes(){
        return numberOfVotes;
    }

    // MODIFIES: this
    // EFFECTS: set the number of votes to an int
    public void setNumberOfVotes(int votes){
        numberOfVotes = votes;
    }

    // EFFECTS: returns the choice description
    public String getDescription(){
        return description;
    }

    // MODIFIES: this
    // EFFECTS: changes the description
    public void setDescription(String description){
        this.description = description;
    }

    // MODIFIES: this
    // EFFECTS: adds 1 to the number of votes
    public void addNumberOfVotes(){
        numberOfVotes++;
    }

    // MODIFIES: this
    // EFFECTS: adds 5 votes
    public void addFiveVotes(){
        numberOfVotes = numberOfVotes + 5;
    }
}