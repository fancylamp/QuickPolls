package model;

import exception.BadInputException;
import exception.PoorTitleException;

import java.io.*;
import java.util.Scanner;

// Represents a QuickPolls instance
public class QuickPolls {

    ListOfPolls lop = new ListOfPolls();


    // EFFECTS: Runs the QuickPolls program
    public void run() {
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("To begin, please select one of the following options.");
        System.out.println("Enter \"N\" to view current events!");
        System.out.println("Enter \"A\" to view current active polls.");
        System.out.println("Enter \"C\" to create a new poll.");
        System.out.println("Enter \"X\" to exit.");
        Scanner select = new Scanner(System.in);
        String menuChoice = select.next();
        if (menuChoice.equals("A")) {
            viewActivePoll();
        } else if (menuChoice.equals("C")) {
            createNewPoll();
        } else if (menuChoice.equals("X")) {
            writeToFile();
            System.exit(0);
        }else if (menuChoice.equals("N")){
            Currents newCurrents = new Currents();
            try{
                newCurrents.printCurrents();
            }
            catch(IOException e){
                System.out.println("There was an error printing news.");
                mainMenu();
            }
            System.out.println("Enter \"X\" to exit.");
            Scanner subinput = new Scanner(System.in);
            String submenuChoice = subinput.nextLine();
            if (submenuChoice.equals("X")){
                mainMenu();
            }
        } else {
            System.out.println("Sorry, this input is not recognized.");
            mainMenu();
        }
    }

    // MODIFIES: listOfPolls
    // EFFECTS: adds a new poll to the list of polls
    public void createNewPoll() {
            Poll newPoll = new Poll();
            try{
                newPoll.initiateAdvancedPoll();
            }
            catch(BadInputException e){
                System.out.println(e.getMessage());
                mainMenu();
            }
            catch(PoorTitleException e){
                System.out.println(e.getMessage());
                mainMenu();
            }
            finally{
            lop.getListOfPolls().add(newPoll);
            }

        System.out.println("Your poll has been created. You will now be returned to the main menu.");
        System.out.println("*****************************");
        System.out.println("*****************************");
        System.out.println("*****************************");
        mainMenu();
    }

    // EFFECTS: displays the list of polls
    public void viewActivePoll() {
        Scanner input = new Scanner(System.in);
        System.out.println("Here are the current active polls");
        lop.printListOfPolls();

            System.out.println("Enter the number of the poll to vote, modify, or react to it.");
            int temp = input.nextInt();
            try {
                System.out.println("Here is the poll you chose!");
                Poll selectedPoll = lop.getListOfPolls().get(temp - 1);
                System.out.println("*****************************");
                System.out.println(selectedPoll.getDescription());
                selectedPoll.printListOfChoices();
                System.out.println("The number of likes on this poll " + selectedPoll.getNumLikes());
                System.out.println("The number of likes on this poll " + selectedPoll.getNumDislikes());
                System.out.println("*****************************");
                System.out.println("Enter \"R\" to react, \"V\" to vote");
                Scanner input2 = new Scanner(System.in);
                String pollChoice = input2.nextLine();
                if (pollChoice.equals("R")) {
                    System.out.println("Enter \"L\" to like, \"D\" to dislike, anything else to return to main");
                    if (input2.nextLine().equals("L")) {
                        selectedPoll.addNumLikes();
                    }
                    else if (input2.nextLine().equals("D")) {
                        selectedPoll.addNumDislikes();
                    }
                    else mainMenu();
                } else if (pollChoice.equals("V")) {

                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("You cant choose Choice 0!");
                mainMenu();
            }
        mainMenu();
    }

    // I/O implementation using Serializable to store objects
    public void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Java Projects\\projectw1_team466\\main\\ListStorageFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lop);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Written current list of polls into storage.");
    }

    public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Java Projects\\projectw1_team466\\main\\ListStorageFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ListOfPolls readList = (ListOfPolls) ois.readObject();
            lop = readList;
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Read list of polls from storage");
    }

}
