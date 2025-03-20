package logic;

import cars.AllCars;
import cars.Car;
import graphics.Wash1;
import graphics.Wash2;
import graphics.Wash3;
import washEquipment.Foam;
import washEquipment.Water;

import java.util.List;
import java.util.Random;

public class Controler {

    final Object controlerlock;
    Car car;
    List<Car> allCars;
    List<Car> queue1;
    List<Car> queue2;
    Wash1 wash1;
    Wash2 wash2;
    Wash3 wash3;
    Queues queues;
    Water water;
    Foam foam;

    public Controler(AllCars allCars, List<Car> queue1, List<Car> queue2, Wash1 wash1, Wash2 wash2, Wash3 wash3, Queues queues, Water water, Foam foam,Object controlerlock ){
        this.allCars = allCars.getCars();
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.wash1 = wash1;
        this.wash2 = wash2;
        this.wash3 = wash3;
        this.queues = queues;
        this.water = water;
        this.foam = foam;
        this.controlerlock = controlerlock;
    }

    boolean takeFromQ1 = true;
    boolean controlerIsSleeping = false;


    public void ControlerWork(){

        Runnable task = new Runnable() {
            @Override
            public void run() {

                while (true) {

                    try {
                        Thread.sleep(10);

                        synchronized (controlerlock) {

                            if (queue1.isEmpty() && queue2.isEmpty()) {
                                continue;
                            }
                            if (takeFromQ1) {
                                if(!queue1.isEmpty()) {
                                    car = queue1.get(0);
                                    queues.modifyQueue1(car,2);
                                    takeFromQ1 = false;
                                }
                            }
                            if (!takeFromQ1) {
                                if(queue2.isEmpty()){
                                    takeFromQ1 = true;
                                }
                                if(!queue2.isEmpty()) {
                                    car = queue2.get(0);
                                    queues.modifyQueue2(car,2);

                                    takeFromQ1 = true;
                                }
                            }

                            if(car!=null) {
                                goCarToWash(car);
                                car=null;
                            }


                        }


                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }




                }
            }
        };


        Thread thread = new Thread(task);
        thread.start();

    }

    private void goCarToWash(Car car){
        synchronized (controlerlock) {
            if (wash1.getIsEmpty()) {
                wash1.setCarName(car.getName() );
                wash1.addCar(car.getName());
                car.setWashNumber(1);
            } else if ( wash2.getIsEmpty()) {
                wash2.setCurrentCarName(car.getName());
                wash2.addCar(car.getName());
                car.setWashNumber(2);
            } else if (wash3.getIsEmpty()) {
                wash3.setCarName(car.getName());
                wash3.addCar(car.getName());
                car.setWashNumber(3);
            } if(!wash1.getIsEmpty() && !wash2.getIsEmpty() && !wash3.getIsEmpty()) {
                try {
                    controlerIsSleeping = true;
                    controlerlock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }


    public boolean getContolerStan(){
        return controlerIsSleeping;
    }
    public void changeControlerStan(){
        if(controlerIsSleeping){
            controlerIsSleeping = false;
        }
        else {
            controlerIsSleeping = true;
        }
    }



}
