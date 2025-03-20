package logic;

import cars.AllCars;
import cars.Car;
import graphics.Wash1;
import logic.Controler;
import logic.Wash2Procces;
import washEquipment.Foam;
import washEquipment.Water;

import java.util.List;

public class Wash1Procces {

        public static boolean isSleep = false;

        private int state =0;
        private int afterFirstWater = 1;
        private int afterFirsFoam = 2;
        private int afterSecondWater = 0;
        Wash1 wash1;
        Water water;
        Foam foam;

        Object lock;
        Object controlerLock;
        Controler controler;

        final Object wash2process;
        AllCars allCars;
        List<Car> cars;
        Car car;


        public Wash1Procces(Wash1 wash1, Water water, Foam foam, Object controlerLock, Controler controler, Object lock, Object wash2process, AllCars allCars) {
            this.wash1 = wash1;
            this.water = water;
            this.foam = foam;
            this.controlerLock = controlerLock;
            this.controler = controler;
            this.lock = lock;
            this.wash2process = wash2process;
            this.allCars = allCars;
            cars = allCars.getCars();
        }


        public void startWash1() {

            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {

                        synchronized (lock) {
                            while (true) {
                                Thread.sleep(1);
                                if (wash1.getIsEmpty()) {
                                    continue;
                                } else {
                                    if (water.getFirstStatus()) {
                                        isSleep = true;
                                        lock.wait();
                                    } else {
                                        String name = wash1.getCurrentCarName();
                                        for(int i = 0; i<cars.size(); i++){
                                            if(cars.get(i).getName().equals(name)){
                                                car = cars.get(i);
                                            }
                                        }
                                        switch (state){
                                            case (0):{
                                                water.changeStatusFirstWater();
                                                wash1.waterOn(name);
                                                lock.wait(1000);

                                                water.changeStatusFirstWater();
                                                wash1.waterOff(name);
                                                startWash2();
                                                state = afterFirstWater;
                                            } break;

                                            case (1):{

                                                if (foam.getFirstStatus()) {
                                                    isSleep = true;
                                                    lock.wait();
                                                } else {
                                                    foam.changeStatusFirstFoam();
                                                    wash1.foamOn(name);
                                                    lock.wait(1500);
                                                    wash1.foamOff(name);
                                                    foam.changeStatusFirstFoam();
                                                    startWash2();
                                                    state = afterFirsFoam;
                                                }}break;
                                            case(2):{
                                                if(water.getFirstStatus()){
                                                    isSleep = true;
                                                    lock.wait();
                                                }
                                                else {
                                                    water.changeStatusFirstWater();
                                                    wash1.waterOn(name);
                                                    lock.wait(1500);
                                                    wash1.waterOff(name);
                                                    water.changeStatusFirstWater();
                                                    lock.wait(500);
                                                    startWash2();
                                                    wash1.carLeaving(name);

                                                    car.changeQueueStan();
                                                    state = afterSecondWater;
                                                }
                                            }break;


                                        }

                                        if(controler.controlerIsSleeping) {
                                            synchronized (controlerLock) {
                                                controlerLock.notify();
                                            }


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

    public void startWash2(){
        if(Wash2Procces.isSleep){
            synchronized (wash2process) {
                Wash2Procces.isSleep = false;
                wash2process.notify();
            }

        }
    }

}



