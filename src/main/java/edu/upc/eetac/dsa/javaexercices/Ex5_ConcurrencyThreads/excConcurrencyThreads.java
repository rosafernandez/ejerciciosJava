package edu.upc.eetac.dsa.javaexercices.Ex5_ConcurrencyThreads;

/**
 * Created by Marti on 25/01/2016.
 */
public class excConcurrencyThreads {

    public static void Run() {
        ThreadClass thre = new ThreadClass("With Thread");
        Thread runn = new Thread(new RunnableClass(), "With Runnable");
        runn.start();
        thre.start();

        try {
            thre.join();
            runn.join();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Se acabó");
    }
}
