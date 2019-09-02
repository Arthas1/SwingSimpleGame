package Citadel2;

import java.awt.Component;

public class Step implements Runnable{
    private final Component c;

    public Step(Component c)
    {
        this.c = c;
        (new Thread(this, "F")).start();
    }
    public void run()
    {
        while (true) {
            c.repaint();
            try {
                Thread.sleep(35);
            }
            catch (Exception e) {
                System.out.println("Wyjątek!");
            }
        }
    }
}