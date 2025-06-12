// Fitness Tracker
//
// 📝 Prompt:
//      In your fitness tracker, you want to represent
//      exercises: Squats, Jumping Jacks, and Planks.
//      Each exercise must:
//              👉 Start the exercise
//	            👉 Show how many calories it burns
//	            👉 End the exercise
//
// 🎯 Goal:
//      Interface: Exercise. Implement 2–3 classes.
//      Print out a fake “workout session” using a
//      list of Exercises.


public class Main {
    public static void main(String[] args) {
        Tracker[] workouts = new Tracker[] {
                new Running(),
                new Swimming(),
                new Dance(),
        };

        for (Tracker tracker : workouts) {
            System.out.println("==========================");
            System.out.println("Workout: " + tracker.getClass().getName());
            tracker.startExercise();
            tracker.endExercise();

            System.out.println("\tCalories burned: " + tracker.caloriesBurned());
            System.out.println("==========================\n");
        }
    }
}