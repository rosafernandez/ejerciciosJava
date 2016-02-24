package edu.upc.eetac.dsa.javaexercices.Ex6_ConcurrencySincronysm;

/**
 * Created by Marti on 25/01/2016.
 */
public class ConsumerClass implements Runnable{

    private BufferClass buffer = null;

    public ConsumerClass (BufferClass buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        char c;
        while((c = buffer.get()) != '\n') {
            //System.out.println(Thread.currentThread().getName() + " reads " + c);
            sb.append(c);
        }
        System.out.println(sb);
    }
}
