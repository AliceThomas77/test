package items;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Newspaper extends Item {

    private Date releaseDate;
    private String title;

    public Newspaper(int numInStock, int numRented, double price, Date releaseDate, String title) {
        super(numInStock, numRented, price);
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String itemInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        return "Newspaper: " + title + " (" + sdf.format(releaseDate) + ")";
    }
}
