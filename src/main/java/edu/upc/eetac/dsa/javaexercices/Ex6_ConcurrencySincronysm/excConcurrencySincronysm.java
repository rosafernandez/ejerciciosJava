package edu.upc.eetac.dsa.javaexercices.Ex6_ConcurrencySincronysm;

/**
 * Created by Marti on 25/01/2016.
 */
public class excConcurrencySincronysm {

    public static void Run() {
        String line = "Sing in me, Muse, and through me tell the story of that man " +
                "skilled in all ways of contending, the wanderer, harried for years on end, " +
                "after he plundered the stronghold on the proud height of Troy. \n";
        BufferClass bc = new BufferClass();
        Thread producer = new Thread(new ProducerClass(bc, line), "producer");
        Thread consumer = new Thread(new ConsumerClass(bc), "consumer");

        consumer.start();
        producer.start();
    }
}
