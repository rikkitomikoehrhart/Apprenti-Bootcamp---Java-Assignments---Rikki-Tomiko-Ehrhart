import java.util.Random;

public class WitchGirlCard implements MagicalGirlCard {
    private String name;
    private int attackPower;
    private int defensePower;
    private int health;

    public WitchGirlCard(String name, Random random) {
        this.name = name;
        attackPower = random.nextInt(5) + 1;
        defensePower = random.nextInt(5) + 1;
        health = random.nextInt(100) + 50;
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
        return "Double, double, pain and your in trouble!";
    }
}
