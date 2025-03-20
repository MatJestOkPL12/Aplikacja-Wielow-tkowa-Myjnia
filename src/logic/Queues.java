package logic;

import cars.AllCars;
import cars.Car;
import graphics.CarsLabel;
import graphics.QueueLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Queues {

    public Queues (AllCars allCars, JPanel panel, CarsLabel carsLabel){
        this.allCars = allCars;
        this.panel = panel;
        this.carsLabel = carsLabel;
    }
    CarsLabel carsLabel;
    AllCars allCars;
    JPanel panel;
    List<Car> queue1 = new ArrayList<>();
    List<Car> queue2 = new ArrayList<>();


    public void addCarsToQueue(){
        QueueLabel queueLabel = new QueueLabel(queue1, queue2, panel);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();

                    while (true) {

                        try {
                            Thread.sleep(500 + random.nextInt(1500));

                            Car car = allCars.getCars().get(random.nextInt(allCars.getCars().size()));

                            if (car.getInQueue() == false) {
                                if (queue1.size() == queue2.size()) {
                                    modifyQueue1(car,1);
                                    car.changeQueueStan();
                                } else if (queue1.size() < queue2.size()) {
                                    modifyQueue1(car,1);
                                    car.changeQueueStan();
                                } else {
                                    modifyQueue2(car,1);
                                    car.changeQueueStan();
                                }
                            }



                            queueLabel.uptadeQueue();

                            for(Component component : panel.getComponents()){
                                if(component == null){
                                    continue;
                                }
                                String name = component.getName();
                                if("Pojazdy".equals(name)){
                                    panel.remove(component);
                                }
                            }

                            carsLabel.updateLabel();


                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

            }


        };
        Thread thread = new Thread(task);
        thread.start();



    }


    public List<Car> getQueue1(){
        return queue1;
    }

    public List<Car> getQueue2(){
        return queue2;
    }

    public synchronized void modifyQueue1(Car car, int option ){
        if(option == 1){
            queue1.add(car);
        }
        if(option == 2){
            queue1.remove(car);
        }
    }
    public synchronized void modifyQueue2(Car car, int option){
        if(option == 1){
            queue2.add(car);
        }
        if(option == 2){
            queue2.remove(car);
        }
    }


}
