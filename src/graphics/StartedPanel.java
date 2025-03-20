package graphics;

import javax.swing.*;

public class StartedPanel {
    JPanel started = new JPanel();

    public StartedPanel(JFrame frame){
        started.setLayout(null);
        frame.add(started);
        frame.revalidate();
        frame.repaint();
    }

    public JPanel getPanel(){
        return started;
    }
}
