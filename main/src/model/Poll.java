package model;

import exception.BadInputException;
import exception.PoorTitleException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// Represents a Poll
public class Poll implements Serializable {

    private String title;

    private String description;

    private ArrayList<Choice> listOfChoice = new ArrayList<Choice>();

    private int numLikes = 0;

    private int numDislikes = 0;


    int temp;


    public ArrayList<Choice> getListOfChoice(){
        return listOfChoice;
    }


    // EFFECTS: sets the temp number
    public void setTemp(int x) throws BadInputException{
        if(x==0){
            throw new BadInputException("Cannot set 0 choices!");
        }
        else{
            temp = x;
        }
    }

    // EFFECTS: returns the number of likes
    public int getNumLikes(){return numLikes;}


    // EFFECTS: returns the number of dislikes
    public int getNumDislikes(){return numDislikes;}



    // EFFECTS: adds 1 to the number of likes
    public void addNumLikes(){numLikes++;}


    // EFFECTS: adds 1 to the number of dislikes
    public void addNumDislikes(){numDislikes++;}



    // REQUIRES: numberOfChoices > 0
    // MODIFIES: listOfChoices
    // EFFECTS: adds a number of choices with description to the list
    public void addChoice(int numberOfChoices){
        for (int i = 0; i < numberOfChoices; i++){
            Scanner input = new Scanner(System.in);
            Choice newChoice = new Choice();
            System.out.println("Please write a short description for this choice.");
            newChoice.setDescription(input.nextLine());
                listOfChoice.add(newChoice);
        }
    }


    public void newList(){
        listOfChoice = new ArrayList<>();
    }

    public void initiateAdvancedPoll() throws BadInputException, PoorTitleException {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to title this new poll?");
        String tempTitle = input.nextLine();
        if (tempTitle.length() > 15){
            throw new PoorTitleException("Your title is too long! Try to stay under 15 characters.");
        } else {
            setTitle(tempTitle);
        }
        System.out.println("Please write a short description of the poll you would like to construct.");
        setDescription(input.nextLine());
        System.out.println("Please indicate the number of choices you would like your poll to have.");
        newList();
        setTemp(input.nextInt());
            addChoice(temp);
            System.out.println("There are " + getListSize() + " choices to your poll.");
            System.out.println("Your choices for this poll are:");
            printListOfChoices();

    }

    public Choice getChoice(int i){
        return listOfChoice.get(i-1);
    }

    public void setTitle(String s){
        this.title = s;
    }

    public String getDescription(){
        return description;
    }

    public String getTitle(){
        return title;
    }

    public void setDescription(String s){
        this.description = s;
    }

    public int getListSize(){
        return listOfChoice.size();
    }

    public void printListOfChoices(){
        for (Choice c:listOfChoice){
            System.out.println(c.getDescription());
            System.out.println("");
        }
    }
}
