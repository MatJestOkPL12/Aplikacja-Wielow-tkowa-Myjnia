package graphics;

import javax.swing.*;

public class StartInfoLabel {

    JLabel startedInfo = new JLabel("<html>Wybierz ilość samochodów w symulacji<br>" +
            "Minimalna ilość wynosi 1, maksymalna to 26<html>");


    public StartInfoLabel(JPanel panel){
        startedInfo.setBounds(110, 70, 300, 200);
        panel.add(startedInfo);
        panel.revalidate();
        panel.repaint();
    }

}
