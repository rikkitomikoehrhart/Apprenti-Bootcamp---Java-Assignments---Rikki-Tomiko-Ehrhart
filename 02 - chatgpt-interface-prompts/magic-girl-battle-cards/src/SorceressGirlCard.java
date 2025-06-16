import java.util.Random;

public class SorceressGirlCard implements MagicalGirlCard {
    private String name;
    private int attackPower;
    private int defensePower;
    private int health;

    public SorceressGirlCard(String name, Random random) {
        this.name = name;
        attackPower = random.nextInt(6) + 1;
        defensePower = random.nextInt(4) + 1;
        health = random.nextInt(110) + 40;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int attackMinusDefense) {
        this.health -= attackMinusDefense;
    }

    @Override
    public int processAttack(Random random) {
        return (random.nextInt(3) + 1) * attackPower;
    }

    @Override
    public int processDefense(Random random) {
        return (random.nextInt(3) + 1) * defensePower;
    }

    @Override
    public int attackMove() {
        return attackPower;
    }

    @Override
    public int defenseMove() {
        return defensePower;
    }

    @Override
    public String getMagicalGirlName() {
        return name;
    }

    @Override
    public String getQuip() {
        return "Magic isn't fair. Luckily, neither am I.";
    }
}
