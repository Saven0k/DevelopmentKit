public class Philosopher implements  Runnable{

    // Инициализируем правую и левую вилку от философа.
    private Object leftFork;
    private Object rightFork;
    private int countEating;

    // Конструктор
    public Philosopher(Object leftFork, Object rightFork, int countEating) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.countEating = countEating;
    }

    // Метод создающий небольной перерыв между действиями. С выводом действия.
    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    //Метод который блокирует вилки.
    @Override
    public void run() {
        try {
            while (countEating <= 3) {
                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(
                            System.nanoTime()
                                    + ": Picked up left fork");
                    synchronized (rightFork) {
                        doAction(
                                System.nanoTime()
                                        + ": Picked up right fork - eating");

                        doAction(
                                System.nanoTime()
                                        + ": Put down right fork");
                    }
                    doAction(
                            System.nanoTime()
                                    + ": Put down left fork. Back to thinking");
                    System.out.println(Thread.currentThread().getName() + " Philosopher eating: "  + countEating);
                }
                countEating++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
