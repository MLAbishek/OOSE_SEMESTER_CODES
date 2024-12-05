public class AlternatingNumberPrinter {
    private static final Object lock = new Object();
    private static int currentNumber = 1;
    private static final int MAX_NUMBER = 10;

    public static class OddThread extends Thread {
        @Override
        public void run() {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (lock) {
                    // Wait while the current number is even
                    while (currentNumber <= MAX_NUMBER && currentNumber % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // Print odd numbers
                    if (currentNumber <= MAX_NUMBER) {
                        System.out.println("Odd Thread: " + currentNumber);
                        currentNumber++;
                        lock.notify();
                    }
                }
            }
        }
    }

    public static class EvenThread extends Thread {
        @Override
        public void run() {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (lock) {
                    // Wait while the current number is odd
                    while (currentNumber <= MAX_NUMBER && currentNumber % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // Print even numbers
                    if (currentNumber <= MAX_NUMBER) {
                        System.out.println("Even Thread: " + currentNumber);
                        currentNumber++;
                        lock.notify();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}