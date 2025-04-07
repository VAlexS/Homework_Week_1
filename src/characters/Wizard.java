package characters;

import java.util.Random;

public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;

    public Wizard (String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public Wizard(String name, int hp) {
        super(name, hp);
        Random rand = new Random();
        this.mana = rand.nextInt(41) + 10;
        this.intelligence = rand.nextInt(50) + 1;
    }

        // getters

    public int getMana() {
        return mana;
    }
    public int getIntelligence(){
        return intelligence;
    }
        // setters

    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;

    }

    @Override
    public void attack(Character target) {
        if (this.mana >= 5) {
            int damage = this.intelligence;
            target.setHp(target.getHp() - damage);
            this.mana -= 5;
            System.out.println(this.getName() + " conjures a powerful spell and strikes " + target.getName() +
                    "dealing " + damage + " arcane damage! Remaining mana: " + this.mana);
        } else {
            System.out.println(this.getName() + " tries to channel the arcane forces, but lacks the mana to cast a spell...");
        }
    }
}
