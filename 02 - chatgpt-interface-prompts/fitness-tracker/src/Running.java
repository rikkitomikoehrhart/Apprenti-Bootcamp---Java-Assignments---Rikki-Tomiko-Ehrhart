public class Running implements Tracker {
    private int caloriesPerMile;
    private int miles;

    public Running () {
        caloriesPerMile = 100;
        miles = 0;
    }


    @Override
    public void startExercise() {
        this.miles = 0;
    }

    @Override
    public int caloriesBurned() {
        return caloriesPerMile * miles;
    }

    @Override
    public void endExercise() {
        this.miles = 1;
    }
}
