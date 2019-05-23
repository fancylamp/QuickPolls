package ui;

import model.Currents;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NewsFrame extends JDialog{

    Currents c = new Currents();

    public NewsFrame() {
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.LIGHT_GRAY);

        try{
            c.printCurrents();
        }
        catch(IOException e){
            System.out.println("There was an error printing news.");
            System.exit(0);
        }

        // Components
        JTextArea newsTitle = new JTextArea("Current events around the world!");
        newsTitle.setFont(new Font("Calibri", Font.ITALIC, 35));
        newsTitle.setEditable(false);
        newsTitle.setBackground(Color.LIGHT_GRAY);

        JTextArea newsText = new JTextArea();
        newsText.setLineWrap(true);
        newsText.append("Title: " + c.getListoftitles().get(0) + "\n");
        newsText.append(c.getListofdescs().get(0) + "\n");
        newsText.append("\n");
        newsText.append("\n");
        newsText.append("Title: " + c.getListoftitles().get(1) + "\n");
        newsText.append(c.getListofdescs().get(1) + "\n");
        newsText.append("\n");
        newsText.append("\n");
        newsText.append("Title: " + c.getListoftitles().get(2) + "\n");
        newsText.append(c.getListofdescs().get(2) + "\n");
        newsText.append("\n");
        newsText.append("\n");
        newsText.append("Title: " + c.getListoftitles().get(3) + "\n");
        newsText.append(c.getListofdescs().get(2) + "\n");
        newsText.append("\n");
        newsText.append("\n");
        newsText.append("Title: " + c.getListoftitles().get(4) + "\n");
        newsText.append(c.getListofdescs().get(2) + "\n");
        newsText.setFont(new Font("Calibri", Font.PLAIN, 20));
        newsText.setEditable(false);


        JScrollPane scrollNews = new JScrollPane(newsText);
        scrollNews.setBackground(Color.LIGHT_GRAY);

        // Setting bounds
        scrollNews.setBounds(100,200,800,800);
        newsTitle.setBounds(100,100,800,50);

        // Adding components
        panel.add(newsTitle);
        panel.add(scrollNews);

        setContentPane(panel);

    }


}
