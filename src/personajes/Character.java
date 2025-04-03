package personajes;

public abstract class Character {

    private String id, name; //el id ha de generarse aleatoriamente

    private int hp; // random between 100-200 to warriors and 50-100 for wizards, representing the health points

    private boolean isAlive = true;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }


}
