package MontyHoll;

import java.util.Random;

public class MontyHoll {
    private static final Random RANDOM = new Random();

    private boolean goat1IsOpen;
    private boolean goat2IsOpen;
    private boolean carIsOpen;

    public MontyHoll() {
        reset();
    }

    public void reset(){
        goat1IsOpen = false;
        goat2IsOpen = false;
        carIsOpen = false;
    }

    public void goatOpen(){
        if (goat1IsOpen && goat2IsOpen){throw new IllegalStateException("Всех козлов уже открыли");}
        int goatNumber = RANDOM.nextInt(2) + 1;
        if (goatNumber == 1){goat1IsOpen = true;}
        if (goatNumber == 2){goat2IsOpen = true;}
    }

    public void carOpen(){
        if (carIsOpen){throw new IllegalStateException("Машина уже открыта");}
        carIsOpen = true;
    }

    public boolean numberDoorIsCar(int doorNumber){
        return doorNumber == 3;
    }

    public boolean chanceSwitchDoorForWin(){
        if (!carIsOpen) {
            throw new IllegalStateException("Машина еще не открыта");
        }
        return !(goat1IsOpen && goat2IsOpen);
    }
}
