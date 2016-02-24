package edu.upc.eetac.dsa.javaexercices.Ex5_ConcurrencyThreads;

import java.util.Random;

/**
 * Created by Marti on 25/01/2016.
 */
public class ThreadClass extends Thread {

    public ThreadClass(String name) {
        super(name);
    }

    public void run() {
        long lastTime = 0;
        for (int i = 0; i < 10; i++) {
            long currentTime = System.currentTimeMillis();
            long intervalTime = (lastTime == 0) ? 0 : currentTime - lastTime;
            lastTime = currentTime;
            System.out.println("Name: " + getName() + " - Interval Time: " + intervalTime +" - Num: " + (i+1) + "\n");
            long sleepTime = (long) (Math.random() * 2000);
            try {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
