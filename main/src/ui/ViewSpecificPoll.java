package ui;

import model.Poll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSpecificPoll extends JDialog implements ActionListener {

    private Poll viewThisPoll;

    private JButton vote1;
    private JButton vote2;
    private JButton vote3;


    public ViewSpecificPoll(Poll p) {
        viewThisPoll = p;
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel(null);

        panel.setBackground(Color.cyan);

        JTextArea viewTitle = new JTextArea("Vote on this poll!");
        viewTitle.setEditable(false);
        viewTitle.setFont(new Font("Calibri", Font.ITALIC, 35));
        viewTitle.setBackground(Color.cyan);

        JTextArea pollTitle = new JTextArea(viewThisPoll.getTitle());
        pollTitle.setEditable(false);
        pollTitle.setFont(new Font("Calibri", Font.PLAIN, 20));
        pollTitle.setBackground(Color.cyan);


        JTextArea pollDesc = new JTextArea(viewThisPoll.getDescription());
        pollDesc.setEditable(false);
        pollDesc.setFont(new Font("Calibri", Font.PLAIN, 20));
        pollDesc.setBackground(Color.cyan);


        JTextArea choice1 = new JTextArea(viewThisPoll.getChoice(1).getDescription());
        choice1.append("\n");
        choice1.append("Number of votes " + viewThisPoll.getChoice(1).getNumberOfVotes());
        choice1.setFont(new Font("Calibri", Font.PLAIN, 20));
        choice1.setEditable(false);
        choice1.setBackground(Color.cyan);


        JTextArea choice2 = new JTextArea(viewThisPoll.getChoice(2).getDescription());
        choice2.append("\n");
        choice2.append("Number of votes " + viewThisPoll.getChoice(2).getNumberOfVotes());
        choice2.setFont(new Font("Calibri", Font.PLAIN, 20));
        choice2.setEditable(false);
        choice2.setBackground(Color.cyan);


        JTextArea choice3 = new JTextArea(viewThisPoll.getChoice(3).getDescription());
        choice3.append("\n");
        choice3.append("Number of votes " + viewThisPoll.getChoice(3).getNumberOfVotes());
        choice3.setFont(new Font("Calibri", Font.PLAIN, 20));
        choice3.setEditable(false);
        choice3.setBackground(Color.cyan);


        vote1 = new JButton("Vote!");
        vote2 = new JButton("Vote!");
        vote3 = new JButton("Vote!");
        vote1.addActionListener(this);
        vote2.addActionListener(this);
        vote3.addActionListener(this);


        // Setting bounds
        viewTitle.setBounds(100, 100, 800, 50);
        pollTitle.setBounds(100, 200, 800, 50);
        pollDesc.setBounds(100, 350, 800, 50);
        choice1.setBounds(100, 500, 400, 50);
        choice2.setBounds(100, 650, 400, 50);
        choice3.setBounds(100, 800, 400, 50);
        vote1.setBounds(500, 500, 300, 50);
        vote2.setBounds(500, 650, 300, 50);
        vote3.setBounds(500, 800, 300, 50);


        panel.add(viewTitle);
        panel.add(pollTitle);
        panel.add(pollDesc);
        panel.add(choice1);
        panel.add(choice2);
        panel.add(choice3);
        panel.add(vote1);
        panel.add(vote2);
        panel.add(vote3);

        setContentPane(panel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vote1) {
            viewThisPoll.getChoice(1).addNumberOfVotes();
            dispose();
        } else if (e.getSource() == vote2) {
            viewThisPoll.getChoice(2).addNumberOfVotes();
            dispose();
        } else if (e.getSource() == vote3) {
            viewThisPoll.getChoice(3).addNumberOfVotes();
            dispose();
        }

    }
}
