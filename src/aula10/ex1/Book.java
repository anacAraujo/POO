package aula10.ex1;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d",
                this.title,
                this.author,
                this.year);
    }
}
