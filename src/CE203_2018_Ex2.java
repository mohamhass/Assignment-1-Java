import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

public class CE203_2018_Ex2 {
    public static void main(String[] args){
        new Frame();
    }

}

class Frame extends JFrame{

    protected JFrame mainframe;
    protected JPanel buttonPanel;
    protected JPanel inputPanel;
    protected JPanel outputPanel;

    LinkedList<String> listOfWords;

    public Frame(){

        //Start of mainframe
        mainframe = new JFrame();

        //Initialising the JPanel's
        buttonPanel = new JPanel();
        inputPanel = new JPanel();
        outputPanel = new JPanel();

        //Initialising the buttons
        JButton add = new JButton("Add to list");
        JButton displayWords = new JButton("Display Words that end with");
        JButton searchList = new JButton("Search");
        JButton removeLastOcc = new JButton("Remove last occurrence");
        JButton removeAllOcc = new JButton("Remove all occurrences");
        JButton clearList = new JButton("Clear");

        //Create constraints for button panel
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbl.setConstraints(buttonPanel ,gbc);
        gbc.gridy = 3;
        gbc.gridx = 3;
        buttonPanel.setLayout(gbl);

        //Add buttons to button panel
        buttonPanel.add(add);
        buttonPanel.add(displayWords);
        buttonPanel.add(searchList);
        buttonPanel.add(removeLastOcc);
        buttonPanel.add(removeAllOcc);
        buttonPanel.add(clearList);

        //New constraints for the inputPanel
        GridBagConstraints gbb = new GridBagConstraints();
        gbb.gridy = 1;

        //extfield for input panel which will live in SOUTH
        JTextField text = new JTextField(10);
        inputPanel.add(text, gbb);


        //CENTER panel for the output uno
        JTextArea outputArea = new JTextArea("CE203 Assignment 1, submitted by: 1605229");
        outputArea.setEditable(false);
        outputPanel.add(outputArea);


        //List initialization and logic
        listOfWords = new LinkedList<String>();
        //add button action listener to take whatever is inside the textbox and add it to the list
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String word = text.getText();
                try {
                    Integer.parseInt(word);
                    outputArea.setText("The string \"" + word + "\" is not a valid word and was not added to the list");
                }
                catch(NumberFormatException ex) {
                    if (!word.equals("")) {
                        listOfWords.add(word);
                        outputArea.setText("Word " + word + " has been added to the list!");
                        text.setText("");
                    }
                    else if(word.equals("")){
                        outputArea.setText("Please enter a word into the textbox below");
                    }
                }
            }
        });

        displayWords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Iterator<String> iter = listOfWords.iterator();
                String words = "";
                while (iter.hasNext()) {
                    String checkString = iter.next();
                    String textinput = text.getText();
                    if (checkString.endsWith(textinput.toLowerCase()) | checkString.endsWith(textinput.toUpperCase()) ){
                        words += "\n" + checkString; }
                }
                outputArea.setText(words);
                text.setText("");
                mainframe.pack();
            }
        });

        searchList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String locations = "";
                int location = -1;
                Iterator<String> iter = listOfWords.iterator();
                int count = 0;
                String textInput = text.getText();
                while (iter.hasNext()){
                    location += 1;
                    String checkString = iter.next();
                    if (checkString.equals(textInput)){
                        count += 1;
                        locations += location + ",";

                    }
                    outputArea.setText(String.valueOf(count));
                }
                outputArea.setText("The word " + textInput + " appears in the list " + count + " times.\n" + "Locations: " + locations);
                text.setText("");
                mainframe.pack();

         }
         });

        removeLastOcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String word = text.getText();
                listOfWords.removeLastOccurrence(word);
                text.setText("");
                outputArea.setText("The last occurrence of " + word + " has been removed.");
                mainframe.pack();

            }
        });

        removeAllOcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String textInput = text.getText();
                Boolean check = listOfWords.removeIf(textInput::equals);
                if(!check){
                    outputArea.setText("Please enter a word that is in the list");
                }
                outputArea.setText("All occurrences of word: " + textInput + " has been removed from the list");
                text.setText("");
                mainframe.pack();

            }
        });

        clearList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listOfWords.clear();
                outputArea.setText("The list of words has been cleared");
                text.setText("");
                mainframe.pack();

            }
        });




         //Add panel to the JFrame and exit on close
         mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         mainframe.add(buttonPanel, BorderLayout.NORTH);
         mainframe.add(inputPanel, BorderLayout.SOUTH);
         mainframe.add(outputPanel, BorderLayout.CENTER);
         mainframe.pack();
         mainframe.setVisible(true);


         }

         }
