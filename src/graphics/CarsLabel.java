package graphics;

import cars.AllCars;
import cars.Car;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CarsLabel {

    JLabel cars = new JLabel();
    List<Car> carsLis = new ArrayList<>();

    JPanel panel;

    public CarsLabel(AllCars allCars, JPanel panel){

        this.panel = panel;

        carsLis = allCars.getCars();

        cars.setName("Pojazdy");


        StringBuilder carsText = new StringBuilder("<html>Pojazdy:<br>");

        for(Car car : carsLis){
            if(car.getInQueue() == false) {
                carsText.append(car.getName()).append("<br>");
            }
        }
        carsText.append("<html>");

        cars.setText(carsText.toString());

        cars.setBounds(10,-115,50,400);

        panel.add(cars);
        panel.revalidate();
        panel.repaint();
    }


    public void updateLabel(){
        StringBuilder carsText = new StringBuilder("<html>Pojazdy:<br>");

        for(Car car : carsLis){
            if(car.getInQueue() == false) {
                carsText.append(car.getName()).append("<br>");
            }
        }
        carsText.append("</html>");

        cars.setText(carsText.toString());

        panel.add(cars);
        panel.revalidate();
        panel.repaint();


    }

}
