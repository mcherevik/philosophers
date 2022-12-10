package philosophers;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable{
    Table table;
    Semaphore sem;
    String name;

    CountThread(Table table, Semaphore sem, String name) {
        this.table = table;
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
            while (!table.isEmpty()) {
                try {
                    sem.acquire();
                    System.out.println(name + " sits down at the table");
                    table.food -= 5;
                    System.out.println(name + " eats 5 spoons of soup");
                    System.out.println("Spoons of soup left: " + table.food);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(name + " gets out of the table");
                sem.release();
            }
    }
}
