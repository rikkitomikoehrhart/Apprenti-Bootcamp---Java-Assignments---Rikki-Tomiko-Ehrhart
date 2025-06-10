public class Mage extends Character{
    private String spell;

    public Mage(String spell, String name, int health, int attackPower) {
        super(name, health, attackPower);
        this.spell = spell;
    }


    @Override
    public void attack() {
        super.attack();
        System.out.println("ZAAAAAPPPPP");
    }
}
