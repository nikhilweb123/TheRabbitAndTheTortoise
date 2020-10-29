package thread.rabbit;

import javax.swing.*;
import java.sql.Time;
import java.util.Date;

public class Rabbit implements Runnable {

    private static final int MILESTONES = 5;

    private final Thread rabbit;

    public Rabbit() {
        this.rabbit = new Thread(this, "Rabbit");
    }

    public Thread getRabbit() {
        return rabbit;
    }

    @Override
    public void run() {
        label:
        for (int index = 0; index < MILESTONES; index++) {
            switch (index) {
                case 0 -> System.out.println("The Rabbit has started from the start line!");
                case 1 -> System.out.println("The Rabbit has reached the Cool River!");
                case 2 -> System.out.println("The Rabbit has reached the Mountain Hill!");
                case 3 -> {
                    System.out.println("The Rabbit has reached the Big Oak Tree!");
                    System.out.println("The Rabbit is leading and hence is going to sleep!");
                    try {
                        Thread.sleep(9000L);
                    } catch (InterruptedException e) {
                        System.err.println("The Rabbit's sleep got interrupted!");
                    }
                }
                case 4 -> {
                    System.out.println("The Rabbit has reached the finish line!");
                    break label;
                }
            }
            try {
                Thread.sleep(1500L);
            } catch (InterruptedException e) {
                System.err.println("The rabbit has lost the path!");
            }
        }

        Date date = new Date();
        Time time = new Time(date.getTime());
        System.out.println("Rabbit has finished race at: " + time);
        JOptionPane.showConfirmDialog(
                null,
                "The Rabbit has completed the race!",
                "Rabbit",
                JOptionPane.OK_CANCEL_OPTION
        );
    }
}