package graphics;

import cars.Car;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QueueLabel {

    JLabel queue = new JLabel();
    List<Car> queue1;
    List<Car> queue2;
    public QueueLabel(List<Car> queue1, List<Car> queue2, JPanel panel) {

        this.queue1 = queue1;
        this.queue2 = queue2;

        queue.setName("Kolejka");
        StringBuilder text = new StringBuilder("<html> Kolejka<br>");

        Collections.reverse(queue1);
        Collections.reverse(queue2);
        for (Car car : queue1) {
            text.append(car.getName()).append(", ");
        }
        text.append("<br>");
        text.append("<br>");

        for (Car car : queue2) {
            text.append(car.getName()).append(", ");
        }

        text.append("<html>");

        queue.setText(text.toString());
        queue.setBounds(80,-170,50,400);

        panel.add(queue);
        panel.revalidate();
        panel.repaint();

        Collections.reverse(queue1);
        Collections.reverse(queue2);

    }

    public void uptadeQueue(){
        StringBuilder text = new StringBuilder("<html> Kolejka<br>");

        Collections.reverse(queue1);
        Collections.reverse(queue2);

        for (Car car : queue1) {
            text.append(car.getName()).append(", ");
        }
        text.append("<br>");
        text.append("<br>");

        for (Car car : queue2) {
            text.append(car.getName()).append(", ");
        }

        text.append("<html>");

        queue.setText(text.toString());

        Collections.reverse(queue1);
        Collections.reverse(queue2);

        queue.revalidate();
        queue.repaint();
    }

}
