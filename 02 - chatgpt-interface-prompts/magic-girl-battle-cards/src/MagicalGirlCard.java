import java.util.Random;

public interface MagicalGirlCard {
    int getHealth();
    int attackMove();
    int defenseMove();
    String getMagicalGirlName();
    String getQuip();
    void setHealth(int attackMinusDefense);
    int processAttack(Random random);
    int processDefense(Random random);
}
