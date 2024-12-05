
class customer {
    int amount = 0;
    int flag = 0;

    public synchronized int withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " goiing to deposit");
        if (flag == 0) {
            try {
                System.out.println("Insufficient balance waiting for deposit");
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        this.amount -= amount;
        System.out.println("Withdraw completed by " + Thread.currentThread().getName());
        return amount;
    }

    public synchronized int deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is going to deposit");
        this.amount += amount;
        System.out.println("amount deposited by" + Thread.currentThread().getName());
        notifyAll();
        flag = 1;
        return amount;

    }

}

public class synchordemo {

    public static void main(String[] args) {
        customer c = new customer();
        Thread t1 = new Thread() {
            public void run() {
                c.withdraw(5000);
                System.out.println("After withdraw amount is " + c.amount);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                c.deposit(9000);
                System.out.println("After deposit amount is " + c.amount);
            }
        };
        t1.setName("dinesh");
        t2.setName("sweety");

        t1.start();
        t2.start();
    }
}