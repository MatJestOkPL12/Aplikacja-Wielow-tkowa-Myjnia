package graphics;

import javax.swing.*;
import java.awt.*;

public class WrongChoiceLabel {

    JLabel wrongChoice = new JLabel("Podana liczba musi byc większa niż 0 oraz mniejsza niż 27");

    public WrongChoiceLabel(JPanel panel){

        wrongChoice.setBounds(80,350,400, 50);

        wrongChoice.setForeground(Color.RED);

        panel.add(wrongChoice);
        panel.revalidate();
        panel.repaint();


    }

}
