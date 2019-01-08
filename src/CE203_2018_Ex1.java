/* Some problems that I still have is the fact that is a user types a zero before the number they
 wish to type then the program will take any number input.
 The validation still works but that's just weird*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CE203_2018_Ex1 {

    public static void main(String[] args) {
        RGBTextFrame frame = new RGBTextFrame();
    }
}

class RGBTextFrame extends JFrame{
    protected JFrame frame;

    public RGBTextFrame(){
        frame = new JFrame("CE203_2018_Ex1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Create a JPanel and add the JLabel (defaults to the center with GridBagLayout)
        JPanel text_panel = new JPanel();
        text_panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 1;

        JLabel assignment_id = new JLabel("CE203 Assignment 1, submitted by: 1605229");
        JLabel catch_invalidField = new JLabel("");
        text_panel.add(assignment_id);
        text_panel.add(catch_invalidField, gbc);

        //Define the text fields
        JTextField red = new JTextField("0", 5);
        JTextField green = new JTextField("0", 5);
        JTextField blue = new JTextField("255", 5);

        //Set the default values for the assignment_id
        assignment_id.setForeground(new Color(0,0,255));

        //Create JLabels for the text above textbox
        JLabel red_label = new JLabel("Red:");
        JLabel green_label = new JLabel("Green:");
        JLabel blue_label = new JLabel("Blue:");
        JLabel space = new JLabel("");

        //Create JButton and attach the action listener
        JButton button = new JButton("Confirm");

        //Define the JPanel for the textbox and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,4));
        //add the text, textboxes and the button
        panel.add(red_label);
        panel.add(green_label);
        panel.add(blue_label);
        panel.add(space);
        panel.add(red);
        panel.add(green);
        panel.add(blue);
        panel.add(button);


        //Add actionlistener to button to get int value when button clicked
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Declaration of the color int values
                int red_value = 0;
                int green_value = 0;
                int blue_value = 255;
                boolean failed = false;
                //Checking which textbox is at fault by checking which causes the exception
                String whoisit = "";

                try {
                    red_value = Integer.parseInt(red.getText());
                    //Validation checking
                    if (red_value > 255) {
                        red_value = 255;
                        red.setText("255");
                    } else if (red_value < 0) {
                        red_value = 200;
                        red.setText("200");
                    }
                }
                    catch(IllegalArgumentException ex){
                        failed = true;
                        //Clear the text field if an Illegal argument in entered and add a warning
                        red.setText("");
                        whoisit += "Red";
                        catch_invalidField.setText("\nPlease enter a number into " + whoisit);
                    }

                    try {
                        green_value = Integer.parseInt(green.getText());
                        //Validation checking
                        if (green_value > 255) {
                            green_value = 255;
                            green.setText("255");
                        } else if (green_value < 0) {
                            green_value = 200;
                            green.setText("200");
                        }
                    } catch (IllegalArgumentException ex){
                        failed = true;
                        //Clear the text field if an Illegal argument in entered and add a warning
                        green.setText("");
                        if (whoisit.contains("Red")){whoisit += " and ";}
                        whoisit += "Green";
                        catch_invalidField.setText("\nPlease enter a number into " + whoisit);
                    }
                    try{
                    blue_value = Integer.parseInt(blue.getText());
                    //Validation checking
                    if (blue_value > 255){
                        blue_value = 255;
                        blue.setText("255");
                    }
                    else if (blue_value < 0){
                        blue_value = 200;
                        blue.setText("200");
                    }

                }
                catch (IllegalArgumentException ex){
                        failed = true;
                    //Clear the text field if an Illegal argument in entered and add a warning
                    blue.setText("");
                    if (whoisit.contains("Red") | whoisit.contains("Green")){whoisit += " and ";}
                    whoisit += "Blue";
                    catch_invalidField.setText("\nPlease enter a number into " + whoisit);
                }
                    if (!failed){
                    catch_invalidField.setText("");}
                    assignment_id.setForeground(new Color(red_value, green_value, blue_value));


            }
        });


        //New panel and actionlistener for reset button
        JButton reset_button = new JButton("Reset");
        reset_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                red.setText("");
                green.setText("");
                blue.setText("");
                catch_invalidField.setText("");
                assignment_id.setForeground(new Color(0, 0, 255));
            }
        });


        // These need to always ba last otherwise the textbox and stuff will not show unless resized
        frame.setSize(500,500);
        frame.add(reset_button, BorderLayout.NORTH);
        frame.add(text_panel, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

}