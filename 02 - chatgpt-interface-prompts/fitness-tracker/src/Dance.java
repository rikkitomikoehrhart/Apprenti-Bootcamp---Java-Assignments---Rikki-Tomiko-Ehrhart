public class Dance implements Tracker {
    private int caloriesPerSong;
    private int numberOfSongs;



    @Override
    public void startExercise() {
        numberOfSongs = 0;
        caloriesPerSong = 35;
    }

    @Override
    public int caloriesBurned() {
        return numberOfSongs * caloriesPerSong;
    }

    @Override
    public void endExercise() {
        numberOfSongs = 5;
    }
}
