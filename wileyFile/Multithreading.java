import java.util.Scanner;

class MyThread1 extends Thread {
    @Override
    public void run() {

        // System.out.println("MyThread1 run() function");

        // Scanner sc = new Scanner(System.in);
        // int x = sc.nextInt(); // Blocking I/O operation

        for (int i = 0; i < 100000; i++) {
            System.out.println("MyThread1 run() function");
        }
    }
}

class MyThread2 implements Runnable {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("MyThread run() function");
        }
    }
}

public class Multithreading {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1(); // Newborn state
        t1.start(); // Ready state

        // Scanner sc = new Scanner(System.in);
        // int x = sc.nextInt(); // Blocking I/O operation

        MyThread2 t = new MyThread2();
        Thread t2 = new Thread(t); // Newborn state
        t2.start(); // Ready state

        // try {
        // Thread.sleep(10);
        // t1.join();
        // t2.join(1000);
        // } catch (InterruptedException e) {
        // System.out.println(e);
        // }

        System.out.println("main function"); // Blocking I/O operation
    }
}
