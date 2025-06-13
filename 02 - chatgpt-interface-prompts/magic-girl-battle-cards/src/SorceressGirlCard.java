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

    public int getHealth() {
        return health;
    }

    public void setHealth(int attackMinusDefense) {
        this.health -= attackMinusDefense;
    }

    public int processAttack(Random random) {
        return (random.nextInt(3) + 1) * attackPower;
    }

    public int processDefense(Random random) {
        return (random.nextInt(3) + 1) * defensePower;
    }

    @Override
    public int attackMove(Random random) {
        return attackPower;
    }

    @Override
    public int defenseMove(Random random) {
        return defensePower;
    }

    @Override
    public String getMagicalGirlName() {
        return name;
    }

    @Override
    public String getQuip() {
        return "Magic isn't far. Luckily, neither am I.";
    }
}
