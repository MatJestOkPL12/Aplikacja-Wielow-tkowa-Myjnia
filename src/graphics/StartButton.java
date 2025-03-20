package graphics;

import cars.AllCars;
import logic.Queues;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton {
    JButton start = new JButton("Start");
    JFrame frame;
    public StartButton (JPanel panel, Choice choice, JFrame frame){
        start.setBounds(200,300, 80, 20);
        panel.add(start);
        panel.revalidate();
        panel.repaint();
        AllCars allCars = new AllCars(choice, panel);
        this.frame = frame;

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = allCars.makeCars();

                if(choice == 1){
                    ApplicationPanel applicationPanel = new ApplicationPanel(frame, panel);
                    StartButton2 startButton2 = new StartButton2(applicationPanel.applicationPanel, allCars);

                }

            }
        });

    }

}
