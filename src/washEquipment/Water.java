package washEquipment;

public class Water {

    public boolean isFirstBusy = false; // Stanowiskp 1 i 2
    public boolean isSecondBusy = false; // Stanowisko 2 i 3

    public synchronized void changeStatusFirstWater(){
        if(isFirstBusy){
            isFirstBusy = false;
        }
        else {
            isFirstBusy = true;
        }
    }

    public synchronized void changeStatusSecondWater(){
        if(isSecondBusy){
            isSecondBusy = false;
        }
        else {
            isSecondBusy = true;
        }
    }

    public synchronized boolean getFirstStatus(){
        return isFirstBusy;
    }
    public synchronized boolean getSecondStatus(){
        return isSecondBusy;
    }


}
