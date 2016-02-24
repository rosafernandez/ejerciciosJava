package edu.upc.eetac.dsa.javaexercices.Ex6_ConcurrencySincronysm;

/**
 * Created by Marti on 25/01/2016.
 */
public class BufferClass {

    private final static int BUFFER_SIZE = 32;
    private char[] buffer;
    private int first;
    private int last;

    public BufferClass() {
        this.buffer = new char[BUFFER_SIZE];
        this.first = 0;
        this.last = 0;
    }

    public synchronized char get() {
        while(isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException ex) {}
        }
        char c = buffer[first++];
        if(first == buffer.length) {
            first = 0;
        }
        notifyAll();
        return c;
    }

    public synchronized void put(char c) {
        while(isFull()) {
            try {
                wait();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        buffer[last++] = c;
        if(last == buffer.length) {
            last = 0;
        }
        notifyAll();
    }

    private boolean isEmpty() {
        return (first == last);
    }

    private boolean isFull() {
        if(last + 1 == first) {
            return true;
        }
        else if(last == (buffer.length - 1) && first == 0) {
            return true;
        }
        return false;
    }
}
