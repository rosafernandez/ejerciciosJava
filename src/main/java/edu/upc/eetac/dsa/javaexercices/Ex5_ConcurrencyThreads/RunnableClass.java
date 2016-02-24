package edu.upc.eetac.dsa.javaexercices.Ex5_ConcurrencyThreads;

/**
 * Created by Marti on 25/01/2016.
 */
public class RunnableClass implements Runnable {

    public void run() {
        long lastTime = 0;
        for (int i = 0; i < 10; i++) {
            long currentTime = System.currentTimeMillis();
            long intervalTime = (i == 0) ? 0 : currentTime - lastTime;
            System.out.println("Name: " + Thread.currentThread().getName() + " - Interval Time: " + intervalTime + " - Num: " + (i+1) + "\n");
            lastTime = currentTime;
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
