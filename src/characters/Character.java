package characters;

import java.util.Random;

public abstract class Character {

    private String id, name; //el id ha de generarse aleatoriamente

    private int hp; // random between 100-200 to warriors and 50-100 for wizards, representing the health points

    private boolean isAlive = true;

    public Character(String name, int hp) {

        //genero un string aleatorio
        id = generateRandomString();

        this.name = name;
        this.hp = hp;
    }

    private String generateRandomString(){
        int longitud = 4; // Longitud del String aleatorio
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringAleatorio = new StringBuilder();
        var random = new Random();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            stringAleatorio.append(caracteres.charAt(index));
        }

        return stringAleatorio.toString();

    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
