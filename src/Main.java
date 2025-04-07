import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.Random;

public class Main {

    public static int generateRandomNumber(int min, int max){
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }


    public static void main(String[] args) {

        Character warrior1 = new Warrior("Warrior 1", generateRandomNumber(100, 200), generateRandomNumber(10, 50), generateRandomNumber(1, 10));

        Character wizzard1 = new Wizard("Wizzard 1", generateRandomNumber(50, 100), generateRandomNumber(10, 50), generateRandomNumber(1, 50));

        
    }
}