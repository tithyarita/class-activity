public class Bank implements Runnable {

    static int balance = 0;
    // static Lock lock = new ReentrantLock();  // (Python lock equivalent)

    public void deposit() {
        // try { Thread.sleep(1000); } catch (InterruptedException e) {}
        balance += 100;
    }

    public void withdraw() {
        balance -= 100;
    }

    public int getValue() {
        return balance;
    }

    @Override
    public void run() {
        // synchronized (Bank.class) {   // lock equivalent
        deposit();
        System.out.println(
            "Value for Thread after deposit "
            + Thread.currentThread().getName() + " " + getValue()
        );

        withdraw();
        System.out.println(
            "Value for Thread after withdraw "
            + Thread.currentThread().getName() + " " + getValue()
        );
        // }
    }
}