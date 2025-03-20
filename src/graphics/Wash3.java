package graphics;

import javax.swing.*;

public class Wash3 {

    boolean isEmpty = true;
    String currentCarName;

    JLabel wash3v1 = new JLabel("|       |");
    JLabel wash3v2 = new JLabel("|       |");
    JPanel panel;

    public Wash3(JPanel panel){

        this.panel = panel;

        wash3v1.setBounds(250,10, 90, 80);
        wash3v2.setBounds(250,20, 90, 80);

        panel.add(wash3v1);
        panel.add(wash3v2);

        panel.revalidate();
        panel.repaint();

    }

    public void setCarName(String name){
        currentCarName = name;
    }
    public String getCurrentCarName(){
        return currentCarName;
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

    public void addCar(String name){
        panel.remove(wash3v2);
        panel.remove(wash3v1);
        changeIsEmpty();
        wash3v1.setText("|        |");
        wash3v2.setText("|   " +name + "  |");

        panel.add(wash3v2);
        panel.add(wash3v1);
        panel.revalidate();
        panel.repaint();

    }


    public void carLeaving(String name){
        panel.remove(wash3v2);
        panel.remove(wash3v1);
        wash3v1.setText("|       |");
        wash3v2.setText("|       |");
        changeIsEmpty();

        panel.add(wash3v1);
        panel.add(wash3v2);
        panel.revalidate();
        panel.repaint();

    }

    public void waterOn(String name){

        panel.remove(wash3v2);
        panel.remove(wash3v1);
        wash3v1.setText("|>     |");
        wash3v2.setText("|   " +name + " |");

        panel.add(wash3v1);
        panel.add(wash3v2);
        panel.revalidate();
        panel.repaint();
    }

    public void waterOff(String name){
        panel.remove(wash3v2);
        panel.remove(wash3v1);

        wash3v1.setText("|        |");
        wash3v2.setText("|   " +name + "   |");

        panel.add(wash3v1);
        panel.add(wash3v2);
        panel.revalidate();
        panel.repaint();
    }

    public void foamOn(String name){
        panel.remove(wash3v2);
        panel.remove(wash3v1);
        wash3v1.setText("|        |");
        wash3v2.setText("|> " +name + "  |");

        panel.add(wash3v1);
        panel.add(wash3v2);
        panel.revalidate();
        panel.repaint();
    }

    public void foamOff(String name){
        panel.remove(wash3v2);
        panel.remove(wash3v1);
        wash3v1.setText("|        |");
        wash3v2.setText("|   " +name + "  |");

        panel.add(wash3v1);
        panel.add(wash3v2);
        panel.revalidate();
        panel.repaint();
    }

}
