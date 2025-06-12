public class Running implements Tracker {
    private int mph;
    private int caloriesPerMile;
    private int miles;

    public Running (int mph) {
        this.mph = mph;

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
