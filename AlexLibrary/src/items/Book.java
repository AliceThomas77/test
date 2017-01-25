package items;

/**
 * Created by Administrator on 20/12/2016.
 */
public class Book extends Item {

    private String title, author;
    private int numPages;

    public Book( int numInStock, int numRented, double price, String title, String author, int numPages) {
        super(numInStock, numRented, price);
        this.title = title;
        this.author = author;
        this.numPages = numPages;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    @Override
    public String itemInfo() {
        return String.format("Book: \"%s\" by %s", title, author);
    }
}
