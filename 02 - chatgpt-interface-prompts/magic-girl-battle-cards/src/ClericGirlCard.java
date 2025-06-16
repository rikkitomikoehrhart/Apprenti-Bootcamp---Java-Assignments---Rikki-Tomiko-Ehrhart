import java.util.Random;

public class ClericGirlCard implements MagicalGirlCard {
    private String name;
    private int attackPower;
    private int defensePower;
    private int health;

    public ClericGirlCard(String name, Random random) {
        this.name = name;
        attackPower = random.nextInt(3) + 1;
        defensePower = random.nextInt(7) + 1;
        health = random.nextInt(80) + 70;
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
        return "By the power vested in me by the Gods... you're going to meet them.";
    }
}
