package graphics;

import javax.swing.*;

public class Wash1 extends JPanel {

    boolean isEmpty = true;

JLabel wash1v1 = new JLabel("|       |");
JLabel wash1v2 = new JLabel("|       |");

JPanel panel;

String currentCarName;
    public Wash1(JPanel panel){
        this.panel = panel;
        wash1v1.setBounds(200,10, 90, 80);
        wash1v2.setBounds(200,20, 90, 80);

        panel.add(wash1v1);
        panel.add(wash1v2);

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
    public void setCarName(String name){
        currentCarName = name;
    }
    public String getCurrentCarName(){
        return currentCarName;
    }

    public void addCar(String name){
        panel.remove(wash1v2);
        wash1v1.setText("|        |");
        wash1v2.setText("|   " +name + "   |");
        changeIsEmpty();
        panel.add(wash1v2);
        panel.revalidate();
        panel.repaint();

    }
    public void carLeaving(String name){
        panel.remove(wash1v2);
        wash1v1.setText("|       |");
        wash1v2.setText("|       |");
        changeIsEmpty();

        panel.add(wash1v2);
        panel.revalidate();
        panel.repaint();

    }

    public void waterOn(String name){
        panel.remove(wash1v2);
        wash1v1.setText("|     <|");
        wash1v2.setText("|   " +name + " |");

        panel.add(wash1v2);
        panel.revalidate();
        panel.repaint();
    }

    public void waterOff(String name){
        panel.remove(wash1v2);
        wash1v1.setText("|        |");
        wash1v2.setText("|   " +name + "   |");

        panel.add(wash1v2);
        panel.revalidate();
        panel.repaint();
    }

    public void foamOn(String name){
        panel.remove(wash1v2);
        wash1v1.setText("|      |");
        wash1v2.setText("|   " +name + "<|");

        panel.add(wash1v2);
        panel.revalidate();
        panel.repaint();
    }

    public void foamOff(String name){
        panel.remove(wash1v2);
        wash1v1.setText("|        |");
        wash1v2.setText("|   " +name + "   |");

        panel.add(wash1v2);
        panel.revalidate();
        panel.repaint();
    }

}
