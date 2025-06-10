public class GameApp {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("sword", "Warrior", 100, 20);
        Mage mage = new Mage("Fireball", "Mage", 50, 20);
        Archer archer = new Archer(100, "Archer", 75, 20);

        Character[] list = new Character[]{warrior, mage, archer};

        for (Character character : list) {
            character.attack();
        }
    }
}
