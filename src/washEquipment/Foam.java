package washEquipment;

public class Foam {
    boolean isFirstBusy = false; // Działa dla stanowiska 1 i 2
    boolean isSecondBusy = false; // Działa dla stanowiska 2 i 3

    public void changeStatusFirstFoam(){
        if(isFirstBusy){
            isFirstBusy = false;
        }
        else {
            isFirstBusy = true;
        }
    }

    public void changeStatusSecondFoam(){
        if(isSecondBusy){
            isSecondBusy = false;
        }
        else {
            isSecondBusy = true;
        }
    }

    public boolean getFirstStatus(){
        return isFirstBusy;
    }
    public boolean getSecondStatus(){
        return isSecondBusy;
    }

}
