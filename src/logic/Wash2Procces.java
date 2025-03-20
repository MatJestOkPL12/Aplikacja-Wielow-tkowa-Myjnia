package logic;

import cars.AllCars;
import cars.Car;
import graphics.Wash1;
import graphics.Wash2;
import washEquipment.Foam;
import washEquipment.Water;

import java.util.List;

public class Wash2Procces {

    private int waterCounter = 0;
    private int foamCounter = 0;
    public static boolean isSleep = false;
    Wash2 wash2;
    Water water;
    Foam foam;
    Object controlerLock;
    Controler controler;
    Object unlock;
    final Object startWash1;
    final Object startWash3;
    AllCars allCars;
    List<Car> cars;
    Car car;


    public Wash2Procces(Wash2 wash2, Water water, Foam foam, Object controlerLock, Controler controler, Object startWash1, Object startWash3, Object startWash2, AllCars allCars) {
        this.wash2 = wash2;
        this.water = water;
        this.foam = foam;
        this.controlerLock = controlerLock;
        this.controler = controler;
        this.unlock = startWash2;
        this.startWash1 = startWash1;
        this.startWash3 = startWash3;
        this.allCars = allCars;
        cars = allCars.getCars();

    }

    public void startWash2() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                synchronized (unlock) {
                    while (true) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if(wash2.getIsEmpty()){
                            continue;
                        }

                        if (water.getFirstStatus() && water.getSecondStatus()) {
                            try {
                                isSleep = true;
                                unlock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        } else {
                            String name = wash2.currentCarName;
                            for(int i = 0; i<cars.size(); i++){
                                if(cars.get(i).getName().equals(name)){
                                    car = cars.get(i);
                                }
                            }
                            if (!water.getFirstStatus()) {
                                try {
                                    water.changeStatusFirstWater();
                                    wash2.startWater1();
                                    Thread.sleep(1500);
                                    wash2.stopWater1();
                                    water.changeStatusFirstWater();
                                    waterCounter++;
                                    if(tryLeave()){
                                        continue;
                                    }
                                    startWash1();
                                    if (foam.getFirstStatus() && foam.getSecondStatus()) {
                                        isSleep = true;
                                        unlock.wait();
                                    } else {
                                        if (!foam.getFirstStatus()) {
                                            foam.changeStatusFirstFoam();
                                            wash2.startFoam1();
                                            Thread.sleep(1500);
                                            wash2.stopFoam1();
                                            foam.changeStatusFirstFoam();
                                            foamCounter++;
                                            startWash1();
                                            if (water.getFirstStatus() && water.getSecondStatus()) {
                                                isSleep = true;
                                                unlock.wait();
                                            } else {
                                                if (!water.getFirstStatus()) {
                                                    water.changeStatusFirstWater();
                                                    wash2.startWater1();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater1();
                                                    water.changeStatusFirstWater();
                                                    startWash1();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();
                                                } else {
                                                    water.changeStatusSecondWater();
                                                    wash2.startWater2();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater2();
                                                    water.changeStatusSecondWater();
                                                    startWash3();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();
                                                }
                                            }

                                        } else {
                                            foam.changeStatusSecondFoam();
                                            wash2.startFoam2();
                                            Thread.sleep(1500);
                                            wash2.stopFoam2();
                                            foamCounter++;
                                            foam.changeStatusSecondFoam();
                                            startWash3();
                                            if (water.getFirstStatus() && water.getSecondStatus()) {
                                                isSleep = true;
                                                unlock.wait();
                                            } else {
                                                if (!water.getFirstStatus()) {
                                                    water.changeStatusFirstWater();
                                                    wash2.startWater1();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater1();
                                                    water.changeStatusFirstWater();
                                                    startWash1();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();
                                                } else {
                                                    water.changeStatusSecondWater();
                                                    wash2.startWater2();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater2();
                                                    water.changeStatusSecondWater();
                                                    startWash3();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();
                                                }
                                            }

                                        }
                                    }
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                water.changeStatusSecondWater();
                                wash2.startWater2();
                                try {
                                    Thread.sleep(1500);
                                    wash2.stopWater2();
                                    water.changeStatusSecondWater();
                                    waterCounter++;
                                    if(tryLeave()){
                                        continue;
                                    }
                                    startWash3();
                                    if (foam.getFirstStatus() && foam.getSecondStatus()) {
                                        isSleep = true;
                                        unlock.wait();
                                    } else {
                                        if (!foam.getFirstStatus()) {
                                            foam.changeStatusFirstFoam();
                                            wash2.startFoam1();
                                            Thread.sleep(1500);
                                            wash2.stopFoam1();
                                            foamCounter++;
                                            foam.changeStatusFirstFoam();
                                            startWash1();
                                            if (water.getFirstStatus() && water.getSecondStatus()) {
                                                isSleep = true;
                                                unlock.wait();
                                            } else {
                                                if (!water.getFirstStatus()) {
                                                    wash2.startWater1();
                                                    water.changeStatusFirstWater();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater1();
                                                    water.changeStatusFirstWater();
                                                    startWash1();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();

                                                } else {
                                                    wash2.startWater2();
                                                    water.changeStatusSecondWater();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater2();
                                                    water.changeStatusSecondWater();
                                                    startWash3();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();

                                                }
                                            }

                                        } else {
                                            wash2.startFoam2();
                                            foam.changeStatusSecondFoam();
                                            Thread.sleep(1500);
                                            wash2.stopFoam2();
                                            foamCounter++;
                                            foam.changeStatusSecondFoam();
                                            startWash3();
                                            if (water.getFirstStatus() && water.getSecondStatus()) {
                                                isSleep = true;
                                                unlock.wait();
                                            } else {
                                                if (!water.getFirstStatus()) {
                                                    water.changeStatusFirstWater();
                                                    wash2.startWater1();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater1();
                                                    water.changeStatusFirstWater();
                                                    startWash1();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();
                                                } else {
                                                    wash2.startWater2();
                                                    water.changeStatusSecondWater();
                                                    Thread.sleep(1500);
                                                    wash2.stopWater2();
                                                    water.changeStatusSecondWater();
                                                    startWash3();
                                                    wash2.leaveCar();
                                                    restetCounter();
                                                    car.changeQueueStan();
                                                }
                                            }

                                        }
                                    }
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }


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
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void startWash1(){
        if(Wash1Procces.isSleep){
        synchronized (startWash1) {
            Wash1Procces.isSleep = false;
            startWash1.notify();
        }

        }
    }

    private void startWash3(){
        if(Wash3Procces.isSleep){
        synchronized (startWash3) {
            Wash3Procces.isSleep = false;
            startWash3.notify();
        }

        }
    }

    public boolean tryLeave(){
        if(waterCounter == 2 && foamCounter ==1){
            waterCounter = 0;
            foamCounter = 0;
            wash2.leaveCar();
            car.changeQueueStan();
            return true;

        }
        else {
            return false;
        }
    }
    private void restetCounter(){
        waterCounter = 0;
        foamCounter = 0;
    }
}
