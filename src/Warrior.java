public class Warrior  extends Character implements Attacker{
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name,hp);
        this.stamina = stamina;
        this.strength = strength;
    }
    //Setters
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    //Getters
    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }
    public void attack(Character character) {
        if (stamina >= 5) {
            // Heavy attack
            character.setHp(character.getHp() - strength);
            stamina -= 5;
            System.out.println(getName() + " performs a heavy attack on " + character.getName() +
                    " for " + strength + " damage!");
        } else {
            // Weak attack (when not enough stamina)
            int weakDamage = strength / 2;
            character.setHp(character.getHp() - weakDamage);
            stamina += 1; // Regain some stamina
            System.out.println(getName() + " performs a weak attack on " + character.getName() +
                    " for " + weakDamage + " damage (low stamina)!");
        }
    }
}
