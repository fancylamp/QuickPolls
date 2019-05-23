package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame implements ActionListener {

    private JButton createButton;
    private JButton viewButton;
    private JButton newsButton;

    public MainMenuFrame(String title){
        super(title);
        setSize(1000,1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        JPanel panel = new JPanel(null);
        panel.setBackground(Color.white);

        // Components
        JTextArea welcomeMessage = new JTextArea("Welcome to QuickPolls!");
        welcomeMessage.setFont(new Font("Calibri", Font.BOLD, 40));
        welcomeMessage.setEditable(false);
        JTextArea subMessage = new JTextArea("To begin, select one of the following options:");
        subMessage.setEditable(false);
        subMessage.setFont(new Font("Calibri",Font.PLAIN,28));

        createButton = new JButton("Create a new poll");
        createButton.addActionListener(this);
        viewButton = new JButton("View existing polls");
        viewButton.addActionListener(this);
        newsButton = new JButton("View current events");
        newsButton.addActionListener(this);

        // Setting bounds
        welcomeMessage.setBounds(300,100,400,75);
        subMessage.setBounds(250,200,525,50);
        createButton.setBounds(400,400,200,50);
        viewButton.setBounds(400,600,200,50);
        newsButton.setBounds(400,800,200,50);


        // Adding components
        panel.add(welcomeMessage);
        panel.add(subMessage);
        panel.add(createButton);
        panel.add(viewButton);
        panel.add(newsButton);

        setContentPane(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == createButton){
            new CreatePollFrame();
        }
        else if (e.getSource() == viewButton){
            new ViewPollFrame();
        }
        else if (e.getSource() == newsButton){
            new NewsFrame();
        }
    }





}
