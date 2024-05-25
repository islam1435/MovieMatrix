public class Movie {
    private String name;
    private int releaseYear;
    private double rating;
    private String review;

    public Movie(String name, int releaseYear, double rating, String review) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}
