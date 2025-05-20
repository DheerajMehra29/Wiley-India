class PrintTable {
    static synchronized void printTable(int n) {
        System.out.println("Table for " + n + ":: ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Thread1 extends Thread {
    PrintTable t;

    Thread1(PrintTable t) {
        this.t = t;
    }

    @Override
    public void run() {
        // System.out.println("Table of 5:: ");
        t.printTable(5);
    }
}

class Thread2 extends Thread {
    PrintTable t;

    Thread2(PrintTable t) {
        this.t = t;
    }

    @Override
    public void run() {
        // System.out.println("Table of 10:: ");
        t.printTable(10);
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) throws InterruptedException {
        PrintTable t = new PrintTable();
        Thread1 t1 = new Thread1(t);
        Thread2 t2 = new Thread2(t);

        long startTime = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}
