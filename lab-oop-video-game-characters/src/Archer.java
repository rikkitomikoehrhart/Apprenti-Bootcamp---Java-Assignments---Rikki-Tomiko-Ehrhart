public class Archer extends Character {
    private int arrows;

    public Archer(int arrows, String name, int health, int attackPower) {
        super(name, health, attackPower);
        this.arrows = arrows;
    }

    @Override
    public void attack() {
        super.attack();
        System.out.println("WOOOOOOOOSH");
    }
}
