package graphics;

import javax.swing.*;
import java.awt.*;

public class Wash2 {
    boolean isEmpty = true;
    public String currentCarName;

    JLabel label1 = new JLabel("W      W");
    JLabel label2 = new JLabel("  P       P");
    JLabel car = new JLabel("");
    JLabel water1 = new JLabel(">");
    JLabel water2 = new JLabel("<");
    JLabel foam1 = new JLabel(">");
    JLabel foam2 = new JLabel("<");
    JPanel panel;

    public Wash2(JPanel panel){

        this.panel = panel;

        label1.setBounds(220,-10, 90, 80);
        label2.setBounds(220, 40, 90, 80);
        car.setBounds(235,20, 90, 80);
        foam1.setBounds(227,20, 90, 80);
        foam2.setBounds(243, 20, 90,80);
        water1.setBounds(227, 10, 90,80);
        water2.setBounds(243, 10, 90,80);

        label1.setFont(new Font("Arial", Font.PLAIN, 12)); // Rozmiar 20 dla W
        label2.setFont(new Font("Arial", Font.PLAIN, 12)); // Rozmiar 20 dla P



        panel.add(label1);
        panel.add(label2);
        panel.add(car);
        panel.revalidate();
        panel.repaint();



    }

    public boolean getIsEmpty(){
        return isEmpty;
    }

    public void changeIsEmpty(){

        if(isEmpty == true){
            isEmpty = false;
        }
        else{
            isEmpty = true;
        }

    }
    public void setCurrentCarName(String name){
        currentCarName = name;
    }
    public String getCurrentCarName(){
        return currentCarName;
    }
    public void addCar(String name){

        panel.remove(car);
        changeIsEmpty();
        car.setText(name);

        panel.add(car);
        panel.revalidate();
        panel.repaint();
    }

    public void startWater1(){
        panel.add(water1);
        panel.revalidate();
        panel.repaint();
    }
    public void stopWater1(){
        panel.remove(water1);
        panel.revalidate();
        panel.repaint();
    }
    public void startWater2(){
        panel.add(water2);
        panel.revalidate();
        panel.repaint();
    }
    public void stopWater2(){
        panel.remove(water2);
        panel.revalidate();
        panel.repaint();
    }
    public void startFoam1(){
        panel.add(foam1);
        panel.revalidate();
        panel.repaint();
    }
    public void stopFoam1(){
        panel.remove(foam1);
        panel.revalidate();
        panel.repaint();
    }
    public void startFoam2(){
        panel.add(foam2);
        panel.revalidate();
        panel.repaint();
    }
    public void stopFoam2(){
        panel.remove(foam2);
        panel.revalidate();
        panel.repaint();
    }
    public void leaveCar(){
        changeIsEmpty();
        panel.remove(car);
        car.setText("");

        panel.add(car);
        panel.revalidate();
        panel.repaint();
    }

}
