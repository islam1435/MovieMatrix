import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private UserService userService = new UserService();
    private MovieService movieService = new MovieService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Welcome to MovieMatrix!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleRegistration();
                    break;
                case 2:
                    if (handleLogin()) {
                        showHomePage();
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleRegistration() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        if (userService.register(username, password, email)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Username already exists. Please try again.");
        }
    }

    private boolean handleLogin() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getUsername());
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    private void showHomePage() {
        while (true) {
            System.out.println("Home Page");
            System.out.println("1. Add Movie");
            System.out.println("2. View Movies");
            System.out.println("3. Search Movie");
            System.out.println("4. Add Director");
            System.out.println("5. View Directors");
            System.out.println("6. Search Director");
            System.out.println("7. Add Actor");
            System.out.println("8. View Actors");
            System.out.println("9. Search Actor");
            System.out.println("10. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    viewMovies();
                    break;
                case 3:
                    searchMovie();
                    break;
                case 4:
                    addDirector();
                    break;
                case 5:
                    viewDirectors();
                    break;
                case 6:
                    searchDirector();
                    break;
                case 7:
                    addActor();
                    break;
                case 8:
                    viewActors();
                    break;
                case 9:
                    searchActor();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMovie() {
        System.out.println("Enter movie name:");
        String name = scanner.nextLine();
        System.out.println("Enter release year:");
        int releaseYear = scanner.nextInt();
        System.out.println("Enter rating:");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter review:");
        String review = scanner.nextLine();

        movieService.addMovie(name, releaseYear, rating, review);
        System.out.println("Movie added successfully!");
    }

    private void viewMovies() {
        List<Movie> movies = movieService.getAllMovies();
        for (Movie movie : movies) {
            System.out.println("Name: " + movie.getName());
            System.out.println("Release Year: " + movie.getReleaseYear());
            System.out.println("Rating: " + movie.getRating());
            System.out.println("Review: " + movie.getReview());
            System.out.println();
        }
    }

    private void searchMovie() {
        System.out.println("Enter movie name to search:");
        String name = scanner.nextLine();
        List<Movie> movies = movieService.searchMovies(name);
        if (movies.isEmpty()) {
            System.out.println("No movies found with the name containing: " + name);
        } else {
            for (Movie movie : movies) {
                System.out.println("Name: " + movie.getName());
                System.out.println("Release Year: " + movie.getReleaseYear());
                System.out.println("Rating: " + movie.getRating());
                System.out.println("Review: " + movie.getReview());
                System.out.println();
            }
        }
    }

    private void addDirector() {
        System.out.println("Enter director name:");
        String name = scanner.nextLine();
        System.out.println("Enter biography:");
        String biography = scanner.nextLine();

        movieService.addDirector(name, biography);
        System.out.println("Director added successfully!");
    }

    private void viewDirectors() {
        List<Director> directors = movieService.getAllDirectors();
        for (Director director : directors) {
            System.out.println("Name: " + director.getName());
            System.out.println("Biography: " + director.getBiography());
            System.out.println();
        }
    }

    private void searchDirector() {
        System.out.println("Enter director name to search:");
        String name = scanner.nextLine();
        List<Director> directors = movieService.searchDirectors(name);
        if (directors.isEmpty()) {
            System.out.println("No directors found with the name containing: " + name);
        } else {
            for (Director director : directors) {
                System.out.println("Name: " + director.getName());
                System.out.println("Biography: " + director.getBiography());
                System.out.println();
            }
        }
    }

    private void addActor() {
        System.out.println("Enter actor name:");
        String name = scanner.nextLine();
        System.out.println("Enter biography:");
        String biography = scanner.nextLine();

        movieService.addActor(name, biography);
        System.out.println("Actor added successfully!");
    }

    private void viewActors() {
        List<Actor> actors = movieService.getAllActors();
        for (Actor actor : actors) {
            System.out.println("Name: " + actor.getName());
            System.out.println("Biography: " + actor.getBiography());
            System.out.println();
        }
    }

    private void searchActor() {
        System.out.println("Enter actor name to search:");
        String name = scanner.nextLine();
        List<Actor> actors = movieService.searchActors(name);
        if (actors.isEmpty()) {
            System.out.println("No actors found with the name containing: " + name);
        } else {
            for (Actor actor : actors) {
                System.out.println("Name: " + actor.getName());
                System.out.println("Biography: " + actor.getBiography());
                System.out.println();
            }
        }
    }
}
