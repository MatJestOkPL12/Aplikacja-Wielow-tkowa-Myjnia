package graphics;

import cars.AllCars;
import logic.*;
import washEquipment.Foam;
import washEquipment.Water;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton2 {

    JButton start2 = new JButton("Zacznij Symulacje");
    AllCars allCars;

    public StartButton2(JPanel panel,  AllCars allCars){
        start2.setBounds(160,300, 150, 20);
        this.allCars = allCars;
        panel.add(start2);
        panel.revalidate();
        panel.repaint();

        start2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object controlerLock = new Object();
               final Object  wash1processO = new Object();
               final Object wash2processO = new Object();
               final Object wash3processO = new Object();
                PositionText positionText = new PositionText(panel);
              Wash1 wash1 = new Wash1(panel);
              Wash2 wash2 = new Wash2(panel);
              Wash3 wash3 = new Wash3(panel);
              Water water = new Water();
              Foam foam = new Foam();
              CarsLabel carsLabel = new CarsLabel(allCars, panel);
              Queues queues = new Queues(allCars, panel, carsLabel);
              Controler controler = new Controler(allCars, queues.getQueue1(), queues.getQueue2(), wash1,wash2,wash3, queues, water, foam, controlerLock );
              queues.addCarsToQueue();
              controler.ControlerWork();
              Wash1Procces wash1Procces = new Wash1Procces(wash1,water, foam,controlerLock, controler,wash1processO, wash2processO,allCars);
              wash1Procces.startWash1();
              Wash2Procces wash2Procces = new Wash2Procces(wash2, water,foam,controlerLock,controler,wash1processO,wash3processO, wash2processO,allCars);
              wash2Procces.startWash2();
              Wash3Procces wash3Procces = new Wash3Procces(wash3,water, foam,controlerLock, controler,wash3processO,wash2processO,allCars);
              wash3Procces.startWash3();




            }
        });

    }

}
