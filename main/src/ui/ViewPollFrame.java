package ui;

import model.ListOfPolls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPollFrame extends JDialog implements ActionListener {

    private JList list;


    public ViewPollFrame()  {

        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel(null);

        panel.setBackground(Color.yellow);

        // Components

        list = new JList(ListOfPolls.getListOfTitles().toArray());
        list.setVisibleRowCount(5);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollList = new JScrollPane(list);

        JTextArea viewTitle = new JTextArea("View current polls!");
        viewTitle.setEditable(false);
        viewTitle.setFont(new Font("Calibri", Font.ITALIC, 35));
        viewTitle.setBackground(Color.yellow);

        JButton viewButton = new JButton("View this poll");
        viewButton.addActionListener(this);


        // Setting bounds
        viewTitle.setBounds(100,100,800,50);
        viewButton.setBounds(100,600,200,50);
        scrollList.setBounds(300,200,400,300);

        // Add components
        panel.add(viewTitle);
        panel.add(scrollList);
        panel.add(viewButton);

        setContentPane(panel);

        }

    @Override
    public void actionPerformed(ActionEvent e){
        new ViewSpecificPoll(ListOfPolls.listOfPolls.get(list.getSelectedIndex()));
    }


    }



