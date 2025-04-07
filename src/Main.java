import characters.Character;
import characters.Warrior;
import characters.Wizard;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            Character character1 = null;
            Character character2 = null;
            int battleCount = 1;

            // Crear personajes
            System.out.println("Creando el Personaje 1:");
            character1 = createCharacter(scanner, random);

            System.out.println("\nCreando el Personaje 2:");
            character2 = createCharacter(scanner, random);

            System.out.println("\n¡Comienza la Batalla entre " + character1.getName() + " y " + character2.getName() + "!");

            // Lógica de la batalla
            while (character1.getHp() > 0 && character2.getHp() > 0) {
                System.out.println("\n--- Ronda #" + battleCount + " ---");
                simulateRound(character1, character2, random);
                System.out.println(character1.getName() + " HP restantes: " + character1.getHp());
                System.out.println(character2.getName() + " HP restantes: " + character2.getHp());
                battleCount++;
            }

            System.out.println("\n--- ¡La Batalla Finalizó! ---");
            if (character1.getHp() <= 0 && character2.getHp() <= 0) {
                System.out.println("¡Ambos combatientes fueron derrotados!");
            } else if (character1.getHp() <= 0) {
                System.out.println(character2.getName() + " es el ganador!");
            } else {
                System.out.println(character1.getName() + " es el ganador!");
            }

            // Preguntar si quiere jugar otra partida con nuevos personajes
            System.out.print("\n¿Quieres jugar otra partida con nuevos personajes? (s/n): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("s");

            if (!playAgain) {
                System.out.println("¡Gracias por la batalla!");
            }
        }

        scanner.close();
    }

    public static Character createCharacter(Scanner scanner, Random random) {
        System.out.print("Ingrese el nombre del personaje: ");
        String name = scanner.nextLine();

        System.out.println("Seleccione el tipo de personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.print("Ingrese el número de su elección: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume la nueva línea

        if (choice == 1) {
            int hp = 100 + random.nextInt(101); // Rango 100-200
            int stamina = 20 + random.nextInt(31); // Rango 20-50
            int strength = 10 + random.nextInt(21); // Rango 10-30
            System.out.println(name + " el Guerrero ha sido creado con " + hp + " HP, " + stamina + " de resistencia y " + strength + " de fuerza.");
            return new Warrior(name, hp, stamina, strength);
        } else if (choice == 2) {
            int hp = 50 + random.nextInt(51); // Rango 50-100
            int mana = 10 + random.nextInt(41); // Rango 10-50
            int intelligence = 5 + random.nextInt(16); // Rango 5-20
            System.out.println(name + " el Mago ha sido creado con " + hp + " HP, " + mana + " de maná e " + intelligence + " de inteligencia.");
            return new Wizard(name, hp, mana, intelligence);
        } else {
            System.out.println("¡Opción inválida! Se creará un Guerrero genérico.");
            return new Warrior("Guerrero Genérico", 150, 30, 20);
        }
    }

    public static void simulateRound(Character character1, Character character2, Random random) {
        // Ambos atacan simultáneamente
        if (character1 instanceof Warrior) {
            warriorAttack((Warrior) character1, character2, random);
        } else if (character1 instanceof Wizard) {
            wizardAttack((Wizard) character1, character2);
        }

        if (character2 instanceof Warrior) {
            warriorAttack((Warrior) character2, character1, random);
        } else if (character2 instanceof Wizard) {
            wizardAttack((Wizard) character2, character1);
        }

        // Asegurar que HP no sea negativo
        character1.setHp(Math.max(0, character1.getHp()));
        character2.setHp(Math.max(0, character2.getHp()));
    }

    public static void warriorAttack(Warrior warrior, Character target, Random random) {
        int damage = 0;
        if (warrior.getStamina() >= 5 && random.nextBoolean()) { // Ataque fuerte aleatorio
            damage = warrior.getStrength();
            warrior.setStamina(warrior.getStamina() - 5);
            System.out.println(warrior.getName() + " realiza un ataque fuerte a " + target.getName() + " causando " + damage + " de daño. Resistencia restante: " + warrior.getStamina());
        } else if (warrior.getStamina() >= 1) { // Ataque débil
            damage = warrior.getStrength() / 2;
            warrior.setStamina(warrior.getStamina() + 1);
            System.out.println(warrior.getName() + " realiza un ataque débil a " + target.getName() + " causando " + damage + " de daño. Resistencia restante: " + warrior.getStamina());
        } else { // No hay suficiente resistencia
            warrior.setStamina(warrior.getStamina() + 2);
            System.out.println(warrior.getName() + " no tiene suficiente resistencia para atacar y recupera 2 puntos. Resistencia restante: " + warrior.getStamina());
        }
        target.setHp(target.getHp() - damage);
    }

    public static void wizardAttack(Wizard wizard, Character target) {
        int damage = 0;
        if (wizard.getMana() >= 5) { // Bola de Fuego
            damage = wizard.getIntelligence();
            wizard.setMana(wizard.getMana() - 5);
            System.out.println(wizard.getName() + " lanza una Bola de Fuego a " + target.getName() + " causando " + damage + " de daño mágico. Maná restante: " + wizard.getMana());
        } else if (wizard.getMana() >= 1) { // Golpe de Bastón
            damage = 2;
            wizard.setMana(wizard.getMana() + 1);
            System.out.println(wizard.getName() + " golpea con su bastón a " + target.getName() + " causando " + damage + " de daño. Maná restante: " + wizard.getMana());
        } else { // No hay suficiente maná
            wizard.setMana(wizard.getMana() + 2);
            System.out.println(wizard.getName() + " no tiene suficiente maná para atacar y recupera 2 puntos. Maná restante: " + wizard.getMana());
        }
        target.setHp(target.getHp() - damage);
    }
}