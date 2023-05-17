package aula12.ex3;

public class Movie {
    private String name;
    private String score;
    private String rating;
    private String genre;
    private String time;

    public Movie(String name, String score, String rating, String genre, String time) {
        this.name = name;
        this.score = score;
        this.rating = rating;
        this.genre = genre;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s: score %s, rating %s, genre %s, time %s;",
                this.name,
                this.score,
                this.rating,
                this.genre,
                this.time);
    }

}
