import java.util.Random;

public interface MagicalGirlCard {
    int attackMove(Random random);
    int defenseMove(Random random);
    String getMagicalGirlName();
    String getQuip();
}
