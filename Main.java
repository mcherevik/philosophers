package philosophers;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(2);
        Table table = new Table();
        Thread[] philosophers = new Thread[5];
        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Thread(new CountThread(table, sem, "Philosopher " + (i + 1)));
        }


            for (Thread t : philosophers) {
                t.start();
            }
            for (Thread t : philosophers) {
                t.join();
            }



    }
}
