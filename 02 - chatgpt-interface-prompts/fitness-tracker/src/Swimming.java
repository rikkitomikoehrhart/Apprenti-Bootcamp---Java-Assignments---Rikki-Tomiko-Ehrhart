public class Swimming implements Tracker {
    private int laps;
    private int caloriesPerLap;


    public Swimming() {
        this.laps = 0;
        this.caloriesPerLap = 15;
    }


    @Override
    public void startExercise() {
        this.laps = 0;
    }

    @Override
    public int caloriesBurned() {
        return caloriesPerLap * laps;
    }

    @Override
    public void endExercise() {
        this.laps = 25;
    }
}
