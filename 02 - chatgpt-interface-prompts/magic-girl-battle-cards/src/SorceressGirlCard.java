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
