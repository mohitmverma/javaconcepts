package threads.evenOdd;

public class EvenOdd {

    int counter=1;
    public static void main(String[] args) {

        EvenOdd obj = new EvenOdd();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEvenNumber();
            }
        });

        Thread t2 = new Thread(obj::printOddNumber);

        t1.start();
        t2.start();
    }

    public void printEvenNumber() {
        synchronized (this) {
            while (counter < 10) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }
    public void printOddNumber() {
        synchronized (this) {
            while (counter < 10) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }
}
