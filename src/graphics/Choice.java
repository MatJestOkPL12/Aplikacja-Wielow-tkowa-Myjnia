package graphics;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Choice {
    JTextField choice = new JTextField("Tu wpisz ilość");

    public Choice(JPanel panel){

        choice.setBounds(170, 230, 150, 20);

        panel.add(choice);
        panel.revalidate();
        panel.repaint();

        choice.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (choice.getText().equals("Tu wpisz ilość")) {
                    choice.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (choice.getText().isEmpty()) {
                    choice.setText("Tu wpisz ilość");
                }
            }
        });
    }

    public String getNumberOfCars(){

        return choice.getText();
    }

}
