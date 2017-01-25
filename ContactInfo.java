package library;


public class ContactInfo {

    private String line1, line2, line3, county, postcode;
    private String phone1;

    public ContactInfo(String line1, String line2, String line3, String county,
                       String postcode, String phone1) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.county = county;
        this.postcode = postcode;
        this.phone1 = phone1;
    }

    @Override
    public String toString() {
        return(String.format("Phone: %s\nLine 1: %s\nLine 2: %s\nLine 3: %s\n" +
                "County: %s\nPostcode: %s", phone1, line1, line2, line3, county, postcode));
    }
}