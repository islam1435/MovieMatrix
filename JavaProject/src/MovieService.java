import java.util.List;
import java.util.ArrayList;

public class MovieService {
    public void addMovie(String name, int releaseYear, double rating, String review) {
        Movie movie = new Movie(name, releaseYear, rating, review);
        DataStorage.movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return DataStorage.movies;
    }

    public List<Movie> searchMovies(String name) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : DataStorage.movies) {
            if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    public void addDirector(String name, String biography) {
        Director director = new Director(name, biography);
        DataStorage.directors.add(director);
    }

    public List<Director> getAllDirectors() {
        return DataStorage.directors;
    }

    public List<Director> searchDirectors(String name) {
        List<Director> result = new ArrayList<>();
        for (Director director : DataStorage.directors) {
            if (director.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(director);
            }
        }
        return result;
    }

    public void addActor(String name, String biography) {
        Actor actor = new Actor(name, biography);
        DataStorage.actors.add(actor);
    }

    public List<Actor> getAllActors() {
        return DataStorage.actors;
    }

    public List<Actor> searchActors(String name) {
        List<Actor> result = new ArrayList<>();
        for (Actor actor : DataStorage.actors) {
            if (actor.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(actor);
            }
        }
        return result;
    }
}
