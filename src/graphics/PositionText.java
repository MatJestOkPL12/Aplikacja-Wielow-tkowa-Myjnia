package graphics;

import javax.swing.*;

public class PositionText {

    JLabel label = new JLabel("Stanowiska");

    public PositionText(JPanel panel){

        label.setBounds(190,0, 90, 20);

        panel.add(label);
        panel.revalidate();
        panel.repaint();

    }

}
