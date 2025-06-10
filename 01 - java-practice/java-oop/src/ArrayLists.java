import java.util.*;

public class ArrayLists {
    public static void main(String[] args) {
        // diamond operator
        ArrayList<String> colors = new ArrayList<>();

        colors.add("red");
        colors.add("green");
        colors.add("blue");

        colors.remove(1);

        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }

        listExample();
    }

    public static void listExample() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Star Wars", 1977));
        movies.add(new Movie("Shawshank Redemption", 1990));


        // syntactic sugar
        List<Movie> oldMovies = movies.stream()
                .filter(m -> m.getReleaseYear() < 1985)
                .toList();

        // sort movies by comparing      the getter for title
        movies.sort(Comparator.comparing(Movie::getTitle));


        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i).getTitle());
        }
    }
}
