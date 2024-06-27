package MontyHoll;

import java.util.Random;

public class Main {
    private static Random random = new Random();
    public static void main(String[] args) {
        MontyHoll montyHoll = new MontyHoll();
        //Human select door( first)
        int selectDoor = random.nextInt(3) + 1;

        //Open random goat
        montyHoll.goatOpen();

        // Ask to change door
        boolean switchDoor = random.nextBoolean();

        //Open the car
        montyHoll.carOpen();

        //Check win
        boolean win = montyHoll.numberDoorIsCar(switchDoor ? 3 - selectDoor: selectDoor);

        //Выводим на экран результат

        System.out.println("Gamer win: " + win);
    }
}