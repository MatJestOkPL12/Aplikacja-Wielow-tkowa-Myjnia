package graphics;

import javax.swing.*;

public class ApplicationPanel {

    JPanel applicationPanel = new JPanel();

    public ApplicationPanel(JFrame frame, JPanel panel){

        applicationPanel.setLayout(null);

        frame.remove(panel);
        frame.add(applicationPanel);
        frame.revalidate();
        frame.repaint();

    }

}
