package ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            model.QuickPolls NewInstance = new model.QuickPolls();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MainMenuFrame("QuickPolls");
                }
            });
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You cant choose choice 0!");
            model.QuickPolls NewInstance = new model.QuickPolls();
            NewInstance.run();
        }

    }

}


