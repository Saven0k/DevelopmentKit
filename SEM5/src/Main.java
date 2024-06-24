import java.util.TreeMap;

/**
 *
 1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
 2. Вилки лежат на столе между каждой парой ближайших философов.
 3. Каждый философ может либо есть, либо размышлять.
 4. Философ может есть только тогда, когда держит две вилки взятую справа и слева.
 5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
 6. Можно брать только две вилки одновременно
 7. На столе 5 вилок. Между двумя философами лежит 1.
 Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
  */
public class Main {
    public static void main(String[] args) {
        // Создаем колличество обедов у философов.
        int countEating = 0;

        // Создаем список философов за столом.
        Philosopher[] philosophers = new Philosopher[5];

        // Создаем список вилок на столе
        Object[] forks = new Object[philosophers.length];

        // Заполняем вилки.
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        // Создание философов и к ним вилок.
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {

                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(rightFork, leftFork, countEating);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork, countEating);
            }

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }

    }
}