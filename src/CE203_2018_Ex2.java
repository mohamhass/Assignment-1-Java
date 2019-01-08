import javax.swing.*;
import java.awt.*;

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

    public Frame(){
        mainframe = new JFrame();

        //Initialising the JPanel's
        buttonPanel = new JPanel();
        inputPanel = new JPanel();
        outputPanel = new JPanel();

        //Initialising the buttons
        JButton add = new JButton("Add to list");
        JButton displayWords = new JButton("Display Words");
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

        //Buttons nd textfield for input panel which will live in SOUTH
        JButton confirm = new JButton("Confirm");
        JTextField text = new JTextField(10);
        inputPanel.add(text, gbb);
        inputPanel.add(confirm, gbb);


        //CENTER panel for the output uno
        JTextArea outputArea = new JTextArea("Hello, World!");
        outputArea.setEditable(false);
        outputPanel.add(outputArea);


        //Add panel to the JFrame and exit on close
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.add(buttonPanel, BorderLayout.NORTH);
        mainframe.add(inputPanel, BorderLayout.SOUTH);
        mainframe.add(outputPanel, BorderLayout.CENTER);
        mainframe.pack();
        mainframe.setVisible(true);


    }

}
