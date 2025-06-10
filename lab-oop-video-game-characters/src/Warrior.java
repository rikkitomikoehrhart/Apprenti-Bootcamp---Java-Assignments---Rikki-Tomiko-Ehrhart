public class Warrior extends Character {
    private String weaponType;

    public Warrior(String weaponType, String name, int health, int attackPower) {
        super(name, health, attackPower);
        this.weaponType = weaponType;
    }

    @Override
    public void attack(){
        super.attack();
        System.out.println("RAAAAAAAA");
    }
}
