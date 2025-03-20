package cars;

import graphics.Choice;
import graphics.WrongChoiceLabel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AllCars {

    public AllCars(Choice choice, JPanel panel){
        this.choice = choice;
        this.panel = panel;
    }
    Choice choice;
    JPanel panel;
    String [] possiblyCarName = {"A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K", "L", "M", "N", "O", "P","Q", "R", "S", "T", "U", "W", "V", "Y", "X", "Z"};

    List<Car> cars = new ArrayList<>();


    public int makeCars(){
        int numberOfCars = Integer.parseInt(choice.getNumberOfCars());
        if(numberOfCars > 0 && numberOfCars < 27){
            for(int i = 0; i<numberOfCars-1; i++){
                Car car = new Car(possiblyCarName[i]);
                cars.add(car);

            }
            return 1;
        }
        else{
            WrongChoiceLabel wrongChoiceLabel = new WrongChoiceLabel(panel);
        }
        return -1;
    }


    public List<Car> getCars(){
        return cars;
    }
}
