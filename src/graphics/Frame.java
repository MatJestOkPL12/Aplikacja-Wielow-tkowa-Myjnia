package graphics;

import javax.swing.*;

public class Frame {

    JFrame frame = new JFrame();

    public Frame(){
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        StartedPanel startedPanel = new StartedPanel(frame);
        StartInfoLabel startInfoLabel = new StartInfoLabel(startedPanel.started);
        Choice choice = new Choice(startedPanel.started);
        StartButton button = new StartButton(startedPanel.started, choice, frame);

    }

}
