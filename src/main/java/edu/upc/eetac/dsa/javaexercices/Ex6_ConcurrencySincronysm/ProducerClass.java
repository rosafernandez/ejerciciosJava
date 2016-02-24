package edu.upc.eetac.dsa.javaexercices.Ex6_ConcurrencySincronysm;

/**
 * Created by Marti on 25/01/2016.
 */
public class ProducerClass implements Runnable {

    private BufferClass buffer = null;
    private String line = null;

    public ProducerClass(BufferClass buffer, String line) {
        this.buffer = buffer;
        this.line = line;
    }

    @Override
    public void run() {
        char chars[] = line.toCharArray();
        for(char c : chars) {
            //System.out.println(Thread.currentThread().getName() + " writes " + c);
            buffer.put(c);
        }
    }
}
