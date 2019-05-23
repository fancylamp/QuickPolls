package ui;

import model.Choice;
import model.Poll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePollFrame extends JDialog implements ActionListener {

    JTextField pollTitleIn;
    JTextField pollDescIn;
    JTextField choice1In;
    JTextField choice2In;
    JTextField choice3In;

    public CreatePollFrame() {
        setSize(1000, 1200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);


        JPanel panel = new JPanel(null);
        panel.setBackground(Color.PINK);

        // Components
        JTextArea createTitle = new JTextArea("Create a new poll!");
        createTitle.setEditable(false);
        createTitle.setFont(new Font("Calibri", Font.ITALIC, 35));
        createTitle.setBackground(Color.PINK);

        JTextArea pollTitle = new JTextArea("Title of the poll:");
        pollTitle.setEditable(false);
        pollTitle.setFont(new Font("Calibri", Font.PLAIN, 20));
        pollTitle.setBackground(Color.PINK);

        pollTitleIn = new JTextField();
        pollTitleIn.setFont(new Font("Calibri", Font.PLAIN, 20));

        JTextArea pollDesc = new JTextArea("Description of the poll:");
        pollDesc.setEditable(false);
        pollDesc.setFont(new Font("Calibri", Font.PLAIN, 20));
        pollDesc.setBackground(Color.PINK);

        pollDescIn = new JTextField();
        pollDescIn.setFont(new Font("Calibri", Font.PLAIN, 20));

        JTextArea choice1 = new JTextArea("Choice A:");
        choice1.setFont(new Font("Calibri", Font.PLAIN, 20));
        choice1.setEditable(false);
        choice1.setBackground(Color.PINK);

        choice1In = new JTextField();
        choice1In.setFont(new Font("Calibri", Font.PLAIN, 20));

        JTextArea choice2 = new JTextArea("Choice B:");
        choice2.setFont(new Font("Calibri", Font.PLAIN, 20));
        choice2.setEditable(false);
        choice2.setBackground(Color.PINK);

        choice2In = new JTextField();
        choice2In.setFont(new Font("Calibri", Font.PLAIN, 20));

        JTextArea choice3 = new JTextArea("Choice C:");
        choice3.setFont(new Font("Calibri", Font.PLAIN, 20));
        choice3.setEditable(false);
        choice3.setBackground(Color.PINK);

        choice3In = new JTextField();
        choice3In.setFont(new Font("Calibri", Font.PLAIN, 20));

        JButton createButton = new JButton("Create!");
        createButton.addActionListener(this);


        // Setting bounds
        createTitle.setBounds(100,100,800,50);
        pollTitle.setBounds(100,200,800,50);
        pollTitleIn.setBounds(100,250,800,50);
        pollDesc.setBounds(100,350,800,50);
        pollDescIn.setBounds(100,400,800,50);
        choice1.setBounds(100,500,800,50);
        choice1In.setBounds(100,550,800,50);
        choice2.setBounds(100,650,800,50);
        choice2In.setBounds(100,700,800,50);
        choice3.setBounds(100,800,800,50);
        choice3In.setBounds(100,850,800,50);
        createButton.setBounds(100,1000,300,50);


        panel.add(createTitle);
        panel.add(pollTitle);
        panel.add(pollTitleIn);
        panel.add(pollDesc);
        panel.add(pollDescIn);
        panel.add(choice1);
        panel.add(choice1In);
        panel.add(choice2);
        panel.add(choice2In);
        panel.add(choice3);
        panel.add(choice3In);
        panel.add(createButton);

        setContentPane(panel);



    }

    @Override
    public void actionPerformed(ActionEvent e){
        Poll newPoll = new Poll();
        newPoll.setTitle(pollTitleIn.getText());
        newPoll.setDescription(pollDescIn.getText());
        Choice c1 = new Choice();
        Choice c2 = new Choice();
        Choice c3 = new Choice();
        newPoll.getListOfChoice().add(c1);
        newPoll.getListOfChoice().add(c2);
        newPoll.getListOfChoice().add(c3);
        c1.setDescription(choice1In.getText());
        c2.setDescription(choice2In.getText());
        c3.setDescription(choice3In.getText());
        model.ListOfPolls.listOfPolls.add(newPoll);
        dispose();

    }
}