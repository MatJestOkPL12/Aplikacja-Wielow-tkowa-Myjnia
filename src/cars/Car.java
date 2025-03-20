package cars;

public class Car {

    public Car(String name){
        this.name = name;
    }
    String name;

    boolean inQueue = false;
    private int washNumber;


public String getName(){
    return name;
}


public boolean getInQueue(){
    return inQueue;
}

public void changeQueueStan(){
    if(inQueue == false){
        inQueue = true;
    }
    else{
        inQueue = false;
    }
}

public void setWashNumber(int i){
    washNumber = i;
}


}
