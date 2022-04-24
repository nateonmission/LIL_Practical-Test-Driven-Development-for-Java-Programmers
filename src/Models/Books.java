package Models;

public class Books {
    String title;
    String author;
    String isbn_long;
    String isbn_short;

    public Books(String title, String author, String isbn_long, String isbn_short) {
        this.title = title;
        this.author = author;
        this.isbn_long = isbn_long;
        this.isbn_short = isbn_short;
    }

    public Books() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn_long() {
        return isbn_long;
    }

    public void setIsbn_long(String isbn_long) {
        this.isbn_long = isbn_long;
    }

    public String getIsbn_short() {
        return isbn_short;
    }

    public void setIsbn_short(String isbn_short) {
        this.isbn_short = isbn_short;
    }
}
