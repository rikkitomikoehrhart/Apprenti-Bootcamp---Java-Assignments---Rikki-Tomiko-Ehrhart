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
        return "By the power vested in me by the Gods... you're going to meet them.";
    }
}
