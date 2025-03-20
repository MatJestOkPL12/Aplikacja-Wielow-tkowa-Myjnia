package logic;

import cars.AllCars;
import cars.Car;
import graphics.Wash1;
import graphics.Wash2;
import graphics.Wash3;
import washEquipment.Foam;
import washEquipment.Water;

import java.util.List;

public class Wash3Procces {

    private int state =0;
    private int afterFirstWater = 1;
    private int afterFirsFoam = 2;
    private int afterSecondWater = 0;

    public static boolean isSleep = false;
    Wash3 wash3;
    Water water;
    Foam foam;

    Object lock;
    Object controlerLock;
    Controler controler;
    final Object wash2process;
    AllCars allCars;
    List<Car> cars;
    Car car;



    public Wash3Procces(Wash3 wash3, Water water, Foam foam, Object controlerLock, Controler controler, Object lock, Object wash2process, AllCars allCars) {
        this.wash3 = wash3;
        this.water = water;
        this.foam = foam;
        this.controlerLock = controlerLock;
        this.controler = controler;
        this.lock = lock;
        this.wash2process = wash2process;
        this.allCars = allCars;
        cars = allCars.getCars();

    }

    public void startWash3() {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {


                    synchronized (lock) {
                        while (true) {
                            Thread.sleep(1);
                            if (wash3.getIsEmpty()) {
                                continue;
                            } else {

                                if (water.getSecondStatus()) {
                                    isSleep = true;
                                    lock.wait();
                                } else {
                                    lock.wait(1000);
                                    String name = wash3.getCurrentCarName();
                                    for(int i = 0; i<cars.size(); i++){
                                        if(cars.get(i).getName().equals(name)){
                                            car = cars.get(i);
                                        }
                                    }
                                    switch (state) {
                                        case (0): {
                                            water.changeStatusSecondWater();
                                            wash3.waterOn(name);

                                            lock.wait(1500);
                                            water.changeStatusSecondWater();
                                            wash3.waterOff(name);
                                            unlockWash2();
                                            state = afterFirstWater;
                                        }break;

                                        case (1): {
                                            if (foam.getSecondStatus()) {
                                                isSleep = true;
                                                lock.wait();
                                            } else {
                                                foam.changeStatusSecondFoam();
                                                wash3.foamOn(name);
                                                lock.wait(1500);
                                                wash3.foamOff(name);
                                                foam.changeStatusSecondFoam();
                                                unlockWash2();
                                                state = afterFirsFoam;
                                            }
                                        }break;
                                            case(2): {

                                                if (water.getSecondStatus()) {
                                                    isSleep = true;
                                                    lock.wait();
                                                } else {
                                                    water.changeStatusSecondWater();
                                                    wash3.waterOn(name);
                                                    lock.wait(1500);
                                                    wash3.waterOff(name);
                                                    water.changeStatusSecondWater();
                                                    unlockWash2();
                                                    lock.wait(500);
                                                    wash3.carLeaving(name);
                                                    car.changeQueueStan();
                                                    state = afterSecondWater;
                                                }
                                            }break;
                                        }
                                    }
                                        if(controler.controlerIsSleeping) {
                                            synchronized (controlerLock) {
                                                controlerLock.notify();
                                            }


                                        }

                                    }


                                }

                            }
                        } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }

        };

        Thread thread = new Thread(task);
        thread.start();

    }



    private void unlockWash2(){

        if(Wash2Procces.isSleep){
        synchronized (wash2process) {
            Wash2Procces.isSleep = false;
            wash2process.notify();
        }

        }
    }


}
