package Products;

public class Book  extends Readable {

    private String format;
    private int page;


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Book(int id, String name, int cost, int count, String feature, String typeCover, String language, String publisher, String format, int page) {
        super(id, name, cost, count, feature, typeCover, language, publisher);
        this.format = format;
        this.page = page;
    }

    public Book(String typeCover, String language, String publisher, String format, int page) {
        super(typeCover, language, publisher);
        this.format = format;
        this.page = page;
    }

    public Book(String format, int page) {
        this.format = format;
        this.page = page;
    }
}
